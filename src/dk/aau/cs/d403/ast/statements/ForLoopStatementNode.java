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
    public String prettyPrint(int indent) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < indent; i++)
            sb.append("\t");

        sb.append("for (");
        sb.append(forLoopExpressionNode1.prettyPrint(0));
        sb.append(" to ");
        sb.append(forLoopExpressionNode2.prettyPrint(0));
        sb.append(") ");
        sb.append(conditionalBlockNode.prettyPrint(indent));

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
