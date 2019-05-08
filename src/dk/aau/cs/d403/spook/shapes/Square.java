package dk.aau.cs.d403.spook.shapes;

import dk.aau.cs.d403.ast.Enums;
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
        this.rotation = ObjectArgumentNode.zero();

        if (argumentNodes.size() == 2) {
            this.size = argumentNodes.get(0);
            this.color = Color.getColorArgument(argumentNodes.get(1));
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
                PrintGLSL.printObjArgNode(getWorldPosition().getX()) + ", " +
                PrintGLSL.printObjArgNode(getWorldPosition().getY()) + "),\n\t\t" +
                "vec4(" +
                PrintGLSL.printObjArgNode(color.getX()) + ", " +
                PrintGLSL.printObjArgNode(color.getY()) + ", " +
                PrintGLSL.printObjArgNode(color.getZ()) + ", " +
                PrintGLSL.printObjArgNode(color.getW()) + ")\n\t" +
                ");";
    }

    @Override
    public String getCheckCall(String spaceName) {
        return "if (SquareCheck(" + spaceName + ", " + name + "))" + getColorApplication();
    }
}
