package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.errorhandling.CompilerException;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.statements.NonObjectFunctionCallNode;
import dk.aau.cs.d403.ast.statements.ObjectFunctionCallNode;

public class TernaryOperatorNode extends ExpressionNode {
    private BoolExpressionNode boolExpressionNode;
    private ExpressionNode expressionNode1;
    private ExpressionNode expressionNode2;
    private String variableName;
    private Enums.BoolOperator boolOperator;
    private NonObjectFunctionCallNode nonObjectFunctionCallNode;
    private ObjectFunctionCallNode objectFunctionCallNode;

    public TernaryOperatorNode(BoolExpressionNode boolExpressionNode, ExpressionNode expressionNode1, ExpressionNode expressionNode2) {
        this.boolExpressionNode = boolExpressionNode;
        this.expressionNode1 = expressionNode1;
        this.expressionNode2 = expressionNode2;
    }

    public TernaryOperatorNode(String variableName, ExpressionNode expressionNode1, ExpressionNode expressionNode2) {
        this.expressionNode1 = expressionNode1;
        this.expressionNode2 = expressionNode2;
        this.variableName = variableName;
    }

    public TernaryOperatorNode(Enums.BoolOperator boolOperator, String variableName,ExpressionNode expressionNode1, ExpressionNode expressionNode2) {
        if (boolOperator != Enums.BoolOperator.NOT)
            throw new IllegalArgumentException("Boolean operator must be 'NOT'");
        this.expressionNode1 = expressionNode1;
        this.expressionNode2 = expressionNode2;
        this.variableName = variableName;
        this.boolOperator = boolOperator;
    }

    public TernaryOperatorNode(NonObjectFunctionCallNode nonObjectFunctionCallNode, ExpressionNode expressionNode1, ExpressionNode expressionNode2) {
        this.expressionNode1 = expressionNode1;
        this.expressionNode2 = expressionNode2;
        this.nonObjectFunctionCallNode = nonObjectFunctionCallNode;
    }

    public TernaryOperatorNode(ObjectFunctionCallNode objectFunctionCallNode, ExpressionNode expressionNode1, ExpressionNode expressionNode2) {
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

    public Enums.BoolOperator getBoolOperator() {
        return boolOperator;
    }

    @Override
    public String prettyPrint(int indent) {
        if (boolExpressionNode != null)
            return boolExpressionNode.prettyPrint(indent) + " ? " + expressionNode1.prettyPrint(indent) + " : " + expressionNode2.prettyPrint(indent);
        else if (variableName != null)
            return variableName + " ? " + expressionNode1.prettyPrint(indent) + " : " + expressionNode2.prettyPrint(indent);
        else if (nonObjectFunctionCallNode != null)
            return nonObjectFunctionCallNode.prettyPrint(indent) + " ? " + expressionNode1.prettyPrint(indent) + " : " + expressionNode2.prettyPrint(indent);
        else if (objectFunctionCallNode != null)
            return objectFunctionCallNode.prettyPrint(indent) + " ? " + expressionNode1.prettyPrint(indent) + " : " + expressionNode2.prettyPrint(indent);
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
