package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;

import java.util.ArrayList;

public class ObjectArgumentNode implements ASTnode {

    private String variableName;
    private RealNumberNode realNumberNode;
    private ArrayList<ArithOperationNode> arithOperationNodes;
    private ColorFunctionCallNode colorFunctionCallNode;

    public ObjectArgumentNode(String variableName) {
        this.variableName = variableName;
    }

    public ObjectArgumentNode(RealNumberNode realNumberNode) {
        this.realNumberNode = realNumberNode;
    }

    public ObjectArgumentNode(ArrayList<ArithOperationNode> arithOperationNodes) {
        this.arithOperationNodes = arithOperationNodes;
    }

    public ObjectArgumentNode(ColorFunctionCallNode colorFunctionCallNode) {
        this.colorFunctionCallNode = colorFunctionCallNode;
    }

    public String getVariableName() {
        return variableName;
    }

    public RealNumberNode getRealNumberNode() {
        return realNumberNode;
    }

    public ArrayList<ArithOperationNode> getArithOperationNodes() {
        return arithOperationNodes;
    }

    public ColorFunctionCallNode getColorFunctionCallNode() {
        return colorFunctionCallNode;
    }

    @Override
    public String prettyPrint() {
        if (variableName != null)
            return variableName;
        else if (realNumberNode != null)
            return realNumberNode.prettyPrint();
        else if (arithOperationNodes != null) {
            StringBuilder sb = new StringBuilder();
            for (ArithOperationNode arithOperationNode : arithOperationNodes) {
                sb.append(arithOperationNode.prettyPrint());
            }
            return sb.toString();
        }
        else if (colorFunctionCallNode != null)
            return colorFunctionCallNode.prettyPrint();
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
