package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.Enums;

public class BoolOperationExtendNode implements ASTnode {
    private Enums.boolOperator boolOperator;
    private Enums.boolOperator optionalNOT;
    private BoolOperationNode boolOperationNode;


    public BoolOperationExtendNode(Enums.boolOperator boolOperator, BoolOperationNode boolOperationNode) {
        this.boolOperator = boolOperator;
        this.boolOperationNode = boolOperationNode;
    }

    public BoolOperationExtendNode(Enums.boolOperator boolOperator, Enums.boolOperator optionalNOT, BoolOperationNode boolOperationNode) {
        if (optionalNOT != Enums.boolOperator.NOT)
            throw new IllegalArgumentException("Boolean operator should be !");
        this.boolOperator = boolOperator;
        this.optionalNOT = optionalNOT;
        this.boolOperationNode = boolOperationNode;
    }

    public Enums.boolOperator getBoolOperator() {
        return boolOperator;
    }

    public Enums.boolOperator getOptionalNOT() {
        return optionalNOT;
    }

    public BoolOperationNode getBoolOperationNode() {
        return boolOperationNode;
    }

    @Override
    public String prettyPrint() {
        //Case of operator !bool
        if (boolOperator != null && optionalNOT != null && boolOperationNode != null) {
            return " " + Enums.boolOperatorToString(boolOperator) + " " + Enums.boolOperatorToString(optionalNOT) + boolOperationNode.prettyPrint();
        }
        //Case of operator bool
        else if (boolOperator != null && boolOperationNode != null) {
            return " " + Enums.boolOperatorToString(boolOperator)+ " " + boolOperationNode.prettyPrint();
        } else return "Invalid Boolean Operation Extension";
    }

    private CodePosition codePosition;

    @Override
    public CodePosition getCodePosition() {
        return codePosition;
    }

    @Override
    public void setCodePosition(CodePosition codePosition) {
        this.codePosition = codePosition;
    }
}
