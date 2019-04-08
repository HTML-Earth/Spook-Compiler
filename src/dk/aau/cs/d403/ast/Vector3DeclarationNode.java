package dk.aau.cs.d403.ast;

public class Vector3DeclarationNode extends VariableDeclarationNode {
    String variableName;
    float value0;
    float value1;
    float value2;

    Vector3DeclarationNode(String variableName, float value0, float value1, float value2) {
        this.variableName = variableName;
        this.value0 = value0;
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public String prettyPrint() {
        return "vector3 " + variableName + " = (" + value0 + ", " + value1 + ", " + value2 + ");";
    }
}
