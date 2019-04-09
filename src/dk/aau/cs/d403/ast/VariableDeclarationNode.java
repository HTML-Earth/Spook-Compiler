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

    public DataType dataType;
    public String variableName;

    public VariableDeclarationNode(DataType dataType, String variableName) {
        this.dataType = dataType;
        this.variableName = variableName;
    }

    @Override
    public String prettyPrint() {
        return dataType.toString() + " " + variableName + " = ???;";
    }
}
