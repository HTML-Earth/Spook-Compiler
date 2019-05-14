package dk.aau.cs.d403.spook.fill;

import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;
import dk.aau.cs.d403.codegen.PrintGLSL;
import dk.aau.cs.d403.spook.Vector2;
import dk.aau.cs.d403.spook.Vector4;
import dk.aau.cs.d403.spook.color.Color;

import java.util.ArrayList;

public class CircleGradient extends Fill {
    private ObjectArgumentNode innerRadius;
    private ObjectArgumentNode outerRadius;
    private Vector4 innerColor;
    private Vector4 outerColor;

    public CircleGradient (String name, ArrayList<ObjectArgumentNode> argumentNodes) {
        classType = Enums.ClassType.CIRCLE_GRADIENT;

        this.name = name;
        this.position = Vector2.zero();
        this.rotation = ObjectArgumentNode.zero();
        this.scale = Vector2.one();

        if (argumentNodes.size() == 3) {
            this.innerRadius = ObjectArgumentNode.zero();
            this.outerRadius = argumentNodes.get(0);
            this.innerColor = Color.getColorArgument(argumentNodes.get(1));
            this.outerColor = Color.getColorArgument(argumentNodes.get(2));
        }
        else if (argumentNodes.size() == 4) {
            this.innerRadius = argumentNodes.get(0);
            this.outerRadius = argumentNodes.get(1);
            this.innerColor = Color.getColorArgument(argumentNodes.get(2));
            this.outerColor = Color.getColorArgument(argumentNodes.get(3));
        }
    }

    public static String getStruct() {
        return "struct CircleGradient {\n\t" +
                "float innerRadius;\n\t" +
                "float outerRadius;\n\t" +
                "vec4 innerColor;\n\t" +
                "vec4 outerColor;\n\t" +
                "vec2 pos;\n\t" +
                "vec2 scale;\n\t" +
                "float rot;\n" +
                "};";
    }


    public static String getBlendFunctionSignature() {
        return "float CircleGradientBlend(vec2 point, CircleGradient circleGradient)";
    }

    public static String getBlendFunctionBody() {
        return "return smoothstep(circleGradient.innerRadius, circleGradient.outerRadius, distance(point, circleGradient.pos));";
    }

    @Override
    public String getDeclaration() {
        return "CircleGradient " + name + " = CircleGradient(\n\t\t" +
                PrintGLSL.printObjArgNode(innerRadius) + ",\n\t\t" +
                PrintGLSL.printObjArgNode(outerRadius) + ",\n\t\t" +
                PrintGLSL.printVector4(innerColor) + ",\n\t\t" +
                PrintGLSL.printVector4(outerColor) + ",\n\t\t" +
                PrintGLSL.printVector2(getWorldPosition()) + ",\n\t\t" +
                PrintGLSL.printVector2(scale) + ",\n\t\t" +
                PrintGLSL.printObjArgNode(rotation) + "\n\t" +
                ");";
    }

    @Override
    public String getColorApplication(String spaceName) {
        return "\t\tfloat blendValue = CircleGradientBlend(" + spaceName + ", " + name + ");\n" +
                "\t\tvec4 blendedGradientColor = mix(" + name + ".innerColor, " + name + ".outerColor, blendValue);\n" +
                "\t\tfragColor = mix(fragColor, blendedGradientColor, blendedGradientColor.a);\n";
    }
}
