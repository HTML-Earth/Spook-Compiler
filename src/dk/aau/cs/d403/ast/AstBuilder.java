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
        ArrayList<VarDeclInitNode> varDeclInitNodes = new ArrayList<>();

        for (SpookParser.VariableDeclInitContext variableDeclInit : ctx.variableDeclInit()) {
            varDeclInitNodes.add((VarDeclInitNode) visitVariableDeclInit(variableDeclInit));
        }

        VariableDeclarationNode variableDeclarationNode = new VariableDeclarationNode(getDataType(ctx.dataType()), varDeclInitNodes);
        variableDeclarationNode.setCodePosition(getCodePosition(ctx));
        return variableDeclarationNode;
    }

    @Override
    public ASTnode visitVariableDeclInit(SpookParser.VariableDeclInitContext ctx) {
        if (ctx.assignment() != null) {
            AssignmentNode assignmentNode = (AssignmentNode) visitAssignment(ctx.assignment());
            VarDeclInitNode varDeclInitNode = new VarDeclInitNode(assignmentNode);
            varDeclInitNode.setCodePosition(getCodePosition(ctx));
            return varDeclInitNode;
        }
        else if (ctx.variableName() != null) {
            VarDeclInitNode varDeclInitNode = new VarDeclInitNode(ctx.variableName().getText());
            varDeclInitNode.setCodePosition(getCodePosition(ctx));
            return varDeclInitNode;
        }
        else
            throw new CompilerException("Missing Variable Declaration initialization", getCodePosition(ctx));
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
                return new SwizzleNode(variableName, new ColorSwizzleNode(ctx.colorSwizzle().getText().substring(1)));
            }
            else if (ctx.coordinateSwizzle() != null) {
                return new SwizzleNode(variableName, new CoordinateSwizzleNode(ctx.coordinateSwizzle().getText().substring(1)));
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
        else if (ctx.boolExpression() != null)
            return visitBoolExpression(ctx.boolExpression());
        else if (ctx.ternaryOperator() != null)
            return visitTernaryOperator(ctx.ternaryOperator());
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
        ArrayList<BoolOperationExtendNode> boolOperationExtendNodes = new ArrayList<>();

        //Visit all Extend nodes and add them to the list
        for (SpookParser.BoolOperationExtendContext boolOperationExtendContext : ctx.boolOperationExtend())
            boolOperationExtendNodes.add((BoolOperationExtendNode) visitBoolOperationExtend(boolOperationExtendContext));

        //Case !bool extend
        if (ctx.NOT() != null && ctx.boolOperation() != null && ctx.boolOperationExtend() != null) {
            BoolOperationNode boolOperationNode = (BoolOperationNode) visitBoolOperation(ctx.boolOperation());

            BoolOperationsNode boolOperationsNode = new BoolOperationsNode(boolOperationNode, boolOperationExtendNodes, optionalNOT);
            boolOperationsNode.setCodePosition(getCodePosition(ctx));
            return boolOperationsNode;
        }
        //Case !bool
        else if (ctx.NOT() != null && ctx.boolOperation() != null) {
            BoolOperationNode boolOperationNode = (BoolOperationNode) visitBoolOperation(ctx.boolOperation());

            BoolOperationsNode boolOperationsNode = new BoolOperationsNode(boolOperationNode, optionalNOT);
            boolOperationsNode.setCodePosition(getCodePosition(ctx));
            return boolOperationsNode;
        }
        //Case bool extend
        else if (ctx.boolOperation() != null && ctx.boolOperationExtend() != null) {
            BoolOperationNode boolOperationNode = (BoolOperationNode) visitBoolOperation(ctx.boolOperation());

            BoolOperationsNode boolOperationsNode = new BoolOperationsNode(boolOperationNode, boolOperationExtendNodes);
            boolOperationsNode.setCodePosition(getCodePosition(ctx));
            return boolOperationsNode;
        }
        //Case !arith extend
        else if (ctx.NOT() != null && ctx.arithExpression() != null && ctx.boolOperationExtend() != null) {
            ArithExpressionNode arithExpressionNode = (ArithExpressionNode) visitArithExpression(ctx.arithExpression());

            BoolOperationsNode boolOperationsNode = new BoolOperationsNode(arithExpressionNode, boolOperationExtendNodes, optionalNOT);
            boolOperationsNode.setCodePosition(getCodePosition(ctx));
            return boolOperationsNode;
        }
        //Case arith extend
        else if (ctx.arithExpression() != null && ctx.boolOperationExtend() != null) {
            ArithExpressionNode arithExpressionNode = (ArithExpressionNode) visitArithExpression(ctx.arithExpression());

            BoolOperationsNode boolOperationsNode = new BoolOperationsNode(arithExpressionNode, boolOperationExtendNodes);
            boolOperationsNode.setCodePosition(getCodePosition(ctx));
            return boolOperationsNode;
        }
        else
            throw new CompilerException("Invalid Boolean operations", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitBoolOperationExtend(SpookParser.BoolOperationExtendContext ctx) {
        Enums.BoolOperator boolOperator = getBoolOperator(ctx.boolOperator());
        Enums.BoolOperator optionalNOT = Enums.BoolOperator.NOT;

        //Needs boolOperator for all cases
        if (ctx.boolOperator() != null) {
            //Case operator !bool
            if (ctx.boolOperation() != null & ctx.NOT() != null) {
                BoolOperationNode boolOperationNode = (BoolOperationNode) visitBoolOperation(ctx.boolOperation());

                BoolOperationExtendNode boolOperationExtendNode = new BoolOperationExtendNode(boolOperator, optionalNOT, boolOperationNode);
                boolOperationExtendNode.setCodePosition(getCodePosition(ctx));
                return boolOperationExtendNode;
            }
            //Case operator bool
            else if (ctx.boolOperation() != null) {
                BoolOperationNode boolOperationNode = (BoolOperationNode) visitBoolOperation(ctx.boolOperation());

                BoolOperationExtendNode boolOperationExtendNode = new BoolOperationExtendNode(boolOperator, boolOperationNode);
                boolOperationExtendNode.setCodePosition(getCodePosition(ctx));
                return boolOperationExtendNode;
            }
            //Case operator !arith
            else if (ctx.arithExpression() != null & ctx.NOT() != null) {
                ArithExpressionNode arithExpressionNode = (ArithExpressionNode) visitArithExpression(ctx.arithExpression());

                BoolOperationExtendNode boolOperationExtendNode = new BoolOperationExtendNode(boolOperator, optionalNOT, arithExpressionNode);
                boolOperationExtendNode.setCodePosition(getCodePosition(ctx));
                return boolOperationExtendNode;
            }
            //Case operator arith
            else if (ctx.arithExpression() != null) {
                ArithExpressionNode arithExpressionNode = (ArithExpressionNode) visitArithExpression(ctx.arithExpression());

                BoolOperationExtendNode boolOperationExtendNode = new BoolOperationExtendNode(boolOperator, arithExpressionNode);
                boolOperationExtendNode.setCodePosition(getCodePosition(ctx));
                return boolOperationExtendNode;
            }
        }
        throw new CompilerException("Invalid Boolean Operation Extension", getCodePosition(ctx));
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
        String objectName = ctx.objectVariableName().getText();
        String className = ctx.className().getText();

        if (ctx.objectConstructor() != null) {
            ObjectContructorNode objectContructorNode = (ObjectContructorNode) visitObjectConstructor(ctx.objectConstructor());

            ObjectDeclarationNode objectDeclarationNode = new ObjectDeclarationNode(className, objectName, objectContructorNode);
            objectDeclarationNode.setCodePosition(getCodePosition(ctx));
            return objectDeclarationNode;
        } else {
            ObjectDeclarationNode objectDeclarationNode = new ObjectDeclarationNode(className, objectName);
            objectDeclarationNode.setCodePosition(getCodePosition(ctx));
            return objectDeclarationNode;
        }
    }

    @Override
    public ASTnode visitObjectConstructor(SpookParser.ObjectConstructorContext ctx) {
        if (ctx.objectArgs() != null) {
            ArrayList<ObjectArgumentNode> objectArgumentNodes = new ArrayList<>(visitAllObjectArguments(ctx.objectArgs()));
            ObjectArgumentNodePlural objectArgumentNodePlural = new ObjectArgumentNodePlural(objectArgumentNodes);
            ObjectContructorNode objectContructorNode = new ObjectContructorNode(objectArgumentNodePlural);
            objectContructorNode.setCodePosition(getCodePosition(ctx));
            return objectContructorNode;
        } else if (ctx.functionCall() != null) {
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
    public ASTnode visitFunctionDecl(SpookParser.FunctionDeclContext ctx) {
        Enums.DataType dataType;
        if (ctx.dataType() != null) {
            dataType = getDataType(ctx.dataType());
            if (ctx.functionArgs() != null) {
                ArrayList<FunctionArgNode> functionArgNodes = visitAllFunctionArgs(ctx.functionArgs());

                FunctionDeclarationNode functionDeclarationNode = new FunctionDeclarationNode(dataType, ctx.functionName().getText(), functionArgNodes, (BlockNode) visitBlock(ctx.block()));
                functionDeclarationNode.setCodePosition(getCodePosition(ctx));

                return functionDeclarationNode;
            } else {
                FunctionDeclarationNode functionDeclarationNode = new FunctionDeclarationNode(dataType, ctx.functionName().getText(), (BlockNode) visitBlock(ctx.block()));
                functionDeclarationNode.setCodePosition(getCodePosition(ctx));

                return functionDeclarationNode;
            }
        }
        else {
            if (ctx.functionArgs() != null) {
                ArrayList<FunctionArgNode> functionArgNodes = visitAllFunctionArgs(ctx.functionArgs());

                FunctionDeclarationNode functionDeclarationNode = new FunctionDeclarationNode(null, ctx.functionName().getText(), functionArgNodes, (BlockNode)visitBlock(ctx.block()));

                functionDeclarationNode.setCodePosition(getCodePosition(ctx));

                return functionDeclarationNode;
            }
            else {
                FunctionDeclarationNode functionDeclarationNode = new FunctionDeclarationNode(null, ctx.functionName().getText(), (BlockNode)visitBlock(ctx.block()));
                functionDeclarationNode.setCodePosition(getCodePosition(ctx));

                return functionDeclarationNode;
            }
        }

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
        for (SpookParser.ObjectArgContext objectArgContext : ctx.objectArg())
            objectArgumentNodes.add((ObjectArgumentNode) visitObjectArg(objectArgContext));

        ObjectArgumentNodePlural objectArgumentNodePlural = new ObjectArgumentNodePlural(objectArgumentNodes);
        return objectArgumentNodePlural.getObjectArgumentNodes();
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
        else if (ctx.vector2Expression() != null) {
            Vector2ExpressionNode vector2ExpressionNode = (Vector2ExpressionNode) visitVector2Expression(ctx.vector2Expression());
            ArithOperandNode arithOperandNode = new ArithOperandNode(vector2ExpressionNode);
            arithOperandNode.setCodePosition(getCodePosition(ctx));
            return arithOperandNode;
        }
        else if (ctx.vector3Expression() != null) {
            Vector3ExpressionNode vector3ExpressionNode = (Vector3ExpressionNode) visitVector3Expression(ctx.vector3Expression());
            ArithOperandNode arithOperandNode = new ArithOperandNode(vector3ExpressionNode);
            arithOperandNode.setCodePosition(getCodePosition(ctx));
            return arithOperandNode;
        }
        else if (ctx.vector4Expression() != null) {
            Vector4ExpressionNode vector4ExpressionNode = (Vector4ExpressionNode) visitVector4Expression(ctx.vector4Expression());
            ArithOperandNode arithOperandNode = new ArithOperandNode(vector4ExpressionNode);
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
        ASTnode functionCallNode;

        if (ctx.expression(0) != null)
            expression1 = (ExpressionNode) visitExpression(ctx.expression(0));
        else
            throw new CompilerException("Invalid first expression for Ternary operator", getCodePosition(ctx));

        if (ctx.expression(1) != null)
            expression2 = (ExpressionNode) visitExpression(ctx.expression(1));
        else
            throw new CompilerException("Invalid second expression for Ternary operator", getCodePosition(ctx));

        if (ctx.boolExpression() != null) {
            boolExpression = (BoolExpressionNode) visitBoolExpression(ctx.boolExpression());
            TernaryOperatorNode ternaryOperatorNode = new TernaryOperatorNode(boolExpression, expression1, expression2);
            ternaryOperatorNode.setCodePosition(getCodePosition(ctx));
            return ternaryOperatorNode;
        }
        else if (ctx.variableName() != null) {
            TernaryOperatorNode ternaryOperatorNode = new TernaryOperatorNode(expression1, expression2, ctx.variableName().getText());
            ternaryOperatorNode.setCodePosition(getCodePosition(ctx));
            return ternaryOperatorNode;
        }
        else if (ctx.functionCall() != null) {
            functionCallNode = visitFunctionCall(ctx.functionCall());
            if (functionCallNode instanceof NonObjectFunctionCallNode) {
                TernaryOperatorNode ternaryOperatorNode = new TernaryOperatorNode(expression1, expression2, (NonObjectFunctionCallNode) functionCallNode);
                ternaryOperatorNode.setCodePosition(getCodePosition(ctx));
                return ternaryOperatorNode;
            }
            else if (functionCallNode instanceof ObjectFunctionCallNode) {
                TernaryOperatorNode ternaryOperatorNode = new TernaryOperatorNode(expression1, expression2, (ObjectFunctionCallNode) functionCallNode);
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
        //Does not need if checks as there is only 1 option, and therefore cannot vary (Parser does this null check)
        ConditionalExpressionNode ifBool = (ConditionalExpressionNode) visitConditionalExpression(ctx.conditionalExpression());
        ConditionalBlockNode ifBlock = (ConditionalBlockNode) visitConditionalBlock(ctx.conditionalBlock());
        IfStatementNode ifStatement = new IfStatementNode(ifBool, ifBlock);
        ifStatement.setCodePosition(getCodePosition(ctx));
        return ifStatement;
    }

    @Override
    public ASTnode visitConditionalExpression(SpookParser.ConditionalExpressionContext ctx) {
        ConditionalExpressionNode conditionalExpressionNode;
        if (ctx.BOOL_LITERAL() != null) {
            conditionalExpressionNode = new ConditionalExpressionNode(getBooleanValue(ctx.BOOL_LITERAL()));
            conditionalExpressionNode.setCodePosition(getCodePosition(ctx));
            return conditionalExpressionNode;
        } else if (ctx.boolExpression() != null) {
            BoolExpressionNode boolExpressionNode = (BoolExpressionNode) visitBoolExpression(ctx.boolExpression());
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
    public ASTnode visitConditionalBlock(SpookParser.ConditionalBlockContext ctx) {
        ConditionalBlockNode conditionalBlockNode;
        if (ctx.block() != null) {
            BlockNode blockNode = (BlockNode) visitBlock(ctx.block());
            conditionalBlockNode = new ConditionalBlockNode(blockNode);
            conditionalBlockNode.setCodePosition(getCodePosition(ctx));
            return conditionalBlockNode;
        }
        else if (ctx.statement() != null) {
            StatementNode statementNode = (StatementNode) visitStatement(ctx.statement());
            conditionalBlockNode = new ConditionalBlockNode(statementNode);
            conditionalBlockNode.setCodePosition(getCodePosition(ctx));
            return conditionalBlockNode;
        }
        else
            throw new CompilerException("Invalid Conditional Block", getCodePosition(ctx));
    }

    @Override
    public ASTnode visitElseIfStatement(SpookParser.ElseIfStatementContext ctx) {
        //Only 1 option, parser does the null check
        ConditionalExpressionNode elseifBool = (ConditionalExpressionNode) visitConditionalExpression(ctx.conditionalExpression());
        ConditionalBlockNode elseifBlock = (ConditionalBlockNode) visitConditionalBlock(ctx.conditionalBlock());
        ElseIfStatementNode elseifStatement = new ElseIfStatementNode(elseifBool, elseifBlock);
        elseifStatement.setCodePosition(getCodePosition(ctx));
        return elseifStatement;
    }

    @Override
    public ASTnode visitElseStatement(SpookParser.ElseStatementContext ctx) {
        //Does not need if checks as there is only 1 option, and therefore cannot vary (Parser does this null check)
        ConditionalBlockNode elseBlock = (ConditionalBlockNode) visitConditionalBlock(ctx.conditionalBlock());
        ElseStatementNode elseStatement = new ElseStatementNode(elseBlock);
        elseStatement.setCodePosition(getCodePosition(ctx));
        return elseStatement;
    }

    @Override
    public ASTnode visitForStatement(SpookParser.ForStatementContext ctx) {
        BlockNode blockNode;
        StatementNode statementNode;

        ForLoopExpressionNode forLoopExpressionNode1 = (ForLoopExpressionNode) visitForLoopExpression(ctx.forLoopExpression(0));
        ForLoopExpressionNode forLoopExpressionNode2 = (ForLoopExpressionNode) visitForLoopExpression(ctx.forLoopExpression(1));
        ConditionalBlockNode conditionalBlockNode = (ConditionalBlockNode) visitConditionalBlock(ctx.conditionalBlock());

        ForLoopStatementNode forLoopStatementNode = new ForLoopStatementNode(forLoopExpressionNode1, forLoopExpressionNode2, conditionalBlockNode);
        forLoopStatementNode.setCodePosition(getCodePosition(ctx));
        return forLoopStatementNode;
    }

    @Override
    public ASTnode visitForLoopExpression(SpookParser.ForLoopExpressionContext ctx) {
        if (ctx.assignment() != null)
            return new ForLoopExpressionNode((AssignmentNode) visitAssignment(ctx.assignment()));
        else if (ctx.atomPrecedence() != null) {
            AtomPrecedenceNode atomPrecedenceNode = (AtomPrecedenceNode) visitAtomPrecedence(ctx.atomPrecedence());
            return new ForLoopExpressionNode(atomPrecedenceNode);
        }
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