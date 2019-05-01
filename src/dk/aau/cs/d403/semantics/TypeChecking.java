package dk.aau.cs.d403.semantics;

import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.ast.statements.*;
import dk.aau.cs.d403.ast.structure.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TypeChecking {
    private Stack<HashMap<String, ASTnode>> hashMapStack;
    private Integer functionCounter = 1;

    private ArrayList<String> listOfPredefinedClasses;

    public TypeChecking() {
        this.hashMapStack = new Stack<>();
        this.listOfPredefinedClasses = new ArrayList<>();

        this.listOfPredefinedClasses.add("Circle");
        this.listOfPredefinedClasses.add("Rectangle");
        this.listOfPredefinedClasses.add("Triangle");
        this.listOfPredefinedClasses.add("Square");
        this.listOfPredefinedClasses.add("Shape");
        this.listOfPredefinedClasses.add("Color");
        this.listOfPredefinedClasses.add("CircleGradient");
        this.listOfPredefinedClasses.add("LineGradient");
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
        for (FunctionDeclarationNode functionDeclaration : programNode.getFunctionDeclarationNodes())
            visitFunctionDeclaration(functionDeclaration);
        for (ClassDeclarationNode classDeclaration : programNode.getClassDeclarationNodes())
            visitClassDeclaration(classDeclaration);
        visitMain(programNode.getMainNode());
    }

    public void visitMain(MainNode mainNode) {
        visitBlock(mainNode.getBlockNode());
    }

    public void visitBlock(BlockNode blockNode) {
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
        /*
        else if (statementNode instanceof ObjectFunctionCallNode)
            visitObjectFunctionCall((ObjectFunctionCallNode) statementNode);
            */
        else if (statementNode instanceof IfElseStatementNode)
            visitIfElseStatement((IfElseStatementNode) statementNode);
        else if (statementNode instanceof ForLoopStatementNode)
            visitForLoopStatement((ForLoopStatementNode) statementNode);
    }

    /*      STATEMENTS       */
    private void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
        String variableName = variableDeclarationNode.getVariableName();
        Enums.DataType dataType = variableDeclarationNode.getDataType();

        VariableDeclarationNode retrievedNode = null;
        if (retrieveSymbol(variableName) != null)
            retrievedNode = (VariableDeclarationNode) retrieveSymbol(variableName);

        if (retrievedNode == null)
            enterSymbol(variableName, variableDeclarationNode);
        else if (!dataType.equals(retrievedNode.getDataType()))
            enterSymbol(variableName, variableDeclarationNode);
        else
            throw new RuntimeException("ERROR: A variable with the same name and type already exists.");

        if (variableDeclarationNode.getAssignmentNode() != null)
            visitAssignment(variableDeclarationNode.getAssignmentNode());
    }

    private void visitObjectDeclaration(ObjectDeclarationNode objectDeclarationNode) {
        String objectType = objectDeclarationNode.getObjectType();
        String variableName = objectDeclarationNode.getVariableName();

        ObjectDeclarationNode retrievedNode;
        if (retrieveSymbol(variableName) != null)
            retrievedNode = (ObjectDeclarationNode) retrieveSymbol(variableName);
        else
            retrievedNode = null;

        // Check if the class is custom and check if that class is declared
        if (!listOfPredefinedClasses.contains(objectType)) {
            if (retrieveSymbol(objectType) == null)
                throw new RuntimeException("ERROR: An object is declared with a non-existing class.");
        }

        if (retrieveSymbol(variableName) == null)
            enterSymbol(variableName, objectDeclarationNode);
        else if (retrievedNode != null && !retrievedNode.getObjectType().equals(objectType))
            enterSymbol(variableName, objectDeclarationNode);
        else
            throw new RuntimeException("ERROR: An object is already declared with the same name and type.");
    }

    private void visitAssignment(AssignmentNode assignmentNode) {
        String variableName = assignmentNode.getVariableName();

        if (retrieveSymbol(variableName) == null)
            throw new RuntimeException("ERROR: Variable on left side of assignment is not initialized.");

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

        if (retrievedFunctions != null) {
            boolean matchingSize = false;
            boolean argumentMatch = false;
            for (FunctionDeclarationNode retrievedNode : retrievedFunctions) {
                if (retrievedNode.getFunctionArgNodes() != null && objectArgumentNodes != null) {
                    if (retrievedNode.getFunctionArgNodes().size() == objectArgumentNodes.size()) {
                        matchingSize = true;

                        // Check parameters
                        outerLoop:
                        for (int i = 0; i < objectArgumentNodes.size(); i++) {

                            // Check Ints and Floats
                            if (objectArgumentNodes.get(i).getLowPrecedence() != null) {
                                LowPrecedenceNode lowPrecedenceNode = objectArgumentNodes.get(i).getLowPrecedence();
                                for (HighPrecedenceNode highPrecedenceNode : lowPrecedenceNode.getHighPrecedenceNodes()) {
                                    for (AtomPrecedenceNode atomPrecedenceNode : highPrecedenceNode.getAtomPrecedenceNodes()) {

                                        if (atomPrecedenceNode.getOperand().getRealNumberNode() != null) {
                                            if (!retrievedNode.getFunctionArgNodes().get(i).getDataType().equals(Enums.DataType.INT) && !retrievedNode.getFunctionArgNodes().get(i).getDataType().equals(Enums.DataType.FLOAT)) {
                                                argumentMatch = false;
                                                break outerLoop;
                                            }
                                            else
                                                argumentMatch = true;
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
                }
                else if (retrievedNode.getFunctionArgNodes() == null && objectArgumentNodes == null) {
                    enterSymbol(functionName, nonObjectFunctionCallNode);
                    matchingSize = true;
                    break;
                }
                else
                    throw new RuntimeException("ERROR: Non-object function does not exist with no parameters.");
            }
            if (!matchingSize)
                throw new RuntimeException("ERROR: The amount of given arguments for the Non-Object function call does not match the amount of required parameters for the function.");
            if (!argumentMatch)
                throw new RuntimeException("ERROR: The given arguments for the Non-object function call does not match the parameters for the function.");
        }
        else {
            throw new RuntimeException("ERROR: Non-object function does not exist.");
        }
    }

    private void visitIfElseStatement(IfElseStatementNode ifElseStatementNode) {
        IfStatementNode ifStatementNode = ifElseStatementNode.getIfStatementNode();

        // Make sure its boolean expression and block/statement is well typed
        visitExpression(ifStatementNode.getIfBool());
        if (ifStatementNode.getIfBlock() != null)
            visitBlock(ifStatementNode.getIfBlock());
        else
            visitStatement(ifStatementNode.getIfStatement());

        // Check if there are any Else-if statements and do the same for Else-if statements as for If statements
        if (ifElseStatementNode.getElseIfStatementNodes() != null) {
            for (ElseIfStatementNode elseIfStatementNode : ifElseStatementNode.getElseIfStatementNodes()) {
                visitExpression(elseIfStatementNode.getElseIfBool());
                if (elseIfStatementNode.getElseIfBlock() != null)
                    visitBlock(elseIfStatementNode.getElseIfBlock());
                else
                    visitStatement(elseIfStatementNode.getElseIfStatement());
            }
        }

        // Check if there are an Else statements and do the same for it as for Else-if and If
        if (ifElseStatementNode.getElseStatementNode() != null) {
            if (ifElseStatementNode.getElseStatementNode().getElseBlock() != null)
                visitBlock(ifElseStatementNode.getElseStatementNode().getElseBlock());
            else
                visitStatement(ifElseStatementNode.getElseStatementNode().getElseStatement());
        }
    }

    private void visitForLoopStatement(ForLoopStatementNode forLoopStatementNode) {
        ForLoopExpressionNode forLoopExpression1 = forLoopStatementNode.getForLoopExpressionNode1();
        ForLoopExpressionNode forLoopExpression2 = forLoopStatementNode.getForLoopExpressionNode2();

        // Visit expression and check if they are well typed
        visitForLoopExpression(forLoopExpression1);
        visitForLoopExpression(forLoopExpression2);

        if (forLoopStatementNode.getBlockNode() != null)
            visitBlock(forLoopStatementNode.getBlockNode());
        else if (forLoopStatementNode.getStatementNode() != null)
            visitStatement(forLoopStatementNode.getStatementNode());
    }

    private void visitForLoopExpression(ForLoopExpressionNode forLoopExpressionNode) {
        if (forLoopExpressionNode.getVariableDeclarationNode() != null) {
            VariableDeclarationNode variableDeclarationNode = forLoopExpressionNode.getVariableDeclarationNode();
            if (!variableDeclarationNode.getDataType().equals(Enums.DataType.INT) && !variableDeclarationNode.getDataType().equals(Enums.DataType.FLOAT))
                throw new RuntimeException("ERROR: Variable is of an incompatible type for ForLoop");
            else
                visitVariableDeclaration(variableDeclarationNode);
        }
        else if (forLoopExpressionNode.getAssignmentNode() != null) {
            visitAssignment(forLoopExpressionNode.getAssignmentNode());
        }
        else if (retrieveSymbol(forLoopExpressionNode.getVariableName()) != null) {
            VariableDeclarationNode variableDeclarationNode = (VariableDeclarationNode) retrieveSymbol(forLoopExpressionNode.getVariableName());
            if (variableDeclarationNode == null)
                throw new RuntimeException("ERROR: Variable in ForLoop is not declared.");
            else if (variableDeclarationNode.getAssignmentNode() == null)
                throw new RuntimeException("ERROR: Variable in ForLoop is not initialized.");
            else if (!variableDeclarationNode.getDataType().equals(Enums.DataType.INT) && !variableDeclarationNode.getDataType().equals(Enums.DataType.FLOAT)) {
                throw new RuntimeException("ERROR: Variable is of an illegal type for the ForLoop.");
            }
        }
        else
            throw new RuntimeException("ERROR: Invalid ForLoop expression");
    }

    /*      FUNCTIONS        */
    private void visitFunctionDeclaration(FunctionDeclarationNode functionDeclarationNode) {
        String functionName = functionDeclarationNode.getFunctionName();
        ArrayList<FunctionArgNode> functionArgs = functionDeclarationNode.getFunctionArgNodes();

        FunctionDeclarationNode retrievedNode;
        if (retrieveSymbol(functionName) != null)
            retrievedNode = (FunctionDeclarationNode) retrieveSymbol(functionName);
        else
            retrievedNode = null;

        // Same name
        if (retrievedNode == null)
            enterSymbol(functionName, functionDeclarationNode);
        else if (retrievedNode.getFunctionArgNodes() != null && functionArgs != null)  {
            boolean unique = false;
            if (retrievedNode.getFunctionArgNodes().size() == functionArgs.size()) {
                for (int i = functionArgs.size(); i > 0; i--) {
                    if (!functionArgs.get(i - 1).prettyPrint().equals(retrievedNode.getFunctionArgNodes().get(i - 1).prettyPrint())) {
                        unique = true;
                        break;
                    }
                }
                if (unique)
                    enterSymbol(functionName, functionDeclarationNode);
                else
                    throw new RuntimeException("ERROR: A function with the same name and arguments already exists.");
            }
            else
                enterSymbol(functionName, functionDeclarationNode);

        }
        else if (retrievedNode.getFunctionArgNodes() == null) {
            if (functionArgs != null)
                enterSymbol(functionName, functionDeclarationNode);
            else
                throw new RuntimeException("ERROR: A function with the same name already exists.");
        }
        else if (retrievedNode.getFunctionArgNodes() != null) {
            enterSymbol(functionName, functionDeclarationNode);
        }
        else
            throw new RuntimeException("ERROR: A function with the same name already exists.");

        visitFunctionBlock(functionDeclarationNode.getBlockNode(), functionDeclarationNode.getReturnType());
    }

    private void visitFunctionBlock(BlockNode blockNode, Enums.ReturnType returnType) {
        openScope();
        for (StatementNode statement : blockNode.getStatementNodes()) {
            visitStatement(statement);
        }
        if (returnType != Enums.ReturnType.VOID)
            visitReturnStatement(blockNode.getReturnNode());
        closeScope();
    }

    private void visitReturnStatement(ReturnNode returnNode) {
        visitExpression(returnNode.getExpressionNode());
    }

    private void visitExpression(ExpressionNode expressionNode) {
        LowPrecedenceNode lowPrecedenceNode;
        if (expressionNode instanceof ArithExpressionNode) {
            lowPrecedenceNode = ((ArithExpressionNode) expressionNode).getLowPrecedenceNode();
            visitLowPrecedenceNode(lowPrecedenceNode);
        }
        else if (expressionNode instanceof BoolExpressionNode) {
            // Do BoolExpression things
        }
    }

    private void visitLowPrecedenceNode(LowPrecedenceNode lowPrecedenceNode) {
        for (HighPrecedenceNode highPrecedenceNode : lowPrecedenceNode.getHighPrecedenceNodes()) {
            for (AtomPrecedenceNode atomPrecedenceNode : highPrecedenceNode.getAtomPrecedenceNodes()) {

                // Operand: Variable name
                if (atomPrecedenceNode.getOperand().getVariableName() != null) {
                    String variableName = atomPrecedenceNode.getOperand().getVariableName();

                    if (retrieveSymbol(variableName) == null)
                        throw new RuntimeException("ERROR: Assigned variable is not declared.");
                    else if (retrieveSymbol(variableName) instanceof VariableDeclarationNode) {
                        VariableDeclarationNode variableDeclarationNode = (VariableDeclarationNode) retrieveSymbol(variableName);

                        if (variableDeclarationNode != null && variableDeclarationNode.getAssignmentNode() != null)
                            visitAssignment(variableDeclarationNode.getAssignmentNode());
                        else
                            throw new RuntimeException("ERROR: Assigned variable is not initialized.");

                        if (!variableDeclarationNode.getDataType().equals(Enums.DataType.INT) && !variableDeclarationNode.getDataType().equals(Enums.DataType.FLOAT))
                            throw new RuntimeException("ERROR: Assigned variable is of an incompatible type.");
                    }
                    else
                        enterSymbol(variableName, lowPrecedenceNode);
                }

                // Operand: Non-object function Call

                // Operand: Low precedence
                if (atomPrecedenceNode.getLowPrecedenceNode() != null)
                    visitLowPrecedenceNode(atomPrecedenceNode.getLowPrecedenceNode());
            }
        }
    }

    /*      CLASSES          */
    private void visitClassDeclaration(ClassDeclarationNode classDeclarationNode) {
        String className = classDeclarationNode.getClassName();

        if (retrieveSymbol(className) == null && !this.listOfPredefinedClasses.contains(className))
            enterSymbol(className, classDeclarationNode);
        else
            throw new RuntimeException("ERROR: Class name is already in use.");

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
    private boolean visitVariableName(String variableName) {
        boolean correctVariable = false;



        return correctVariable;
    }
    private ArrayList<Enums.DataType> getExpressionNodeType(ExpressionNode expressionNode) {
        ArrayList<Enums.DataType> dataTypeList = new ArrayList<>();

        if(expressionNode instanceof ArithExpressionNode) {
            dataTypeList.add(Enums.DataType.INT);
            dataTypeList.add(Enums.DataType.FLOAT);
        }
        else if(expressionNode instanceof BoolExpressionNode)
            dataTypeList.add(Enums.DataType.BOOL);
        else if(expressionNode instanceof Vector4ExpressionNode)
            dataTypeList.add(Enums.DataType.VEC4);
        else if(expressionNode instanceof Vector3ExpressionNode)
            dataTypeList.add(Enums.DataType.VEC3);
        else if(expressionNode instanceof Vector2ExpressionNode)
            dataTypeList.add(Enums.DataType.VEC2);

        return dataTypeList;
    }
}
