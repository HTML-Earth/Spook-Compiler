import dk.aau.cs.d403.ast.AstBuilder;
import dk.aau.cs.d403.ast.structure.ProgramNode;
import dk.aau.cs.d403.parser.SpookLexer;
import dk.aau.cs.d403.parser.SpookParser;
import dk.aau.cs.d403.semantics.SymbolTableFilling;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ObjectDeclarationTest {

    private SymbolTableFilling symbolTableFilling = new SymbolTableFilling();

    @AfterEach
    void printSymbolTable() {
        symbolTableFilling.printSymbolTable();
    }

    // Testing basic object declaration from a predefined class.
    @Disabled
    void objectDeclaration01() {
        try {
            SpookLexer lexer = new SpookLexer(CharStreams.fromFileName("Resources/ObjectDeclarationTests/ObjectDeclaration01.spook"));
            SpookParser parser = new SpookParser(new CommonTokenStream(lexer));

            AstBuilder astBuilder = new AstBuilder();
            ProgramNode programNode = (ProgramNode) astBuilder.visitProgram(parser.program());

            symbolTableFilling.visitProgram(programNode);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Testing basic object declaration from a custom class.
    @Disabled
    void objectDeclaration02() {
        try {
            SpookLexer lexer = new SpookLexer(CharStreams.fromFileName("Resources/ObjectDeclarationTests/ObjectDeclaration02.spook"));
            SpookParser parser = new SpookParser(new CommonTokenStream(lexer));

            AstBuilder astBuilder = new AstBuilder();
            ProgramNode programNode = (ProgramNode) astBuilder.visitProgram(parser.program());

            symbolTableFilling.visitProgram(programNode);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Testing basic object declaration but without the class.
    @Disabled
    void objectDeclaration03() {
        try {
            SpookLexer lexer = new SpookLexer(CharStreams.fromFileName("Resources/ObjectDeclarationTests/ObjectDeclaration03.spook"));
            SpookParser parser = new SpookParser(new CommonTokenStream(lexer));

            AstBuilder astBuilder = new AstBuilder();
            ProgramNode programNode = (ProgramNode) astBuilder.visitProgram(parser.program());

            assertThrows(RuntimeException.class, ()->{
                symbolTableFilling.visitProgram(programNode);
            });
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
