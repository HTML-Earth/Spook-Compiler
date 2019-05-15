package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.CompilerException;
import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.statements.NonObjectFunctionCallNode;

import java.util.ArrayList;

import static dk.aau.cs.d403.ast.Enums.operatorToString;
import static dk.aau.cs.d403.ast.Enums.returnTypeToStringGLSL;

public class LowPrecedenceNode implements ASTnode {
    private ArrayList<HighPrecedenceNode> highPrecedenceNodes;
    private ArrayList<Enums.Operator> operators;

    //Low -> High
    public LowPrecedenceNode(ArrayList<HighPrecedenceNode> highPrecedenceNodes) {
        this.highPrecedenceNodes = highPrecedenceNodes;
    }

    public LowPrecedenceNode(HighPrecedenceNode highPrecedenceNode) {
        this.highPrecedenceNodes = new ArrayList<>();
        this.highPrecedenceNodes.add(highPrecedenceNode);
    }

    //Low -> High (Operator High)*
    public LowPrecedenceNode(ArrayList<HighPrecedenceNode> highPrecedenceNodes, ArrayList<Enums.Operator> operators) {
        //Check for illegal operators
        if (!(operators.contains(Enums.Operator.ADD) || operators.contains(Enums.Operator.SUB))) {
            throw new CompilerException("MUL, DIV & MOD are not Low Precedence", getCodePosition());
        }
        this.highPrecedenceNodes = highPrecedenceNodes;
        this.operators = operators;
    }

    public LowPrecedenceNode(double number) {
        RealNumberNode realNumberNode = new RealNumberNode(number);
        ArithOperandNode arithOperandNode = new ArithOperandNode(realNumberNode);
        AtomPrecedenceNode atomPrecedenceNode = new AtomPrecedenceNode(arithOperandNode);
        ArrayList<AtomPrecedenceNode> atomPrecedenceNodes = new ArrayList<>();
        atomPrecedenceNodes.add(atomPrecedenceNode);
        this.highPrecedenceNodes = new ArrayList<>();
        this.highPrecedenceNodes.add(new HighPrecedenceNode(atomPrecedenceNodes));
    }


    public LowPrecedenceNode(Vector2ExpressionNode vector2ExpressionNode) {
        this.highPrecedenceNodes = new ArrayList<>();
        this.highPrecedenceNodes.add(new HighPrecedenceNode(vector2ExpressionNode));
    }

    public LowPrecedenceNode(NonObjectFunctionCallNode nonObjectFunctionCallNode) {
        this.highPrecedenceNodes = new ArrayList<>();
        this.highPrecedenceNodes.add(new HighPrecedenceNode(nonObjectFunctionCallNode));
    }

    public ArrayList<HighPrecedenceNode> getHighPrecedenceNodes() {
        return highPrecedenceNodes;
    }

    public ArrayList<Enums.Operator> getOperators() {
        return operators;
    }

    @Override
    public String prettyPrint(int indent) {
        int matchHigh = 0;
        if (highPrecedenceNodes != null && operators != null) {
            if (!highPrecedenceNodes.isEmpty() && !operators.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (HighPrecedenceNode highPrecedenceNode : highPrecedenceNodes) {
                    //Get the highNode
                    sb.append(highPrecedenceNode.prettyPrint(indent));
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
            return highPrecedenceNodes.get(0).prettyPrint(indent);
        } else
            return "Invalid Low Precedence Operation";
    }

    private CodePosition codePosition;

    @Override
    public void setCodePosition(CodePosition codePosition) {
        this.codePosition = codePosition;
    }

    @Override
    public CodePosition getCodePosition() {
        return codePosition;
    }

    public static LowPrecedenceNode zero() {
        ArrayList<HighPrecedenceNode> highPrecedenceNodes = new ArrayList<>();
        highPrecedenceNodes.add(HighPrecedenceNode.zero());
        return new LowPrecedenceNode(highPrecedenceNodes);
    }

    public static LowPrecedenceNode add(LowPrecedenceNode a, LowPrecedenceNode b) {
        return LowPrecedenceNode.operate(a,b, Enums.Operator.ADD);
    }

    public static LowPrecedenceNode sub(LowPrecedenceNode a, LowPrecedenceNode b) {
        return LowPrecedenceNode.operate(a,b, Enums.Operator.SUB);
    }

    public static LowPrecedenceNode mod(LowPrecedenceNode a, LowPrecedenceNode b) {
        return LowPrecedenceNode.operate(a,b, Enums.Operator.MOD);
    }

    public static LowPrecedenceNode div(LowPrecedenceNode a, LowPrecedenceNode b) {
        return LowPrecedenceNode.operate(a,b, Enums.Operator.DIV);
    }

    public static LowPrecedenceNode mul(LowPrecedenceNode a, LowPrecedenceNode b) {
        return LowPrecedenceNode.operate(a,b, Enums.Operator.MUL);
    }

    public static LowPrecedenceNode operate(LowPrecedenceNode a, LowPrecedenceNode b, Enums.Operator operator) {
        ArrayList<HighPrecedenceNode> highPrecedenceNodes = new ArrayList<>();
        ArrayList<Enums.Operator> operators = new ArrayList<>();

        ArrayList<HighPrecedenceNode> highPrecedenceNodesA = a.getHighPrecedenceNodes();
        if (highPrecedenceNodesA != null) {
            if (highPrecedenceNodesA.size() > 0) {
                highPrecedenceNodes.add(highPrecedenceNodesA.get(0));
                if (a.getOperators() != null) {
                    int operatorAmt = a.getOperators().size();
                    for (int i = 0; i < operatorAmt; i++) {
                        operators.add(a.getOperators().get(i));
                        highPrecedenceNodes.add(highPrecedenceNodesA.get(i+1));
                    }
                }
            }
        }

        operators.add(operator);

        ArrayList<HighPrecedenceNode> highPrecedenceNodesB = b.getHighPrecedenceNodes();
        if (highPrecedenceNodesB != null) {
            if (highPrecedenceNodesB.size() > 0) {
                highPrecedenceNodes.add(highPrecedenceNodesB.get(0));
                if (b.getOperators() != null) {
                    int operatorAmt = b.getOperators().size();
                    for (int i = 0; i < operatorAmt; i++) {
                        operators.add(b.getOperators().get(i));
                        highPrecedenceNodes.add(highPrecedenceNodesB.get(i+1));
                    }
                }
            }
        }

        return new LowPrecedenceNode(highPrecedenceNodes, operators);
    }
}
