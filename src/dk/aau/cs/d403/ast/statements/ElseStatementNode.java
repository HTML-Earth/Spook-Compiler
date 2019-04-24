package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.structure.BlockNode;

public class ElseStatementNode extends StatementNode {
    private BlockNode elseBlock;
    private StatementNode elseStatement;

    public ElseStatementNode(BlockNode elseBlock) {
        this.elseBlock = elseBlock;
    }

    public ElseStatementNode(StatementNode elseStatement) {
        this.elseStatement = elseStatement;
    }

    public BlockNode getElseBlock() {
        return elseBlock;
    }

    public StatementNode getElseStatement() {
        return elseStatement;
    }

    @Override
    public String prettyPrint() {
        return "Else statement";
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
