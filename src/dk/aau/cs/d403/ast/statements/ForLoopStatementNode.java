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

    public ForLoopExpressionNode getForLoopExpressionNode1() {
        return forLoopExpressionNode1;
    }

    public ForLoopExpressionNode getForLoopExpressionNode2() {
        return forLoopExpressionNode2;
    }

    public BlockNode getBlockNode() {
        return blockNode;
    }

    public StatementNode getStatementNode() {
        return statementNode;
    }

    @Override
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append("for (");
        sb.append(forLoopExpressionNode1.prettyPrint());
        sb.append(" to ");
        sb.append(forLoopExpressionNode2.prettyPrint());
        sb.append(") ");

        if (blockNode != null) {
            sb.append(blockNode.prettyPrint());
        }
        else if (statementNode != null) {
            sb.append("\n\t");
            sb.append(statementNode.prettyPrint());
        }

        return sb.toString();
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
