package dk.aau.cs.d403.ast;

import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.ast.statements.*;
import dk.aau.cs.d403.ast.structure.*;
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
        BlockNode blockNode = (BlockNode)visitBlock(ctx.block());

        return new MainNode(blockNode);
    }

    @Override
    public ASTnode visitBlock(SpookParser.BlockContext ctx) {
        ArrayList<StatementNode> statementNodes = new ArrayList<>();

        for (SpookParser.StatementsContext statements: ctx.statements()) {
            statementNodes.addAll(visitAllStatements(statements));
        }

        BlockNode blockNode = new BlockNode(statementNodes);

        return blockNode;
    }

    private ArrayList<StatementNode> visitAllStatements(SpookParser.StatementsContext ctx) {
        ArrayList<StatementNode> statementNodes = new ArrayList<>();

        statementNodes.add((StatementNode) visitStatement(ctx.statement()));

        if (ctx.statements() != null)
            statementNodes.addAll(visitAllStatements(ctx.statements()));

        return statementNodes;
    }

    @Override
    public ASTnode visitStatement(SpookParser.StatementContext ctx) {
        if (ctx.declaration() != null)
            return visitDeclaration(ctx.declaration());
        else if (ctx.assignment() != null)
            return visitAssignment(ctx.assignment());
        else if (ctx.objectFunctionCall() != null)
            return visitObjectFunctionCall(ctx.objectFunctionCall());
        else if (ctx.conditionalStatement() != null)
            return visitConditionalStatement(ctx.conditionalStatement());
        else if (ctx.RETURN() != null) {
            //do Return stuff
            return null;
        }
        else {
            throw new RuntimeException("Statement is of unknown type");
        }
    }

    @Override
    public ASTnode visitDeclaration(SpookParser.DeclarationContext ctx) {
        if (ctx.variableDecl() != null)
            return visitVariableDecl(ctx.variableDecl());
        else if (ctx.objectDecl() != null)
            return visitObjectDecl(ctx.objectDecl());
        else
            throw new RuntimeException("Declaration is of unknown type");
    }

    @Override
    public ASTnode visitVariableDecl(SpookParser.VariableDeclContext ctx) {

        VariableDeclarationNode.DataType dataType;

        if (ctx.dataType().INT() != null)
            dataType = VariableDeclarationNode.DataType.INT;
        else if (ctx.dataType().FLOAT() != null)
            dataType = VariableDeclarationNode.DataType.FLOAT;
        else if (ctx.dataType().BOOL() != null)
            dataType = VariableDeclarationNode.DataType.BOOL;
        else if (ctx.dataType().VECTOR2() != null)
            dataType = VariableDeclarationNode.DataType.VEC2;
        else if (ctx.dataType().VECTOR3() != null)
            dataType = VariableDeclarationNode.DataType.VEC3;
        else if (ctx.dataType().VECTOR4() != null)
            dataType = VariableDeclarationNode.DataType.VEC4;
        else
            throw new RuntimeException("DataType is unknown");

        if (ctx.assignment() != null) {
            return new VariableDeclarationNode(dataType, (AssignmentNode)visitAssignment(ctx.assignment()));
        }
        else if (ctx.variableName() != null) {
            return new VariableDeclarationNode(dataType, ctx.variableName().getText());
        }
        else {
            throw new RuntimeException("Expected variable name or assignment in declaration");
        }
    }

    @Override
    public ASTnode visitAssignment(SpookParser.AssignmentContext ctx) {
        ExpressionNode expressionNode = (ExpressionNode)visitExpression(ctx.expression());
        return new AssignmentNode(ctx.variableName().getText(), expressionNode);
    }

    @Override
    public ASTnode visitExpression(SpookParser.ExpressionContext ctx) {
        if (ctx.integerExpression() != null)
            return visitIntegerExpression(ctx.integerExpression());
        else if (ctx.floatExpression() != null)
            return visitFloatExpression(ctx.floatExpression());
        else if (ctx.vector2Expression() != null)
            return visitVector2Expression(ctx.vector2Expression());
        else if (ctx.vector3Expression() != null)
            return visitVector3Expression(ctx.vector3Expression());
        else if (ctx.vector4Expression() != null)
            return visitVector4Expression(ctx.vector4Expression());
        else if (ctx.boolExpression() != null)
            return visitBoolExpression(ctx.boolExpression());
        else if (ctx.ternaryOperator() != null)
            return visitTernaryOperator(ctx.ternaryOperator());
        else
            throw new RuntimeException("Invalid expression");
    }

    @Override
    public ASTnode visitIntegerExpression(SpookParser.IntegerExpressionContext ctx) {
        if (ctx.naturalNumber() != null)
            return new IntegerExpressionNode(new NaturalNumberNode(getNaturalNumberValue(ctx.naturalNumber())));
        else if (ctx.arithOperations() != null)
            return new IntegerExpressionNode(new ArrayList<ArithOperationNode>());
        else if (ctx.mathFunction() != null)
            return new IntegerExpressionNode(new MathFunctionCallNode());
        else
            throw new RuntimeException("Invalid integer expression");
    }

    @Override
    public ASTnode visitFloatExpression(SpookParser.FloatExpressionContext ctx) {
        if (ctx.realNumber() != null)
            return new FloatExpressionNode(new RealNumberNode(getRealNumberValue(ctx.realNumber())));
        else if (ctx.arithOperations() != null)
            return new FloatExpressionNode(new ArrayList<ArithOperationNode>());
        else if (ctx.mathFunction() != null)
            return new FloatExpressionNode(new MathFunctionCallNode());
        else
            throw new RuntimeException("Invalid float expression");
    }

    @Override
    public ASTnode visitVector2Expression(SpookParser.Vector2ExpressionContext ctx) {
        FloatExpressionNode float1 = (FloatExpressionNode)visitFloatExpression(ctx.floatExpression(0));
        FloatExpressionNode float2 = (FloatExpressionNode)visitFloatExpression(ctx.floatExpression(1));

        return new Vector2ExpressionNode(float1, float2);
    }

    @Override
    public ASTnode visitVector3Expression(SpookParser.Vector3ExpressionContext ctx) {
        FloatExpressionNode float1 = (FloatExpressionNode)visitFloatExpression(ctx.floatExpression(0));
        FloatExpressionNode float2 = (FloatExpressionNode)visitFloatExpression(ctx.floatExpression(1));
        FloatExpressionNode float3 = (FloatExpressionNode)visitFloatExpression(ctx.floatExpression(2));

        return new Vector3ExpressionNode(float1, float2, float3);
    }

    @Override
    public ASTnode visitVector4Expression(SpookParser.Vector4ExpressionContext ctx) {
        FloatExpressionNode float1 = (FloatExpressionNode)visitFloatExpression(ctx.floatExpression(0));
        FloatExpressionNode float2 = (FloatExpressionNode)visitFloatExpression(ctx.floatExpression(1));
        FloatExpressionNode float3 = (FloatExpressionNode)visitFloatExpression(ctx.floatExpression(2));
        FloatExpressionNode float4 = (FloatExpressionNode)visitFloatExpression(ctx.floatExpression(3));

        return new Vector4ExpressionNode(float1, float2, float3, float4);
    }

    @Override
    public ASTnode visitBoolExpression(SpookParser.BoolExpressionContext ctx) {
        if (ctx.BOOL_LITERAL() != null)
            return new BoolExpressionNode(getBooleanValue(ctx.BOOL_LITERAL()));
        else if (ctx.boolOperations() != null)
            return new BoolExpressionNode(new ArrayList<BoolOperationNode>());
        else
            throw new RuntimeException("Invalid Bool expression");
    }

    @Override
    public ASTnode visitClassDecl(SpookParser.ClassDeclContext ctx) {
        return new ClassDeclarationNode(ctx.className().getText());
    }

    @Override
    public ASTnode visitObjectDecl(SpookParser.ObjectDeclContext ctx) {
        if (ctx.classType().RECTANGLE() != null) {
            String rectName = ctx.objectVariableName().getText();
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
        return new FunctionDeclarationNode(ctx.functionName().getText(), ctx.returnType().getText());
    }

    @Override
    public ASTnode visitObjectFunctionCall(SpookParser.ObjectFunctionCallContext ctx) {
        return new ObjectFunctionCallNode();
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

    private boolean getBooleanValue(TerminalNode boolLiteral) {
        boolean value;

        if (boolLiteral.getText().equals("true"))
            value = true;
        else if (boolLiteral.getText().equals("false"))
            value = false;
        else
            throw new RuntimeException("Boolean value not 'true' or 'false'");

        return value;
    }
}
