package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;

import java.util.ArrayList;

public class ObjectDeclarationNode extends DeclarationNode {
    private Enums.ClassType objectType;
    private String customClassType;
    private String variableName;

    private ArrayList<ObjectArgumentNode> objectArgumentNodes;

    public ObjectDeclarationNode(Enums.ClassType objectType, String variableName) {
        this.objectType = objectType;
        this.variableName = variableName;
    }

    public ObjectDeclarationNode(Enums.ClassType objectType, String variableName, ArrayList<ObjectArgumentNode> objectArgumentNodes) {
        this.objectType = objectType;
        this.variableName = variableName;
        this.objectArgumentNodes = objectArgumentNodes;
    }

    public ObjectDeclarationNode(String customClassType, String variableName) {
        this.customClassType = customClassType;
        this.variableName = variableName;
    }

    public ObjectDeclarationNode(String customClassType, String variableName, ArrayList<ObjectArgumentNode> objectArgumentNodes) {
        this.customClassType = customClassType;
        this.variableName = variableName;
        this.objectArgumentNodes = objectArgumentNodes;
    }

    public Enums.ClassType getObjectType() {
        return objectType;
    }

    public String getVariableName() {
        return variableName;
    }

    public ArrayList<ObjectArgumentNode> getObjectArgumentNodes() {
        return objectArgumentNodes;
    }

    public String getCustomClassType() {
        return customClassType;
    }

    @Override
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append(Enums.classTypeToString(objectType));
        sb.append(" ");
        sb.append(variableName);
        sb.append(" = (");

        boolean first = true;
        for (ObjectArgumentNode argNode : objectArgumentNodes) {
            if (!first)
                sb.append(", ");
            first = false;
            sb.append(argNode.prettyPrint());
        }

        sb.append(")");

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
