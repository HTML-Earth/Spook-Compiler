package dk.aau.cs.d403.spook;

import dk.aau.cs.d403.CompilerException;
import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.NumberPacking;
import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.ast.statements.NonObjectFunctionCallNode;
import dk.aau.cs.d403.ast.statements.ObjectFunctionCallNode;
import dk.aau.cs.d403.codegen.CodeGenerator;
import dk.aau.cs.d403.spook.color.Color;

import java.util.ArrayList;

public class Vector4 {
    private ObjectArgumentNode x;
    private ObjectArgumentNode y;
    private ObjectArgumentNode z;
    private ObjectArgumentNode w;

    public Vector4(ObjectArgumentNode x, ObjectArgumentNode y, ObjectArgumentNode z, ObjectArgumentNode w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vector4(double x, double y, double z, double w) {
        this.x = NumberPacking.getObjectArgumentFromDouble(x);
        this.y = NumberPacking.getObjectArgumentFromDouble(y);
        this.z = NumberPacking.getObjectArgumentFromDouble(z);
        this.w = NumberPacking.getObjectArgumentFromDouble(w);
    }

    public ObjectArgumentNode getX() {
        return x;
    }

    public void setX(ObjectArgumentNode x) {
        this.x = x;
    }

    public ObjectArgumentNode getY() {
        return y;
    }

    public void setY(ObjectArgumentNode y) {
        this.y = y;
    }

    public ObjectArgumentNode getZ() {
        return z;
    }

    public void setZ(ObjectArgumentNode z) {
        this.z = z;
    }

    public ObjectArgumentNode getW() {
        return w;
    }

    public void setW(ObjectArgumentNode w) {
        this.w = w;
    }

    public static Vector4 zero(){
        RealNumberNode zero = new RealNumberNode(0);
        ObjectArgumentNode x = NumberPacking.getObjectArgumentFromRealNumber(zero);
        ObjectArgumentNode y = NumberPacking.getObjectArgumentFromRealNumber(zero);
        ObjectArgumentNode z = NumberPacking.getObjectArgumentFromRealNumber(zero);
        ObjectArgumentNode w = NumberPacking.getObjectArgumentFromRealNumber(zero);
        return new Vector4(x,y,z,w);
    }

    public static Vector4 evaluateExpression(ExpressionNode expressionNode) {
        if (expressionNode instanceof Vector4ExpressionNode) {
            Vector4ExpressionNode vector4ExpressionNode = (Vector4ExpressionNode) expressionNode;
            ObjectArgumentNode x = new ObjectArgumentNode(vector4ExpressionNode.getArithExpressionNode1().getLowPrecedenceNode());
            ObjectArgumentNode y = new ObjectArgumentNode(vector4ExpressionNode.getArithExpressionNode2().getLowPrecedenceNode());
            ObjectArgumentNode z = new ObjectArgumentNode(vector4ExpressionNode.getArithExpressionNode3().getLowPrecedenceNode());
            ObjectArgumentNode w = new ObjectArgumentNode(vector4ExpressionNode.getArithExpressionNode4().getLowPrecedenceNode());
            return new Vector4(x,y,z,w);
        }
        else
            throw new CompilerException("Expression is not vector4 expression", expressionNode.getCodePosition());
    }

    public static Vector4 evaluateLowPrecedence(LowPrecedenceNode lowPrecedenceNode) {
        ArrayList<HighPrecedenceNode> highPrecedenceNodes = lowPrecedenceNode.getHighPrecedenceNodes();

        Vector4 result = evaluateHighPrecedence(lowPrecedenceNode.getHighPrecedenceNodes().get(0));

        if (lowPrecedenceNode.getOperators() != null) {
            int operatorAmt = lowPrecedenceNode.getOperators().size();
            for (int i = 0; i < operatorAmt; i++) {
                Vector4 operand = evaluateHighPrecedence(lowPrecedenceNode.getHighPrecedenceNodes().get(i + 1));
                result = evaluateOperation(lowPrecedenceNode.getOperators().get(i), result, operand);
            }
        }

        return result;
    }

    public static Vector4 evaluateHighPrecedence(HighPrecedenceNode highPrecedenceNode) {
        Vector4 result = evaluateAtomPrecedence(highPrecedenceNode.getAtomPrecedenceNodes().get(0));

        if (highPrecedenceNode.getOperators() != null) {
            int operatorAmt = highPrecedenceNode.getOperators().size();
            for (int i = 0; i < operatorAmt; i++) {
                Vector4 operand = evaluateAtomPrecedence(highPrecedenceNode.getAtomPrecedenceNodes().get(i+1));
                result = evaluateOperation(highPrecedenceNode.getOperators().get(i), result, operand);
            }
        }

        return result;
    }

    public static Vector4 evaluateAtomPrecedence(AtomPrecedenceNode atomPrecedenceNode) {
        if (atomPrecedenceNode.getLowPrecedenceNode() != null)
            return evaluateLowPrecedence(atomPrecedenceNode.getLowPrecedenceNode());
        else if (atomPrecedenceNode.getOperator() != null) {
            if (atomPrecedenceNode.getOperator() == Enums.Operator.SUB)
                return Vector4.evaluateOperation(Enums.Operator.SUB, Vector4.zero(), evaluateArithOperand(atomPrecedenceNode.getOperand()));
            else if (atomPrecedenceNode.getOperator() == Enums.Operator.ADD)
                return evaluateArithOperand(atomPrecedenceNode.getOperand());
            else
                throw new CompilerException(atomPrecedenceNode.getOperator().toString() + " before single operand is illegal", atomPrecedenceNode.getCodePosition());
        }
        else
            return evaluateArithOperand(atomPrecedenceNode.getOperand());
    }

    public static Vector4 evaluateArithOperand(ArithOperandNode arithOperandNode) {
        RealNumberNode realNumberNode = arithOperandNode.getRealNumberNode();
        NonObjectFunctionCallNode nonObjectFunctionCallNode = arithOperandNode.getNonObjectFunctionCallNode();
        ObjectFunctionCallNode objectFunctionCallNode = arithOperandNode.getObjectFunctionCallNode();
        String variableName = arithOperandNode.getVariableName();
        SwizzleNode swizzleNode = arithOperandNode.getSwizzleNode();

        if (realNumberNode != null) {
            double number = realNumberNode.getNumber();
            return new Vector4(number, number, number, number);
        }
        else if (nonObjectFunctionCallNode != null) {
            throw new CompilerException("Evaluation not yet implemented", arithOperandNode.getCodePosition());
        }
        else if (objectFunctionCallNode != null) {
            if (objectFunctionCallNode.getObjectVariableName().equals("Color")) {
                return Color.getColorProperty(objectFunctionCallNode);
            }
            else
                throw new CompilerException("Object function call on unrecognized object: " + objectFunctionCallNode.getObjectVariableName(), arithOperandNode.getCodePosition());
        }
        else if (variableName != null) {
            return evaluateExpression(CodeGenerator.getVariables().get(variableName).getVarDeclInitNodes().get(0).getAssignmentNode().getExpressionNode());
        }
        else if (swizzleNode != null) {
            throw new CompilerException("Evaluation not yet implemented", arithOperandNode.getCodePosition());
        }
        else
            throw new CompilerException("Invalid Arith Operand", arithOperandNode.getCodePosition());
    }

    public static Vector4 evaluateOperation(Enums.Operator operator, Vector4 left, Vector4 right) {
        ObjectArgumentNode x;
        ObjectArgumentNode y;
        ObjectArgumentNode z;
        ObjectArgumentNode w;

        switch (operator) {
            case ADD:
                x = ObjectArgumentNode.add(left.getX(), right.getX());
                y = ObjectArgumentNode.add(left.getX(), right.getX());
                z = ObjectArgumentNode.add(left.getX(), right.getX());
                w = ObjectArgumentNode.add(left.getX(), right.getX());
                break;
            case SUB:
                x = ObjectArgumentNode.subtract(left.getX(), right.getX());
                y = ObjectArgumentNode.subtract(left.getX(), right.getX());
                z = ObjectArgumentNode.subtract(left.getX(), right.getX());
                w = ObjectArgumentNode.subtract(left.getX(), right.getX());
                break;
            case MOD:
                x = ObjectArgumentNode.mod(left.getX(), right.getX());
                y = ObjectArgumentNode.mod(left.getX(), right.getX());
                z = ObjectArgumentNode.mod(left.getX(), right.getX());
                w = ObjectArgumentNode.mod(left.getX(), right.getX());
                break;
            case DIV:
                x = ObjectArgumentNode.divide(left.getX(), right.getX());
                y = ObjectArgumentNode.divide(left.getX(), right.getX());
                z = ObjectArgumentNode.divide(left.getX(), right.getX());
                w = ObjectArgumentNode.divide(left.getX(), right.getX());
                break;
            case MUL:
                x = ObjectArgumentNode.multiply(left.getX(), right.getX());
                y = ObjectArgumentNode.multiply(left.getX(), right.getX());
                z = ObjectArgumentNode.multiply(left.getX(), right.getX());
                w = ObjectArgumentNode.multiply(left.getX(), right.getX());
                break;
            default:
                throw new RuntimeException("Invalid operation");
        }

        return new Vector4(x,y,z,w);
    }

    public static String GLSLPrint(Vector4 vector) {
        return "(" +
                vector.getX().prettyPrint(0) + ", " +
                vector.getY().prettyPrint(0) + ", " +
                vector.getZ().prettyPrint(0) + ", " +
                vector.getW().prettyPrint(0) + ")";
    }
}
