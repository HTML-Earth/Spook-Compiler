package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.CodePosition;

public class SwizzleNode extends ExpressionNode {
    private String variableName;
    private ColorSwizzleNode colorSwizzle;
    private CoordinateSwizzleNode coordinateSwizzle;

    public SwizzleNode(String variableName, CoordinateSwizzleNode coordinateSwizzle) {
        this.variableName = variableName;
        this.coordinateSwizzle = coordinateSwizzle;
    }

    public SwizzleNode(String variableName, ColorSwizzleNode colorSwizzle) {
        this.variableName = variableName;
        this.colorSwizzle = colorSwizzle;
    }

    public String getVariableName() {
        return variableName;
    }

    public ColorSwizzleNode getColorSwizzle() {
        return colorSwizzle;
    }

    public CoordinateSwizzleNode getCoordinateSwizzle() {
        return coordinateSwizzle;
    }

    @Override
    public String prettyPrint() {
        return "Swizzle";
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
