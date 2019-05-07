package dk.aau.cs.d403.spook;

import dk.aau.cs.d403.ast.NumberPacking;
import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;
import dk.aau.cs.d403.ast.expressions.RealNumberNode;

public class Vector2 {
    private ObjectArgumentNode x;
    private ObjectArgumentNode y;

    public Vector2(ObjectArgumentNode x, ObjectArgumentNode y) {
        this.x = x;
        this.y = y;
    }


    public Vector2(double x, double y) {
        this.x = NumberPacking.getObjectArgumentFromDouble(x);
        this.y = NumberPacking.getObjectArgumentFromDouble(y);
    }

    public ObjectArgumentNode getX() {
        return x;
    }

    public void setX(ObjectArgumentNode x) {
        this.x = x;
    }

    public ObjectArgumentNode getY() {
        return y;
    }

    public void setY(ObjectArgumentNode y) {
        this.y = y;
    }

    public static Vector2 zero(){
        RealNumberNode zero = new RealNumberNode(0);
        ObjectArgumentNode x = NumberPacking.getObjectArgumentFromRealNumber(zero);
        ObjectArgumentNode y = NumberPacking.getObjectArgumentFromRealNumber(zero);
        return new Vector2(x,y);
    }

    public static Vector2 add(Vector2 a, Vector2 b) {
        return new Vector2(ObjectArgumentNode.add(a.getX(), b.getX()), ObjectArgumentNode.add(a.getY(), b.getY()));
    }

    public static String GLSLPrint(Vector2 vector) {
        return "(" +
                vector.getX().prettyPrint(0) + ", " +
                vector.getY().prettyPrint(0) + ")";
    }
}
