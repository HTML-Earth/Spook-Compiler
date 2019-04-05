package dk.aau.cs.d403.ast;

import dk.aau.cs.d403.parser.SpookParserBaseVisitor;
import dk.aau.cs.d403.parser.SpookParser;

import java.util.ArrayList;

public class AstBuilder extends SpookParserBaseVisitor<ASTnode> {
    @Override
    public ASTnode visitProgram(SpookParser.ProgramContext ctx) {
        //Main
        MainNode mainNode = (MainNode)visitMain(ctx.main());

        //Class declarations
        for (SpookParser.ClassDeclContext classDecl : ctx.classDecl()) {
            visitClassDecl(classDecl);
        }

        //Function declarations
        for (SpookParser.FunctionDeclContext functionDecl : ctx.functionDecl()) {
            visitFunctionDecl(functionDecl);
        }

        return new ProgramNode(mainNode);
    }

    @Override
    public ASTnode visitMain(SpookParser.MainContext ctx) {

        ArrayList<VariableDeclarationNode> declarationNodes = new ArrayList<>();

        for (SpookParser.DeclarationsContext declarations : ctx.declarations()) {
            declarationNodes.addAll(visitAllDeclarations(declarations));
        }

        return new MainNode(declarationNodes);
    }

    public ArrayList<VariableDeclarationNode> visitAllDeclarations(SpookParser.DeclarationsContext ctx) {
        ArrayList<VariableDeclarationNode> declarationNodes = new ArrayList<>();

        declarationNodes.add((VariableDeclarationNode)visitDeclaration(ctx.declaration()));

        if (ctx.declarations() != null)
            declarationNodes.addAll(visitAllDeclarations(ctx.declarations()));

        return declarationNodes;
    }

    @Override
    public ASTnode visitDeclaration(SpookParser.DeclarationContext ctx) {
        if (ctx.numberDecl() != null)
            return visitNumberDecl(ctx.numberDecl());
        else
            return visitBoolDecl(ctx.boolDecl());
    }

    @Override
    public ASTnode visitComment(SpookParser.CommentContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ASTnode visitClassDecl(SpookParser.ClassDeclContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ASTnode visitFunctionDecl(SpookParser.FunctionDeclContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ASTnode visitReturnType(SpookParser.ReturnTypeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ASTnode visitNumberDecl(SpookParser.NumberDeclContext ctx) {
        if (ctx.integerDecl() != null)
            return visitIntegerDecl(ctx.integerDecl());
        else if (ctx.floatDecl() != null)
            return visitFloatDecl(ctx.floatDecl());
        else
            return null;
    }

    @Override
    public ASTnode visitIntegerDecl(SpookParser.IntegerDeclContext ctx) {
        String varName = ctx.ID().getText();
        DigitNode digit = (DigitNode)visitDigit(ctx.digit());
        int integerValue = digit.getNumberValue();
        return new IntDeclarationNode(varName, integerValue);
    }

    @Override
    public ASTnode visitFloatDecl(SpookParser.FloatDeclContext ctx) {
        String varName = ctx.ID().getText();
        FloatDigitNode digit = (FloatDigitNode)visitFloat_digit(ctx.real_number().float_digit());
        float floatValue = digit.getNumberValue();
        return new FloatDeclarationNode(varName, floatValue);
    }

    @Override
    public ASTnode visitBoolDecl(SpookParser.BoolDeclContext ctx) {
        return null;
        //return new BoolDeclarationNode(ctx.dataTypeVariable().variable().getText(), false);
    }

    @Override
    public ASTnode visitBoolOperation(SpookParser.BoolOperationContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ASTnode visitVector2Decl(SpookParser.Vector2DeclContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ASTnode visitVector3Decl(SpookParser.Vector3DeclContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ASTnode visitVector4Decl(SpookParser.Vector4DeclContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ASTnode visitArithOperation(SpookParser.ArithOperationContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ASTnode visitMath_function(SpookParser.Math_functionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ASTnode visitReal_number(SpookParser.Real_numberContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ASTnode visitDigit(SpookParser.DigitContext ctx) {
        String numberString = ctx.DIGIT().getSymbol().getText();
        return new DigitNode(Integer.valueOf(numberString));
    }

    @Override
    public ASTnode visitFloat_digit(SpookParser.Float_digitContext ctx) {
        String numberString = ctx.FLOAT_DIGIT().getSymbol().getText();
        return new FloatDigitNode(Float.valueOf(numberString));
    }
}
