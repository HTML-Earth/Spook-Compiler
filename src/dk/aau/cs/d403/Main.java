package dk.aau.cs.d403;

import dk.aau.cs.d403.ast.AstBuilder;
import dk.aau.cs.d403.ast.structure.ProgramNode;
import dk.aau.cs.d403.parser.SpookLexer;
import dk.aau.cs.d403.parser.SpookParser;
import dk.aau.cs.d403.semantics.TypeChecking;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    // spook [options] [source files] -o output file
    public static void main(String[] args) {
        // Arguments
        String inputFile = null;
        File outputFile = null;
        boolean prettyPrint = false;
        boolean print = false;
        boolean copy = false;

        String generatedCode = null;

        // Parsing arguments
        boolean nextArgIsOutputFile = false;
        for (String arg : args) {
            if (arg.length() > 0) {
                if (arg.charAt(0) == '-') {
                    if (nextArgIsOutputFile)
                        throw new IllegalArgumentException("Expected output file, got: " + arg);

                    switch (arg.substring(1)) {
                        case "pp": case "prettyprint":
                            prettyPrint = true;
                            break;
                        case "p": case "print": case "sout":
                            print = true;
                            break;
                        case "c": case "copy": case "clipboard": case "pasta":
                            copy = true;
                            break;
                        case "o":
                            nextArgIsOutputFile = true;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid argument: " + arg);
                    }
                }
                else {
                    if (nextArgIsOutputFile) {
                        if (outputFile != null)
                            System.out.println("Overriding output file");
                        outputFile = new File(arg);
                        nextArgIsOutputFile = false;
                    }
                    else {
                        if (outputFile != null)
                            System.out.println("Overriding input file"); //TODO: allow multiple input files
                        inputFile = arg;
                    }
                }
            }
        }

        if (inputFile == null)
            throw new RuntimeException("No input file specified");


        // LEXER / PARSER
        SpookParser parser = null;
        try {
            SpookLexer lexer = new SpookLexer(CharStreams.fromFileName(inputFile));
            parser = new SpookParser(new CommonTokenStream(lexer));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        if (parser == null)
            throw new RuntimeException("Parser failed.");

        // AST
        AstBuilder builder = new AstBuilder();
        ProgramNode ast = (ProgramNode)builder.visitProgram(parser.program());

        // CONTEXT ANALYSIS
        TypeChecking typeChecking = new TypeChecking();
        typeChecking.visitProgram(ast);

        // CODE GENERATION
        String inputFileName = new File(inputFile).getName();
        CodeGenerator codeGenerator = new CodeGenerator();
        generatedCode = "// " + inputFileName + "\n// Compiled with Spook Compiler \n// https://github.com/HTML-Earth/Spook-Compiler\n\n";
        generatedCode = generatedCode + codeGenerator.GenerateGLSL(ast);

        // Pretty printing
        if (prettyPrint) {
            System.out.println("Pretty Print:");
            System.out.println(ast.prettyPrint(0));
        }

        // Print the code to the terminal
        if (print) {
            System.out.println("Generated GLSL:");
            System.out.println(generatedCode);
        }

        // Copy the code into the clipboard
        if (copy) {
            StringSelection selection = new StringSelection(generatedCode);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, selection);
        }

        // Write the code to the output file
        if (outputFile != null) {
            try {
                FileWriter writer = new FileWriter(outputFile);
                writer.write(generatedCode);
                writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
