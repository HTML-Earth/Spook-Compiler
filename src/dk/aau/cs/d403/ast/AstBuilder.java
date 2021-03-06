package dk.aau.cs.d403.ast;

import dk.aau.cs.d403.errorhandling.CompilerException;
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
    public ProgramNode visitProgram(SpookParser.ProgramContext ctx) {
        //Main shader function
        MainNode mainNode = visitMain(ctx.main());
        ArrayList<ClassDeclarationNode> classDeclarationNodes = new ArrayList<>();
        ArrayList<FunctionDeclarationNode> functionDeclarationNodes = new ArrayList<>();

        //Class declarations
        for (SpookParser.ClassDeclContext classDecl : ctx.classDecl()) {
            classDeclarationNodes.add(visitClassDecl(classDecl));
        }

        //Function declarations
        for (SpookParser.FunctionDeclContext functionDecl : ctx.functionDecl()) {
            functionDeclarationNodes.add(visitFunctionDecl(functionDecl));
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
    public MainNode visitMain(SpookParser.MainContext ctx) {
        BlockNode blockNode = visitBlock(ctx.block());

        MainNode mainNode = new MainNode(blockNode);
        mainNode.setCodePosition(getCodePosition(ctx));

        return mainNode;
    }

    @Override
    public BlockNode visitBlock(SpookParser.BlockContext ctx) {
        ArrayList<StatementNode> statementNodes = new ArrayList<>();

        for (SpookParser.StatementContext statement: ctx.statement()) {
            statementNodes.add(visitStatement(statement));
        }

        BlockNode blockNode = new BlockNode(statementNodes);
        blockNode.setCodePosition(getCodePosition(ctx));

        return blockNode;
    }

    //RETURNS A BLOCK NODE WITH A STATEMENT LIST
    @Override
    public StatementNode visitStatement(SpookParser.StatementContext ctx) {

        if (ctx.declaration() != null)
            return visitDeclaration(ctx.declaration());
        else if (ctx.assignment() != null)
            return visitAssignment(ctx.assignment());
        else if (ctx.functionCall() != null)
            return (StatementNode)visitFunctionCall(ctx.functionCall());
        else if (ctx.conditionalStatement() != null)
            return visitIfElseStatement(ctx.conditionalStatement().ifElseStatement());
        else if (ctx.iterativeStatement() != null)
            return visitForStatement(ctx.iterativeStatement().forStatement());
        else if (ctx.returnStatement() != null)
            return visitReturnStatement(ctx.returnStatement());
        else
            throw new CompilerException("Statement is of unknown type", getCodePosition(ctx));
    }

    @Override
    public DeclarationNode visitDeclaration(SpookParser.DeclarationContext ctx) {
        if (ctx.variableDecl() != null) {
            return visitVariableDecl(ctx.variableDecl());
        }
        else if (ctx.objectDecl() != null) {

            return visitObjectDecl(ctx.objectDecl());
        }
        else
            throw new CompilerException("Declaration is of unknown type", getCodePosition(ctx));
    }

    @Override
    public VariableDeclarationNode visitVariableDecl(SpookParser.VariableDeclContext ctx) {
        ArrayList<VarDeclInitNode> varDeclInitNodes = new ArrayList<>();

        for (SpookParser.VariableDeclInitContext variableDeclInit : ctx.variableDeclInit()) {
            varDeclInitNodes.add(visitVariableDeclInit(variableDeclInit, getDataType(ctx.dataType())));
        }

        VariableDeclarationNode variableDeclarationNode = new VariableDeclarationNode(getDataType(ctx.dataType()), varDeclInitNodes);
        variableDeclarationNode.setCodePosition(getCodePosition(ctx));
        return variableDeclarationNode;
    }

    private VarDeclInitNode visitVariableDeclInit(SpookParser.VariableDeclInitContext ctx, Enums.DataType dataType) {
        if (ctx.assignment() != null) {
            AssignmentNode assignmentNode = visitAssignment(ctx.assignment());
            VarDeclInitNode varDeclInitNode = new VarDeclInitNode(assignmentNode);
            varDeclInitNode.setCodePosition(getCodePosition(ctx));
            return varDeclInitNode;
        }
        //Given only name -> initialize to 0, false or null as GLSL does
        else if (ctx.variableName() != null) {
            VarDeclInitNode varDeclInitNode;
            if (dataType == Enums.DataType.NUM) {
                ArithExpressionNode arithExpressionNode = new ArithExpressionNode(new LowPrecedenceNode(0));
                varDeclInitNode = new VarDeclInitNode(ctx.variableName().getText(), arithExpressionNode);
                varDeclInitNode.setCodePosition(getCodePosition(ctx));
                return varDeclInitNode;
            }
            else if (dataType == Enums.DataType.BOOL) {
                BoolExpressionNode boolExpressionNode = new BoolExpressionNode(new BoolOperationsNode(new BoolOperationNode(false)));
                varDeclInitNode = new VarDeclInitNode(ctx.variableName().getText(), boolExpressionNode);
                varDeclInitNode.setCodePosition(getCodePosition(ctx));
                return varDeclInitNode;
            }
            else if (dataType == Enums.DataType.VEC2) {
                ArithExpressionNode zeroNode = new ArithExpressionNode(new LowPrecedenceNode(0));
                Vector2ExpressionNode vector2ExpressionNode = new Vector2ExpressionNode(zeroNode, zeroNode);
                varDeclInitNode = new VarDeclInitNode(ctx.variableName().getText(), vector2ExpressionNode);
                varDeclInitNode.setCodePosition(getCodePosition(ctx));
                return varDeclInitNode;
            }
            else if (dataType == Enums.DataType.VEC3) {
                ArithExpressionNode zeroNode = new ArithExpressionNode(new LowPrecedenceNode(0));
                Vector3ExpressionNode vector3ExpressionNode = new Vector3ExpressionNode(zeroNode, zeroNode, zeroNode);
                varDeclInitNode = new VarDeclInitNode(ctx.variableName().getText(), vector3ExpressionNode);
                varDeclInitNode.setCodePosition(getCodePosition(ctx));
                return varDeclInitNode;
            }
            else if (dataType == Enums.DataType.VEC4) {
                ArithExpressionNode zeroNode = new ArithExpressionNode(new LowPrecedenceNode(0));
                Vector4ExpressionNode vector4ExpressionNode = new Vector4ExpressionNode(zeroNode, zeroNode, zeroNode, zeroNode);
                varDeclInitNode = new VarDeclInitNode(ctx.variableName().getText(), vector4ExpressionNode);
                varDeclInitNode.setCodePosition(getCodePosition(ctx));
                return varDeclInitNode;
            }
            else {
                varDeclInitNode = new VarDeclInitNode(ctx.variableName().getText(), null);
                varDeclInitNode.setCodePosition(getCodePosition(ctx));
                return varDeclInitNode;
            }
        }
        else
            throw new CompilerException("Missing Variable Declaration initialization", getCodePosition(ctx));
    }

    @Override
    public AssignmentNode visitAssignment(SpookParser.AssignmentContext ctx) {
        ExpressionNode expressionNode;

        if (ctx.expression() != null) {
            expressionNode = visitExpression(ctx.expression());
        }
        else
            throw new CompilerException("Invalid expression in assignment", getCodePosition(ctx));

        if (ctx.swizzle() != null) {
            AssignmentNode assignmentNode = new AssignmentNode(visitSwizzle(ctx.swizzle()), expressionNode);
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
    public SwizzleNode visitSwizzle(SpookParser.SwizzleContext ctx) {
        if (ctx.objectVariableName() != null) {
            String variableName = ctx.objectVariableName().getText();
            if (ctx.functionName() != null) {
                return new SwizzleNode(variableName, ctx.functionName().getText());
            }
            else
                throw new CompilerException("Expected Color- or Coordinate swizzle", getCodePosition(ctx));
        }
        else
            throw new CompilerException("Expected variable name for swizzle", getCodePosition(ctx));
    }

    @Override
    public ExpressionNode visitExpression(SpookParser.ExpressionContext ctx) {
        if (ctx.arithExpression() != null)
        {
            // Simplify AST for vector expressions
            // (Directly returns vector expression instead of going through precedence in arithmetic expression)
            if (ctx.arithExpression().lowPrecedence().highPrecedence().size() == 1) {
                if (ctx.arithExpression().lowPrecedence().highPrecedence().get(0).atomPrecedence().size() == 1) {
                    SpookParser.ArithOperandContext arithOperandContext = ctx.arithExpression().lowPrecedence().highPrecedence(0).atomPrecedence(0).arithOperand();
                    if (arithOperandContext != null) {
                        if (arithOperandContext.vector2Expression() != null) {
                            return visitVector2Expression(arithOperandContext.vector2Expression());
                        }
                        if (arithOperandContext.vector3Expression() != null) {
                            return visitVector3Expression(arithOperandContext.vector3Expression());
                        }
                        if (arithOperandContext.vector4Expression() != null) {
                            return visitVector4Expression(arithOperandContext.vector4Expression());
                        }
                    }
                }
            }

            return visitArithExpression(ctx.arithExpression());
        }
        else if (ctx.boolExpression() != null)
            return visitBoolExpression(ctx.boolExpression());
        else if (ctx.ternaryOperator() != null)
            return visitTernaryOperator(ctx.ternaryOperator());
        else
            throw new CompilerException("Invalid expression", getCodePosition(ctx));
    }

    @Override
    public ArithExpressionNode visitArithExpression(SpookParser.ArithExpressionContext ctx) {
        ArithExpressionNode arithExpressionNode = new ArithExpressionNode(visitLowPrecedence(ctx.lowPrecedence()));
        arithExpressionNode.setCodePosition(getCodePosition(ctx));
        return arithExpressionNode;
    }

    @Override
    public Vector2ExpressionNode visitVector2Expression(SpookParser.Vector2ExpressionContext ctx) {
        ArithExpressionNode float1 = visitArithExpression(ctx.arithExpression(0));
        ArithExpressionNode float2 = visitArithExpression(ctx.arithExpression(1));

        Vector2ExpressionNode vector2ExpressionNode = new Vector2ExpressionNode(float1, float2);
        vector2ExpressionNode.setCodePosition(getCodePosition(ctx));

        return vector2ExpressionNode;
    }

    @Override
    public Vector3ExpressionNode visitVector3Expression(SpookParser.Vector3ExpressionContext ctx) {
        ArithExpressionNode float1 = visitArithExpression(ctx.arithExpression(0));
        ArithExpressionNode float2 = visitArithExpression(ctx.arithExpression(1));
        ArithExpressionNode float3 = visitArithExpression(ctx.arithExpression(2));

        Vector3ExpressionNode vector3ExpressionNode = new Vector3ExpressionNode(float1, float2, float3);
        vector3ExpressionNode.setCodePosition(getCodePosition(ctx));

        return vector3ExpressionNode;
    }

    @Override
    public Vector4ExpressionNode visitVector4Expression(SpookParser.Vector4ExpressionContext ctx) {
        ArithExpressionNode float1 = visitArithExpression(ctx.arithExpression(0));
        ArithExpressionNode float2 = visitArithExpression(ctx.arithExpression(1));
        ArithExpressionNode float3 = visitArithExpression(ctx.arithExpression(2));
        ArithExpressionNode float4 = visitArithExpression(ctx.arithExpression(3));

        Vector4ExpressionNode vector4ExpressionNode = new Vector4ExpressionNode(float1, float2, float3, float4);
        vector4ExpressionNode.setCodePosition(getCodePosition(ctx));

        return vector4ExpressionNode;
    }

    @Override
    public BoolExpressionNode visitBoolExpression(SpookParser.BoolExpressionContext ctx) {
        if (ctx.boolOperations() != null) {
            BoolExpressionNode boolExpressionNode = new BoolExpressionNode(visitBoolOperations(ctx.boolOperations()));
            boolExpressionNode.setCodePosition(getCodePosition(ctx));
            return boolExpressionNode;
        }
        else
            throw new CompilerException("Invalid Bool expression", getCodePosition(ctx));
    }

    @Override
    public BoolOperationsNode visitBoolOperations(SpookParser.BoolOperationsContext ctx) {
        Enums.BoolOperator optionalNOT = Enums.BoolOperator.NOT;
        ArrayList<BoolOperationExtendNode> boolOperationExtendNodes = new ArrayList<>();

        //Visit all Extend nodes and add them to the list
        for (SpookParser.BoolOperationExtendContext boolOperationExtendContext : ctx.boolOperationExtend())
            boolOperationExtendNodes.add(visitBoolOperationExtend(boolOperationExtendContext));

        //Case !bool extend
        if (ctx.NOT() != null && ctx.boolOperation() != null && ctx.boolOperationExtend() != null && !ctx.boolOperationExtend().isEmpty()) {
            BoolOperationNode boolOperationNode = visitBoolOperation(ctx.boolOperation());

            BoolOperationsNode boolOperationsNode = new BoolOperationsNode(boolOperationNode, boolOperationExtendNodes, optionalNOT);
            boolOperationsNode.setCodePosition(getCodePosition(ctx));
            return boolOperationsNode;
        }
        //Case !bool
        else if (ctx.NOT() != null && ctx.boolOperation() != null) {
            BoolOperationNode boolOperationNode = visitBoolOperation(ctx.boolOperation());

            BoolOperationsNode boolOperationsNode = new BoolOperationsNode(boolOperationNode, optionalNOT);
            boolOperationsNode.setCodePosition(getCodePosition(ctx));
            return boolOperationsNode;
        }
        //Case bool extend
        else if (ctx.boolOperation() != null && ctx.boolOperationExtend() != null && !ctx.boolOperationExtend().isEmpty()) {
            BoolOperationNode boolOperationNode = visitBoolOperation(ctx.boolOperation());

            BoolOperationsNode boolOperationsNode = new BoolOperationsNode(boolOperationNode, boolOperationExtendNodes);
            boolOperationsNode.setCodePosition(getCodePosition(ctx));
            return boolOperationsNode;
        }
        //Case bool
        else if (ctx.boolOperation() != null) {
            BoolOperationNode boolOperationNode = visitBoolOperation(ctx.boolOperation());

            BoolOperationsNode boolOperationsNode = new BoolOperationsNode(boolOperationNode);
            boolOperationsNode.setCodePosition(getCodePosition(ctx));
            return boolOperationsNode;
        }
        //Case !arith extend
        else if (ctx.NOT() != null && ctx.arithExpression() != null && ctx.boolOperationExtend() != null) {
            ArithExpressionNode arithExpressionNode = visitArithExpression(ctx.arithExpression());

            BoolOperationsNode boolOperationsNode = new BoolOperationsNode(arithExpressionNode, boolOperationExtendNodes, optionalNOT);
            boolOperationsNode.setCodePosition(getCodePosition(ctx));
            return boolOperationsNode;
        }
        //Case arith extend
        else if (ctx.arithExpression() != null && ctx.boolOperationExtend() != null) {
            ArithExpressionNode arithExpressionNode = visitArithExpression(ctx.arithExpression());

            BoolOperationsNode boolOperationsNode = new BoolOperationsNode(arithExpressionNode, boolOperationExtendNodes);
            boolOperationsNode.setCodePosition(getCodePosition(ctx));
            return boolOperationsNode;
        }
        else
            throw new CompilerException("Invalid Boolean operations", getCodePosition(ctx));
    }

    @Override
    public BoolOperationExtendNode visitBoolOperationExtend(SpookParser.BoolOperationExtendContext ctx) {
        Enums.BoolOperator boolOperator = getBoolOperator(ctx.boolOperator());
        Enums.BoolOperator optionalNOT = Enums.BoolOperator.NOT;

        //Needs boolOperator for all cases
        if (ctx.boolOperator() != null) {
            //Case operator !bool
            if (ctx.boolOperation() != null & ctx.NOT() != null) {
                BoolOperationNode boolOperationNode = visitBoolOperation(ctx.boolOperation());

                BoolOperationExtendNode boolOperationExtendNode = new BoolOperationExtendNode(boolOperator, optionalNOT, boolOperationNode);
                boolOperationExtendNode.setCodePosition(getCodePosition(ctx));
                return boolOperationExtendNode;
            }
            //Case operator bool
            else if (ctx.boolOperation() != null) {
                BoolOperationNode boolOperationNode = visitBoolOperation(ctx.boolOperation());

                BoolOperationExtendNode boolOperationExtendNode = new BoolOperationExtendNode(boolOperator, boolOperationNode);
                boolOperationExtendNode.setCodePosition(getCodePosition(ctx));
                return boolOperationExtendNode;
            }
            //Case operator !arith
            else if (ctx.arithExpression() != null & ctx.NOT() != null) {
                ArithExpressionNode arithExpressionNode = visitArithExpression(ctx.arithExpression());

                BoolOperationExtendNode boolOperationExtendNode = new BoolOperationExtendNode(boolOperator, optionalNOT, arithExpressionNode);
                boolOperationExtendNode.setCodePosition(getCodePosition(ctx));
                return boolOperationExtendNode;
            }
            //Case operator arith
            else if (ctx.arithExpression() != null) {
                ArithExpressionNode arithExpressionNode = visitArithExpression(ctx.arithExpression());

                BoolOperationExtendNode boolOperationExtendNode = new BoolOperationExtendNode(boolOperator, arithExpressionNode);
                boolOperationExtendNode.setCodePosition(getCodePosition(ctx));
                return boolOperationExtendNode;
            }
        }
        throw new CompilerException("Invalid Boolean Operation Extension", getCodePosition(ctx));
    }

    @Override
    public BoolOperationNode visitBoolOperation(SpookParser.BoolOperationContext ctx) {
        if (ctx.BOOL_LITERAL() != null) {
            BoolOperationNode boolOperationNode = new BoolOperationNode(getBooleanValue(ctx.BOOL_LITERAL()));
            boolOperationNode.setCodePosition(getCodePosition(ctx));
            return boolOperationNode;
        }
        else if (ctx.boolOperations() != null) {
            BoolOperationNode boolOperationNode = new BoolOperationNode(visitBoolOperations(ctx.boolOperations()));
            boolOperationNode.setCodePosition(getCodePosition(ctx));
            return boolOperationNode;
        }
        else throw new CompilerException("Invalid Boolean operation/operand", getCodePosition(ctx));
    }

    @Override
    public ClassDeclarationNode visitClassDecl(SpookParser.ClassDeclContext ctx) {
        ClassBlockNode classBlockNode = visitClassBlock(ctx.classBlock());

        ClassDeclarationNode classDeclarationNode = new ClassDeclarationNode(ctx.className(0).getText(), classBlockNode);
        classDeclarationNode.setCodePosition(getCodePosition(ctx));

        return classDeclarationNode;
    }

    @Override
    public ClassBlockNode visitClassBlock(SpookParser.ClassBlockContext ctx) {
        ArrayList<DeclarationNode> declarationNodes = new ArrayList<>();
        ArrayList<FunctionDeclarationNode> functionDeclarationNodes = new ArrayList<>();

        // Declarations
        for (SpookParser.DeclarationContext declaration: ctx.declaration()) {
            declarationNodes.add(visitDeclaration(declaration));
        }

        //Function declarations
        for (SpookParser.FunctionDeclContext functionDecl : ctx.functionDecl()) {
            functionDeclarationNodes.add(visitFunctionDecl(functionDecl));
        }

        ClassBlockNode classBlockNode = new ClassBlockNode(declarationNodes, functionDeclarationNodes);
        classBlockNode.setCodePosition(getCodePosition(ctx));

        return classBlockNode;
    }

    @Override
    public ObjectDeclarationNode visitObjectDecl(SpookParser.ObjectDeclContext ctx) {
        String objectName = ctx.objectVariableName().getText();
        String className = ctx.className().getText();
        ObjectContructorNode objectContructorNode;

        if (ctx.objectConstructor() != null)
            objectContructorNode = visitObjectConstructor(ctx.objectConstructor());
        else
            throw new CompilerException("Missing constructor for object " + ctx.objectVariableName().getText(), getCodePosition(ctx));

        ObjectDeclarationNode objectDeclarationNode = new ObjectDeclarationNode(className, objectName, objectContructorNode);
        objectDeclarationNode.setCodePosition(getCodePosition(ctx));

        if (ctx.objectConstructor().objectArgs() != null && ctx.objectConstructor().objectArgs().objectArg().size() == 0)
            throw new CompilerException("Object "+ objectDeclarationNode.getVariableName() +" Must be given atleast 1 constructor argument", objectContructorNode.getCodePosition());

        return objectDeclarationNode;

    }

    @Override
    public ObjectContructorNode visitObjectConstructor(SpookParser.ObjectConstructorContext ctx) {
        if (ctx.objectArgs() != null) {
            ArrayList<ObjectArgumentNode> objectArgumentNodes = new ArrayList<>(visitAllObjectArguments(ctx.objectArgs()));
            ObjectArgumentNodePlural objectArgumentNodePlural = new ObjectArgumentNodePlural(objectArgumentNodes);
            ObjectContructorNode objectContructorNode = new ObjectContructorNode(objectArgumentNodePlural);
            objectContructorNode.setCodePosition(getCodePosition(ctx));
            return objectContructorNode;
        }
        else if (ctx.objectVariableName() != null) {
            ObjectContructorNode objectContructorNode = new ObjectContructorNode(ctx.objectVariableName().getText());
            objectContructorNode.setCodePosition(getCodePosition(ctx));
            return objectContructorNode;
        }
        else if (ctx.functionCall() != null) {
            ASTnode functionCallNode = visitFunctionCall(ctx.functionCall());
            if (functionCallNode instanceof NonObjectFunctionCallNode) {
                ObjectContructorNode objectContructorNode = new ObjectContructorNode((NonObjectFunctionCallNode) functionCallNode);
                objectContructorNode.setCodePosition(getCodePosition(ctx));
                return objectContructorNode;
            } else if (functionCallNode instanceof ObjectFunctionCallNode) {
                ObjectContructorNode objectContructorNode = new ObjectContructorNode((ObjectFunctionCallNode) functionCallNode);
                objectContructorNode.setCodePosition(getCodePosition(ctx));
                return objectContructorNode;
            } else
                throw new CompilerException("Invalid Functioncall in object constructor", getCodePosition(ctx));
        } else
            throw new CompilerException("Invalid Object argument(s) in object constructor", getCodePosition(ctx));
    }

    @Override
    public FunctionDeclarationNode visitFunctionDecl(SpookParser.FunctionDeclContext ctx) {
        Enums.DataType dataType;
        if (ctx.dataType() != null) {
            dataType = getDataType(ctx.dataType());
            if (ctx.functionArgs() != null) {
                ArrayList<FunctionArgNode> functionArgNodes = visitAllFunctionArgs(ctx.functionArgs());

                FunctionDeclarationNode functionDeclarationNode = new FunctionDeclarationNode(dataType, ctx.functionName().getText(), functionArgNodes, visitBlock(ctx.block()));
                functionDeclarationNode.setCodePosition(getCodePosition(ctx));

                return functionDeclarationNode;
            } else {
                FunctionDeclarationNode functionDeclarationNode = new FunctionDeclarationNode(dataType, ctx.functionName().getText(), visitBlock(ctx.block()));
                functionDeclarationNode.setCodePosition(getCodePosition(ctx));

                return functionDeclarationNode;
            }
        }
        else if (ctx.className() != null) {
            String className = ctx.className().getText();
            if (ctx.functionArgs() != null) {
                ArrayList<FunctionArgNode> functionArgNodes = visitAllFunctionArgs(ctx.functionArgs());

                FunctionDeclarationNode functionDeclarationNode = new FunctionDeclarationNode(className, ctx.functionName().getText(), functionArgNodes, visitBlock(ctx.block()));
                functionDeclarationNode.setCodePosition(getCodePosition(ctx));

                return functionDeclarationNode;
            } else {
                FunctionDeclarationNode functionDeclarationNode = new FunctionDeclarationNode(className, ctx.functionName().getText(), visitBlock(ctx.block()));
                functionDeclarationNode.setCodePosition(getCodePosition(ctx));

                return functionDeclarationNode;
            }
        }
        else {
            if (ctx.functionArgs() != null) {
                ArrayList<FunctionArgNode> functionArgNodes = visitAllFunctionArgs(ctx.functionArgs());

                FunctionDeclarationNode functionDeclarationNode = new FunctionDeclarationNode(ctx.functionName().getText(), functionArgNodes, visitBlock(ctx.block()));

                functionDeclarationNode.setCodePosition(getCodePosition(ctx));

                return functionDeclarationNode;
            }
            else {
                FunctionDeclarationNode functionDeclarationNode = new FunctionDeclarationNode(ctx.functionName().getText(), (BlockNode)visitBlock(ctx.block()));
                functionDeclarationNode.setCodePosition(getCodePosition(ctx));

                return functionDeclarationNode;
            }
        }

    }

    @Override
    public ReturnNode visitReturnStatement(SpookParser.ReturnStatementContext ctx) {
        if (ctx.expression() != null) {
            ReturnNode returnNode = new ReturnNode(visitExpression(ctx.expression()));
            returnNode.setCodePosition(getCodePosition(ctx));
            return returnNode;
        }
        else
            throw new CompilerException("Invalid return statement", getCodePosition(ctx));
    }

    private ArrayList<FunctionArgNode> visitAllFunctionArgs(SpookParser.FunctionArgsContext ctx) {
        ArrayList<FunctionArgNode> functionArgNodes = new ArrayList<>();

        FunctionArgNode functionArgNode = visitFunctionArg(ctx.functionArg());

        if (functionArgNode != null)
            functionArgNodes.add(functionArgNode);

        if (ctx.functionArgs() != null)
            functionArgNodes.addAll(visitAllFunctionArgs(ctx.functionArgs()));

        return functionArgNodes;
    }

    @Override
    public FunctionArgNode visitFunctionArg(SpookParser.FunctionArgContext ctx) {
        FunctionArgNode functionArgNode;

        if (ctx.className() != null)
            functionArgNode = new FunctionArgNode(ctx.className().getText(), ctx.variableName().getText());
        else if (ctx.dataType() != null)
            functionArgNode = new FunctionArgNode(getDataType(ctx.dataType()), ctx.variableName().getText());
        else
            throw new CompilerException("Invalid function arg", getCodePosition(ctx));


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
    public NonObjectFunctionCallNode visitNonObjectFunctionCall(SpookParser.NonObjectFunctionCallContext ctx) {
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
    public ObjectFunctionCallNode visitObjectFunctionCall(SpookParser.ObjectFunctionCallContext ctx) {
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
        for (SpookParser.ObjectArgContext objectArgContext : ctx.objectArg())
            objectArgumentNodes.add(visitObjectArg(objectArgContext));

        ObjectArgumentNodePlural objectArgumentNodePlural = new ObjectArgumentNodePlural(objectArgumentNodes);
        return objectArgumentNodePlural.getObjectArgumentNodes();
    }

    @Override
    public ObjectArgumentNode visitObjectArg(SpookParser.ObjectArgContext ctx) {
        ObjectArgumentNode objectArgumentNode;

        if (ctx.lowPrecedence() != null)
            objectArgumentNode = new ObjectArgumentNode(visitLowPrecedence(ctx.lowPrecedence()));
        else if (ctx.boolExpression() != null)
            objectArgumentNode = new ObjectArgumentNode(visitBoolExpression(ctx.boolExpression()));
        else
            throw new CompilerException("Invalid Object Function Call Argument", getCodePosition(ctx));

        objectArgumentNode.setCodePosition(getCodePosition(ctx));
        return objectArgumentNode;
    }

    @Override
    public LowPrecedenceNode visitLowPrecedence(SpookParser.LowPrecedenceContext ctx) {
        ArrayList<HighPrecedenceNode> highPrecedenceNodes = new ArrayList<>();
        ArrayList<Enums.Operator> operators = new ArrayList<>();


        //High Precedence Nodes
        for (SpookParser.HighPrecedenceContext highPrecedence : ctx.highPrecedence()) {
            highPrecedenceNodes.add(visitHighPrecedence(highPrecedence));
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
    public HighPrecedenceNode visitHighPrecedence(SpookParser.HighPrecedenceContext ctx) {
        ArrayList<AtomPrecedenceNode> atomPrecedenceNodes = new ArrayList<>();
        ArrayList<Enums.Operator> operators = new ArrayList<>();


        //Atom Precedence Nodes
        for (SpookParser.AtomPrecedenceContext atomPrecedence : ctx.atomPrecedence()) {
            atomPrecedenceNodes.add(visitAtomPrecedence(atomPrecedence));
        }

        //Operators
        for (SpookParser.HighOperatorContext highOperatorContext : ctx.highOperator()) {
            operators.add(getOperator(highOperatorContext));
        }

        if (atomPrecedenceNodes.size() == 1) {
            HighPrecedenceNode highPrecedenceNode = new HighPrecedenceNode(atomPrecedenceNodes);
            highPrecedenceNode.setCodePosition(getCodePosition(ctx));
            return highPrecedenceNode;
        } else {
            HighPrecedenceNode highPrecedenceNode = new HighPrecedenceNode(atomPrecedenceNodes, operators);
            highPrecedenceNode.setCodePosition(getCodePosition(ctx));
            return highPrecedenceNode;
        }
    }

    @Override
    public AtomPrecedenceNode visitAtomPrecedence(SpookParser.AtomPrecedenceContext ctx) {
        //return -operand AtomNode
        if (ctx.SUB() != null && ctx.arithOperand() != null) {
            ArithOperandNode atomOperandNode = visitArithOperand(ctx.arithOperand());
            atomOperandNode.setCodePosition(getCodePosition(ctx));
            AtomPrecedenceNode atomPrecedenceNode = new AtomPrecedenceNode(Enums.Operator.SUB, atomOperandNode);
            atomOperandNode.setCodePosition(getCodePosition(ctx));
            return atomPrecedenceNode;
        }
        //return operand AtomNode
        else if (ctx.arithOperand() != null) {
            ArithOperandNode atomOperandNode = visitArithOperand(ctx.arithOperand());
            atomOperandNode.setCodePosition(getCodePosition(ctx));
            AtomPrecedenceNode atomPrecedenceNode = new AtomPrecedenceNode(atomOperandNode);
            atomOperandNode.setCodePosition(getCodePosition(ctx));
            return atomPrecedenceNode;
        }
        //return (lowprecedence) AtomNode
        else if (ctx.lowPrecedence() != null) {
            LowPrecedenceNode lowPrecedenceNode = visitLowPrecedence(ctx.lowPrecedence());
            lowPrecedenceNode.setCodePosition(getCodePosition(ctx));
            AtomPrecedenceNode atomPrecedenceNode = new AtomPrecedenceNode(lowPrecedenceNode);
            atomPrecedenceNode.setCodePosition(getCodePosition(ctx));
            return atomPrecedenceNode;
        } else
            throw new CompilerException("Invalid AtomPrecedence Operation", getCodePosition(ctx));
    }

    @Override
    public ArithOperandNode visitArithOperand(SpookParser.ArithOperandContext ctx) {
        if (ctx.realNumber() != null) {
            ArithOperandNode arithOperandNode = new ArithOperandNode(visitRealNumber((ctx.realNumber())));
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
            SwizzleNode swizzleNode = visitSwizzle(ctx.swizzle());
            ArithOperandNode arithOperandNode = new ArithOperandNode(swizzleNode);

            arithOperandNode.setCodePosition(getCodePosition(ctx));

            return arithOperandNode;
        }
        else if (ctx.vector2Expression() != null) {
            Vector2ExpressionNode vector2ExpressionNode = visitVector2Expression(ctx.vector2Expression());
            ArithOperandNode arithOperandNode = new ArithOperandNode(vector2ExpressionNode);
            arithOperandNode.setCodePosition(getCodePosition(ctx));
            return arithOperandNode;
        }
        else if (ctx.vector3Expression() != null) {
            Vector3ExpressionNode vector3ExpressionNode = visitVector3Expression(ctx.vector3Expression());
            ArithOperandNode arithOperandNode = new ArithOperandNode(vector3ExpressionNode);
            arithOperandNode.setCodePosition(getCodePosition(ctx));
            return arithOperandNode;
        }
        else if (ctx.vector4Expression() != null) {
            Vector4ExpressionNode vector4ExpressionNode = visitVector4Expression(ctx.vector4Expression());
            ArithOperandNode arithOperandNode = new ArithOperandNode(vector4ExpressionNode);
            arithOperandNode.setCodePosition(getCodePosition(ctx));
            return arithOperandNode;
        }
        else
            throw new CompilerException("Invalid Operand", getCodePosition(ctx));
    }

    @Override
    public TernaryOperatorNode visitTernaryOperator(SpookParser.TernaryOperatorContext ctx) {
        BoolExpressionNode boolExpression;
        ExpressionNode expression1;
        ExpressionNode expression2;
        ASTnode functionCallNode;

        if (ctx.expression(0) != null)
            expression1 = visitExpression(ctx.expression(0));
        else
            throw new CompilerException("Invalid first expression for Ternary operator", getCodePosition(ctx));

        if (ctx.expression(1) != null)
            expression2 = visitExpression(ctx.expression(1));
        else
            throw new CompilerException("Invalid second expression for Ternary operator", getCodePosition(ctx));

        if (ctx.boolExpression() != null) {
            boolExpression = visitBoolExpression(ctx.boolExpression());
            TernaryOperatorNode ternaryOperatorNode = new TernaryOperatorNode(boolExpression, expression1, expression2);
            ternaryOperatorNode.setCodePosition(getCodePosition(ctx));
            return ternaryOperatorNode;
        }
        else if (ctx.variableName() != null && ctx.NOT() != null) {
            TernaryOperatorNode ternaryOperatorNode = new TernaryOperatorNode(Enums.BoolOperator.NOT, ctx.variableName().getText(), expression1, expression2);
            ternaryOperatorNode.setCodePosition(getCodePosition(ctx));
            return ternaryOperatorNode;
        }
        else if (ctx.variableName() != null) {
            TernaryOperatorNode ternaryOperatorNode = new TernaryOperatorNode(ctx.variableName().getText(), expression1, expression2);
            ternaryOperatorNode.setCodePosition(getCodePosition(ctx));
            return ternaryOperatorNode;
        }
        else if (ctx.functionCall() != null) {
            functionCallNode = visitFunctionCall(ctx.functionCall());
            if (functionCallNode instanceof NonObjectFunctionCallNode) {
                TernaryOperatorNode ternaryOperatorNode = new TernaryOperatorNode((NonObjectFunctionCallNode) functionCallNode, expression1, expression2);
                ternaryOperatorNode.setCodePosition(getCodePosition(ctx));
                return ternaryOperatorNode;
            }
            else if (functionCallNode instanceof ObjectFunctionCallNode) {
                TernaryOperatorNode ternaryOperatorNode = new TernaryOperatorNode((ObjectFunctionCallNode) functionCallNode, expression1, expression2);
                ternaryOperatorNode.setCodePosition(getCodePosition(ctx));
                return ternaryOperatorNode;
            }
            else
                throw new CompilerException("Invalid Functioncall in Ternary operator", getCodePosition(ctx));
        }
        else
            throw new CompilerException("Invalid Boolean expression in Ternary operator", getCodePosition(ctx));
    }

    @Override
    public IfElseStatementNode visitIfElseStatement(SpookParser.IfElseStatementContext ctx) {
        IfStatementNode ifStatementNode = visitIfStatement(ctx.ifStatement());
        ArrayList<ElseIfStatementNode> elseIfStatementNode = null;
        ElseStatementNode elseStatementNode = null;

        if (ctx.elseIfStatement() != null) {
            elseIfStatementNode = new ArrayList<>();
            for (SpookParser.ElseIfStatementContext elseIfStatement : ctx.elseIfStatement()) {
                elseIfStatementNode.add(visitElseIfStatement(elseIfStatement));
            }
        }
        if (ctx.elseStatement() != null) {
            elseStatementNode = visitElseStatement(ctx.elseStatement());
        }

        IfElseStatementNode ifElseStatementNode = new IfElseStatementNode(ifStatementNode, elseIfStatementNode, elseStatementNode);
        ifElseStatementNode.setCodePosition(getCodePosition(ctx));
        return ifElseStatementNode;
    }

    @Override
    public IfStatementNode visitIfStatement(SpookParser.IfStatementContext ctx) {
        //Does not need if checks as there is only 1 option, and therefore cannot vary (Parser does this null check)
        ConditionalExpressionNode ifBool = visitConditionalExpression(ctx.conditionalExpression());
        ConditionalBlockNode ifBlock = visitConditionalBlock(ctx.conditionalBlock());
        IfStatementNode ifStatement = new IfStatementNode(ifBool, ifBlock);
        ifStatement.setCodePosition(getCodePosition(ctx));
        return ifStatement;
    }

    @Override
    public ConditionalExpressionNode visitConditionalExpression(SpookParser.ConditionalExpressionContext ctx) {
        ConditionalExpressionNode conditionalExpressionNode;
        if (ctx.boolExpression() != null) {
            BoolExpressionNode boolExpressionNode = visitBoolExpression(ctx.boolExpression());
            conditionalExpressionNode = new ConditionalExpressionNode(boolExpressionNode);
            conditionalExpressionNode.setCodePosition(getCodePosition(ctx));
            return conditionalExpressionNode;
        } else if (ctx.variableName() != null) {
            conditionalExpressionNode = new ConditionalExpressionNode(ctx.variableName().getText());
            conditionalExpressionNode.setCodePosition(getCodePosition(ctx));
            return conditionalExpressionNode;
        } else if (ctx.functionCall() != null) {
            ASTnode functioncall = visitFunctionCall(ctx.functionCall());
            if (functioncall instanceof NonObjectFunctionCallNode) {
                conditionalExpressionNode = new ConditionalExpressionNode((NonObjectFunctionCallNode) functioncall);
                conditionalExpressionNode.setCodePosition(getCodePosition(ctx));
                return conditionalExpressionNode;
            } else if (functioncall instanceof ObjectFunctionCallNode) {
                conditionalExpressionNode = new ConditionalExpressionNode((ObjectFunctionCallNode) functioncall);
                conditionalExpressionNode.setCodePosition(getCodePosition(ctx));
                return conditionalExpressionNode;
            }
        }
        //If nothing matches
        throw new CompilerException("Invalid Conditional Expression", getCodePosition(ctx));
    }

    @Override
    public ConditionalBlockNode visitConditionalBlock(SpookParser.ConditionalBlockContext ctx) {
        ConditionalBlockNode conditionalBlockNode;
        if (ctx.block() != null) {
            BlockNode blockNode = visitBlock(ctx.block());
            conditionalBlockNode = new ConditionalBlockNode(blockNode);
            conditionalBlockNode.setCodePosition(getCodePosition(ctx));
            return conditionalBlockNode;
        }
        else if (ctx.statement() != null) {
            StatementNode statementNode = (visitStatement(ctx.statement()));
            conditionalBlockNode = new ConditionalBlockNode(statementNode);
            conditionalBlockNode.setCodePosition(getCodePosition(ctx));
            return conditionalBlockNode;
        }
        else
            throw new CompilerException("Invalid Conditional Block", getCodePosition(ctx));
    }

    @Override
    public ElseIfStatementNode visitElseIfStatement(SpookParser.ElseIfStatementContext ctx) {
        //Only 1 option, parser does the null check
        ConditionalExpressionNode elseifBool = visitConditionalExpression(ctx.conditionalExpression());
        ConditionalBlockNode elseifBlock = visitConditionalBlock(ctx.conditionalBlock());
        ElseIfStatementNode elseifStatement = new ElseIfStatementNode(elseifBool, elseifBlock);
        elseifStatement.setCodePosition(getCodePosition(ctx));
        return elseifStatement;
    }

    @Override
    public ElseStatementNode visitElseStatement(SpookParser.ElseStatementContext ctx) {
        //Does not need if checks as there is only 1 option, and therefore cannot vary (Parser does this null check)
        ConditionalBlockNode elseBlock = visitConditionalBlock(ctx.conditionalBlock());
        ElseStatementNode elseStatement = new ElseStatementNode(elseBlock);
        elseStatement.setCodePosition(getCodePosition(ctx));
        return elseStatement;
    }

    @Override
    public ForLoopStatementNode visitForStatement(SpookParser.ForStatementContext ctx) {
        ForLoopExpressionNode expressionNode1 = visitForLoopExpression(ctx.forLoopExpression(0));
        ForLoopExpressionNode expressionNode2 = visitForLoopExpression(ctx.forLoopExpression(1));
        ConditionalBlockNode conditionalBlockNode = visitConditionalBlock(ctx.conditionalBlock());
        ForLoopStatementNode forLoopStatementNode = new ForLoopStatementNode(expressionNode1, expressionNode2, conditionalBlockNode);
        forLoopStatementNode.setCodePosition(getCodePosition(ctx));
        return forLoopStatementNode;
    }

    @Override
    public ForLoopExpressionNode visitForLoopExpression(SpookParser.ForLoopExpressionContext ctx) {
        if (ctx.assignment() != null) {
            ForLoopExpressionNode forLoopExpressionNode = new ForLoopExpressionNode(visitAssignment(ctx.assignment()));
            forLoopExpressionNode.setCodePosition(getCodePosition(ctx));
            return forLoopExpressionNode;
        }
        else if (ctx.atomPrecedence() != null) {
            ForLoopExpressionNode forLoopExpressionNode = new ForLoopExpressionNode(visitAtomPrecedence(ctx.atomPrecedence()));
            forLoopExpressionNode.setCodePosition(getCodePosition(ctx));
            return forLoopExpressionNode;
        }
        else if (ctx.variableDecl() != null) {
            ForLoopExpressionNode forLoopExpressionNode = new ForLoopExpressionNode(visitVariableDecl(ctx.variableDecl()));
            forLoopExpressionNode.setCodePosition(getCodePosition(ctx));
            if (forLoopExpressionNode.getVariableDeclarationNode().getCodePosition() == null)
                throw new RuntimeException("missing codeposition");
            return forLoopExpressionNode;
        }
        else
            throw new CompilerException("Invalid ForLoop expression", getCodePosition(ctx));
    }


    @Override
    public RealNumberNode visitRealNumber(SpookParser.RealNumberContext ctx) {
        float value = getRealNumberValue(ctx);
        RealNumberNode realNumberNode = new RealNumberNode(value);
        realNumberNode.setCodePosition(getCodePosition(ctx));
        return realNumberNode;
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
        else if (ctx.DIGIT_NEGATIVE() != null) {
            String negativeNumberString = ctx.DIGIT_NEGATIVE().getSymbol().getText();
            value = Integer.valueOf(negativeNumberString.substring(1, negativeNumberString.length() - 1));
        }
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

        // TODO: Class like "Circle" does not work as a function argument.

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

    private  Enums.BoolOperator getBoolOperator (SpookParser.BoolOperatorContext ctx) {
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
}
