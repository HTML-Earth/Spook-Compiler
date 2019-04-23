package dk.aau.cs.d403.codegen;

import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.ast.statements.*;
import dk.aau.cs.d403.ast.structure.*;
import dk.aau.cs.d403.spook.*;
import dk.aau.cs.d403.spook.color.Color;
import dk.aau.cs.d403.spook.shapes.*;

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
            sb.append(Shape.getStruct(type));
            sb.append("\n");
        }

        sb.append("\n");
    }

    private void generatePrototypes() {
        for (Enums.ClassType type : usedClasses) {
            sb.append(Shape.getCheckFunctionSignature(type));
            sb.append(";\n");
        }

        sb.append("\n");
    }

    private void generateFunctions() {
        for (Enums.ClassType type : usedClasses) {
            sb.append(Shape.getCheckFunctionSignature(type));
            sb.append("{\n\t");
            sb.append(Shape.getCheckFunctionBody(type));
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

            Enums.ClassType objectType;

            if (object instanceof Rectangle)
                objectType = Enums.ClassType.RECTANGLE;
            else if (object instanceof Circle)
                objectType = Enums.ClassType.CIRCLE;
            else if (object instanceof Square)
                objectType = Enums.ClassType.SQUARE;
            else if (object instanceof Triangle)
                objectType = Enums.ClassType.TRIANGLE;
            else
                throw new RuntimeException("Unrecognized object type");

            sb.append(Shape.getCheckCall(objectType, object.getName()));
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
            return; //visitAssignment((AssignmentNode)statementNode);
        else if (statementNode instanceof DeclarationNode)
            visitDeclaration((DeclarationNode)statementNode);
        else if (statementNode instanceof IfElseStatementNode)
            return; //visitIfElseStatement((IfElseStatementNode)statementNode);
        else if (statementNode instanceof ObjectFunctionCallNode)
            visitObjectFunctionCall((ObjectFunctionCallNode)statementNode);
        else if (statementNode instanceof ReturnNode)
            return; //visitReturn((ReturnNode)statementNode);
        else {
            System.out.println(statementNode.prettyPrint());
            throw new RuntimeException("Statement is of unknown type");
        }
    }

    /*
    private AssignmentNode visitAssignment(AssignmentNode assignmentNode) {
        sb.append(assignmentNode.getVariableName());
        sb.append(" = ");
        visitExpressionNode(assignmentNode.getExpressionNode());
        return assignmentNode;
    }
    */

    private void visitDeclaration(DeclarationNode declarationNode) {
        if (declarationNode instanceof VariableDeclarationNode)
            //visitVariableDeclaration((VariableDeclarationNode)declarationNode);
            System.out.println(""); //skip
        else if (declarationNode instanceof ObjectDeclarationNode)
            visitObjectDeclaration((ObjectDeclarationNode)declarationNode);
        else
            throw new RuntimeException("Declaration is of unknown type");
    }

    private void visitObjectDeclaration(ObjectDeclarationNode objectDeclarationNode) {
        ArrayList<ObjectArgumentNode> argumentNodes = objectDeclarationNode.getObjectArgumentNodes();

        Enums.ClassType objectType = objectDeclarationNode.getObjectType();
        usedClasses.add(objectType);

        switch (objectType) {
            case CIRCLE:
                break;
            case RECTANGLE:
                if (argumentNodes.size() == 3) {
                    ClassPropertyNode colorProperty = argumentNodes.get(2).getClassPropertyNode();

                    Vector2 size = new Vector2(argumentNodes.get(0), argumentNodes.get(1));
                    Vector4 color = Color.getColorProperty(colorProperty);

                    Rectangle rectangle = new Rectangle(objectDeclarationNode.getVariableName(), size, color);
                    spookObjects.put(objectDeclarationNode.getVariableName(), rectangle);
                }
                break;
            case TRIANGLE:
                break;
            case SHAPE:
                break;
            case COLOR:
                break;
        }
    }

    /*
    private void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
        sb.append(Enums.dataTypeToStringGLSL(variableDeclarationNode.getDataType()));
        sb.append(" ");
        visitAssignment(variableDeclarationNode.getAssignmentNode());
    }
    */

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

    /*
    private ExpressionNode visitExpressionNode(ExpressionNode expressionNode) {
        if (expressionNode instanceof IntegerExpressionNode) {
            return visitIntegerExpression((IntegerExpressionNode)expressionNode);
        }
        else if (expressionNode instanceof FloatExpressionNode) {
            return visitFloatExpression((FloatExpressionNode)expressionNode);
        }
        else if (expressionNode instanceof Vector4ExpressionNode) {
            return visitVector4Expression((Vector4ExpressionNode)expressionNode);
        }
        else if (expressionNode instanceof Vector3ExpressionNode) {
            return visitVector3Expression((Vector3ExpressionNode)expressionNode);
        }
        else if (expressionNode instanceof Vector2ExpressionNode) {
            return visitVector2Expression((Vector2ExpressionNode)expressionNode);
        }
        else if (expressionNode instanceof BoolExpressionNode) {
            return visitBoolExpression((BoolExpressionNode)expressionNode);
        }
        else if (expressionNode instanceof TernaryOperatorNode) {
            return visitTernaryOperator((TernaryOperatorNode)expressionNode);
        }
        else
            throw new RuntimeException("Invalid expression");
    }
    */
}
