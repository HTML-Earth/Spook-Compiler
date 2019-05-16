import dk.aau.cs.d403.CompilerException;
import dk.aau.cs.d403.ast.AstBuilder;
import dk.aau.cs.d403.ast.structure.ProgramNode;
import dk.aau.cs.d403.codegen.CodeGenerator;
import dk.aau.cs.d403.parser.SpookLexer;
import dk.aau.cs.d403.parser.SpookParser;
import dk.aau.cs.d403.semantics.TypeChecking;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ObjectDeclarationTest {

    private TypeChecking typeChecking = new TypeChecking();

    void testShader(String shaderName) {
        try {
            SpookLexer lexer = new SpookLexer(CharStreams.fromFileName("Resources/ObjectDeclarationTests/" + shaderName + ".spook"));
            SpookParser parser = new SpookParser(new CommonTokenStream(lexer));

            AstBuilder astBuilder = new AstBuilder();
            ProgramNode programNode = (ProgramNode) astBuilder.visitProgram(parser.program());
            programNode.prettyPrint(0);

            typeChecking.visitProgram(programNode);
            CodeGenerator codeGenerator = new CodeGenerator();
            //codeGenerator.GenerateGLSL(programNode);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void printSymbolTable() {
        typeChecking.printSymbolTable();
    }

    // Testing basic object declaration from a predefined class.
    @Test
    void objectDeclaration01() {
        try {
            SpookLexer lexer = new SpookLexer(CharStreams.fromFileName("Resources/ObjectDeclarationTests/ObjectDeclaration01.spook"));
            SpookParser parser = new SpookParser(new CommonTokenStream(lexer));

            AstBuilder astBuilder = new AstBuilder();
            Assertions.assertThrows(CompilerException.class, () -> {
                ProgramNode programNode = (ProgramNode) astBuilder.visitProgram(parser.program());
                typeChecking.visitProgram(programNode);
            });

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Testing basic object declaration from a custom class.
    @Test
    void objectDeclaration02() {
        try {
            SpookLexer lexer = new SpookLexer(CharStreams.fromFileName("Resources/ObjectDeclarationTests/ObjectDeclaration02.spook"));
            SpookParser parser = new SpookParser(new CommonTokenStream(lexer));

            AstBuilder astBuilder = new AstBuilder();
            Assertions.assertThrows(CompilerException.class, () -> {
                ProgramNode programNode = (ProgramNode) astBuilder.visitProgram(parser.program());
                typeChecking.visitProgram(programNode);
            });
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Testing basic object declaration but without the class.
    @Test
    void objectDeclaration03() {
        try {
            SpookLexer lexer = new SpookLexer(CharStreams.fromFileName("Resources/ObjectDeclarationTests/ObjectDeclaration03.spook"));
            SpookParser parser = new SpookParser(new CommonTokenStream(lexer));

            AstBuilder astBuilder = new AstBuilder();
            assertThrows(CompilerException.class, ()->{
                ProgramNode programNode = (ProgramNode) astBuilder.visitProgram(parser.program());
                typeChecking.visitProgram(programNode);
            });
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void objectDeclaration04() {
        testShader("ObjectDeclaration04");
    }
}
