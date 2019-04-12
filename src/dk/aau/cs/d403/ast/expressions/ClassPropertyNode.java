package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.Enums;

public class ClassPropertyNode implements ASTnode {
    private Enums.ClassType classType;
    private String variableName;

    public ClassPropertyNode(Enums.ClassType classType, String variableName) {
        this.classType = classType;
        this.variableName = variableName;
    }

    public Enums.ClassType getClassType() {
        return classType;
    }

    public String getVariableName() {
        return variableName;
    }

    @Override
    public String prettyPrint() {
        return Enums.classTypeToString(classType) + "." + variableName;
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
