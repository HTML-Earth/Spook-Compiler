package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.statements.NonObjectFunctionCallNode;
import dk.aau.cs.d403.ast.statements.ObjectFunctionCallNode;

public class ObjectArgumentNode implements ASTnode {

    private LowPrecedenceNode lowPrecedence;
    private ColorFunctionCallNode colorFunctionCallNode;
    private NonObjectFunctionCallNode nonObjectFunctionCallNode;
    private ObjectFunctionCallNode objectFunctionCallNode;

    public ObjectArgumentNode(LowPrecedenceNode lowPrecedence) {
        this.lowPrecedence = lowPrecedence;
    }

    public ObjectArgumentNode(ColorFunctionCallNode colorFunctionCallNode) {
        this.colorFunctionCallNode = colorFunctionCallNode;
    }

    public ObjectArgumentNode(NonObjectFunctionCallNode nonObjectFunctionCallNode) {
        this.nonObjectFunctionCallNode = nonObjectFunctionCallNode;
    }

    public ObjectArgumentNode(ObjectFunctionCallNode objectFunctionCallNode) {
        this.objectFunctionCallNode = objectFunctionCallNode;
    }

    public LowPrecedenceNode getLowPrecedence() {
        return lowPrecedence;
    }

    public NonObjectFunctionCallNode getNonObjectFunctionCallNode() {
        return nonObjectFunctionCallNode;
    }

    public ColorFunctionCallNode getColorFunctionCallNode() {
        return colorFunctionCallNode;
    }

    public ObjectFunctionCallNode getObjectFunctionCallNode() {
        return objectFunctionCallNode;
    }

    @Override
    public String prettyPrint() {
        if (lowPrecedence != null)
            return lowPrecedence.prettyPrint();
        else if (colorFunctionCallNode != null)
            return colorFunctionCallNode.prettyPrint();
        else if (nonObjectFunctionCallNode != null)
            return nonObjectFunctionCallNode.prettyPrint();
        else if (objectFunctionCallNode != null)
            return objectFunctionCallNode.prettyPrint();
        else
            return "Invalid Object Argument";
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
