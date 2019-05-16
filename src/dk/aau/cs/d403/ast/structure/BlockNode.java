package dk.aau.cs.d403.ast.structure;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.statements.*;

import java.util.ArrayList;

//Both Block & functionBlock
public class BlockNode implements ASTnode {
    private ArrayList<StatementNode> statementNodes;

    public BlockNode(ArrayList<StatementNode> statementNodes) {
        this.statementNodes = statementNodes;
    }


    public ArrayList<StatementNode> getStatementNodes() {
        return statementNodes;
    }

    //Indentation is wrong because stmt.pp is the standard implementation
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
