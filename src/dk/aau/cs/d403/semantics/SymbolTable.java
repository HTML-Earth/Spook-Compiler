package dk.aau.cs.d403.semantics;

public interface SymbolTable {
    void openScope();
    void closeScope();
    void EnterSymbol(String name, String type);
    void retrieveSymbol(String name);
    void declaredLocally(String name);
}
