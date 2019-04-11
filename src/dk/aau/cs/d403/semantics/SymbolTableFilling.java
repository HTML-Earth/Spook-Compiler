package dk.aau.cs.d403.semantics;

import java.util.*;

import dk.aau.cs.d403.ast.Enums;
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

    public void printSymbolTable() {
        System.out.println("Size of symbol table: " + symbolTable.size());

        System.out.println("Symbol table:\n----------------------------------");
        System.out.println(String.format("%5s, %5s, %5s, %5s, %5s", "Data type", "Return type", "Variable name", "Attributes", "Scopelevel"));
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
        else if (statementNode instanceof AssignmentNode)
            visitAssignment((AssignmentNode) statementNode);
    }

    private void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
        String variableName = variableDeclarationNode.getVariableName();

        // If a variable doesn't exist
        if(retrieveSymbol(variableName) == null) {
            Enums.DataType declarationType = variableDeclarationNode.getDataType();

            enterSymbol(new NodeObject(declarationType, variableName, this.scopeLevel), this.scopeLevel);
        }
        // If a variable already existed but not in the same scope
        else if (!(retrieveSymbol(variableName).getScopeLevel().equals(this.scopeLevel))) {
            Enums.DataType declarationType = variableDeclarationNode.getDataType();

            enterSymbol(new NodeObject(declarationType, variableName, this.scopeLevel), this.scopeLevel);
        }
        // If a variable already existed in the same scope
        else {
            throw new RuntimeException("ERROR: Variable name is already in use.");
        }
    }

    private void visitAssignment(AssignmentNode assignmentNode) {
        String variableName = assignmentNode.getVariableName();

        // If a variable exists
        if(retrieveSymbol(variableName) != null) {
            // If the variable has the same scope level as the Node
            if(retrieveSymbol(variableName).getScopeLevel().equals(this.scopeLevel)) {
                Enums.DataType assignmentType = retrieveSymbol(assignmentNode.getVariableName()).getType();

                enterSymbol(new NodeObject(assignmentType, variableName, this.scopeLevel, assignmentNode.prettyPrint()), this.scopeLevel);
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

        // If a class with this name doesn't exist
        if(retrieveSymbol(className) == null) {
            enterSymbol(new NodeObject(className, this.scopeLevel), this.scopeLevel);
        }
        else
            throw new RuntimeException("ERROR: Class name is already in use.");

        visitClassBlock(classDeclarationNode.getClassBlockNode());
    }

    private void visitClassBlock(ClassBlockNode classBlockNode) {
        openScope();
        for(FunctionDeclarationNode funcNode : classBlockNode.getFunctionDeclarationNodes())
            visitFunctionDeclaration(funcNode);

        for(DeclarationNode declNode : classBlockNode.getDeclarationNodes())
            visitVariableDeclaration((VariableDeclarationNode) declNode);
        closeScope();
    }

    /*
    private void visitRectangleDeclaration(RectangleDeclarationNode rectangleDeclarationNode) {
        //
    }
    */

    private void visitFunctionDeclaration(FunctionDeclarationNode functionDeclarationNode) {
        String functionName = functionDeclarationNode.getFunctionName();
        Enums.ReturnType dataType = functionDeclarationNode.getReturnType();

        StringBuilder sb = new StringBuilder();
        String attributes = null;

        // Find the function parameters and turn them into a string
        if (functionDeclarationNode.getFunctionArgNodes() != null) {
            for (FunctionArgNode functionArgNode : functionDeclarationNode.getFunctionArgNodes()) {
                sb.append(functionArgNode.getDataType());
                sb.append(" ");
                sb.append(functionArgNode.getVariableName());
            }
            attributes = sb.toString();
        }

        // If a function with this name doesn't exist
        if(retrieveSymbol(functionName) == null) {
            enterSymbol(new NodeObject(dataType, functionName, this.scopeLevel, attributes), this.scopeLevel);
        }
        // If a function with the same name exists but doesn't have the same parameters
        else if (!(retrieveSymbol(functionName).getAttributes().equals(attributes))) {
            enterSymbol(new NodeObject(dataType, functionName, this.scopeLevel, attributes), this.scopeLevel);
        }
        else {
            throw new RuntimeException("ERROR: Function already exist with the same parameters");
        }

        visitBlock(functionDeclarationNode.getBlockNode());
    }
}


