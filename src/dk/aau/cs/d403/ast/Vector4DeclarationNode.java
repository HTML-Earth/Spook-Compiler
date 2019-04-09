package dk.aau.cs.d403.ast;

public class Vector4DeclarationNode extends VariableDeclarationNode {
    private String variableName;
    private float value0;
    private float value1;
    private float value2;
    private float value3;

    Vector4DeclarationNode(String variableName, float value0, float value1, float value2, float value3) {
        this.variableName = variableName;
        this.value0 = value0;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    @Override
    public String prettyPrint() {
        return "Vec4 " + variableName + " = (" + value0 + ", " + value1 + ", " + value2 + ", " + value3 + ");";
    }
}
