package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;

import java.util.ArrayList;

public class ObjectArgumentNodePlural implements ASTnode {
    private ArrayList<ObjectArgumentNode> objectArgumentNodes;
    private CodePosition codePosition;

    public ObjectArgumentNodePlural(ArrayList<ObjectArgumentNode> objectArgumentNodes) {
        this.objectArgumentNodes = objectArgumentNodes;
    }

    public ArrayList<ObjectArgumentNode> getObjectArgumentNodes() {
        return objectArgumentNodes;
    }

    @Override
    public String prettyPrint(int indent) {
        if (objectArgumentNodes.size() == 1) {
            return objectArgumentNodes.get(0).prettyPrint(indent);
        } else if (objectArgumentNodes.size() > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            for (ObjectArgumentNode objectArgumentNode : objectArgumentNodes) {
                sb.append(objectArgumentNode.prettyPrint(indent));
                //Append COMMA unless last node
                if (objectArgumentNode != objectArgumentNodes.get(objectArgumentNodes.size()-1))
                    sb.append(',');
            }
            sb.append(")");
            return sb.toString();
        }
        else
            return "Invalid Object arguments (Plural)";
    }

    @Override
    public void setCodePosition(CodePosition codePosition) {
        this.codePosition = codePosition;
    }

    @Override
    public CodePosition getCodePosition() {
        return codePosition;
    }
}
