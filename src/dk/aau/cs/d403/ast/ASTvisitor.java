package dk.aau.cs.d403.ast;

import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.ast.statements.*;
import dk.aau.cs.d403.ast.structure.*;

public interface ASTvisitor {
    //Structure
    ProgramNode visitProgram(ProgramNode programNode);
    MainNode visitMain(MainNode mainNode);
    BlockNode visitBlock(BlockNode blockNode);
    ClassDeclarationNode visitClassDeclaration(ClassDeclarationNode classDeclarationNode);
    ClassBlockNode visitClassBlock(ClassBlockNode classBlockNode);
    FunctionDeclarationNode visitFunctionDeclaration(FunctionDeclarationNode functionDeclarationNode);

    //Statements
    AssignmentNode visitAssignment(AssignmentNode assignmentNode);

    DeclarationNode visitDeclaration(DeclarationNode declarationNode);
    ObjectDeclarationNode visitObjectDeclaration(ObjectDeclarationNode objectDeclarationNode);
    VariableDeclarationNode visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode);

    StatementNode visitStatement(StatementNode statementNode);
    IfElseStatementNode visitIfElseStatement(IfElseStatementNode ifElseStatementNode);
    ObjectFunctionCallNode visitObjectFunctionCall(ObjectFunctionCallNode objectFunctionCallNode);
    FunctionArgNode visitFunctionArg(FunctionArgNode functionArgNode);
    ReturnNode visitReturn(ReturnNode returnNode);

    //Expressions
    TernaryOperatorNode visitTernaryOperator(TernaryOperatorNode ternaryOperatorNode);
    ColorFunctionCallNode visitClassProperty(ColorFunctionCallNode colorFunctionCallNode);

    ArithOperandNode visitArithOperand(ArithOperandNode arithOperandNode);
    ArithOperationNode visitArithOperation(ArithOperationNode arithOperationNode);
    BoolOperationNode visitBoolOperation(BoolOperationNode boolOperationNode);

    MathFunctionCallNode visitMathFunctionCall(MathFunctionCallNode mathFunctionCallNode);
    ObjectArgumentNode visitObjectArgument(ObjectArgumentNode objectArgumentNode);

    ExpressionNode visitExpressionNode(ExpressionNode expressionNode);
    BoolExpressionNode visitBoolExpression(BoolExpressionNode boolExpressionNode);
    IntegerExpressionNode visitIntegerExpression(IntegerExpressionNode integerExpressionNode);
    FloatExpressionNode visitFloatExpression(FloatExpressionNode floatExpressionNode);
    Vector2ExpressionNode visitVector2Expression(Vector2ExpressionNode vector2ExpressionNode);
    Vector3ExpressionNode visitVector3Expression(Vector3ExpressionNode vector3ExpressionNode);
    Vector4ExpressionNode visitVector4Expression(Vector4ExpressionNode vector4ExpressionNode);

    IntegerNumberNode visitNaturalNumber(IntegerNumberNode integerNumberNode);
    RealNumberNode visitRealNumber(RealNumberNode realNumberNode);
}