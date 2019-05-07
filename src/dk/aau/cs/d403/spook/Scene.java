package dk.aau.cs.d403.spook;

import dk.aau.cs.d403.ast.NumberPacking;
import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.spook.color.Color;
import dk.aau.cs.d403.spook.color.Colorable;

import java.util.ArrayList;

public class Scene extends SpookObject implements Colorable {
    Vector4 color;

    public Scene() {
        children = new ArrayList<>();
        color = Color.magenta();
    }

    public Vector2 getPosition() {
        return new Vector2(0,0);
    }

    public void setPosition(Vector2 position) {
        throw new RuntimeException("Scene position cannot be changed");
    }

    public ObjectArgumentNode getRotation() {
        return NumberPacking.getObjectArgumentFromFloat(0);
    }

    public void setRotation(ObjectArgumentNode rotation) {
        throw new RuntimeException("Scene rotation cannot be changed");
    }

    @Override
    public void setParent(SpookObject parent)
    {
        throw new RuntimeException("Cannot set Scene's parent");
    }

    @Override
    public SpookObject getParent() {
        return null;
    }

    @Override
    public String getDeclaration() {
        throw new RuntimeException("Scene should not be declared");
    }

    @Override
    public Vector4 getColor() {
        return color;
    }

    @Override
    public void setColor(Vector4 color) {
        this.color = color;
    }
}
