package dk.aau.cs.d403.ast.statements;

public class AssignmentNode extends StatementNode {
    private String variableName;

    public AssignmentNode(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableName() {
        return variableName;
    }

    @Override
    public String prettyPrint() {
        return variableName + " = " + "expr" + ";";
    }
}
