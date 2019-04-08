package dk.aau.cs.d403.ast;

import java.util.ArrayList;

public class MainNode implements ASTnode {
    private ArrayList<VariableDeclarationNode> declarationNodes;

    MainNode(ArrayList<VariableDeclarationNode> declarationNodes) {
        this.declarationNodes = declarationNodes;
    }

    public ArrayList<VariableDeclarationNode> getDeclarationNodes() {
        return declarationNodes;
    }

    @Override
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();

        sb.append("Shader {");

        for (VariableDeclarationNode varDec : declarationNodes)
        {
            if (varDec != null) {
                sb.append("\n\t");
                sb.append(varDec.prettyPrint());
            }
        }

        sb.append("\n}");

        return sb.toString();
    }
}
