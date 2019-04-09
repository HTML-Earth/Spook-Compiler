package dk.aau.cs.d403.ast;

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

    public VariableDeclarationNode(DataType dataType, String variableName) {
        this.dataType = dataType;
        this.variableName = variableName;
    }

    public DataType getDataType() {
        return dataType;
    }

    public String getVariableName() {
        return variableName;
    }

    @Override
    public String prettyPrint() {
        return dataType.toString() + " " + variableName + " = ???;";
    }
}
