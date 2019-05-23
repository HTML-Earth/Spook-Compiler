package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.errorhandling.CompilerException;

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
        if (boolOperationsNode != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(boolOperationsNode.prettyPrint(indent)); //TODO: check if this makes sense

            return sb.toString();
        }
        else
            throw new CompilerException("Invalid BoolExpression", codePosition);
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

    public static BoolExpressionNode False() {
        return new BoolExpressionNode(BoolOperationsNode.False());
    }

    public static BoolExpressionNode True() {
        return new BoolExpressionNode(BoolOperationsNode.True());
    }

}
