package dk.aau.cs.d403.ast.structure;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.statements.ReturnNode;
import dk.aau.cs.d403.ast.statements.StatementNode;

import java.util.ArrayList;

public class BlockNode implements ASTnode {
    private ArrayList<StatementNode> statementNodes;
    private ReturnNode returnNode;

    public BlockNode(ArrayList<StatementNode> statementNodes) {
        this.statementNodes = statementNodes;
    }

    public BlockNode(ArrayList<StatementNode> statementNodes, ReturnNode returnNode) {
        this.statementNodes = statementNodes;
        this.returnNode = returnNode;
    }

    public ArrayList<StatementNode> getStatementNodes() {
        return statementNodes;
    }

    public ReturnNode getReturnNode() {
        return returnNode;
    }

    @Override
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();

        sb.append("{");

        for (StatementNode stmnt : statementNodes)
        {
            if (stmnt != null) {
                sb.append("\n\t");
                sb.append(stmnt.prettyPrint());
            }
        }
        if (returnNode != null) {
            sb.append("\n\t");
            sb.append(returnNode.prettyPrint());
        }

        sb.append("\n}");

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
