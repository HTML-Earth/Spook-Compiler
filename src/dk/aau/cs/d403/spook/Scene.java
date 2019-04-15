package dk.aau.cs.d403.spook;

import dk.aau.cs.d403.spook.color.Colorable;

public class Scene extends SpookObject implements Colorable {
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
}
