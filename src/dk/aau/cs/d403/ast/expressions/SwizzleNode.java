package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.errorhandling.CompilerException;

public class SwizzleNode extends ExpressionNode {
    private String variableName;
    private String swizzle;

    public SwizzleNode(String variableName, String swizzle) {
        this.variableName = variableName;
        this.swizzle = swizzle;
    }

    public String getVariableName() {
        return variableName;
    }

    public String getSwizzle() {
        return swizzle;
    }

    @Override
    public String prettyPrint(int indent) {
        if (swizzle != null)
            return variableName + "." + swizzle;
        else
            return "Invalid swizzle";
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

    public int getFirstCoordinate() {
        return charToCoordinate(swizzle.charAt(0));
    }

    public int getSecondCoordinate() {
        return charToCoordinate(swizzle.charAt(1));
    }

    public int getThirdCoordinate() {
        return charToCoordinate(swizzle.charAt(2));
    }

    public int getFourthCoordinate() {
        return charToCoordinate(swizzle.charAt(3));
    }

    private int charToCoordinate(char c) {
        switch (c) {
            case 'x': case 'r':
                return 0;
            case 'y': case 'g':
                return 1;
            case 'z': case 'b':
                return 2;
            case 'w': case 'a':
                return 3;
            default:
                throw new CompilerException("Invalid swizzle char (" + c + ")");
        }
    }
}
