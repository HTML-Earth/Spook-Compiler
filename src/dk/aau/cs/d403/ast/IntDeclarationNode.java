package dk.aau.cs.d403.ast;

public class IntDeclarationNode extends VariableDeclarationNode {
    private String variableName;
    private int value;

    IntDeclarationNode(String variableName, int value) {
        this.variableName = variableName;
        this.value = value;
    }

    @Override
    public String prettyPrint() {
        return "Int " + variableName + " = " + value + ";";
    }
}
