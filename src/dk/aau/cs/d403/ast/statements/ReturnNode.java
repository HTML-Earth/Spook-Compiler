package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.expressions.ExpressionNode;

public class ReturnNode extends StatementNode {
    private ExpressionNode expressionNode;

    public ReturnNode(ExpressionNode expressionNode) {
        this.expressionNode = expressionNode;
    }

    @Override
    public String prettyPrint(int indent) {
        StringBuilder sb = new StringBuilder();
        if (expressionNode != null) {
            for (int i = 0; i < indent; i++)
                sb.append("\t");
            sb.append("return " + expressionNode.prettyPrint(indent) + ";");
            return sb.toString();
        }
        else
            return "Invalid return statement";
    }

    public ExpressionNode getExpressionNode() {
        return expressionNode;
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
