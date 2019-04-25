package dk.aau.cs.d403.codegen;

import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.ast.statements.*;
import dk.aau.cs.d403.ast.structure.*;
import dk.aau.cs.d403.spook.*;
import dk.aau.cs.d403.spook.color.Color;
import dk.aau.cs.d403.spook.shapes.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CodeGenerator {

    private StringBuilder sb;
    private Scene scene;

    private HashMap<String, SpookObject> spookObjects;
    private HashSet<Enums.ClassType> usedClasses;

    public String GenerateGLSL(ProgramNode ast) {
        sb = new StringBuilder();
        scene = new Scene();
        spookObjects = new HashMap<>();
        usedClasses = new HashSet<>();

        visitProgram(ast);

        generateStructs();
        generatePrototypes();
        generateMain();
        generateFunctions();

        return sb.toString();
    }

    private void generateStructs() {
        for (Enums.ClassType type : usedClasses) {
            sb.append(getClassCode(type, "getStruct"));
            sb.append("\n");
        }

        sb.append("\n");
    }

    private void generatePrototypes() {
        for (Enums.ClassType type : usedClasses) {
            sb.append(getClassCode(type, "getCheckFunctionSignature"));
            sb.append(";\n");
        }

        sb.append("\n");
    }

    private void generateFunctions() {
        for (Enums.ClassType type : usedClasses) {
            sb.append(getClassCode(type, "getCheckFunctionSignature"));
            sb.append("{\n\t");
            sb.append(getClassCode(type, "getCheckFunctionBody"));
            sb.append("\n");
        }

        sb.append("}");
    }

    private void generateMain() {
        sb.append("void mainImage( out vec4 fragColor, in vec2 fragCoord ) {\n");

        for (SpookObject object : scene.getChildren()) {
            sb.append("\t");
            sb.append(object.getDeclaration());
            sb.append("\n\n");
        }

        for (SpookObject object : scene.getChildren()) {
            sb.append("\t");
            sb.append(((Shape)object).getCheckCall());
            sb.append("\n\n");
        }

        sb.append("\tfragColor = vec4");
        sb.append(PrintGLSL.printVector4(scene.getColor()));
        sb.append(";\n");

        sb.append("}\n\n");
    }

    private void visitProgram(ProgramNode programNode) {
        visitMain(programNode.getMainNode());
    }

    private void visitMain(MainNode mainNode) {
        visitBlock(mainNode.getBlockNode());
    }

    private void visitBlock(BlockNode blockNode) {
        for (StatementNode statement : blockNode.getStatementNodes())
            visitStatement(statement);
    }

    private void visitStatement(StatementNode statementNode) {
        if (statementNode instanceof AssignmentNode)
            return; //TODO: visitAssignment((AssignmentNode)statementNode);
        else if (statementNode instanceof DeclarationNode)
            visitDeclaration((DeclarationNode)statementNode);
        else if (statementNode instanceof IfElseStatementNode)
            return; //TODO: visitIfElseStatement((IfElseStatementNode)statementNode);
        else if (statementNode instanceof ObjectFunctionCallNode)
            visitObjectFunctionCall((ObjectFunctionCallNode)statementNode);
        else if (statementNode instanceof ReturnNode)
            return; //TODO: visitReturn((ReturnNode)statementNode);
        else {
            System.out.println(statementNode.prettyPrint());
            throw new RuntimeException("Statement is of unknown type");
        }
    }

    private void visitDeclaration(DeclarationNode declarationNode) {
        if (declarationNode instanceof VariableDeclarationNode)
            return; //TODO: visitVariableDeclaration((VariableDeclarationNode)declarationNode);
        else if (declarationNode instanceof ObjectDeclarationNode)
            visitObjectDeclaration((ObjectDeclarationNode)declarationNode);
        else
            throw new RuntimeException("Declaration is of unknown type");
    }

    private void visitObjectDeclaration(ObjectDeclarationNode objectDeclarationNode) {
        ArrayList<ObjectArgumentNode> argumentNodes = objectDeclarationNode.getObjectArgumentNodes();

        Enums.ClassType objectType = objectDeclarationNode.getObjectType();
        usedClasses.add(objectType);

        SpookObject object;

        switch (objectType) {
            case CIRCLE:
                object = new Circle(objectDeclarationNode.getVariableName(), argumentNodes);
                break;
            case RECTANGLE:
                object = new Rectangle(objectDeclarationNode.getVariableName(), argumentNodes);
                break;
            case SQUARE:
                object = new Square(objectDeclarationNode.getVariableName(), argumentNodes);
                break;
            case TRIANGLE:
                object = new Triangle(objectDeclarationNode.getVariableName(), argumentNodes);
                break;
            default:
                throw new RuntimeException("Invalid object declaration");
        }

        spookObjects.put(objectDeclarationNode.getVariableName(), object);
    }

    private void visitObjectFunctionCall(ObjectFunctionCallNode objectFunctionCallNode) {
        if (objectFunctionCallNode.getObjectVariableName().equals("Scene")) {
            switch (objectFunctionCallNode.getFunctionName()) {
                case "add":
                    String objectName = objectFunctionCallNode.getObjectArguments().get(0).getVariableName();
                    SpookObject object = spookObjects.get(objectName);
                    if (object != null)
                        scene.add(object);
                    break;
                case "color":
                    scene.setColor(Color.getColorProperty(objectFunctionCallNode.getObjectArguments().get(0).getClassPropertyNode()));
                    break;
                default:
                    throw new RuntimeException("Unknown function: " + objectFunctionCallNode.getFunctionName());
            }
        }
        else {
            String objectName = objectFunctionCallNode.getObjectVariableName();
            SpookObject object = spookObjects.get(objectName);

            if (object == null)
                throw new RuntimeException("Object not found");

            switch (objectFunctionCallNode.getFunctionName()) {
                case "position":
                    ObjectArgumentNode x = objectFunctionCallNode.getObjectArguments().get(0);
                    ObjectArgumentNode y = objectFunctionCallNode.getObjectArguments().get(1);
                    object.setPosition(new Vector2(x,y));
                    break;
                default:
                    throw new RuntimeException("Unknown function: " + objectFunctionCallNode.getFunctionName());
            }
        }
    }

    private String getClassCode(Enums.ClassType classType, String methodName) {
        java.lang.reflect.Method method;
        try {
            Class objClass = SpookObject.getClassFromClassType(classType);
            method = objClass.getMethod(methodName);
            try {
                return method.invoke(null).toString();
            }
            catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

        }
        catch (SecurityException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return classType.toString() + "." + methodName;
    }
}
