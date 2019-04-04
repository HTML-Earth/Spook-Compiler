package dk.aau.cs.d403.ast;

public class ProgramNode implements ASTnode{

    MainNode mainNode;

    ProgramNode(MainNode mainNode) {
        this.mainNode = mainNode;
    }

    @Override
    public String prettyPrint() {
        return mainNode.prettyPrint();
    }
}
