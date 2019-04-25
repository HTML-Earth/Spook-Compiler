package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.expressions.BoolExpressionNode;
import dk.aau.cs.d403.ast.structure.BlockNode;

public class ElseIfStatementNode extends StatementNode {
    private BoolExpressionNode elseIfBool;
    private BlockNode elseIfBlock;
    private StatementNode elseIfStatement;

    public ElseIfStatementNode(BoolExpressionNode elseIfBool, StatementNode elseIfStatement) {
        this.elseIfBool = elseIfBool;
        this.elseIfStatement = elseIfStatement;
    }

    public ElseIfStatementNode(BoolExpressionNode elseIfBool, BlockNode elseIfBlock) {
        this.elseIfBool = elseIfBool;
        this.elseIfBlock = elseIfBlock;
    }

    public BoolExpressionNode getElseIfBool() {
        return elseIfBool;
    }

    public BlockNode getElseIfBlock() {
        return elseIfBlock;
    }

    public StatementNode getElseIfStatement() {
        return elseIfStatement;
    }

    @Override
    public String prettyPrint() {
        return "If else statement";
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
