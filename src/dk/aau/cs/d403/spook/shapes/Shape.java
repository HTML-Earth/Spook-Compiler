package dk.aau.cs.d403.spook.shapes;

import dk.aau.cs.d403.ast.expressions.AtomPrecedenceNode;
import dk.aau.cs.d403.ast.expressions.BoolExpressionNode;
import dk.aau.cs.d403.ast.expressions.HighPrecedenceNode;
import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;
import dk.aau.cs.d403.errorhandling.CompilerException;
import dk.aau.cs.d403.spook.Vector4;
import dk.aau.cs.d403.spook.color.Colorable;
import dk.aau.cs.d403.spook.SpookObject;
import dk.aau.cs.d403.spook.fill.Fill;

import java.util.ArrayList;

public abstract class Shape extends SpookObject implements Colorable {
    protected Vector4 color;
    protected BoolExpressionNode inverted;

    @Override
    public Vector4 getColor() {
        return color;
    }

    @Override
    public void setColor(Vector4 color) {
        this.color = color;
    }

    public BoolExpressionNode isInverted() {
        return inverted;
    }

    public void setInverted(BoolExpressionNode inverted) {
        this.inverted = inverted;
    }

    public void setInverted(ObjectArgumentNode argumentNode) {
        if (argumentNode.getBoolExpression() != null) {
            this.inverted = argumentNode.getBoolExpression();
        }
        //TODO: make it possible to use variables through lowPrecedence
        else
            throw new CompilerException("Expected a boolean expression");
    }

    public void setInverted(ArrayList<ObjectArgumentNode> argumentNodes) {
        if (argumentNodes.size() == 1)
            setInverted(argumentNodes.get(0));
        else
            throw new CompilerException("ERROR: Invalid number of arguments. Expecting 1 argument, Found " + argumentNodes.size() + " arguments");
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
        if (color.getW() != null && color.getW().getLowPrecedence().getHighPrecedenceNodes().size() == 1) {
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
