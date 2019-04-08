package dk.aau.cs.d403.ast;

public class BoolDeclarationNode extends VariableDeclarationNode {
    private String variableName;
    private boolean value;

    BoolDeclarationNode(String variableName, boolean value) {
        this.variableName = variableName;
        this.value = value;
    }
    @Override
    public String prettyPrint() {
        return "bool " + variableName + " = " + value + ";";
    }
}
