package dk.aau.cs.d403.spook.shapes;

import dk.aau.cs.d403.errorhandling.CompilerException;
import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;
import dk.aau.cs.d403.codegen.PrintGLSL;
import dk.aau.cs.d403.spook.Vector2;
import dk.aau.cs.d403.spook.color.Color;

import java.util.ArrayList;

public class Polygon extends Shape {
    private ArrayList<Vector2> points;

    private static final int maxPoints = 16;
    private static final int minPoints = 3;

    public Polygon (String name, ArrayList<ObjectArgumentNode> argumentNodes) {
        classType = Enums.ClassType.POLYGON;

        this.name = name;
        this.position = Vector2.zero();
        this.rotation = ObjectArgumentNode.zero();
        this.scale = Vector2.one();

        points = new ArrayList<>();

        //Max arguments = 17
        if (argumentNodes.size() > minPoints && argumentNodes.size() < maxPoints + 2) {
            for (int i = 0; i < argumentNodes.size() - 1; i++) {
                points.add(Vector2.evaluateLowPrecedence(argumentNodes.get(i).getLowPrecedence()));
            }
            this.color = Color.getColorArgument(argumentNodes.get(argumentNodes.size() - 1));
        }
        else
            throw new CompilerException("Invalid number of arguments in Polygon Contructor. Expected: " + (minPoints + 1) + " - " + (maxPoints + 1) + "Found: " + argumentNodes.size() );
    }

    public static String getStruct() {
        return "struct Polygon {\n\t" +
                "vec2 points["+maxPoints+"];\n\t" +
                "vec2 pos;\n\t" +
                "vec2 scale;\n\t" +
                "float rot;\n\t" +
                "vec4 color;\n" +
                "};";
    }

    public static String getCheckFunctionSignature() {
        return "bool PolygonCheck(vec2 point, Polygon poly, int amt)";
    }

    public static String getCheckFunctionBody() {
        return "    float angle = 0.0;\n" +
                "    for (int i = 0; i < amt; i++) {\n" +
                "        vec2 a = vec2(poly.points[i]-point);\n" +
                "        \n" +
                "        vec2 b;\n" +
                "        \n" +
                "        if (i < amt-1)\n" +
                "        \tb = vec2(poly.points[i+1]-point);\n" +
                "        else\n" +
                "            b = vec2(poly.points[0]-point);\n" +
                "        \n" +
                "        angle += abs( acos( dot(a,b) / ( length(a) * length(b) ) ) );\n" +
                "    }\n" +
                "    angle *= 180.0 / PI;\n" +
                "    return angle < 361.0 && angle > 359.0;";
    }

    @Override
    public String getDeclaration() {
        StringBuilder pointDecl = new StringBuilder();
        pointDecl.append("vec2["+maxPoints+"](\n\t\t\t");

        for (int i = 0; i < maxPoints; i++) {
            if (i < points.size()) {
                pointDecl.append(PrintGLSL.printVector2(points.get(i)));
                pointDecl.append(" + ");
                pointDecl.append(PrintGLSL.printVector2(getWorldPosition()));
            }
            else
                pointDecl.append(PrintGLSL.printVector2(Vector2.zero()));

            if (i < maxPoints - 1)
                pointDecl.append(",\n\t\t\t");
            else
                pointDecl.append("\n\t\t");
        }

        pointDecl.append(")");

        return "Polygon " + name + " = Polygon(\n\t\t" +
                pointDecl.toString() + ",\n\t\t" +
                PrintGLSL.printVector2(getWorldPosition()) + ",\n\t\t" +
                PrintGLSL.printVector2(scale) + ",\n\t\t" +
                PrintGLSL.printObjArgNode(rotation) + ",\n\t\t" +
                PrintGLSL.printVector4(color) + "\n\t" +
                ");";
    }

    @Override
    public String getCheckCall(String spaceName) {
        return "if (PolygonCheck(" + spaceName + ", " + name + ", " + points.size() + ")) {\n" + getColorApplication(spaceName) + "\t}";
    }
}
