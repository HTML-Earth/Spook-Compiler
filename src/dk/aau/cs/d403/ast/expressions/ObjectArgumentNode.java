package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;

public class ObjectArgumentNode implements ASTnode {

    private String variableName;
    private RealNumberNode realNumberNode;
    private LowPrecedenceNode lowPrecedenceNode;
    private ClassPropertyNode classPropertyNode;

    public ObjectArgumentNode(String variableName) {
        this.variableName = variableName;
    }

    public ObjectArgumentNode(RealNumberNode realNumberNode) {
        this.realNumberNode = realNumberNode;
    }

    public ObjectArgumentNode(LowPrecedenceNode lowPrecedenceNode) {
        this.lowPrecedenceNode = lowPrecedenceNode;
    }

    public ObjectArgumentNode(ClassPropertyNode classPropertyNode) {
        this.classPropertyNode = classPropertyNode;
    }

    public String getVariableName() {
        return variableName;
    }

    public RealNumberNode getRealNumberNode() {
        return realNumberNode;
    }

    public LowPrecedenceNode getLowPrecedenceNode() {
        return lowPrecedenceNode;
    }

    public ClassPropertyNode getClassPropertyNode() {
        return classPropertyNode;
    }

    @Override
    public String prettyPrint() {
        if (variableName != null)
            return variableName;
        else if (realNumberNode != null)
            return realNumberNode.prettyPrint();
        else if (lowPrecedenceNode != null)
            return lowPrecedenceNode.prettyPrint();
        else if (classPropertyNode != null)
            return classPropertyNode.prettyPrint();
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
