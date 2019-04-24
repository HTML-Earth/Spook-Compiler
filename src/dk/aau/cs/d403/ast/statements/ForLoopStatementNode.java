package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.expressions.ForLoopExpressionNode;
import dk.aau.cs.d403.ast.structure.BlockNode;

public class ForLoopStatementNode extends StatementNode {
    private ForLoopExpressionNode forLoopExpressionNode1;
    private ForLoopExpressionNode forLoopExpressionNode2;
    private BlockNode blockNode;
    private StatementNode statementNode;

    // ForLoop with a single statement
    public ForLoopStatementNode(ForLoopExpressionNode forLoopExpressionNode1, ForLoopExpressionNode forLoopExpressionNode2, StatementNode statementNode) {
        this.forLoopExpressionNode1 = forLoopExpressionNode1;
        this.forLoopExpressionNode2 = forLoopExpressionNode2;
        this.statementNode = statementNode;
    }

    // ForLoop with block
    public ForLoopStatementNode(ForLoopExpressionNode forLoopExpressionNode1, ForLoopExpressionNode forLoopExpressionNode2, BlockNode blockNode) {
        this.forLoopExpressionNode1 = forLoopExpressionNode1;
        this.forLoopExpressionNode2 = forLoopExpressionNode2;
        this.blockNode = blockNode;
    }

    @Override
    public String prettyPrint() {
        return "ForLoop Statement";
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
