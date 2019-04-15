package dk.aau.cs.d403.spook;

import java.util.ArrayList;

public abstract class SpookObject {
    private Vector2 position;
    private float rotation;

    private SpookObject parent;
    private ArrayList<SpookObject> children;

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public SpookObject getParent() {
        return parent;
    }

    public ArrayList<SpookObject> getChildren() {
        return children;
    }

    public void add(SpookObject spookObject) {
        children.add(spookObject);
    }
}
