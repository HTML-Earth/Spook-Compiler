package dk.aau.cs.d403.spook;

import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;

import java.util.ArrayList;

public abstract class SpookObject {
    protected String name;
    protected Vector2 position;
    protected ObjectArgumentNode rotation;

    protected SpookObject parent;
    protected ArrayList<SpookObject> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public ObjectArgumentNode getRotation() {
        return rotation;
    }

    public void setRotation(ObjectArgumentNode rotation) {
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

    public abstract String getDeclaration();
}
