package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.statements.NonObjectFunctionCallNode;
import dk.aau.cs.d403.ast.statements.ObjectFunctionCallNode;

public class ConditionalExpressionNode implements ASTnode {
    private BoolExpressionNode boolExpressionNode;
    private String variableName;
    private NonObjectFunctionCallNode nonObjectFunctionCallNode;
    private ObjectFunctionCallNode objectFunctionCallNode;

    public ConditionalExpressionNode(BoolExpressionNode boolExpressionNode) {
        this.boolExpressionNode = boolExpressionNode;
    }

    public ConditionalExpressionNode(String variableName) {
        this.variableName = variableName;
    }

    public ConditionalExpressionNode(NonObjectFunctionCallNode nonObjectFunctionCallNode) {
        this.nonObjectFunctionCallNode = nonObjectFunctionCallNode;
    }

    public ConditionalExpressionNode(ObjectFunctionCallNode objectFunctionCallNode) {
        this.objectFunctionCallNode = objectFunctionCallNode;
    }

    public BoolExpressionNode getBoolExpressionNode() {
        return boolExpressionNode;
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
    public String prettyPrint(int indent) {
        if (boolExpressionNode != null)
            return boolExpressionNode.prettyPrint(indent);
        else if (variableName != null)
            return variableName;
        else if (nonObjectFunctionCallNode != null)
            return nonObjectFunctionCallNode.prettyPrint(indent);
        else if (objectFunctionCallNode != null)
            return objectFunctionCallNode.prettyPrint(indent);
        else
            return "Invalid Conditional Expression";
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
