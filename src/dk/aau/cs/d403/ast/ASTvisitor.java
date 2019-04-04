package dk.aau.cs.d403.ast;

public interface ASTvisitor<T> {
    T visit(ASTnode var1);

    T visitChildren(ASTnode var1);

    T visitTerminal(ASTnode var1);

    T visitErrorNode(ASTnode var1);
}