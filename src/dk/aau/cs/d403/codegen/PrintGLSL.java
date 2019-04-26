package dk.aau.cs.d403.codegen;

import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.spook.Vector2;
import dk.aau.cs.d403.spook.Vector3;
import dk.aau.cs.d403.spook.Vector4;

public class PrintGLSL {

    public static String printArithExpression(ArithExpressionNode arithExpressionNode) {
        /*
        RealNumberNode realNumberNode = arithExpressionNode.getRealNumberNode();
        ArrayList<ArithOperationNode> arithOperationNodes = floatExpressionNode.getArithOperationNodes();
        MathFunctionCallNode mathFunctionCallNode = floatExpressionNode.getMathFunctionCallNode();
        if (realNumberNode != null) {
            return printRealNumber(realNumberNode);
        }
        else if (arithOperationNodes != null) {
            StringBuilder sb = new StringBuilder();
            boolean firstOp = true;
            for (ArithOperationNode arithOperationNode : arithOperationNodes) {
                if (!firstOp)
                    sb.append(" ");
                firstOp = false;
                sb.append(printArithOperation(arithOperationNode));
            }
            return sb.toString();
        }
        else if (mathFunctionCallNode != null) {
            return printMathFunctionCall(mathFunctionCallNode);
        }
        else
            throw new RuntimeException("Invalid float expression");
            */

        return arithExpressionNode.prettyPrint();
    }

    public static String printMathFunctionCall(MathFunctionCallNode mathFunctionCallNode) {
        /*
        StringBuilder sb = new StringBuilder();
        sb.append(Enums.mathFunctionToString(mathFunctionCallNode.getFunctionName()));
        sb.append("(");
        ArithOperandNode arithOperandNode = mathFunctionCallNode.getOperandNode();
        ArrayList<ArithOperationNode> arithOperationNodes = mathFunctionCallNode.getOperationNodes();
        if (arithOperandNode != null) {
            sb.append(printArithOperand(arithOperandNode));
        }
        else if (arithOperationNodes != null) {
            for (ArithOperationNode operationNode : arithOperationNodes) {
                sb.append(printArithOperation(operationNode));
            }
        }
        else throw new RuntimeException("Invalid math function call");
        sb.append(")");

        return sb.toString();
        */
        return mathFunctionCallNode.prettyPrint();
    }


    public static String printArithOperand(ArithOperandNode arithOperandNode) {
        RealNumberNode realNumberNode = arithOperandNode.getRealNumberNode();
        MathFunctionCallNode mathFunctionCallNode = arithOperandNode.getMathFunctionCallNode();
        String variableName = arithOperandNode.getVariableName();

        if (realNumberNode != null) {
            return printRealNumber(realNumberNode);
        }
        else if (mathFunctionCallNode != null) {
            return printMathFunctionCall(mathFunctionCallNode);
        }
        else if (variableName != null) {
            return printVariableName(variableName);
        }
        else throw new RuntimeException("Invalid arith operand");
    }

    /*
    public static String printArithOperation(ArithOperationNode arithOperationNode) {
        StringBuilder sb = new StringBuilder();
        ArithOperandNode leftOperand = arithOperationNode.getLeftOperand();
        Enums.Operator operator = arithOperationNode.getOperator();
        ArithOperandNode rightOperand = arithOperationNode.getRightOperand();
        ArithOperationNode subOperation = arithOperationNode.getArithOperationNode();
        ArrayList<ArithOperationNode> arithOperationNodes = arithOperationNode.getArithOperationNodes();

        if (leftOperand != null && operator != null && rightOperand != null) {
            sb.append(printArithOperand(leftOperand));
            sb.append(" ");
            sb.append(Enums.operatorToString(operator));
            sb.append(" ");
            sb.append(printArithOperand(rightOperand));
        }
        else if (leftOperand != null && operator != null && subOperation != null) {
            sb.append(printArithOperand(leftOperand));
            sb.append(" ");
            sb.append(Enums.operatorToString(operator));
            sb.append(printArithOperation(subOperation));
        }
        else if (operator != null && rightOperand != null) {
            sb.append(" ");
            sb.append(Enums.operatorToString(operator));
            sb.append(" ");
            sb.append(printArithOperand(rightOperand));
        }
        else if (operator != null && subOperation != null) {
            sb.append(Enums.operatorToString(operator));
            sb.append(" ");
            sb.append(printArithOperation(subOperation));
        }
        else if (arithOperationNodes != null) {
            for (ArithOperationNode operationNode: arithOperationNodes) {
                sb.append(printArithOperation(operationNode));
            }
        }
        else
            throw new RuntimeException("Invalid Arithmetic Operation");

        return sb.toString();
    }
    */

    public static String printRealNumber(RealNumberNode realNumberNode) {
        return realNumberNode.prettyPrint();
    }

    public static String printObjArgNode(ObjectArgumentNode node) {
        /*
        if (node.getVariableName() != null)
            return node.getVariableName();
        else if (node.getRealNumberNode() != null)
            return printRealNumber(node.getRealNumberNode());
        else if (node.getArithOperationNodes() != null) {
            StringBuilder sb = new StringBuilder();
            for (ArithOperationNode arithOperationNode : node.getArithOperationNodes()) {
                sb.append(printArithOperation(arithOperationNode));
            }
            return sb.toString();
        }
        else if (node.getClassPropertyNode() != null)
            return node.getClassPropertyNode().prettyPrint();
        else
            return "Invalid Object Argument";
            */
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
