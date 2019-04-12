package dk.aau.cs.d403.ast;

public class CodePosition {
    private int lineNumber;
    private int columnNumber;

    public CodePosition(int lineNumber, int columnNumber) {
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    @Override
    public String toString() {
        return lineNumber + ":" + columnNumber;
    }
}
