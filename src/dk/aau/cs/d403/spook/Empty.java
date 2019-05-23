package dk.aau.cs.d403.spook;

import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;
import dk.aau.cs.d403.codegen.PrintGLSL;
import dk.aau.cs.d403.errorhandling.InvalidAmountOfArgumentsException;

import java.util.ArrayList;

public class Empty extends SpookObject {

    public Empty (String name, ArrayList<ObjectArgumentNode> argumentNodes) {
        classType = Enums.ClassType.CIRCLE;

        this.name = name;
        this.position = Vector2.zero();
        this.rotation = ObjectArgumentNode.zero();
        this.scale = Vector2.one();

        if (argumentNodes.size() == 1) {
            this.position = Vector2.evaluateLowPrecedence(argumentNodes.get(0).getLowPrecedence());
        }
        else if (argumentNodes.size() == 2) {
            this.position = new Vector2(argumentNodes.get(0), argumentNodes.get(1));
        }
        else {
            throw new InvalidAmountOfArgumentsException("Empty constructor", 1,2, argumentNodes.size());
        }
    }

    public static String getStruct() {
        return "struct Empty {\n\t" +
                "vec2 pos;\n\t" +
                "vec2 scale;\n\t" +
                "float rot;\n" +
                "};";
    }

    @Override
    public String getDeclaration() {
        return "Empty " + name + " = Empty(\n\t\t" +
                PrintGLSL.printVector2(getWorldPosition()) + ",\n\t\t" +
                PrintGLSL.printVector2(scale) + ",\n\t\t" +
                PrintGLSL.printObjArgNode(rotation) + "\n\t" +
                ");";
    }
}
