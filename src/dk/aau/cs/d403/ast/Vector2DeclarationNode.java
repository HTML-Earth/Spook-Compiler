package dk.aau.cs.d403.ast;

public class Vector2DeclarationNode extends VariableDeclarationNode {
    private String variableName;
    private float value0;
    private float value1;

    Vector2DeclarationNode(String variableName, float value0, float value1) {
        this.variableName = variableName;
        this.value0 = value0;
        this.value1 = value1;
    }

    @Override
    public String prettyPrint() {
        return "Vec2 " + variableName + " = (" + value0 + ", " + value1 + ");";
    }
}
