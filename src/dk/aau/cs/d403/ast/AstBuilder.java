package dk.aau.cs.d403.ast;

import dk.aau.cs.d403.CompilerException;
import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.ast.statements.*;
import dk.aau.cs.d403.ast.structure.*;
import dk.aau.cs.d403.parser.SpookParser;
import dk.aau.cs.d403.parser.SpookParserBaseVisitor;
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

        for (SpookParser.StatementContext statement: ctx.statement()) {
            statementNodes.add((StatementNode) visitStatement(statement));
        }

        BlockNode blockNode = new BlockNode(statementNodes);
        blockNode.setCodePosition(getCodePosition(ctx));

        return blockNode;
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
            return visitIfElseStatement(ctx.conditionalStatement().ifElseStatement());
        else if (ctx.iterativeStatement() != null)
            return visitForStatement(ctx.iterativeStatement().forStatement());
        else {
            throw new CompilerException("Statement is of unknown type", getCodePosition(ctx));
        }
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
            return new VariableDeclarationNode(getDataType(ctx.dataType()), (AssignmentNode)visitAssignment(ctx.assignment(0)));
        }
        else if (ctx.variableName() != null) {
            return new VariableDeclarationNode(getDataType(ctx.dataType()), ctx.variableName(0).getText());
        }
        else {
            throw new CompilerException("Expected variable name or assignment in declaration", getCodePosition(ctx));
        }
    }

    @Override
    public ASTnode visitAssignment(SpookParser.AssignmentContext ctx) {
        ExpressionNode expressionNode;

        if (ctx.expression() != null) {
            expressionNode = (ExpressionNode)visitExpression(ctx.expression());
        }
        else
            throw new CompilerException("Invalid expression in assignment", getCodePosition(ctx));

        if (ctx.swizzle() != null) {
            AssignmentNode assignmentNode = new AssignmentNode((SwizzleNode) visitSwizzle(ctx.swizzle()), expressionNode);
            assignmentNode.setCodePosition(getCodePosition(ctx));
            return assignmentNode;
        }
        else if (ctx.variableName() != null) {
            AssignmentNode assignmentNode = new AssignmentNode(ctx.variableName().getText(), expressionNode);
            assignmentNode.setCodePosition(getCodePosition(ctx));
            return assignmentNode;
        }
        else
            throw new CompilerException("Expected variable name or swizzle in assignment", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitSwizzle(SpookParser.SwizzleContext ctx) {
        if (ctx.variableName() != null) {
            String variableName = ctx.variableName().getText();
            if (ctx.colorSwizzle() != null) {
                return new SwizzleNode(variableName, new ColorSwizzleNode(ctx.colorSwizzle().getText()));
            }
            else if (ctx.coordinateSwizzle() != null) {
                return new SwizzleNode(variableName, new CoordinateSwizzleNode(ctx.coordinateSwizzle().getText()));
            }
            else
                throw new CompilerException("Expected Color- or Coordinate swizzle", getCodePosition(ctx));
        }
        else
            throw new CompilerException("Expected variable name for swizzle", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitExpression(SpookParser.ExpressionContext ctx) {
        if (ctx.arithExpression() != null)
            return visitArithExpression(ctx.arithExpression());
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
        else if (ctx.functionCall() != null)
            return visitFunctionCall(ctx.functionCall());
        else
            throw new CompilerException("Invalid expression", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitArithExpression(SpookParser.ArithExpressionContext ctx) {

        return new ArithExpressionNode((LowPrecedenceNode) visitLowPrecedence(ctx.lowPrecedence()));
    }

    @Override
    public ASTnode visitVector2Expression(SpookParser.Vector2ExpressionContext ctx) {
        FloatExpressionNode float1 = (FloatExpressionNode)visitArithExpression(ctx.arithExpression(0));
        FloatExpressionNode float2 = (FloatExpressionNode)visitArithExpression(ctx.arithExpression(1));

        Vector2ExpressionNode vector2ExpressionNode = new Vector2ExpressionNode(float1, float2);
        vector2ExpressionNode.setCodePosition(getCodePosition(ctx));

        return vector2ExpressionNode;
    }

    @Override
    public ASTnode visitVector3Expression(SpookParser.Vector3ExpressionContext ctx) {
        FloatExpressionNode float1 = (FloatExpressionNode)visitArithExpression(ctx.arithExpression(0));
        FloatExpressionNode float2 = (FloatExpressionNode)visitArithExpression(ctx.arithExpression(1));
        FloatExpressionNode float3 = (FloatExpressionNode)visitArithExpression(ctx.arithExpression(2));

        Vector3ExpressionNode vector3ExpressionNode = new Vector3ExpressionNode(float1, float2, float3);
        vector3ExpressionNode.setCodePosition(getCodePosition(ctx));

        return vector3ExpressionNode;
    }

    @Override
    public ASTnode visitVector4Expression(SpookParser.Vector4ExpressionContext ctx) {
        FloatExpressionNode float1 = (FloatExpressionNode)visitArithExpression(ctx.arithExpression(0));
        FloatExpressionNode float2 = (FloatExpressionNode)visitArithExpression(ctx.arithExpression(1));
        FloatExpressionNode float3 = (FloatExpressionNode)visitArithExpression(ctx.arithExpression(2));
        FloatExpressionNode float4 = (FloatExpressionNode)visitArithExpression(ctx.arithExpression(3));

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
            BoolExpressionNode boolExpressionNode = new BoolExpressionNode(new ArrayList<>());
            boolExpressionNode.setCodePosition(getCodePosition(ctx));

            return boolExpressionNode;
        }
        else
            throw new CompilerException("Invalid Bool expression", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitMathFunction(SpookParser.MathFunctionContext ctx) {
        if (ctx.function() != null) {
            Enums.MathFunctionName functionName = getMathFunction(ctx.function());
            if (ctx.lowPrecedence() != null) {
                MathFunctionCallNode mathFunctionCallNode = new MathFunctionCallNode(functionName, (LowPrecedenceNode) visitLowPrecedence(ctx.lowPrecedence()));
                mathFunctionCallNode.setCodePosition(getCodePosition(ctx));

                return mathFunctionCallNode;
            }
            else
                throw new CompilerException("Invalid expression in math function", getCodePosition(ctx));
        }
        else
            throw new CompilerException("Invalid math function name", getCodePosition(ctx));
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
        for (SpookParser.DeclarationContext declaration: ctx.declaration()) {
            declarationNodes.add((DeclarationNode) visitDeclaration(declaration));
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
            ArrayList<ObjectArgumentNode> objectArgumentNodes = visitAllObjectArguments(ctx.objectArgs());

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

        if (getReturnType(ctx.returnType()) != Enums.ReturnType.VOID) {
            if (ctx.functionArgs() != null) {
                ArrayList<FunctionArgNode> functionArgNodes = visitAllFunctionArgs(ctx.functionArgs());

                FunctionDeclarationNode functionDeclarationNode = new FunctionDeclarationNode(returnType, ctx.functionName().getText(), functionArgNodes, (BlockNode)visitFunctionBlock(ctx.functionBlock()));
                functionDeclarationNode.setCodePosition(getCodePosition(ctx));

                return functionDeclarationNode;
            }
            else {
                FunctionDeclarationNode functionDeclarationNode = new FunctionDeclarationNode(returnType, ctx.functionName().getText(), (BlockNode)visitFunctionBlock(ctx.functionBlock()));
                functionDeclarationNode.setCodePosition(getCodePosition(ctx));

                return functionDeclarationNode;
            }
        }
        else if (getReturnType(ctx.returnType()) == Enums.ReturnType.VOID) {
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
        else {
            throw new CompilerException("Invalid function declaration", getCodePosition(ctx));
        }
    }

    @Override
    public ASTnode visitFunctionBlock(SpookParser.FunctionBlockContext ctx) {
        ArrayList<StatementNode> statementNodes = new ArrayList<>();

        for (SpookParser.StatementContext statement: ctx.statement()) {
            statementNodes.add((StatementNode) visitStatement(statement));
        }

        BlockNode blockNode = new BlockNode(statementNodes, (ReturnNode) visitReturnStatement(ctx.returnStatement()));
        blockNode.setCodePosition(getCodePosition(ctx));

        return blockNode;
    }

    @Override
    public ASTnode visitReturnStatement(SpookParser.ReturnStatementContext ctx) {
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
        else if (ctx.expression() != null) {
            ReturnNode returnNode = new ReturnNode((ExpressionNode) visitExpression(ctx.expression()));
            returnNode.setCodePosition(getCodePosition(ctx));
            return returnNode;
        }
        else
            throw new CompilerException("Invalid return statement", getCodePosition(ctx));
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
        if (ctx.functionCall().nonObjectFunctionCall() != null) {
            ObjectArgumentNode objectArgumentNode = new ObjectArgumentNode((NonObjectFunctionCallNode) visitNonObjectFunctionCall(ctx.functionCall().nonObjectFunctionCall()));
            objectArgumentNode.setCodePosition(getCodePosition(ctx));

            return objectArgumentNode;
        }
        else if (ctx.functionCall().objectFunctionCall() != null) {
            ObjectArgumentNode objectArgumentNode = new ObjectArgumentNode((ObjectFunctionCallNode) visitObjectFunctionCall(ctx.functionCall().objectFunctionCall()));
            objectArgumentNode.setCodePosition(getCodePosition(ctx));

            return objectArgumentNode;
        }
        else if (ctx.lowPrecedence() != null) {
            ObjectArgumentNode objectArgumentNode = new ObjectArgumentNode((LowPrecedenceNode) visitLowPrecedence(ctx.lowPrecedence()));
            objectArgumentNode.setCodePosition(getCodePosition(ctx));

            return objectArgumentNode;
        }
        else if (ctx.colorFunctionCall() != null) {
            ObjectArgumentNode objectArgumentNode = new ObjectArgumentNode((ColorFunctionCallNode) visitColorFunctionCall(ctx.colorFunctionCall()));
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
    public ASTnode visitColorFunctionCall(SpookParser.ColorFunctionCallContext ctx) {
        Enums.ColorName colorName;

        if (ctx.predefinedFunctionName() != null)
            colorName = getColorName(ctx.predefinedFunctionName());
        else
            throw new CompilerException("Invalid class property", getCodePosition(ctx));

        ColorFunctionCallNode colorFunctionCallNode = new ColorFunctionCallNode(colorName);
        colorFunctionCallNode.setCodePosition(getCodePosition(ctx));

        return colorFunctionCallNode;
    }

    @Override
    public ASTnode visitTernaryOperator(SpookParser.TernaryOperatorContext ctx) {
        BoolExpressionNode boolExpression;
        ExpressionNode expression1;
        ExpressionNode expression2;

        if (ctx.boolExpression() != null) {
            boolExpression = (BoolExpressionNode) visitBoolExpression(ctx.boolExpression());

            if (ctx.expression(0) != null)
                expression1 = (ExpressionNode) visitExpression(ctx.expression(0));
            else
                throw new CompilerException("Invalid first expression for Ternary operator", getCodePosition(ctx));

            if (ctx.expression(1) != null)
                expression2 = (ExpressionNode) visitExpression(ctx.expression(1));
            else
                throw new CompilerException("Invalid second expression for Ternary operator", getCodePosition(ctx));
        }
        else
            throw new CompilerException("Invalid Boolean expression in Ternary operator", getCodePosition(ctx));

        return new TernaryOperatorNode(boolExpression, expression1, expression2);
    }

    @Override
    public ASTnode visitIfElseStatement(SpookParser.IfElseStatementContext ctx) {
        IfStatementNode ifStatementNode = (IfStatementNode) visitIfStatement(ctx.ifStatement());
        ArrayList<ElseIfStatementNode> elseIfStatementNode = null;
        ElseStatementNode elseStatementNode = null;

        if (ctx.elseIfStatement() != null) {
            for (SpookParser.ElseIfStatementContext elseIfStatement : ctx.elseIfStatement()) {
                elseIfStatementNode.add((ElseIfStatementNode) visitElseIfStatement(elseIfStatement));
            }
        }
        if (ctx.elseStatement() != null) {
            elseStatementNode = (ElseStatementNode) visitElseStatement(ctx.elseStatement());
        }

        return new IfElseStatementNode(ifStatementNode, elseIfStatementNode, elseStatementNode);
    }

    @Override
    public ASTnode visitIfStatement(SpookParser.IfStatementContext ctx) {
        BoolExpressionNode ifBool;
        BlockNode ifBlock;
        StatementNode ifStatement;

        if (ctx.ifBoolExpression() != null) {
            ifBool = (BoolExpressionNode) visitBoolExpression(ctx.ifBoolExpression().boolExpression());
            if (ctx.ifBlock().conditionalBlock().block() != null) {
                ifBlock = (BlockNode) visitBlock(ctx.ifBlock().conditionalBlock().block());
                return new IfStatementNode(ifBool, ifBlock);
            }
            else if (ctx.ifBlock().conditionalBlock().statement() != null) {
                ifStatement = (StatementNode) visitStatement(ctx.ifBlock().conditionalBlock().statement());
                return new IfStatementNode(ifBool, ifStatement);
            }
            else
                throw new CompilerException("Invalid If-Block or If-Statement", getCodePosition(ctx));
        }
        else
            throw new CompilerException("Invalid If-Boolean expression", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitElseIfStatement(SpookParser.ElseIfStatementContext ctx) {
        BoolExpressionNode elseIfBool;
        BlockNode elseIfBlock;
        StatementNode elseIfStatement;

        if (ctx.elseifBoolExpression() != null) {
            elseIfBool = (BoolExpressionNode) visitBoolExpression(ctx.elseifBoolExpression().boolExpression());
            if (ctx.elseIfBlock().conditionalBlock().block() != null) {
                elseIfBlock = (BlockNode) visitBlock(ctx.elseIfBlock().conditionalBlock().block());
                return new ElseIfStatementNode(elseIfBool, elseIfBlock);
            }
            else if (ctx.elseIfBlock().conditionalBlock().statement() != null) {
                elseIfStatement = (StatementNode) visitStatement(ctx.elseIfBlock().conditionalBlock().statement());
                return new ElseIfStatementNode(elseIfBool, elseIfStatement);
            }
            else
                throw new CompilerException("Invalid ElseIf-Block or ElseIf-Statement", getCodePosition(ctx));
        }
        else
            throw new CompilerException("Invalid ElseIf-Boolean expression", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitElseStatement(SpookParser.ElseStatementContext ctx) {
        BlockNode elseBlock;
        StatementNode elseStatement;

        if (ctx.elseBlock().conditionalBlock().block() != null) {
            elseBlock = (BlockNode) visitBlock(ctx.elseBlock().conditionalBlock().block());
            return new ElseStatementNode(elseBlock);
        }
        else if (ctx.elseBlock().conditionalBlock().statement() != null) {
            elseStatement = (StatementNode) visitStatement(ctx.elseBlock().conditionalBlock().statement());
            return new ElseStatementNode(elseStatement);
        }
        else
            throw new CompilerException("Invalid Else-Block or Else-Statement", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitForStatement(SpookParser.ForStatementContext ctx) {
        BlockNode blockNode;
        StatementNode statementNode;

        ForLoopExpressionNode forLoopExpressionNode1 = (ForLoopExpressionNode) visitForLoopExpression(ctx.forLoopExpression(0));
        ForLoopExpressionNode forLoopExpressionNode2 = (ForLoopExpressionNode) visitForLoopExpression(ctx.forLoopExpression(1));

        if (ctx.statement() != null) {
            statementNode = (StatementNode) visitStatement(ctx.statement());
            return new ForLoopStatementNode(forLoopExpressionNode1, forLoopExpressionNode2, statementNode);
        }
        else if (ctx.block() != null) {
            blockNode = (BlockNode) visitBlock(ctx.block());
            return new ForLoopStatementNode(forLoopExpressionNode1, forLoopExpressionNode2, blockNode);
        }
        else
            throw new CompilerException("Invalid ForLoop Statement", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitForLoopExpression(SpookParser.ForLoopExpressionContext ctx) {
        if (ctx.assignment() != null)
            return new ForLoopExpressionNode((AssignmentNode) visitAssignment(ctx.assignment()));
        else if (ctx.DIGIT() != null)
            return new ForLoopExpressionNode(Integer.valueOf(ctx.DIGIT().getSymbol().getText()));
        else if (ctx.variableName() != null)
            return new ForLoopExpressionNode(ctx.variableName().getText());
        else if (ctx.variableDecl() != null)
            return new ForLoopExpressionNode((VariableDeclarationNode) visitVariableDecl(ctx.variableDecl()));
        else
            throw new CompilerException("Invalid ForLoop expression", getCodePosition(ctx));
    }

    private float getRealNumberValue(SpookParser.RealNumberContext ctx) {
        float value;

        if (ctx.FLOAT_DIGIT() != null)
            value = Float.valueOf(ctx.FLOAT_DIGIT().getSymbol().getText());
        else if (ctx.integerNumber() != null)
            value = getIntegerNumberValue(ctx.integerNumber());
        else
            throw new CompilerException("Real number is not a digit or float digit", getCodePosition(ctx));

        return value;
    }

    private int getIntegerNumberValue(SpookParser.IntegerNumberContext ctx) {
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

    private Enums.ColorName getColorName(SpookParser.PredefinedFunctionNameContext ctx) {
        Enums.ColorName colorName;

        if (ctx.colorName().BLACK() != null)
            colorName = Enums.ColorName.BLACK;
        else if (ctx.colorName().BLUE() != null)
            colorName = Enums.ColorName.BLUE;
        else if (ctx.colorName().RED() != null)
            colorName = Enums.ColorName.RED;
        else if (ctx.colorName().GREEN() != null)
            colorName = Enums.ColorName.GREEN;
        else if (ctx.colorName().WHITE() != null)
            colorName = Enums.ColorName.WHITE;
        else
            throw new CompilerException("Color is unknown", getCodePosition(ctx));

        return colorName;
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
