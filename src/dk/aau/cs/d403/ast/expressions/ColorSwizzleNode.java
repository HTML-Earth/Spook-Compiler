package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.CodePosition;

public class ColorSwizzleNode extends ExpressionNode {
    private String swizzle;

    public ColorSwizzleNode(String swizzle) {
        this.swizzle = swizzle;
    }

    public String getSwizzle() {
        return swizzle;
    }

    @Override
    public String prettyPrint(int indent) {
        return swizzle;
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
