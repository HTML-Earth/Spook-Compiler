package dk.aau.cs.d403.ast.structure;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;

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
    public String prettyPrint(int indent) {
        StringBuilder sb = new StringBuilder();

        sb.append(mainNode.prettyPrint(indent));

        if (classDeclarationNodes.size() > 0) {
            sb.append("\n\n");

            for (ClassDeclarationNode classDec : classDeclarationNodes) {
                sb.append(classDec.prettyPrint(indent));
            }
        }

        if (functionDeclarationNodes.size() > 0) {
            sb.append("\n\n");

            for (FunctionDeclarationNode funcDec : functionDeclarationNodes) {
                sb.append(funcDec.prettyPrint(indent));
            }
        }

        sb.append("\n");

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
