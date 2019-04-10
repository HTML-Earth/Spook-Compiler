package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;

public class ObjectArgumentNode implements ASTnode {

    private String variableName;
    private RealNumberNode realNumberNode;
    private ArithOperationNode arithOperationNode;
    private ClassPropertyNode classPropertyNode;

    public ObjectArgumentNode(String variableName) {
        this.variableName = variableName;
    }

    public ObjectArgumentNode(RealNumberNode realNumberNode) {
        this.realNumberNode = realNumberNode;
    }

    public ObjectArgumentNode(ArithOperationNode arithOperationNode) {
        this.arithOperationNode = arithOperationNode;
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

    public ArithOperationNode getArithOperationNode() {
        return arithOperationNode;
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
        else if (arithOperationNode != null)
            return arithOperationNode.prettyPrint();
        else if (classPropertyNode != null)
            return classPropertyNode.prettyPrint();
        else
            return "Invalid Object Argument";
    }
}
