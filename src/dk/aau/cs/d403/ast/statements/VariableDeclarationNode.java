package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.Enums;

import java.util.ArrayList;

public class VariableDeclarationNode extends DeclarationNode {
    private Enums.DataType dataType;
    private ArrayList<VarDeclInitNode> varDeclInitNodes;

    public VariableDeclarationNode(Enums.DataType dataType, ArrayList<VarDeclInitNode> varDeclInitNodes) {
        this.dataType = dataType;
        this.varDeclInitNodes = varDeclInitNodes;
    }

    public Enums.DataType getDataType() {
        return dataType;
    }

    public ArrayList<VarDeclInitNode> getVarDeclInitNodes() {
        return varDeclInitNodes;
    }

    @Override
    public String prettyPrint(int indent) {
        StringBuilder sb = new StringBuilder();
        for (VarDeclInitNode varDeclInitNode : varDeclInitNodes) {
            sb.append(varDeclInitNode.prettyPrint(indent));
            if (!varDeclInitNode.equals(varDeclInitNodes.get(varDeclInitNodes.size()-1))); {
                //This body is not empty
                sb.append(", ");
            }
        }
        return Enums.dataTypeToStringSpook(dataType) + " " + sb.toString();
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
