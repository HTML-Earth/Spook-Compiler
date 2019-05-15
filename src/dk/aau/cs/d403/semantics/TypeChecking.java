package dk.aau.cs.d403.semantics;

import dk.aau.cs.d403.CompilerException;
import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.ast.statements.*;
import dk.aau.cs.d403.ast.structure.*;
import dk.aau.cs.d403.spook.Vector2;

import java.util.*;

public class TypeChecking {
    private Stack<HashMap<String, ASTnode>> hashMapStack;
    private Integer functionCounter = 1;
    private FunctionDeclarationNode currentFuncNode;

    private ArrayList<String> listOfPredefinedClasses;
    private ArrayList<String> listOfPredefinedFunctions;
    private ArrayList<VariableDeclarationNode> listOfPredefinedVariables;
    private ArrayList<Enums.BoolOperator> booleanOperatorList;
    private ArrayList<Enums.BoolOperator> numberOperatorList;

    public TypeChecking() {
        this.hashMapStack = new Stack<>();

        this.listOfPredefinedClasses = new ArrayList<>();
        this.listOfPredefinedClasses.add("Empty");
        this.listOfPredefinedClasses.add("Circle");
        this.listOfPredefinedClasses.add("Rectangle");
        this.listOfPredefinedClasses.add("Triangle");
        this.listOfPredefinedClasses.add("Square");
        this.listOfPredefinedClasses.add("Shape");
        this.listOfPredefinedClasses.add("Color");
        this.listOfPredefinedClasses.add("CircleGradient");
        this.listOfPredefinedClasses.add("LineGradient");
        this.listOfPredefinedClasses.add("Polygon");
        this.listOfPredefinedClasses.add("Scene");

        this.listOfPredefinedFunctions = new ArrayList<>();
        this.listOfPredefinedFunctions.add("abs");
        this.listOfPredefinedFunctions.add("acos");
        this.listOfPredefinedFunctions.add("acosh");
        this.listOfPredefinedFunctions.add("asin");
        this.listOfPredefinedFunctions.add("asinh");
        this.listOfPredefinedFunctions.add("atan");
        this.listOfPredefinedFunctions.add("atanh");
        this.listOfPredefinedFunctions.add("ceil");
        this.listOfPredefinedFunctions.add("clamp");
        this.listOfPredefinedFunctions.add("cos");
        this.listOfPredefinedFunctions.add("cosh");
        this.listOfPredefinedFunctions.add("cross");
        this.listOfPredefinedFunctions.add("degrees");
        this.listOfPredefinedFunctions.add("distance");
        this.listOfPredefinedFunctions.add("dot");
        this.listOfPredefinedFunctions.add("exp");
        this.listOfPredefinedFunctions.add("exp2");
        this.listOfPredefinedFunctions.add("floor");
        this.listOfPredefinedFunctions.add("fract");
        this.listOfPredefinedFunctions.add("inversesqrt");
        this.listOfPredefinedFunctions.add("length");
        this.listOfPredefinedFunctions.add("log");
        this.listOfPredefinedFunctions.add("log2");
        this.listOfPredefinedFunctions.add("max");
        this.listOfPredefinedFunctions.add("min");
        this.listOfPredefinedFunctions.add("mix");
        this.listOfPredefinedFunctions.add("mod");
        this.listOfPredefinedFunctions.add("normalize");
        this.listOfPredefinedFunctions.add("outerProduct");
        this.listOfPredefinedFunctions.add("pow");
        this.listOfPredefinedFunctions.add("radians");
        this.listOfPredefinedFunctions.add("reflect");
        this.listOfPredefinedFunctions.add("refract");
        this.listOfPredefinedFunctions.add("round");
        this.listOfPredefinedFunctions.add("roundEven");
        this.listOfPredefinedFunctions.add("sign");
        this.listOfPredefinedFunctions.add("sin");
        this.listOfPredefinedFunctions.add("sinh");
        this.listOfPredefinedFunctions.add("smoothstep");
        this.listOfPredefinedFunctions.add("sqrt");
        this.listOfPredefinedFunctions.add("step");
        this.listOfPredefinedFunctions.add("tan");
        this.listOfPredefinedFunctions.add("tanh");
        this.listOfPredefinedFunctions.add("trunc");

        ArithExpressionNode zeroNode = new ArithExpressionNode(LowPrecedenceNode.zero());

        this.listOfPredefinedVariables = new ArrayList<>();
        ArrayList<VarDeclInitNode> screenVarDeclInitList = new ArrayList<>();
        AssignmentNode screenAssignmentNode = new AssignmentNode("Screen", new Vector2ExpressionNode(zeroNode, zeroNode));
        screenVarDeclInitList.add(new VarDeclInitNode(screenAssignmentNode));
        this.listOfPredefinedVariables.add(new VariableDeclarationNode(Enums.DataType.VEC2, screenVarDeclInitList));

        ArrayList<VarDeclInitNode> timeVarDeclInitList = new ArrayList<>();
        AssignmentNode timeAssignmentNode = new AssignmentNode("Time", zeroNode);
        timeVarDeclInitList.add(new VarDeclInitNode(timeAssignmentNode));
        this.listOfPredefinedVariables.add(new VariableDeclarationNode(Enums.DataType.NUM, timeVarDeclInitList));

        this.booleanOperatorList = new ArrayList<>();
        this.booleanOperatorList.add(Enums.BoolOperator.AND);
        this.booleanOperatorList.add(Enums.BoolOperator.OR);
        this.booleanOperatorList.add(Enums.BoolOperator.NOT);

        this.numberOperatorList = new ArrayList<>();
        this.numberOperatorList.add(Enums.BoolOperator.GREATER_OR_EQUAL);
        this.numberOperatorList.add(Enums.BoolOperator.GREATER_THAN);
        this.numberOperatorList.add(Enums.BoolOperator.LESS_OR_EQUAL);
        this.numberOperatorList.add(Enums.BoolOperator.LESS_THAN);
        this.numberOperatorList.add(Enums.BoolOperator.EQUAL);
        this.numberOperatorList.add(Enums.BoolOperator.NOT_EQUAL);
    }

    private void openScope() {
        HashMap<String, ASTnode> newSymbolTable = new HashMap<>();
        this.hashMapStack.push(newSymbolTable);
    }

    private void closeScope() {
        this.hashMapStack.pop();
    }

    private void enterSymbol(String name, ASTnode object) {
        if (retrieveSymbol(name) != null) {
            String functionName = functionCounter.toString() + name;
            functionCounter += 1;
            this.hashMapStack.peek().put(functionName, object);
        } else
            this.hashMapStack.peek().put(name, object);
    }

    private ASTnode retrieveSymbol(String name) {
        int stackLevel = this.hashMapStack.size() - 1;

        while (stackLevel >= 0) {
            if (this.hashMapStack.elementAt(stackLevel).get(name) != null)
                return this.hashMapStack.elementAt(stackLevel).get(name);
            else
                stackLevel -= 1;
        }

        return null;
    }

    private ArrayList<FunctionDeclarationNode> retrieveAllFunctions(String name) {
        ArrayList<FunctionDeclarationNode> symbols = new ArrayList<>();
        int stackLevel = this.hashMapStack.size() - 1;

        while (stackLevel >= 0) {
            if (this.hashMapStack.elementAt(stackLevel).get(name) != null) {
                symbols.add((FunctionDeclarationNode) this.hashMapStack.elementAt(stackLevel).get(name));
                if (functionCounter != 1) {
                    for (int i = 1; i < functionCounter; i++)
                        symbols.add((FunctionDeclarationNode) this.hashMapStack.elementAt(stackLevel).get(i + name));
                }
            }

            stackLevel -= 1;
        }

        return symbols;
    }

    public void printSymbolTable() {
        System.out.println("Symbol table:\n----------------------------------");
        System.out.println("Size of stack: " + hashMapStack.size());
        for (HashMap<String, ASTnode> hashMap : hashMapStack) {
            for (Map.Entry<String, ASTnode> entry : hashMap.entrySet()) {
                System.out.println(entry);
            }
        }
        System.out.println("----------------------------------");
    }

    /*      VISITOR         */
    public void visitProgram(ProgramNode programNode) {
        openScope();

        // Enter global variables for every block to use
        enterSymbol(this.listOfPredefinedVariables.get(0).getVarDeclInitNodes().get(0).getAssignmentNode().getVariableName(), this.listOfPredefinedVariables.get(0));
        enterSymbol(this.listOfPredefinedVariables.get(1).getVarDeclInitNodes().get(0).getAssignmentNode().getVariableName(), this.listOfPredefinedVariables.get(1));

        for (FunctionDeclarationNode functionDeclaration : programNode.getFunctionDeclarationNodes())
            visitFunctionDeclaration(functionDeclaration);
        for (ClassDeclarationNode classDeclaration : programNode.getClassDeclarationNodes())
            visitClassDeclaration(classDeclaration);
        visitMain(programNode.getMainNode());
        System.out.println("gucci gang xd");
    }

    private void visitMain(MainNode mainNode) {
        visitBlock(mainNode.getBlockNode());
    }

    private void visitBlock(BlockNode blockNode) {
        openScope();
        for (StatementNode statement : blockNode.getStatementNodes()) {
            visitStatement(statement);
        }
        closeScope();
    }

    private void visitStatement(StatementNode statementNode) {
        if (statementNode instanceof VariableDeclarationNode)
            visitVariableDeclaration((VariableDeclarationNode) statementNode);
        else if (statementNode instanceof ObjectDeclarationNode)
            visitObjectDeclaration((ObjectDeclarationNode) statementNode);
        else if (statementNode instanceof AssignmentNode)
            visitAssignment((AssignmentNode) statementNode);
        else if (statementNode instanceof NonObjectFunctionCallNode)
            visitNonObjectFunctionCall((NonObjectFunctionCallNode) statementNode);
        else if (statementNode instanceof ObjectFunctionCallNode)
            visitObjectFunctionCall((ObjectFunctionCallNode) statementNode);
        else if (statementNode instanceof IfElseStatementNode)
            visitIfElseStatement((IfElseStatementNode) statementNode);
        else if (statementNode instanceof ForLoopStatementNode)
            visitForLoopStatement((ForLoopStatementNode) statementNode);
    }

    /*      STATEMENTS       */
    private void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {

        for (VarDeclInitNode varDeclInitNode : variableDeclarationNode.getVarDeclInitNodes()) {
            VariableDeclarationNode retrievedNode = null;
            if (retrieveSymbol(varDeclInitNode.getAssignmentNode().getVariableName()) != null)
                retrievedNode = (VariableDeclarationNode) retrieveSymbol(varDeclInitNode.getAssignmentNode().getVariableName());

            if (retrievedNode == null)
                enterSymbol(varDeclInitNode.getAssignmentNode().getVariableName(), variableDeclarationNode);
            //else if (retrievedNode.getCodePosition() == null)
             //   System.out.println(retrievedNode.prettyPrint(0));
            else
                throw new CompilerException("ERROR: A variable (" + varDeclInitNode.getAssignmentNode().getVariableName() + ") with the same name already exists.", retrievedNode.getCodePosition());

            if (varDeclInitNode.getAssignmentNode() != null)
                visitAssignment(varDeclInitNode.getAssignmentNode());
        }
    }

    private void visitObjectDeclaration(ObjectDeclarationNode objectDeclarationNode) {
        String objectType = objectDeclarationNode.getClassName();
        String variableName = objectDeclarationNode.getVariableName();

        ObjectDeclarationNode retrievedNode;
        if (retrieveSymbol(variableName) != null)
            retrievedNode = (ObjectDeclarationNode) retrieveSymbol(variableName);
        else
            retrievedNode = null;

        // Check if the class is custom and check if that class is declared
        if (!listOfPredefinedClasses.contains(objectType)) {
            if (retrieveSymbol(objectType) == null)
                throw new CompilerException("ERROR: An object (" + objectDeclarationNode.getVariableName() + ") is declared with a non-existing class.", objectDeclarationNode.getCodePosition());
        }

        //Check if the constructor is well typed
        if (objectDeclarationNode.getObjectContructorNode() != null)
            visitObjectConstructor(objectDeclarationNode.getObjectContructorNode());

        if (retrieveSymbol(variableName) == null)
            enterSymbol(variableName, objectDeclarationNode);
        else if (retrievedNode != null && !retrievedNode.getClassName().equals(objectType))
            enterSymbol(variableName, objectDeclarationNode);
        else
            throw new CompilerException("ERROR: An object (" + variableName + ") is already declared with the same name and type.", retrieveSymbol(variableName).getCodePosition());
    }

    private void visitObjectConstructor(ObjectContructorNode objectContructorNode) {
        if (objectContructorNode.getNonObjectFunctionCallNode() != null)
            visitNonObjectFunctionCall(objectContructorNode.getNonObjectFunctionCallNode());
        else if (objectContructorNode.getObjectFunctionCallNode() != null)
            visitObjectFunctionCall(objectContructorNode.getObjectFunctionCallNode());
        //Visit every ObjectArgument
        else if (objectContructorNode.getObjectArgumentNodePlural() != null) {
            //Get all the Arguments
            ArrayList<ObjectArgumentNode> objectArgumentNodes = objectContructorNode.getObjectArgumentNodePlural().getObjectArgumentNodes();
            //For every Argument, get the LowPrecedence for which we get every HighPrecedence, for which we get every AtomPrecedence, for which we typecheck every operand
            for (ObjectArgumentNode objectArgumentNode : objectArgumentNodes) {
                LowPrecedenceNode currentLowPrecedence = objectArgumentNode.getLowPrecedence();
                for (HighPrecedenceNode highPrecedenceNode : currentLowPrecedence.getHighPrecedenceNodes()) {
                    for (AtomPrecedenceNode atomPrecedenceNode : highPrecedenceNode.getAtomPrecedenceNodes()) {
                        ArithOperandNode currentArg = atomPrecedenceNode.getOperand();

                        if (currentArg.getNonObjectFunctionCallNode() != null)
                            visitNonObjectFunctionCall(currentArg.getNonObjectFunctionCallNode());
                        else if (currentArg.getObjectFunctionCallNode() != null)
                            visitObjectFunctionCall(currentArg.getObjectFunctionCallNode());
                        else if (currentArg.getVariableName() != null)
                            visitVariableName(currentArg.getVariableName());
                        else if (currentArg.getVector2ExpressionNode() != null)
                            visitVector2Expression(currentArg.getVector2ExpressionNode());
                        else if (currentArg.getVector3ExpressionNode() != null)
                            visitVector3Expression(currentArg.getVector3ExpressionNode());
                        else if (currentArg.getVector4ExpressionNode() != null)
                            visitVector4Expression(currentArg.getVector4ExpressionNode());
                        else if (currentArg.getRealNumberNode() != null || currentArg.getSwizzleNode() != null) {
                            //do nothing
                        }
                        else
                            throw new CompilerException("ERROR Invalid Constructor Argument in (" + objectContructorNode.prettyPrint(0) + ")");
                    }
                }
            }
        }
        else
            throw new CompilerException("ERROR: Invalid constructor for object, must be 0 or more arguments or function", objectContructorNode.getCodePosition());
    }

    private void visitAssignment(AssignmentNode assignmentNode) {
        String variableName;
        Enums.DataType dataType;

        if (assignmentNode.getVariableName() != null) {
            variableName = assignmentNode.getVariableName();
            VariableDeclarationNode variableDeclarationNode = (VariableDeclarationNode) retrieveSymbol(variableName);

            if (variableDeclarationNode != null)
                dataType = variableDeclarationNode.getDataType();
            else
                dataType = null;

            if (retrieveSymbol(variableName) == null)
                throw new CompilerException("ERROR: Variable (" + variableName + ") on left side of assignment is not declared.", assignmentNode.getCodePosition());

            if (assignmentNode.getExpressionNode() != null) {
                Enums.DataType assignedDataType = null;
                if (assignmentNode.getExpressionNode() instanceof BoolExpressionNode) {
                    assignedDataType = Enums.DataType.BOOL;
                } else if (assignmentNode.getExpressionNode() instanceof ArithExpressionNode) {
                    assignedDataType = visitLowPrecedenceNode(((ArithExpressionNode) assignmentNode.getExpressionNode()).getLowPrecedenceNode());
                }
                if (dataType != null && assignedDataType != null && !assignedDataType.equals(dataType))
                    throw new CompilerException("ERROR: Incompatible types.(" + dataType + " and " + assignedDataType + ")", assignmentNode.getCodePosition());
            }
        }
        else if (assignmentNode.getSwizzleNode() != null) {
            visitSwizzle(assignmentNode.getSwizzleNode());
        }

        visitExpression(assignmentNode.getExpressionNode());
    }

    private void visitNonObjectFunctionCall(NonObjectFunctionCallNode nonObjectFunctionCallNode) {
        String functionName = nonObjectFunctionCallNode.getFunctionName();
        ArrayList<ObjectArgumentNode> objectArgumentNodes = nonObjectFunctionCallNode.getArgumentNodes();

        ArrayList<FunctionDeclarationNode> retrievedFunctions;
        if (retrieveAllFunctions(functionName) != null)
            retrievedFunctions = retrieveAllFunctions(functionName);
        else
            retrievedFunctions = null;

        if (retrievedFunctions.size() > 0) {
            boolean matchingSize = true;
            boolean argumentMatch = true;
            for (FunctionDeclarationNode retrievedNode : retrievedFunctions) {
                if (retrievedNode != null) { //TODO: Find reason why this is neccesary (File: IfElseSlaaGraesTest)
                    if (retrievedNode.getFunctionArgNodes() != null && objectArgumentNodes != null) {
                        if (retrievedNode.getFunctionArgNodes().size() != objectArgumentNodes.size())
                            matchingSize = false;
                        else {
                            // Check parameters
                            outerLoop:
                            for (int i = 0; i < objectArgumentNodes.size(); i++) {

                                // Check Ints and Floats
                                if (objectArgumentNodes.get(i).getLowPrecedence() != null) {
                                    LowPrecedenceNode lowPrecedenceNode = objectArgumentNodes.get(i).getLowPrecedence();
                                    for (HighPrecedenceNode highPrecedenceNode : lowPrecedenceNode.getHighPrecedenceNodes()) {
                                        for (AtomPrecedenceNode atomPrecedenceNode : highPrecedenceNode.getAtomPrecedenceNodes()) {

                                            if (atomPrecedenceNode.getOperand().getRealNumberNode() != null) {
                                                if (!retrievedNode.getFunctionArgNodes().get(i).getDataType().equals(Enums.DataType.NUM)) {
                                                    argumentMatch = false;
                                                    break outerLoop;
                                                }
                                            }
                                        }
                                    }
                                }
                            /* Not yet implemented in the AST
                            if (objectArgumentNodes.get(i).getNonObjectFunctionCallNode() != null) {
                                visitNonObjectFunctionCall(objectArgumentNodes.get(i).getNonObjectFunctionCallNode());
                            }
                            */

                            /* Not yet implemented in the AST
                            if (objectArgumentNodes.get(i).getColorFunctionCallNode() != null) {
                                if (!retrievedNode.getFunctionArgNodes().get(i).getDataType().equals(Enums.DataType.VEC3)) {
                                    argumentMatch = false;
                                    break outerLoop;
                                }
                                else {
                                    argumentMatch = true;
                                }
                            }
                             */
                            }
                        }
                    } else if (retrievedNode.getFunctionArgNodes() == null && objectArgumentNodes == null) {
                        enterSymbol(functionName, nonObjectFunctionCallNode);
                        matchingSize = true;
                        break;
                    }
                }
            }
            if (!matchingSize)
                throw new CompilerException("ERROR: The amount of given arguments (" + objectArgumentNodes.size() + ") for the Non-Object function call (" + functionName + ") does \nnot match the amount of required parameters for the function.", retrieveSymbol(functionName).getCodePosition());
            if (!argumentMatch)
                throw new CompilerException("ERROR: The given arguments for the Non-object function call (" + functionName + ") does \nnot match the parameters for the function.", retrieveSymbol(functionName).getCodePosition());
        }
        else {
            if (listOfPredefinedFunctions.contains(functionName)) {
                // predefined function
            }
            else
                throw new CompilerException("ERROR: Non-object function (" + functionName + ") does not exist.", nonObjectFunctionCallNode.getCodePosition());
        }
    }

    private Enums.DataType visitObjectFunctionCall(ObjectFunctionCallNode objectFunctionCallNode) {
        String variableName = objectFunctionCallNode.getObjectVariableName();
        String functionName = objectFunctionCallNode.getFunctionName();
        ArrayList<ObjectArgumentNode> objectArgumentNodes = objectFunctionCallNode.getObjectArguments();
        ObjectDeclarationNode objectDeclarationNode;
        ClassDeclarationNode classDeclarationNode;

        if (!listOfPredefinedClasses.contains(variableName)) {
            
            // Check if variable is declared and initialized
            if (retrieveSymbol(variableName) != null) {
                if (!(retrieveSymbol(variableName) instanceof ObjectDeclarationNode))
                    throw new CompilerException("ERROR: Variable (" + variableName + ") is not an object declaration.", retrieveSymbol(variableName).getCodePosition());
                else
                    objectDeclarationNode = (ObjectDeclarationNode) retrieveSymbol(variableName);
            }
            else
                throw new CompilerException("ERROR: Variable (" + variableName + ") is not declared.");

            if (objectDeclarationNode != null) {

                // If it is a custom object function call
                if (!(listOfPredefinedClasses.contains(objectDeclarationNode.getClassName()))) {
                    classDeclarationNode = (ClassDeclarationNode) retrieveSymbol(objectDeclarationNode.getClassName());
                    boolean existingFunction = false;
                    boolean sameFunction = true;
                    Enums.DataType dataType = null;

                    if (classDeclarationNode != null && classDeclarationNode.getClassBlockNode() != null) {

                        // Check if class has the function used
                        for (FunctionDeclarationNode functionDeclarationNode : classDeclarationNode.getClassBlockNode().getFunctionDeclarationNodes()) {

                            // Look for the function with the same name
                            if (functionDeclarationNode.getFunctionName().equals(functionName)) {
                                existingFunction = true;

                                // Check the data types of the arguments given
                                if (functionDeclarationNode.getFunctionArgNodes() != null) {
                                    ArrayList<FunctionArgNode> functionArgNodes = functionDeclarationNode.getFunctionArgNodes();

                                    // Check each argument if its data type matches the function's parameters
                                    for (int i = 0; i < functionDeclarationNode.getFunctionArgNodes().size(); i++) {
                                        dataType = visitLowPrecedenceNode(objectArgumentNodes.get(i).getLowPrecedence());
                                        if (!(functionArgNodes.get(i).getDataType().equals(dataType))) {
                                            sameFunction = false;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }


                    if (!existingFunction)
                        throw new CompilerException("ERROR: No functions existed with the given function name (" + functionName + ")", classDeclarationNode.getCodePosition());
                    if (!sameFunction)
                        throw new CompilerException("ERROR: No function with the given parameters exists for (" + functionName + ")", classDeclarationNode.getCodePosition());

                    return dataType;
                }
            }
        }
        return null;
    }

    private void visitIfElseStatement(IfElseStatementNode ifElseStatementNode) {
        IfStatementNode ifStatementNode = ifElseStatementNode.getIfStatementNode();

        // Make sure its boolean expression and block/statement is well typed
        visitExpression(ifStatementNode.getIfBool().getBoolExpressionNode());
        if (ifStatementNode.getIfBlock().getBlockNode() != null) {
            visitBlock(ifStatementNode.getIfBlock().getBlockNode());
        }
        else if (ifStatementNode.getIfBlock().getStatementNode() != null) {
            visitStatement(ifStatementNode.getIfBlock().getStatementNode());
        }
        else if (ifStatementNode.getIfBlock().getReturnNode() != null)
            visitReturnStatement(ifStatementNode.getIfBlock().getReturnNode(), currentFuncNode);

        // Check if there are any Else-if statements and do the same for Else-if statements as for If statements
        if (ifElseStatementNode.getElseIfStatementNodes() != null) {
            for (ElseIfStatementNode elseIfStatementNode : ifElseStatementNode.getElseIfStatementNodes()) {
                visitExpression(elseIfStatementNode.getElseIfBool().getBoolExpressionNode());
                if (elseIfStatementNode.getElseIfBlock().getBlockNode() != null) {
                    visitBlock(elseIfStatementNode.getElseIfBlock().getBlockNode());
                }
                else if (elseIfStatementNode.getElseIfBlock().getStatementNode() != null) {
                    visitStatement(elseIfStatementNode.getElseIfBlock().getStatementNode());
                }
                else if (elseIfStatementNode.getElseIfBlock().getReturnNode() != null)
                    visitReturnStatement(elseIfStatementNode.getElseIfBlock().getReturnNode(), currentFuncNode);
            }
        }

        // Check if there are Else statements and do the same for it as for Else-if and If
        if (ifElseStatementNode.getElseStatementNode() != null) {
            if (ifElseStatementNode.getElseStatementNode().getElseBlock().getBlockNode() != null) {
                visitBlock(ifElseStatementNode.getElseStatementNode().getElseBlock().getBlockNode());
            }
            else if (ifElseStatementNode.getElseStatementNode().getElseBlock().getStatementNode() != null) {
                visitStatement(ifElseStatementNode.getElseStatementNode().getElseBlock().getStatementNode());
            }
            else if (ifElseStatementNode.getElseStatementNode().getElseBlock().getReturnNode() != null)
                visitReturnStatement(ifElseStatementNode.getElseStatementNode().getElseBlock().getReturnNode(), currentFuncNode);
        }
    }

    //Was used to pull assignments out of if's an return them to variable declarations
    /*private void initVariable(ArrayList<StatementNode> statementNodes) {
        for (StatementNode statementNode : statementNodes) {
            initVariable(statementNode);
        }
    }

    //Return assignment to declaration
    private void initVariable(StatementNode statementNode) {
        if (statementNode instanceof AssignmentNode) {
            AssignmentNode assignmentNode = (AssignmentNode) statementNode;
            ASTnode varDecl = retrieveSymbol(assignmentNode.getVariableName());
            if (varDecl instanceof VariableDeclarationNode) {
                VarDeclInitNode newAssign = new VarDeclInitNode(assignmentNode);
                ArrayList<VarDeclInitNode> varDeclInitNodes = new ArrayList<>();
                varDeclInitNodes.add(newAssign);
                VariableDeclarationNode variableDeclarationNode = (VariableDeclarationNode) varDecl;
                variableDeclarationNode.setVarDeclInitNodes(varDeclInitNodes);
                enterSymbol(assignmentNode.getVariableName(), variableDeclarationNode);
            }
        }
    }
    */

    private void visitForLoopStatement(ForLoopStatementNode forLoopStatementNode) {
        ForLoopExpressionNode forLoopExpression1 = forLoopStatementNode.getForLoopExpressionNode1();
        ForLoopExpressionNode forLoopExpression2 = forLoopStatementNode.getForLoopExpressionNode2();

        // Visit expression and check if they are well typed
        visitForLoopExpression(forLoopExpression1);
        visitForLoopExpression(forLoopExpression2);

        if (forLoopStatementNode.getConditionalBlockNode().getBlockNode() != null)
            visitBlock(forLoopStatementNode.getConditionalBlockNode().getBlockNode());
        else if (forLoopStatementNode.getConditionalBlockNode().getStatementNode() != null)
            visitStatement(forLoopStatementNode.getConditionalBlockNode().getStatementNode());
    }

    private void visitForLoopExpression(ForLoopExpressionNode forLoopExpressionNode) {
        if (forLoopExpressionNode.getVariableDeclarationNode() != null) {
            VariableDeclarationNode variableDeclarationNode = forLoopExpressionNode.getVariableDeclarationNode();
            if (!variableDeclarationNode.getDataType().equals(Enums.DataType.NUM))
                throw new CompilerException("ERROR: Variable is of an incompatible type for ForLoop", variableDeclarationNode.getCodePosition());
            else
                visitVariableDeclaration(variableDeclarationNode);
        }
        else if (forLoopExpressionNode.getAssignmentNode() != null) {
            visitAssignment(forLoopExpressionNode.getAssignmentNode());
        }
        else if (retrieveSymbol(forLoopExpressionNode.getVariableName()) != null) {
            VariableDeclarationNode variableDeclarationNode = (VariableDeclarationNode) retrieveSymbol(forLoopExpressionNode.getVariableName());
            if (variableDeclarationNode == null)
                throw new CompilerException("ERROR: Variable in ForLoop is not declared.", variableDeclarationNode.getCodePosition());
            else if (variableDeclarationNode.getVarDeclInitNodes().get(0).getAssignmentNode() == null)
                throw new CompilerException("ERROR: Variable in ForLoop is not initialized.", variableDeclarationNode.getCodePosition());
            else if (!variableDeclarationNode.getDataType().equals(Enums.DataType.NUM)) {
                throw new CompilerException("ERROR: Variable is of an illegal type for the ForLoop.", variableDeclarationNode.getCodePosition());
            }
        }
        else if (forLoopExpressionNode.getAtomPrecedenceNode() != null) {
            //Type is ok
        }
        else
            throw new CompilerException("ERROR: Invalid ForLoop expression", forLoopExpressionNode.getCodePosition());
    }

    /*      FUNCTIONS        */
    private void visitFunctionDeclaration(FunctionDeclarationNode functionDeclarationNode) {
        String functionName = functionDeclarationNode.getFunctionName();
        ArrayList<FunctionArgNode> functionArgs = functionDeclarationNode.getFunctionArgNodes();
        Enums.DataType returnType = functionDeclarationNode.getReturnType();

        ArrayList<FunctionDeclarationNode> retrievedFunctions;
        if (retrieveAllFunctions(functionName) != null)
            retrievedFunctions = retrieveAllFunctions(functionName);
        else
            retrievedFunctions = null;

        // Same name
        if (retrievedFunctions == null)
            enterSymbol(functionName, functionDeclarationNode);

        if (retrievedFunctions != null) {
            boolean sameReturnType = true;
            boolean sameFunctionArgs = false;
            boolean sameAmountOfArgs = false;

            outerloop:
            for (FunctionDeclarationNode retrievedNode : retrievedFunctions) {
                sameReturnType = retrievedNode.getReturnType() == returnType;
                sameAmountOfArgs = retrievedNode.getFunctionArgNodes() == null && functionArgs == null;

                if (retrievedNode.getFunctionArgNodes() != null && functionArgs != null)  {
                    if (retrievedNode.getFunctionArgNodes().size() == functionArgs.size()) {
                        for (int i = 0; i < functionArgs.size(); i++) {
                            if (functionArgs.get(i).getDataType() != null) {
                                if (retrievedNode.getFunctionArgNodes().get(i).getDataType() != null) {
                                    if (functionArgs.get(i).getDataType().equals(retrievedNode.getFunctionArgNodes().get(i).getDataType())) {
                                        sameFunctionArgs = true;
                                        break outerloop;
                                    }
                                }
                            }
                            else if (functionArgs.get(i).getClassName() != null) {
                                if (retrievedNode.getFunctionArgNodes().get(i).getClassName() != null) {
                                    if (functionArgs.get(i).getClassName().equals(retrievedNode.getFunctionArgNodes().get(i).getClassName())) {
                                        sameFunctionArgs = true;
                                        break outerloop;
                                    }
                                }
                            }

                        }
                    }
                }
            }

            if (sameFunctionArgs)
                throw new CompilerException("ERROR: A function with the same name (" + functionName + ") and arguments already exists.", retrieveSymbol(functionName).getCodePosition());
            if (!sameReturnType)
                throw new CompilerException("ERROR: A function with the same name (" + functionName + ") with a different return type already exists.", retrieveSymbol(functionName).getCodePosition());
            if (sameAmountOfArgs)
                throw new CompilerException("ERROR: A function with the same name (" + functionName + ") and type (" + returnType + ") already exists.", retrieveSymbol(functionName).getCodePosition());

            enterSymbol(functionName, functionDeclarationNode);
        }

        visitFunctionBlock(functionDeclarationNode.getBlockNode(), functionDeclarationNode.getReturnType(), functionDeclarationNode);
    }

    private void visitFunctionBlock(BlockNode blockNode, Enums.DataType returnType, FunctionDeclarationNode functionDeclarationNode) {
        openScope();

        //Visit all function arguments and add them as Variable Declarations in the new scope
        if (functionDeclarationNode.getFunctionArgNodes() != null) {
            for (FunctionArgNode functionArgNode : functionDeclarationNode.getFunctionArgNodes()) {

                //Initialize VarDecl to null, as it should already be checked
                AssignmentNode assignmentNode = new AssignmentNode(functionArgNode.getVariableName(), null);
                VarDeclInitNode varDeclInitNode = new VarDeclInitNode(assignmentNode);
                VariableDeclarationNode variableDeclarationNode = new VariableDeclarationNode(functionArgNode.getDataType(), varDeclInitNode);
                visitVariableDeclaration(variableDeclarationNode);
            }
        }

        for (StatementNode statement : blockNode.getStatementNodes()) {
            visitStatement(statement);
        }
        if (returnType != null) {
            this.currentFuncNode = functionDeclarationNode;
            for (StatementNode statementNode : blockNode.getStatementNodes()) {
                if (statementNode instanceof ReturnNode) {
                    visitReturnStatement((ReturnNode) statementNode, functionDeclarationNode);
                }
            }
            //check if last statement is returnStatement
            if (blockNode.getStatementNodes().get(blockNode.getStatementNodes().size()-1) instanceof ReturnNode) {
                ReturnNode finalReturn = (ReturnNode) blockNode.getStatementNodes().get(blockNode.getStatementNodes().size()-1);
                visitReturnStatement(finalReturn, functionDeclarationNode);
            }
            else
                throw new CompilerException("ERROR: Last statement of non-void function (" + functionDeclarationNode.getFunctionName() + ") has to be return", functionDeclarationNode.getCodePosition());

        }
        closeScope();
    }

    private void visitReturnStatement(ReturnNode returnNode, FunctionDeclarationNode functionDeclarationNode) {
        ExpressionNode expressionNode = returnNode.getExpressionNode();
        Enums.DataType returnType = functionDeclarationNode.getReturnType();
        LowPrecedenceNode lowPrecedenceNode;

        if (expressionNode instanceof ArithExpressionNode) {
            lowPrecedenceNode = ((ArithExpressionNode) expressionNode).getLowPrecedenceNode();
            Enums.DataType dataType = visitLowPrecedenceNode(lowPrecedenceNode);

            if (dataType != null && !dataType.equals(returnType))
                throw new CompilerException("ERROR: Return statement does not match the return type (" + returnType + ") of the function", expressionNode.getCodePosition());
        }
        else if (expressionNode instanceof BoolExpressionNode && returnType.equals(Enums.DataType.BOOL))
            visitExpression(expressionNode);
        else if (expressionNode instanceof TernaryOperatorNode) {
            // ternary
        }
        else if (expressionNode instanceof  Vector4ExpressionNode && returnType.equals(Enums.DataType.VEC4))
            visitExpression(expressionNode);
        else if (expressionNode instanceof  Vector3ExpressionNode && returnType.equals(Enums.DataType.VEC3))
            visitExpression(expressionNode);
        else if (expressionNode instanceof  Vector2ExpressionNode && returnType.equals(Enums.DataType.VEC2))
            visitExpression(expressionNode);
        else
            throw new CompilerException("ERROR: Return statement does not match the return type (" + returnType + ") of the function", expressionNode.getCodePosition());
    }
// ternary operator, bool
    /*      Expressions      */
    private void visitExpression(ExpressionNode expressionNode) {

        LowPrecedenceNode lowPrecedenceNode;
        if (expressionNode instanceof ArithExpressionNode) {
            lowPrecedenceNode = ((ArithExpressionNode) expressionNode).getLowPrecedenceNode();
            visitLowPrecedenceNode(lowPrecedenceNode); //TODO: this does nothing?
        }
        else if (expressionNode instanceof BoolExpressionNode)
            visitBoolExpression((BoolExpressionNode) expressionNode);
        else if (expressionNode instanceof TernaryOperatorNode)
            visitTernaryOperator((TernaryOperatorNode) expressionNode);
        else if (expressionNode instanceof  Vector4ExpressionNode)
            visitVector4Expression((Vector4ExpressionNode) expressionNode);
        else if (expressionNode instanceof  Vector3ExpressionNode)
            visitVector3Expression((Vector3ExpressionNode) expressionNode);
        else if (expressionNode instanceof  Vector2ExpressionNode)
            visitVector2Expression((Vector2ExpressionNode) expressionNode);
    }

    private Enums.DataType visitLowPrecedenceNode(LowPrecedenceNode lowPrecedenceNode) {
        for (HighPrecedenceNode highPrecedenceNode : lowPrecedenceNode.getHighPrecedenceNodes()) {
            for (AtomPrecedenceNode atomPrecedenceNode : highPrecedenceNode.getAtomPrecedenceNodes()) {

                if (atomPrecedenceNode.getOperand() != null) {
                    // Operand: Variable name
                    if (atomPrecedenceNode.getOperand().getVariableName() != null) {
                        String variableName = atomPrecedenceNode.getOperand().getVariableName();

                        visitVariableName(variableName);
                        VariableDeclarationNode variableDeclarationNode = (VariableDeclarationNode) retrieveSymbol(variableName);
                        if (variableDeclarationNode != null)
                            return variableDeclarationNode.getDataType();
                    }

                    // Operand: Non-object function Call
                    if (atomPrecedenceNode.getOperand().getNonObjectFunctionCallNode() != null) {
                        NonObjectFunctionCallNode nonObjectFunctionCallNode = atomPrecedenceNode.getOperand().getNonObjectFunctionCallNode();
                        visitNonObjectFunctionCall(atomPrecedenceNode.getOperand().getNonObjectFunctionCallNode());

                        // The reason for not checking all functions is because a function with a given name can only have one return type.
                        // It is not legal to have another function with the same name but with a different return type.
                        FunctionDeclarationNode functionDeclarationNode = (FunctionDeclarationNode) retrieveSymbol(nonObjectFunctionCallNode.getFunctionName());
                        if (functionDeclarationNode != null)
                            return functionDeclarationNode.getReturnType();
                    }

                    // Operand: Object function Call
                    if (atomPrecedenceNode.getOperand().getObjectFunctionCallNode() != null) {
                        ObjectFunctionCallNode objectFunctionCallNode = atomPrecedenceNode.getOperand().getObjectFunctionCallNode();
                        return visitObjectFunctionCall(objectFunctionCallNode);
                    }

                // Operand: Swizzle
                if (atomPrecedenceNode.getOperand().getSwizzleNode() != null) {
                    SwizzleNode swizzleNode = atomPrecedenceNode.getOperand().getSwizzleNode();
                    visitSwizzle(swizzleNode);
                    int swizzleLength = 0;

                    if (swizzleNode.getSwizzle() != null)
                        swizzleLength = swizzleNode.getSwizzle().length();

                        if (swizzleLength == 4)
                            return Enums.DataType.VEC4;
                        else if (swizzleLength == 3)
                            return Enums.DataType.VEC3;
                        else if (swizzleLength == 2)
                            return Enums.DataType.VEC2;
                        else if (swizzleLength == 1)
                            return Enums.DataType.NUM;
                        else
                            throw new CompilerException("ERROR: Too long swizzle", swizzleNode.getCodePosition());
                    }

                    if (atomPrecedenceNode.getOperand().getRealNumberNode() != null)
                        return Enums.DataType.NUM;

                    // Operand: Low precedence
                    if (atomPrecedenceNode.getLowPrecedenceNode() != null)
                        return visitLowPrecedenceNode(atomPrecedenceNode.getLowPrecedenceNode());
                }
            }
        }
        return null;
    }

    private void visitBoolExpression(BoolExpressionNode boolExpressionNode) {

        BoolOperationsNode boolOperationsNode = boolExpressionNode.getBoolOperationsNode();

        BoolOperationNode boolOperationNode = boolOperationsNode.getBoolOperationNode();
        ArrayList<BoolOperationExtendNode> boolOperationExtendNodes = boolOperationsNode.getBoolOperationExtendNodes();
    }

    private void visitTernaryOperator(TernaryOperatorNode ternaryOperatorNode) {
        visitExpression(ternaryOperatorNode.getBoolExpressionNode());
        visitExpression(ternaryOperatorNode.getExpressionNode1());
        visitExpression(ternaryOperatorNode.getExpressionNode2());
    }

    private void visitVector4Expression(Vector4ExpressionNode vector4ExpressionNode) {
        visitExpression(vector4ExpressionNode.getArithExpressionNode1());
        visitExpression(vector4ExpressionNode.getArithExpressionNode2());
        visitExpression(vector4ExpressionNode.getArithExpressionNode3());
        visitExpression(vector4ExpressionNode.getArithExpressionNode4());
    }

    private void visitVector3Expression(Vector3ExpressionNode vector3ExpressionNode) {
        visitExpression(vector3ExpressionNode.getArithExpressionNode1());
        visitExpression(vector3ExpressionNode.getArithExpressionNode2());
        visitExpression(vector3ExpressionNode.getArithExpressionNode3());
    }

    private void visitVector2Expression(Vector2ExpressionNode vector2ExpressionNode) {
        visitExpression(vector2ExpressionNode.getArithExpressionNode1());
        visitExpression(vector2ExpressionNode.getArithExpressionNode2());
    }

    private void visitSwizzle(SwizzleNode swizzleNode) {
        String variableName = swizzleNode.getVariableName();
        Enums.DataType dataType;
        String swizzle;

        // Check if variable is declared and initialized
        visitVariableName(variableName);

        // Check if variable is a vector
        VariableDeclarationNode variableDeclarationNode = (VariableDeclarationNode) retrieveSymbol(variableName);
        if (variableDeclarationNode != null) {

            dataType = variableDeclarationNode.getDataType();
            if (!(dataType.equals(Enums.DataType.VEC4))) {
                if (!(dataType.equals(Enums.DataType.VEC3))) {
                    if (!(dataType.equals(Enums.DataType.VEC2))) {
                        if (!(dataType.equals(Enums.DataType.NUM)))
                        throw new CompilerException("ERROR: Variable (" + variableName + ") is not of a vector or num type", variableDeclarationNode.getCodePosition());
                    }
                }
            }
        }
        // Not used - is checked in visitVariableName
        else
            throw new CompilerException("Variable (" + variableName + ") is not declared.", variableDeclarationNode.getCodePosition());

        if (swizzleNode.getSwizzle() != null) {
            swizzle = swizzleNode.getSwizzle();

            if (swizzle.contains("w") || swizzle.contains("a")) {
                if (!dataType.equals(Enums.DataType.VEC4)) {
                    throw new CompilerException("ERROR: w or a in swizzle, but it's not a Vec4.", swizzleNode.getCodePosition());
                }
            }

            if (swizzle.contains("z") || swizzle.contains("b")) {
                if (!dataType.equals(Enums.DataType.VEC3) && !dataType.equals(Enums.DataType.VEC4)) {
                    throw new CompilerException("ERROR: z or b in swizzle, but it's not a Vec3 or Vec4.", swizzleNode.getCodePosition());
                }
            }

            if (swizzle.contains("y") || swizzle.contains("g")) {
                if (dataType.equals(Enums.DataType.NUM)) {
                    throw new CompilerException("ERROR: y or g in swizzle, but it's a Num.", swizzleNode.getCodePosition());
                }
            }
        }
    }

    /*      CLASSES          */
    private void visitClassDeclaration(ClassDeclarationNode classDeclarationNode) {
        String className = classDeclarationNode.getClassName();

        if (retrieveSymbol(className) == null && !this.listOfPredefinedClasses.contains(className))
            enterSymbol(className, classDeclarationNode);
        else
            throw new CompilerException("ERROR: Class name (" + className + ") is already in use.", classDeclarationNode.getCodePosition());

        visitClassBlock(classDeclarationNode.getClassBlockNode());
    }

    private void visitClassBlock(ClassBlockNode classBlockNode) {
        openScope();
        for (DeclarationNode declarationNode : classBlockNode.getDeclarationNodes()) {
            if (declarationNode instanceof VariableDeclarationNode)
                visitVariableDeclaration((VariableDeclarationNode) declarationNode);
            //else if (declarationNode instanceof ObjectDeclarationNode)
               // visitObjectDeclaration((ObjectDeclarationNode) declarationNode);
        }
        for (FunctionDeclarationNode functionDeclarationNode : classBlockNode.getFunctionDeclarationNodes()) {
            visitFunctionDeclaration(functionDeclarationNode);
        }
        closeScope();
    }

    /*      MISC         */
    private void visitVariableName(String variableName) {
        if (retrieveSymbol(variableName) == null)
            throw new CompilerException("ERROR: Variable (" + variableName + ") is not declared");
        else if (retrieveSymbol(variableName) != null) {
            VariableDeclarationNode variableDeclarationNode = (VariableDeclarationNode) retrieveSymbol(variableName);

            if (variableDeclarationNode != null)
                for (VarDeclInitNode varDeclInitNode : variableDeclarationNode.getVarDeclInitNodes()) {
                    if (varDeclInitNode.getAssignmentNode() != null) {
                        if (varDeclInitNode.getAssignmentNode().getVariableName().equals(variableName))
                            return;
                    }
                }
                throw new CompilerException("ERROR: Variable (" + variableName + ") is not initialized", variableDeclarationNode.getCodePosition());
        }
    }
}
