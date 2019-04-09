package dk.aau.cs.d403.semantics;
import dk.aau.cs.d403.ast.statements.VariableDeclarationNode.DataType;

public class NodeObject {
    private DataType type;
    private String name;
    private String scopeLevel;

    public NodeObject(DataType type, String name, String scopeLevel) {
        this.type = type;
        this.name = name;
        this.scopeLevel = scopeLevel;
    }

    public NodeObject(String name, String scopeLevel) {
        this.name = name;
        this.scopeLevel = scopeLevel;
    }

    public DataType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getScopeLevel() {
        return scopeLevel;
    }
}
