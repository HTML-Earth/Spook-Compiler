package dk.aau.cs.d403.ast.statements;

public class RectangleDeclarationNode extends ObjectDeclarationNode {
    private String objName;

    private float width;
    private float height;

    private float colorR;
    private float colorG;
    private float colorB;
    private float colorA;

    public RectangleDeclarationNode(String objName, float width, float height, float colorR, float colorG, float colorB, float colorA) {
        this.objName = objName;
        this.width = width;
        this.height = height;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
        this.colorA = colorA;
    }

    @Override
    public String prettyPrint() {
        return "Rectangle " + objName + " = (" + width + ", " + height + ", " + "Color(" + colorR + "," + colorG + "," + colorB + "," + colorA + "))";
    }
}
