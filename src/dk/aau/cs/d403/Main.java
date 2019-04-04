package dk.aau.cs.d403;

import dk.aau.cs.d403.ast.AstBuilder;
import dk.aau.cs.d403.ast.MainNode;
import dk.aau.cs.d403.parser.SpookLexer;
import dk.aau.cs.d403.parser.SpookParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            SpookLexer lexer = new SpookLexer(CharStreams.fromFileName("Resources/TestShader.spok"));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            SpookParser parser = new SpookParser(tokenStream);

            SpookParser.MainContext cst = parser.main();
            new AstBuilder().VisitMain(cst);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
