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
        visitMain(programNode.getMainNode());
        for (FunctionDeclarationNode functionDeclaration : programNode.getFunctionDeclarationNodes())
            visitFunctionDeclaration(functionDeclaration);
        for (ClassDeclarationNode classDeclaration : programNode.getClassDeclarationNodes())
            visitClassDeclaration(classDeclaration);
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
        else if (statementNode instanceof AssignmentNode)
            visitAssignment((AssignmentNode) statementNode);
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

    private void visitAssignment(AssignmentNode assignmentNode) {
        String variableName = assignmentNode.getVariableName();

        // Check if the assignment expression is an INT or FLOAT
        Enums.DataType dataType;
        ArrayList<Enums.DataType> dataTypeList = getExpressionNodeType(assignmentNode.getExpressionNode());
        if (dataTypeList.contains(Enums.DataType.INT))
            dataType = Enums.DataType.INT;
        else if (dataTypeList.contains(Enums.DataType.FLOAT))
            dataType = Enums.DataType.FLOAT;
        else
            dataType = dataTypeList.get(0);

        VariableDeclarationNode retrievedNode = null;
        if (retrieveSymbol(variableName) != null)
            retrievedNode = (VariableDeclarationNode) retrieveSymbol(variableName);

        if (retrievedNode != null) {
            if (retrievedNode.getDataType().equals(dataType))
                enterSymbol(variableName, assignmentNode);
            else
                throw new RuntimeException("ERROR: The variable type does not match the expression type.");
        }
        else
            throw new RuntimeException("ERROR: Variable is not declared.");

        visitExpression(assignmentNode.getExpressionNode());
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
            for (int i = functionArgs.size(); i > 0; i--) {
                if (!functionArgs.get(i - 1).prettyPrint().equals(retrievedNode.getFunctionArgNodes().get(i - 1).prettyPrint())) {
                    unique = true;
                    break;
                }
            }
            if (unique)
                enterSymbol(functionName, functionDeclarationNode);
            else
                throw new RuntimeException("ERROR: A function with the same name already exists.");
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

                if (atomPrecedenceNode.getOperand().getVariableName() != null) {
                    if (retrieveSymbol(atomPrecedenceNode.getOperand().getVariableName()) == null)
                        throw new RuntimeException("ERROR: Variable is not declared.");
                    else if (!(retrieveSymbol(atomPrecedenceNode.getOperand().getVariableName()) instanceof AssignmentNode))
                        throw new RuntimeException("ERROR: Variable is not initialized.");

                    AssignmentNode assignmentNode = (AssignmentNode) retrieveSymbol(atomPrecedenceNode.getOperand().getVariableName());
                    Enums.DataType dataType = null;
                    if (assignmentNode != null) {
                        if (getExpressionNodeType(assignmentNode.getExpressionNode()).contains(Enums.DataType.FLOAT))
                            dataType = Enums.DataType.FLOAT;
                        else if (getExpressionNodeType(assignmentNode.getExpressionNode()).contains(Enums.DataType.INT))
                            dataType = Enums.DataType.INT;
                    }

                    if (dataType == null)
                        throw new RuntimeException("ERROR: Variable does not match the expression type.");
                }

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
