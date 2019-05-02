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
    private SwizzleNode swizzleNode;

    public ArithOperandNode(RealNumberNode realNumberNode) {
        this.realNumberNode = realNumberNode;
    }

    public ArithOperandNode(NonObjectFunctionCallNode nonObjectFunctionCallNode) {
        this.nonObjectFunctionCallNode = nonObjectFunctionCallNode;
    }

    public ArithOperandNode(ObjectFunctionCallNode objectFunctionCallNode) {
        this.objectFunctionCallNode = objectFunctionCallNode;
    }

    public ArithOperandNode(SwizzleNode swizzleNode) {
        this.swizzleNode = swizzleNode;
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

    public SwizzleNode getSwizzleNode() {return swizzleNode; }

    @Override
    public String prettyPrint(int indent) {
        if (realNumberNode != null) {
            return realNumberNode.prettyPrint(indent);
        }
        else if (nonObjectFunctionCallNode != null) {
            return nonObjectFunctionCallNode.prettyPrint(indent);
        }
        else if (objectFunctionCallNode != null) {
            return objectFunctionCallNode.prettyPrint(indent);
        }
        else if (variableName != null) {
            return variableName;
        }
        else if (swizzleNode != null) {
            return swizzleNode.prettyPrint(indent);
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
