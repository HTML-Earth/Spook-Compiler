package dk.aau.cs.d403.ast.expressions;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.CodePosition;
import dk.aau.cs.d403.ast.Enums;

public class ColorFunctionCallNode implements ASTnode {
    private Enums.ColorName colorName;

    public ColorFunctionCallNode(Enums.ColorName colorName) {
        this.colorName = colorName;
    }

    public Enums.ColorName getClassType() {
        return colorName;
    }

    @Override
    public String prettyPrint() {
        return "Color." + Enums.colorToString(colorName);
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
