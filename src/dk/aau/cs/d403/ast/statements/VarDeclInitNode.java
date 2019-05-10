package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.CompilerException;
import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;

public class VarDeclInitNode implements ASTnode {
    private String variableName;
    private AssignmentNode assignmentNode;

    public VarDeclInitNode(String variableName) {
        this.variableName = variableName;
    }

    public VarDeclInitNode(AssignmentNode assignmentNode) {
        this.assignmentNode = assignmentNode;
    }

    public String getVariableName() {
        return variableName;
    }

    public AssignmentNode getAssignmentNode() {
        return assignmentNode;
    }

    @Override
    public String prettyPrint() {
        if (variableName != null)
            return variableName;
        else if (assignmentNode != null)
            return assignmentNode.prettyPrint();
        else
            throw new CompilerException("Invalid Variable Declaration initialization", codePosition);
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
