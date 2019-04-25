package dk.aau.cs.d403.spook;

import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;
import dk.aau.cs.d403.ast.expressions.RealNumberNode;

public class Vector2 {
    private ObjectArgumentNode x;
    private ObjectArgumentNode y;

    public Vector2(ObjectArgumentNode x, ObjectArgumentNode y) {
        this.x = x;
        this.y = y;
    }


    public Vector2(float x, float y) {
        this.x = new ObjectArgumentNode(new RealNumberNode(x));
        this.y = new ObjectArgumentNode(new RealNumberNode(y));
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
        ObjectArgumentNode x = new ObjectArgumentNode(zero);
        ObjectArgumentNode y = new ObjectArgumentNode(zero);
        return new Vector2(x,y);
    }

    public static String GLSLPrint(Vector2 vector) {
        return "(" +
                vector.getX().prettyPrint() + ", " +
                vector.getY().prettyPrint() + ")";
    }
}
