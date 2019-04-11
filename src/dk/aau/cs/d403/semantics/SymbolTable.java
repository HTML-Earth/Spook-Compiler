package dk.aau.cs.d403.semantics;

public interface SymbolTable {
    void openScope();
    void closeScope();
    void enterSymbol(NodeObject object, String name);
    NodeObject retrieveSymbol(String name);
    //void declaredLocally(String name);
}
