package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.CodePosition;

public class ArithExpressionNode extends ExpressionNode {
    private LowPrecedenceNode lowPrecedenceNode;

    public ArithExpressionNode(LowPrecedenceNode lowPrecedenceNode) {
        this.lowPrecedenceNode = lowPrecedenceNode;
    }

    public LowPrecedenceNode getLowPrecedenceNode() {
        return lowPrecedenceNode;
    }

    @Override
    public String prettyPrint() {
        return "Arithmetic Expression";
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
