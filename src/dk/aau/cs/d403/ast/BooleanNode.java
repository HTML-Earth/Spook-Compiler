package dk.aau.cs.d403.ast;

public class BooleanNode implements ASTnode {
    boolean value;

    BooleanNode(boolean value) {
        this.value = value;
    }

    @Override
    public String prettyPrint() {
        return null;
    }
}
