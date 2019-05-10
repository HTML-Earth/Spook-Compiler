package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.expressions.*;

public class AssignmentNode extends StatementNode {
    private String variableName;
    private ExpressionNode expressionNode;
    private SwizzleNode swizzleNode;

    public AssignmentNode(String variableName, ExpressionNode expressionNode) {
        this.variableName = variableName;
        this.expressionNode = expressionNode;
    }

    public AssignmentNode(SwizzleNode swizzleNode, ExpressionNode expressionNode) {
        this.swizzleNode = swizzleNode;
        this.expressionNode = expressionNode;
    }

    public String getVariableName() {
        return variableName;
    }

    public ExpressionNode getExpressionNode() {
        return expressionNode;
    }

    public SwizzleNode getSwizzleNode() {
        return swizzleNode;
    }

    @Override
    public String prettyPrint(int indent) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < indent; i++)
            sb.append("\t");

        if (swizzleNode != null)
            sb.append(swizzleNode.prettyPrint(0) + " = " + expressionNode.prettyPrint(0));

        else if (variableName != null && expressionNode != null) {
            if (expressionNode instanceof ArithExpressionNode) {
                ArithExpressionNode arithExpressionNode = (ArithExpressionNode) expressionNode;
                sb.append(variableName + " = " + arithExpressionNode.prettyPrint(0));
            }
            else if (expressionNode instanceof BoolExpressionNode) {
                BoolExpressionNode boolExpressionNode = (BoolExpressionNode) expressionNode;
                sb.append(variableName + " = " + boolExpressionNode.prettyPrint(0));
            }
            else if (expressionNode instanceof TernaryOperatorNode) {
                TernaryOperatorNode ternaryOperatorNode = (TernaryOperatorNode) expressionNode;
                sb.append(variableName + " = " + ternaryOperatorNode.prettyPrint(0));
            }
        }
        return sb.toString();
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
