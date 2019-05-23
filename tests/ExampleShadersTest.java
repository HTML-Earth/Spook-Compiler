import dk.aau.cs.d403.ast.AstBuilder;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.structure.ProgramNode;
import dk.aau.cs.d403.codegen.CodeGenerator;
import dk.aau.cs.d403.parser.SpookLexer;
import dk.aau.cs.d403.parser.SpookParser;
import dk.aau.cs.d403.semantics.TypeChecking;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ExampleShadersTest {
    private TypeChecking typeChecking = new TypeChecking();

    void testShader(String shaderName) {
        try {
            SpookLexer lexer = new SpookLexer(CharStreams.fromFileName("Resources/ExampleShadersTest/" + shaderName + ".spook"));
            SpookParser parser = new SpookParser(new CommonTokenStream(lexer));

            AstBuilder astBuilder = new AstBuilder();
            ProgramNode programNode = (ProgramNode) astBuilder.visitProgram(parser.program());
            programNode.prettyPrint(0);

            typeChecking.visitProgram(programNode);
            CodeGenerator codeGenerator = new CodeGenerator();
            codeGenerator.GenerateGLSL(programNode);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void printTable() {
        typeChecking.printSymbolTable();
    }

    @Test
    void BallShader() {
        testShader("BallShader");
    }

    @Test
    void FunnyShader() {
        testShader("FunnyShader");
    }

    @Test
    void Spooderman() {
        testShader("Spooderman");
    }

    @Test
    void Triangles() {
        testShader("Triangles");
    }
}
