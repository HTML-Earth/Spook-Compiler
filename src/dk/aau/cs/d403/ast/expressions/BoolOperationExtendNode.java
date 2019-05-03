package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.Enums;

public class BoolOperationExtendNode implements ASTnode {
    private Enums.BoolOperator boolOperator;
    private Enums.BoolOperator optionalNOT;
    private BoolOperationNode boolOperationNode;


    public BoolOperationExtendNode(Enums.BoolOperator boolOperator, BoolOperationNode boolOperationNode) {
        this.boolOperator = boolOperator;
        this.boolOperationNode = boolOperationNode;
    }

    public BoolOperationExtendNode(Enums.BoolOperator boolOperator, Enums.BoolOperator optionalNOT, BoolOperationNode boolOperationNode) {
        if (optionalNOT != Enums.BoolOperator.NOT)
            throw new IllegalArgumentException("Boolean operator should be !");
        this.boolOperator = boolOperator;
        this.optionalNOT = optionalNOT;
        this.boolOperationNode = boolOperationNode;
    }

    public Enums.BoolOperator getBoolOperator() {
        return boolOperator;
    }

    public Enums.BoolOperator getOptionalNOT() {
        return optionalNOT;
    }

    public BoolOperationNode getBoolOperationNode() {
        return boolOperationNode;
    }

    @Override
    public String prettyPrint(int indent) {
        //Case of operator !bool
        if (boolOperator != null && optionalNOT != null && boolOperationNode != null) {
            return Enums.boolOperatorToString(boolOperator) + Enums.boolOperatorToString(optionalNOT) + boolOperationNode.prettyPrint(indent);
        }
        //Case of operator bool
        else if (boolOperator != null && boolOperationNode != null) {
            return Enums.boolOperatorToString(boolOperator) + boolOperationNode.prettyPrint(indent);
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
