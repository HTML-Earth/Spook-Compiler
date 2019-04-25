package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.CodePosition;

public class Vector2ExpressionNode extends ExpressionNode {
    protected ArithExpressionNode arithExpressionNode1;
    protected ArithExpressionNode arithExpressionNode2;

    public Vector2ExpressionNode(ArithExpressionNode arithExpressionNode1, ArithExpressionNode arithExpressionNode2) {
        this.arithExpressionNode1 = arithExpressionNode1;
        this.arithExpressionNode2 = arithExpressionNode2;
    }

    public ArithExpressionNode getArithExpressionNode1() {
        return arithExpressionNode1;
    }

    public ArithExpressionNode getArithExpressionNode2() {
        return arithExpressionNode2;
    }

    @Override
    public String prettyPrint() {
        return "(" + arithExpressionNode1.prettyPrint()
                + ", " + arithExpressionNode2.prettyPrint()
                + ")";
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
