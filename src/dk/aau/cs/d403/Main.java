package dk.aau.cs.d403;

import dk.aau.cs.d403.parser.TestLexer;
import dk.aau.cs.d403.parser.TestParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
    public static void main(String[] args) {
        TestLexer lexer = new TestLexer(CharStreams.fromString("Hello Bob!"));
        TestParser parser = new TestParser(new CommonTokenStream(lexer));

        String name = parser.main().name().getText();
        System.out.println("Name: " + name);
    }
}
