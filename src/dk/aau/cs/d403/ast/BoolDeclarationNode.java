package dk.aau.cs.d403.ast;

public class BoolDeclarationNode extends VariableDeclarationNode {
    String variableName;
    boolean value;

    BoolDeclarationNode(String variableName, boolean value) {
        this.variableName = variableName;
        this.value = value;
    }
    @Override
    public String prettyPrint() {
        return null;
    }
}
