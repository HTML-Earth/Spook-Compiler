package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.statements.AssignmentNode;
import dk.aau.cs.d403.ast.statements.VariableDeclarationNode;

public class ForLoopExpressionNode extends ExpressionNode {
    private VariableDeclarationNode variableDeclarationNode;
    private String variableName;
    private AssignmentNode assignmentNode;
    private int number;

    // Constructors
    public ForLoopExpressionNode(AssignmentNode assignmentNode) {
        this.assignmentNode = assignmentNode;
    }

    public ForLoopExpressionNode(int number) {
        this.number = number;
    }

    public ForLoopExpressionNode(VariableDeclarationNode variableDeclarationNode) {
        this.variableDeclarationNode = variableDeclarationNode;
    }

    public ForLoopExpressionNode(String variableName) {
        this.variableName = variableName;
    }

    public VariableDeclarationNode getVariableDeclarationNode() {
        return variableDeclarationNode;
    }

    // Getters
    public String getVariableName() {
        return variableName;
    }

    public AssignmentNode getAssignmentNode() {
        return assignmentNode;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String prettyPrint() {
        return "ForLoop Expression";
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
