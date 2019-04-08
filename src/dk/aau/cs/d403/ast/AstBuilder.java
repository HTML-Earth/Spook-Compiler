package dk.aau.cs.d403.ast;

import dk.aau.cs.d403.parser.SpookParserBaseVisitor;
import dk.aau.cs.d403.parser.SpookParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;

public class AstBuilder extends SpookParserBaseVisitor<ASTnode> {
    @Override
    public ASTnode visitProgram(SpookParser.ProgramContext ctx) {
        //Main shader function
        MainNode mainNode = (MainNode)visitMain(ctx.main());
        ArrayList<ClassDeclarationNode> classDeclarationNodes = new ArrayList<>();
        ArrayList<FunctionDeclarationNode> functionDeclarationNodes = new ArrayList<>();

        //Class declarations
        for (SpookParser.ClassDeclContext classDecl : ctx.classDecl()) {
            classDeclarationNodes.add((ClassDeclarationNode)visitClassDecl(classDecl));
        }

        //Function declarations
        for (SpookParser.FunctionDeclContext functionDecl : ctx.functionDecl()) {
            functionDeclarationNodes.add((FunctionDeclarationNode)visitFunctionDecl(functionDecl));
        }

        return new ProgramNode(mainNode, classDeclarationNodes, functionDeclarationNodes);
    }

    @Override
    public ASTnode visitMain(SpookParser.MainContext ctx) {

        ArrayList<VariableDeclarationNode> declarationNodes = new ArrayList<>();

        for (SpookParser.DeclarationsContext declarations : ctx.declarations()) {
            declarationNodes.addAll(visitAllDeclarations(declarations));
        }

        return new MainNode(declarationNodes);
    }

    private ArrayList<VariableDeclarationNode> visitAllDeclarations(SpookParser.DeclarationsContext ctx) {
        ArrayList<VariableDeclarationNode> declarationNodes = new ArrayList<>();

        declarationNodes.add((VariableDeclarationNode)visitDeclaration(ctx.declaration()));

        if (ctx.declarations() != null)
            declarationNodes.addAll(visitAllDeclarations(ctx.declarations()));

        return declarationNodes;
    }

    @Override
    public ASTnode visitClassDecl(SpookParser.ClassDeclContext ctx) {
        return new ClassDeclarationNode(ctx.ID().getText());
    }

    @Override
    public ASTnode visitObjectDecl(SpookParser.ObjectDeclContext ctx) {
        if (ctx.classType().RECTANGLE() != null) {
            String rectName = ctx.ID().getText();
            float rectWidth = getRealNumberValue(ctx.objectArgs(0).objectArg().realNumber());
            float rectHeight = getRealNumberValue(ctx.objectArgs(0).objectArgs().objectArg().realNumber());
            float rectColorR = 0;
            float rectColorG = 0;
            float rectColorB = 0;
            float rectColorA = 0;

            return new RectangleDeclarationNode(rectName, rectWidth, rectHeight, rectColorR, rectColorG, rectColorB, rectColorA);
        }
        else if (ctx.classType().CIRCLE() != null)
            return null;
        else
            throw new RuntimeException("Object is of unknown type");
    }

    @Override
    public ASTnode visitFunctionDecl(SpookParser.FunctionDeclContext ctx) {
        return new FunctionDeclarationNode(ctx.ID(0).toString(), ctx.returnType().getText());
    }

    @Override
    public ASTnode visitObjectFunctionCall(SpookParser.ObjectFunctionCallContext ctx) {
        return new ObjectFunctionCallNode();
    }

    @Override
    public ASTnode visitDeclaration(SpookParser.DeclarationContext ctx) {
        if (ctx.numberDecl() != null)
            return visitNumberDecl(ctx.numberDecl());
        else if (ctx.boolDecl() != null)
            return visitBoolDecl(ctx.boolDecl());
        else if (ctx.objectDecl() != null)
            return visitObjectDecl(ctx.objectDecl());
        else if (ctx.objectFunctionCall() != null)
            return visitObjectFunctionCall(ctx.objectFunctionCall());
        else {
            throw new RuntimeException("Declaration is of unknown type");
        }
    }

    @Override
    public ASTnode visitNumberDecl(SpookParser.NumberDeclContext ctx) {
        if (ctx.integerDecl() != null)
            return visitIntegerDecl(ctx.integerDecl());
        else if (ctx.floatDecl() != null)
            return visitFloatDecl(ctx.floatDecl());
        else if (ctx.vector2Decl() != null)
            return visitVector2Decl(ctx.vector2Decl());
        else if (ctx.vector3Decl() != null)
            return visitVector3Decl(ctx.vector3Decl());
        else if (ctx.vector4Decl() != null)
            return visitVector4Decl(ctx.vector4Decl());
        else
            return null;
    }

    @Override
    public ASTnode visitIntegerDecl(SpookParser.IntegerDeclContext ctx) {
        String varName = ctx.ID().getText();
        int integerValue = getNaturalNumberValue(ctx.naturalNumber());
        return new IntDeclarationNode(varName, integerValue);
    }

    @Override
    public ASTnode visitFloatDecl(SpookParser.FloatDeclContext ctx) {
        String varName = ctx.ID().getText();
        float value = getRealNumberValue(ctx.realNumber());

        return new FloatDeclarationNode(varName, value);
    }

    @Override
    public ASTnode visitVector2Decl(SpookParser.Vector2DeclContext ctx) {
        String varName = ctx.ID().getText();

        float[] values = new float[2];

        for (int i = 0; i < 2; i++) {
            values[i] = getRealNumberValue(ctx.realNumber(i));
        }

        return new Vector2DeclarationNode(varName, values[0], values[1]);
    }

    @Override
    public ASTnode visitVector3Decl(SpookParser.Vector3DeclContext ctx) {
        String varName = ctx.ID().getText();

        float[] values = new float[3];

        for (int i = 0; i < 3; i++) {
            values[i] = getRealNumberValue(ctx.realNumber(i));
        }

        return new Vector3DeclarationNode(varName, values[0], values[1], values[2]);
    }

    @Override
    public ASTnode visitVector4Decl(SpookParser.Vector4DeclContext ctx) {
        String varName = ctx.ID().getText();

        float[] values = new float[4];

        for (int i = 0; i < 4; i++) {
            values[i] = getRealNumberValue(ctx.realNumber(i));
        }

        return new Vector4DeclarationNode(varName, values[0], values[1], values[2], values[3]);
    }

    private float getRealNumberValue(SpookParser.RealNumberContext ctx) {
        float value;

        if (ctx.FLOAT_DIGIT() != null)
            value = Float.valueOf(ctx.FLOAT_DIGIT().getSymbol().getText());
        else if (ctx.naturalNumber() != null)
            value = getNaturalNumberValue(ctx.naturalNumber());
        else
            throw new RuntimeException("Real number is not a digit or float digit");

        return value;
    }

    private int getNaturalNumberValue(SpookParser.NaturalNumberContext ctx) {
        int value;

        if (ctx.DIGIT() != null)
            value = Integer.valueOf(ctx.DIGIT().getSymbol().getText());
        else if (ctx.DIGIT_NEGATIVE() != null)
            value = Integer.valueOf(ctx.DIGIT_NEGATIVE().getSymbol().getText());
        else
            value = 0;

        return value;
    }

    @Override
    public ASTnode visitBoolDecl(SpookParser.BoolDeclContext ctx) {
        String varName = ctx.ID().getText();
        boolean value = getBoolLiteralValue(ctx.BOOL_LITERAL());

        return new BoolDeclarationNode(varName, value);
    }

    private boolean getBoolLiteralValue(TerminalNode boolLiteral) {
        if (boolLiteral.toString().equals("true")) {
            return true;
        }
        else if (boolLiteral.toString().equals("false")) {
            return false;
        }
        else {
            throw new RuntimeException("unexpected bool literal value");
        }
    }
}
