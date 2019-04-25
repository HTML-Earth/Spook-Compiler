package dk.aau.cs.d403.spook;

import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;
import dk.aau.cs.d403.spook.shapes.Rectangle;
import dk.aau.cs.d403.spook.shapes.Shape;

import java.util.ArrayList;

public abstract class SpookObject {
    protected Enums.ClassType classType;
    protected String name;
    protected Vector2 position;
    protected ObjectArgumentNode rotation;

    protected SpookObject parent;
    protected ArrayList<SpookObject> children;

    public Enums.ClassType getClassType() {
        return classType;
    }

    public String getName() {
        return name;
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

    public static Class getClassFromClassType(Enums.ClassType classType) {
        String className;
        String packagePath = "dk.aau.cs.d403.spook.shapes";

        switch (classType) {
            case CIRCLE:
                className = "Circle";
                break;
            case RECTANGLE:
                className = "Rectangle";
                break;
            case SQUARE:
                className = "Square";
                break;
            case TRIANGLE:
                className = "Triangle";
                break;
            default:
                throw new RuntimeException(classType.toString() + " unavailable");
        }

        try {
            return Class.forName(packagePath + "." + className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

            return Shape.class;
        }
    }
}
