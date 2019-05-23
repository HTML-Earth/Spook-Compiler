package dk.aau.cs.d403.errorhandling;

import dk.aau.cs.d403.ast.CodePosition;

public class InvalidAmountOfArgumentsException extends CompilerException {
    public InvalidAmountOfArgumentsException(String methodName, int expected, int given) {
        super("Expected " + expected + " arguments for " + methodName + "; got " + given + ".");
    }

    public InvalidAmountOfArgumentsException(String methodName, int expected, int given, CodePosition codePosition) {
        super("Expected " + expected + " arguments for " + methodName + "; got " + given + ".", codePosition);
    }

    public InvalidAmountOfArgumentsException(String methodName, int expectedMin, int expectedMax, int given) {
        super("Expected " + expectedMin + "-" + expectedMax + " arguments for " + methodName + "; got " + given + ".");
    }

    public InvalidAmountOfArgumentsException(String methodName, int expectedMin, int expectedMax, int given, CodePosition codePosition) {
        super("Expected " + expectedMin + "-" + expectedMax + " arguments for " + methodName + "; got " + given + ".", codePosition);
    }
}
