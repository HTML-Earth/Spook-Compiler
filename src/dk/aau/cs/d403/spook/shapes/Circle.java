package dk.aau.cs.d403.spook.shapes;

import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.ColorFunctionCallNode;
import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;
import dk.aau.cs.d403.codegen.PrintGLSL;
import dk.aau.cs.d403.spook.Vector2;
import dk.aau.cs.d403.spook.color.Color;

import java.util.ArrayList;

public class Circle extends Shape {
    private ObjectArgumentNode radius;

    public Circle (String name, ArrayList<ObjectArgumentNode> argumentNodes) {
        classType = Enums.ClassType.CIRCLE;

        this.name = name;
        this.position = Vector2.zero();

        if (argumentNodes.size() == 2) {
            this.radius = argumentNodes.get(0);
            ColorFunctionCallNode colorProperty = argumentNodes.get(1).getColorFunctionCallNode();
            this.color = Color.getColorProperty(colorProperty);
        }
    }

    public static String getStruct() {
        return "struct Circle {\n\t" +
                "float radius;\n\t" +
                "vec2 pos;\n\t" +
                "vec4 color;\n" +
                "};";
    }

    public static String getCheckFunctionSignature() {
        return "bool CircleCheck(vec2 point, Circle circle)";
    }

    public static String getCheckFunctionBody() {
        return "return (distance(point, circle.pos) < circle.radius);";
    }

    @Override
    public String getDeclaration() {
        return "Circle " + name + " = Circle(\n\t\t" +
                PrintGLSL.printObjArgNode(radius) + ",\n\t\t" +
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
        return "if (CircleCheck(fragCoord, " + name + ")) {\n\t\t" +
                "fragColor = " + name + ".color;\n\t\t" +
                "return;\n\t" +
                "}";
    }
}
