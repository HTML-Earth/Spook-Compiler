package dk.aau.cs.d403.errorhandling;

import org.antlr.v4.runtime.*;

public class ReasonableErrorStrategy extends DefaultErrorStrategy {

    @Override
    public void reportError(Parser recognizer, RecognitionException e) {
        if (e instanceof NoViableAltException) {
            this.reportNoViableAlternative(recognizer, (NoViableAltException)e);
        } else if (e instanceof InputMismatchException) {
            this.reportInputMismatch(recognizer, (InputMismatchException)e);
        } else if (e instanceof FailedPredicateException) {
            this.reportFailedPredicate(recognizer, (FailedPredicateException)e);
        } else {
            System.err.println("unknown recognition error type: " + e.getClass().getName());
            recognizer.notifyErrorListeners(e.getOffendingToken(), e.getMessage(), e);
        }
        throw new RuntimeException("Lexer/Parser failed.");
    }
}
