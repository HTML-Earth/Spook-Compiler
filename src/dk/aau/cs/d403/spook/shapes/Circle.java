package dk.aau.cs.d403.spook.shapes;

import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;
import dk.aau.cs.d403.spook.Vector2;

import java.util.ArrayList;

public class Circle extends Shape {

    public Circle (String name, ArrayList<ObjectArgumentNode> argumentNodes) {
        classType = Enums.ClassType.CIRCLE;

        this.name = name;
        this.position = Vector2.zero();

        throw new RuntimeException("Not yet implemented");
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

    @Override
    public String getDeclaration() {
        return null;
    }

    @Override
    public String getCheckCall() {
        return null;
    }
}
