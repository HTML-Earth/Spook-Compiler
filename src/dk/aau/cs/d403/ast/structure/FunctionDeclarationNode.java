package dk.aau.cs.d403.ast.structure;

import dk.aau.cs.d403.ast.ASTnode;

public class FunctionDeclarationNode implements ASTnode {
    private String returnType;
    private String functionName;

    public FunctionDeclarationNode(String functionName, String returnType) {
        this.functionName = functionName;
        this.returnType = returnType;
    }

    @Override
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();

        sb.append(returnType);
        sb.append(" ");
        sb.append(functionName);
        sb.append("() {\n");

        //for each declaration / function

        sb.append("\n}");

        return sb.toString();
    }
}
