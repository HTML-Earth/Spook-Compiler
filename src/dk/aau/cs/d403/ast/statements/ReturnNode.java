package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.expressions.ExpressionNode;
import dk.aau.cs.d403.ast.expressions.RealNumberNode;

public class ReturnNode extends StatementNode {
    private String variableName;
    private RealNumberNode realNumberNode;
    private boolean boolLiteral;
    private ExpressionNode expressionNode;

    public ReturnNode(String variableName) {
        this.variableName = variableName;
    }

    public ReturnNode(RealNumberNode realNumberNode) {
        this.realNumberNode = realNumberNode;
    }

    public ReturnNode(boolean boolLiteral) {
        this.boolLiteral = boolLiteral;
    }

    public ReturnNode(ExpressionNode expressionNode) {
        this.expressionNode = expressionNode;
    }

    public String getVariableName() {
        return variableName;
    }

    public RealNumberNode getRealNumberNode() {
        return realNumberNode;
    }

    public boolean isBoolLiteral() {
        return boolLiteral;
    }

    @Override
    public String prettyPrint() {
        String returnValue;

        if (variableName != null)
            returnValue = variableName;
        else if (realNumberNode != null)
            returnValue = realNumberNode.prettyPrint();
        else
            returnValue = "" + boolLiteral;

        return "return " + returnValue + ";";
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
