package dk.aau.cs.d403.spook.color;

import dk.aau.cs.d403.CompilerException;
import dk.aau.cs.d403.ast.expressions.HighPrecedenceNode;
import dk.aau.cs.d403.ast.expressions.LowPrecedenceNode;
import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;
import dk.aau.cs.d403.ast.statements.ObjectFunctionCallNode;
import dk.aau.cs.d403.spook.Vector3;
import dk.aau.cs.d403.spook.Vector4;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Color {
    public static Vector4 clear() {
        return new Vector4(0,0,0,0);
    }
    public static Vector4 black() {
        return new Vector4(0,0,0,1);
    }
    public static Vector4 gray() {
        return new Vector4(0.5,0.5,0.5,1);
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
    public static Vector4 orange() {
        return new Vector4(1,0.5,0,1);
    }
    public static Vector4 purple() {
        return new Vector4(0.5,0,0.5,1);
    }
    public static Vector4 brown() {
        return new Vector4(0.59,0.29,0,1);
    }
    public static Vector4 tan() {
        return new Vector4(0.82,0.71,0.55,1);
    }
    public static Vector4 olive() {
        return new Vector4(0.5,0.5,0,1);
    }
    public static Vector4 maroon() {
        return new Vector4(0.5,0,0,1);
    }
    public static Vector4 navy() {
        return new Vector4(0,0,0.5,1);
    }
    public static Vector4 aquamarine() {
        return new Vector4(0.5,1,0.83,1);
    }
    public static Vector4 turquoise() {
        return new Vector4(0.25,0.88,0.82,1);
    }
    public static Vector4 silver() {
        return new Vector4(0.75,0.75,0.75,1);
    }
    public static Vector4 lime() {
        return new Vector4(0.75,1,0,1);
    }
    public static Vector4 teal() {
        return new Vector4(0,0.5,0.5,1);
    }
    public static Vector4 indigo() {
        return new Vector4(0.25,0,1,1);
    }
    public static Vector4 violet() {
        return new Vector4(0.5,0,1,1);
    }
    public static Vector4 pink() {
        return new Vector4(1,0.75,0.8,1);
    }


    public static Vector4 getColorArgument(ObjectArgumentNode objectArgumentNode) {
        return Vector4.evaluateLowPrecedence(objectArgumentNode.getLowPrecedence());
        //return getColorProperty(highPrecedenceNodes.get(0).getAtomPrecedenceNodes().get(0).getOperand().getObjectFunctionCallNode());
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
