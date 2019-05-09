package dk.aau.cs.d403.ast.structure;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.statements.DeclarationNode;

import java.util.ArrayList;

public class ClassBlockNode implements ASTnode {
    private ArrayList<DeclarationNode> declarationNodes;
    private ArrayList<FunctionDeclarationNode> functionDeclarationNodes;

    public ClassBlockNode(ArrayList<DeclarationNode> declarationNodes, ArrayList<FunctionDeclarationNode> functionDeclarationNodes) {
        this.declarationNodes = declarationNodes;
        this.functionDeclarationNodes = functionDeclarationNodes;
    }

    public ArrayList<DeclarationNode> getDeclarationNodes() {
        return declarationNodes;
    }

    public ArrayList<FunctionDeclarationNode> getFunctionDeclarationNodes() {
        return functionDeclarationNodes;
    }

    @Override
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();

        sb.append(" {");

        for (DeclarationNode decl : declarationNodes)
        {
            if (decl != null) {
                sb.append("\n\t");
                sb.append(decl.prettyPrint());
            }
        }

        for (FunctionDeclarationNode funcDecl : functionDeclarationNodes)
        {
            if (funcDecl != null) {
                sb.append("\n\t");
                sb.append(funcDecl.prettyPrint());
            }
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
