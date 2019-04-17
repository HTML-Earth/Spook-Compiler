package dk.aau.cs.d403.codegen;

import dk.aau.cs.d403.ast.ASTvisitor;
import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.ast.statements.*;
import dk.aau.cs.d403.ast.structure.*;
import dk.aau.cs.d403.spook.Scene;
import dk.aau.cs.d403.spook.SpookObject;
import dk.aau.cs.d403.spook.Vector2;
import dk.aau.cs.d403.spook.Vector4;
import dk.aau.cs.d403.spook.color.Color;
import dk.aau.cs.d403.spook.shapes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CodeGenerator implements ASTvisitor {

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
        sb = new StringBuilder(); //hacky hack

        generateStructs(usedClasses);
        generatePrototypes(usedClasses);
        generateMain(ast.getMainNode());
        generateFunctions(usedClasses);

        return sb.toString();
    }

    private void generateStructs(HashSet<Enums.ClassType> classTypes) {
        for (Enums.ClassType type : classTypes) {
            sb.append(Shape.getStruct(type));
            sb.append("\n");
        }

        sb.append("\n");
    }

    private void generatePrototypes(HashSet<Enums.ClassType> classTypes) {
        for (Enums.ClassType type : classTypes) {
            sb.append(Shape.getCheckFunctionSignature(type));
            sb.append(";\n");
        }

        sb.append("\n");
    }

    private void generateFunctions(HashSet<Enums.ClassType> classTypes) {
        for (Enums.ClassType type : classTypes) {
            sb.append(Shape.getCheckFunctionSignature(type));
            sb.append("{\n\t");
            sb.append(Shape.getCheckFunctionBody(type));
            sb.append("\n");
        }

        sb.append("\n}");
    }

    private void generateMain(MainNode mainNode) {
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

        sb.append("\tfragColor = vec4" + Vector4.prettyPrint(scene.getColor()) + ";\n");

        sb.append("}\n\n");
    }

    @Override
    public ProgramNode visitProgram(ProgramNode programNode) {
        visitMain(programNode.getMainNode());
        return programNode;
    }

    @Override
    public MainNode visitMain(MainNode mainNode) {
        visitBlock(mainNode.getBlockNode());
        return mainNode;
    }

    @Override
    public BlockNode visitBlock(BlockNode blockNode) {
        sb.append("{");
        for (StatementNode statement : blockNode.getStatementNodes()) {
            sb.append("\n\t");
            visitStatement(statement);
            sb.append(";");
        }
        sb.append("\n}");
        return blockNode;
    }

    @Override
    public ClassDeclarationNode visitClassDeclaration(ClassDeclarationNode classDeclarationNode) {
        sb.append("CLASS DECLARATION");
        return classDeclarationNode;
    }

    @Override
    public ClassBlockNode visitClassBlock(ClassBlockNode classBlockNode) {
        sb.append("CLASS BLOCK");
        return classBlockNode;
    }

    @Override
    public FunctionDeclarationNode visitFunctionDeclaration(FunctionDeclarationNode functionDeclarationNode) {
        sb.append("FUNCTION DECLARATION");
        return functionDeclarationNode;
    }

    @Override
    public AssignmentNode visitAssignment(AssignmentNode assignmentNode) {
        sb.append(assignmentNode.getVariableName());
        sb.append(" = ");
        visitExpressionNode(assignmentNode.getExpressionNode());
        return assignmentNode;
    }

    @Override
    public DeclarationNode visitDeclaration(DeclarationNode declarationNode) {
        if (declarationNode instanceof VariableDeclarationNode)
            return visitVariableDeclaration((VariableDeclarationNode)declarationNode);
        else if (declarationNode instanceof ObjectDeclarationNode)
            return visitObjectDeclaration((ObjectDeclarationNode)declarationNode);
        else
            throw new RuntimeException("Declaration is of unknown type");
    }

    @Override
    public ObjectDeclarationNode visitObjectDeclaration(ObjectDeclarationNode objectDeclarationNode) {
        sb.append("OBJECT DECLARATION");

        ArrayList<ObjectArgumentNode> argumentNodes = objectDeclarationNode.getObjectArgumentNodes();

        Enums.ClassType objectType = objectDeclarationNode.getObjectType();
        usedClasses.add(objectType);

        switch (objectType) {
            case CIRCLE:
                break;
            case RECTANGLE:
                if (argumentNodes.size() == 3) {
                    float width = argumentNodes.get(0).getRealNumberNode().getNumber();
                    float height = argumentNodes.get(1).getRealNumberNode().getNumber();
                    ClassPropertyNode colorProperty = argumentNodes.get(2).getClassPropertyNode();

                    Vector2 size = new Vector2(width,height);
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

        return objectDeclarationNode;
    }

    @Override
    public VariableDeclarationNode visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
        sb.append(Enums.dataTypeToStringGLSL(variableDeclarationNode.getDataType()));
        sb.append(" ");
        visitAssignment(variableDeclarationNode.getAssignmentNode());
        return variableDeclarationNode;
    }

    @Override
    public StatementNode visitStatement(StatementNode statementNode) {
        if (statementNode instanceof AssignmentNode)
            return visitAssignment((AssignmentNode)statementNode);
        else if (statementNode instanceof DeclarationNode)
            return visitDeclaration((DeclarationNode)statementNode);
        else if (statementNode instanceof IfElseStatementNode)
            return visitIfElseStatement((IfElseStatementNode)statementNode);
        else if (statementNode instanceof ObjectFunctionCallNode)
            return visitObjectFunctionCall((ObjectFunctionCallNode)statementNode);
        else if (statementNode instanceof ReturnNode)
            return visitReturn((ReturnNode)statementNode);
        else {
            System.out.println(statementNode.prettyPrint());
            throw new RuntimeException("Statement is of unknown type");
        }
    }

    @Override
    public IfElseStatementNode visitIfElseStatement(IfElseStatementNode ifElseStatementNode) {
        sb.append("IF ELSE STATEMENT");
        return ifElseStatementNode;
    }

    @Override
    public ObjectFunctionCallNode visitObjectFunctionCall(ObjectFunctionCallNode objectFunctionCallNode) {
        sb.append("OBJECT FUNCTION CALL");
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
                    float x = objectFunctionCallNode.getObjectArguments().get(0).getRealNumberNode().getNumber();
                    float y = objectFunctionCallNode.getObjectArguments().get(1).getRealNumberNode().getNumber();
                    object.setPosition(new Vector2(x,y));
                    break;
                default:
                    throw new RuntimeException("Unknown function: " + objectFunctionCallNode.getFunctionName());
            }
        }
        return objectFunctionCallNode;
    }

    @Override
    public FunctionArgNode visitFunctionArg(FunctionArgNode functionArgNode) {
        sb.append("FUNCTION ARG");
        return functionArgNode;
    }

    @Override
    public ReturnNode visitReturn(ReturnNode returnNode) {
        sb.append("RETURN");
        return returnNode;
    }

    @Override
    public TernaryOperatorNode visitTernaryOperator(TernaryOperatorNode ternaryOperatorNode) {
        sb.append("TERNARY OPERATOR");
        return ternaryOperatorNode;
    }

    @Override
    public ClassPropertyNode visitClassProperty(ClassPropertyNode classPropertyNode) {
        sb.append("CLASS PROPERTY");
        return classPropertyNode;
    }

    @Override
    public ArithOperandNode visitArithOperand(ArithOperandNode arithOperandNode) {
        RealNumberNode realNumberNode = arithOperandNode.getRealNumberNode();
        MathFunctionCallNode mathFunctionCallNode = arithOperandNode.getMathFunctionCallNode();
        String variableName = arithOperandNode.getVariableName();

        if (realNumberNode != null) {
            visitRealNumber(realNumberNode);
        }
        else if (mathFunctionCallNode != null) {
            visitMathFunctionCall(mathFunctionCallNode);
        }
        else if (variableName != null) {
            sb.append(variableName);
        }
        else throw new RuntimeException("Invalid arith operand");

        return arithOperandNode;
    }

    @Override
    public ArithOperationNode visitArithOperation(ArithOperationNode arithOperationNode) {
        ArithOperandNode leftOperand = arithOperationNode.getLeftOperand();
        Enums.Operator operator = arithOperationNode.getOperator();
        ArithOperandNode rightOperand = arithOperationNode.getRightOperand();
        ArithOperationNode subOperation = arithOperationNode.getArithOperationNode();
        ArrayList<ArithOperationNode> arithOperationNodes = arithOperationNode.getArithOperationNodes();

        if (leftOperand != null && operator != null && rightOperand != null) {
            visitArithOperand(leftOperand);
            sb.append(" ");
            sb.append(Enums.operatorToString(operator));
            sb.append(" ");
            visitArithOperand(rightOperand);
        }
        else if (leftOperand != null && operator != null && subOperation != null) {
            visitArithOperand(leftOperand);
            sb.append(" ");
            sb.append(Enums.operatorToString(operator));
            visitArithOperation(subOperation);
        }
        else if (operator != null && rightOperand != null) {
            sb.append(" ");
            sb.append(Enums.operatorToString(operator));
            sb.append(" ");
            visitArithOperand(rightOperand);
        }
        else if (operator != null && subOperation != null) {
            sb.append(Enums.operatorToString(operator));
            sb.append(" ");
            visitArithOperation(subOperation);
        }
        else if (arithOperationNodes != null) {
            for (ArithOperationNode operationNode: arithOperationNodes) {
                visitArithOperation(operationNode);
            }
        }
        else
            throw new RuntimeException("Invalid Arithmetic Operation");

        return arithOperationNode;
    }

    @Override
    public BoolOperationNode visitBoolOperation(BoolOperationNode boolOperationNode) {
        sb.append("BOOL OPERATION");
        return boolOperationNode;
    }

    @Override
    public MathFunctionCallNode visitMathFunctionCall(MathFunctionCallNode mathFunctionCallNode) {
        sb.append(Enums.mathFunctionToString(mathFunctionCallNode.getFunctionName()));
        sb.append("(");
        ArithOperandNode arithOperandNode = mathFunctionCallNode.getOperandNode();
        ArrayList<ArithOperationNode> arithOperationNodes = mathFunctionCallNode.getOperationNodes();
        if (arithOperandNode != null) {
            visitArithOperand(arithOperandNode);
        }
        else if (arithOperationNodes != null) {
            for (ArithOperationNode operationNode : arithOperationNodes) {
                visitArithOperation(operationNode);
            }
        }
        else throw new RuntimeException("Invalid math function call");
        sb.append(")");

        return mathFunctionCallNode;
    }

    @Override
    public ObjectArgumentNode visitObjectArgument(ObjectArgumentNode objectArgumentNode) {
        sb.append("OBJECT ARGUMENT");
        return objectArgumentNode;
    }

    @Override
    public ExpressionNode visitExpressionNode(ExpressionNode expressionNode) {
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

    @Override
    public BoolExpressionNode visitBoolExpression(BoolExpressionNode boolExpressionNode) {
        sb.append("BOOL EXPRESSION");
        return boolExpressionNode;
    }

    @Override
    public IntegerExpressionNode visitIntegerExpression(IntegerExpressionNode integerExpressionNode) {
        NaturalNumberNode naturalNumberNode = integerExpressionNode.getNaturalNumberNode();
        ArrayList<ArithOperationNode> arithOperationNodes = integerExpressionNode.getArithOperationNodes();
        MathFunctionCallNode mathFunctionCallNode = integerExpressionNode.getMathFunctionCallNode();
        if (naturalNumberNode != null) {
            visitNaturalNumber(naturalNumberNode);
        }
        else if (arithOperationNodes != null) {
            boolean firstOp = true;
            for (ArithOperationNode arithOperationNode : arithOperationNodes) {
                if (!firstOp)
                    sb.append(" ");
                firstOp = false;
                visitArithOperation(arithOperationNode);
            }
        }
        else if (mathFunctionCallNode != null) {
            visitMathFunctionCall(mathFunctionCallNode);
        }
        else
            throw new RuntimeException("Invalid integer expression");

        return integerExpressionNode;
    }

    @Override
    public FloatExpressionNode visitFloatExpression(FloatExpressionNode floatExpressionNode) {
        RealNumberNode realNumberNode = floatExpressionNode.getRealNumberNode();
        ArrayList<ArithOperationNode> arithOperationNodes = floatExpressionNode.getArithOperationNodes();
        MathFunctionCallNode mathFunctionCallNode = floatExpressionNode.getMathFunctionCallNode();
        if (realNumberNode != null) {
            visitRealNumber(realNumberNode);
        }
        else if (arithOperationNodes != null) {
            boolean firstOp = true;
            for (ArithOperationNode arithOperationNode : arithOperationNodes) {
                if (!firstOp)
                    sb.append(" ");
                firstOp = false;
                visitArithOperation(arithOperationNode);
            }
        }
        else if (mathFunctionCallNode != null) {
            visitMathFunctionCall(mathFunctionCallNode);
        }
        else
            throw new RuntimeException("Invalid float expression");

        return floatExpressionNode;
    }

    @Override
    public Vector2ExpressionNode visitVector2Expression(Vector2ExpressionNode vector2ExpressionNode) {
        sb.append("(");
        visitFloatExpression(vector2ExpressionNode.getFloatExpressionNode1());
        sb.append(", ");
        visitFloatExpression(vector2ExpressionNode.getFloatExpressionNode2());
        sb.append(")");
        return vector2ExpressionNode;
    }

    @Override
    public Vector3ExpressionNode visitVector3Expression(Vector3ExpressionNode vector3ExpressionNode) {
        sb.append("(");
        visitFloatExpression(vector3ExpressionNode.getFloatExpressionNode1());
        sb.append(", ");
        visitFloatExpression(vector3ExpressionNode.getFloatExpressionNode2());
        sb.append(", ");
        visitFloatExpression(vector3ExpressionNode.getFloatExpressionNode3());
        sb.append(")");
        return vector3ExpressionNode;
    }

    @Override
    public Vector4ExpressionNode visitVector4Expression(Vector4ExpressionNode vector4ExpressionNode) {
        sb.append("(");
        visitFloatExpression(vector4ExpressionNode.getFloatExpressionNode1());
        sb.append(", ");
        visitFloatExpression(vector4ExpressionNode.getFloatExpressionNode2());
        sb.append(", ");
        visitFloatExpression(vector4ExpressionNode.getFloatExpressionNode3());
        sb.append(", ");
        visitFloatExpression(vector4ExpressionNode.getFloatExpressionNode4());
        sb.append(")");
        return vector4ExpressionNode;
    }

    @Override
    public NaturalNumberNode visitNaturalNumber(NaturalNumberNode naturalNumberNode) {
        sb.append(naturalNumberNode.prettyPrint());
        return naturalNumberNode;
    }

    @Override
    public RealNumberNode visitRealNumber(RealNumberNode realNumberNode) {
        sb.append(realNumberNode.prettyPrint());
        return realNumberNode;
    }
}
