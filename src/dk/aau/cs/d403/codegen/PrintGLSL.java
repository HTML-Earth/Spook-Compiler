package dk.aau.cs.d403.codegen;

import dk.aau.cs.d403.ast.structure.BlockNode;
import dk.aau.cs.d403.ast.structure.FunctionDeclarationNode;
import dk.aau.cs.d403.errorhandling.CompilerException;
import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.ast.statements.*;
import dk.aau.cs.d403.spook.Vector2;
import dk.aau.cs.d403.spook.Vector3;
import dk.aau.cs.d403.spook.Vector4;

import java.awt.font.ImageGraphicAttribute;
import java.util.ArrayList;

import static dk.aau.cs.d403.ast.Enums.Operator.SUB;
import static dk.aau.cs.d403.ast.Enums.operatorToString;
import static dk.aau.cs.d403.ast.Enums.returnTypeToStringGLSL;

public class PrintGLSL {

    public static String printVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
        StringBuilder sb = new StringBuilder();
        sb.append(Enums.dataTypeToStringGLSL(variableDeclarationNode.getDataType()));
        sb.append(" ");
        for (VarDeclInitNode varDeclInitNode : variableDeclarationNode.getVarDeclInitNodes()) {
            if (varDeclInitNode.getAssignmentNode() != null)
                sb.append(printAssignment(varDeclInitNode.getAssignmentNode()));
            else
                sb.append(varDeclInitNode.getAssignmentNode().getVariableName()).append(";");
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
            return printBoolExpression((BoolExpressionNode)expressionNode);
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
                sb.append("(");
                for (HighPrecedenceNode highPrecedenceNode : highPrecedenceNodes) {
                    //Get the highNode
                    sb.append(printHighPrecedence(highPrecedenceNode));
                    //Get operator matching the highNode
                    if (matchHigh < highPrecedenceNodes.size() - 1) {
                        sb.append(operatorToString(operators.get(matchHigh)));
                        matchHigh++;
                    }
                }
                sb.append(")");
                return sb.toString();
            } else
                return "LowPrecedenceNode receives empty list";
        }
        //Single HighNode
        else if (highPrecedenceNodes != null) {
            return "(" + printHighPrecedence(highPrecedenceNodes.get(0)) + ")";
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
            }
            else
                throw new CompilerException("HighPrecedenceNode receives empty list", highPrecedenceNode.getCodePosition());
        } else if (atomPrecedenceNodes != null && !atomPrecedenceNodes.isEmpty()) {
            return printAtomPrecedence(atomPrecedenceNodes.get(0));
        } else
            throw new CompilerException("Invalid High Precedence Operation", highPrecedenceNode.getCodePosition());
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

    public static String printBoolExpression(BoolExpressionNode boolExpressionNode) {
        return boolExpressionNode.prettyPrint(0); //TODO: this might need to use custom code instead of pp
    }

    public static String printFunctionDeclaration(FunctionDeclarationNode functionDeclarationNode, boolean prototype) {
        StringBuilder sb = new StringBuilder();

        sb.append(Enums.dataTypeToStringGLSL(functionDeclarationNode.getReturnType()));
        sb.append(" ");
        sb.append(functionDeclarationNode.getFunctionName());
        sb.append("(");

        if (functionDeclarationNode.getFunctionArgNodes() != null)
            for (int i = 0; i < functionDeclarationNode.getFunctionArgNodes().size(); i++) {
                String arg = printFunctionArg(functionDeclarationNode.getFunctionArgNodes().get(i));
                sb.append(i < functionDeclarationNode.getFunctionArgNodes().size()-1 ? arg + ", " : arg);
            }

        sb.append(")");

        if (prototype)
            sb.append(";");
        else {
            sb.append(printFunctionBlock(functionDeclarationNode.getBlockNode()));
        }

        sb.append("\n\n");

        return sb.toString();
    }

    public static String printFunctionArg(FunctionArgNode functionArgNode) {
        if (functionArgNode.getDataType() != null)
            return Enums.dataTypeToStringGLSL(functionArgNode.getDataType()) + " " + functionArgNode.getVariableName();
        else
            throw new CompilerException("Not implemented");
    }

    public static String printFunctionBlock(BlockNode blockNode) {
        StringBuilder sb = new StringBuilder();

        sb.append("{\n");
        for (StatementNode statementNode : blockNode.getStatementNodes()) {
            sb.append("\t");
            sb.append(printStatement(statementNode));
            sb.append("\n");
        }
        sb.append("}");

        return sb.toString();
    }

    public static String printStatement(StatementNode statementNode) {
        if (statementNode instanceof DeclarationNode)
            return printDeclaration((DeclarationNode)statementNode);
        else if (statementNode instanceof AssignmentNode)
            return printAssignment((AssignmentNode)statementNode);
        else if (statementNode instanceof NonObjectFunctionCallNode)
            return printNonObjectFunctionCall((NonObjectFunctionCallNode)statementNode);
        else if (statementNode instanceof ForLoopStatementNode)
            return printForLoop((ForLoopStatementNode)statementNode);
        else if (statementNode instanceof IfElseStatementNode)
            return printIfElse((IfElseStatementNode)statementNode);
        else if (statementNode instanceof ReturnNode)
            return printReturn((ReturnNode)statementNode);
        else
            throw new CompilerException("Not implemented");
    }

    public static String printReturn(ReturnNode returnNode) {
        return "return " + printExpression(returnNode.getExpressionNode()) + ";";
    }

    public static String printDeclaration(DeclarationNode declarationNode) {
        if (declarationNode instanceof VariableDeclarationNode)
            return printVariableDeclaration((VariableDeclarationNode)declarationNode);
        else
            throw new CompilerException("Not implemented");
    }

    public static String printForLoop(ForLoopStatementNode forLoopStatementNode) {
        StringBuilder sb = new StringBuilder();

        sb.append("for (");

        sb.append(printForLoopExpression(forLoopStatementNode.getForLoopExpressionNode1(), forLoopStatementNode.getForLoopExpressionNode2()));

        sb.append(")\n");

        sb.append(printConditionalBlock(forLoopStatementNode.getConditionalBlockNode()));

        return sb.toString();
    }

    public static String printForLoopExpression(ForLoopExpressionNode forLoopExpressionNode1, ForLoopExpressionNode forLoopExpressionNode2) {
        StringBuilder sb = new StringBuilder();

        if (forLoopExpressionNode1.getVariableDeclarationNode() != null)
            sb.append(printVariableDeclaration(forLoopExpressionNode1.getVariableDeclarationNode()));
        else if (forLoopExpressionNode1.getAssignmentNode() != null)
            sb.append(printAssignment(forLoopExpressionNode1.getAssignmentNode()));
        else if (forLoopExpressionNode1.getAtomPrecedenceNode() != null)
            sb.append(printAtomPrecedence(forLoopExpressionNode1.getAtomPrecedenceNode()));

        sb.append("; ");

        sb.append("var < ");

        if (forLoopExpressionNode2.getVariableDeclarationNode() != null)
            sb.append(printVariableDeclaration(forLoopExpressionNode2.getVariableDeclarationNode()));
        else if (forLoopExpressionNode2.getAssignmentNode() != null)
            sb.append(printAssignment(forLoopExpressionNode2.getAssignmentNode()));
        else if (forLoopExpressionNode2.getAtomPrecedenceNode() != null)
            sb.append(printAtomPrecedence(forLoopExpressionNode2.getAtomPrecedenceNode()));

        sb.append("; ");

        sb.append("var++");

        return sb.toString();
    }

    public static String printIfElse(IfElseStatementNode ifElseStatementNode) {
        StringBuilder sb = new StringBuilder();

        sb.append(printIf(ifElseStatementNode.getIfStatementNode()));

        sb.append("\n");

        if (ifElseStatementNode.getElseIfStatementNodes() != null)
            for (ElseIfStatementNode elseIfStatementNode : ifElseStatementNode.getElseIfStatementNodes()){
                sb.append(printElseIf(elseIfStatementNode));
                sb.append("\n");
            }

        if (ifElseStatementNode.getElseStatementNode() != null) {
            sb.append(printElse(ifElseStatementNode.getElseStatementNode()));
            sb.append("\n");
        }

        return sb.toString();
    }

    public static String printIf(IfStatementNode ifStatementNode) {
        StringBuilder sb = new StringBuilder();

        sb.append("if (");

        if (ifStatementNode.getIfBool().getBoolExpressionNode() != null)
            sb.append(printBoolExpression(ifStatementNode.getIfBool().getBoolExpressionNode()));
        else if (ifStatementNode.getIfBool().getVariableName() != null)
            sb.append(ifStatementNode.getIfBool().getVariableName());
        else if (ifStatementNode.getIfBool().getNonObjectFunctionCallNode() != null)
            sb.append(printNonObjectFunctionCall(ifStatementNode.getIfBool().getNonObjectFunctionCallNode()));
        else if (ifStatementNode.getIfBool().getObjectFunctionCallNode() != null)
            throw new CompilerException("Not implemented");

        sb.append(")\n");

        sb.append(printConditionalBlock(ifStatementNode.getIfBlock()));

        return sb.toString();
    }

    public static String printElseIf(ElseIfStatementNode elseIfStatementNode) {
        StringBuilder sb = new StringBuilder();

        sb.append("else if (");

        if (elseIfStatementNode.getElseIfBool().getBoolExpressionNode() != null)
            sb.append(printBoolExpression(elseIfStatementNode.getElseIfBool().getBoolExpressionNode()));
        else if (elseIfStatementNode.getElseIfBool().getVariableName() != null)
            sb.append(elseIfStatementNode.getElseIfBool().getVariableName());
        else if (elseIfStatementNode.getElseIfBool().getNonObjectFunctionCallNode() != null)
            sb.append(printNonObjectFunctionCall(elseIfStatementNode.getElseIfBool().getNonObjectFunctionCallNode()));
        else if (elseIfStatementNode.getElseIfBool().getObjectFunctionCallNode() != null)
            throw new CompilerException("Not implemented");

        sb.append(")\n");

        sb.append(printConditionalBlock(elseIfStatementNode.getElseIfBlock()));

        return sb.toString();
    }

    public static String printElse(ElseStatementNode elseStatementNode) {
        StringBuilder sb = new StringBuilder();

        sb.append("else\n");

        sb.append(printConditionalBlock(elseStatementNode.getElseBlock()));

        return sb.toString();
    }

    public static String printConditionalBlock(ConditionalBlockNode conditionalBlockNode) {
        StringBuilder sb = new StringBuilder();

        if (conditionalBlockNode.getStatementNode() != null) {
            sb.append("\t\t");
            sb.append(printStatement(conditionalBlockNode.getStatementNode()));
        }
        else if (conditionalBlockNode.getBlockNode() != null) {
            sb.append("{\n");
            sb.append(printFunctionBlock(conditionalBlockNode.getBlockNode()));
            sb.append("}");
        }

        return sb.toString();
    }

    public static String printNonObjectFunctionCall(NonObjectFunctionCallNode nonObjectFunctionCallNode) {
        StringBuilder sb = new StringBuilder();
        ArrayList<ObjectArgumentNode> argumentNodes = nonObjectFunctionCallNode.getArgumentNodes();

        switch (nonObjectFunctionCallNode.getFunctionName()) {
            case "mix2": case "mix3": case "mix4":
                sb.append("mix");
                break;
            case "cross3":
                sb.append("cross");
                break;
            case "normalize2": case "normalize3": case "normalize4":
                sb.append("normalize");
                break;
            case "reflect2": case "reflect3": case "reflect4":
                sb.append("reflect");
                break;
            case "refract2": case "refract3": case "refract4":
                sb.append("refract");
                break;
            default:
                sb.append(nonObjectFunctionCallNode.getFunctionName());
                break;
        }
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
            return printVariableName(variableName);
        }
        else if (swizzleNode != null) {
            return printSwizzle(swizzleNode);
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

    public static String printSwizzle(SwizzleNode swizzleNode) {
        return printVariableName(swizzleNode.getVariableName()) + "." + swizzleNode.getSwizzle();
    }

    public static String printVariableName(String variableName) {
        switch (variableName) {
            case "Time":
                return "iTime";
            case "Pi":
                return "PI";
            case "Screen":
                return "iResolution";
            default:
                return variableName;
        }
    }

    public static String printRealNumber(RealNumberNode realNumberNode) {
        return realNumberNode.prettyPrint(0);
    }

    public static String printObjArgNode(ObjectArgumentNode node) {
        if (node.getLowPrecedence() != null)
            return printLowPrecedence(node.getLowPrecedence());
        else if (node.getBoolExpression() != null)
            return printBoolExpression(node.getBoolExpression());
        else
            throw new CompilerException("Invalid object arg node", node.getCodePosition());
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
        if (vector.getLowPrecedenceNode() != null) {
            return "vec4" + printLowPrecedence(vector.getLowPrecedenceNode());
        }
        else return "vec4(" +
                printObjArgNode(vector.getX()) + ", " +
                printObjArgNode(vector.getY()) + ", " +
                printObjArgNode(vector.getZ()) + ", " +
                printObjArgNode(vector.getW()) + ")";
    }
}
