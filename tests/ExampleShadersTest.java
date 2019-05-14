import dk.aau.cs.d403.ast.AstBuilder;
import dk.aau.cs.d403.ast.structure.ProgramNode;
import dk.aau.cs.d403.parser.SpookLexer;
import dk.aau.cs.d403.parser.SpookParser;
import dk.aau.cs.d403.semantics.TypeChecking;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ExampleShadersTest {
    private TypeChecking typeChecking = new TypeChecking();

    void testShader(String shaderName) {
        try {
            SpookLexer lexer = new SpookLexer(CharStreams.fromFileName("Resources/" + shaderName + ".spook"));
            SpookParser parser = new SpookParser(new CommonTokenStream(lexer));

            AstBuilder astBuilder = new AstBuilder();
            ProgramNode programNode = (ProgramNode) astBuilder.visitProgram(parser.program());

            typeChecking.visitProgram(programNode);
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
    void BoolTest() {
        testShader("BoolTest");
    }

    @Test
    void FunnyShader() {
        testShader("FunnyShader");
    }

    @Test
    void Ghost() {
        testShader("Ghost");
    }

    @Test
    void GhostWithoutLoops() {
        testShader("GhostWithoutLoops");
    }

    @Test
    void LayersAndTransparency() {
        testShader("LayersAndTransparency");
    }

    @Test
    void MathFunctions() {
        testShader("MathFunctions");
    }

    @Test
    void MathFunctions2() {
        testShader("MathFunctions2");
    }

    @Test
    void MathFunctions3() {
        testShader("MathFunctions3");
    }

    @Test
    void Polygons() {
        testShader("Polygons");
    }

    @Test
    void RotationTest() {
        testShader("RotationTest");
    }

    @Test
    void ShapeTest() {
        testShader("ShapeTest");
    }

    @Test
    void ShapeTestMoving() {
        testShader("ShapeTestMoving");
    }

    @Test
    void Spooderman() {
        testShader("Spooderman");
    }

    @Test
    void TestDeclaration() {
        testShader("TestDeclaration");
    }

    @Test
    void TestShader() {
        testShader("TestShader");
    }

    @Test
    void TestShader2() {
        testShader("TestShader2");
    }

    @Test
    void Uniforms() {
        testShader("Uniforms");
    }

    @Test
    void VectorFunctions() {
        testShader("VectorFunctions");
    }
}
