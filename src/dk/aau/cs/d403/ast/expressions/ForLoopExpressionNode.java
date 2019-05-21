package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.statements.AssignmentNode;
import dk.aau.cs.d403.ast.statements.VariableDeclarationNode;

public class ForLoopExpressionNode extends ExpressionNode {
    private VariableDeclarationNode variableDeclarationNode;
    private AssignmentNode assignmentNode;
    private AtomPrecedenceNode atomPrecedenceNode;

    // Constructors
    public ForLoopExpressionNode(AssignmentNode assignmentNode) {
        this.assignmentNode = assignmentNode;
    }

    public ForLoopExpressionNode(AtomPrecedenceNode atomPrecedenceNode) {
        this.atomPrecedenceNode = atomPrecedenceNode;
    }

    public ForLoopExpressionNode(VariableDeclarationNode variableDeclarationNode) {
        this.variableDeclarationNode = variableDeclarationNode;
    }

    public VariableDeclarationNode getVariableDeclarationNode() {
        return variableDeclarationNode;
    }

    // Getters
    public AssignmentNode getAssignmentNode() {
        return assignmentNode;
    }

    public AtomPrecedenceNode getAtomPrecedenceNode() {
        return atomPrecedenceNode;
    }

    @Override
    public String prettyPrint(int indent) {
        if (variableDeclarationNode != null)
            return variableDeclarationNode.prettyPrint(indent);
        else if (assignmentNode != null)
            return assignmentNode.prettyPrint(indent);
        else if (atomPrecedenceNode != null)
            return atomPrecedenceNode.prettyPrint(indent);
        else
            return "Invalid ForLoop Expression";
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
