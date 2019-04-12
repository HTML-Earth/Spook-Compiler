package dk.aau.cs.d403.ast.structure;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.Enums;

public class ClassDeclarationNode implements ASTnode {
    private String className;
    private Enums.ClassType classType;
    private ClassBlockNode classBlockNode;

    public ClassDeclarationNode(String className, ClassBlockNode classBlockNode) {
        this.className = className;
        this.classBlockNode = classBlockNode;
    }

    public ClassDeclarationNode(String className, Enums.ClassType classType, ClassBlockNode classBlockNode) {
        this.className = className;
        this.classType = classType;
        this.classBlockNode = classBlockNode;
    }

    public String getClassName() {
        return this.className;
    }

    public Enums.ClassType getClassType() {
        return classType;
    }

    public ClassBlockNode getClassBlockNode() {
        return classBlockNode;
    }

    @Override
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();

        sb.append("class ");
        sb.append(className);

        if (classType != null) {
            sb.append(" extends ");
            sb.append(classType.toString());
        }

        sb.append(" {\n");

        //for each declaration / function

        sb.append("\n}");

        return sb.toString();
    }

    private CodePosition codePosition;

    @Override
    public void setCodePosition(CodePosition codePosition) {
        this.codePosition = codePosition;
    }

    @Override
    public CodePosition getCodePosition() {
        return codePosition;
    }
}
