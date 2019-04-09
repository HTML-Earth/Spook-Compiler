package dk.aau.cs.d403.ast;

import java.util.ArrayList;

public class IntegerExpressionNode extends ExpressionNode {
    private ArrayList<ArithOperationNode> arithOperationNodes;
    private MathFunctionCall mathFunctionCall;
    private NaturalNumberNode naturalNumberNode;

    public IntegerExpressionNode(ArrayList<ArithOperationNode> arithOperationNodes) {
        this.arithOperationNodes = arithOperationNodes;
    }

    public IntegerExpressionNode(MathFunctionCall mathFunctionCall) {
        this.mathFunctionCall = mathFunctionCall;
    }

    public IntegerExpressionNode(NaturalNumberNode naturalNumberNode) {
        this.naturalNumberNode = naturalNumberNode;
    }

    public ArrayList<ArithOperationNode> getArithOperationNodes() {
        return arithOperationNodes;
    }

    public MathFunctionCall getMathFunctionCall() {
        return mathFunctionCall;
    }

    public NaturalNumberNode getNaturalNumberNode() {
        return naturalNumberNode;
    }

    @Override
    public String prettyPrint() {
        if (arithOperationNodes != null)
            return "arith";
        else if (mathFunctionCall != null)
            return mathFunctionCall.prettyPrint();
        else if (naturalNumberNode != null)
            return naturalNumberNode.prettyPrint();
        else
            return "Invalid integer expression";
    }
}
