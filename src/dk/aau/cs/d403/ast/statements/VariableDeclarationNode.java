package dk.aau.cs.d403.ast.statements;

public class VariableDeclarationNode extends StatementNode {

    public enum DataType {
        INT,
        FLOAT,
        BOOL,
        VEC2,
        VEC3,
        VEC4
    }

    private DataType dataType;
    private String variableName;
    private AssignmentNode assignmentNode;

    public VariableDeclarationNode(DataType dataType, String variableName) {
        this.dataType = dataType;
        this.variableName = variableName;
    }

    public VariableDeclarationNode(DataType dataType, AssignmentNode assignmentNode) {
        this.dataType = dataType;
        this.variableName = assignmentNode.getVariableName();
        this.assignmentNode = assignmentNode;
    }

    public DataType getDataType() {
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
            return dataType.toString() + " " + assignmentNode.prettyPrint();
        else
            return dataType.toString() + " " + variableName + ";";
    }
}
