package dk.aau.cs.d403.ast;

public class FloatDeclarationNode extends VariableDeclarationNode {
    String variableName;
    float value;

    FloatDeclarationNode(String variableName, float value) {
        this.variableName = variableName;
        this.value = value;
    }

    @Override
    public String prettyPrint() {
        return "float " + variableName + " = " + value + ";";
    }
}
