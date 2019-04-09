package dk.aau.cs.d403;

import dk.aau.cs.d403.ast.AstBuilder;
import dk.aau.cs.d403.ast.ProgramNode;
import dk.aau.cs.d403.codegen.CodeGenerator;
import dk.aau.cs.d403.parser.SpookLexer;
import dk.aau.cs.d403.parser.SpookParser;
import dk.aau.cs.d403.semantics.Checker;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            SpookLexer lexer = new SpookLexer(CharStreams.fromFileName("Resources/BasicShader.spook"));
            SpookParser parser = new SpookParser(new CommonTokenStream(lexer));

            System.out.println("Building AST...\n");
            AstBuilder builder = new AstBuilder();
            ProgramNode ast = (ProgramNode)builder.visitProgram(parser.program());

            System.out.println("Pretty Print:");
            System.out.println(ast.prettyPrint());

            System.out.println("Contextual Analysis...\n");
            Checker checker = new Checker();
            checker.visitProgram();

            System.out.println("Generated GLSL:");
            CodeGenerator codeGenerator = new CodeGenerator();
            System.out.println(codeGenerator.GenerateGLSL(ast));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
