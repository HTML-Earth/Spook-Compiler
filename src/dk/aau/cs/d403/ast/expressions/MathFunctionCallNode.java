package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.Enums;

import java.util.ArrayList;

public class MathFunctionCallNode implements ASTnode {
    private Enums.MathFunctionName functionName;
    private LowPrecedenceNode lowPrecedenceNode;

    public MathFunctionCallNode(Enums.MathFunctionName functionName, LowPrecedenceNode lowPrecedenceNode) {
        this.functionName = functionName;
        this.lowPrecedenceNode = lowPrecedenceNode;
    }

    public Enums.MathFunctionName getFunctionName() {
        return functionName;
    }

    public LowPrecedenceNode getLowPrecedenceNode() {
        return lowPrecedenceNode;
    }

    @Override
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append(Enums.mathFunctionToString(functionName));
        sb.append("(");
        sb.append(lowPrecedenceNode.prettyPrint());
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
