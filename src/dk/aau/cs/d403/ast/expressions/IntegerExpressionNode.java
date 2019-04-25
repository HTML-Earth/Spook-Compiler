package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.CodePosition;

import java.util.ArrayList;

public class IntegerExpressionNode extends ExpressionNode {
    private ArrayList<ArithOperationNode> arithOperationNodes;
    private MathFunctionCallNode mathFunctionCallNode;
    private IntegerNumberNode integerNumberNode;

    public IntegerExpressionNode(ArrayList<ArithOperationNode> arithOperationNodes) {
        this.arithOperationNodes = arithOperationNodes;
    }

    public IntegerExpressionNode(MathFunctionCallNode mathFunctionCallNode) {
        this.mathFunctionCallNode = mathFunctionCallNode;
    }

    public IntegerExpressionNode(IntegerNumberNode integerNumberNode) {
        this.integerNumberNode = integerNumberNode;
    }

    public ArrayList<ArithOperationNode> getArithOperationNodes() {
        return arithOperationNodes;
    }

    public MathFunctionCallNode getMathFunctionCallNode() {
        return mathFunctionCallNode;
    }

    public IntegerNumberNode getIntegerNumberNode() {
        return integerNumberNode;
    }

    @Override
    public String prettyPrint() {
        if (arithOperationNodes != null) {
            return ArithOperationNode.prettyPrintOperations(arithOperationNodes);
        }
        else if (mathFunctionCallNode != null)
            return mathFunctionCallNode.prettyPrint();
        else if (integerNumberNode != null)
            return integerNumberNode.prettyPrint();
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
