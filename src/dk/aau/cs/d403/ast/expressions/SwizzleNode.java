package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.CodePosition;

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
}
