package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.CompilerException;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.statements.NonObjectFunctionCallNode;
import dk.aau.cs.d403.ast.statements.ObjectFunctionCallNode;

public class TernaryOperatorNode extends ExpressionNode {
    private BoolExpressionNode boolExpressionNode;
    private ExpressionNode expressionNode1;
    private ExpressionNode expressionNode2;
    private String variableName;
    private NonObjectFunctionCallNode nonObjectFunctionCallNode;
    private ObjectFunctionCallNode objectFunctionCallNode;

    public TernaryOperatorNode(BoolExpressionNode boolExpressionNode, ExpressionNode expressionNode1, ExpressionNode expressionNode2) {
        this.boolExpressionNode = boolExpressionNode;
        this.expressionNode1 = expressionNode1;
        this.expressionNode2 = expressionNode2;
    }

    public TernaryOperatorNode(ExpressionNode expressionNode1, ExpressionNode expressionNode2, String variableName) {
        this.expressionNode1 = expressionNode1;
        this.expressionNode2 = expressionNode2;
        this.variableName = variableName;
    }

    public TernaryOperatorNode(ExpressionNode expressionNode1, ExpressionNode expressionNode2, NonObjectFunctionCallNode nonObjectFunctionCallNode) {
        this.expressionNode1 = expressionNode1;
        this.expressionNode2 = expressionNode2;
        this.nonObjectFunctionCallNode = nonObjectFunctionCallNode;
    }

    public TernaryOperatorNode(ExpressionNode expressionNode1, ExpressionNode expressionNode2, ObjectFunctionCallNode objectFunctionCallNode) {
        this.expressionNode1 = expressionNode1;
        this.expressionNode2 = expressionNode2;
        this.objectFunctionCallNode = objectFunctionCallNode;
    }

    public BoolExpressionNode getBoolExpressionNode() {
        return boolExpressionNode;
    }

    public ExpressionNode getExpressionNode1() {
        return expressionNode1;
    }

    public ExpressionNode getExpressionNode2() {
        return expressionNode2;
    }

    public String getVariableName() {
        return variableName;
    }

    public NonObjectFunctionCallNode getNonObjectFunctionCallNode() {
        return nonObjectFunctionCallNode;
    }

    public ObjectFunctionCallNode getObjectFunctionCallNode() {
        return objectFunctionCallNode;
    }

    @Override
    public String prettyPrint() {
        if (boolExpressionNode != null)
            return boolExpressionNode.prettyPrint() + " ? " + expressionNode1.prettyPrint() + " : " + expressionNode2.prettyPrint();
        else if (variableName != null)
            return variableName + " ? " + expressionNode1.prettyPrint() + " : " + expressionNode2.prettyPrint();
        else if (nonObjectFunctionCallNode != null)
            return nonObjectFunctionCallNode.prettyPrint() + " ? " + expressionNode1.prettyPrint() + " : " + expressionNode2.prettyPrint();
        else if (objectFunctionCallNode != null)
            return objectFunctionCallNode.prettyPrint() + " ? " + expressionNode1.prettyPrint() + " : " + expressionNode2.prettyPrint();
        else
            throw new CompilerException("Invalid Ternary Operation", codePosition);
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
