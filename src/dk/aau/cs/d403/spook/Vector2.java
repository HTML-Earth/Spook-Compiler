package dk.aau.cs.d403.spook;

public class Vector2 {
    private float x;
    private float y;

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
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

    public static Vector2 zero(){
        return new Vector2(0,0);
    }

    public static String prettyPrint(Vector2 vector) {
        return "(" + vector.getX() + ", " + vector.getY() + ")";
    }
}
