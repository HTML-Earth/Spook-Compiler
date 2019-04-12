package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.CodePosition;

import java.util.ArrayList;

public class IntegerExpressionNode extends ExpressionNode {
    private ArrayList<ArithOperationNode> arithOperationNodes;
    private MathFunctionCallNode mathFunctionCallNode;
    private NaturalNumberNode naturalNumberNode;

    public IntegerExpressionNode(ArrayList<ArithOperationNode> arithOperationNodes) {
        this.arithOperationNodes = arithOperationNodes;
    }

    public IntegerExpressionNode(MathFunctionCallNode mathFunctionCallNode) {
        this.mathFunctionCallNode = mathFunctionCallNode;
    }

    public IntegerExpressionNode(NaturalNumberNode naturalNumberNode) {
        this.naturalNumberNode = naturalNumberNode;
    }

    public ArrayList<ArithOperationNode> getArithOperationNodes() {
        return arithOperationNodes;
    }

    public MathFunctionCallNode getMathFunctionCallNode() {
        return mathFunctionCallNode;
    }

    public NaturalNumberNode getNaturalNumberNode() {
        return naturalNumberNode;
    }

    @Override
    public String prettyPrint() {
        if (arithOperationNodes != null) {
            return ArithOperationNode.prettyPrintOperations(arithOperationNodes);
        }
        else if (mathFunctionCallNode != null)
            return mathFunctionCallNode.prettyPrint();
        else if (naturalNumberNode != null)
            return naturalNumberNode.prettyPrint();
        else
            return "Invalid integer expression";
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
