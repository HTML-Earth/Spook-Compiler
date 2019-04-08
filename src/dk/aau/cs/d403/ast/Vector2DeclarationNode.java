package dk.aau.cs.d403.ast;

public class Vector2DeclarationNode extends VariableDeclarationNode {
    String variableName;
    float value0;
    float value1;

    Vector2DeclarationNode(String variableName, float value0, float value1) {
        this.variableName = variableName;
        this.value0 = value0;
        this.value1 = value1;
    }

    @Override
    public String prettyPrint() {
        return "vector2 " + variableName + " = (" + value0 + ", " + value1 + ");\n";
    }
}
