package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.CodePosition;

import java.util.ArrayList;

//Extends expressionNode does not match parser //TODO: implement ASTnode
public class Vector2ExpressionNode extends ExpressionNode {
    protected ArithExpressionNode arithExpressionNode1;
    protected ArithExpressionNode arithExpressionNode2;

    public Vector2ExpressionNode(ArithExpressionNode arithExpressionNode1, ArithExpressionNode arithExpressionNode2) {
        this.arithExpressionNode1 = arithExpressionNode1;
        this.arithExpressionNode2 = arithExpressionNode2;
    }

    public Vector2ExpressionNode() {
        // ArithExpression1
        ArrayList<AtomPrecedenceNode> atomPrecedenceNodes = new ArrayList<>();
        AtomPrecedenceNode atomPrecedenceNode = new AtomPrecedenceNode(new ArithOperandNode(new RealNumberNode((float) 0.0)));
        atomPrecedenceNodes.add(atomPrecedenceNode);

        ArrayList<HighPrecedenceNode> highPrecedenceNodes = new ArrayList<>();
        HighPrecedenceNode highPrecedenceNode = new HighPrecedenceNode(atomPrecedenceNodes);
        highPrecedenceNodes.add(highPrecedenceNode);
        arithExpressionNode1 = new ArithExpressionNode(new LowPrecedenceNode(highPrecedenceNodes));

        // ArithExpression2
        ArrayList<AtomPrecedenceNode> atomPrecedenceNodes1 = new ArrayList<>();
        AtomPrecedenceNode atomPrecedenceNode1 = new AtomPrecedenceNode(new ArithOperandNode(new RealNumberNode((float) 0.0)));
        atomPrecedenceNodes.add(atomPrecedenceNode1);

        ArrayList<HighPrecedenceNode> highPrecedenceNodes1 = new ArrayList<>();
        HighPrecedenceNode highPrecedenceNode1 = new HighPrecedenceNode(atomPrecedenceNodes1);
        highPrecedenceNodes1.add(highPrecedenceNode1);
        arithExpressionNode1 = new ArithExpressionNode(new LowPrecedenceNode(highPrecedenceNodes1));
    }

    public ArithExpressionNode getArithExpressionNode1() {
        return arithExpressionNode1;
    }

    public ArithExpressionNode getArithExpressionNode2() {
        return arithExpressionNode2;
    }

    @Override
    public String prettyPrint(int indent) {
        return "(" + arithExpressionNode1.prettyPrint(indent)
                + ", " + arithExpressionNode2.prettyPrint(indent)
                + ")";
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
