package dk.aau.cs.d403.spook.shapes;

import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;
import dk.aau.cs.d403.spook.Vector2;

import java.util.ArrayList;

public class Square extends Shape {

    public Square (String name, ArrayList<ObjectArgumentNode> argumentNodes) {
        classType = Enums.ClassType.SQUARE;

        this.name = name;
        this.position = Vector2.zero();

        throw new RuntimeException("Not yet implemented");
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

    @Override
    public String getDeclaration() {
        return null;
    }

    @Override
    public String getCheckCall() {
        return null;
    }
}
