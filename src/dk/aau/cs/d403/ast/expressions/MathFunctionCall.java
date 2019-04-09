package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;

public class MathFunctionCall implements ASTnode {
    @Override
    public String prettyPrint() {
        return "Math function call";
    }
}
