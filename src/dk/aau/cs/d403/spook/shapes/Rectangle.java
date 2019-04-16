package dk.aau.cs.d403.spook.shapes;

public class Rectangle extends Shape {
    private float width;
    private float height;

    public Rectangle (String name, float width, float height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    @Override
    public String getDeclaration() {
        return "Rectangle " + name + " = Rectangle(\n\t\t" +
                "vec2(" + width + ", " + height + "),\n\t\t" +
                "vec2(0, 0),\n\t\t" +
                "vec4(0, 0, 0, 1)\n\t" +
                ");";
    }
}
