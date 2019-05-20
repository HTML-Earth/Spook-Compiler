package dk.aau.cs.d403.spook.shapes;

import dk.aau.cs.d403.ast.expressions.AtomPrecedenceNode;
import dk.aau.cs.d403.ast.expressions.HighPrecedenceNode;
import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;
import dk.aau.cs.d403.spook.Vector4;
import dk.aau.cs.d403.spook.color.Colorable;
import dk.aau.cs.d403.spook.SpookObject;
import dk.aau.cs.d403.spook.fill.Fill;

import java.util.ArrayList;

public abstract class Shape extends SpookObject implements Colorable {
    protected Vector4 color;
    protected boolean inverted;

    @Override
    public Vector4 getColor() {
        return color;
    }

    @Override
    public void setColor(Vector4 color) {
        this.color = color;
    }

    public boolean isInverted() {
        return inverted;
    }

    public void setInverted(boolean inverted) {
        this.inverted = inverted;
    }

    public void setInverted(ObjectArgumentNode argumentNode) {
        this.inverted = inverted; //TODO: fix
    }

    public void setInverted(ArrayList<ObjectArgumentNode> argumentNodes) {
        this.inverted = inverted; //TODO: fix
    }

    public abstract String getCheckCall(String spaceName);

    public static String getRotationFunctionSignature2D() {
        return "mat2 rotate2D(float angle)";
    }

    public static String getRotationFunctionBody2D() {
        return "float rad = -angle * PI / 180.0;\n\treturn mat2(cos(rad), -sin(rad), sin(rad), cos(rad));";
    }

    public static String getScaleFunctionSignature2D() {
        return "mat2 scale2D(vec2 scale)";
    }

    public static String getScaleFunctionBody2D() {
        return "return mat2(1.0/scale.x, 0.0, 0.0, 1.0/scale.y);";
    }

    @Override
    public String getColorApplication(String spaceName) {
        StringBuilder childFillColors = new StringBuilder();
        for (SpookObject child : children) {
            if (child instanceof Fill) {
                childFillColors.append(((Fill) child).getColorApplication(spaceName));
            }
        }

        //IF ALPHA IS FULL (1)
        if (color.getW().getLowPrecedence().getHighPrecedenceNodes().size() == 1) {
            HighPrecedenceNode highPrecedenceNode = color.getW().getLowPrecedence().getHighPrecedenceNodes().get(0);
            if (highPrecedenceNode.getAtomPrecedenceNodes().size() == 1) {
                AtomPrecedenceNode atomPrecedenceNode = highPrecedenceNode.getAtomPrecedenceNodes().get(0);
                if (atomPrecedenceNode.getOperator() == null) {
                    if (atomPrecedenceNode.getOperand().getRealNumberNode() != null) {
                        if (atomPrecedenceNode.getOperand().getRealNumberNode().getNumber() == 1) {
                            return "\t\tfragColor = " + name + ".color;\n" + childFillColors.toString();
                        }
                    }
                }
            }
        }

        //IF ALPHA CAN BE LESS THAN 1
        return "\t\tfragColor = mix(fragColor, " + name + ".color, " + name + ".color.a);\n" + childFillColors.toString();
    }
}
