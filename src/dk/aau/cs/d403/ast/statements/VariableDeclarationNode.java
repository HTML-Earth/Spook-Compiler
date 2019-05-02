package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.Enums;

public class VariableDeclarationNode extends DeclarationNode {
    private Enums.DataType dataType;
    private String variableName;
    private AssignmentNode assignmentNode;

    public VariableDeclarationNode(Enums.DataType dataType, String variableName) {
        this.dataType = dataType;
        this.variableName = variableName;
    }

    public VariableDeclarationNode(Enums.DataType dataType, AssignmentNode assignmentNode) {
        this.dataType = dataType;
        this.variableName = assignmentNode.getVariableName();
        this.assignmentNode = assignmentNode;
    }

    public Enums.DataType getDataType() {
        return dataType;
    }

    public String getVariableName() {
        return variableName;
    }

    public AssignmentNode getAssignmentNode() {
        return assignmentNode;
    }

    @Override
    public String prettyPrint(int indent) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < indent; i++)
            sb.append("\t");

        if (assignmentNode != null)
            sb.append(Enums.dataTypeToStringSpook(dataType) + " " + assignmentNode.prettyPrint(0));
        else
            sb.append(Enums.dataTypeToStringSpook(dataType) + " " + variableName);

        return sb.toString();
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
