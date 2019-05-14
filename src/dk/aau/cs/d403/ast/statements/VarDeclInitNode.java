package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.CompilerException;
import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.expressions.ExpressionNode;

public class VarDeclInitNode implements ASTnode {
    private AssignmentNode assignmentNode; //Is always initialized, if nothing is parsed in becomes 0, false or null as it does in GLSL

    public VarDeclInitNode(String variableName, ExpressionNode expressionNode) {
        this.assignmentNode = new AssignmentNode(variableName, expressionNode);
    }

    public VarDeclInitNode(AssignmentNode assignmentNode) {
        this.assignmentNode = assignmentNode;
    }

    public AssignmentNode getAssignmentNode() {
        return assignmentNode;
    }

    @Override
    public String prettyPrint(int indent) {

        if (assignmentNode != null)
            return assignmentNode.prettyPrint(indent);
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
