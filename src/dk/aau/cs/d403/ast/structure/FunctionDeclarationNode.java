package dk.aau.cs.d403.ast.structure;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.statements.FunctionArgNode;

import java.util.ArrayList;

public class FunctionDeclarationNode implements ASTnode {
    private String returnType;
    private String functionName;
    private ArrayList<FunctionArgNode> functionArgNodes;

    public FunctionDeclarationNode(String functionName, String returnType) {
        this.functionName = functionName;
        this.returnType = returnType;
    }

    public FunctionDeclarationNode(String returnType, String functionName, ArrayList<FunctionArgNode> functionArgNodes) {
        this.returnType = returnType;
        this.functionName = functionName;
        this.functionArgNodes = functionArgNodes;
    }

    public String getReturnType() {
        return returnType;
    }

    public String getFunctionName() {
        return functionName;
    }

    public ArrayList<FunctionArgNode> getFunctionArgNodes() {
        return functionArgNodes;
    }

    @Override
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();

        sb.append(returnType);
        sb.append(" ");
        sb.append(functionName);
        sb.append("() {\n");

        //for each declaration / function

        sb.append("\n}");

        return sb.toString();
    }
}
