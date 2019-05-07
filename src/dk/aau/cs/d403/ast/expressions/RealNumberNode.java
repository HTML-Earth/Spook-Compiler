package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;

public class RealNumberNode implements ASTnode {
    private double number;

    public RealNumberNode(double number) {
        this.number = number;
    }

    public double getNumber() {
        return number;
    }

    @Override
    public String prettyPrint(int indent) {
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
