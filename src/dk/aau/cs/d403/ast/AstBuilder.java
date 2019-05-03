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
import java.util.HashMap;

public class AstBuilder extends SpookParserBaseVisitor<ASTnode> {
    private HashMap<String, VariableDeclarationNode> variables;

    @Override
    public ASTnode visitProgram(SpookParser.ProgramContext ctx) {
        variables = new HashMap<>();

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

        //ID error
        if (!ctx.variableName().isEmpty()) {
            throw new CompilerException("Unknown declaration (check type for " + ctx.variableName(0).getText() + ")", getCodePosition(ctx));
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
            statementNodes.addAll(((BlockNode)visitStatement(statement)).getStatementNodes());
        }

        BlockNode blockNode = new BlockNode(statementNodes);
        blockNode.setCodePosition(getCodePosition(ctx));

        return blockNode;
    }

    @Override
    public ASTnode visitStatement(SpookParser.StatementContext ctx) {
        ArrayList<StatementNode> statementNodes = new ArrayList<>();

        if (ctx.declaration() != null)
            statementNodes.add((StatementNode)visitDeclaration(ctx.declaration()));
        else if (ctx.assignment() != null)
            statementNodes.add((StatementNode)visitAssignment(ctx.assignment()));
        else if (ctx.functionCall() != null)
            statementNodes.add((StatementNode)visitFunctionCall(ctx.functionCall()));
        else if (ctx.conditionalStatement() != null)
            statementNodes.add((StatementNode)visitIfElseStatement(ctx.conditionalStatement().ifElseStatement()));
        else if (ctx.iterativeStatement() != null)
            statementNodes.addAll(((BlockNode)visitForStatement(ctx.iterativeStatement().forStatement())).getStatementNodes());
        else
            throw new CompilerException("Statement is of unknown type", getCodePosition(ctx));

        return new BlockNode(statementNodes);
    }

    @Override
    public ASTnode visitDeclaration(SpookParser.DeclarationContext ctx) {
        if (ctx.variableDecl() != null) {
            VariableDeclarationNode visitedVariableDeclarationNode = (VariableDeclarationNode) visitVariableDecl(ctx.variableDecl());
            variables.put(visitedVariableDeclarationNode.getVariableName(), visitedVariableDeclarationNode);
            return visitedVariableDeclarationNode;
        }
        else if (ctx.objectDecl() != null)
            return visitObjectDecl(ctx.objectDecl());
        else
            throw new CompilerException("Declaration is of unknown type", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitVariableDecl(SpookParser.VariableDeclContext ctx) {
        if (ctx.assignment(0) != null) {
            return new VariableDeclarationNode(getDataType(ctx.dataType()), (AssignmentNode)visitAssignment(ctx.assignment(0)));
        }
        else if (ctx.variableName(0) != null) {
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
        else
            throw new CompilerException("Invalid expression in assignment", getCodePosition(ctx));
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


    public ASTnode visitArithExpression(SpookParser.ArithExpressionContext ctx) {
        return new ArithExpressionNode((LowPrecedenceNode) visitLowPrecedence(ctx.lowPrecedence()));
    }

    @Override
    public ASTnode visitVector2Expression(SpookParser.Vector2ExpressionContext ctx) {
        ArithExpressionNode float1 = (ArithExpressionNode)visitArithExpression(ctx.arithExpression(0));
        ArithExpressionNode float2 = (ArithExpressionNode)visitArithExpression(ctx.arithExpression(1));

        Vector2ExpressionNode vector2ExpressionNode = new Vector2ExpressionNode(float1, float2);
        vector2ExpressionNode.setCodePosition(getCodePosition(ctx));

        return vector2ExpressionNode;
    }

    @Override
    public ASTnode visitVector3Expression(SpookParser.Vector3ExpressionContext ctx) {
        ArithExpressionNode float1 = (ArithExpressionNode)visitArithExpression(ctx.arithExpression(0));
        ArithExpressionNode float2 = (ArithExpressionNode)visitArithExpression(ctx.arithExpression(1));
        ArithExpressionNode float3 = (ArithExpressionNode)visitArithExpression(ctx.arithExpression(2));

        Vector3ExpressionNode vector3ExpressionNode = new Vector3ExpressionNode(float1, float2, float3);
        vector3ExpressionNode.setCodePosition(getCodePosition(ctx));

        return vector3ExpressionNode;
    }

    @Override
    public ASTnode visitVector4Expression(SpookParser.Vector4ExpressionContext ctx) {
        ArithExpressionNode float1 = (ArithExpressionNode) visitArithExpression(ctx.arithExpression(0));
        ArithExpressionNode float2 = (ArithExpressionNode) visitArithExpression(ctx.arithExpression(1));
        ArithExpressionNode float3 = (ArithExpressionNode) visitArithExpression(ctx.arithExpression(2));
        ArithExpressionNode float4 = (ArithExpressionNode) visitArithExpression(ctx.arithExpression(3));

        Vector4ExpressionNode vector4ExpressionNode = new Vector4ExpressionNode(float1, float2, float3, float4);
        vector4ExpressionNode.setCodePosition(getCodePosition(ctx));

        return vector4ExpressionNode;
    }

    @Override
    public ASTnode visitBoolExpression(SpookParser.BoolExpressionContext ctx) {
        if (ctx.boolOperations() != null) {
            BoolExpressionNode boolExpressionNode = new BoolExpressionNode((BoolOperationsNode) visitBoolOperations(ctx.boolOperations()));
            boolExpressionNode.setCodePosition(getCodePosition(ctx));
            return boolExpressionNode;
        }
        else
            throw new CompilerException("Invalid Bool expression", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitBoolOperations(SpookParser.BoolOperationsContext ctx) {
        Enums.BoolOperator optionalNOT = Enums.BoolOperator.NOT;
        BoolOperationNode boolOperationNode = ((BoolOperationNode) visitBoolOperation(ctx.boolOperation()));
        ArrayList<BoolOperationExtendNode> boolOperationExtendNodes = new ArrayList<>();

        for (SpookParser.BoolOperationExtendContext boolOperationExtendContext : ctx.boolOperationExtend())
            boolOperationExtendNodes.add((BoolOperationExtendNode) visitBoolOperationExtend(boolOperationExtendContext));

        if (ctx.NOT() != null && ctx.boolOperation() != null && ctx.boolOperationExtend() != null) {
            BoolOperationsNode boolOperationsNode = new BoolOperationsNode(boolOperationNode, boolOperationExtendNodes, optionalNOT);
            boolOperationsNode.setCodePosition(getCodePosition(ctx));
            return boolOperationsNode;
        }

        else if (ctx.NOT() != null && ctx.boolOperation() != null) {
            BoolOperationsNode boolOperationsNode = new BoolOperationsNode(boolOperationNode, optionalNOT);
            boolOperationsNode.setCodePosition(getCodePosition(ctx));
            return boolOperationsNode;
        }

        else if (ctx.boolOperation() != null && ctx.boolOperationExtend() != null) {
            BoolOperationsNode boolOperationsNode = new BoolOperationsNode(boolOperationNode, boolOperationExtendNodes);
            boolOperationsNode.setCodePosition(getCodePosition(ctx));
            return boolOperationsNode;
        } else
            throw new CompilerException("Invalid Boolean operations", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitBoolOperationExtend(SpookParser.BoolOperationExtendContext ctx) {
        Enums.BoolOperator boolOperator = getBoolOperator(ctx.boolOperator());
        Enums.BoolOperator optionalNOT = Enums.BoolOperator.NOT;
        BoolOperationNode boolOperationNode = ((BoolOperationNode) visitBoolOperation(ctx.boolOperation()));

        if (ctx.boolOperation() != null && ctx.boolOperator() != null & ctx.NOT() != null) {
            BoolOperationExtendNode boolOperationExtendNode = new BoolOperationExtendNode(boolOperator, optionalNOT, boolOperationNode);
            boolOperationExtendNode.setCodePosition(getCodePosition(ctx));
            return boolOperationExtendNode;
        }
        else if (ctx.boolOperator() != null && ctx.boolOperation() != null) {
            BoolOperationExtendNode boolOperationExtendNode = new BoolOperationExtendNode(boolOperator, boolOperationNode);
            boolOperationExtendNode.setCodePosition(getCodePosition(ctx));
            return boolOperationExtendNode;
        }
        else throw new CompilerException("Invalid Boolean Operation Extension", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitBoolOperation(SpookParser.BoolOperationContext ctx) {
        if (ctx.BOOL_LITERAL() != null) {
            BoolOperationNode boolOperationNode = new BoolOperationNode(getBooleanValue(ctx.BOOL_LITERAL()));
            boolOperationNode.setCodePosition(getCodePosition(ctx));
            return boolOperationNode;
        }
        else if (ctx.boolOperations() != null) {
            BoolOperationNode boolOperationNode = new BoolOperationNode((BoolOperationsNode) visitBoolOperations(ctx.boolOperations()));
            boolOperationNode.setCodePosition(getCodePosition(ctx));
            return boolOperationNode;
        }
        else if (ctx.variableName() != null) {
            BoolOperationNode boolOperationNode = new BoolOperationNode(ctx.variableName().getText());
            boolOperationNode.setCodePosition(getCodePosition(ctx));
            return boolOperationNode;
        }
        else if (ctx.realNumber() != null) {
            BoolOperationNode boolOperationNode = new BoolOperationNode(new RealNumberNode(getRealNumberValue(ctx.realNumber())));
            boolOperationNode.setCodePosition(getCodePosition(ctx));
            return boolOperationNode;
        }
        else throw new CompilerException("Invalid Boolean operation/operand", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitClassDecl(SpookParser.ClassDeclContext ctx) {
        ClassBlockNode classBlockNode = (ClassBlockNode) visitClassBlock(ctx.classBlock());

        ClassDeclarationNode classDeclarationNode = new ClassDeclarationNode(ctx.className(0).getText(), classBlockNode);
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
        String className;

        String objectName = ctx.objectVariableName().getText();

        if (ctx.className() != null) {
            className = ctx.className().getText();
        }
        else
            throw new CompilerException("Invalid Class name for Object Declaration", getCodePosition(ctx));

        if (ctx.objectArgs() != null) {
            ArrayList<ObjectArgumentNode> objectArgumentNodes = visitAllObjectArguments(ctx.objectArgs());

            ObjectDeclarationNode objectDeclarationNode = new ObjectDeclarationNode(className, objectName, objectArgumentNodes);
            objectDeclarationNode.setCodePosition(getCodePosition(ctx));

            if (objectArgumentNodes.size() > 0)
                objectDeclarationNode = new ObjectDeclarationNode(className, objectName, objectArgumentNodes);
            else
                objectDeclarationNode = new ObjectDeclarationNode(className, objectName);

            objectDeclarationNode.setCodePosition(getCodePosition(ctx));
            return objectDeclarationNode;
        }
        else {
            ObjectDeclarationNode objectDeclarationNode = new ObjectDeclarationNode(className, objectName);
            objectDeclarationNode.setCodePosition(getCodePosition(ctx));

            objectDeclarationNode.setCodePosition(getCodePosition(ctx));
            return objectDeclarationNode;
        }
    }

    @Override
    public ASTnode visitFunctionDecl(SpookParser.FunctionDeclContext ctx) {
        Enums.DataType returnType;
        if (ctx.dataType() != null)
        {
            returnType = getDataType(ctx.dataType());
        }
        else if (ctx.VOID() != null) {
            returnType = Enums.ReturnType.VOID;
        }
        else
            throw new CompilerException("Invalid return type", getCodePosition(ctx));

        if (ctx.dataType() != null) {
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
        else if (ctx.VOID() != null) {
            if (ctx.functionArgs() != null) {
                ArrayList<FunctionArgNode> functionArgNodes = visitAllFunctionArgs(ctx.functionArgs());

                FunctionDeclarationNode functionDeclarationNode = new FunctionDeclarationNode(ctx.functionName().getText(), functionArgNodes, (BlockNode)visitBlock(ctx.block()));
                functionDeclarationNode.setCodePosition(getCodePosition(ctx));

                return functionDeclarationNode;
            }
            else {
                FunctionDeclarationNode functionDeclarationNode = new FunctionDeclarationNode(ctx.functionName().getText(), (BlockNode)visitBlock(ctx.block()));
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

        if (ctx.statement() != null) {
            for (SpookParser.StatementContext statement : ctx.statement()) {
                statementNodes.add((StatementNode) visitStatement(statement));
            }
        }

        BlockNode blockNode = new BlockNode(statementNodes, (ReturnNode) visitReturnStatement(ctx.returnStatement()));
        blockNode.setCodePosition(getCodePosition(ctx));

        return blockNode;
    }

    @Override
    public ASTnode visitReturnStatement(SpookParser.ReturnStatementContext ctx) {
        if (ctx.expression() != null) {
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
        if (ctx.functionName() != null) {
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
        else
            throw new CompilerException("Invalid function name for function call", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitObjectFunctionCall(SpookParser.ObjectFunctionCallContext ctx) {
        if (ctx.objectVariableName() != null) {
            String objectName = ctx.objectVariableName().getText();
            if (ctx.functionName() != null) {
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
            else
                throw new CompilerException("Invalid function name in function call", getCodePosition(ctx));
        }
        else
            throw new CompilerException("Invalid object variable name in function call", getCodePosition(ctx));
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
        if (ctx.lowPrecedence() != null) {
            ObjectArgumentNode objectArgumentNode = new ObjectArgumentNode((LowPrecedenceNode) visitLowPrecedence(ctx.lowPrecedence()));
            objectArgumentNode.setCodePosition(getCodePosition(ctx));

            return objectArgumentNode;
        }
        else
            throw new CompilerException("Invalid Object Function Call Argument", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitLowPrecedence(SpookParser.LowPrecedenceContext ctx) {
        ArrayList<HighPrecedenceNode> highPrecedenceNodes = new ArrayList<>();
        ArrayList<Enums.Operator> operators = new ArrayList<>();


        //High Precedence Nodes
        for (SpookParser.HighPrecedenceContext highPrecedence : ctx.highPrecedence()) {
            highPrecedenceNodes.add((HighPrecedenceNode) visitHighPrecedence(highPrecedence));
        }

        //Operators
        for (SpookParser.LowOperatorContext lowOperatorContext : ctx.lowOperator()) {
            operators.add(getOperator(lowOperatorContext));
        }

        if (highPrecedenceNodes.size() == 1) {
            LowPrecedenceNode lowPrecedenceNode = new LowPrecedenceNode(highPrecedenceNodes);
            lowPrecedenceNode.setCodePosition(getCodePosition(ctx));
            return lowPrecedenceNode;

        } else if (highPrecedenceNodes.size() > 1) {
            LowPrecedenceNode lowPrecedenceNode = new LowPrecedenceNode(highPrecedenceNodes, operators);
            lowPrecedenceNode.setCodePosition(getCodePosition(ctx));
            return lowPrecedenceNode;

        } else
            throw new CompilerException("Invalid Low Precedence", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitHighPrecedence(SpookParser.HighPrecedenceContext ctx) {
        ArrayList<AtomPrecedenceNode> atomPrecedenceNodes = new ArrayList<>();
        ArrayList<Enums.Operator> operators = new ArrayList<>();


        //Atom Precedence Nodes
        for (SpookParser.AtomPrecedenceContext atomPrecedence : ctx.atomPrecedence()) {
            atomPrecedenceNodes.add((AtomPrecedenceNode) visitAtomPrecedence(atomPrecedence));
        }

        //Operators
        for (SpookParser.HighOperatorContext highOperatorContext : ctx.highOperator()) {
            operators.add(getOperator(highOperatorContext));
        }

        if (atomPrecedenceNodes.size() == 1) {
            return new HighPrecedenceNode(atomPrecedenceNodes);
        } else {
            return new HighPrecedenceNode(atomPrecedenceNodes, operators);
        }
    }

    @Override
    public ASTnode visitAtomPrecedence(SpookParser.AtomPrecedenceContext ctx) {
        //return -operand AtomNode
        if (ctx.SUB() != null && ctx.arithOperand() != null) {
            ArithOperandNode atomOperandNode = (ArithOperandNode) visitArithOperand(ctx.arithOperand());
            atomOperandNode.setCodePosition(getCodePosition(ctx));
            return new AtomPrecedenceNode(Enums.Operator.SUB, atomOperandNode);
        }
        //return operand AtomNode
        else if (ctx.arithOperand() != null) {
            ArithOperandNode atomOperandNode = (ArithOperandNode) visitArithOperand(ctx.arithOperand());
            atomOperandNode.setCodePosition(getCodePosition(ctx));
            return new AtomPrecedenceNode(atomOperandNode);
        }
        //return (lowprecedence) AtomNode
        else if (ctx.lowPrecedence() != null) {
            LowPrecedenceNode lowPrecedenceNode = (LowPrecedenceNode) visitLowPrecedence(ctx.lowPrecedence());
            lowPrecedenceNode.setCodePosition(getCodePosition(ctx));
            return new AtomPrecedenceNode(lowPrecedenceNode);
        } else
            throw new CompilerException("Invalid AtomPrecedence Operation", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitArithOperand(SpookParser.ArithOperandContext ctx) {
        if (ctx.realNumber() != null) {
            ArithOperandNode arithOperandNode = new ArithOperandNode(new RealNumberNode(getRealNumberValue(ctx.realNumber())));
            arithOperandNode.setCodePosition(getCodePosition(ctx));

            return arithOperandNode;
        }
        else if (ctx.functionCall() != null) {
            ASTnode functionCallNode = visitFunctionCall(ctx.functionCall());
            ArithOperandNode arithOperandNode;

            if (functionCallNode instanceof NonObjectFunctionCallNode)
                arithOperandNode = new ArithOperandNode((NonObjectFunctionCallNode)functionCallNode);
            else
                arithOperandNode = new ArithOperandNode((ObjectFunctionCallNode)functionCallNode);

            arithOperandNode.setCodePosition(getCodePosition(ctx));

            return arithOperandNode;
        }
        else if (ctx.variableName() != null) {
            ArithOperandNode arithOperandNode = new ArithOperandNode(ctx.variableName().getText());
            arithOperandNode.setCodePosition(getCodePosition(ctx));

            return arithOperandNode;
        }
        else if (ctx.swizzle() != null) {
            ASTnode swizzleNode = visitSwizzle(ctx.swizzle());
            ArithOperandNode arithOperandNode = new ArithOperandNode((SwizzleNode) swizzleNode);

            arithOperandNode.setCodePosition(getCodePosition(ctx));

            return arithOperandNode;
        }

        else
            throw new CompilerException("Invalid Operand", getCodePosition(ctx));
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
        ArrayList<ElseIfStatementNode> elseIfStatementNode = new ArrayList<>();
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
        ArrayList<StatementNode> forLoopStatementNodes = new ArrayList<>();

        BlockNode blockNode;
        StatementNode statementNode;

        ForLoopExpressionNode expressionNode1 = (ForLoopExpressionNode) visitForLoopExpression(ctx.forLoopExpression(0));
        ForLoopExpressionNode expressionNode2 = (ForLoopExpressionNode) visitForLoopExpression(ctx.forLoopExpression(1));

        float expr1 = evaluateForLoopExpression(expressionNode1);
        float expr2 = evaluateForLoopExpression(expressionNode2);

        boolean countDown = false;
        if (expr1 > expr2)
            countDown = true;

        while (countDown ? expr1 >= expr2 : expr1 <= expr2) {

            ForLoopExpressionNode fixedExpressionNode1 = expressionNode1;

            ArrayList<AtomPrecedenceNode> atomPrecedenceNodes = new ArrayList<>();
            atomPrecedenceNodes.add(new AtomPrecedenceNode(new ArithOperandNode(new RealNumberNode(expr1))));

            ArrayList<HighPrecedenceNode> highPrecedenceNodes = new ArrayList<>();
            highPrecedenceNodes.add(new HighPrecedenceNode(atomPrecedenceNodes));

            ArithExpressionNode fixedExpressionNode = new ArithExpressionNode(new LowPrecedenceNode(highPrecedenceNodes));

            if (expressionNode1.getIntegerNumberNode() != null) {
                fixedExpressionNode1 = new ForLoopExpressionNode(new IntegerNumberNode((int)expr1));
            }
            else if (expressionNode1.getVariableDeclarationNode() != null) {
                if (expressionNode1.getVariableDeclarationNode().getAssignmentNode() != null) {
                    AssignmentNode assignmentNode = expressionNode1.getVariableDeclarationNode().getAssignmentNode();
                    fixedExpressionNode1 = new ForLoopExpressionNode(new VariableDeclarationNode(
                        expressionNode1.getVariableDeclarationNode().getDataType(),
                        new AssignmentNode(assignmentNode.getVariableName(), fixedExpressionNode)
                    ));
                }
            }
            else if (expressionNode1.getAssignmentNode() != null) {
                AssignmentNode assignmentNode = expressionNode1.getAssignmentNode();
                fixedExpressionNode1 = new ForLoopExpressionNode(new AssignmentNode(
                        assignmentNode.getVariableName(), fixedExpressionNode
                ));
            }

            ForLoopExpressionNode fixedExpressionNode2 = new ForLoopExpressionNode(new IntegerNumberNode((int)expr1));

            if (ctx.statement() != null) {
                statementNode = (StatementNode) visitStatement(ctx.statement());
                forLoopStatementNodes.add(new ForLoopStatementNode(fixedExpressionNode1, fixedExpressionNode2, statementNode));
            }
            else if (ctx.block() != null) {
                blockNode = (BlockNode) visitBlock(ctx.block());
                forLoopStatementNodes.add(new ForLoopStatementNode(fixedExpressionNode1, fixedExpressionNode2, blockNode));
            }
            else
                throw new CompilerException("Invalid ForLoopStatement", getCodePosition(ctx));

            if (countDown)
                expr1--;
            else
                expr1++;
        }

        return new BlockNode(forLoopStatementNodes);
    }

    @Override
    public ASTnode visitForLoopExpression(SpookParser.ForLoopExpressionContext ctx) {
        if (ctx.assignment() != null)
            return new ForLoopExpressionNode((AssignmentNode) visitAssignment(ctx.assignment()));
        else if (ctx.DIGIT() != null)
            return new ForLoopExpressionNode(new IntegerNumberNode(Integer.valueOf(ctx.DIGIT().getSymbol().getText())));
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

        if (ctx.NUM() != null)
            dataType = Enums.DataType.NUM;
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

    private Enums.Operator getOperator(SpookParser.HighOperatorContext ctx) {
        Enums.Operator operator;

        if (ctx.MOD() != null)
            operator = Enums.Operator.MOD;
        else if (ctx.DIV() != null)
            operator = Enums.Operator.DIV;
        else if (ctx.MUL() != null)
            operator = Enums.Operator.MUL;
        else
            throw new CompilerException("Operator is unknown", getCodePosition(ctx));

        return operator;
    }

    private Enums.Operator getOperator(SpookParser.LowOperatorContext ctx) {
        Enums.Operator operator;

        if (ctx.ADD() != null)
            operator = Enums.Operator.ADD;
        else if (ctx.SUB() != null)
            operator = Enums.Operator.SUB;
        else
            throw new CompilerException("Operator is unknown", getCodePosition(ctx));

        return operator;
    }

    private Enums.BoolOperator getBoolOperator (SpookParser.BoolOperatorContext ctx) {
        Enums.BoolOperator boolOperator;

        if (ctx.AND() != null)
            boolOperator = Enums.BoolOperator.AND;
        else if (ctx.EQUAL() != null)
            boolOperator = Enums.BoolOperator.EQUAL;
        else if (ctx.GREATER_OR_EQUAL() != null)
            boolOperator = Enums.BoolOperator.GREATER_OR_EQUAL;
        else if (ctx.GREATER_THAN() != null)
            boolOperator = Enums.BoolOperator.GREATER_THAN;
        else if (ctx.LESS_OR_EQUAL() != null)
            boolOperator = Enums.BoolOperator.LESS_OR_EQUAL;
        else if (ctx.LESS_THAN() != null)
            boolOperator = Enums.BoolOperator.LESS_THAN;
        else if (ctx.NOT_EQUAL() != null)
            boolOperator = Enums.BoolOperator.NOT_EQUAL;
        else if (ctx.OR() != null)
            boolOperator = Enums.BoolOperator.OR;
        else throw new CompilerException("Boolean operator is unknown", getCodePosition(ctx));
        return boolOperator;
    }

    private CodePosition getCodePosition(ParserRuleContext ctx) {
        return new CodePosition(ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    // FOR LOOP EVALUATION

    private float evaluateForLoopExpression(ForLoopExpressionNode expressionNode) {
        if (expressionNode.getAssignmentNode() != null)
            return evaluateAssignment(expressionNode.getAssignmentNode());
        else if (expressionNode.getIntegerNumberNode() != null)
            return expressionNode.getIntegerNumberNode().getNumber();
        else if (expressionNode.getVariableDeclarationNode() != null)
            return evaluateVariableDeclaration(expressionNode.getVariableDeclarationNode());
        else if (expressionNode.getVariableName() != null)
            return evaluateVariable(expressionNode.getVariableName());
        else
            throw new CompilerException("Invalid for loop expression", expressionNode.getCodePosition());
    }

    private float evaluateVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
        if (variableDeclarationNode.getDataType() == Enums.DataType.NUM) {
            AssignmentNode assignmentNode = variableDeclarationNode.getAssignmentNode();

            if (assignmentNode != null)
                return evaluateAssignment(variableDeclarationNode.getAssignmentNode());
            else
                return evaluateVariable(variableDeclarationNode.getVariableName());
        }
        else
            throw new CompilerException("For loop variable is not Num", variableDeclarationNode.getCodePosition());
    }

    private float evaluateAssignment(AssignmentNode assignmentNode) {
        if (assignmentNode.getSwizzleNode() != null)
            throw new CompilerException("This assignment node probably shouldn't have a swizzle node", assignmentNode.getCodePosition());

        return evaluateExpression(assignmentNode.getExpressionNode());
    }

    private float evaluateVariable(String variableName) {
        VariableDeclarationNode variableDeclarationNode = variables.get(variableName);
        if (variableDeclarationNode != null)
            return evaluateVariableDeclaration(variableDeclarationNode);
        else
            throw new RuntimeException("Variable " + variableName + " not found");
    }

    private float evaluateExpression(ExpressionNode expressionNode) {
        if (expressionNode instanceof ArithExpressionNode) {
            ArithExpressionNode arithExpressionNode = (ArithExpressionNode)expressionNode;
            return evaluateLowPrecedence(arithExpressionNode.getLowPrecedenceNode());
        }
        else
            throw new CompilerException("For loop expression is not arith expression", expressionNode.getCodePosition());
    }

    private float evaluateLowPrecedence(LowPrecedenceNode lowPrecedenceNode) {
        float result = evaluateHighPrecedence(lowPrecedenceNode.getHighPrecedenceNodes().get(0));

        if (lowPrecedenceNode.getOperators() != null) {
            int operatorAmt = lowPrecedenceNode.getOperators().size();
            for (int i = 0; i < operatorAmt; i++) {
                float operand = evaluateHighPrecedence(lowPrecedenceNode.getHighPrecedenceNodes().get(i+1));
                result = evaluateOperation(lowPrecedenceNode.getOperators().get(i), result, operand);
            }
        }

        return result;
    }

    private float evaluateHighPrecedence(HighPrecedenceNode highPrecedenceNode) {
        float result = evaluateAtomPrecedence(highPrecedenceNode.getAtomPrecedenceNodes().get(0));

        if (highPrecedenceNode.getOperators() != null) {
            int operatorAmt = highPrecedenceNode.getOperators().size();
            for (int i = 0; i < operatorAmt; i++) {
                float operand = evaluateAtomPrecedence(highPrecedenceNode.getAtomPrecedenceNodes().get(i+1));
                result = evaluateOperation(highPrecedenceNode.getOperators().get(i), result, operand);
            }
        }

        return result;
    }

    private float evaluateAtomPrecedence(AtomPrecedenceNode atomPrecedenceNode) {
        if (atomPrecedenceNode.getLowPrecedenceNode() != null)
            return evaluateLowPrecedence(atomPrecedenceNode.getLowPrecedenceNode());
        else if (atomPrecedenceNode.getOperator() != null) {
            if (atomPrecedenceNode.getOperator() == Enums.Operator.SUB)
                return 0 - evaluateArithOperand(atomPrecedenceNode.getOperand());
            else if (atomPrecedenceNode.getOperator() == Enums.Operator.ADD)
                return evaluateArithOperand(atomPrecedenceNode.getOperand());
            else
                throw new CompilerException(atomPrecedenceNode.getOperator().toString() + " before single operand is illegal", atomPrecedenceNode.getCodePosition());
        }
        else
            return evaluateArithOperand(atomPrecedenceNode.getOperand());
    }

    private float evaluateArithOperand(ArithOperandNode arithOperandNode) {
        RealNumberNode realNumberNode = arithOperandNode.getRealNumberNode();
        NonObjectFunctionCallNode nonObjectFunctionCallNode = arithOperandNode.getNonObjectFunctionCallNode();
        ObjectFunctionCallNode objectFunctionCallNode = arithOperandNode.getObjectFunctionCallNode();
        String variableName = arithOperandNode.getVariableName();
        SwizzleNode swizzleNode = arithOperandNode.getSwizzleNode();

        if (realNumberNode != null) {
            return realNumberNode.getNumber();
        }
        else if (nonObjectFunctionCallNode != null) {
            throw new CompilerException("Evaluation not yet implemented", arithOperandNode.getCodePosition());
        }
        else if (objectFunctionCallNode != null) {
            throw new CompilerException("Evaluation not yet implemented", arithOperandNode.getCodePosition());
        }
        else if (variableName != null) {
            return evaluateVariable(variableName);
        }
        else if (swizzleNode != null) {
            return evaluateSwizzle(swizzleNode);
        }
        else
            throw new CompilerException("Invalid Arith Operand", arithOperandNode.getCodePosition());
    }

    private float evaluateOperation(Enums.Operator operator, float left, float right) {
        switch (operator) {
            case ADD:
                return left + right;
            case SUB:
                return left - right;
            case MOD:
                return left % right;
            case DIV:
                return left / right;
            case MUL:
                return left * right;
            default:
                throw new RuntimeException("Invalid operation");
        }
    }

    private float evaluateSwizzle(SwizzleNode swizzleNode) {
        String swizzle;
        if (swizzleNode.getCoordinateSwizzle() != null) {
            swizzle = swizzleNode.getCoordinateSwizzle().getSwizzle();
        }
        else if (swizzleNode.getColorSwizzle() != null) {
            swizzle = swizzleNode.getColorSwizzle().getSwizzle();
        }
        else {
            throw new CompilerException("Invalid swizzle", swizzleNode.getCodePosition());
        }

        if (swizzle.length() == 1) {
            throw new CompilerException("Swizzle not yet implemented", swizzleNode.getCodePosition());
        }
        else
            throw new CompilerException("Swizzle does not result in Num", swizzleNode.getCodePosition());
    }
}
