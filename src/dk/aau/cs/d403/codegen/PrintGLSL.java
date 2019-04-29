package dk.aau.cs.d403.codegen;

import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.ast.statements.NonObjectFunctionCallNode;
import dk.aau.cs.d403.ast.statements.ObjectFunctionCallNode;
import dk.aau.cs.d403.spook.Vector2;
import dk.aau.cs.d403.spook.Vector3;
import dk.aau.cs.d403.spook.Vector4;

public class PrintGLSL {

    public static String printArithExpression(ArithExpressionNode arithExpressionNode) {
        return arithExpressionNode.prettyPrint();
    }

    public static String printNonObjectFunctionCall(NonObjectFunctionCallNode nonObjectFunctionCallNode) {
        return nonObjectFunctionCallNode.prettyPrint();
    }

    public static String printObjectFunctionCall(ObjectFunctionCallNode objectFunctionCallNode) {
        return objectFunctionCallNode.prettyPrint();
    }

    public static String printArithOperand(ArithOperandNode arithOperandNode) {
        RealNumberNode realNumberNode = arithOperandNode.getRealNumberNode();
        NonObjectFunctionCallNode nonObjectFunctionCallNode = arithOperandNode.getNonObjectFunctionCallNode();
        ObjectFunctionCallNode objectFunctionCallNode = arithOperandNode.getObjectFunctionCallNode();
        String variableName = arithOperandNode.getVariableName();

        if (realNumberNode != null) {
            return printRealNumber(realNumberNode);
        }
        else if (nonObjectFunctionCallNode != null) {
            return printNonObjectFunctionCall(nonObjectFunctionCallNode);
        }
        else if (objectFunctionCallNode != null) {
            return printObjectFunctionCall(objectFunctionCallNode);
        }
        else if (variableName != null) {
            return printVariableName(variableName);
        }
        else throw new RuntimeException("Invalid arith operand");
    }

    public static String printRealNumber(RealNumberNode realNumberNode) {
        return realNumberNode.prettyPrint();
    }

    public static String printObjArgNode(ObjectArgumentNode node) {
        return node.prettyPrint();
    }

    public static String printVector2(Vector2 vector){
        return "(" +
                printObjArgNode(vector.getX()) + ", " +
                printObjArgNode(vector.getY()) + ")";
    }

    public static String printVector3(Vector3 vector){
        return "(" +
                printObjArgNode(vector.getX()) + ", " +
                printObjArgNode(vector.getY()) + ", " +
                printObjArgNode(vector.getZ()) + ")";
    }

    public static String printVector4(Vector4 vector){
        return "(" +
                printObjArgNode(vector.getX()) + ", " +
                printObjArgNode(vector.getY()) + ", " +
                printObjArgNode(vector.getZ()) + ", " +
                printObjArgNode(vector.getW()) + ")";
    }

    public static String printVariableName(String variableName) {
        if (variableName.equals("Time"))
            return "iTime";
        else
            return variableName;
    }
}
