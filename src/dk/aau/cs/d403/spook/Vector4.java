package dk.aau.cs.d403.spook;

public class Vector4 {
    private float x;
    private float y;
    private float z;
    private float w;

    public Vector4(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }

    public static Vector4 zero(){
        return new Vector4(0,0,0,0);
    }

    public static String prettyPrint(Vector4 vector) {
        return "(" + vector.getX() + ", " + vector.getY() + ", " + vector.getZ() + ", " + vector.getW() + ")";
    }
}
