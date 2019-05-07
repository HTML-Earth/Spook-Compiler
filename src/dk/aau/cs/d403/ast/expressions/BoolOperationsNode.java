package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.Enums;

import java.util.ArrayList;

public class BoolOperationsNode implements ASTnode {
    private BoolOperationNode boolOperationNode;
    private ArithExpressionNode arithExpressionNode;
    private ArrayList<BoolOperationExtendNode> boolOperationExtendNodes;
    private Enums.boolOperator optionalNOT;

    public BoolOperationsNode(BoolOperationNode boolOperationNode, ArrayList<BoolOperationExtendNode> boolOperationExtendNodes, Enums.boolOperator optionalNOT) {
        if (optionalNOT != Enums.boolOperator.NOT)
            throw new IllegalArgumentException("Boolean Operator should be !");
        this.boolOperationNode = boolOperationNode;
        this.boolOperationExtendNodes = boolOperationExtendNodes;
        this.optionalNOT = optionalNOT;
    }

    public BoolOperationsNode(BoolOperationNode boolOperationNode, Enums.boolOperator optionalNOT) {
        if (optionalNOT != Enums.boolOperator.NOT)
            throw new IllegalArgumentException("Boolean Operator should be !");
        this.boolOperationNode = boolOperationNode;
        this.optionalNOT = optionalNOT;
    }

    public BoolOperationsNode(BoolOperationNode boolOperationNode, ArrayList<BoolOperationExtendNode> boolOperationExtendNodes) {
        this.boolOperationNode = boolOperationNode;
        this.boolOperationExtendNodes = boolOperationExtendNodes;
    }

    public BoolOperationsNode(ArithExpressionNode arithExpressionNode, ArrayList<BoolOperationExtendNode> boolOperationExtendNodes, Enums.boolOperator optionalNOT) {
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

    public Enums.boolOperator getOptionalNOT() {
        return optionalNOT;
    }

    public ArithExpressionNode getArithExpressionNode() {
        return arithExpressionNode;
    }

    @Override
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();
        if (boolOperationExtendNodes != null) {
            for (BoolOperationExtendNode boolOperationExtendNode : boolOperationExtendNodes) {
                sb.append(boolOperationExtendNode.prettyPrint());
            }
        }
        //Case !bool extend
        if (boolOperationNode != null && boolOperationExtendNodes != null && optionalNOT != null)
            return Enums.boolOperatorToString(optionalNOT) + boolOperationNode.prettyPrint() + sb;
        //Case bool extend
        else if (boolOperationNode != null && boolOperationExtendNodes != null)
            return boolOperationNode.prettyPrint() + sb;
        //Case !bool
        else if (optionalNOT != null && boolOperationNode != null)
            return Enums.boolOperatorToString(optionalNOT) + boolOperationNode.prettyPrint();
        //Case bool
        else if (boolOperationNode != null)
            return boolOperationNode.prettyPrint();
        //Case !arith extend
        else if (arithExpressionNode != null && boolOperationExtendNodes != null && optionalNOT != null)
            return Enums.boolOperatorToString(optionalNOT) + arithExpressionNode.prettyPrint() + sb;
        //Case arith extend
        else if (arithExpressionNode != null && boolOperationExtendNodes != null)
            return arithExpressionNode.prettyPrint() + sb;
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
