import dk.aau.cs.d403.ast.AstBuilder;
import dk.aau.cs.d403.ast.structure.ProgramNode;
import dk.aau.cs.d403.parser.SpookLexer;
import dk.aau.cs.d403.parser.SpookParser;
import dk.aau.cs.d403.semantics.TypeChecking;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class VariableDeclarationTest {
    private TypeChecking typeChecking = new TypeChecking();

    @AfterEach
    void printTable() {
        typeChecking.printSymbolTable();
    }

    @Test
    void variableDeclarationTest01() {
        try {
            SpookLexer lexer = new SpookLexer(CharStreams.fromFileName("Resources/VariableDeclarationTests/Test01.spook"));
            SpookParser parser = new SpookParser(new CommonTokenStream(lexer));

            AstBuilder astBuilder = new AstBuilder();
            ProgramNode programNode = (ProgramNode) astBuilder.visitProgram(parser.program());

            typeChecking.visitProgram(programNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void variableDeclarationTest02() {
        try {
            SpookLexer lexer = new SpookLexer(CharStreams.fromFileName("Resources/VariableDeclarationTests/Test02.spook"));
            SpookParser parser = new SpookParser(new CommonTokenStream(lexer));

            AstBuilder builder = new AstBuilder();
            ProgramNode ast = (ProgramNode) builder.visitProgram(parser.program());

            assertThrows(RuntimeException.class, ()-> typeChecking.visitProgram(ast));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
