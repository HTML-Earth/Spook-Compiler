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
    public String prettyPrint() {
        if (swizzleNode != null)
            return swizzleNode.prettyPrint() + " = " + expressionNode.prettyPrint() + ";";
        else if (variableName != null)
            return variableName + " = " + expressionNode.prettyPrint() + ";";
        else
            return "Invalid Assignment";
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
