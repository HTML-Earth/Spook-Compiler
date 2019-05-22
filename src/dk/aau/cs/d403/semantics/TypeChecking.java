package dk.aau.cs.d403.semantics;

import dk.aau.cs.d403.errorhandling.CompilerException;
import dk.aau.cs.d403.ast.ASTnode;
import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.ast.statements.*;
import dk.aau.cs.d403.ast.structure.*;

import java.util.*;

public class TypeChecking {
    private Stack<HashMap<String, ASTnode>> hashMapStack;
    private Integer functionCounter = 1;
    private FunctionDeclarationNode currentFuncNode;

    private ArrayList<String> listOfPredefinedClasses;
    private HashMap<String, Enums.DataType> predefinedFunctions;
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


        this.predefinedFunctions = new HashMap<>();
        this.predefinedFunctions.put("abs", Enums.DataType.NUM);
        this.predefinedFunctions.put("acos", Enums.DataType.NUM);
        this.predefinedFunctions.put("acosh", Enums.DataType.NUM);
        this.predefinedFunctions.put("asin", Enums.DataType.NUM);
        this.predefinedFunctions.put("asinh", Enums.DataType.NUM);
        this.predefinedFunctions.put("atan", Enums.DataType.NUM);
        this.predefinedFunctions.put("atanh", Enums.DataType.NUM);
        this.predefinedFunctions.put("ceil", Enums.DataType.NUM);
        this.predefinedFunctions.put("clamp", Enums.DataType.NUM);
        this.predefinedFunctions.put("cos", Enums.DataType.NUM);
        this.predefinedFunctions.put("cosh", Enums.DataType.NUM);
        this.predefinedFunctions.put("cross", Enums.DataType.VEC3);
        this.predefinedFunctions.put("cross3", Enums.DataType.VEC3);
        this.predefinedFunctions.put("degrees", Enums.DataType.NUM);
        this.predefinedFunctions.put("distance", Enums.DataType.NUM);
        this.predefinedFunctions.put("dot", Enums.DataType.NUM);
        this.predefinedFunctions.put("exp", Enums.DataType.NUM);
        this.predefinedFunctions.put("exp2", Enums.DataType.NUM);
        this.predefinedFunctions.put("floor", Enums.DataType.NUM);
        this.predefinedFunctions.put("fract", Enums.DataType.NUM);
        this.predefinedFunctions.put("inversesqrt", Enums.DataType.NUM);
        this.predefinedFunctions.put("length", Enums.DataType.NUM);
        this.predefinedFunctions.put("log", Enums.DataType.NUM);
        this.predefinedFunctions.put("log2", Enums.DataType.NUM);
        this.predefinedFunctions.put("max", Enums.DataType.NUM);
        this.predefinedFunctions.put("min", Enums.DataType.NUM);
        this.predefinedFunctions.put("mix", Enums.DataType.NUM);
        this.predefinedFunctions.put("mix2", Enums.DataType.VEC2);
        this.predefinedFunctions.put("mix3", Enums.DataType.VEC3);
        this.predefinedFunctions.put("mix4", Enums.DataType.VEC4);
        this.predefinedFunctions.put("mod", Enums.DataType.NUM);
        this.predefinedFunctions.put("normalize2", Enums.DataType.VEC2);
        this.predefinedFunctions.put("normalize3", Enums.DataType.VEC3);
        this.predefinedFunctions.put("normalize4", Enums.DataType.VEC4);
        this.predefinedFunctions.put("outerProduct", Enums.DataType.NUM);
        this.predefinedFunctions.put("pow", Enums.DataType.NUM);
        this.predefinedFunctions.put("radians", Enums.DataType.NUM);
        this.predefinedFunctions.put("reflect2", Enums.DataType.VEC2);
        this.predefinedFunctions.put("reflect3", Enums.DataType.VEC3);
        this.predefinedFunctions.put("reflect4", Enums.DataType.VEC4);
        this.predefinedFunctions.put("refract2", Enums.DataType.VEC2);
        this.predefinedFunctions.put("refract3", Enums.DataType.VEC3);
        this.predefinedFunctions.put("refract4", Enums.DataType.VEC4);
        this.predefinedFunctions.put("round", Enums.DataType.NUM);
        this.predefinedFunctions.put("roundEven", Enums.DataType.NUM);
        this.predefinedFunctions.put("sign", Enums.DataType.NUM);
        this.predefinedFunctions.put("sin", Enums.DataType.NUM);
        this.predefinedFunctions.put("sinh", Enums.DataType.NUM);
        this.predefinedFunctions.put("smoothstep", Enums.DataType.NUM);
        this.predefinedFunctions.put("sqrt", Enums.DataType.NUM);
        this.predefinedFunctions.put("step", Enums.DataType.NUM);
        this.predefinedFunctions.put("tan", Enums.DataType.NUM);
        this.predefinedFunctions.put("tanh", Enums.DataType.NUM);
        this.predefinedFunctions.put("trunc", Enums.DataType.NUM);
        this.predefinedFunctions.put("setScale", Enums.DataType.NUM);
        this.predefinedFunctions.put("setParent", Enums.DataType.NUM);


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

        this.numberOperatorList = new ArrayList<>();
        this.numberOperatorList.add(Enums.BoolOperator.GREATER_OR_EQUAL);
        this.numberOperatorList.add(Enums.BoolOperator.GREATER_THAN);
        this.numberOperatorList.add(Enums.BoolOperator.LESS_OR_EQUAL);
        this.numberOperatorList.add(Enums.BoolOperator.LESS_THAN);
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
                if (this.hashMapStack.elementAt(stackLevel).get(name) instanceof FunctionDeclarationNode) {
                    symbols.add((FunctionDeclarationNode) this.hashMapStack.elementAt(stackLevel).get(name));
                    if (functionCounter != 1) {
                        for (int i = 1; i < functionCounter; i++)
                            symbols.add((FunctionDeclarationNode) this.hashMapStack.elementAt(stackLevel).get(i + name));
                    }
                }
            }

            stackLevel -= 1;
        }
        this.functionCounter = 1;

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

        // Visit all function Decls then all the function blocks
        visitFunctionDeclAndBlock(programNode.getFunctionDeclarationNodes());
        // visit all classDecls
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
            if (retrieveSymbol(varDeclInitNode.getAssignmentNode().getVariableName()) != null && retrieveSymbol(varDeclInitNode.getAssignmentNode().getVariableName()) instanceof VariableDeclarationNode)
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
        if (objectDeclarationNode.getObjectContructorNode() != null) {
            visitObjectConstructor(objectDeclarationNode);
        }

        if (retrieveSymbol(variableName) == null)
            enterSymbol(variableName, objectDeclarationNode);
        else if (retrievedNode != null && !retrievedNode.getClassName().equals(objectType))
            enterSymbol(variableName, objectDeclarationNode);
        else
            throw new CompilerException("ERROR: An object (" + variableName + ") is already declared with the same name and type.", retrieveSymbol(variableName).getCodePosition());
    }

    private void visitObjectConstructor(ObjectDeclarationNode objectDeclarationNode) {
        ObjectContructorNode objectContructorNode = objectDeclarationNode.getObjectContructorNode();
        if (objectContructorNode.getNonObjectFunctionCallNode() != null)
            visitNonObjectFunctionCall(objectContructorNode.getNonObjectFunctionCallNode());
        else if (objectContructorNode.getObjectFunctionCallNode() != null)
            visitObjectFunctionCall(objectContructorNode.getObjectFunctionCallNode());
        //If initialized to another object, check that it is declared and the types match
        else if (objectContructorNode.getObjectVariableName() != null) {
            retrieveSymbol(objectDeclarationNode.getVariableName());
            if (retrieveSymbol(objectDeclarationNode.getObjectContructorNode().getObjectVariableName()) instanceof ObjectDeclarationNode) {
                visitObjectVariableName(objectContructorNode.getObjectVariableName());
                ObjectDeclarationNode objectConstructorDeclarationNode = (ObjectDeclarationNode) retrieveSymbol(objectDeclarationNode.getObjectContructorNode().getObjectVariableName());
                if (objectConstructorDeclarationNode != null) {
                    //visitObjectDeclaration(objectConstructorDeclarationNode);
                    if (objectDeclarationNode.getClassName().equals(objectConstructorDeclarationNode.getClassName())) {
                        //Object types are a match
                    }
                    else
                        throw new CompilerException("Object types do not match " + objectDeclarationNode.getClassName() + " and " + objectConstructorDeclarationNode.getClassName(), objectDeclarationNode.getCodePosition());
                }
                else
                    throw new CompilerException("Object (" + objectContructorNode.getObjectVariableName() + ") not declared", objectContructorNode.getCodePosition());
            }
            else
                throw new CompilerException("Contructor (" + objectContructorNode.getObjectVariableName() + ") is not an object", objectContructorNode.getCodePosition());
        }
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
        String dataType;

        if (assignmentNode.getVariableName() != null) {
            VariableDeclarationNode variableDeclarationNode = null;
            variableName = assignmentNode.getVariableName();
            if (retrieveSymbol(variableName) instanceof VariableDeclarationNode)
                variableDeclarationNode = (VariableDeclarationNode) retrieveSymbol(variableName);

            if (variableDeclarationNode != null)
                dataType = Enums.dataTypeToStringSpook(variableDeclarationNode.getDataType());
            else
                dataType = null;

            if (retrieveSymbol(variableName) == null)
                throw new CompilerException("ERROR: Variable (" + variableName + ") on left side of assignment is not declared.", assignmentNode.getCodePosition());

            if (assignmentNode.getExpressionNode() != null) {
                String assignedDataType = null;
                if (assignmentNode.getExpressionNode() instanceof BoolExpressionNode) {
                    assignedDataType = Enums.dataTypeToStringSpook(Enums.DataType.BOOL);
                } else if (assignmentNode.getExpressionNode() instanceof ArithExpressionNode) {
                    assignedDataType = visitLowPrecedenceNode(((ArithExpressionNode) assignmentNode.getExpressionNode()).getLowPrecedenceNode());
                }
                //Check datatype for the first expression in ternaryoperator, visitTernaryOperator makes sure both expressions are of same type
                else if (assignmentNode.getExpressionNode() instanceof TernaryOperatorNode) {
                    TernaryOperatorNode ternaryOperatorNode = (TernaryOperatorNode) assignmentNode.getExpressionNode();
                    visitTernaryOperator(ternaryOperatorNode);
                    assignedDataType = ternaryExprType(assignmentNode.getExpressionNode());
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

    private FunctionDeclarationNode visitNonObjectFunctionCall(NonObjectFunctionCallNode nonObjectFunctionCallNode) {
        boolean notFound = true;
        String functionName = nonObjectFunctionCallNode.getFunctionName();
        ArrayList<ObjectArgumentNode> objectArgumentNodes = nonObjectFunctionCallNode.getArgumentNodes();

        ArrayList<FunctionDeclarationNode> retrievedFunctions = new ArrayList<>();
        retrievedFunctions = retrieveAllFunctions(functionName);

        if (this.predefinedFunctions.containsKey(functionName)) {
            return new FunctionDeclarationNode(predefinedFunctions.get(functionName), functionName, new BlockNode(new ArrayList<>()));
        }
        else {
            if (!retrievedFunctions.isEmpty()) {
                for (FunctionDeclarationNode functionDeclarationNode : retrievedFunctions) {
                    if (functionDeclarationNode != null) {
                        if (functionDeclarationNode.getFunctionArgNodes() != null && objectArgumentNodes != null) {
                            if (functionDeclarationNode.getFunctionArgNodes().size() != objectArgumentNodes.size()) {
                                continue;
                                //throw new CompilerException("ERROR: Argument and parameter size mismatch in function call (" + nonObjectFunctionCallNode.getFunctionName() + ")", nonObjectFunctionCallNode.getCodePosition());
                            } else {
                                for (int i = 0; i < functionDeclarationNode.getFunctionArgNodes().size(); i++) {
                                    if (functionDeclarationNode.getFunctionArgNodes().get(i).getDataType() != null) {
                                        if (visitLowPrecedenceNode(nonObjectFunctionCallNode.getArgumentNodes().get(i).getLowPrecedence()) != null) {
                                            String foundDataType1 = Enums.dataTypeToStringSpook(functionDeclarationNode.getFunctionArgNodes().get(i).getDataType());
                                            String foundDataType2 = visitLowPrecedenceNode(nonObjectFunctionCallNode.getArgumentNodes().get(i).getLowPrecedence());
                                            if (!foundDataType1.equals(foundDataType2)) {
                                                throw new CompilerException("ERROR: Argument type mismatch in function call (" + functionName + "). Found " + foundDataType1 + " and " + foundDataType2, nonObjectFunctionCallNode.getCodePosition());
                                            }
                                        }
                                        else
                                            throw new CompilerException("ERROR: Argument (" + functionDeclarationNode.getFunctionArgNodes().get(i) + ") in function call (" + functionName + ") with missing type.", nonObjectFunctionCallNode.getCodePosition());
                                    }

                                    else if (functionDeclarationNode.getFunctionArgNodes().get(i).getClassName() != null) {
                                        if (visitLowPrecedenceNode(nonObjectFunctionCallNode.getArgumentNodes().get(i).getLowPrecedence()) != null) {
                                            String foundClassName1 = functionDeclarationNode.getFunctionArgNodes().get(i).getClassName();
                                            String foundClassName2 = visitLowPrecedenceNode(nonObjectFunctionCallNode.getArgumentNodes().get(i).getLowPrecedence());
                                            if (!foundClassName1.equals(foundClassName2)) {
                                                throw new CompilerException("ERROR: Argument type mismatch in function call (" + functionName + "). Found " + foundClassName1 + " and " + foundClassName2, nonObjectFunctionCallNode.getCodePosition());
                                            }
                                        }
                                        else
                                            throw new CompilerException("ERROR: Argument (" + nonObjectFunctionCallNode.getArgumentNodes().get(i) + ") in function call (" + functionName + ") with missing type.", nonObjectFunctionCallNode.getCodePosition());
                                    }

                                    else
                                        System.out.println("get class name data type was null");
                                }
                                notFound = false;
                                return functionDeclarationNode;
                            }

                        } else if (functionDeclarationNode.getFunctionArgNodes() == null && objectArgumentNodes == null) {
                            notFound = false;
                            return functionDeclarationNode;
                        }

                        else if (notFound && functionDeclarationNode.getFunctionArgNodes() != null)
                            continue;

                        else if (notFound && objectArgumentNodes != null && functionDeclarationNode.getFunctionArgNodes() == null)
                            continue;

                        else
                            break;

                    }
                }

                if (notFound)
                    throw new CompilerException("ERROR: No function with matching parameters was found. (" + functionName + ")", nonObjectFunctionCallNode.getCodePosition());

            } else {
                throw new CompilerException("ERROR: Missing function for function call. (" + functionName + ")", nonObjectFunctionCallNode.getCodePosition());
            }

        }

        return null;

    }

    private String visitObjectFunctionCall(ObjectFunctionCallNode objectFunctionCallNode) {
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
                    String dataType = null;

                    if (classDeclarationNode != null && classDeclarationNode.getClassBlockNode() != null) {

                        // Check if class has the function used
                        for (FunctionDeclarationNode functionDeclarationNode : classDeclarationNode.getClassBlockNode().getFunctionDeclarationNodes()) {

                            // Look for the function with the same name
                            for (String predefinedFunctionName : predefinedFunctions.keySet()) {
                                if (functionName.equals(predefinedFunctionName)) {
                                    existingFunction = true;
                                } else if (functionDeclarationNode.getFunctionName().equals(functionName)) {
                                    existingFunction = true;

                                    // Check the data types of the arguments given
                                    if (functionDeclarationNode.getFunctionArgNodes() != null) {
                                        ArrayList<FunctionArgNode> functionArgNodes = functionDeclarationNode.getFunctionArgNodes();

                                        // Check each argument if its data type matches the function's parameters
                                        for (int i = 0; i < functionDeclarationNode.getFunctionArgNodes().size(); i++) {
                                            dataType = visitLowPrecedenceNode(objectArgumentNodes.get(i).getLowPrecedence());
                                            if (!(Enums.dataTypeToStringSpook(functionArgNodes.get(i).getDataType()).equals(dataType))) {
                                                sameFunction = false;
                                                break;
                                            }
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

        openScope();

        // Visit expression and check if they are well typed
        visitForLoopExpression(forLoopExpression1);
        visitForLoopExpression(forLoopExpression2);

        if (forLoopStatementNode.getConditionalBlockNode().getBlockNode() != null)
            visitBlock(forLoopStatementNode.getConditionalBlockNode().getBlockNode());
        else if (forLoopStatementNode.getConditionalBlockNode().getStatementNode() != null)
            visitStatement(forLoopStatementNode.getConditionalBlockNode().getStatementNode());

        closeScope();
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
        //else if (retrieveSymbol(forLoopExpressionNode.getVariableName()) != null) {
        //    VariableDeclarationNode variableDeclarationNode = (VariableDeclarationNode) retrieveSymbol(forLoopExpressionNode.getVariableName());
        //    if (variableDeclarationNode == null)
        //        throw new CompilerException("ERROR: Variable in ForLoop is not declared.", variableDeclarationNode.getCodePosition());
        //    else if (variableDeclarationNode.getVarDeclInitNodes().get(0).getAssignmentNode() == null)
        //        throw new CompilerException("ERROR: Variable in ForLoop is not initialized.", variableDeclarationNode.getCodePosition());
        //    else if (!variableDeclarationNode.getDataType().equals(Enums.DataType.NUM)) {
        //        throw new CompilerException("ERROR: Variable is of an illegal type for the ForLoop.", variableDeclarationNode.getCodePosition());
        //    }
        //}
        else if (forLoopExpressionNode.getAtomPrecedenceNode() != null) {
            //Type is ok
            //TODO: type is probably not ok, since atom precedence can have a variable name (see above)
        }
        else
            throw new CompilerException("ERROR: Invalid ForLoop expression", forLoopExpressionNode.getCodePosition());
    }

    /*      FUNCTIONS        */

    // Split up visit function Decl and block, in order to enter all function symbols into table first
    private void visitFunctionDeclAndBlock(ArrayList<FunctionDeclarationNode> functionDeclarationNodes) {
        // Visit and enterSymbol for all functionDecls, needed in order to call functions in other functions
        for (FunctionDeclarationNode functionDeclaration : functionDeclarationNodes) {
            visitFunctionDeclaration(functionDeclaration);
        }
        // Visit every function block
        for (FunctionDeclarationNode functionDeclaration : functionDeclarationNodes) {
            visitFunctionBlock(functionDeclaration.getBlockNode(), functionDeclaration.getReturnType(), functionDeclaration);
        }
    }

    private void visitFunctionDeclaration(FunctionDeclarationNode functionDeclarationNode) {
        String functionName = functionDeclarationNode.getFunctionName();
        ArrayList<FunctionArgNode> functionArgs = functionDeclarationNode.getFunctionArgNodes();
        Enums.DataType returnType = functionDeclarationNode.getReturnType();
        String className = functionDeclarationNode.getClassName();

        //Check if name matches predefined
        functionNameMatchesPredefined(functionDeclarationNode);

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
            //if (!sameReturnType) TODO: Remove this
            //    throw new CompilerException("ERROR: A function with the same name (" + functionName + ") with a different return type already exists.", retrieveSymbol(functionName).getCodePosition());
            if (sameAmountOfArgs)
                if (returnType != null)
                    throw new CompilerException("ERROR: A function with the same name (" + functionName + ") and type (" + returnType + ") already exists.", retrieveSymbol(functionName).getCodePosition());
                else
                    throw new CompilerException("ERROR: A function with the same name (" + functionName + ") and type (" + className + ") already exists.", retrieveSymbol(functionName).getCodePosition());

            enterSymbol(functionName, functionDeclarationNode);
        }
    }

    private void functionNameMatchesPredefined(FunctionDeclarationNode function) {
        String functionName = function.getFunctionName();
        for (String predefinedName : predefinedFunctions.keySet())
        if (functionName.equals(predefinedName))
            throw new CompilerException("ERROR: A predefined function with this name exists (" + functionName + ")", function.getCodePosition());

    }

    private void visitFunctionBlock(BlockNode blockNode, Enums.DataType returnType, FunctionDeclarationNode functionDeclarationNode) {
        openScope();

        //Visit all function arguments and add them as Variable Declarations in the new scope
        if (functionDeclarationNode.getFunctionArgNodes() != null) {
            for (FunctionArgNode functionArgNode : functionDeclarationNode.getFunctionArgNodes()) {

                //Initialize Var/Object Decls to null, as they should already be checked
                if (functionArgNode.getDataType() != null) {
                    AssignmentNode assignmentNode = new AssignmentNode(functionArgNode.getVariableName(), null);
                    VarDeclInitNode varDeclInitNode = new VarDeclInitNode(assignmentNode);
                    VariableDeclarationNode variableDeclarationNode = new VariableDeclarationNode(functionArgNode.getDataType(), varDeclInitNode);
                    variableDeclarationNode.setCodePosition(functionArgNode.getCodePosition());
                    visitVariableDeclaration(variableDeclarationNode);
                }
                else if (functionArgNode.getClassName() != null) {
                    ArrayList<ObjectArgumentNode> objectArgumentNodes = new ArrayList<>();
                    ObjectContructorNode objectContructorNode = new ObjectContructorNode(new ObjectArgumentNodePlural(objectArgumentNodes));
                    ObjectDeclarationNode objectDeclarationNode = new ObjectDeclarationNode(functionArgNode.getClassName(), functionArgNode.getVariableName(), objectContructorNode);
                    objectDeclarationNode.setCodePosition(functionArgNode.getCodePosition());
                    visitObjectDeclaration(objectDeclarationNode);
                }
                else
                    throw new CompilerException("Function argument missing type for argument: " + functionArgNode.prettyPrint(0), functionArgNode.getCodePosition());
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
            String dataType = visitLowPrecedenceNode(lowPrecedenceNode);

            if (dataType != null && !dataType.equals(Enums.dataTypeToStringSpook(returnType)))
                throw new CompilerException("ERROR: Return statement does not match the return type (" + Enums.dataTypeToStringSpook(returnType) + ") of the function", expressionNode.getCodePosition());
        }
        else if (expressionNode instanceof BoolExpressionNode && returnType.equals(Enums.DataType.BOOL))
            visitExpression(expressionNode);
        else if (expressionNode instanceof TernaryOperatorNode)
            visitTernaryOperator((TernaryOperatorNode) expressionNode);
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
            visitLowPrecedenceNode(lowPrecedenceNode);
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

    private String visitLowPrecedenceNode(LowPrecedenceNode lowPrecedenceNode) {
        for (HighPrecedenceNode highPrecedenceNode : lowPrecedenceNode.getHighPrecedenceNodes()) {
            for (AtomPrecedenceNode atomPrecedenceNode : highPrecedenceNode.getAtomPrecedenceNodes()) {

                if (atomPrecedenceNode.getOperand() != null) {
                    // Operand: Variable name
                    if (atomPrecedenceNode.getOperand().getVariableName() != null) {
                        String variableName = atomPrecedenceNode.getOperand().getVariableName();

                        visitVariableName(variableName);

                        if (retrieveSymbol(variableName) instanceof VariableDeclarationNode) {
                            VariableDeclarationNode variableDeclarationNode = (VariableDeclarationNode) retrieveSymbol(variableName);
                            if (variableDeclarationNode != null)
                                return Enums.dataTypeToStringSpook(variableDeclarationNode.getDataType());
                            else
                                throw new CompilerException("Missing VariableDeclarationNode", lowPrecedenceNode.getCodePosition());
                        }
                        else if (retrieveSymbol(variableName) instanceof ObjectDeclarationNode) {
                            ObjectDeclarationNode objectDeclarationNode = (ObjectDeclarationNode) retrieveSymbol(variableName);
                            if (objectDeclarationNode != null)
                                return objectDeclarationNode.getClassName();
                            else
                                throw new CompilerException("Missing ObjectDeclarationNode", lowPrecedenceNode.getCodePosition());
                        }
                        else
                            throw new CompilerException("Retrieved symbol for " + variableName + " was not varDec or objDec.", lowPrecedenceNode.getCodePosition());
                    }

                    // Operand: Non-object function Call
                    else if (atomPrecedenceNode.getOperand().getNonObjectFunctionCallNode() != null) {
                        NonObjectFunctionCallNode nonObjectFunctionCallNode = atomPrecedenceNode.getOperand().getNonObjectFunctionCallNode();
                        FunctionDeclarationNode functionDeclarationNode = visitNonObjectFunctionCall(nonObjectFunctionCallNode);

                        if (functionDeclarationNode != null) {
                            if (functionDeclarationNode.getReturnType() != null)
                                return Enums.dataTypeToStringSpook(functionDeclarationNode.getReturnType());
                            else if (functionDeclarationNode.getClassName() != null)
                                return functionDeclarationNode.getClassName();
                            else
                                throw new CompilerException("Invalid FunctionDeclarationNode", lowPrecedenceNode.getCodePosition());
                        }
                        else
                            throw new CompilerException("Missing FunctionDeclarationNode", lowPrecedenceNode.getCodePosition());
                    }

                    // Operand: Object function Call
                    else if (atomPrecedenceNode.getOperand().getObjectFunctionCallNode() != null) {
                        ObjectFunctionCallNode objectFunctionCallNode = atomPrecedenceNode.getOperand().getObjectFunctionCallNode();
                        return visitObjectFunctionCall(objectFunctionCallNode);
                    }

                    // Operand: Swizzle
                    else if (atomPrecedenceNode.getOperand().getSwizzleNode() != null) {
                        SwizzleNode swizzleNode = atomPrecedenceNode.getOperand().getSwizzleNode();
                        visitSwizzle(swizzleNode);
                        int swizzleLength = 0;

                        if (swizzleNode.getSwizzle() != null)
                            swizzleLength = swizzleNode.getSwizzle().length();

                        if (swizzleLength == 4)
                            return Enums.dataTypeToStringSpook(Enums.DataType.VEC4);
                        else if (swizzleLength == 3)
                            return Enums.dataTypeToStringSpook(Enums.DataType.VEC3);
                        else if (swizzleLength == 2)
                            return Enums.dataTypeToStringSpook(Enums.DataType.VEC2);
                        else if (swizzleLength == 1)
                            return Enums.dataTypeToStringSpook(Enums.DataType.NUM);
                        else
                            throw new CompilerException("ERROR: Too long swizzle", swizzleNode.getCodePosition());
                    }

                    else if (atomPrecedenceNode.getOperand().getRealNumberNode() != null)
                        return Enums.dataTypeToStringSpook(Enums.DataType.NUM);

                    else
                        throw new CompilerException("Invalid Operand", lowPrecedenceNode.getCodePosition());

                }

                // Operand: Low precedence
                else if (atomPrecedenceNode.getLowPrecedenceNode() != null)
                    return visitLowPrecedenceNode(atomPrecedenceNode.getLowPrecedenceNode());

                else
                    throw new CompilerException("Invalid AtomPrecedence", lowPrecedenceNode.getCodePosition());
            }
        }
        return null;
    }

    private void visitBoolExpression(BoolExpressionNode boolExpressionNode) {
        BoolOperationsNode boolOperationsNode = boolExpressionNode.getBoolOperationsNode();
        ArrayList<BoolOperationExtendNode> extendNodes = boolOperationsNode.getBoolOperationExtendNodes();

        if (extendNodes != null) {
            for (int currentExtend = 0; currentExtend < extendNodes.size(); currentExtend++) {
                //Go through all extendNodes, if the operator matches <, >, >=, <= check that both operands are arithExpression
                if (numberOperatorList.contains(extendNodes.get(currentExtend).getBoolOperator())) {
                    //For the first node we check the original operand is an arithExpression (Original operator extend)
                    if (currentExtend == 0) {
                        if (boolOperationsNode.getArithExpressionNode().getLowPrecedenceNode() != null && extendNodes.get(currentExtend).getArithExpressionNode().getLowPrecedenceNode() != null) {
                            String variableType = visitLowPrecedenceNode(boolOperationsNode.getArithExpressionNode().getLowPrecedenceNode());
                            String extendVariableType = visitLowPrecedenceNode(extendNodes.get(currentExtend).getArithExpressionNode().getLowPrecedenceNode());

                            if (variableType.equals(Enums.dataTypeToStringSpook(Enums.DataType.NUM)) && extendVariableType.equals(Enums.dataTypeToStringSpook(Enums.DataType.NUM))) {
                                //OK type
                            }
                            else
                                throw new CompilerException("Operator (" + extendNodes.get(currentExtend).getBoolOperator() + ") requires Num type. Found: " + variableType + " and " + extendVariableType, boolExpressionNode.getCodePosition());
                        }
                    } else
                        //Check for currentExtend - 1 operator currentExtend
                        if (extendNodes.get(currentExtend - 1).getArithExpressionNode().getLowPrecedenceNode() != null && extendNodes.get(currentExtend).getArithExpressionNode().getLowPrecedenceNode() != null) {
                            String variableType = visitLowPrecedenceNode(extendNodes.get(currentExtend - 1).getArithExpressionNode().getLowPrecedenceNode());
                            String extendVariableType = visitLowPrecedenceNode(extendNodes.get(currentExtend).getArithExpressionNode().getLowPrecedenceNode());

                            if (variableType.equals(Enums.dataTypeToStringSpook(Enums.DataType.NUM)) && extendVariableType.equals(Enums.dataTypeToStringSpook(Enums.DataType.NUM))) {
                                //OK type
                            }
                            else
                                throw new CompilerException("Operator (" + extendNodes.get(currentExtend).getBoolOperator() + ") requires Num type. Found: " + variableType + " and " + extendVariableType, boolExpressionNode.getCodePosition());
                        }

                }
                //Check if the operator matches &&, ||
                if (booleanOperatorList.contains(extendNodes.get(currentExtend).getBoolOperator())) {
                    //For the first node we check the original operand is a boolExpression (Original operator extend)
                    if (currentExtend == 0) {
                        if (boolOperationsNode.getBoolOperationNode() != null || extendNodes.get(currentExtend).getBoolOperationNode() != null) {
                            //OK type
                        }
                        //Check variables
                        else if (boolOperationsNode.getArithExpressionNode().getLowPrecedenceNode() != null && extendNodes.get(currentExtend).getArithExpressionNode().getLowPrecedenceNode() != null) {
                            String variableType = visitLowPrecedenceNode(boolOperationsNode.getArithExpressionNode().getLowPrecedenceNode());
                            String extendVariableType = visitLowPrecedenceNode(extendNodes.get(currentExtend).getArithExpressionNode().getLowPrecedenceNode());

                            if (variableType.equals(Enums.dataTypeToStringSpook(Enums.DataType.BOOL)) && extendVariableType.equals(Enums.dataTypeToStringSpook(Enums.DataType.BOOL))) {
                                //OK type
                            }
                        }
                        else
                            throw new CompilerException("Operator (" + Enums.boolOperatorToString(extendNodes.get(currentExtend).getBoolOperator()) + ") requires boolean expressions. Check for missing parentheses", boolExpressionNode.getCodePosition());
                    } else {
                        //Check for currentExtend - 1 operator currentExtend
                        if (extendNodes.get(currentExtend).getBoolOperationNode() != null || extendNodes.get(currentExtend - 1).getBoolOperationNode() != null) {
                            //OK type
                        }
                        //Check variables
                        else if (extendNodes.get(currentExtend - 1).getArithExpressionNode().getLowPrecedenceNode() != null && extendNodes.get(currentExtend).getArithExpressionNode().getLowPrecedenceNode() != null) {
                            String variableType = visitLowPrecedenceNode(extendNodes.get(currentExtend - 1).getArithExpressionNode().getLowPrecedenceNode());
                            String extendVariableType = visitLowPrecedenceNode(extendNodes.get(currentExtend).getArithExpressionNode().getLowPrecedenceNode());

                            if (variableType.equals(Enums.dataTypeToStringSpook(Enums.DataType.BOOL)) && extendVariableType.equals(Enums.dataTypeToStringSpook(Enums.DataType.BOOL))) {
                                //OK type
                            }
                        }
                    }
                }

                //Check for != and ==, where both type must match
                if (extendNodes.get(currentExtend).getBoolOperator() == Enums.BoolOperator.EQUAL || extendNodes.get(currentExtend).getBoolOperator() == Enums.BoolOperator.NOT_EQUAL) {
                    //Special check for the first node
                    if (currentExtend == 0) {

                        if (boolOperationsNode.getBoolOperationNode() != null && extendNodes.get(currentExtend).getBoolOperationNode() != null) {
                            //OK type
                        }
                        // originalType = bool && extend = boolOperation
                        else if (boolOperationsNode.getArithExpressionNode().getLowPrecedenceNode() != null) {
                            String variableType = visitLowPrecedenceNode(boolOperationsNode.getArithExpressionNode().getLowPrecedenceNode());

                            if (variableType.equals(Enums.dataTypeToStringSpook(Enums.DataType.BOOL)) && extendNodes.get(currentExtend).getBoolOperationNode() != null) {
                                //OK type
                            }
                        }
                        // original = boolOperation && extendType = bool
                        else if (extendNodes.get(currentExtend).getArithExpressionNode().getLowPrecedenceNode() != null) {
                            String extendVariableType = visitLowPrecedenceNode(extendNodes.get(currentExtend).getArithExpressionNode().getLowPrecedenceNode());

                            if (extendVariableType.equals(Enums.dataTypeToStringSpook(Enums.DataType.BOOL)) && boolOperationsNode.getBoolOperationNode() != null) {
                                //OK type
                            }
                        }
                        //The 2 LowPrecedences match type
                        else if (boolOperationsNode.getArithExpressionNode().getLowPrecedenceNode() != null && extendNodes.get(currentExtend).getArithExpressionNode().getLowPrecedenceNode() != null) {
                            String variableType = visitLowPrecedenceNode(boolOperationsNode.getArithExpressionNode().getLowPrecedenceNode());
                            String extendVariableType = visitLowPrecedenceNode(extendNodes.get(currentExtend).getArithExpressionNode().getLowPrecedenceNode());

                            if (variableType.equals(extendVariableType)) {
                                //OK type
                            }
                        } else
                            throw new CompilerException("Cannot compare expressions of different types", boolExpressionNode.getCodePosition());

                    } else {
                        if (extendNodes.get(currentExtend - 1).getBoolOperationNode() != null && extendNodes.get(currentExtend).getBoolOperationNode() != null) {
                            //OK type
                        } else if (extendNodes.get(currentExtend - 1).getArithExpressionNode() != null && extendNodes.get(currentExtend).getArithExpressionNode() != null) {
                            //OK type
                        }
                        // prevoiusExtend = boolOperation && currentExtendType = bool
                        else if (extendNodes.get(currentExtend).getArithExpressionNode().getLowPrecedenceNode() != null) {
                            String extendVariableType = visitLowPrecedenceNode(extendNodes.get(currentExtend).getArithExpressionNode().getLowPrecedenceNode());

                            if (extendVariableType.equals(Enums.dataTypeToStringSpook(Enums.DataType.BOOL)) && extendNodes.get(currentExtend - 1).getBoolOperationNode() != null) {
                                //OK type
                            }
                        }
                        //The 2 LowPrecedences match type
                        else if (extendNodes.get(currentExtend - 1).getArithExpressionNode().getLowPrecedenceNode() != null && extendNodes.get(currentExtend).getArithExpressionNode().getLowPrecedenceNode() != null) {
                            String variableType = visitLowPrecedenceNode(extendNodes.get(currentExtend - 1).getArithExpressionNode().getLowPrecedenceNode());
                            String extendVariableType = visitLowPrecedenceNode(extendNodes.get(currentExtend).getArithExpressionNode().getLowPrecedenceNode());

                            if (variableType.equals(extendVariableType)) {
                                //OK type
                            }
                        } else
                            throw new CompilerException("Cannot compare expressions of different types", boolExpressionNode.getCodePosition());

                    }
                }
            }
        }
    }

    private void visitTernaryOperator(TernaryOperatorNode ternaryOperatorNode) {
        if (ternaryOperatorNode.getBoolExpressionNode() != null)
            visitExpression(ternaryOperatorNode.getBoolExpressionNode());
        else if (ternaryOperatorNode.getVariableName() != null) {
            visitVariableName(ternaryOperatorNode.getVariableName());
            //Case of !variableName check that variableName is of type Bool
            if (ternaryOperatorNode.getBoolOperator() != null) {
                VariableDeclarationNode variableDeclarationNode = null;
                if (retrieveSymbol(ternaryOperatorNode.getVariableName()) instanceof VariableDeclarationNode)
                variableDeclarationNode =(VariableDeclarationNode) retrieveSymbol(ternaryOperatorNode.getVariableName());
                if (variableDeclarationNode != null) {
                    if (variableDeclarationNode.getDataType() != Enums.DataType.BOOL)
                        throw new CompilerException("Variable: " + ternaryOperatorNode.getVariableName() +" is not of type bool, negation not allowed", ternaryOperatorNode.getCodePosition());
                }
            }
        }
        else if (ternaryOperatorNode.getObjectFunctionCallNode() != null)
            visitObjectFunctionCall(ternaryOperatorNode.getObjectFunctionCallNode());
        else if (ternaryOperatorNode.getNonObjectFunctionCallNode() != null)
            visitNonObjectFunctionCall(ternaryOperatorNode.getNonObjectFunctionCallNode());

        //check if the types of the expression are a match
        ternaryExprMatch(ternaryOperatorNode);

        visitExpression(ternaryOperatorNode.getExpressionNode2());
        visitExpression(ternaryOperatorNode.getExpressionNode1());
    }

    //Checks if the 2 expression in a ternary operator matches
    private void ternaryExprMatch(TernaryOperatorNode ternaryOperatorNode) {
        ExpressionNode expression1 = ternaryOperatorNode.getExpressionNode1();
        ExpressionNode expression2 = ternaryOperatorNode.getExpressionNode2();
        String expression1Type = ternaryExprType(expression1);
        String expression2Type = ternaryExprType(expression2);

        if (!expression1Type.equals(expression2Type))
            throw new CompilerException("Expressions in ternary operator are not the same type. Found: (" + expression1Type + " and " + expression2Type + ")", ternaryOperatorNode.getCodePosition());
    }

    //Returns the type of a single expression in a ternary operator
    private String ternaryExprType(ExpressionNode expressionNode) {
        if (expressionNode instanceof ArithExpressionNode)
            return visitLowPrecedenceNode(((ArithExpressionNode) expressionNode).getLowPrecedenceNode());
        else if (expressionNode instanceof BoolExpressionNode)
            return Enums.dataTypeToStringSpook(Enums.DataType.BOOL);
        else if (expressionNode instanceof Vector2ExpressionNode) {
            String tempDataType;
            tempDataType = Enums.dataTypeToStringSpook(Enums.DataType.VEC2);
            if (expressionNode instanceof Vector3ExpressionNode) {
                tempDataType = Enums.dataTypeToStringSpook(Enums.DataType.VEC3);
                if (expressionNode instanceof Vector4ExpressionNode)
                    tempDataType = Enums.dataTypeToStringSpook(Enums.DataType.VEC4);
            }
            return tempDataType;
        }
        else if (expressionNode instanceof TernaryOperatorNode) {
            TernaryOperatorNode ternaryTemp = (TernaryOperatorNode) expressionNode;
            ternaryExprMatch(ternaryTemp);
            return ternaryExprType(ternaryTemp.getExpressionNode1());
        }
        else
            throw new CompilerException("Ternary expression missing type");
    }

    private void visitVector4Expression(Vector4ExpressionNode vector4ExpressionNode) {
        String expr1 = visitLowPrecedenceNode(vector4ExpressionNode.getArithExpressionNode1().getLowPrecedenceNode());
        String expr2 = visitLowPrecedenceNode(vector4ExpressionNode.getArithExpressionNode2().getLowPrecedenceNode());
        String expr3 = visitLowPrecedenceNode(vector4ExpressionNode.getArithExpressionNode3().getLowPrecedenceNode());
        String expr4 = visitLowPrecedenceNode(vector4ExpressionNode.getArithExpressionNode4().getLowPrecedenceNode());

        if (!expr1.equals(Enums.dataTypeToStringSpook(Enums.DataType.NUM)) || !expr2.equals(Enums.dataTypeToStringSpook(Enums.DataType.NUM)) || !expr3.equals(Enums.dataTypeToStringSpook(Enums.DataType.NUM)) || !expr4.equals(Enums.dataTypeToStringSpook(Enums.DataType.NUM)))
            throw new CompilerException("Expression in Vec4 can only be Num. Found: " + expr1 + ", " + expr2 + ", " + expr3 + " and " + expr4, vector4ExpressionNode.getCodePosition());
    }

    private void visitVector3Expression(Vector3ExpressionNode vector3ExpressionNode) {
        String expr1 = visitLowPrecedenceNode(vector3ExpressionNode.getArithExpressionNode1().getLowPrecedenceNode());
        String expr2 = visitLowPrecedenceNode(vector3ExpressionNode.getArithExpressionNode2().getLowPrecedenceNode());
        String expr3 = visitLowPrecedenceNode(vector3ExpressionNode.getArithExpressionNode3().getLowPrecedenceNode());
        if (!expr1.equals(Enums.dataTypeToStringSpook(Enums.DataType.NUM)) || !expr2.equals(Enums.dataTypeToStringSpook(Enums.DataType.NUM)) || !expr3.equals(Enums.dataTypeToStringSpook(Enums.DataType.NUM)))
            throw new CompilerException("Expression in Vec3 can only be Num. Found: " + expr1 + ", " + expr2 + " and " + expr3, vector3ExpressionNode.getCodePosition());
    }

    private void visitVector2Expression(Vector2ExpressionNode vector2ExpressionNode) {
        String expr1 = visitLowPrecedenceNode(vector2ExpressionNode.getArithExpressionNode1().getLowPrecedenceNode());
        String expr2 = visitLowPrecedenceNode(vector2ExpressionNode.getArithExpressionNode2().getLowPrecedenceNode());
        if (!expr1.equals(Enums.dataTypeToStringSpook(Enums.DataType.NUM)) || !expr2.equals(Enums.dataTypeToStringSpook(Enums.DataType.NUM)))
            throw new CompilerException("Expression in Vec2 can only be Num. Found: " + expr1 + " and " + expr2, vector2ExpressionNode.getCodePosition());
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
            else if (declarationNode instanceof ObjectDeclarationNode)
                visitObjectDeclaration((ObjectDeclarationNode) declarationNode);
        }
        visitFunctionDeclAndBlock(classBlockNode.getFunctionDeclarationNodes());
        closeScope();
    }

    /*      MISC         */
    private void visitVariableName(String variableName) {
        if (retrieveSymbol(variableName) == null)
            throw new CompilerException("ERROR: Variable (" + variableName + ") is not declared");

    }

    private void visitObjectVariableName (String objectVariableName) {
        if (retrieveSymbol(objectVariableName) == null)
            throw new CompilerException("ERROR: Variable (" + objectVariableName + ") is not declared");
        else if (retrieveSymbol(objectVariableName) != null) {
            ObjectDeclarationNode objectDeclarationNode = (ObjectDeclarationNode) retrieveSymbol(objectVariableName);

            if (objectDeclarationNode != null) {
                if (objectDeclarationNode.getObjectContructorNode() != null) {
                    return;
                }
                throw new CompilerException("ERROR: Variable (" + objectVariableName + ") is not initialized", objectDeclarationNode.getCodePosition());
            }
        }
    }
}
