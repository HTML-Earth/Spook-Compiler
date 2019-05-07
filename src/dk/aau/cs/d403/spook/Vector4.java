package dk.aau.cs.d403.spook;

import dk.aau.cs.d403.ast.NumberPacking;
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

    public Vector4(double x, double y, double z, double w) {
        this.x = NumberPacking.getObjectArgumentFromDouble(x);
        this.y = NumberPacking.getObjectArgumentFromDouble(y);
        this.z = NumberPacking.getObjectArgumentFromDouble(z);
        this.w = NumberPacking.getObjectArgumentFromDouble(w);
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
        ObjectArgumentNode x = NumberPacking.getObjectArgumentFromRealNumber(zero);
        ObjectArgumentNode y = NumberPacking.getObjectArgumentFromRealNumber(zero);
        ObjectArgumentNode z = NumberPacking.getObjectArgumentFromRealNumber(zero);
        ObjectArgumentNode w = NumberPacking.getObjectArgumentFromRealNumber(zero);
        return new Vector4(x,y,z,w);
    }

    public static String GLSLPrint(Vector4 vector) {
        return "(" +
                vector.getX().prettyPrint(0) + ", " +
                vector.getY().prettyPrint(0) + ", " +
                vector.getZ().prettyPrint(0) + ", " +
                vector.getW().prettyPrint(0) + ")";
    }
}
