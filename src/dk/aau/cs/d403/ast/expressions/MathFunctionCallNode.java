package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;

public class MathFunctionCallNode implements ASTnode {

    public enum MathFunctionName {
        ABS,
        SIN,
        COS,
        TAN
    }

    private MathFunctionName functionName;
    private String variableName;
    private RealNumberNode realNumberNode;
    private MathFunctionCallNode mathFunctionCallNode;
    private String uniform;

    @Override
    public String prettyPrint() {
        return "Math function call";
    }
}
