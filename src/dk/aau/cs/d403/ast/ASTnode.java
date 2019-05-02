package dk.aau.cs.d403.ast;

public interface ASTnode {
    //ASTnode getParent();

    //ASTnode getChild(int var1);

    //void setParent(ASTnode var1);

    //<T> T accept(ASTvisitor<? extends T> var1);

    String prettyPrint(int indentation);

    void setCodePosition(CodePosition codePosition);
    CodePosition getCodePosition();
}
