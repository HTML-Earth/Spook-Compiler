package dk.aau.cs.d403.spook.shapes;

import dk.aau.cs.d403.spook.Vector2;
import dk.aau.cs.d403.spook.Vector4;

public class Rectangle extends Shape {
    private Vector2 size;

    public Rectangle (String name, Vector2 size, Vector4 color) {
        this.name = name;
        this.size = size;
        this.position = Vector2.zero();
        this.color = color;
    }

    @Override
    public String getDeclaration() {
        return "Rectangle " + name + " = Rectangle(\n\t\t" +
                "vec2(" + size.getX() + ", " + size.getY() + "),\n\t\t" +
                "vec2(" + position.getX() + ", " + position.getY() + "),\n\t\t" +
                "vec4(" + color.getX() + ", " + color.getY() + ", " + color.getZ() + ", " + color.getW() + ")\n\t" +
                ");";
    }
}
