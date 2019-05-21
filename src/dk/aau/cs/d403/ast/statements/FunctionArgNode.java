package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.Enums;

public class FunctionArgNode implements ASTnode {
    private Enums.DataType dataType;
    private String variableName;
    private String className;

    public FunctionArgNode(String className, String variableName) {
        this.className = className;
        this.variableName = variableName;
    }

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

    public String getClassName() {
        return className;
    }

    @Override
    public String prettyPrint(int indent) {
        if (dataType != null)
            return Enums.dataTypeToStringSpook(dataType) + " " + variableName;
        else if (className != null)
            return className + " " + variableName;
        else
            return "Invalid type or class";
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
