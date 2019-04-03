package dk.aau.cs.d403;

import dk.aau.cs.d403.parser.TestLexer;
import dk.aau.cs.d403.parser.TestParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TestLexer lexer = new TestLexer(CharStreams.fromString("int 23;float 1.5;"));
        TestParser parser = new TestParser(new CommonTokenStream(lexer));

        //Den kan ikke lide at begge linjer
        //String intDigit = parser.main().declarations().declaration().numberDecl().integerDecl().DIGIT().toString();
        List<TerminalNode> floatDigit = parser.main().declarations().declarations().declaration().numberDecl().floatDecl().DIGIT();

        System.out.println("integer digit: " + 0 + "\n" +
                "float decl: " + floatDigit.get(0) + "." + floatDigit.get(1));
    }
}
