package dk.aau.cs.d403.ast.expressions;

public class Vector3ExpressionNode extends Vector2ExpressionNode {
    protected FloatExpressionNode floatExpressionNode3;

    public Vector3ExpressionNode(FloatExpressionNode floatExpressionNode1, FloatExpressionNode floatExpressionNode2, FloatExpressionNode floatExpressionNode3) {
        super(floatExpressionNode1, floatExpressionNode2);
        this.floatExpressionNode3 = floatExpressionNode3;
    }

    public FloatExpressionNode getFloatExpressionNode3() {
        return floatExpressionNode3;
    }

    @Override
    public String prettyPrint() {
        return "( " + floatExpressionNode1.prettyPrint()
                + " , " + floatExpressionNode2.prettyPrint()
                + " , " + floatExpressionNode3.prettyPrint()
                + " )";
    }
}
