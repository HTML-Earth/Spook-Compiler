package dk.aau.cs.d403.spook.shapes;

import dk.aau.cs.d403.spook.Vector4;
import dk.aau.cs.d403.spook.color.Colorable;
import dk.aau.cs.d403.spook.SpookObject;

public abstract class Shape extends SpookObject implements Colorable {
    protected Vector4 color;

    @Override
    public Vector4 getColor() {
        return color;
    }

    @Override
    public void setColor(Vector4 color) {
        this.color = color;
    }

    public abstract String getCheckCall();
}
