package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.statements.AssignmentNode;
import dk.aau.cs.d403.ast.statements.VariableDeclarationNode;

public class ForLoopExpressionNode extends ExpressionNode {
    private VariableDeclarationNode variableDeclarationNode;
    private String variableName;
    private AssignmentNode assignmentNode;
    private RealNumberNode realNumberNode;

    // Constructors
    public ForLoopExpressionNode(AssignmentNode assignmentNode) {
        this.assignmentNode = assignmentNode;
    }

    public ForLoopExpressionNode(RealNumberNode realNumberNode) {
        this.realNumberNode = realNumberNode;
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

    public RealNumberNode getRealNumberNode() {
        return realNumberNode;
    }

    @Override
    public String prettyPrint() {
        if (variableDeclarationNode != null)
            return variableDeclarationNode.prettyPrint();
        else if (variableName != null)
            return variableName;
        else if (assignmentNode != null)
            return assignmentNode.prettyPrint();
        else if (realNumberNode != null)
            return realNumberNode.prettyPrint();
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
