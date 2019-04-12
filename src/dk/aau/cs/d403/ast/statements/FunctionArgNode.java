package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.Enums;

public class FunctionArgNode implements ASTnode {
    private Enums.DataType dataType;
    private String variableName;

    public FunctionArgNode(Enums.DataType dataType, String variableName) {
        this.dataType = dataType;
        this.variableName = variableName;
    }

    public Enums.DataType getDataType() {
        return dataType;
    }

    public String getVariableName() {
        return variableName;
    }

    @Override
    public String prettyPrint() {
        return "Function args";
    }

    @Override
    public String toString() {
        return getDataType() + " " + getVariableName() + ", ";
    }
}
