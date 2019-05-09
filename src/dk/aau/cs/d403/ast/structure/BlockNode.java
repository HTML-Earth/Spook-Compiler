package dk.aau.cs.d403.ast.structure;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.statements.*;

import java.util.ArrayList;

//Both Block & functionBlock
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
    public String prettyPrint(int indent) {
        StringBuilder sb = new StringBuilder();

        sb.append("{");

        for (StatementNode stmnt : statementNodes)
        {
            if (stmnt != null) {
                sb.append("\n");
                sb.append(stmnt.prettyPrint(indent + 1));

                if (stmnt instanceof AssignmentNode || stmnt instanceof DeclarationNode ||
                    stmnt instanceof ObjectFunctionCallNode || stmnt instanceof NonObjectFunctionCallNode)
                    sb.append(";");
            }
        }
        if (returnNode != null) {
            sb.append("\n");
            sb.append(returnNode.prettyPrint(indent + 1));
        }

        sb.append("\n");

        for (int i = 0; i < indent; i++)
            sb.append("\t");

        sb.append("}");

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
