package dk.aau.cs.d403.ast;

public class FloatDeclarationNode extends VariableDeclarationNode {
    private String variableName;
    private float value;

    FloatDeclarationNode(String variableName, float value) {
        this.variableName = variableName;
        this.value = value;
    }

    @Override
    public String prettyPrint() {
        return "Float " + variableName + " = " + value + ";";
    }
}
