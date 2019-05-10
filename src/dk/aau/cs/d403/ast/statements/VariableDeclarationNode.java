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
        for (int i = 0; i < indent; i++)
            sb.append("\t");
        sb.append(Enums.dataTypeToStringSpook(dataType)).append(" ");
        for (int i = 0; i < varDeclInitNodes.size(); i++) {
            sb.append(varDeclInitNodes.get(i).prettyPrint(0));
            if (i != varDeclInitNodes.size()-1) {
                sb.append(", ");
            }
        }
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
