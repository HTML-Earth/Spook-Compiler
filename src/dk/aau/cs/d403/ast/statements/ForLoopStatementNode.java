package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.expressions.ForLoopExpressionNode;
import dk.aau.cs.d403.ast.structure.BlockNode;

public class ForLoopStatementNode extends StatementNode {
    private ForLoopExpressionNode forLoopExpressionNode1;
    private ForLoopExpressionNode forLoopExpressionNode2;
    private ConditionalBlockNode conditionalBlockNode;

    public ForLoopStatementNode(ForLoopExpressionNode forLoopExpressionNode1, ForLoopExpressionNode forLoopExpressionNode2, ConditionalBlockNode conditionalBlockNode) {
        this.forLoopExpressionNode1 = forLoopExpressionNode1;
        this.forLoopExpressionNode2 = forLoopExpressionNode2;
        this.conditionalBlockNode = conditionalBlockNode;
    }

    public ForLoopExpressionNode getForLoopExpressionNode1() {
        return forLoopExpressionNode1;
    }

    public ForLoopExpressionNode getForLoopExpressionNode2() {
        return forLoopExpressionNode2;
    }

    public ConditionalBlockNode getConditionalBlockNode() {
        return conditionalBlockNode;
    }

    @Override
    public String prettyPrint() {

        return "for (" +
                forLoopExpressionNode1.prettyPrint() +
                " to " +
                forLoopExpressionNode2.prettyPrint() +
                ") " +
                "\n" +
                conditionalBlockNode.prettyPrint();
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
