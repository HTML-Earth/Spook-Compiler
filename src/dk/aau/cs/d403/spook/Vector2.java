package dk.aau.cs.d403.spook;

import dk.aau.cs.d403.errorhandling.CompilerException;
import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.NumberPacking;
import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.ast.statements.NonObjectFunctionCallNode;
import dk.aau.cs.d403.ast.statements.ObjectFunctionCallNode;
import dk.aau.cs.d403.codegen.CodeGenerator;

import java.util.ArrayList;

public class Vector2 {
    private ObjectArgumentNode x;
    private ObjectArgumentNode y;
    private LowPrecedenceNode lowPrecedenceNode;
    private TernaryOperatorNode ternaryOperatorNode;

    public Vector2(ObjectArgumentNode x, ObjectArgumentNode y) {
        this.x = x;
        this.y = y;
    }

    public Vector2(double x, double y) {
        this.x = NumberPacking.getObjectArgumentFromDouble(x);
        this.y = NumberPacking.getObjectArgumentFromDouble(y);
    }

    public Vector2(LowPrecedenceNode lowPrecedenceNode) {
        this.lowPrecedenceNode = lowPrecedenceNode;
    }

    public Vector2(NonObjectFunctionCallNode nonObjectFunctionCallNode) {
        this.lowPrecedenceNode = new LowPrecedenceNode(nonObjectFunctionCallNode);
    }

    public Vector2(String variableName) {
        this.lowPrecedenceNode = new LowPrecedenceNode(variableName);
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

    public LowPrecedenceNode getLowPrecedenceNode() {
        return lowPrecedenceNode;
    }

    public TernaryOperatorNode getTernaryOperatorNode() {
        return ternaryOperatorNode;
    }

    public static Vector2 zero(){
        RealNumberNode zero = new RealNumberNode(0);
        ObjectArgumentNode x = NumberPacking.getObjectArgumentFromRealNumber(zero);
        ObjectArgumentNode y = NumberPacking.getObjectArgumentFromRealNumber(zero);
        return new Vector2(x,y);
    }

    public static Vector2 one(){
        RealNumberNode one = new RealNumberNode(1);
        ObjectArgumentNode x = NumberPacking.getObjectArgumentFromRealNumber(one);
        ObjectArgumentNode y = NumberPacking.getObjectArgumentFromRealNumber(one);
        return new Vector2(x,y);
    }

    public static Vector2 add(Vector2 a, Vector2 b) {
        return evaluateOperation(Enums.Operator.ADD, a, b);
        //return new Vector2(ObjectArgumentNode.add(a.getX(), b.getX()), ObjectArgumentNode.add(a.getY(), b.getY()));
    }

    public static Vector2 evaluateExpression(ExpressionNode expressionNode) {
        if (expressionNode instanceof Vector2ExpressionNode) {
            Vector2ExpressionNode vector2ExpressionNode = (Vector2ExpressionNode) expressionNode;
            ObjectArgumentNode x = new ObjectArgumentNode(vector2ExpressionNode.getArithExpressionNode1().getLowPrecedenceNode());
            ObjectArgumentNode y = new ObjectArgumentNode(vector2ExpressionNode.getArithExpressionNode2().getLowPrecedenceNode());
            return new Vector2(x,y);
        }
        else if (expressionNode instanceof ArithExpressionNode) {
            return evaluateLowPrecedence(((ArithExpressionNode) expressionNode).getLowPrecedenceNode());
        }
        else
            throw new CompilerException("Expression is not vector2 expression", expressionNode.getCodePosition());
    }

    public static Vector2 evaluateLowPrecedence(LowPrecedenceNode lowPrecedenceNode) {
        ArrayList<HighPrecedenceNode> highPrecedenceNodes = lowPrecedenceNode.getHighPrecedenceNodes();

        Vector2 result = evaluateHighPrecedence(lowPrecedenceNode.getHighPrecedenceNodes().get(0));

        if (lowPrecedenceNode.getOperators() != null) {
            int operatorAmt = lowPrecedenceNode.getOperators().size();
            for (int i = 0; i < operatorAmt; i++) {
                Vector2 operand = evaluateHighPrecedence(lowPrecedenceNode.getHighPrecedenceNodes().get(i + 1));
                result = evaluateOperation(lowPrecedenceNode.getOperators().get(i), result, operand);
            }
        }

        return result;
    }

    public static Vector2 evaluateHighPrecedence(HighPrecedenceNode highPrecedenceNode) {
        Vector2 result = evaluateAtomPrecedence(highPrecedenceNode.getAtomPrecedenceNodes().get(0));

        if (highPrecedenceNode.getOperators() != null) {
            int operatorAmt = highPrecedenceNode.getOperators().size();
            for (int i = 0; i < operatorAmt; i++) {
                Vector2 operand = evaluateAtomPrecedence(highPrecedenceNode.getAtomPrecedenceNodes().get(i+1));
                result = evaluateOperation(highPrecedenceNode.getOperators().get(i), result, operand);
            }
        }

        return result;
    }

    public static Vector2 evaluateAtomPrecedence(AtomPrecedenceNode atomPrecedenceNode) {
        if (atomPrecedenceNode.getLowPrecedenceNode() != null)
            return evaluateLowPrecedence(atomPrecedenceNode.getLowPrecedenceNode());
        else if (atomPrecedenceNode.getOperator() != null) {
            if (atomPrecedenceNode.getOperator() == Enums.Operator.SUB)
                return Vector2.evaluateOperation(Enums.Operator.SUB, Vector2.zero(), evaluateArithOperand(atomPrecedenceNode.getOperand()));
            else if (atomPrecedenceNode.getOperator() == Enums.Operator.ADD)
                return evaluateArithOperand(atomPrecedenceNode.getOperand());
            else
                throw new CompilerException(atomPrecedenceNode.getOperator().toString() + " before single operand is illegal", atomPrecedenceNode.getCodePosition());
        }
        else
            return evaluateArithOperand(atomPrecedenceNode.getOperand());
    }

    public static Vector2 evaluateArithOperand(ArithOperandNode arithOperandNode) {
        RealNumberNode realNumberNode = arithOperandNode.getRealNumberNode();
        NonObjectFunctionCallNode nonObjectFunctionCallNode = arithOperandNode.getNonObjectFunctionCallNode();
        ObjectFunctionCallNode objectFunctionCallNode = arithOperandNode.getObjectFunctionCallNode();
        String variableName = arithOperandNode.getVariableName();
        SwizzleNode swizzleNode = arithOperandNode.getSwizzleNode();

        if (realNumberNode != null) {
            double number = realNumberNode.getNumber();
            return new Vector2(number, number);
        }
        else if (nonObjectFunctionCallNode != null) {
            return new Vector2(nonObjectFunctionCallNode);
        }
        else if (objectFunctionCallNode != null) {
            throw new CompilerException("Object function call on unrecognized object: " + objectFunctionCallNode.getObjectVariableName(), arithOperandNode.getCodePosition());
        }
        else if (variableName != null) {
            //return new Vector2(variableName);
            return evaluateExpression(CodeGenerator.getVariables().get(variableName).getVarDeclInitNodes().get(0).getAssignmentNode().getExpressionNode());
        }
        else if (swizzleNode != null) {
            throw new CompilerException("Evaluation not yet implemented", arithOperandNode.getCodePosition());
        }
        else
            throw new CompilerException("Invalid Arith Operand", arithOperandNode.getCodePosition());
    }

    public static Vector2 evaluateOperation(Enums.Operator operator, Vector2 left, Vector2 right) {
        LowPrecedenceNode lpLeft = left.getLowPrecedenceNode();
        LowPrecedenceNode lpRight = right.getLowPrecedenceNode();

        if (lpLeft != null || lpRight != null) {

            if (lpLeft == null) {
                LowPrecedenceNode x = left.getX().getLowPrecedence();
                LowPrecedenceNode y = left.getY().getLowPrecedence();
                lpLeft = new LowPrecedenceNode(new Vector2ExpressionNode(new ArithExpressionNode(x), new ArithExpressionNode(y)));
            }
            else if (lpRight == null) {
                LowPrecedenceNode x = right.getX().getLowPrecedence();
                LowPrecedenceNode y = right.getY().getLowPrecedence();
                lpRight = new LowPrecedenceNode(new Vector2ExpressionNode(new ArithExpressionNode(x), new ArithExpressionNode(y)));
            }

            switch (operator) {
                case ADD:
                    return new Vector2(LowPrecedenceNode.add(lpLeft, lpRight));
                case SUB:
                    return new Vector2(LowPrecedenceNode.sub(lpLeft, lpRight));
                case MOD:
                    return new Vector2(LowPrecedenceNode.mod(lpLeft, lpRight));
                case DIV:
                    return new Vector2(LowPrecedenceNode.div(lpLeft, lpRight));
                case MUL:
                    return new Vector2(LowPrecedenceNode.mul(lpLeft, lpRight));
                default:
                    throw new RuntimeException("Invalid operation");
            }
        }

        ObjectArgumentNode x;
        ObjectArgumentNode y;

        switch (operator) {
            case ADD:
                x = ObjectArgumentNode.add(left.getX(), right.getX());
                y = ObjectArgumentNode.add(left.getY(), right.getY());
                break;
            case SUB:
                x = ObjectArgumentNode.subtract(left.getX(), right.getX());
                y = ObjectArgumentNode.subtract(left.getY(), right.getY());
                break;
            case MOD:
                x = ObjectArgumentNode.mod(left.getX(), right.getX());
                y = ObjectArgumentNode.mod(left.getY(), right.getY());
                break;
            case DIV:
                x = ObjectArgumentNode.divide(left.getX(), right.getX());
                y = ObjectArgumentNode.divide(left.getY(), right.getY());
                break;
            case MUL:
                x = ObjectArgumentNode.multiply(left.getX(), right.getX());
                y = ObjectArgumentNode.multiply(left.getY(), right.getY());
                break;
            default:
                throw new RuntimeException("Invalid operation");
        }

        return new Vector2(x,y);
    }

    public static String GLSLPrint(Vector2 vector) {
        if (vector.getLowPrecedenceNode() != null) {
            return vector.getLowPrecedenceNode().prettyPrint(0);
        }
        else return "(" +
                vector.getX().prettyPrint(0) + ", " +
                vector.getY().prettyPrint(0) + ")";
    }
}
