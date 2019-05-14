package dk.aau.cs.d403.spook.color;

import dk.aau.cs.d403.spook.Vector4;

public interface Colorable {
    Vector4 getColor();
    void setColor(Vector4 color);

    String getColorApplication(String spaceName);
}
