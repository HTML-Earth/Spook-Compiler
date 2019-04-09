package dk.aau.cs.d403.ast;

public class RealNumberNode implements ASTnode {
    private float number;

    public RealNumberNode(int number) {
        this.number = number;
    }

    public float getNumber() {
        return number;
    }

    @Override
    public String prettyPrint() {
        return "" + number;
    }
}
