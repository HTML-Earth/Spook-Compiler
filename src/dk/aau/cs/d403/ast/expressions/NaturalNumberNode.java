package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;

public class NaturalNumberNode implements ASTnode {
    private int number;

    public NaturalNumberNode(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String prettyPrint() {
        return "" + number;
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
