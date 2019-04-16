package dk.aau.cs.d403.spook;

import dk.aau.cs.d403.spook.color.Colorable;

import java.util.ArrayList;

public class Scene extends SpookObject implements Colorable {
    public Scene() {
        children = new ArrayList<>();
    }

    public Vector2 getPosition() {
        return new Vector2(0,0);
    }

    public void setPosition(Vector2 position) {
        throw new RuntimeException("Scene position cannot be changed");
    }

    public float getRotation() {
        return 0;
    }

    public void setRotation(float rotation) {
        throw new RuntimeException("Scene rotation cannot be changed");
    }

    public SpookObject getParent() {
        return null;
    }

    @Override
    public String getDeclaration() {
        throw new RuntimeException("Scene should not be declared");
    }
}
