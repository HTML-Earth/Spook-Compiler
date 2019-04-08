package dk.aau.cs.d403.ast;

import java.util.ArrayList;

public class ProgramNode implements ASTnode{

    private MainNode mainNode;
    private ArrayList<ClassDeclarationNode> classDeclarationNodes;
    private ArrayList<FunctionDeclarationNode> functionDeclarationNodes;

    public ProgramNode(MainNode mainNode, ArrayList<ClassDeclarationNode> classDeclarationNodes, ArrayList<FunctionDeclarationNode> functionDeclarationNodes) {
        this.mainNode = mainNode;
        this.classDeclarationNodes = classDeclarationNodes;
        this.functionDeclarationNodes = functionDeclarationNodes;
    }

    @Override
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();

        sb.append(mainNode.prettyPrint());

        sb.append("\n\n");

        for (ClassDeclarationNode classDec : classDeclarationNodes) {
            sb.append(classDec.prettyPrint());
        }

        sb.append("\n\n");

        for (FunctionDeclarationNode funcDec : functionDeclarationNodes) {
            sb.append(funcDec.prettyPrint());
        }

        return sb.toString();
    }
}
