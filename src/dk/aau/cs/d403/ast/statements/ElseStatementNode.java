package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.CodePosition;

public class ElseStatementNode extends StatementNode {
    private ConditionalBlockNode elseBlock;

    public ElseStatementNode(ConditionalBlockNode elseBlock) {
        this.elseBlock = elseBlock;
    }

    public ConditionalBlockNode getElseBlock() {
        return elseBlock;
    }

    @Override
    public String prettyPrint() {
        return "else " + elseBlock.prettyPrint();
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
