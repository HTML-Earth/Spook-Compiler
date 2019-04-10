package dk.aau.cs.d403.semantics;
import dk.aau.cs.d403.ast.statements.VariableDeclarationNode.DataType;

public class NodeObject {
    private DataType type;
    private String name;
    private String scopeLevel;
    private String attributes;

    public NodeObject(DataType type, String name, String scopeLevel) {
        this.type = type;
        this.name = name;
        this.scopeLevel = scopeLevel;
    }

    public NodeObject(String name, String scopeLevel, String attributes) {
        this.name = name;
        this.scopeLevel = scopeLevel;
        this.attributes = attributes;
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

    public String getAttributes() {
        return attributes;
    }
}
