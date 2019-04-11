package dk.aau.cs.d403.ast.structure;

import dk.aau.cs.d403.ast.ASTnode;

import java.util.ArrayList;

public class ProgramNode implements ASTnode {

    private MainNode mainNode;
    private ArrayList<ClassDeclarationNode> classDeclarationNodes;
    private ArrayList<FunctionDeclarationNode> functionDeclarationNodes;

    public ProgramNode(MainNode mainNode, ArrayList<ClassDeclarationNode> classDeclarationNodes, ArrayList<FunctionDeclarationNode> functionDeclarationNodes) {
        this.mainNode = mainNode;
        this.classDeclarationNodes = classDeclarationNodes;
        this.functionDeclarationNodes = functionDeclarationNodes;
    }

    public MainNode getMainNode() {
        return mainNode;
    }

    public ArrayList<ClassDeclarationNode> getClassDeclarationNodes() {
        return classDeclarationNodes;
    }

    public ArrayList<FunctionDeclarationNode> getFunctionDeclarationNodes() {
        return functionDeclarationNodes;
    }

    @Override
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();

        sb.append(mainNode.prettyPrint());

        if (classDeclarationNodes.size() > 0) {
            sb.append("\n\n");

            for (ClassDeclarationNode classDec : classDeclarationNodes) {
                sb.append(classDec.prettyPrint());
            }
        }

        if (functionDeclarationNodes.size() > 0) {
            sb.append("\n\n");

            for (FunctionDeclarationNode funcDec : functionDeclarationNodes) {
                sb.append(funcDec.prettyPrint());
            }
        }

        sb.append("\n");

        return sb.toString();
    }
}
