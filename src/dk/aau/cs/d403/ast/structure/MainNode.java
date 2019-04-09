package dk.aau.cs.d403.ast.structure;

import dk.aau.cs.d403.ast.ASTnode;

public class MainNode implements ASTnode {
    private BlockNode blockNode;

    public MainNode(BlockNode blockNode) {
        this.blockNode = blockNode;
    }

    public BlockNode getBlockNode() {
        return blockNode;
    }

    @Override
    public String prettyPrint() {
        return "Shader " + blockNode.prettyPrint();
    }
}
