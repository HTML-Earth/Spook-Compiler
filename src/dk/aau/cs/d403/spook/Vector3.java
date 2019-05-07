package dk.aau.cs.d403.spook;

import dk.aau.cs.d403.ast.NumberPacking;
import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;
import dk.aau.cs.d403.ast.expressions.RealNumberNode;

public class Vector3 {
    private ObjectArgumentNode x;
    private ObjectArgumentNode y;
    private ObjectArgumentNode z;

    public Vector3(ObjectArgumentNode x, ObjectArgumentNode y, ObjectArgumentNode z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3(double x, double y, double z) {
        this.x = NumberPacking.getObjectArgumentFromDouble(x);
        this.y = NumberPacking.getObjectArgumentFromDouble(y);
        this.z = NumberPacking.getObjectArgumentFromDouble(z);
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

    public static Vector3 zero(){
        RealNumberNode zero = new RealNumberNode(0);
        ObjectArgumentNode x = NumberPacking.getObjectArgumentFromRealNumber(zero);
        ObjectArgumentNode y = NumberPacking.getObjectArgumentFromRealNumber(zero);
        ObjectArgumentNode z = NumberPacking.getObjectArgumentFromRealNumber(zero);
        return new Vector3(x,y,z);
    }

    public static String GLSLPrint(Vector3 vector) {
        return "(" +
                vector.getX().prettyPrint(0) + ", " +
                vector.getY().prettyPrint(0) + ", " +
                vector.getZ().prettyPrint(0) + ")";
    }
}
