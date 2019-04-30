package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.Enums;

public class BoolOperationNode implements ASTnode {
    private String variableName;
    private RealNumberNode realNumberNode;
    private BoolOperationsNode boolOperationsNode;
    private Boolean boolLiteral;

    public BoolOperationNode(String variableName) {
        this.variableName = variableName;
    }

    public BoolOperationNode(RealNumberNode realNumberNode) {
        this.realNumberNode = realNumberNode;
    }

    public BoolOperationNode(BoolOperationsNode boolOperationsNode) {
        this.boolOperationsNode = boolOperationsNode;
    }

    public BoolOperationNode(boolean boolLiteral) {
        this.boolLiteral = boolLiteral;
    }

    public String getVariableName() {
        return variableName;
    }

    public RealNumberNode getRealNumberNode() {
        return realNumberNode;
    }

    public BoolOperationsNode getBoolOperationsNode() {
        return boolOperationsNode;
    }

    public boolean getBoolLiteral() {
        return boolLiteral;
    }

    @Override
    public String prettyPrint() {
        if (variableName != null)
            return variableName;
        else if (realNumberNode != null)
            return realNumberNode.prettyPrint();
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
