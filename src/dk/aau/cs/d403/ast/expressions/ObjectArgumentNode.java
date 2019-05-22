package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;

public class ObjectArgumentNode implements ASTnode {

    private LowPrecedenceNode lowPrecedence;

    private BoolExpressionNode boolExpression;

    public ObjectArgumentNode(LowPrecedenceNode lowPrecedence) {
        this.lowPrecedence = lowPrecedence;
    }

    public ObjectArgumentNode(BoolExpressionNode boolExpression) {
        this.boolExpression = boolExpression;
    }

    public LowPrecedenceNode getLowPrecedence() {
        return lowPrecedence;
    }

    public BoolExpressionNode getBoolExpression() {
        return boolExpression;
    }

    @Override
    public String prettyPrint(int indent) {
        if (lowPrecedence != null)
            return lowPrecedence.prettyPrint(indent);
        else if (boolExpression != null)
            return boolExpression.prettyPrint(indent);
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

    public boolean isOnlyVariableName() {
        if (lowPrecedence != null) {
            if (lowPrecedence.getHighPrecedenceNodes() != null) {
                if (lowPrecedence.getHighPrecedenceNodes().size() == 1) {
                    if (lowPrecedence.getHighPrecedenceNodes().get(0).getAtomPrecedenceNodes() != null) {
                        if (lowPrecedence.getHighPrecedenceNodes().get(0).getAtomPrecedenceNodes().size() == 1) {
                            if (lowPrecedence.getHighPrecedenceNodes().get(0).getAtomPrecedenceNodes().get(0).getOperand() != null) {
                                if (lowPrecedence.getHighPrecedenceNodes().get(0).getAtomPrecedenceNodes().get(0).getOperand().getVariableName() != null) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isOnlyGame() {
        return true; //Why you heff to be mad?
    }

    public String getVariableName() {
        return lowPrecedence
                .getHighPrecedenceNodes().get(0)
                .getAtomPrecedenceNodes().get(0)
                .getOperand()
                .getVariableName();
    }

    public void renameVariable (String newName) {
        lowPrecedence.renameVariable(newName);
    }

    public static ObjectArgumentNode zero() {
        return new ObjectArgumentNode(LowPrecedenceNode.zero());
    }

    public static ObjectArgumentNode add(ObjectArgumentNode a, ObjectArgumentNode b) {
        return new ObjectArgumentNode(LowPrecedenceNode.add(a.getLowPrecedence(), b.getLowPrecedence()));
    }

    public static ObjectArgumentNode subtract(ObjectArgumentNode a, ObjectArgumentNode b) {
        throw new RuntimeException("Not yet implemented");
    }

    public static ObjectArgumentNode multiply(ObjectArgumentNode a, ObjectArgumentNode b) {
        throw new RuntimeException("Not yet implemented");
    }

    public static ObjectArgumentNode divide(ObjectArgumentNode a, ObjectArgumentNode b) {
        throw new RuntimeException("Not yet implemented");
    }

    public static ObjectArgumentNode mod(ObjectArgumentNode a, ObjectArgumentNode b) {
        throw new RuntimeException("Not yet implemented");
    }
}
