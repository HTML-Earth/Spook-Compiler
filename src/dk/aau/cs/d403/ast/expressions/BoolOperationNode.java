package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;

public class BoolOperationNode implements ASTnode {
    private BoolOperationsNode boolOperationsNode;
    private Boolean boolLiteral;

    public BoolOperationNode(BoolOperationsNode boolOperationsNode) {
        this.boolOperationsNode = boolOperationsNode;
    }

    public BoolOperationNode(boolean boolLiteral) {
        this.boolLiteral = boolLiteral;
    }

    public BoolOperationsNode getBoolOperationsNode() {
        return boolOperationsNode;
    }

    public Boolean getBoolLiteral() {
        return boolLiteral;
    }

    @Override
    public String prettyPrint(int indent) {
        if (boolOperationsNode != null)
            return boolOperationsNode.prettyPrint(indent);
        else if (boolLiteral != null)
            return boolLiteral.toString();
        else
            return "Invalid BoolOperationNode";
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
