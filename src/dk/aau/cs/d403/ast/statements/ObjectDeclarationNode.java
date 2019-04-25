package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;

import java.util.ArrayList;

import static dk.aau.cs.d403.ast.Enums.classTypeToString;

public class ObjectDeclarationNode extends DeclarationNode {
    private String objectType;
    private String variableName;

    ArrayList<ObjectArgumentNode> objectArgumentNodes;

    public ObjectDeclarationNode(String objectType, String variableName) {
        this.objectType = objectType;
        this.variableName = variableName;
    }

    public ObjectDeclarationNode(String objectType, String variableName, ArrayList<ObjectArgumentNode> objectArgumentNodes) {
        this.objectType = objectType;
        this.variableName = variableName;
        this.objectArgumentNodes = objectArgumentNodes;
    }

    public String getObjectType() {
        return objectType;
    }

    public String getVariableName() {
        return variableName;
    }

    public ArrayList<ObjectArgumentNode> getObjectArgumentNodes() {
        return objectArgumentNodes;
    }

    @Override
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append(objectType);
        sb.append(" ");
        sb.append(variableName);
        sb.append(" = ");
        sb.append("(");

        if (objectArgumentNodes != null) {
            //Print ',' before each arg except the first
            boolean firstArg = true;
            for (ObjectArgumentNode arg : objectArgumentNodes) {
                if (!firstArg)
                    sb.append(", ");
                else
                    firstArg = false;
                sb.append(arg.prettyPrint());
            }
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
