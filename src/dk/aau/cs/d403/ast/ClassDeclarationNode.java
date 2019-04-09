package dk.aau.cs.d403.ast;

public class ClassDeclarationNode implements ASTnode {
    private String className;

    ClassDeclarationNode(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }

    @Override
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();

        sb.append("class ");
        sb.append(className);
        sb.append(" {\n");

        //for each declaration / function

        sb.append("\n}");

        return sb.toString();
    }
}
