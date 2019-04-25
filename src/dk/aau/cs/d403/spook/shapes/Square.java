package dk.aau.cs.d403.spook.shapes;

import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.ClassPropertyNode;
import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;
import dk.aau.cs.d403.codegen.PrintGLSL;
import dk.aau.cs.d403.spook.Vector2;
import dk.aau.cs.d403.spook.color.Color;

import java.util.ArrayList;

public class Square extends Shape {
    private ObjectArgumentNode size;

    public Square (String name, ArrayList<ObjectArgumentNode> argumentNodes) {
        classType = Enums.ClassType.SQUARE;

        this.name = name;
        this.position = Vector2.zero();

        if (argumentNodes.size() == 2) {
            this.size = argumentNodes.get(0);
            ClassPropertyNode colorProperty = argumentNodes.get(1).getClassPropertyNode();
            this.color = Color.getColorProperty(colorProperty);
        }
    }

    public static String getStruct() {
        return "struct Square {\n\t" +
                "float size;\n\t" +
                "vec2 pos;\n\t" +
                "vec4 color;\n" +
                "};";
    }

    public static String getCheckFunctionSignature() {
        return "bool SquareCheck(vec2 point, Square sqr)";
    }

    public static String getCheckFunctionBody() {
        return "return (point.x > rec.pos.x - rec.size * 0.5 && point.x < rec.pos.x + rec.size * 0.5 &&\n\t\t\t" +
                       "point.y > rec.pos.y - rec.size * 0.5 && point.y < rec.pos.y + rec.size * 0.5);";
    }

    @Override
    public String getDeclaration() {
        return "Square " + name + " = Square(\n\t\t" +
                PrintGLSL.printObjArgNode(size) + ",\n\t\t" +
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
        return "if (SquareCheck(fragCoord, " + name + ")) {\n\t\t" +
                "fragColor = " + name + ".color;\n\t\t" +
                "return;\n\t" +
                "}";
    }
}
