package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.CodePosition;

import java.util.ArrayList;

public class FloatExpressionNode extends ExpressionNode {
    private ArrayList<ArithOperationNode> arithOperationNodes;
    private MathFunctionCallNode mathFunctionCallNode;
    private RealNumberNode realNumberNode;

    public FloatExpressionNode(ArrayList<ArithOperationNode> arithOperationNodes) {
        this.arithOperationNodes = arithOperationNodes;
    }

    public FloatExpressionNode(MathFunctionCallNode mathFunctionCall) {
        this.mathFunctionCallNode = mathFunctionCall;
    }

    public FloatExpressionNode(RealNumberNode realNumberNode) {
        this.realNumberNode = realNumberNode;
    }

    public ArrayList<ArithOperationNode> getArithOperationNodes() {
        return arithOperationNodes;
    }

    public MathFunctionCallNode getMathFunctionCallNode() {
        return mathFunctionCallNode;
    }

    public RealNumberNode getRealNumberNode() {
        return realNumberNode;
    }

    @Override
    public String prettyPrint() {
        if (arithOperationNodes != null) {
            return ArithOperationNode.prettyPrintOperations(arithOperationNodes);
        }
        else if (mathFunctionCallNode != null)
            return mathFunctionCallNode.prettyPrint();
        else if (realNumberNode != null)
            return realNumberNode.prettyPrint();
        else
            return "Invalid float expression";
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
