package dk.aau.cs.d403.spook.shapes;

import dk.aau.cs.d403.codegen.PrintGLSL;
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
                PrintGLSL.printObjArgNode(size.getX()) + ", " +
                PrintGLSL.printObjArgNode(size.getY()) + "),\n\t\t" +
                "vec2(" +
                PrintGLSL.printObjArgNode(position.getX()) + ", " +
                PrintGLSL.printObjArgNode(position.getY()) + "),\n\t\t" +
                "vec4(" +
                PrintGLSL.printObjArgNode(color.getX()) + ", " +
                PrintGLSL.printObjArgNode(color.getY()) + ", " +
                PrintGLSL.printObjArgNode(color.getZ()) + ", " +
                PrintGLSL.printObjArgNode(color.getW()) + ")\n\t" +
                ");";
    }
}
