package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.Enums;

import java.util.ArrayList;

public class BoolOperationsNode implements ASTnode {
    private BoolOperationNode boolOperationNode;
    private ArithExpressionNode arithExpressionNode;
    private ArrayList<BoolOperationExtendNode> boolOperationExtendNodes;
    private Enums.BoolOperator optionalNOT;

    public BoolOperationsNode(BoolOperationNode boolOperationNode, ArrayList<BoolOperationExtendNode> boolOperationExtendNodes, Enums.BoolOperator optionalNOT) {
        if (optionalNOT != Enums.BoolOperator.NOT)
            throw new IllegalArgumentException("Boolean Operator should be !");
        this.boolOperationNode = boolOperationNode;
        this.boolOperationExtendNodes = boolOperationExtendNodes;
        this.optionalNOT = optionalNOT;
    }

    public BoolOperationsNode(BoolOperationNode boolOperationNode, Enums.BoolOperator optionalNOT) {
        if (optionalNOT != Enums.BoolOperator.NOT)
            throw new IllegalArgumentException("Boolean Operator should be !");
        this.boolOperationNode = boolOperationNode;
        this.optionalNOT = optionalNOT;
    }

    public BoolOperationsNode(BoolOperationNode boolOperationNode, ArrayList<BoolOperationExtendNode> boolOperationExtendNodes) {
        this.boolOperationNode = boolOperationNode;
        this.boolOperationExtendNodes = boolOperationExtendNodes;
    }

    public BoolOperationsNode(ArithExpressionNode arithExpressionNode, ArrayList<BoolOperationExtendNode> boolOperationExtendNodes, Enums.BoolOperator optionalNOT) {
        this.arithExpressionNode = arithExpressionNode;
        this.boolOperationExtendNodes = boolOperationExtendNodes;
        this.optionalNOT = optionalNOT;
    }

    public BoolOperationsNode(ArithExpressionNode arithExpressionNode, ArrayList<BoolOperationExtendNode> boolOperationExtendNodes) {
        this.arithExpressionNode = arithExpressionNode;
        this.boolOperationExtendNodes = boolOperationExtendNodes;
    }

    public BoolOperationNode getBoolOperationNode() {
        return boolOperationNode;
    }

    public ArrayList<BoolOperationExtendNode> getBoolOperationExtendNodes() {
        return boolOperationExtendNodes;
    }

    public Enums.BoolOperator getOptionalNOT() {
        return optionalNOT;
    }

    public ArithExpressionNode getArithExpressionNode() {
        return arithExpressionNode;
    }

    @Override
    public String prettyPrint(int indent) {
        StringBuilder sb = new StringBuilder();
        if (boolOperationExtendNodes != null) {
            for (BoolOperationExtendNode boolOperationExtendNode : boolOperationExtendNodes) {
                sb.append(boolOperationExtendNode.prettyPrint(indent));
            }
        }
        //Case !bool extend
        if (boolOperationNode != null && boolOperationExtendNodes != null && optionalNOT != null)
            return Enums.boolOperatorToString(optionalNOT) + boolOperationNode.prettyPrint(indent) + sb;
        //Case bool extend
        else if (boolOperationNode != null && boolOperationExtendNodes != null)
            return boolOperationNode.prettyPrint(indent) + sb;
        //Case !bool
        else if (optionalNOT != null && boolOperationNode != null)
            return Enums.boolOperatorToString(optionalNOT) + boolOperationNode.prettyPrint(indent);
        //Case bool
        else if (boolOperationNode != null)
            return boolOperationNode.prettyPrint(indent);

        //Case !arith extend
        else if (arithExpressionNode != null && boolOperationExtendNodes != null && optionalNOT != null)
            return Enums.boolOperatorToString(optionalNOT) + arithExpressionNode.prettyPrint(indent) + sb;
        //Case arith extend
        else if (arithExpressionNode != null && boolOperationExtendNodes != null)
            return arithExpressionNode.prettyPrint(indent) + sb;
        else
            return "Invalid Boolean Operations Node";
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
