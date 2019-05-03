package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.expressions.ExpressionNode;
import dk.aau.cs.d403.ast.expressions.RealNumberNode;

public class ReturnNode extends StatementNode {
    private ExpressionNode expressionNode;

    public ReturnNode(ExpressionNode expressionNode) {
        this.expressionNode = expressionNode;
    }

    @Override
    public String prettyPrint(int indent) {
        if (expressionNode != null)
            return "return " + expressionNode.prettyPrint(indent) + ";";
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
