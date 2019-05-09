package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.CodePosition;

public class ObjectDeclarationNode extends DeclarationNode {
    private String className;
    private String variableName;
    private ObjectContructorNode objectContructorNode;

    public ObjectDeclarationNode(String className, String variableName) {
        this.className = className;
        this.variableName = variableName;
    }

    public ObjectDeclarationNode(String className, String variableName, ObjectContructorNode objectContructorNode) {
        this.className = className;
        this.variableName = variableName;
        this.objectContructorNode = objectContructorNode;
    }

    public String getClassName() {
        return className;
    }

    public String getVariableName() {
        return variableName;
    }

    public ObjectContructorNode getObjectContructorNode() {
        return objectContructorNode;
    }

    @Override
    public String prettyPrint(int indent) {
        StringBuilder sb = new StringBuilder();

        //Print type and name
        if (className != null && variableName != null) {
            sb.append(className);
            sb.append(" ");
            sb.append(variableName);

            //if initialized print construction
            if (objectContructorNode != null) {
                sb.append(" = ");
                sb.append(objectContructorNode.prettyPrint(0));
            }
            return sb.toString();
        } else
            return "Invalid Object declaration";
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
