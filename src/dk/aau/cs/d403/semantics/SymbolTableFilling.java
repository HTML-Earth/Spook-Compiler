package dk.aau.cs.d403.semantics;

import java.util.*;

import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.ast.statements.*;
import dk.aau.cs.d403.ast.structure.*;

public class SymbolTableFilling implements SymbolTable{

    private HashMap<NodeObject, String> symbolTable;
    private String scopeLevel;
    private int level = 1;

    public SymbolTableFilling() {
        this.symbolTable = new HashMap<>();
    }

    @Override
    public void openScope() {
        this.scopeLevel = "Scope" + level;
    }

    @Override
    public void closeScope() {
        this.level += 1;
    }

    @Override
    public void enterSymbol(NodeObject object, String scopeLevel) {
        symbolTable.put(object, scopeLevel);
    }

    @Override
    public NodeObject retrieveSymbol(String name) {
        for (NodeObject object : symbolTable.keySet()) {
            if (object.getName().equals(name)) {
                return object;
            }
        }
        return null;
    }

    public HashMap<NodeObject, String> getSymbolTable() {
        return symbolTable;
    }

    public void printSymbolTable() {
        System.out.println("Size of symbol table: " + symbolTable.size());

        System.out.println("Symbol table:\n----------------------------------");
        System.out.println(String.format("%5s, %5s, %5s %5s, %5s, %5s", "Data type", "Class type", "Return type", "Variable name", "Attributes", "Scopelevel"));
        for (Map.Entry entry : symbolTable.entrySet()) {
            System.out.println(entry);
        }
        System.out.println("----------------------------------");
    }


    public void visitProgram(ProgramNode programNode) {
        visitMain(programNode.getMainNode());

        for (ClassDeclarationNode classDecl : programNode.getClassDeclarationNodes()) {
            visitClassDeclaration(classDecl);
        }

        for (FunctionDeclarationNode functionDecl : programNode.getFunctionDeclarationNodes()) {
            visitFunctionDeclaration(functionDecl);
        }
    }

    private void visitMain(MainNode mainNode) {
        visitBlock(mainNode.getBlockNode());
    }

    private void visitBlock(BlockNode blockNode) {
        openScope();
        for (StatementNode statementNode: blockNode.getStatementNodes()) {
            visitStatement(statementNode);
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
        /*else if (statementNode instanceof ObjectFunctionCallNode)
            visitObjectFunctionCall((ObjectFunctionCallNode) statementNode);*/
    }

    private void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
        String variableName = variableDeclarationNode.getVariableName();
        Enums.DataType declarationType = variableDeclarationNode.getDataType();

        // SCOPE CHECK: If a variable doesn't exist
        if(retrieveSymbol(variableName) == null) {
            enterSymbol(new NodeObject(declarationType, variableName, this.scopeLevel), this.scopeLevel);
        }
        // SCOPE CHECK: If a variable already existed but not of the same type
        else if (!(retrieveSymbol(variableName).getType().equals(declarationType))) {
            enterSymbol(new NodeObject(declarationType, variableName, this.scopeLevel), this.scopeLevel);
        }
        // SCOPE CHECK: If a variable already existed but not in the same scope
        else if (!(retrieveSymbol(variableName).getScopeLevel().equals(this.scopeLevel))) {
            enterSymbol(new NodeObject(declarationType, variableName, this.scopeLevel), this.scopeLevel);
        }
        // If a variable already existed in the same scope
        else {
            throw new RuntimeException("ERROR: Variable name is already in use.");
        }
    }

    private void visitObjectDeclaration(ObjectDeclarationNode objectDeclarationNode) {
        String variableName = objectDeclarationNode.getVariableName();
        Enums.ClassType objectType = objectDeclarationNode.getObjectType();
        ArrayList<ObjectArgumentNode> objectArguments = objectDeclarationNode.getObjectArgumentNodes();

        // SCOPE CHECK: If a variable doesn't exist
        if (retrieveSymbol(variableName) == null) {
            enterSymbol(new NodeObject(objectType, variableName, this.scopeLevel, objectArguments), this.scopeLevel);
        }
        // SCOPE CHECK: If a variable already existed but not of the same type
        else if (!(retrieveSymbol(variableName).getClassType().equals(objectType))) {
            enterSymbol(new NodeObject(objectType, variableName, this.scopeLevel, objectArguments), this.scopeLevel);
        }
        // SCOPE CHECK: If a variable already existed but not in the same scope
        else if (!(retrieveSymbol(variableName).getScopeLevel().equals(this.scopeLevel))) {
            enterSymbol(new NodeObject(objectType, variableName, this.scopeLevel, objectArguments), this.scopeLevel);
        }
        else {
            throw new RuntimeException("ERROR: Variable name is already in use for that type");
        }
    }

    private void visitAssignment(AssignmentNode assignmentNode) {
        String variableName = assignmentNode.getVariableName();
        NodeObject nodeObject = retrieveSymbol(variableName);
        ExpressionNode expression = assignmentNode.getExpressionNode();

        // SCOPE CHECK: If a variable exists
        if(nodeObject != null) {

            // TYPE CHECK: If the type of the variable does not match the type of the assignment
            if(!(nodeObject.getType().equals(getExpressionNodeType(expression)))) {
                throw new RuntimeException("ERROR: Variable type does not match the type of the expression.");
            }

            // SCOPE CHECK: If the variable has the same scope level as the Node
            if(nodeObject.getScopeLevel().equals(this.scopeLevel)) {
                Enums.DataType assignmentType = retrieveSymbol(assignmentNode.getVariableName()).getType();

                enterSymbol(new NodeObject(assignmentType, variableName, this.scopeLevel, expression), this.scopeLevel);
            }
            else
                throw new RuntimeException("ERROR: Variable is not declared in this scope.");
        }
        else {
            throw new RuntimeException("ERROR: Variable is not declared.");
        }
    }

    private void visitClassDeclaration(ClassDeclarationNode classDeclarationNode) {
        String className = classDeclarationNode.getClassName();

        // SCOPE CHECK: If a class with this name doesn't exist
        if(retrieveSymbol(className) == null) {
            enterSymbol(new NodeObject(className, this.scopeLevel), this.scopeLevel);
        }
        else
            throw new RuntimeException("ERROR: Class name is already in use.");

        visitClassBlock(classDeclarationNode.getClassBlockNode());
    }

    private void visitClassBlock(ClassBlockNode classBlockNode) {
        openScope();
        for(DeclarationNode declNode : classBlockNode.getDeclarationNodes())
            visitVariableDeclaration((VariableDeclarationNode) declNode);
        closeScope();
        for(FunctionDeclarationNode funcNode : classBlockNode.getFunctionDeclarationNodes())
            visitFunctionDeclaration(funcNode);
        closeScope();
    }

    private void visitFunctionDeclaration(FunctionDeclarationNode functionDeclarationNode) {
        String functionName = functionDeclarationNode.getFunctionName();
        Enums.ReturnType returnType = functionDeclarationNode.getReturnType();
        ArrayList<FunctionArgNode> functionArgs = functionDeclarationNode.getFunctionArgNodes();

        // SCOPE CHECK: If a function with this name doesn't exist
        if(retrieveSymbol(functionName) == null) {
            enterSymbol(new NodeObject(returnType, functionName, this.scopeLevel, functionArgs), this.scopeLevel);
        }
        // SCOPE CHECK: If a function with the same name exists but is in a different scope
        else if(!(retrieveSymbol(functionName).getScopeLevel().equals(this.scopeLevel))) {
            enterSymbol(new NodeObject(returnType, functionName, this.scopeLevel, functionArgs), this.scopeLevel);
        }
        // SCOPE CHECK: If a function with the same name exists but the arguments are different
        else if(!(retrieveSymbol(functionName).getFunctionArguments().toString().equals(functionArgs.toString()))) {
            enterSymbol(new NodeObject(returnType, functionName, this.scopeLevel, functionArgs), this.scopeLevel);
        }
        else {
            throw new RuntimeException("ERROR: Function already exist with the same parameters");
        }

        visitBlock(functionDeclarationNode.getBlockNode());
    }

    private Enums.DataType getExpressionNodeType(ExpressionNode expressionNode) {

        if(expressionNode instanceof IntegerExpressionNode)
            return Enums.DataType.INT;
        else if(expressionNode instanceof FloatExpressionNode)
            return Enums.DataType.FLOAT;
        else if(expressionNode instanceof BoolExpressionNode)
            return Enums.DataType.BOOL;
        else if(expressionNode instanceof Vector4ExpressionNode)
            return Enums.DataType.VEC2;
        else if(expressionNode instanceof Vector3ExpressionNode)
            return Enums.DataType.VEC3;
        else if(expressionNode instanceof Vector2ExpressionNode)
            return Enums.DataType.VEC4;
        else
            throw new RuntimeException("Assignment expression is unknown");
    }
}


