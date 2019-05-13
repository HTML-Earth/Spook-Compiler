package dk.aau.cs.d403.codegen;

import dk.aau.cs.d403.CompilerException;
import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.ast.statements.*;
import dk.aau.cs.d403.spook.Vector2;
import dk.aau.cs.d403.spook.Vector3;
import dk.aau.cs.d403.spook.Vector4;

import java.util.ArrayList;

import static dk.aau.cs.d403.ast.Enums.Operator.SUB;
import static dk.aau.cs.d403.ast.Enums.operatorToString;

public class PrintGLSL {

    public static String printVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
        StringBuilder sb = new StringBuilder();
        sb.append(Enums.dataTypeToStringGLSL(variableDeclarationNode.getDataType()));
        sb.append(" ");
        for (VarDeclInitNode varDeclInitNode : variableDeclarationNode.getVarDeclInitNodes()) {
            if (varDeclInitNode.getAssignmentNode() != null)
                sb.append(printAssignment(varDeclInitNode.getAssignmentNode()));
            else
                sb.append(varDeclInitNode.getVariableName()).append(";");
        }


        return sb.toString();
    }

    public static String printAssignment(AssignmentNode assignmentNode) {
        return assignmentNode.getVariableName() + " = " + printExpression(assignmentNode.getExpressionNode()) + ";";
    }

    public static String printExpression(ExpressionNode expressionNode) {
        if (expressionNode instanceof ArithExpressionNode)
            return printArithExpression((ArithExpressionNode)expressionNode);
        else if (expressionNode instanceof BoolExpressionNode)
            throw new CompilerException("Not yet implemented", expressionNode.getCodePosition());
        else if (expressionNode instanceof Vector4ExpressionNode)
            return printVector4Expression((Vector4ExpressionNode)expressionNode);
        else if (expressionNode instanceof Vector3ExpressionNode)
            return printVector3Expression((Vector3ExpressionNode)expressionNode);
        else if (expressionNode instanceof Vector2ExpressionNode)
            return printVector2Expression((Vector2ExpressionNode)expressionNode);
        else
            throw new CompilerException("Invalid Expression", expressionNode.getCodePosition());
    }

    public static String printVector2Expression(Vector2ExpressionNode vector4ExpressionNode) {
        return "vec2(" +
                printArithExpression(vector4ExpressionNode.getArithExpressionNode1()) + ", " +
                printArithExpression(vector4ExpressionNode.getArithExpressionNode2()) + ")";
    }

    public static String printVector3Expression(Vector3ExpressionNode vector4ExpressionNode) {
        return "vec3(" +
                printArithExpression(vector4ExpressionNode.getArithExpressionNode1()) + ", " +
                printArithExpression(vector4ExpressionNode.getArithExpressionNode2()) + ", " +
                printArithExpression(vector4ExpressionNode.getArithExpressionNode3()) + ")";
    }

    public static String printVector4Expression(Vector4ExpressionNode vector4ExpressionNode) {
        return "vec4(" +
                printArithExpression(vector4ExpressionNode.getArithExpressionNode1()) + ", " +
                printArithExpression(vector4ExpressionNode.getArithExpressionNode2()) + ", " +
                printArithExpression(vector4ExpressionNode.getArithExpressionNode3()) + ", " +
                printArithExpression(vector4ExpressionNode.getArithExpressionNode4()) + ")";
    }

    public static String printArithExpression(ArithExpressionNode arithExpressionNode) {
        return printLowPrecedence(arithExpressionNode.getLowPrecedenceNode());
    }

    public static String printLowPrecedence(LowPrecedenceNode lowPrecedenceNode) {
        //THIS HAS BEEN COPY PASTA'D FROM LowPrecedenceNode.prettyPrint()
        int matchHigh = 0;
        ArrayList<HighPrecedenceNode> highPrecedenceNodes = lowPrecedenceNode.getHighPrecedenceNodes();
        ArrayList<Enums.Operator> operators = lowPrecedenceNode.getOperators();
        if (highPrecedenceNodes != null && operators != null) {
            if (!highPrecedenceNodes.isEmpty() && !operators.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (HighPrecedenceNode highPrecedenceNode : highPrecedenceNodes) {
                    //Get the highNode
                    sb.append(printHighPrecedence(highPrecedenceNode));
                    //Get operator matching the highNode
                    if (matchHigh < highPrecedenceNodes.size() - 1) {
                        sb.append(operatorToString(operators.get(matchHigh)));
                        matchHigh++;
                    }
                }
                return sb.toString();
            } else
                return "LowPrecedenceNode receives empty list";
        }
        //Single HighNode
        else if (highPrecedenceNodes != null) {
            return printHighPrecedence(highPrecedenceNodes.get(0));
        } else
            return "Invalid Low Precedence Operation";
    }

    public static String printHighPrecedence(HighPrecedenceNode highPrecedenceNode) {
        //THIS HAS BEEN COPY PASTA'D FROM HighPrecedenceNode.prettyPrint()
        int matchAtom = 0;
        ArrayList<AtomPrecedenceNode> atomPrecedenceNodes = highPrecedenceNode.getAtomPrecedenceNodes();
        ArrayList<Enums.Operator> operators = highPrecedenceNode.getOperators();
        if (atomPrecedenceNodes != null && operators != null) {
            if (!atomPrecedenceNodes.isEmpty() && !operators.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (AtomPrecedenceNode atomPrecedenceNode : atomPrecedenceNodes) {
                    //Get the AtomNode
                    sb.append(printAtomPrecedence(atomPrecedenceNode));
                    //Get operator matching the AtomNode
                    if (matchAtom < atomPrecedenceNodes.size() - 1) {
                        sb.append(operatorToString(operators.get(matchAtom)));
                        matchAtom++;
                    }
                }
                return sb.toString();
            } else
                return "HighPrecedenceNode receives empty list";
        } else if (atomPrecedenceNodes != null && !atomPrecedenceNodes.isEmpty()) {
            return printAtomPrecedence(atomPrecedenceNodes.get(0));
        } else
            return "Invalid High Precedence Operation";
    }

    public static String printAtomPrecedence(AtomPrecedenceNode atomPrecedenceNode) {
        ArithOperandNode operand = atomPrecedenceNode.getOperand();
        Enums.Operator operator = atomPrecedenceNode.getOperator();
        LowPrecedenceNode lowPrecedenceNode = atomPrecedenceNode.getLowPrecedenceNode();

        //THIS HAS BEEN COPY PASTA'D FROM AtomPrecedenceNode.prettyPrint()

        //Print -operand
        if (operand != null && operator != null) {
            return Enums.operatorToString(SUB)
                    + printArithOperand(operand);
        }
        //Print operand
        else if (operand != null) {
            return printArithOperand(operand);
        }
        //Print Parenthesis
        else if (lowPrecedenceNode != null) {
            return "(" + printLowPrecedence(lowPrecedenceNode) + ")";
        } else
            return "Invalid Atom Precedence Operation";
    }

    public static String printNonObjectFunctionCall(NonObjectFunctionCallNode nonObjectFunctionCallNode) {
        StringBuilder sb = new StringBuilder();
        ArrayList<ObjectArgumentNode> argumentNodes = nonObjectFunctionCallNode.getArgumentNodes();

        sb.append(nonObjectFunctionCallNode.getFunctionName());
        sb.append("(");

        if (argumentNodes != null) {
            //Print ',' before each arg except the first
            boolean firstArg = true;
            for (ObjectArgumentNode arg : argumentNodes) {
                if (!firstArg)
                    sb.append(", ");
                else
                    firstArg = false;
                sb.append(printObjArgNode(arg));
            }
        }

        sb.append(")");

        return sb.toString();
    }

    public static String printObjectFunctionCall(ObjectFunctionCallNode objectFunctionCallNode) {
        return objectFunctionCallNode.prettyPrint(0);
    }

    public static String printArithOperand(ArithOperandNode arithOperandNode) {
        RealNumberNode realNumberNode = arithOperandNode.getRealNumberNode();
        NonObjectFunctionCallNode nonObjectFunctionCallNode = arithOperandNode.getNonObjectFunctionCallNode();
        ObjectFunctionCallNode objectFunctionCallNode = arithOperandNode.getObjectFunctionCallNode();
        String variableName = arithOperandNode.getVariableName();
        SwizzleNode swizzleNode = arithOperandNode.getSwizzleNode();
        Vector2ExpressionNode vector2ExpressionNode = arithOperandNode.getVector2ExpressionNode();
        Vector3ExpressionNode vector3ExpressionNode = arithOperandNode.getVector3ExpressionNode();
        Vector4ExpressionNode vector4ExpressionNode = arithOperandNode.getVector4ExpressionNode();

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
            return variableName;
        }
        else if (swizzleNode != null) {
            return swizzleNode.prettyPrint(0);
        }
        else if (vector2ExpressionNode != null) {
            return vector2ExpressionNode.prettyPrint(0);
        }
        else if (vector3ExpressionNode != null) {
            return vector3ExpressionNode.prettyPrint(0);
        }
        else if (vector4ExpressionNode != null) {
            return vector4ExpressionNode.prettyPrint(0);
        }
        else throw new RuntimeException("Invalid arith operand");
    }

    public static String printRealNumber(RealNumberNode realNumberNode) {
        return realNumberNode.prettyPrint(0);
    }

    public static String printObjArgNode(ObjectArgumentNode node) {
        return printLowPrecedence(node.getLowPrecedence());
    }

    public static String printVector2(Vector2 vector){
        if (vector.getLowPrecedenceNode() != null) {
            return "vec2" + printLowPrecedence(vector.getLowPrecedenceNode());
        }
        else return "vec2(" +
                printObjArgNode(vector.getX()) + ", " +
                printObjArgNode(vector.getY()) + ")";
    }

    public static String printVector3(Vector3 vector){
        return "vec3(" +
                printObjArgNode(vector.getX()) + ", " +
                printObjArgNode(vector.getY()) + ", " +
                printObjArgNode(vector.getZ()) + ")";
    }

    public static String printVector4(Vector4 vector){
        return "vec4(" +
                printObjArgNode(vector.getX()) + ", " +
                printObjArgNode(vector.getY()) + ", " +
                printObjArgNode(vector.getZ()) + ", " +
                printObjArgNode(vector.getW()) + ")";
    }
}
