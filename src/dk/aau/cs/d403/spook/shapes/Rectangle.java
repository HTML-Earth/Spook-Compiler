package dk.aau.cs.d403.spook.shapes;

import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.ColorFunctionCallNode;
import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;
import dk.aau.cs.d403.codegen.PrintGLSL;
import dk.aau.cs.d403.spook.Vector2;
import dk.aau.cs.d403.spook.color.Color;

import java.util.ArrayList;

public class Rectangle extends Shape {
    private Vector2 size;

    public Rectangle (String name, ArrayList<ObjectArgumentNode> argumentNodes) {
        classType = Enums.ClassType.RECTANGLE;

        this.name = name;
        this.position = Vector2.zero();

        if (argumentNodes.size() == 3) {
            this.size = new Vector2(argumentNodes.get(0), argumentNodes.get(1));
            ColorFunctionCallNode colorProperty = argumentNodes.get(2).getColorFunctionCallNode();
            this.color = Color.getColorProperty(colorProperty);
        }
    }

    public static String getStruct() {
        return "struct Rectangle {\n\t" +
                "vec2 size;\n\t" +
                "vec2 pos;\n\t" +
                "vec4 color;\n" +
                "};";
    }

    public static String getCheckFunctionSignature() {
        return "bool RectangleCheck(vec2 point, Rectangle rec)";
    }

    public static String getCheckFunctionBody() {
        return "return (point.x > rec.pos.x - rec.size.x * 0.5 && point.x < rec.pos.x + rec.size.x * 0.5 &&\n\t\t\t" +
                       "point.y > rec.pos.y - rec.size.y * 0.5 && point.y < rec.pos.y + rec.size.y * 0.5);";
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

    @Override
    public String getCheckCall() {
        return "if (RectangleCheck(fragCoord, " + name + ")) {\n\t\t" +
                "fragColor = " + name + ".color;\n\t\t" +
                "return;\n\t" +
                "}";
    }
}
