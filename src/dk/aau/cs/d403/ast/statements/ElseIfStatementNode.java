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
    public String prettyPrint(int indent) {
        if (elseIfBlock != null) {
            return "else if (" + elseIfBool.prettyPrint(indent) + ") " + elseIfBlock.prettyPrint(indent);
        }
        else if (elseIfStatement != null) {
            return "else if (" + elseIfBool.prettyPrint(indent) + ")\n" + elseIfStatement.prettyPrint(indent + 1);
        }
        else
            return "Invalid ElseIf statement";
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
