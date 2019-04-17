package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.expressions.ExpressionNode;

public class AssignmentNode extends StatementNode {
    private String variableName;
    private ExpressionNode expressionNode;
    private String assignedVariableName;

    public AssignmentNode(String variableName, ExpressionNode expressionNode) {
        this.variableName = variableName;
        this.expressionNode = expressionNode;
    }

    public AssignmentNode(String variableName, String assignedVariableName) {
        this.variableName = variableName;
        this.assignedVariableName = assignedVariableName;
    }

    public String getVariableName() {
        return variableName;
    }

    public ExpressionNode getExpressionNode() {
        return expressionNode;
    }

    public String getAssignedVariableName() {
        return assignedVariableName;
    }

    @Override
    public String prettyPrint() {
        return variableName + " = " + expressionNode.prettyPrint() + ";";
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
