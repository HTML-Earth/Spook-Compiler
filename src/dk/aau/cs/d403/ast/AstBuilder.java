package dk.aau.cs.d403.ast;

import dk.aau.cs.d403.CompilerException;
import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.ast.statements.*;
import dk.aau.cs.d403.ast.structure.*;
import dk.aau.cs.d403.parser.SpookParserBaseVisitor;
import dk.aau.cs.d403.parser.SpookParser;
import org.antlr.v4.runtime.ParserRuleContext;
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

        ProgramNode programNode = new ProgramNode(mainNode, classDeclarationNodes, functionDeclarationNodes);
        programNode.setCodePosition(getCodePosition(ctx));

        return programNode;
    }

    @Override
    public ASTnode visitMain(SpookParser.MainContext ctx) {
        BlockNode blockNode = (BlockNode)visitBlock(ctx.block());

        MainNode mainNode = new MainNode(blockNode);
        mainNode.setCodePosition(getCodePosition(ctx));

        return mainNode;
    }

    @Override
    public ASTnode visitBlock(SpookParser.BlockContext ctx) {
        ArrayList<StatementNode> statementNodes = new ArrayList<>();

        for (SpookParser.StatementsContext statements: ctx.statements()) {
            statementNodes.addAll(visitAllStatements(statements));
        }

        BlockNode blockNode = new BlockNode(statementNodes);
        blockNode.setCodePosition(getCodePosition(ctx));

        return blockNode;
    }

    private ArrayList<StatementNode> visitAllStatements(SpookParser.StatementsContext ctx) {
        ArrayList<StatementNode> statementNodes = new ArrayList<>();

        StatementNode statementNode = (StatementNode) visitStatement(ctx.statement());

        if (statementNode != null)
            statementNodes.add(statementNode);

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
        else if (ctx.functionCall() != null)
            return visitFunctionCall(ctx.functionCall());
        else if (ctx.conditionalStatement() != null)
            return visitConditionalStatement(ctx.conditionalStatement());
        else if (ctx.RETURN() != null) {
            if (ctx.variableName() != null) {
                ReturnNode returnNode = new ReturnNode(ctx.variableName().getText());
                returnNode.setCodePosition(getCodePosition(ctx));
                return returnNode;
            }
            else if (ctx.realNumber() != null) {
                ReturnNode returnNode = new ReturnNode(new RealNumberNode(getRealNumberValue(ctx.realNumber())));
                returnNode.setCodePosition(getCodePosition(ctx));
                return returnNode;
            }
            else if (ctx.BOOL_LITERAL() != null) {
                ReturnNode returnNode = new ReturnNode(getBooleanValue(ctx.BOOL_LITERAL()));
                returnNode.setCodePosition(getCodePosition(ctx));
                return returnNode;
            }
            else
                throw new CompilerException("Invalid return statement", getCodePosition(ctx));
        }
        else {
            throw new CompilerException("Statement is of unknown type", getCodePosition(ctx));
        }
    }

    private ArrayList<DeclarationNode> visitAllDeclarations(SpookParser.DeclarationsContext ctx) {
        ArrayList<DeclarationNode> declarationNodes = new ArrayList<>();

        DeclarationNode declarationNode = (DeclarationNode) visitDeclaration(ctx.declaration());

        if (declarationNode != null)
            declarationNodes.add(declarationNode);

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
            throw new CompilerException("Declaration is of unknown type", getCodePosition(ctx));
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
            throw new CompilerException("Expected variable name or assignment in declaration", getCodePosition(ctx));
        }
    }

    @Override
    public ASTnode visitAssignment(SpookParser.AssignmentContext ctx) {
        ExpressionNode expressionNode = (ExpressionNode)visitExpression(ctx.expression());
        AssignmentNode assignmentNode = new AssignmentNode(ctx.variableName().getText(), expressionNode);
        assignmentNode.setCodePosition(getCodePosition(ctx));

        return assignmentNode;
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
            throw new CompilerException("Invalid expression", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitIntegerExpression(SpookParser.IntegerExpressionContext ctx) {
        if (ctx.naturalNumber() != null) {
            IntegerExpressionNode integerExpressionNode = new IntegerExpressionNode(new NaturalNumberNode(getNaturalNumberValue(ctx.naturalNumber())));
            integerExpressionNode.setCodePosition(getCodePosition(ctx));
            return integerExpressionNode;
        }
        else if (ctx.arithOperations() != null) {
            IntegerExpressionNode integerExpressionNode = new IntegerExpressionNode(visitAllArithOperations(ctx.arithOperations()));
            integerExpressionNode.setCodePosition(getCodePosition(ctx));
            return integerExpressionNode;
        }
        else if (ctx.mathFunction() != null) {
            IntegerExpressionNode integerExpressionNode = new IntegerExpressionNode((MathFunctionCallNode)visitMathFunction(ctx.mathFunction()));
            integerExpressionNode.setCodePosition(getCodePosition(ctx));
            return integerExpressionNode;
        }
        else
            throw new CompilerException("Invalid integer expression", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitFloatExpression(SpookParser.FloatExpressionContext ctx) {
        if (ctx.realNumber() != null) {
            FloatExpressionNode floatExpressionNode = new FloatExpressionNode(new RealNumberNode(getRealNumberValue(ctx.realNumber())));
            floatExpressionNode.setCodePosition(getCodePosition(ctx));
            return floatExpressionNode;
        }
        else if (ctx.arithOperations() != null) {
            FloatExpressionNode floatExpressionNode = new FloatExpressionNode(visitAllArithOperations(ctx.arithOperations()));
            floatExpressionNode.setCodePosition(getCodePosition(ctx));
            return floatExpressionNode;
        }
        else if (ctx.mathFunction() != null) {
            FloatExpressionNode floatExpressionNode = new FloatExpressionNode((MathFunctionCallNode)visitMathFunction(ctx.mathFunction()));
            floatExpressionNode.setCodePosition(getCodePosition(ctx));
            return floatExpressionNode;
        }
        else
            throw new CompilerException("Invalid float expression", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitVector2Expression(SpookParser.Vector2ExpressionContext ctx) {
        FloatExpressionNode float1 = (FloatExpressionNode)visitFloatExpression(ctx.floatExpression(0));
        FloatExpressionNode float2 = (FloatExpressionNode)visitFloatExpression(ctx.floatExpression(1));

        Vector2ExpressionNode vector2ExpressionNode = new Vector2ExpressionNode(float1, float2);
        vector2ExpressionNode.setCodePosition(getCodePosition(ctx));

        return vector2ExpressionNode;
    }

    @Override
    public ASTnode visitVector3Expression(SpookParser.Vector3ExpressionContext ctx) {
        FloatExpressionNode float1 = (FloatExpressionNode)visitFloatExpression(ctx.floatExpression(0));
        FloatExpressionNode float2 = (FloatExpressionNode)visitFloatExpression(ctx.floatExpression(1));
        FloatExpressionNode float3 = (FloatExpressionNode)visitFloatExpression(ctx.floatExpression(2));

        Vector3ExpressionNode vector3ExpressionNode = new Vector3ExpressionNode(float1, float2, float3);
        vector3ExpressionNode.setCodePosition(getCodePosition(ctx));

        return vector3ExpressionNode;
    }

    @Override
    public ASTnode visitVector4Expression(SpookParser.Vector4ExpressionContext ctx) {
        FloatExpressionNode float1 = (FloatExpressionNode)visitFloatExpression(ctx.floatExpression(0));
        FloatExpressionNode float2 = (FloatExpressionNode)visitFloatExpression(ctx.floatExpression(1));
        FloatExpressionNode float3 = (FloatExpressionNode)visitFloatExpression(ctx.floatExpression(2));
        FloatExpressionNode float4 = (FloatExpressionNode)visitFloatExpression(ctx.floatExpression(3));

        Vector4ExpressionNode vector4ExpressionNode = new Vector4ExpressionNode(float1, float2, float3, float4);
        vector4ExpressionNode.setCodePosition(getCodePosition(ctx));

        return vector4ExpressionNode;
    }

    @Override
    public ASTnode visitBoolExpression(SpookParser.BoolExpressionContext ctx) {
        if (ctx.BOOL_LITERAL() != null) {
            BoolExpressionNode boolExpressionNode = new BoolExpressionNode(getBooleanValue(ctx.BOOL_LITERAL()));
            boolExpressionNode.setCodePosition(getCodePosition(ctx));

            return boolExpressionNode;
        }
        else if (ctx.boolOperations() != null) {
            BoolExpressionNode boolExpressionNode = new BoolExpressionNode(new ArrayList<BoolOperationNode>());
            boolExpressionNode.setCodePosition(getCodePosition(ctx));

            return boolExpressionNode;
        }
        else
            throw new CompilerException("Invalid Bool expression", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitMathFunction(SpookParser.MathFunctionContext ctx) {
        Enums.MathFunctionName functionName = getMathFunction(ctx.function());
        if (ctx.arithOperand() != null) {
            MathFunctionCallNode mathFunctionCallNode = new MathFunctionCallNode(functionName, (ArithOperandNode)visitArithOperand(ctx.arithOperand()));
            mathFunctionCallNode.setCodePosition(getCodePosition(ctx));

            return mathFunctionCallNode;
        }
        else if (ctx.arithOperations() != null) {
            MathFunctionCallNode mathFunctionCallNode = new MathFunctionCallNode(functionName, visitAllArithOperations(ctx.arithOperations()));
            mathFunctionCallNode.setCodePosition(getCodePosition(ctx));

            return mathFunctionCallNode;
        }
        else {
            MathFunctionCallNode mathFunctionCallNode = new MathFunctionCallNode(functionName);
            mathFunctionCallNode.setCodePosition(getCodePosition(ctx));

            return mathFunctionCallNode;
        }
    }

    @Override
    public ASTnode visitClassDecl(SpookParser.ClassDeclContext ctx) {
        ClassBlockNode classBlockNode = (ClassBlockNode) visitClassBlock(ctx.classBlock());

        ClassDeclarationNode classDeclarationNode = new ClassDeclarationNode(ctx.className().getText(), classBlockNode);
        classDeclarationNode.setCodePosition(getCodePosition(ctx));

        return classDeclarationNode;
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

        ClassBlockNode classBlockNode = new ClassBlockNode(declarationNodes, functionDeclarationNodes);
        classBlockNode.setCodePosition(getCodePosition(ctx));

        return classBlockNode;
    }

    @Override
    public ASTnode visitObjectDecl(SpookParser.ObjectDeclContext ctx) {
        Enums.ClassType classType = getClassType(ctx.classType());
        String objectName = ctx.objectVariableName().getText();
        if (ctx.objectArgs() != null) {
            ArrayList<ObjectArgumentNode> objectArgumentNodes = visitAllObjectArguments(ctx.objectArgs(0));

            ObjectDeclarationNode objectDeclarationNode = new ObjectDeclarationNode(classType, objectName, objectArgumentNodes);
            objectDeclarationNode.setCodePosition(getCodePosition(ctx));

            return objectDeclarationNode;
        }
        else {
            ObjectDeclarationNode objectDeclarationNode = new ObjectDeclarationNode(classType, objectName);
            objectDeclarationNode.setCodePosition(getCodePosition(ctx));

            return objectDeclarationNode;
        }
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

            FunctionDeclarationNode functionDeclarationNode = new FunctionDeclarationNode(returnType, ctx.functionName().getText(), functionArgNodes, (BlockNode)visitBlock(ctx.block()));
            functionDeclarationNode.setCodePosition(getCodePosition(ctx));

            return functionDeclarationNode;
        }
        else {
            FunctionDeclarationNode functionDeclarationNode = new FunctionDeclarationNode(returnType, ctx.functionName().getText(), (BlockNode)visitBlock(ctx.block()));
            functionDeclarationNode.setCodePosition(getCodePosition(ctx));

            return functionDeclarationNode;
        }
    }

    private ArrayList<FunctionArgNode> visitAllFunctionArgs(SpookParser.FunctionArgsContext ctx) {
        ArrayList<FunctionArgNode> functionArgNodes = new ArrayList<>();

        FunctionArgNode functionArgNode = (FunctionArgNode) visitFunctionArg(ctx.functionArg());

        if (functionArgNode != null)
            functionArgNodes.add(functionArgNode);

        if (ctx.functionArgs() != null)
            functionArgNodes.addAll(visitAllFunctionArgs(ctx.functionArgs()));

        return functionArgNodes;
    }

    @Override
    public ASTnode visitFunctionArg(SpookParser.FunctionArgContext ctx) {
        FunctionArgNode functionArgNode = new FunctionArgNode(getDataType(ctx.dataType()), ctx.variableName().getText());
        functionArgNode.setCodePosition(getCodePosition(ctx));

        return functionArgNode;
    }

    @Override
    public ASTnode visitFunctionCall(SpookParser.FunctionCallContext ctx) {
        if (ctx.objectFunctionCall() != null)
            return visitObjectFunctionCall(ctx.objectFunctionCall());
        else if (ctx.nonObjectFunctionCall() != null)
            return visitNonObjectFunctionCall(ctx.nonObjectFunctionCall());
        else
            throw new CompilerException("Invalid function call", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitNonObjectFunctionCall(SpookParser.NonObjectFunctionCallContext ctx) {
        String functionName = ctx.functionName().getText();
        if (ctx.objectArgs() != null) {
            ArrayList<ObjectArgumentNode> argumentNodes = visitAllObjectArguments(ctx.objectArgs());
            NonObjectFunctionCallNode nonObjectFunctionCallNode = new NonObjectFunctionCallNode(functionName, argumentNodes);
            nonObjectFunctionCallNode.setCodePosition(getCodePosition(ctx));

            return nonObjectFunctionCallNode;
        }
        else {
            NonObjectFunctionCallNode nonObjectFunctionCallNode = new NonObjectFunctionCallNode(functionName);
            nonObjectFunctionCallNode.setCodePosition(getCodePosition(ctx));

            return nonObjectFunctionCallNode;
        }
    }

    @Override
    public ASTnode visitObjectFunctionCall(SpookParser.ObjectFunctionCallContext ctx) {
        String objectName = ctx.objectVariableName().getText();
        String functionName = ctx.functionName().getText();
        if (ctx.objectArgs() != null) {
            ArrayList<ObjectArgumentNode> argumentNodes = visitAllObjectArguments(ctx.objectArgs());
            ObjectFunctionCallNode objectFunctionCallNode = new ObjectFunctionCallNode(objectName, functionName, argumentNodes);
            objectFunctionCallNode.setCodePosition(getCodePosition(ctx));

            return objectFunctionCallNode;
        }
        else {
            ObjectFunctionCallNode objectFunctionCallNode = new ObjectFunctionCallNode(objectName, functionName);
            objectFunctionCallNode.setCodePosition(getCodePosition(ctx));

            return objectFunctionCallNode;
        }
    }

    private ArrayList<ObjectArgumentNode> visitAllObjectArguments(SpookParser.ObjectArgsContext ctx) {
        ArrayList<ObjectArgumentNode> objectArgumentNodes = new ArrayList<>();

        ObjectArgumentNode objectArgumentNode = (ObjectArgumentNode) visitObjectArg(ctx.objectArg());

        if (objectArgumentNode != null)
            objectArgumentNodes.add(objectArgumentNode);

        if (ctx.objectArgs() != null)
            objectArgumentNodes.addAll(visitAllObjectArguments(ctx.objectArgs()));

        return objectArgumentNodes;
    }

    @Override
    public ASTnode visitObjectArg(SpookParser.ObjectArgContext ctx) {
        if (ctx.variableName() != null) {
            ObjectArgumentNode objectArgumentNode = new ObjectArgumentNode(ctx.variableName().getText());
            objectArgumentNode.setCodePosition(getCodePosition(ctx));

            return objectArgumentNode;
        }
        else if (ctx.realNumber() != null) {
            ObjectArgumentNode objectArgumentNode = new ObjectArgumentNode(new RealNumberNode(getRealNumberValue(ctx.realNumber())));
            objectArgumentNode.setCodePosition(getCodePosition(ctx));

            return objectArgumentNode;
        }
        else if (ctx.arithOperations() != null) {
            ObjectArgumentNode objectArgumentNode = new ObjectArgumentNode(visitAllArithOperations(ctx.arithOperations()));
            objectArgumentNode.setCodePosition(getCodePosition(ctx));

            return objectArgumentNode;
        }
        else if (ctx.classProperty() != null) {
            ObjectArgumentNode objectArgumentNode = new ObjectArgumentNode((ClassPropertyNode)visitClassProperty(ctx.classProperty()));
            objectArgumentNode.setCodePosition(getCodePosition(ctx));

            return objectArgumentNode;
        }
        else
            throw new CompilerException("Invalid Object Function Call Argument", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitArithOperation(SpookParser.ArithOperationContext ctx) {
        switch (ctx.arithOperand().size()) {
            case 0:
                // operator ( operation )
                if (ctx.operator() != null && ctx.arithOperation() != null) {
                    Enums.Operator operator = getOperator(ctx.operator());
                    ArithOperationNode operationNode = (ArithOperationNode)visitArithOperation(ctx.arithOperation());

                    ArithOperationNode arithOperationNode = new ArithOperationNode(operator, operationNode);
                    arithOperationNode.setCodePosition(getCodePosition(ctx));

                    return arithOperationNode;
                }
                // ( operations )
                else if (ctx.arithOperations() != null) {
                    ArithOperationNode arithOperationNode = new ArithOperationNode(visitAllArithOperations(ctx.arithOperations()));
                    arithOperationNode.setCodePosition(getCodePosition(ctx));

                    return arithOperationNode;
                }
                else throw new CompilerException("Expected 'operator (operation)' or '(operations)'", getCodePosition(ctx));
            case 1:
                // operand operator ( operation )
                if (ctx.arithOperand(0) != null && ctx.operator() != null && ctx.arithOperation() != null) {
                    ArithOperandNode operandNode = (ArithOperandNode)visitArithOperand(ctx.arithOperand(0));
                    Enums.Operator operator = getOperator(ctx.operator());
                    ArithOperationNode operationNode = (ArithOperationNode)visitArithOperation(ctx.arithOperation());

                    ArithOperationNode arithOperationNode = new ArithOperationNode(operandNode, operator, operationNode);
                    arithOperationNode.setCodePosition(getCodePosition(ctx));

                    return arithOperationNode;
                }
                // operator operand
                else if (ctx.operator() != null && ctx.arithOperand(0) != null) {
                    Enums.Operator operator = getOperator(ctx.operator());
                    ArithOperandNode operandNode = (ArithOperandNode)visitArithOperand(ctx.arithOperand(0));

                    ArithOperationNode arithOperationNode = new ArithOperationNode(operator, operandNode);
                    arithOperationNode.setCodePosition(getCodePosition(ctx));

                    return arithOperationNode;
                }
                else throw new CompilerException("Expected 'operand operator (operation)' or 'operator operand'", getCodePosition(ctx));
            case 2:
                // operand operator operand
                if (ctx.arithOperand(0) != null && ctx.operator() != null && ctx.arithOperand(1) != null) {
                    ArithOperandNode leftOperand = (ArithOperandNode)visitArithOperand(ctx.arithOperand(0));
                    Enums.Operator operator = getOperator(ctx.operator());
                    ArithOperandNode rightOperand = (ArithOperandNode)visitArithOperand(ctx.arithOperand(1));

                    ArithOperationNode arithOperationNode = new ArithOperationNode(leftOperand, operator, rightOperand);
                    arithOperationNode.setCodePosition(getCodePosition(ctx));

                    return arithOperationNode;
                }
                else throw new CompilerException("Expected 'operand operator operand'", getCodePosition(ctx));
            default:
                throw new CompilerException("Invalid arith operation", getCodePosition(ctx));
        }
    }

    private ArrayList<ArithOperationNode> visitAllArithOperations(SpookParser.ArithOperationsContext ctx) {
        ArrayList<ArithOperationNode> arithOperationNodes = new ArrayList<>();

        ArithOperationNode arithOperationNode = (ArithOperationNode) visitArithOperation(ctx.arithOperation());

        if (arithOperationNode != null)
            arithOperationNodes.add(arithOperationNode);

        if (ctx.arithOperations() != null)
            arithOperationNodes.addAll(visitAllArithOperations(ctx.arithOperations()));

        return arithOperationNodes;
    }

    @Override
    public ASTnode visitArithOperand(SpookParser.ArithOperandContext ctx) {
        if (ctx.realNumber() != null) {
            ArithOperandNode arithOperandNode = new ArithOperandNode(new RealNumberNode(getRealNumberValue(ctx.realNumber())));
            arithOperandNode.setCodePosition(getCodePosition(ctx));

            return arithOperandNode;
        }
        else if (ctx.mathFunction() != null) {
            ArithOperandNode arithOperandNode = new ArithOperandNode((MathFunctionCallNode)visitMathFunction(ctx.mathFunction()));
            arithOperandNode.setCodePosition(getCodePosition(ctx));

            return arithOperandNode;
        }
        else if (ctx.variableName() != null) {
            ArithOperandNode arithOperandNode = new ArithOperandNode(ctx.variableName().getText());
            arithOperandNode.setCodePosition(getCodePosition(ctx));

            return arithOperandNode;
        }
        else if (ctx.UNIFORM() != null) {
            ArithOperandNode arithOperandNode = new ArithOperandNode(ctx.UNIFORM().getText());
            arithOperandNode.setCodePosition(getCodePosition(ctx));

            return arithOperandNode;
        }
        else
            throw new CompilerException("Invalid Operand", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitClassProperty(SpookParser.ClassPropertyContext ctx) {
        ClassPropertyNode classPropertyNode = new ClassPropertyNode(getClassType(ctx.classType()), ctx.variableName().getText());
        classPropertyNode.setCodePosition(getCodePosition(ctx));

        return classPropertyNode;
    }

    private float getRealNumberValue(SpookParser.RealNumberContext ctx) {
        float value;

        if (ctx.FLOAT_DIGIT() != null)
            value = Float.valueOf(ctx.FLOAT_DIGIT().getSymbol().getText());
        else if (ctx.naturalNumber() != null)
            value = getNaturalNumberValue(ctx.naturalNumber());
        else
            throw new CompilerException("Real number is not a digit or float digit", getCodePosition(ctx));

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
            throw new CompilerException("Boolean value not 'true' or 'false'");

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
            throw new CompilerException("DataType is unknown", getCodePosition(ctx));

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
            throw new CompilerException("ReturnType is unknown", getCodePosition(ctx));

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
            throw new CompilerException("ClassType is unknown", getCodePosition(ctx));

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
            throw new CompilerException("Operator is unknown", getCodePosition(ctx));

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
            throw new CompilerException("Math function is unknown", getCodePosition(ctx));

        return mathFunction;
    }

    private CodePosition getCodePosition(ParserRuleContext ctx) {
        return new CodePosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }
}
