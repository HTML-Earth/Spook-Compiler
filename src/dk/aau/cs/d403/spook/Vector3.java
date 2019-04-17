package dk.aau.cs.d403.spook;

public class Vector3 {
    private float x;
    private float y;
    private float z;

    public Vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
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

    public static Vector3 zero(){
        return new Vector3(0,0,0);
    }

    public static String prettyPrint(Vector3 vector) {
        return "(" + vector.getX() + ", " + vector.getY() + ", " + vector.getZ() + ")";
    }
}
