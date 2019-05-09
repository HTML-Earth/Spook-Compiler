package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.expressions.ExpressionNode;

public class ReturnNode extends StatementNode {
    private ExpressionNode expressionNode;

    public ReturnNode(ExpressionNode expressionNode) {
        this.expressionNode = expressionNode;
    }

    @Override
    public String prettyPrint() {
        if (expressionNode != null)
            return "return " + expressionNode.prettyPrint() + ";";
        else
            return "Invalid return statement";
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
