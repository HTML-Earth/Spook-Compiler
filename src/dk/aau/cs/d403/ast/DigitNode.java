package dk.aau.cs.d403.ast;

public class DigitNode extends RealNumberNode {

    int numberValue;

    DigitNode(int value) {
        numberValue = value;
    }

    @Override
    public String prettyPrint() {
        return "" + numberValue;
    }
}
