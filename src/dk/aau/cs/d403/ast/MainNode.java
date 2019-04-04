package dk.aau.cs.d403.ast;

import java.util.ArrayList;

public class MainNode implements ASTnode {
    public ArrayList<VariableDeclarationNode> declarationNodes;

    MainNode(ArrayList<VariableDeclarationNode> declarationNodes) {
        this.declarationNodes = declarationNodes;
    }

    @Override
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();

        sb.append("Shader {\n");

        for (VariableDeclarationNode varDec : declarationNodes)
            sb.append(varDec.prettyPrint());

        sb.append("\n}");

        return sb.toString();
    }
}
