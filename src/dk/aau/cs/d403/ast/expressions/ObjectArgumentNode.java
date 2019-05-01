package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.statements.NonObjectFunctionCallNode;
import dk.aau.cs.d403.ast.statements.ObjectFunctionCallNode;

public class ObjectArgumentNode implements ASTnode {

    private LowPrecedenceNode lowPrecedence;

    public ObjectArgumentNode(LowPrecedenceNode lowPrecedence) {
        this.lowPrecedence = lowPrecedence;
    }

    public LowPrecedenceNode getLowPrecedence() {
        return lowPrecedence;
    }

    @Override
    public String prettyPrint() {
        if (lowPrecedence != null)
            return lowPrecedence.prettyPrint();
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
