package dk.aau.cs.d403.codegen;

import dk.aau.cs.d403.ast.structure.ProgramNode;

public class CodeGenerator {

    public String GenerateGLSL(ProgramNode ast) {
        StringBuilder sb = new StringBuilder();

        sb.append("void mainImage( out vec4 fragColor, in vec2 fragCoord ) {\n");
        sb.append(ast.getMainNode().getBlockNode().prettyPrint());
        return sb.toString();
    }
}
