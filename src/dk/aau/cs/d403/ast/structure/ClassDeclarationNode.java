package dk.aau.cs.d403.ast.structure;

import dk.aau.cs.d403.ast.ASTnode;

public class ClassDeclarationNode implements ASTnode {
    private String className;
    private ClassBlockNode classBlockNode;

    public ClassDeclarationNode(String className, ClassBlockNode classBlockNode) {
        this.className = className;
        this.classBlockNode = classBlockNode;
    }

    public String getClassName() {
        return this.className;
    }

    public ClassBlockNode getClassBlockNode() {
        return classBlockNode;
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
