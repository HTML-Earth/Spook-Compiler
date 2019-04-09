package dk.aau.cs.d403.semantics;
import dk.aau.cs.d403.ast.VariableDeclarationNode.DataType;

public class NodeObject {
    private DataType type;
    private String name;

    public NodeObject(DataType type, String name) {
        this.type = type;
        this.name = name;
    }

    public NodeObject(String name) {
        this.name = name;
    }

    public DataType getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
