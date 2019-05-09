package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.expressions.ConditionalExpressionNode;

public class ElseIfStatementNode extends StatementNode {
    private ConditionalExpressionNode elseIfBool;
    private ConditionalBlockNode elseIfBlock;

    public ElseIfStatementNode(ConditionalExpressionNode elseIfBool, ConditionalBlockNode elseIfBlock) {
        this.elseIfBool = elseIfBool;
        this.elseIfBlock = elseIfBlock;
    }

    public ConditionalExpressionNode getElseIfBool() {
        return elseIfBool;
    }

    public ConditionalBlockNode getElseIfBlock() {
        return elseIfBlock;
    }

    @Override
    public String prettyPrint() {
        //TODO: Check if newline and indents work
        return "else if (" + elseIfBool.prettyPrint() + ") " + elseIfBlock.prettyPrint();
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
