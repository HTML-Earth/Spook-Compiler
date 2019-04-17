package dk.aau.cs.d403.spook.color;

import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.ClassPropertyNode;
import dk.aau.cs.d403.spook.Vector4;

public class Color {
    public static Vector4 black() {
        return new Vector4(0,0,0,1);
    }
    public static Vector4 white() {
        return new Vector4(1,1,1,1);
    }
    public static Vector4 red() {
        return new Vector4(1,0,0,1);
    }
    public static Vector4 green() {
        return new Vector4(0,1,0,1);
    }
    public static Vector4 blue() {
        return new Vector4(0,0,1,1);
    }
    public static Vector4 cyan() {
        return new Vector4(0,1,1,1);
    }
    public static Vector4 magenta() {
        return new Vector4(1,0,1,1);
    }
    public static Vector4 yellow() {
        return new Vector4(1,1,0,1);
    }
    public static Vector4 invisible() {
        return new Vector4(0,0,0,0);
    }

    public static Vector4 getColorProperty(ClassPropertyNode propertyNode) {
        if (propertyNode.getClassType() != Enums.ClassType.COLOR)
            throw new RuntimeException("Property is not a color property");

        switch (propertyNode.getVariableName()) {
            case "black":
                return black();
            case "white":
                return white();
            case "red":
                return red();
            case "green":
                return green();
            case "blue":
                return blue();
            case "cyan":
                return cyan();
            case "magenta":
                return magenta();
            case "yellow":
                return yellow();
            case "invisible":
                return invisible();
            default:
                throw new RuntimeException("Unknown color");
        }
    }
}
