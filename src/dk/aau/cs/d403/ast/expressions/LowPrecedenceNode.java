package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.Enums;

import java.util.ArrayList;

import static dk.aau.cs.d403.ast.Enums.operatorToString;

public class LowPrecedenceNode implements ASTnode {
    private HighPrecedenceNode highPrecedenceNode;
    private ArrayList<HighPrecedenceNode> highPrecedenceNodes;
    private ArrayList<Enums.Operator> operators;

    //Low -> High
    public LowPrecedenceNode(HighPrecedenceNode highPrecedenceNode) {
        this.highPrecedenceNode = highPrecedenceNode;
    }

    //Low -> High (Operator High)*
    public LowPrecedenceNode(HighPrecedenceNode highPrecedenceNode, ArrayList<HighPrecedenceNode> highPrecedenceNodes, ArrayList<Enums.Operator> operators) {
        //Check for illegal operators
        if (!(operators.contains(Enums.Operator.ADD) || operators.contains(Enums.Operator.SUB))) {
            throw new IllegalArgumentException("MUL, DIV & MOD are not Low Precedence");
        }
        this.highPrecedenceNode = highPrecedenceNode;
        this.highPrecedenceNodes = highPrecedenceNodes;
        this.operators = operators;
    }

    public HighPrecedenceNode getHighPrecedenceNode() {
        return highPrecedenceNode;
    }

    public ArrayList<HighPrecedenceNode> getHighPrecedenceNodes() {
        return highPrecedenceNodes;
    }

    public ArrayList<Enums.Operator> getOperators() {
        return operators;
    }

    @Override
    public String prettyPrint() {
        int matchHigh = 0;
        if (highPrecedenceNode != null && !highPrecedenceNodes.isEmpty() && !operators.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (HighPrecedenceNode highPrecedenceNode : highPrecedenceNodes) {
                //Get operator matching the highNode
                sb.append(operatorToString(operators.get(matchHigh)));
                //Get the highNode
                sb.append(highPrecedenceNode.prettyPrint());
                matchHigh++;
            }
            return highPrecedenceNode.prettyPrint() + sb.toString();
        } else if (highPrecedenceNode != null) {
            return highPrecedenceNode.prettyPrint();
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
}
