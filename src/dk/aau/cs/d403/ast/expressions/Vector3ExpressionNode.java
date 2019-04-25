package dk.aau.cs.d403.ast.expressions;

public class Vector3ExpressionNode extends Vector2ExpressionNode {
    protected ArithExpressionNode arithExpressionNode3;

    public Vector3ExpressionNode(ArithExpressionNode arithExpressionNode1, ArithExpressionNode arithExpressionNode2, ArithExpressionNode arithExpressionNode3) {
        super(arithExpressionNode1, arithExpressionNode2);
        this.arithExpressionNode3 = arithExpressionNode3;
    }

    public ArithExpressionNode getArithExpressionNode3() {
        return arithExpressionNode3;
    }

    @Override
    public String prettyPrint() {
        return "(" + arithExpressionNode1.prettyPrint()
                + ", " + arithExpressionNode2.prettyPrint()
                + ", " + arithExpressionNode3.prettyPrint()
                + ")";
    }
}
