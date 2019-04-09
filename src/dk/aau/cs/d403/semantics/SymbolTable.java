package dk.aau.cs.d403.semantics;

public interface SymbolTable {
    void openScope();
    void closeScope();
    void enterSymbol(String name, NodeObject object);
    NodeObject retrieveSymbol(String name);
    //void declaredLocally(String name);
}
