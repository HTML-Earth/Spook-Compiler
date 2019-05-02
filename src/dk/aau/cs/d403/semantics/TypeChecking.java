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

        VariableDeclarationNode retrievedNode = null;
        if (retrieveSymbol(variableName) != null)
            retrievedNode = (VariableDeclarationNode) retrieveSymbol(variableName);

        if (retrievedNode == null)
            enterSymbol(variableName, variableDeclarationNode);
        else
            throw new RuntimeException("ERROR: A variable with the same name already exists.");

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
        String variableName;

        if (assignmentNode.getVariableName() != null) {
            variableName = assignmentNode.getVariableName();

            if (retrieveSymbol(variableName) == null)
                throw new RuntimeException("ERROR: Variable on left side of assignment is not initialized.");
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

        if (retrievedFunctions != null) {
            boolean matchingSize = true;
            boolean argumentMatch = true;
            for (FunctionDeclarationNode retrievedNode : retrievedFunctions) {
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
            if (!variableDeclarationNode.getDataType().equals(Enums.DataType.NUM))
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
            else if (!variableDeclarationNode.getDataType().equals(Enums.DataType.NUM)) {
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
        Enums.ReturnType returnType = functionDeclarationNode.getReturnType();

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
                        for (int i = 0; i < functionArgs.size(); i--) {
                            if (functionArgs.get(i).getDataType().equals(retrievedNode.getFunctionArgNodes().get(i).getDataType())) {
                                sameFunctionArgs = true;
                                break outerloop;
                            }
                        }
                    }
                }
            }

            if (sameFunctionArgs)
                throw new RuntimeException("ERROR: A function with the same name and arguments already exists.");
            if (!sameReturnType)
                throw new RuntimeException("ERROR: A function with the same name with a different return type already exists.");
            if (sameAmountOfArgs)
                throw new RuntimeException("ERROR: A function with the same name already exists.");

            enterSymbol(functionName, functionDeclarationNode);
        }

        visitFunctionBlock(functionDeclarationNode.getBlockNode(), functionDeclarationNode.getReturnType(), functionDeclarationNode);
    }

    private void visitFunctionBlock(BlockNode blockNode, Enums.ReturnType returnType, FunctionDeclarationNode functionDeclarationNode) {
        openScope();
        for (StatementNode statement : blockNode.getStatementNodes()) {
            visitStatement(statement);
        }
        if (returnType != Enums.ReturnType.VOID)
            visitReturnStatement(blockNode.getReturnNode(), functionDeclarationNode);
        closeScope();
    }

    private void visitReturnStatement(ReturnNode returnNode, FunctionDeclarationNode functionDeclarationNode) {
        ExpressionNode expressionNode = returnNode.getExpressionNode();
        Enums.ReturnType returnType = functionDeclarationNode.getReturnType();
        LowPrecedenceNode lowPrecedenceNode;

        if (expressionNode instanceof ArithExpressionNode && returnType.equals(Enums.ReturnType.NUM)) {
            lowPrecedenceNode = ((ArithExpressionNode) expressionNode).getLowPrecedenceNode();
            visitLowPrecedenceNode(lowPrecedenceNode);
        }
        else if (expressionNode instanceof BoolExpressionNode && returnType.equals(Enums.ReturnType.BOOL)) {
            // Do BoolExpression things
        }
        else if (expressionNode instanceof TernaryOperatorNode) {
            // ternary
        }
        else if (expressionNode instanceof  Vector4ExpressionNode && returnType.equals(Enums.ReturnType.VEC4))
            visitVector4Expression((Vector4ExpressionNode) expressionNode);
        else if (expressionNode instanceof  Vector3ExpressionNode && returnType.equals(Enums.ReturnType.VEC3))
            visitVector3Expression((Vector3ExpressionNode) expressionNode);
        else if (expressionNode instanceof  Vector2ExpressionNode && returnType.equals(Enums.ReturnType.VEC2))
            visitVector2Expression((Vector2ExpressionNode) expressionNode);
        else
            throw new RuntimeException("ERROR: Return statement does not match the return type of the function");
    }
// swizzle, ternary operator, objectdecl, bool
    /*      Expressions      */
    private void visitExpression(ExpressionNode expressionNode) {
        LowPrecedenceNode lowPrecedenceNode;
        if (expressionNode instanceof ArithExpressionNode) {
            lowPrecedenceNode = ((ArithExpressionNode) expressionNode).getLowPrecedenceNode();
            visitLowPrecedenceNode(lowPrecedenceNode);
        }
        else if (expressionNode instanceof BoolExpressionNode) {
            // Do BoolExpression things
        }
        else if (expressionNode instanceof TernaryOperatorNode)
            visitTernaryOperator((TernaryOperatorNode) expressionNode);
        else if (expressionNode instanceof  Vector4ExpressionNode)
            visitVector4Expression((Vector4ExpressionNode) expressionNode);
        else if (expressionNode instanceof  Vector3ExpressionNode)
            visitVector3Expression((Vector3ExpressionNode) expressionNode);
        else if (expressionNode instanceof  Vector2ExpressionNode)
            visitVector2Expression((Vector2ExpressionNode) expressionNode);
    }

    private void visitLowPrecedenceNode(LowPrecedenceNode lowPrecedenceNode) {
        for (HighPrecedenceNode highPrecedenceNode : lowPrecedenceNode.getHighPrecedenceNodes()) {
            for (AtomPrecedenceNode atomPrecedenceNode : highPrecedenceNode.getAtomPrecedenceNodes()) {

                // Operand: Variable name
                if (atomPrecedenceNode.getOperand().getVariableName() != null) {
                    String variableName = atomPrecedenceNode.getOperand().getVariableName();

                    visitVariableName(variableName);
                    VariableDeclarationNode variableDeclarationNode = (VariableDeclarationNode) retrieveSymbol(variableName);
                    if (variableDeclarationNode != null && !variableDeclarationNode.getDataType().equals(Enums.DataType.NUM))
                        throw new RuntimeException("ERROR: Assigned variable is of an incompatible type.");
                    else
                        enterSymbol(variableName, lowPrecedenceNode);
                }

                // Operand: Non-object function Call
                if (atomPrecedenceNode.getOperand().getNonObjectFunctionCallNode() != null) {
                    NonObjectFunctionCallNode nonObjectFunctionCallNode = atomPrecedenceNode.getOperand().getNonObjectFunctionCallNode();
                    visitNonObjectFunctionCall(atomPrecedenceNode.getOperand().getNonObjectFunctionCallNode());

                    // The reason for not checking all functions is because a function with a given name can only have one return type.
                    // It is not legal to have another function with the same name but with a different return type.
                    FunctionDeclarationNode functionDeclarationNode = (FunctionDeclarationNode) retrieveSymbol(nonObjectFunctionCallNode.getFunctionName());
                    if (functionDeclarationNode != null && !functionDeclarationNode.getReturnType().equals(Enums.ReturnType.NUM))
                        throw new RuntimeException("ERROR: Wrong return type for given expression.");
                    else
                        enterSymbol(nonObjectFunctionCallNode.getFunctionName(), lowPrecedenceNode);
                }

                // Operand: Swizzle
                if (atomPrecedenceNode.getOperand().getSwizzleNode() != null) {
                    SwizzleNode swizzleNode = atomPrecedenceNode.getOperand().getSwizzleNode();
                    visitSwizzle(swizzleNode);
                    if (retrieveSymbol(swizzleNode.getVariableName()) != null) {
                        VariableDeclarationNode variableDeclarationNode = (VariableDeclarationNode) retrieveSymbol(swizzleNode.getVariableName());

                    }
                }

                // Operand: Low precedence
                if (atomPrecedenceNode.getLowPrecedenceNode() != null)
                    visitLowPrecedenceNode(atomPrecedenceNode.getLowPrecedenceNode());
            }
        }
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
        CoordinateSwizzleNode coordinateSwizzleNode;
        ColorSwizzleNode colorSwizzleNode;

        // Check if variable is declared and initialized
        visitVariableName(variableName);

        // Check if variable is a vector
        VariableDeclarationNode variableDeclarationNode = (VariableDeclarationNode) retrieveSymbol(variableName);
        if (variableDeclarationNode != null) {

            dataType = variableDeclarationNode.getDataType();
            if (!(dataType.equals(Enums.DataType.VEC4))) {
                if (!(dataType.equals(Enums.DataType.VEC3))) {
                    if (!(dataType.equals(Enums.DataType.VEC2))) {
                        throw new RuntimeException("ERROR: Variable is not of a vector type");
                    }
                }
            }
        }
        // Not used - is checked in visitVariableName
        else
            throw new RuntimeException("Variable is not declared.");

        if (swizzleNode.getCoordinateSwizzle() != null) {
            coordinateSwizzleNode = swizzleNode.getCoordinateSwizzle();
            String swizzleString = coordinateSwizzleNode.getSwizzle();

            if (dataType.equals(Enums.DataType.VEC3) && swizzleString.contains("w"))
                throw new RuntimeException("ERROR: vec3, w");
            else if (dataType.equals(Enums.DataType.VEC2) && swizzleString.contains("w") || swizzleString.contains("z"))
                throw new RuntimeException("ERROR: vec2, w,z");
        }
        else if (swizzleNode.getColorSwizzle() != null) {
            colorSwizzleNode = swizzleNode.getColorSwizzle();
            String swizzleString = colorSwizzleNode.getSwizzle();

            if (dataType.equals(Enums.DataType.VEC3) && swizzleString.contains("a"))
                throw new RuntimeException("ERROR: vec3, a");
            else if (dataType.equals(Enums.DataType.VEC2) && swizzleString.contains("a") || swizzleString.contains("b"))
                throw new RuntimeException("ERROR: vec2, a, b");
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
    private void visitVariableName(String variableName) {
        if (retrieveSymbol(variableName) == null)
            throw new RuntimeException("ERROR: Variable is not declared");
        else if (retrieveSymbol(variableName) != null) {
            VariableDeclarationNode variableDeclarationNode = (VariableDeclarationNode) retrieveSymbol(variableName);

            if (variableDeclarationNode != null && variableDeclarationNode.getAssignmentNode() == null)
                throw new RuntimeException("ERROR: Variable is not initialized");
        }
    }
    private Enums.DataType getExpressionNodeType(ExpressionNode expressionNode) {

        if (expressionNode instanceof ArithExpressionNode)
            return Enums.DataType.NUM;
        else if(expressionNode instanceof BoolExpressionNode)
            return Enums.DataType.BOOL;
        else if(expressionNode instanceof Vector4ExpressionNode)
            return Enums.DataType.VEC4;
        else if(expressionNode instanceof Vector3ExpressionNode)
            return Enums.DataType.VEC3;
        else if(expressionNode instanceof Vector2ExpressionNode)
            return Enums.DataType.VEC2;
        else
            throw new RuntimeException("Unknown Expression Node type.");
    }
}
