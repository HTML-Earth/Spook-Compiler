package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.Enums;

import static dk.aau.cs.d403.ast.Enums.Operator.SUB;

public class AtomPrecedenceNode implements ASTnode {
    private ArithOperandNode operand;
    private LowPrecedenceNode lowPrecedenceNode;
    private Enums.Operator operator;

    public AtomPrecedenceNode(ArithOperandNode operand) {
        this.operand = operand;
    }

    public AtomPrecedenceNode(Enums.Operator operator, ArithOperandNode operand) {
        this.operand = operand;
        if (operator == SUB)
            this.operator = operator;
    }

    public AtomPrecedenceNode(LowPrecedenceNode lowPrecedenceNode) {
        this.lowPrecedenceNode = lowPrecedenceNode;
    }

    public ArithOperandNode getOperand() {
        return operand;
    }

    public LowPrecedenceNode getLowPrecedenceNode() {
        return lowPrecedenceNode;
    }

    public Enums.Operator getOperator() {
        return operator;
    }

    @Override
    public String prettyPrint(int indent) {
        //Print -operand
        if (operand != null && operator != null) {
            return Enums.operatorToString(SUB)
                    + operand.prettyPrint(indent);
        }
        //Print operand
        else if (operand != null) {
            return operand.prettyPrint(indent);
        }
        //Print Parenthesis
        else if (lowPrecedenceNode != null) {
            return "(" + lowPrecedenceNode.prettyPrint(indent) + ")";
        } else
            return "Invalid Atom Precedence Operation";
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
