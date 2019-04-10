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

    public enum ReturnType {
        VOID,
        INT,
        FLOAT,
        BOOL,
        VEC2,
        VEC3,
        VEC4
    }

    public static String returnTypeToStringSpook(ReturnType returnType) {
        switch (returnType) {
            case INT:
                return dataTypeToStringSpook(DataType.INT);
            case FLOAT:
                return dataTypeToStringSpook(DataType.FLOAT);
            case BOOL:
                return dataTypeToStringSpook(DataType.BOOL);
            case VEC2:
                return dataTypeToStringSpook(DataType.VEC2);
            case VEC3:
                return dataTypeToStringSpook(DataType.VEC3);
            case VEC4:
                return dataTypeToStringSpook(DataType.VEC4);
            case VOID:
                return "Void";
            default:
                return "InvalidType";
        }
    }

    public static String returnTypeToStringGLSL(ReturnType returnType) {
        switch (returnType) {
            case INT:
                return dataTypeToStringGLSL(DataType.INT);
            case FLOAT:
                return dataTypeToStringGLSL(DataType.FLOAT);
            case BOOL:
                return dataTypeToStringGLSL(DataType.BOOL);
            case VEC2:
                return dataTypeToStringGLSL(DataType.VEC2);
            case VEC3:
                return dataTypeToStringGLSL(DataType.VEC3);
            case VEC4:
                return dataTypeToStringGLSL(DataType.VEC4);
            case VOID:
                return "void";
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

    public static String classTypeToString(ClassType classType) {
        switch (classType) {
            case CIRCLE:
                return "Circle";
            case RECTANGLE:
                return "Rectangle";
            case TRIANGLE:
                return "Triangle";
            case SHAPE:
                return "Shape";
            case COLOR:
                return "Color";
            default:
                return "InvalidClassType";
        }
    }

    public enum Operator {
        ADD,
        SUB,
        MOD,
        DIV,
        MUL
    }

    public static String operatorToString(Operator operator) {
        switch (operator) {
            case ADD:
                return "+";
            case SUB:
                return "-";
            case MOD:
                return "%";
            case DIV:
                return "/";
            case MUL:
                return "*";
            default:
                return "InvalidOperator";
        }
    }
}
