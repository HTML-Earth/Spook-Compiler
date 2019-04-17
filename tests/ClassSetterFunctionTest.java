import dk.aau.cs.d403.ast.AstBuilder;
import dk.aau.cs.d403.ast.structure.ProgramNode;
import dk.aau.cs.d403.parser.SpookLexer;
import dk.aau.cs.d403.parser.SpookParser;
import dk.aau.cs.d403.semantics.SymbolTableFilling;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClassSetterFunctionTest {

    private SymbolTableFilling symbolTableFilling = new SymbolTableFilling();

    @AfterEach
    void printSymbolTable() {
        symbolTableFilling.printSymbolTable();
    }

    // Testing basic Class setter.
    @Test
    void scopeRuleClassSetter01() {
        try {
            SpookLexer lexer = new SpookLexer(CharStreams.fromFileName("Resources/ClassSetterFunctionTests/ClassSetterFunction01.spook"));
            SpookParser parser = new SpookParser(new CommonTokenStream(lexer));

            AstBuilder astBuilder = new AstBuilder();
            ProgramNode programNode = (ProgramNode) astBuilder.visitProgram(parser.program());

            symbolTableFilling.visitProgram(programNode);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Testing if a Class setter can access Main scope variables.
    @Test
    void scopeRuleClassSetter02() {
        try {
            SpookLexer lexer = new SpookLexer(CharStreams.fromFileName("Resources/ClassSetterFunctionTests/ClassSetterFunction02.spook"));
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

    // Testing if a Class setter can access a different Class scope variable.
    @Test
    void scopeRuleClassSetter03() {
        try {
            SpookLexer lexer = new SpookLexer(CharStreams.fromFileName("Resources/ClassSetterFunctionTests/ClassSetterFunction03.spook"));
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

    // Testing if a Class setter can access a different Class scope variable.
    @Test
    void scopeRuleClassSetter04() {
        try {
            SpookLexer lexer = new SpookLexer(CharStreams.fromFileName("Resources/ClassSetterFunctionTests/ClassSetterFunction04.spook"));
            SpookParser parser = new SpookParser(new CommonTokenStream(lexer));

            AstBuilder astBuilder = new AstBuilder();
            ProgramNode programNode = (ProgramNode) astBuilder.visitProgram(parser.program());

            symbolTableFilling.visitProgram(programNode);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
