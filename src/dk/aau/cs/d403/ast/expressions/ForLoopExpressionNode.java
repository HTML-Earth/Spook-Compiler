package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.statements.AssignmentNode;
import dk.aau.cs.d403.ast.statements.VariableDeclarationNode;

public class ForLoopExpressionNode extends ExpressionNode {
    private VariableDeclarationNode variableDeclarationNode;
    private String variableName;
    private AssignmentNode assignmentNode;
    private IntegerNumberNode integerNumberNode;

    // Constructors
    public ForLoopExpressionNode(AssignmentNode assignmentNode) {
        this.assignmentNode = assignmentNode;
    }

    public ForLoopExpressionNode(IntegerNumberNode integerNumberNode) {
        this.integerNumberNode = integerNumberNode;
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

    public IntegerNumberNode getIntegerNumberNode() {
        return integerNumberNode;
    }

    @Override
    public String prettyPrint(int indent) {
        if (variableDeclarationNode != null)
            return variableDeclarationNode.prettyPrint(indent);
        else if (variableName != null)
            return variableName;
        else if (assignmentNode != null)
            return assignmentNode.prettyPrint(indent);
        else if (integerNumberNode != null)
            return integerNumberNode.prettyPrint(indent);
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
