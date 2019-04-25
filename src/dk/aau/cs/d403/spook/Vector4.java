package dk.aau.cs.d403.spook;

import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;
import dk.aau.cs.d403.ast.expressions.RealNumberNode;

public class Vector4 {
    private ObjectArgumentNode x;
    private ObjectArgumentNode y;
    private ObjectArgumentNode z;
    private ObjectArgumentNode w;

    public Vector4(ObjectArgumentNode x, ObjectArgumentNode y, ObjectArgumentNode z, ObjectArgumentNode w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vector4(float x, float y, float z, float w) {
        this.x = new ObjectArgumentNode(new RealNumberNode(x));
        this.y = new ObjectArgumentNode(new RealNumberNode(y));
        this.z = new ObjectArgumentNode(new RealNumberNode(z));
        this.w = new ObjectArgumentNode(new RealNumberNode(w));
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

    public ObjectArgumentNode getZ() {
        return z;
    }

    public void setZ(ObjectArgumentNode z) {
        this.z = z;
    }

    public ObjectArgumentNode getW() {
        return w;
    }

    public void setW(ObjectArgumentNode w) {
        this.w = w;
    }

    public static Vector4 zero(){
        RealNumberNode zero = new RealNumberNode(0);
        ObjectArgumentNode x = new ObjectArgumentNode(zero);
        ObjectArgumentNode y = new ObjectArgumentNode(zero);
        ObjectArgumentNode z = new ObjectArgumentNode(zero);
        ObjectArgumentNode w = new ObjectArgumentNode(zero);
        return new Vector4(x,y,z,w);
    }

    public static String GLSLPrint(Vector4 vector) {
        return "(" +
                vector.getX().prettyPrint() + ", " +
                vector.getY().prettyPrint() + ", " +
                vector.getZ().prettyPrint() + ", " +
                vector.getW().prettyPrint() + ")";
    }
}
