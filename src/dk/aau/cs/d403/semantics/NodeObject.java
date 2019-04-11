package dk.aau.cs.d403.semantics;

import dk.aau.cs.d403.ast.Enums;

public class NodeObject {
    private Enums.DataType type;
    private Enums.ReturnType returnType;
    private String name;
    private String scopeLevel;
    private String attributes;

    public NodeObject(Enums.DataType type, String name, String scopeLevel) {
        this.type = type;
        this.name = name;
        this.scopeLevel = scopeLevel;
        this.attributes = "Variable";
    }

    public NodeObject(Enums.ReturnType type, String name, String scopeLevel, String attributes) {
        this.returnType = type;
        this.name = name;
        this.scopeLevel = scopeLevel;
        if (attributes == null)
            this.attributes = "Assignment";
        else
            this.attributes = attributes;
    }

    public NodeObject(Enums.DataType type, String name, String scopeLevel, String attributes) {
        this.type = type;
        this.name = name;
        this.scopeLevel = scopeLevel;
        if (attributes == null)
            this.attributes = "Function";
        else
            this.attributes = attributes;
    }

    public NodeObject(String name, String scopeLevel) {
        this.name = name;
        this.scopeLevel = scopeLevel;
        this.attributes = "Class";
    }

    public Enums.DataType getType() {
        return type;
    }

    public Enums.ReturnType getReturnType() {
        return returnType;
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

    @Override
    public String toString() {
        return String.format("%5s, %10s, %13s, %15s, %8s", getType(), getReturnType(), getName(), getAttributes(), getScopeLevel());
    }
}
