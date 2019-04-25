package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.expressions.BoolExpressionNode;
import dk.aau.cs.d403.ast.structure.BlockNode;

public class IfStatementNode extends StatementNode {
    private BoolExpressionNode ifBool;
    private BlockNode ifBlock;
    private StatementNode ifStatement;

    public IfStatementNode(BoolExpressionNode ifBool, StatementNode ifStatement) {
        this.ifBool = ifBool;
        this.ifStatement = ifStatement;
    }

    public IfStatementNode(BoolExpressionNode ifBool, BlockNode ifBlock) {
        this.ifBool = ifBool;
        this.ifBlock = ifBlock;
    }

    public BoolExpressionNode getIfBool() {
        return ifBool;
    }

    public BlockNode getIfBlock() {
        return ifBlock;
    }

    public StatementNode getIfStatement() {
        return ifStatement;
    }

    @Override
    public String prettyPrint() {
        if (ifBlock != null)
            return "if (" + ifBool.prettyPrint() + ") " + ifBlock.prettyPrint();
        else if (ifStatement != null)
            return "if (" + ifBool.prettyPrint() + ")\n\t" + ifStatement.prettyPrint();
        else
            return "Invalid If-statement";
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
