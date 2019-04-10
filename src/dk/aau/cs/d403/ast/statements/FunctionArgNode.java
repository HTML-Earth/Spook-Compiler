package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.statements.VariableDeclarationNode.DataType;

public class FunctionArgNode implements ASTnode {
    private DataType dataType;
    private String variableName;

    public FunctionArgNode(DataType dataType, String variableName) {
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
        return "Function args";
    }
}
