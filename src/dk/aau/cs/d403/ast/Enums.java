package dk.aau.cs.d403.ast;

public class Enums {
    public enum DataType {
        INT,
        FLOAT,
        BOOL,
        VEC2,
        VEC3,
        VEC4
    }

    public static String dataTypeToStringSpook(DataType dataType) {
        switch (dataType) {
            case INT:
                return "Int";
            case FLOAT:
                return "Float";
            case BOOL:
                return "Bool";
            case VEC2:
                return "Vec2";
            case VEC3:
                return "Vec3";
            case VEC4:
                return "Vec4";
            default:
                return "InvalidType";
        }
    }

    public static String dataTypeToStringGLSL(DataType dataType) {
        switch (dataType) {
            case INT:
                return "int";
            case FLOAT:
                return "float";
            case BOOL:
                return "bool";
            case VEC2:
                return "vector2";
            case VEC3:
                return "vector3";
            case VEC4:
                return "vector4";
            default:
                return "InvalidType";
        }
    }

    public enum ClassType {
        CIRCLE,
        RECTANGLE,
        TRIANGLE,
        SHAPE,
        COLOR
    }
}
