package dk.aau.cs.d403.semantics;

public interface SymbolTable {
    void openScope(String name);
    void enterSymbol(String name, NodeObject object);
    NodeObject retrieveSymbol(String name);
}
