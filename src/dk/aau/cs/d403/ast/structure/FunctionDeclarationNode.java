package dk.aau.cs.d403.ast.structure;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.statements.FunctionArgNode;

import java.util.ArrayList;

public class FunctionDeclarationNode implements ASTnode {
    private Enums.DataType returnType;
    private String functionName;
    private ArrayList<FunctionArgNode> functionArgNodes;
    private BlockNode blockNode;

    public FunctionDeclarationNode(Enums.DataType returnType, String functionName, BlockNode blockNode) {
        this.returnType = returnType;
        this.functionName = functionName;
        this.blockNode = blockNode;
    }

    public FunctionDeclarationNode(Enums.DataType returnType, String functionName, ArrayList<FunctionArgNode> functionArgNodes, BlockNode blockNode) {
        this.returnType = returnType;
        this.functionName = functionName;
        this.functionArgNodes = functionArgNodes;
        this.blockNode = blockNode;
    }

    public FunctionDeclarationNode(String functionName, BlockNode blockNode) {
        this.returnType = null;
        this.functionName = functionName;
        this.blockNode = blockNode;
    }

    public FunctionDeclarationNode(String functionName, ArrayList<FunctionArgNode> functionArgNodes, BlockNode blockNode) {
        this.returnType = null;
        this.functionName = functionName;
        this.blockNode = blockNode;
    }

    public Enums.DataType getReturnType() {
        return returnType;
    }

    public String getFunctionName() {
        return functionName;
    }

    public BlockNode getBlockNode() {
        return blockNode;
    }

    public ArrayList<FunctionArgNode> getFunctionArgNodes() {
        return functionArgNodes;
    }

    @Override
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();

        sb.append(Enums.dataTypeToStringSpook(returnType));
        sb.append(" ");
        sb.append(functionName);
        sb.append("(");
        if (functionArgNodes != null) {
            //Print ',' before each arg except the first
            boolean firstArg = true;
            for (FunctionArgNode arg : functionArgNodes) {
                if (!firstArg)
                    sb.append(", ");
                else
                    firstArg = false;
                sb.append(arg.prettyPrint());
            }
        }
        sb.append(") ");
        sb.append(blockNode.prettyPrint());

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
