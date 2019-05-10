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
    private Vector2ExpressionNode vector2ExpressionNode;
    private Vector3ExpressionNode vector3ExpressionNode;
    private Vector4ExpressionNode vector4ExpressionNode;

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

    public ArithOperandNode(Vector2ExpressionNode vector2ExpressionNode) {
        this.vector2ExpressionNode = vector2ExpressionNode;
    }

    public ArithOperandNode(Vector3ExpressionNode vector3ExpressionNode) {
        this.vector3ExpressionNode = vector3ExpressionNode;
    }

    public ArithOperandNode(Vector4ExpressionNode vector4ExpressionNode) {
        this.vector4ExpressionNode = vector4ExpressionNode;
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

    public Vector2ExpressionNode getVector2ExpressionNode() {
        return vector2ExpressionNode;
    }

    public Vector3ExpressionNode getVector3ExpressionNode() {
        return vector3ExpressionNode;
    }

    public Vector4ExpressionNode getVector4ExpressionNode() {
        return vector4ExpressionNode;
    }

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
        else if (vector2ExpressionNode != null) {
            return vector2ExpressionNode.prettyPrint(indent);
        }
        else if (vector3ExpressionNode != null) {
            return vector3ExpressionNode.prettyPrint(indent);
        }
        else if (vector4ExpressionNode != null) {
            return vector4ExpressionNode.prettyPrint(indent);
        }
        //else
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
