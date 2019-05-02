package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;

import java.util.ArrayList;

public class ObjectFunctionCallNode extends StatementNode {
    private String objectVariableName;
    private String functionName;

    private ArrayList<ObjectArgumentNode> objectArguments;

    public ObjectFunctionCallNode(String objectVariableName, String functionName) {
        this.objectVariableName = objectVariableName;
        this.functionName = functionName;
    }

    public ObjectFunctionCallNode(String objectVariableName, String functionName, ArrayList<ObjectArgumentNode> objectArguments) {
        this.objectVariableName = objectVariableName;
        this.functionName = functionName;
        this.objectArguments = objectArguments;
    }

    public String getObjectVariableName() {
        return objectVariableName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public ArrayList<ObjectArgumentNode> getObjectArguments() {
        return objectArguments;
    }

    @Override
    public String prettyPrint(int indent) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < indent; i++)
            sb.append("\t");

        sb.append(objectVariableName);
        sb.append(".");
        sb.append(functionName);
        sb.append("(");

        if (objectArguments != null) {
            //Print ',' before each arg except the first
            boolean firstArg = true;
            for (ObjectArgumentNode arg : objectArguments) {
                if (!firstArg)
                    sb.append(", ");
                else
                    firstArg = false;
                sb.append(arg.prettyPrint(0));
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
