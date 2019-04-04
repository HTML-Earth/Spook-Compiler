package dk.aau.cs.d403.ast;

import dk.aau.cs.d403.parser.SpookBaseVisitor;
import dk.aau.cs.d403.parser.SpookParser;

import java.util.ArrayList;

public class AstBuilder extends SpookBaseVisitor<ASTnode> {
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

        ProgramNode programNode = new ProgramNode(mainNode);

        return programNode;
    }

    @Override
    public ASTnode visitMain(SpookParser.MainContext ctx) {

        ArrayList<VariableDeclarationNode> declarationNodes = new ArrayList<>();

        for (SpookParser.DeclarationsContext declarations : ctx.declarations()) {
            declarationNodes.add((VariableDeclarationNode)visitDeclarations(declarations));
        }

        MainNode mainNode = new MainNode(declarationNodes);

        return mainNode;
    }

    @Override
    public ASTnode visitDeclarations(SpookParser.DeclarationsContext ctx) {
        VariableDeclarationNode varDecNode = (VariableDeclarationNode) visitDeclaration(ctx.declaration());

        return varDecNode;
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
    public ASTnode visitDataType(SpookParser.DataTypeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ASTnode visitVectorType(SpookParser.VectorTypeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ASTnode visitVariable(SpookParser.VariableContext ctx) {
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
        String varName = ctx.dataTypeVariable().variable().getText();
        int integerValue = Integer.valueOf(ctx.digit().DIGIT().getSymbol().getText());
        return new IntDeclarationNode(varName, integerValue);
    }

    @Override
    public ASTnode visitFloatDecl(SpookParser.FloatDeclContext ctx) {
        return new FloatDeclarationNode();
    }

    @Override
    public ASTnode visitBoolDecl(SpookParser.BoolDeclContext ctx) {
        return new BoolDeclarationNode();
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
    public ASTnode visitDataTypeVariable(SpookParser.DataTypeVariableContext ctx) {
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
    public ASTnode visitSpace(SpookParser.SpaceContext ctx) {
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
        System.out.println(ctx);
        return visitChildren(ctx);
    }
}
