package dk.aau.cs.d403.codegen;

import dk.aau.cs.d403.ast.ProgramNode;
import dk.aau.cs.d403.ast.VariableDeclarationNode;

public class CodeGenerator {

    public String GenerateGLSL(ProgramNode ast) {
        StringBuilder sb = new StringBuilder();

        sb.append("void mainImage( out vec4 fragColor, in vec2 fragCoord ) {");

        for (VariableDeclarationNode varDec : ast.getMainNode().getDeclarationNodes()) {
            sb.append("\n\t");
            sb.append(varDec.prettyPrint());
        }

        sb.append("\n}");
        return sb.toString();
    }
}
