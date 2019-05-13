package dk.aau.cs.d403.spook;

import dk.aau.cs.d403.CompilerException;
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
    protected Vector2 scale;

    protected SpookObject parent = null;
    protected ArrayList<SpookObject> children = new ArrayList<>();

    public Enums.ClassType getClassType() {
        return classType;
    }

    public String getName() {
        return name;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getWorldPosition() {
        if (getParent() != null)
            return Vector2.add(getPosition(), getParent().getWorldPosition());
        else
            return getPosition();
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setPosition(ArrayList<ObjectArgumentNode> objectArgumentNodes) {
        if (objectArgumentNodes != null){
            if (objectArgumentNodes.size() == 1){
                setPosition(Vector2.evaluateLowPrecedence(objectArgumentNodes.get(0).getLowPrecedence()));
            }
            else if (objectArgumentNodes.size() == 2) {
                ObjectArgumentNode xPos = objectArgumentNodes.get(0);
                ObjectArgumentNode yPos = objectArgumentNodes.get(1);
                setPosition(new Vector2(xPos, yPos));
            }
            else {
                if (objectArgumentNodes.size() > 0) {
                    throw new CompilerException("Invalid amount of arguments for setPosition() (" + objectArgumentNodes.size() + ")", objectArgumentNodes.get(0).getCodePosition());
                }
                else {
                    throw new CompilerException("Invalid amount of arguments for setPosition() (" + objectArgumentNodes.size() + ")");
                }
            }
        }
        else {
            throw new CompilerException("Argument list for setPosition is null");
        }
    }

    public ObjectArgumentNode getRotation() {
        return rotation;
    }

    public void setScale(Vector2 scale) {
        this.scale = scale;
    }

    public void setScale(ArrayList<ObjectArgumentNode> objectArgumentNodes) {
        if (objectArgumentNodes != null){
            if (objectArgumentNodes.size() == 1){
                setScale(Vector2.evaluateLowPrecedence(objectArgumentNodes.get(0).getLowPrecedence()));
            }
            else if (objectArgumentNodes.size() == 2) {
                ObjectArgumentNode xPos = objectArgumentNodes.get(0);
                ObjectArgumentNode yPos = objectArgumentNodes.get(1);
                setScale(new Vector2(xPos, yPos));
            }
            else {
                if (objectArgumentNodes.size() > 0) {
                    throw new CompilerException("Invalid amount of arguments for setScale() (" + objectArgumentNodes.size() + ")", objectArgumentNodes.get(0).getCodePosition());
                }
                else {
                    throw new CompilerException("Invalid amount of arguments for setScale() (" + objectArgumentNodes.size() + ")");
                }
            }
        }
        else {
            throw new CompilerException("Argument list for setScale is null");
        }
    }

    public Vector2 getScale() {
        return scale;
    }

    public void setRotation(ObjectArgumentNode rotation) {
        this.rotation = rotation;
    }

    public void setRotation(ArrayList<ObjectArgumentNode> objectArgumentNodes) {
        if (objectArgumentNodes != null){
            if (objectArgumentNodes.size() == 1){
                setRotation(objectArgumentNodes.get(0));
            }
            else {
                if (objectArgumentNodes.size() > 0) {
                    throw new CompilerException("Invalid amount of arguments for setRotation() (" + objectArgumentNodes.size() + ")", objectArgumentNodes.get(0).getCodePosition());
                }
                else {
                    throw new CompilerException("Invalid amount of arguments for setRotation() (" + objectArgumentNodes.size() + ")");
                }
            }
        }
        else {
            throw new CompilerException("Argument list for setRotation is null");
        }
    }

    public void setParent(SpookObject parent)
    {
        if (parent != this.parent) {
            if (this.parent != null) {
                this.parent.remove(this);
            }

            this.parent = parent;
            parent.add(this);
        }
    }

    public void add(SpookObject spookObject) {
        if (!children.contains(spookObject))
            children.add(spookObject);
    }

    public void remove(SpookObject spookObject) {
        if (children.contains(spookObject))
            children.remove(spookObject);
    }

    public SpookObject getParent() {
        return parent;
    }

    public ArrayList<SpookObject> getChildren() {
        return children;
    }


    public abstract String getDeclaration();

    public static Class getClassFromClassType(String className) {
        String packagePath = "dk.aau.cs.d403.spook.shapes";
        try {
            return Class.forName(packagePath + "." + className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

            return Shape.class;
        }
    }
}
