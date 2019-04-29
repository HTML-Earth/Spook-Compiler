package dk.aau.cs.d403.spook.color;

import dk.aau.cs.d403.ast.expressions.ColorFunctionCallNode;
import dk.aau.cs.d403.ast.expressions.LowPrecedenceNode;
import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;
import dk.aau.cs.d403.ast.statements.NonObjectFunctionCallNode;
import dk.aau.cs.d403.ast.statements.ObjectFunctionCallNode;
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

    public static Vector4 getColorArgument(ObjectArgumentNode objectArgumentNode) {
        ColorFunctionCallNode colorFunctionCallNode = objectArgumentNode.getColorFunctionCallNode();
        ObjectFunctionCallNode objectFunctionCallNode = objectArgumentNode.getObjectFunctionCallNode();
        NonObjectFunctionCallNode nonObjectFunctionCallNode = objectArgumentNode.getNonObjectFunctionCallNode();
        LowPrecedenceNode lowPrecedenceNode = objectArgumentNode.getLowPrecedence();

        if (colorFunctionCallNode != null)
            return getColorProperty(colorFunctionCallNode);
        else if (objectFunctionCallNode != null) {
            return magenta();
        }
        else if (nonObjectFunctionCallNode != null) {
            return magenta();
        }
        else if (lowPrecedenceNode != null) {
            return magenta();
        }
        else {
            throw new RuntimeException("Invalid color argument");
        }
    }

    public static Vector4 getColorProperty(ColorFunctionCallNode colorFunctionCallNode) {
        if (colorFunctionCallNode.getClassType() == null)
            throw new RuntimeException("Property is not a color property");

        switch (colorFunctionCallNode.getClassType()) {
            case BLACK:
                return black();
            case WHITE:
                return white();
            case RED:
                return red();
            case GREEN:
                return green();
            case BLUE:
                return blue();
            //case CYAN
            //    return cyan();
            //case MAGENTA:
            //    return magenta();
            //case YELLOW:
            //    return yellow();
            //case INVISIBLE:
            //    return invisible();
            default:
                throw new RuntimeException("Unknown color");
        }
    }
}
