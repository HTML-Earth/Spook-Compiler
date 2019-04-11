package dk.aau.cs.d403.codegen;

import dk.aau.cs.d403.ast.ASTvisitor;
import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.ast.statements.*;
import dk.aau.cs.d403.ast.structure.*;

public class CodeGenerator implements ASTvisitor {

    public String GenerateGLSL(ProgramNode ast) {
        StringBuilder sb = new StringBuilder();

        sb.append("void mainImage( out vec4 fragColor, in vec2 fragCoord ) {\n");
        sb.append(ast.getMainNode().getBlockNode().prettyPrint());
        return sb.toString();
    }

    @Override
    public ProgramNode visitProgram(ProgramNode programNode) {
        return null;
    }

    @Override
    public MainNode visitMain(MainNode mainNode) {
        return null;
    }

    @Override
    public BlockNode visitBlock(BlockNode blockNode) {
        return null;
    }

    @Override
    public ClassDeclarationNode visitClassDeclaration(ClassDeclarationNode classDeclarationNode) {
        return null;
    }

    @Override
    public ClassBlockNode visitClassBlock(ClassBlockNode classBlockNode) {
        return null;
    }

    @Override
    public FunctionDeclarationNode visitFunctionDeclaration(FunctionDeclarationNode functionDeclarationNode) {
        return null;
    }

    @Override
    public AssignmentNode visitAssignment(AssignmentNode assignmentNode) {
        return null;
    }

    @Override
    public DeclarationNode visitDeclaration(DeclarationNode declarationNode) {
        return null;
    }

    @Override
    public ObjectDeclarationNode visitObjectDeclaration(ObjectDeclarationNode objectDeclarationNode) {
        return null;
    }

    @Override
    public VariableDeclarationNode visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
        return null;
    }

    @Override
    public StatementNode visitStatement(StatementNode statementNode) {
        return null;
    }

    @Override
    public IfElseStatementNode visitIfElseStatement(IfElseStatementNode ifElseStatementNode) {
        return null;
    }

    @Override
    public ObjectFunctionCallNode visitObjectFunctionCall(ObjectFunctionCallNode objectFunctionCallNode) {
        return null;
    }

    @Override
    public FunctionArgNode visitFunctionArg(FunctionArgNode functionArgNode) {
        return null;
    }

    @Override
    public RectangleDeclarationNode visitRectangleDeclaration(RectangleDeclarationNode rectangleDeclarationNode) {
        return null;
    }

    @Override
    public ReturnNode visitReturn(ReturnNode returnNode) {
        return null;
    }

    @Override
    public TernaryOperatorNode visitTernaryOperator(TernaryOperatorNode ternaryOperatorNode) {
        return null;
    }

    @Override
    public ClassPropertyNode visitClassProperty(ClassPropertyNode classPropertyNode) {
        return null;
    }

    @Override
    public ArithOperandNode visitArithOperand(ArithOperandNode arithOperandNode) {
        return null;
    }

    @Override
    public ArithOperationNode visitArithOperation(ArithOperationNode arithOperationNode) {
        return null;
    }

    @Override
    public BoolOperationNode visitBoolOperation(BoolOperationNode boolOperationNode) {
        return null;
    }

    @Override
    public MathFunctionCallNode visitMathFunctionCall(MathFunctionCallNode mathFunctionCallNode) {
        return null;
    }

    @Override
    public ObjectArgumentNode visitObjectArgument(ObjectArgumentNode objectArgumentNode) {
        return null;
    }

    @Override
    public ExpressionNode visitExpressionNode(ExpressionNode expressionNode) {
        return null;
    }

    @Override
    public BoolExpressionNode visitBoolExpression(BoolExpressionNode boolExpressionNode) {
        return null;
    }

    @Override
    public IntegerExpressionNode visitIntegerExpression(IntegerExpressionNode integerExpressionNode) {
        return null;
    }

    @Override
    public FloatExpressionNode visitFloatExpression(FloatExpressionNode floatExpressionNode) {
        return null;
    }

    @Override
    public Vector2ExpressionNode visitVector2Expression(Vector2ExpressionNode vector2ExpressionNode) {
        return null;
    }

    @Override
    public Vector3ExpressionNode visitVector3Expression(Vector3ExpressionNode vector3ExpressionNode) {
        return null;
    }

    @Override
    public Vector4ExpressionNode visitVector4Expression(Vector4ExpressionNode vector4ExpressionNode) {
        return null;
    }

    @Override
    public NaturalNumberNode visitNaturalNumber(NaturalNumberNode naturalNumberNode) {
        return null;
    }

    @Override
    public RealNumberNode visitRealNumber(RealNumberNode realNumberNode) {
        return null;
    }
}
