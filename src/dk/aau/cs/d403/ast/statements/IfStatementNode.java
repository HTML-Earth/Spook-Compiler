package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.expressions.ConditionalExpressionNode;

public class IfStatementNode extends StatementNode {
    private ConditionalExpressionNode ifBool;
    private ConditionalBlockNode ifBlock;

    public IfStatementNode(ConditionalExpressionNode ifBool, ConditionalBlockNode ifBlock) {
        this.ifBool = ifBool;
        this.ifBlock = ifBlock;
    }

    public ConditionalExpressionNode getIfBool() {
        return ifBool;
    }

    public ConditionalBlockNode getIfBlock() {
        return ifBlock;
    }

    @Override
    public String prettyPrint(int indent) {
        return "if (" + ifBool.prettyPrint(indent) + ")\n " + ifBlock.prettyPrint(indent);
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
