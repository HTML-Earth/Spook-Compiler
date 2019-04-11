package dk.aau.cs.d403.ast.expressions;

public class Vector2ExpressionNode extends ExpressionNode {
    protected FloatExpressionNode floatExpressionNode1;
    protected FloatExpressionNode floatExpressionNode2;

    public Vector2ExpressionNode(FloatExpressionNode floatExpressionNode1, FloatExpressionNode floatExpressionNode2) {
        this.floatExpressionNode1 = floatExpressionNode1;
        this.floatExpressionNode2 = floatExpressionNode2;
    }

    public FloatExpressionNode getFloatExpressionNode1() {
        return floatExpressionNode1;
    }

    public FloatExpressionNode getFloatExpressionNode2() {
        return floatExpressionNode2;
    }

    @Override
    public String prettyPrint() {
        return "(" + floatExpressionNode1.prettyPrint()
                + ", " + floatExpressionNode2.prettyPrint()
                + ")";
    }
}
