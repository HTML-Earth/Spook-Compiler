package dk.aau.cs.d403;

import dk.aau.cs.d403.ast.AstBuilder;
import dk.aau.cs.d403.ast.structure.ProgramNode;
import dk.aau.cs.d403.parser.SpookLexer;
import dk.aau.cs.d403.parser.SpookParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            SpookLexer lexer = new SpookLexer(CharStreams.fromFileName("Resources/TestShader2.spook"));
            SpookParser parser = new SpookParser(new CommonTokenStream(lexer));

            System.out.println("Building AST...\n");
            AstBuilder builder = new AstBuilder();
            ProgramNode ast = (ProgramNode)builder.visitProgram(parser.program());

            System.out.println("Pretty Print:");
            System.out.println(ast.prettyPrint());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
