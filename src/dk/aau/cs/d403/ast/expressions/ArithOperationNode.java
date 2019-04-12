package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.Enums;

import java.util.ArrayList;

public class ArithOperationNode implements ASTnode {
    private ArithOperandNode leftOperand;
    private ArithOperandNode rightOperand;
    private Enums.Operator operator;
    private ArithOperationNode arithOperationNode;

    private ArrayList<ArithOperationNode> arithOperationNodes;

    public ArithOperationNode(ArithOperandNode leftOperand, Enums.Operator operator, ArithOperandNode rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
    }

    public ArithOperationNode(ArithOperandNode leftOperand, Enums.Operator operator, ArithOperationNode arithOperationNode) {
        this.leftOperand = leftOperand;
        this.operator = operator;
        this.arithOperationNode = arithOperationNode;
    }

    public ArithOperationNode(Enums.Operator operator, ArithOperandNode rightOperand) {
        this.operator = operator;
        this.rightOperand = rightOperand;
    }

    public ArithOperationNode(Enums.Operator operator, ArithOperationNode arithOperationNode) {
        this.operator = operator;
        this.arithOperationNode = arithOperationNode;
    }

    public ArithOperationNode(ArrayList<ArithOperationNode> arithOperationNodes) {
        this.arithOperationNodes = arithOperationNodes;
    }

    public ArithOperandNode getLeftOperand() {
        return leftOperand;
    }

    public ArithOperandNode getRightOperand() {
        return rightOperand;
    }

    public Enums.Operator getOperator() {
        return operator;
    }

    public ArithOperationNode getArithOperationNode() {
        return arithOperationNode;
    }

    public ArrayList<ArithOperationNode> getArithOperationNodes() {
        return arithOperationNodes;
    }

    @Override
    public String prettyPrint() {
        if (leftOperand != null && operator != null && rightOperand != null) {
            return leftOperand.prettyPrint() + " "
                    + Enums.operatorToString(operator) + " "
                    + rightOperand.prettyPrint();
        }
        else if (leftOperand != null && operator != null && arithOperationNode != null) {
            return leftOperand.prettyPrint() + " "
                    + Enums.operatorToString(operator) + " "
                    + arithOperationNode.prettyPrint();
        }
        else if (operator != null && rightOperand != null) {
            return " " + Enums.operatorToString(operator) + " "
                    + rightOperand.prettyPrint();
        }
        else if (operator != null && arithOperationNode != null) {
            return " " + Enums.operatorToString(operator) + " "
                    + arithOperationNode.prettyPrint();
        }
        else if (arithOperationNodes != null) {
            StringBuilder sb = new StringBuilder();
            for (ArithOperationNode operationNode: arithOperationNodes) {
                sb.append(operationNode.prettyPrint());
            }
            return sb.toString();
        }
        else
            return "Invalid Arithmetic Operation";
    }

    public static String prettyPrintOperations(ArrayList<ArithOperationNode> operationNodes) {
        if (operationNodes != null) {
            StringBuilder sb = new StringBuilder();
            boolean firstOp = true;
            for (ArithOperationNode operationNode: operationNodes) {
                if (!firstOp)
                    sb.append(" ");
                else
                    firstOp = false;
                sb.append(operationNode.prettyPrint());
            }
            return sb.toString();
        }
        else return "Missing ArithOperations";
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
