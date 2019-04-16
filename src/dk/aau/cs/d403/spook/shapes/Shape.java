package dk.aau.cs.d403.spook.shapes;

import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.spook.color.Colorable;
import dk.aau.cs.d403.spook.SpookObject;

public abstract class Shape extends SpookObject implements Colorable {
    public static String getStruct(Enums.ClassType classType) {
        switch (classType) {
            case CIRCLE:
                return "struct Circle {\n\t" +
                        "float radius;\n\t" +
                        "vec2 pos;\n\t" +
                        "vec4 color;\n" +
                        "};";
            case RECTANGLE:
                return "struct Rectangle {\n\t" +
                        "vec2 size;\n\t" +
                        "vec2 pos;\n\t" +
                        "vec4 color;\n" +
                        "};";
            case SQUARE:
                return "struct Square {\n\t" +
                        "float size;\n\t" +
                        "vec2 pos;\n\t" +
                        "vec4 color;\n" +
                        "};";
            case TRIANGLE:
                return "struct Triangle {\n\t" +
                        "vec2 size;\n\t" +
                        "vec2 pos;\n\t" +
                        "vec4 color;\n" +
                        "};";
            case SHAPE:
                throw new RuntimeException("Shape has no struct");
            case COLOR:
                throw new RuntimeException("Color has no struct");
            default:
                throw new RuntimeException("Invalid class type");
        }
    }

    public static String getCheckFunctionSignature(Enums.ClassType classType) {
        switch (classType) {
            case CIRCLE:
                return "bool CircleCheck(vec2 point, Circle circle)";
            case RECTANGLE:
                return "bool RectangleCheck(vec2 point, Rectangle rec)";
            case SQUARE:
                return "bool SquareCheck(vec2 point, Square sqr)";
            case TRIANGLE:
                return "bool TriangleCheck(vec2 point, Triangle tri)";
            case SHAPE:
                throw new RuntimeException("Shape has no struct");
            case COLOR:
                throw new RuntimeException("Color has no struct");
            default:
                throw new RuntimeException("Invalid class type");
        }
    }

    public static String getCheckFunctionBody(Enums.ClassType classType) {
        switch (classType) {
            case CIRCLE:
                return "";
            case RECTANGLE:
                return "return (point.x > rec.pos.x && point.x < rec.pos.x + rec.size.x &&\n\t" +
                        "point.y > rec.pos.y && point.y < rec.pos.y + rec.size.y);";
            case SQUARE:
                return "";
            case TRIANGLE:
                return "";
            case SHAPE:
                throw new RuntimeException("Shape has no struct");
            case COLOR:
                throw new RuntimeException("Color has no struct");
            default:
                throw new RuntimeException("Invalid class type");
        }
    }

    public static String getCheckCall(Enums.ClassType classType, String name) {
        switch (classType) {
            case CIRCLE:
                return "";
            case RECTANGLE:
                return "if (RectangleCheck(fragCoord, " + name + ")) {\n\t\t" +
                        "fragColor = " + name + ".color;\n\t\t" +
                        "return;\n\t" +
                        "}";
            case SQUARE:
                return "";
            case TRIANGLE:
                return "";
            case SHAPE:
                throw new RuntimeException("Shape has no struct");
            case COLOR:
                throw new RuntimeException("Color has no struct");
            default:
                throw new RuntimeException("Invalid class type");
        }
    }
}
