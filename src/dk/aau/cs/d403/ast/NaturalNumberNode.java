package dk.aau.cs.d403.ast;

public class NaturalNumberNode implements ASTnode {
    private int number;

    public NaturalNumberNode(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String prettyPrint() {
        return "" + number;
    }
}
