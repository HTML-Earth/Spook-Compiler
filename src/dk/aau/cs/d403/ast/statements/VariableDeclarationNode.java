package dk.aau.cs.d403.ast.statements;

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
    public String prettyPrint() {
        if (assignmentNode != null)
            return Enums.dataTypeToStringSpook(dataType) + " " + assignmentNode.prettyPrint();
        else
            return Enums.dataTypeToStringSpook(dataType) + " " + variableName + ";";
    }
}
