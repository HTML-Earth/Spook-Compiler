package dk.aau.cs.d403;

import dk.aau.cs.d403.parser.SpookLexer;
import dk.aau.cs.d403.parser.SpookParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            SpookLexer lexer = new SpookLexer(CharStreams.fromFileName("Resources/TestShader.spok"));
            SpookParser parser = new SpookParser(new CommonTokenStream(lexer));


            //Den kan ikke lide at begge linjer
            //String intDigit = parser.main().declarations().declaration().numberDecl().integerDecl().DIGIT().toString();
            //List<TerminalNode> floatDigit = parser.main().declarations().declarations().declaration().numberDecl().floatDecl().DIGIT();

            //System.out.println("integer digit: " + 0 + "\n" +
                    //"float decl: " + floatDigit.get(0) + "." + floatDigit.get(1));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
