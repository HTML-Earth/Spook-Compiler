package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.expressions.ExpressionNode;
import dk.aau.cs.d403.ast.expressions.SwizzleNode;

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
        else if (variableName != null)
            sb.append(variableName + " = " + expressionNode.prettyPrint(0));

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
