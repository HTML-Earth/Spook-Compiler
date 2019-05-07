package dk.aau.cs.d403.ast;

import dk.aau.cs.d403.ast.expressions.*;

import java.util.ArrayList;

public class NumberPacking {
    public static ObjectArgumentNode getObjectArgumentFromDouble(double number) {
        return getObjectArgumentFromRealNumber(new RealNumberNode(number));
    }

    public static ObjectArgumentNode getObjectArgumentFromRealNumber(RealNumberNode numberNode) {
        ArrayList<AtomPrecedenceNode> atomPrecedenceNodes = new ArrayList<>();
        atomPrecedenceNodes.add(
                new AtomPrecedenceNode(
                        new ArithOperandNode(
                                numberNode
                        )
                )
        );

        ArrayList<HighPrecedenceNode> highPrecedenceNodes = new ArrayList<>();
        highPrecedenceNodes.add(
                new HighPrecedenceNode(
                        atomPrecedenceNodes
                )
        );

        return new ObjectArgumentNode(
                new LowPrecedenceNode(
                        highPrecedenceNodes
                )
        );
    }
}
