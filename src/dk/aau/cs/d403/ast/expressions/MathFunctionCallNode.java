package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.Enums;

import java.util.ArrayList;

public class MathFunctionCallNode implements ASTnode {
    private Enums.MathFunctionName functionName;
    private ArithOperandNode operandNode;
    private ArrayList<ArithOperationNode> operationNodes;

    public MathFunctionCallNode(Enums.MathFunctionName functionName) {
        this.functionName = functionName;
    }

    public MathFunctionCallNode(Enums.MathFunctionName functionName, ArithOperandNode operandNode) {
        this.functionName = functionName;
        this.operandNode = operandNode;
    }

    public MathFunctionCallNode(Enums.MathFunctionName functionName, ArrayList<ArithOperationNode> operationNodes) {
        this.functionName = functionName;
        this.operationNodes = operationNodes;
    }

    public Enums.MathFunctionName getFunctionName() {
        return functionName;
    }

    public ArithOperandNode getOperandNode() {
        return operandNode;
    }

    public ArrayList<ArithOperationNode> getOperationNodes() {
        return operationNodes;
    }

    @Override
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append(Enums.mathFunctionToString(functionName));
        sb.append("(");

        if (operandNode != null)
            sb.append(operandNode.prettyPrint());
        else if (operationNodes != null) {
            for (ArithOperationNode operationNode: operationNodes) {
                sb.append(operationNode.prettyPrint());
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
