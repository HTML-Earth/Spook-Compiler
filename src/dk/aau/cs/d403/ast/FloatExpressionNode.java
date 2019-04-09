package dk.aau.cs.d403.ast;

import java.util.ArrayList;

public class FloatExpressionNode extends ExpressionNode {
    private ArrayList<ArithOperationNode> arithOperationNodes;
    private MathFunctionCall mathFunctionCall;
    private RealNumberNode realNumberNode;

    public FloatExpressionNode(ArrayList<ArithOperationNode> arithOperationNodes) {
        this.arithOperationNodes = arithOperationNodes;
    }

    public FloatExpressionNode(MathFunctionCall mathFunctionCall) {
        this.mathFunctionCall = mathFunctionCall;
    }

    public FloatExpressionNode(RealNumberNode realNumberNode) {
        this.realNumberNode = realNumberNode;
    }

    public ArrayList<ArithOperationNode> getArithOperationNodes() {
        return arithOperationNodes;
    }

    public MathFunctionCall getMathFunctionCall() {
        return mathFunctionCall;
    }

    public RealNumberNode getRealNumberNode() {
        return realNumberNode;
    }

    @Override
    public String prettyPrint() {
        if (arithOperationNodes != null)
            return "arith";
        else if (mathFunctionCall != null)
            return mathFunctionCall.prettyPrint();
        else if (realNumberNode != null)
            return realNumberNode.prettyPrint();
        else
            return "Invalid integer expression";
    }
}
