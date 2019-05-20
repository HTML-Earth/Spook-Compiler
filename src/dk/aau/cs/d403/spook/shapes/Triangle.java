package dk.aau.cs.d403.spook.shapes;

import dk.aau.cs.d403.errorhandling.CompilerException;
import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;
import dk.aau.cs.d403.codegen.PrintGLSL;
import dk.aau.cs.d403.spook.Vector2;
import dk.aau.cs.d403.spook.color.Color;

import java.util.ArrayList;

public class Triangle extends Shape {
    private Vector2 size;

    public Triangle (String name, ArrayList<ObjectArgumentNode> argumentNodes) {
        classType = Enums.ClassType.TRIANGLE;

        this.name = name;
        this.position = Vector2.zero();
        this.rotation = ObjectArgumentNode.zero();
        this.scale = Vector2.one();

        if (argumentNodes.size() == 3) {
            this.size = new Vector2(argumentNodes.get(0), argumentNodes.get(1));
            this.color = Color.getColorArgument(argumentNodes.get(2));
        }
        else
            throw new CompilerException("Invalid number of arguments in Triangle Contructor. Expected: 3. Found:" + argumentNodes.size());
    }

    public static String getStruct() {
        return "struct Triangle {\n\t" +
                "vec2 size;\n\t" +
                "vec2 pos;\n\t" +
                "vec2 scale;\n\t" +
                "float rot;\n\t" +
                "vec4 color;\n" +
                "};";
    }

    public static String getCheckFunctionSignature() {
        return "bool TriangleCheck(vec2 point, Triangle tri)";
    }

    public static String getCheckFunctionBody() {
        return "if (point.y < tri.pos.y - (tri.size.y / 2.) || point.y > tri.pos.y + (tri.size.y / 2.))\n\t\t" +
                    "return false;\n" +
                "\n\t" +
                "vec2 pTop = vec2(tri.pos.x, tri.pos.y + (tri.size.y / 2.));\n\t" +
                "\n\t" +
                "if (point.x < tri.pos.x) {\n\t\t" +
                    "vec2 pLeft = vec2(tri.pos.x - (tri.size.x / 2.), tri.pos.y - (tri.size.y / 2.));\n\t\t" +
                    "float angle = (pTop.y - pLeft.y) / (pTop.x - pLeft.x);\n\t\t" +
                    "return (point.y < angle * (point.x-pLeft.x) + pLeft.y);\n\t" +
                "}\n\t" +
                "else {\n\t\t" +
                    "vec2 pRight = vec2(tri.pos.x + (tri.size.x / 2.), tri.pos.y - (tri.size.y / 2.));\n\t\t" +
                    "float angle = (pRight.y - pTop.y) / (pRight.x - pTop.x);\n\t\t" +
                    "return (point.y < angle * (point.x-pTop.x) + pTop.y);\n\t" +
                "}";
    }

    @Override
    public String getDeclaration() {
        return "Triangle " + name + " = Triangle(\n\t\t" +
                PrintGLSL.printVector2(size) + ",\n\t\t" +
                PrintGLSL.printVector2(getWorldPosition()) + ",\n\t\t" +
                PrintGLSL.printVector2(scale) + ",\n\t\t" +
                PrintGLSL.printObjArgNode(rotation) + ",\n\t\t" +
                PrintGLSL.printVector4(color) + "\n\t" +
                ");";
    }

    @Override
    public String getCheckCall(String spaceName) {
        return "if (TriangleCheck(" + spaceName + ", " + name + ")) {\n" + getColorApplication(spaceName) + "\t}";
    }
}
