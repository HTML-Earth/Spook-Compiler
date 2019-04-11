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

    private ArrayList<DeclarationNode> visitAllDeclarations(SpookParser.DeclarationsContext ctx) {
        ArrayList<DeclarationNode> declarationNodes = new ArrayList<>();

        declarationNodes.add((DeclarationNode) visitDeclaration(ctx.declaration()));

        if (ctx.declarations() != null)
            declarationNodes.addAll(visitAllDeclarations(ctx.declarations()));

        return declarationNodes;
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

        if (ctx.assignment() != null) {
            return new VariableDeclarationNode(getDataType(ctx.dataType()), (AssignmentNode)visitAssignment(ctx.assignment()));
        }
        else if (ctx.variableName() != null) {
            return new VariableDeclarationNode(getDataType(ctx.dataType()), ctx.variableName().getText());
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
            return new IntegerExpressionNode(visitAllArithOperations(ctx.arithOperations()));
        else if (ctx.mathFunction() != null)
            return new IntegerExpressionNode((MathFunctionCallNode)visitMathFunction(ctx.mathFunction()));
        else
            throw new RuntimeException("Invalid integer expression");
    }

    @Override
    public ASTnode visitFloatExpression(SpookParser.FloatExpressionContext ctx) {
        if (ctx.realNumber() != null)
            return new FloatExpressionNode(new RealNumberNode(getRealNumberValue(ctx.realNumber())));
        else if (ctx.arithOperations() != null)
            return new FloatExpressionNode(visitAllArithOperations(ctx.arithOperations()));
        else if (ctx.mathFunction() != null)
            return new FloatExpressionNode((MathFunctionCallNode)visitMathFunction(ctx.mathFunction()));
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
    public ASTnode visitMathFunction(SpookParser.MathFunctionContext ctx) {
        Enums.MathFunctionName functionName = getMathFunction(ctx.function());
        if (ctx.arithOperand() != null)
            return new MathFunctionCallNode(functionName, (ArithOperandNode)visitArithOperand(ctx.arithOperand()));
        else if (ctx.arithOperations() != null)
            return new MathFunctionCallNode(functionName, visitAllArithOperations(ctx.arithOperations()));
        else
            return new MathFunctionCallNode(functionName);
    }

    @Override
    public ASTnode visitClassDecl(SpookParser.ClassDeclContext ctx) {
        ClassBlockNode classBlockNode = (ClassBlockNode) visitClassBlock(ctx.classBlock());

        return new ClassDeclarationNode(ctx.className().getText(), classBlockNode);
    }

    @Override
    public ASTnode visitClassBlock(SpookParser.ClassBlockContext ctx) {
        ArrayList<DeclarationNode> declarationNodes = new ArrayList<>();
        ArrayList<FunctionDeclarationNode> functionDeclarationNodes = new ArrayList<>();

        // Declarations
        for (SpookParser.DeclarationsContext declarations: ctx.declarations()) {
            declarationNodes.addAll(visitAllDeclarations(declarations));
        }

        //Function declarations
        for (SpookParser.FunctionDeclContext functionDecl : ctx.functionDecl()) {
            functionDeclarationNodes.add((FunctionDeclarationNode)visitFunctionDecl(functionDecl));
        }

        return new ClassBlockNode(declarationNodes, functionDeclarationNodes);
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
        Enums.ReturnType returnType = Enums.ReturnType.VOID;
        if (ctx.returnType() != null)
        {
            returnType = getReturnType(ctx.returnType());
        }

        if (ctx.functionArgs() != null) {
            ArrayList<FunctionArgNode> functionArgNodes = visitAllFunctionArgs(ctx.functionArgs());
            return new FunctionDeclarationNode(returnType, ctx.functionName().getText(), functionArgNodes, (BlockNode)visitBlock(ctx.block()));
        }
        else {
            return new FunctionDeclarationNode(returnType, ctx.functionName().getText(), (BlockNode)visitBlock(ctx.block()));
        }
    }

    public ArrayList<FunctionArgNode> visitAllFunctionArgs(SpookParser.FunctionArgsContext ctx) {
        ArrayList<FunctionArgNode> functionArgNodes = new ArrayList<>();

        functionArgNodes.add((FunctionArgNode) visitFunctionArg(ctx.functionArg()));

        if (ctx.functionArgs() != null)
            functionArgNodes.addAll(visitAllFunctionArgs(ctx.functionArgs()));

        return functionArgNodes;
    }

    @Override
    public ASTnode visitFunctionArg(SpookParser.FunctionArgContext ctx) {
        return new FunctionArgNode(getDataType(ctx.dataType()), ctx.variableName().getText());
    }

    @Override
    public ASTnode visitObjectFunctionCall(SpookParser.ObjectFunctionCallContext ctx) {
        String objectName = ctx.objectVariableName().getText();
        String functionName = ctx.functionName().getText();
        if (ctx.objectArgs() != null) {
            ArrayList<ObjectArgumentNode> argumentNodes = visitAllObjectArguments(ctx.objectArgs());
            return new ObjectFunctionCallNode(objectName, functionName, argumentNodes);
        }
        else {
            return new ObjectFunctionCallNode(objectName, functionName);
        }
    }

    public ArrayList<ObjectArgumentNode> visitAllObjectArguments(SpookParser.ObjectArgsContext ctx) {
        ArrayList<ObjectArgumentNode> objectArgumentNodes = new ArrayList<>();

        objectArgumentNodes.add((ObjectArgumentNode) visitObjectArg(ctx.objectArg()));

        if (ctx.objectArgs() != null)
            objectArgumentNodes.addAll(visitAllObjectArguments(ctx.objectArgs()));

        return objectArgumentNodes;
    }

    @Override
    public ASTnode visitObjectArg(SpookParser.ObjectArgContext ctx) {
        if (ctx.variableName() != null)
            return new ObjectArgumentNode(ctx.variableName().getText());
        else if (ctx.realNumber() != null)
            return new ObjectArgumentNode(new RealNumberNode(getRealNumberValue(ctx.realNumber())));
        else if (ctx.arithOperation() != null)
            return new ObjectArgumentNode((ArithOperationNode)visitArithOperation(ctx.arithOperation()));
        else if (ctx.classProperty() != null)
            return new ObjectArgumentNode((ClassPropertyNode)visitClassProperty(ctx.classProperty()));
        else
            throw new RuntimeException("Invalid Object Function Call Argument");
    }

    @Override
    public ASTnode visitArithOperation(SpookParser.ArithOperationContext ctx) {
        switch (ctx.arithOperand().size()) {
            case 0:
                // operator ( operation )
                if (ctx.operator() != null && ctx.arithOperation() != null) {
                    Enums.Operator operator = getOperator(ctx.operator());
                    ArithOperationNode operationNode = (ArithOperationNode)visitArithOperation(ctx.arithOperation());
                    return new ArithOperationNode(operator, operationNode);
                }
                // ( operations )
                else if (ctx.arithOperations() != null) {
                    return new ArithOperationNode(visitAllArithOperations(ctx.arithOperations()));
                }
                else throw new RuntimeException("Expected 'operator (operation)' or '(operations)'");
            case 1:
                // operand operator ( operation )
                if (ctx.arithOperand(0) != null && ctx.operator() != null && ctx.arithOperation() != null) {
                    ArithOperandNode operandNode = (ArithOperandNode)visitArithOperand(ctx.arithOperand(0));
                    Enums.Operator operator = getOperator(ctx.operator());
                    ArithOperationNode operationNode = (ArithOperationNode)visitArithOperation(ctx.arithOperation());
                    return new ArithOperationNode(operandNode, operator, operationNode);
                }
                // operator operand
                else if (ctx.operator() != null && ctx.arithOperand(0) != null) {
                    Enums.Operator operator = getOperator(ctx.operator());
                    ArithOperandNode operandNode = (ArithOperandNode)visitArithOperand(ctx.arithOperand(0));
                    return new ArithOperationNode(operator, operandNode);
                }
                else throw new RuntimeException("Expected 'operand operator (operation)' or 'operator operand'");
            case 2:
                // operand operator operand
                if (ctx.arithOperand(0) != null && ctx.operator() != null && ctx.arithOperand(1) != null) {
                    ArithOperandNode leftOperand = (ArithOperandNode)visitArithOperand(ctx.arithOperand(0));
                    Enums.Operator operator = getOperator(ctx.operator());
                    ArithOperandNode rightOperand = (ArithOperandNode)visitArithOperand(ctx.arithOperand(1));
                    return new ArithOperationNode(leftOperand, operator, rightOperand);
                }
                else throw new RuntimeException("Expected 'operand operator operand'");
            default:
                throw new RuntimeException("INVALID");
        }
    }

    public ArrayList<ArithOperationNode> visitAllArithOperations(SpookParser.ArithOperationsContext ctx) {
        ArrayList<ArithOperationNode> arithOperationNodes = new ArrayList<>();

        arithOperationNodes.add((ArithOperationNode) visitArithOperation(ctx.arithOperation()));

        if (ctx.arithOperations() != null)
            arithOperationNodes.addAll(visitAllArithOperations(ctx.arithOperations()));

        return arithOperationNodes;
    }

    @Override
    public ASTnode visitArithOperand(SpookParser.ArithOperandContext ctx) {
        if (ctx.realNumber() != null)
            return new ArithOperandNode(new RealNumberNode(getRealNumberValue(ctx.realNumber())));
        else if (ctx.mathFunction() != null)
            return new ArithOperandNode((MathFunctionCallNode)visitMathFunction(ctx.mathFunction()));
        else if (ctx.variableName() != null)
            return new ArithOperandNode(ctx.variableName().getText());
        else if (ctx.UNIFORM() != null)
            return new ArithOperandNode(ctx.UNIFORM().getText());
        else
            throw new RuntimeException("Invalid Operand");
    }

    @Override
    public ASTnode visitClassProperty(SpookParser.ClassPropertyContext ctx) {
        return new ClassPropertyNode(getClassType(ctx.classType()), ctx.variableName().getText());
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

    private Enums.DataType getDataType(SpookParser.DataTypeContext ctx) {
        Enums.DataType dataType;

        if (ctx.INT() != null)
            dataType = Enums.DataType.INT;
        else if (ctx.FLOAT() != null)
            dataType = Enums.DataType.FLOAT;
        else if (ctx.BOOL() != null)
            dataType = Enums.DataType.BOOL;
        else if (ctx.VECTOR2() != null)
            dataType = Enums.DataType.VEC2;
        else if (ctx.VECTOR3() != null)
            dataType = Enums.DataType.VEC3;
        else if (ctx.VECTOR4() != null)
            dataType = Enums.DataType.VEC4;
        else
            throw new RuntimeException("DataType is unknown");

        return dataType;
    }

    private Enums.ReturnType getReturnType(SpookParser.ReturnTypeContext ctx) {
        Enums.ReturnType returnType;

        if (ctx.dataType().INT() != null)
            returnType = Enums.ReturnType.INT;
        else if (ctx.dataType().FLOAT() != null)
            returnType = Enums.ReturnType.FLOAT;
        else if (ctx.dataType().BOOL() != null)
            returnType = Enums.ReturnType.BOOL;
        else if (ctx.dataType().VECTOR2() != null)
            returnType = Enums.ReturnType.VEC2;
        else if (ctx.dataType().VECTOR3() != null)
            returnType = Enums.ReturnType.VEC3;
        else if (ctx.dataType().VECTOR4() != null)
            returnType = Enums.ReturnType.VEC4;
        else
            throw new RuntimeException("ReturnType is unknown");

        return returnType;
    }

    private Enums.ClassType getClassType(SpookParser.ClassTypeContext ctx) {
        Enums.ClassType classType;

        if (ctx.CIRCLE() != null)
            classType = Enums.ClassType.CIRCLE;
        else if (ctx.RECTANGLE() != null)
            classType = Enums.ClassType.RECTANGLE;
        else if (ctx.TRIANGLE() != null)
            classType = Enums.ClassType.TRIANGLE;
        else if (ctx.SHAPE() != null)
            classType = Enums.ClassType.SHAPE;
        else if (ctx.COLOR() != null)
            classType = Enums.ClassType.COLOR;
        else
            throw new RuntimeException("ClassType is unknown");

        return classType;
    }

    private Enums.Operator getOperator(SpookParser.OperatorContext ctx) {
        Enums.Operator operator;

        if (ctx.ADD() != null)
            operator = Enums.Operator.ADD;
        else if (ctx.SUB() != null)
            operator = Enums.Operator.SUB;
        else if (ctx.MOD() != null)
            operator = Enums.Operator.MOD;
        else if (ctx.DIV() != null)
            operator = Enums.Operator.DIV;
        else if (ctx.MUL() != null)
            operator = Enums.Operator.MUL;
        else
            throw new RuntimeException("Operator is unknown");

        return operator;
    }

    private Enums.MathFunctionName getMathFunction(SpookParser.FunctionContext ctx) {
        Enums.MathFunctionName mathFunction;

        if (ctx.ABS() != null)
            mathFunction = Enums.MathFunctionName.ABS;
        else if (ctx.SIN() != null)
            mathFunction = Enums.MathFunctionName.SIN;
        else if (ctx.COS() != null)
            mathFunction = Enums.MathFunctionName.COS;
        else if (ctx.TAN() != null)
            mathFunction = Enums.MathFunctionName.TAN;
        else
            throw new RuntimeException("Math function is unknown");

        return mathFunction;
    }
}
