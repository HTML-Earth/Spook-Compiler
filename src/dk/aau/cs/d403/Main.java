package dk.aau.cs.d403;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.AstBuilder;
import dk.aau.cs.d403.ast.MainNode;
import dk.aau.cs.d403.ast.ProgramNode;
import dk.aau.cs.d403.parser.SpookLexer;
import dk.aau.cs.d403.parser.SpookParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            SpookLexer lexer = new SpookLexer(CharStreams.fromFileName("Resources/BasicShader.spok"));
            SpookParser parser = new SpookParser(new CommonTokenStream(lexer));

            //ParseTree tree = parser.program();

            AstBuilder builder = new AstBuilder();

            ProgramNode ast = (ProgramNode)builder.visitProgram(parser.program());
            System.out.println(ast.prettyPrint());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
