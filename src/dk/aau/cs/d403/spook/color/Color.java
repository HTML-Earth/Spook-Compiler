package dk.aau.cs.d403.spook.color;

import dk.aau.cs.d403.ast.expressions.LowPrecedenceNode;
import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;
import dk.aau.cs.d403.ast.statements.ObjectFunctionCallNode;
import dk.aau.cs.d403.spook.Vector4;

import java.lang.reflect.Method;

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
        LowPrecedenceNode lowPrecedenceNode = objectArgumentNode.getLowPrecedence();

        if (lowPrecedenceNode != null) {
            return getColorProperty(lowPrecedenceNode.getHighPrecedenceNodes().get(0).getAtomPrecedenceNodes().get(0).getOperand().getObjectFunctionCallNode());
        }
        else {
            throw new RuntimeException("Invalid color argument");
        }
    }

    public static Vector4 getColorProperty(ObjectFunctionCallNode objectFunctionCallNode) {
        if (objectFunctionCallNode.getFunctionName() == null)
            throw new RuntimeException("Color function has no name");

        if (objectFunctionCallNode.getObjectVariableName().equals("Color")) {
            try {
                return new Color().invokeColor(objectFunctionCallNode.getFunctionName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            throw new RuntimeException("Object variable name is not 'Color'");
        }

        throw new RuntimeException("Unknown color");
    }

    Vector4 invokeColor(String name) throws Exception {
        Vector4 color = new Vector4(1,0,1,1);
        Method method;
        Class<?> enclosingClass = getClass();
        if (enclosingClass != null) {
            method = enclosingClass.getDeclaredMethod(name);
            try {
                Object value = method.invoke(this);
                color = (Vector4) value;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return color;
    }
}
