package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.CodePosition;

import java.util.ArrayList;

public class IfElseStatementNode extends StatementNode {
    private IfStatementNode ifStatementNode;
    private ArrayList<ElseIfStatementNode> elseIfStatementNodes;
    private ElseStatementNode elseStatementNode;

    public IfElseStatementNode(IfStatementNode ifStatementNode, ArrayList<ElseIfStatementNode> elseIfStatementNodes, ElseStatementNode elseStatementNode) {
        this.ifStatementNode = ifStatementNode;
        this.elseIfStatementNodes = elseIfStatementNodes;
        this.elseStatementNode = elseStatementNode;
    }

    public IfStatementNode getIfStatementNode() {
        return ifStatementNode;
    }

    public ArrayList<ElseIfStatementNode> getElseIfStatementNodes() {
        return elseIfStatementNodes;
    }

    public ElseStatementNode getElseStatementNode() {
        return elseStatementNode;
    }

    @Override
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append(ifStatementNode.prettyPrint());
        sb.append("\n");
        if (elseIfStatementNodes != null) {
            for (ElseIfStatementNode elseIfStatementNode : elseIfStatementNodes) {
                sb.append(elseIfStatementNode.prettyPrint());
            }
        }
        if (elseStatementNode != null) {
            sb.append("\n");
            sb.append(elseStatementNode.prettyPrint());
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
