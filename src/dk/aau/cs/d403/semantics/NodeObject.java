package dk.aau.cs.d403.semantics;

import dk.aau.cs.d403.ast.Enums;

public class NodeObject {
    private Enums.DataType type;
    private String name;
    private String scopeLevel;

    public NodeObject(Enums.DataType type, String name, String scopeLevel) {
        this.type = type;
        this.name = name;
        this.scopeLevel = scopeLevel;
    }

    public NodeObject(String name, String scopeLevel) {
        this.name = name;
        this.scopeLevel = scopeLevel;
    }

    public Enums.DataType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getScopeLevel() {
        return scopeLevel;
    }
}
