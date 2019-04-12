package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.expressions.ObjectArgumentNode;

import java.util.ArrayList;

public class NonObjectFunctionCallNode extends StatementNode {
    private String functionName;

    private ArrayList<ObjectArgumentNode> argumentNodes;

    public NonObjectFunctionCallNode(String functionName) {
        this.functionName = functionName;
    }

    public NonObjectFunctionCallNode(String functionName, ArrayList<ObjectArgumentNode> argumentNodes) {
        this.functionName = functionName;
        this.argumentNodes = argumentNodes;
    }

    public String getFunctionName() {
        return functionName;
    }

    public ArrayList<ObjectArgumentNode> getArgumentNodes() {
        return argumentNodes;
    }

    @Override
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();

        sb.append(functionName);
        sb.append("(");

        if (argumentNodes != null) {
            //Print ',' before each arg except the first
            boolean firstArg = true;
            for (ObjectArgumentNode arg : argumentNodes) {
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
}