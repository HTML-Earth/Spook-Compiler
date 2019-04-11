package dk.aau.cs.d403.ast.expressions;

public class Vector4ExpressionNode extends Vector3ExpressionNode {
    protected FloatExpressionNode floatExpressionNode4;

    public Vector4ExpressionNode(FloatExpressionNode floatExpressionNode1, FloatExpressionNode floatExpressionNode2, FloatExpressionNode floatExpressionNode3, FloatExpressionNode floatExpressionNode4) {
        super(floatExpressionNode1, floatExpressionNode2, floatExpressionNode3);
        this.floatExpressionNode4 = floatExpressionNode4;
    }

    public FloatExpressionNode getFloatExpressionNode4() {
        return floatExpressionNode4;
    }

    @Override
    public String prettyPrint() {
        return "(" + floatExpressionNode1.prettyPrint()
                + ", " + floatExpressionNode2.prettyPrint()
                + ", " + floatExpressionNode3.prettyPrint()
                + ", " + floatExpressionNode4.prettyPrint()
                + ")";
    }
}
