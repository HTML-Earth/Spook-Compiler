package dk.aau.cs.d403.ast;

public class FloatDigitNode extends RealNumberNode {

    float numberValue;

    FloatDigitNode(float value) {
        numberValue = value;
    }

    @Override
    public String prettyPrint() {
        return "" + numberValue;
    }

    public float getNumberValue() {
        return numberValue;
    }
}
