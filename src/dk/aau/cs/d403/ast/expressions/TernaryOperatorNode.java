package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.CodePosition;

public class TernaryOperatorNode extends ExpressionNode {
    private BoolExpressionNode boolExpressionNode;
    private ExpressionNode expressionNode1;
    private ExpressionNode expressionNode2;

    public TernaryOperatorNode(BoolExpressionNode boolExpressionNode, ExpressionNode expressionNode1, ExpressionNode expressionNode2) {
        this.boolExpressionNode = boolExpressionNode;
        this.expressionNode1 = expressionNode1;
        this.expressionNode2 = expressionNode2;
    }

    public BoolExpressionNode getBoolExpressionNode() {
        return boolExpressionNode;
    }

    public ExpressionNode getExpressionNode1() {
        return expressionNode1;
    }

    public ExpressionNode getExpressionNode2() {
        return expressionNode2;
    }

    @Override
    public String prettyPrint() {
        return "Ternary operator";
    }

    private CodePosition codePosition;

    @Override
    public void setCodePosition(CodePosition codePosition) {
        this.codePosition = codePosition;
    }

    @Override
    public CodePosition getCodePosition() {
        return codePosition;
    }
}
