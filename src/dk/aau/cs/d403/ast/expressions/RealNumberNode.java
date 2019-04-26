package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;

public class RealNumberNode implements ASTnode {
    private float number;

    public RealNumberNode(float number) {
        this.number = number;
    }

    public float getNumber() {
        return number;
    }

    @Override
    public String prettyPrint() {
        return String.valueOf(number);
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
