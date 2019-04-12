package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.CodePosition;

import java.util.ArrayList;

public class BoolExpressionNode extends ExpressionNode {
    private boolean boolLiteral;
    private ArrayList<BoolOperationNode> boolOperationNodes;

    public BoolExpressionNode(boolean boolLiteral) {
        this.boolLiteral = boolLiteral;
    }

    public BoolExpressionNode(ArrayList<BoolOperationNode> boolOperationNodes) {
        this.boolOperationNodes = boolOperationNodes;
    }

    public boolean isBoolLiteral() {
        return boolLiteral;
    }

    public ArrayList<BoolOperationNode> getBoolOperationNodes() {
        return boolOperationNodes;
    }

    @Override
    public String prettyPrint() {
        if (boolOperationNodes != null) {
            StringBuilder sb = new StringBuilder();
            for (BoolOperationNode boolOperationNode: boolOperationNodes) {
                sb.append(boolOperationNode.prettyPrint()); //TODO: check if this makes sense
            }
            return sb.toString();
        }
        else
            return "" + boolLiteral;
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
