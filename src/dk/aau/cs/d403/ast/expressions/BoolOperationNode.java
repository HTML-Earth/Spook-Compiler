package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;

public class BoolOperationNode implements ASTnode {
    @Override
    public String prettyPrint() {
        return "Boolean operation";
    }
}
