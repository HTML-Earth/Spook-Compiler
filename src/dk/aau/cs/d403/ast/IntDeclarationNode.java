package dk.aau.cs.d403.ast;

public class IntDeclarationNode extends VariableDeclarationNode {
    String variableName;
    int value;

    IntDeclarationNode(String variableName, int value) {
        this.variableName = variableName;
        this.value = value;
    }

    @Override
    public String prettyPrint() {
        return "int " + variableName + " = " + value + ";\n";
    }
}
