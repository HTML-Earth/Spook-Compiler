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
                "vec2(" +
                size.getX().prettyPrint() + ", " +
                size.getY().prettyPrint() + "),\n\t\t" +
                "vec2(" +
                position.getX().prettyPrint() + ", " +
                position.getY().prettyPrint() + "),\n\t\t" +
                "vec4(" +
                color.getX().prettyPrint() + ", " +
                color.getY().prettyPrint() + ", " +
                color.getZ().prettyPrint() + ", " +
                color.getW().prettyPrint() + ")\n\t" +
                ");";
    }
}
