package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;

public class ArithOperandNode implements ASTnode {
    private RealNumberNode realNumberNode;
    private MathFunctionCallNode mathFunctionCallNode;
    private String variableName;

    public ArithOperandNode(RealNumberNode realNumberNode) {
        this.realNumberNode = realNumberNode;
    }

    public ArithOperandNode(MathFunctionCallNode mathFunctionCallNode) {
        this.mathFunctionCallNode = mathFunctionCallNode;
    }

    public ArithOperandNode(String variableName) {
        this.variableName = variableName;
    }

    public RealNumberNode getRealNumberNode() {
        return realNumberNode;
    }

    public MathFunctionCallNode getMathFunctionCallNode() {
        return mathFunctionCallNode;
    }

    public String getVariableName() {
        return variableName;
    }

    @Override
    public String prettyPrint() {
        if (realNumberNode != null) {
            return realNumberNode.prettyPrint();
        }
        else if (mathFunctionCallNode != null) {
            return mathFunctionCallNode.prettyPrint();
        }
        else if (variableName != null) {
            return variableName;
        }
        else
            return "Invalid Operand";
    }
}
