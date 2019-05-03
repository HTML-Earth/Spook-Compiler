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
    public String prettyPrint(int indent) {
        if (boolOperationNodes != null) {
            StringBuilder sb = new StringBuilder();
            for (BoolOperationNode boolOperationNode: boolOperationNodes) {
                sb.append(boolOperationNode.prettyPrint(indent)); //TODO: check if this makes sense
            }
            return sb.toString();
        }
        else
            return "" + boolLiteral;
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
