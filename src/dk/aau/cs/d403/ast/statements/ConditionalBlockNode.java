package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.structure.BlockNode;

public class ConditionalBlockNode implements ASTnode {
    private BlockNode blockNode;
    private StatementNode statementNode;
    private ReturnNode returnNode;

    public ConditionalBlockNode(BlockNode blockNode) {
        this.blockNode = blockNode;
    }

    public ConditionalBlockNode(StatementNode statementNode) {
        this.statementNode = statementNode;
    }

    public ConditionalBlockNode(ReturnNode returnNode) {
        this.returnNode = returnNode;
    }

    public BlockNode getBlockNode() {
        return blockNode;
    }

    public StatementNode getStatementNode() {
        return statementNode;
    }

    public ReturnNode getReturnNode() {
        return returnNode;
    }

    @Override
    public String prettyPrint(int indent) {
        if (blockNode != null)
            return blockNode.prettyPrint(indent);
        else if (statementNode != null)
            return statementNode.prettyPrint(indent);
        else if (returnNode != null)
            return returnNode.prettyPrint(indent);
        else
            return "Invalid Conditional Block";
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
