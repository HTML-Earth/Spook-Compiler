package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.CodePosition;

public class BoolExpressionNode extends ExpressionNode {
    private BoolOperationsNode boolOperationsNode;

    public BoolExpressionNode(BoolOperationsNode boolOperationsNode) {
        this.boolOperationsNode = boolOperationsNode;
    }

    public BoolOperationsNode getBoolOperationsNode() {
        return boolOperationsNode;
    }

    @Override
    public String prettyPrint() {
        if (boolOperationsNode != null) {
            return boolOperationsNode.prettyPrint();
        } else
            return "Invalid Boolean Expression";
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
