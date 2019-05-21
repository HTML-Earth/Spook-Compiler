package dk.aau.cs.d403.spook.shapes;

import dk.aau.cs.d403.ast.expressions.BoolExpressionNode;
import dk.aau.cs.d403.errorhandling.CompilerException;
import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;
import dk.aau.cs.d403.codegen.PrintGLSL;
import dk.aau.cs.d403.spook.Vector2;
import dk.aau.cs.d403.spook.color.Color;

import java.util.ArrayList;

public class Circle extends Shape {
    private ObjectArgumentNode radius;

    public Circle (String name, ArrayList<ObjectArgumentNode> argumentNodes) {
        classType = Enums.ClassType.EMPTY;

        this.name = name;
        this.position = Vector2.zero();
        this.rotation = ObjectArgumentNode.zero();
        this.scale = Vector2.one();

        this.inverted = BoolExpressionNode.False();

        if (argumentNodes.size() == 2) {

            this.radius = argumentNodes.get(0);
            this.color = Color.getColorArgument(argumentNodes.get(1));
        }

        else
            throw new CompilerException("ERROR: Invalid number of arguments expecting 2 arguments ex (Num, Vec4) Found " + argumentNodes.size() + " arguments");
    }

    public static String getStruct() {
        return "struct Circle {\n\t" +
                "float radius;\n\t" +
                "vec2 pos;\n\t" +
                "vec2 scale;\n\t" +
                "float rot;\n\t" +
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
                PrintGLSL.printVector2(getWorldPosition()) + ",\n\t\t" +
                PrintGLSL.printVector2(scale) + ",\n\t\t" +
                PrintGLSL.printObjArgNode(rotation) + ",\n\t\t" +
                PrintGLSL.printVector4(color) + "\n\t" +
                ");";
    }

    @Override
    public String getCheckCall(String spaceName) {
        return "CircleCheck(" + spaceName + ", " + name + ")) {\n" + getColorApplication(spaceName);
    }
}
