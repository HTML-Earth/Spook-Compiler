package dk.aau.cs.d403.ast.expressions;

public class Vector4ExpressionNode extends Vector3ExpressionNode {
    protected ArithExpressionNode arithExpressionNode4;

    public Vector4ExpressionNode(ArithExpressionNode arithExpressionNode1, ArithExpressionNode arithExpressionNode2, ArithExpressionNode arithExpressionNode3, ArithExpressionNode arithExpressionNode4) {
        super(arithExpressionNode1, arithExpressionNode2, arithExpressionNode3);
        this.arithExpressionNode4 = arithExpressionNode4;
    }

    public ArithExpressionNode getArithExpressionNode4() {
        return arithExpressionNode4;
    }

    @Override
    public String prettyPrint() {
        return "(" + arithExpressionNode1.prettyPrint()
                + ", " + arithExpressionNode2.prettyPrint()
                + ", " + arithExpressionNode3.prettyPrint()
                + ", " + arithExpressionNode4.prettyPrint()
                + ")";
    }
}
