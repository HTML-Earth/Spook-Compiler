package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.Enums;

import java.util.ArrayList;

import static dk.aau.cs.d403.ast.Enums.operatorToString;

public class HighPrecedenceNode implements ASTnode {
    private AtomPrecedenceNode atomPrecedenceNode;
    private ArrayList<AtomPrecedenceNode> atomPrecedenceNodes;
    private ArrayList<Enums.Operator> operators;

    //High -> Atom
    public HighPrecedenceNode(AtomPrecedenceNode atomPrecedenceNode) {
        this.atomPrecedenceNode = atomPrecedenceNode;
    }

    //High -> Atom (Operator Atom)*
    public HighPrecedenceNode(AtomPrecedenceNode atomPrecedenceNode, ArrayList<AtomPrecedenceNode> atomPrecedenceNodes, ArrayList<Enums.Operator> operators) {
        //Check for low precedence operators
        if (operators.contains(Enums.Operator.ADD) || operators.contains(Enums.Operator.SUB)) {
            throw new IllegalArgumentException("ADD & SUB are not High Precedence");
        }
        this.atomPrecedenceNode = atomPrecedenceNode;
        this.atomPrecedenceNodes = atomPrecedenceNodes;
        this.operators = operators;
    }

    public AtomPrecedenceNode getAtomPrecedenceNode() {
        return atomPrecedenceNode;
    }

    public ArrayList<AtomPrecedenceNode> getAtomPrecedenceNodes() {
        return atomPrecedenceNodes;
    }

    public ArrayList<Enums.Operator> getOperators() {
        return operators;
    }

    @Override
    public String prettyPrint() {
        int matchAtom = 0;
        if (atomPrecedenceNode != null && !atomPrecedenceNodes.isEmpty() && !operators.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (AtomPrecedenceNode atomPrecedenceNode : atomPrecedenceNodes) {
                //Get operator matching the AtomNode
                sb.append(operatorToString(operators.get(matchAtom)));
                //Get the AtomNode
                sb.append(atomPrecedenceNode.prettyPrint());
                matchAtom++;
            }
            return atomPrecedenceNode.prettyPrint() + sb.toString();
        } else if (atomPrecedenceNode != null) {
            return atomPrecedenceNode.prettyPrint();
        } else
            return "Invalid High Precedence Operation";
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
