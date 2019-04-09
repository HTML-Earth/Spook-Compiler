package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.expressions.ExpressionNode;

public class AssignmentNode extends StatementNode {
    private String variableName;
    private ExpressionNode expressionNode;

    public AssignmentNode(String variableName, ExpressionNode expressionNode) {
        this.variableName = variableName;
        this.expressionNode = expressionNode;
    }

    public String getVariableName() {
        return variableName;
    }

    public ExpressionNode getExpressionNode() {
        return expressionNode;
    }

    @Override
    public String prettyPrint() {
        return variableName + " = " + "expr" + ";";
    }
}
