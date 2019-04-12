package dk.aau.cs.d403.ast.statements;

import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.expressions.BoolExpressionNode;
import dk.aau.cs.d403.ast.structure.BlockNode;

import java.util.ArrayList;

public class IfElseStatementNode extends StatementNode {
    private BoolExpressionNode ifBool;
    private ArrayList<BoolExpressionNode> elseIfBools;
    private BoolExpressionNode elseBool;

    private BlockNode ifBlock;
    private ArrayList<BlockNode> elseIfBlocks;
    private BlockNode elseBlock;

    public IfElseStatementNode(BoolExpressionNode ifBool, BlockNode ifBlock) {
        this.ifBool = ifBool;
        this.ifBlock = ifBlock;
    }

    public IfElseStatementNode(BoolExpressionNode ifBool, BoolExpressionNode elseBool, BlockNode ifBlock, BlockNode elseBlock) {
        this.ifBool = ifBool;
        this.elseBool = elseBool;
        this.ifBlock = ifBlock;
        this.elseBlock = elseBlock;
    }

    public IfElseStatementNode(BoolExpressionNode ifBool, ArrayList<BoolExpressionNode> elseIfBools, BlockNode ifBlock, ArrayList<BlockNode> elseIfBlocks) {
        this.ifBool = ifBool;
        this.elseIfBools = elseIfBools;
        this.ifBlock = ifBlock;
        this.elseIfBlocks = elseIfBlocks;
    }

    public IfElseStatementNode(BoolExpressionNode ifBool, ArrayList<BoolExpressionNode> elseIfBools, BoolExpressionNode elseBool, BlockNode ifBlock, ArrayList<BlockNode> elseIfBlocks, BlockNode elseBlock) {
        this.ifBool = ifBool;
        this.elseIfBools = elseIfBools;
        this.elseBool = elseBool;
        this.ifBlock = ifBlock;
        this.elseIfBlocks = elseIfBlocks;
        this.elseBlock = elseBlock;
    }

    public BoolExpressionNode getIfBool() {
        return ifBool;
    }

    public ArrayList<BoolExpressionNode> getElseIfBools() {
        return elseIfBools;
    }

    public BoolExpressionNode getElseBool() {
        return elseBool;
    }

    public BlockNode getIfBlock() {
        return ifBlock;
    }

    public ArrayList<BlockNode> getElseIfBlocks() {
        return elseIfBlocks;
    }

    public BlockNode getElseBlock() {
        return elseBlock;
    }

    @Override
    public String prettyPrint() {
        return "If else statement";
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
