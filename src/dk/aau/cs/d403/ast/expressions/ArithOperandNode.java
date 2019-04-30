package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.statements.NonObjectFunctionCallNode;
import dk.aau.cs.d403.ast.statements.ObjectFunctionCallNode;

public class ArithOperandNode implements ASTnode {
    private RealNumberNode realNumberNode;
    private NonObjectFunctionCallNode nonObjectFunctionCallNode;
    private ObjectFunctionCallNode objectFunctionCallNode;
    private String variableName;

    public ArithOperandNode(RealNumberNode realNumberNode) {
        this.realNumberNode = realNumberNode;
    }

    public ArithOperandNode(NonObjectFunctionCallNode nonObjectFunctionCallNode) {
        this.nonObjectFunctionCallNode = nonObjectFunctionCallNode;
    }

    public ArithOperandNode(ObjectFunctionCallNode objectFunctionCallNode) {
        this.objectFunctionCallNode = objectFunctionCallNode;
    }

    public ArithOperandNode(String variableName) {
        this.variableName = variableName;
    }

    public RealNumberNode getRealNumberNode() {
        return realNumberNode;
    }

    public NonObjectFunctionCallNode getNonObjectFunctionCallNode() {
        return nonObjectFunctionCallNode;
    }

    public ObjectFunctionCallNode getObjectFunctionCallNode() {
        return objectFunctionCallNode;
    }

    public String getVariableName() {
        return variableName;
    }

    @Override
    public String prettyPrint() {
        if (realNumberNode != null) {
            return realNumberNode.prettyPrint();
        }
        else if (nonObjectFunctionCallNode != null) {
            return nonObjectFunctionCallNode.prettyPrint();
        }
        else if (objectFunctionCallNode != null) {
            return objectFunctionCallNode.prettyPrint();
        }
        else if (variableName != null) {
            return variableName;
        }
        else
            return "Invalid Operand";
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
