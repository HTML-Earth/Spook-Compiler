package dk.aau.cs.d403.codegen;

import dk.aau.cs.d403.ast.ASTvisitor;
import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.ast.statements.*;
import dk.aau.cs.d403.ast.structure.*;

public class CodeGenerator implements ASTvisitor {

    StringBuilder sb;

    public String GenerateGLSL(ProgramNode ast) {
        sb = new StringBuilder();
        visitProgram(ast);
        return sb.toString();
    }

    @Override
    public ProgramNode visitProgram(ProgramNode programNode) {
        sb.append("void mainImage( out vec4 fragColor, in vec2 fragCoord ) ");
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
        sb.append("ARITH OPERAND");
        return arithOperandNode;
    }

    @Override
    public ArithOperationNode visitArithOperation(ArithOperationNode arithOperationNode) {
        sb.append("ARITH OPERATION");
        return arithOperationNode;
    }

    @Override
    public BoolOperationNode visitBoolOperation(BoolOperationNode boolOperationNode) {
        sb.append("BOOL OPERATION");
        return boolOperationNode;
    }

    @Override
    public MathFunctionCallNode visitMathFunctionCall(MathFunctionCallNode mathFunctionCallNode) {
        sb.append("MATH FUNCTION CALL");
        return mathFunctionCallNode;
    }

    @Override
    public ObjectArgumentNode visitObjectArgument(ObjectArgumentNode objectArgumentNode) {
        sb.append("OBJECT ARGUMENT");
        return objectArgumentNode;
    }

    @Override
    public ExpressionNode visitExpressionNode(ExpressionNode expressionNode) {
        sb.append("EXPRESSION");
        return expressionNode;
    }

    @Override
    public BoolExpressionNode visitBoolExpression(BoolExpressionNode boolExpressionNode) {
        sb.append("BOOL EXPRESSION");
        return boolExpressionNode;
    }

    @Override
    public IntegerExpressionNode visitIntegerExpression(IntegerExpressionNode integerExpressionNode) {
        sb.append("INTEGER EXPRESSION");
        return integerExpressionNode;
    }

    @Override
    public FloatExpressionNode visitFloatExpression(FloatExpressionNode floatExpressionNode) {
        sb.append("FLOAT EXPRESSION");
        return floatExpressionNode;
    }

    @Override
    public Vector2ExpressionNode visitVector2Expression(Vector2ExpressionNode vector2ExpressionNode) {
        sb.append("VECTOR2 EXPRESSION");
        return vector2ExpressionNode;
    }

    @Override
    public Vector3ExpressionNode visitVector3Expression(Vector3ExpressionNode vector3ExpressionNode) {
        sb.append("VECTOR3 EXPRESSION");
        return vector3ExpressionNode;
    }

    @Override
    public Vector4ExpressionNode visitVector4Expression(Vector4ExpressionNode vector4ExpressionNode) {
        sb.append("VECTOR4 EXPRESSION");
        return vector4ExpressionNode;
    }

    @Override
    public NaturalNumberNode visitNaturalNumber(NaturalNumberNode naturalNumberNode) {
        sb.append("NATURAL NUMBER");
        return naturalNumberNode;
    }

    @Override
    public RealNumberNode visitRealNumber(RealNumberNode realNumberNode) {
        sb.append("REAL NUMBER");
        return realNumberNode;
    }
}
