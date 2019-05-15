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
        this.scale = Vector2.one();

        if (argumentNodes.size() == 2) {
            this.size = argumentNodes.get(0);
            this.color = Color.getColorArgument(argumentNodes.get(1));
        }
    }

    public static String getStruct() {
        return "struct Square {\n\t" +
                "float size;\n\t" +
                "vec2 pos;\n\t" +
                "vec2 scale;\n\t" +
                "float rot;\n\t" +
                "vec4 color;\n" +
                "};";
    }

    public static String getCheckFunctionSignature() {
        return "bool SquareCheck(vec2 point, Square sqr)";
    }

    public static String getCheckFunctionBody() {
        return "return (point.x > sqr.pos.x - sqr.size * 0.5 && point.x < sqr.pos.x + sqr.size * 0.5 &&\n\t\t\t" +
                       "point.y > sqr.pos.y - sqr.size * 0.5 && point.y < sqr.pos.y + sqr.size * 0.5);";
    }

    @Override
    public String getDeclaration() {
        return "Square " + name + " = Square(\n\t\t" +
                PrintGLSL.printObjArgNode(size) + ",\n\t\t" +
                PrintGLSL.printVector2(getWorldPosition()) + ",\n\t\t" +
                PrintGLSL.printVector2(scale) + ",\n\t\t" +
                PrintGLSL.printObjArgNode(rotation) + ",\n\t\t" +
                PrintGLSL.printVector4(color) + "\n\t" +
                ");";
    }

    @Override
    public String getCheckCall(String spaceName) {
        return "if (SquareCheck(" + spaceName + ", " + name + ")) {\n" + getColorApplication(spaceName) + "\t}";
    }
}
