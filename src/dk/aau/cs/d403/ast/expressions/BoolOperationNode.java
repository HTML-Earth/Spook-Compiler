package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.statements.NonObjectFunctionCallNode;
import dk.aau.cs.d403.ast.statements.ObjectFunctionCallNode;

public class BoolOperationNode implements ASTnode {
    private BoolOperationsNode boolOperationsNode;
    private Boolean boolLiteral;
    private NonObjectFunctionCallNode nonObjectFunctionCallNode;
    private ObjectFunctionCallNode objectFunctionCallNode;

    public BoolOperationNode(NonObjectFunctionCallNode nonObjectFunctionCallNode) {
        this.nonObjectFunctionCallNode = nonObjectFunctionCallNode;
    }

    public BoolOperationNode(ObjectFunctionCallNode objectFunctionCallNode) {
        this.objectFunctionCallNode = objectFunctionCallNode;
    }

    public BoolOperationNode(BoolOperationsNode boolOperationsNode) {
        this.boolOperationsNode = boolOperationsNode;
    }

    public BoolOperationNode(boolean boolLiteral) {
        this.boolLiteral = boolLiteral;
    }

    public ObjectFunctionCallNode getObjectFunctionCallNode() {
        return objectFunctionCallNode;
    }

    public NonObjectFunctionCallNode getNonObjectFunctionCallNode() {
        return nonObjectFunctionCallNode;
    }

    public BoolOperationsNode getBoolOperationsNode() {
        return boolOperationsNode;
    }

    public boolean getBoolLiteral() {
        return boolLiteral;
    }

    @Override
    public String prettyPrint() {
        if (objectFunctionCallNode != null)
            return objectFunctionCallNode.prettyPrint();
        else if (nonObjectFunctionCallNode != null)
            return nonObjectFunctionCallNode.prettyPrint();
        else if (boolOperationsNode != null)
            return boolOperationsNode.prettyPrint();
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
