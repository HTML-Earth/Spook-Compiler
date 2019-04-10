package dk.aau.cs.d403.semantics;

import java.util.HashMap;

import dk.aau.cs.d403.ast.statements.*;
import dk.aau.cs.d403.ast.statements.VariableDeclarationNode.DataType;
import dk.aau.cs.d403.ast.structure.*;

public class SymbolTableFilling implements SymbolTable{

    public HashMap<String, NodeObject> symbolTable;
    public String scopeLevel;
    private int level = 1;

    @Override
    public void openScope() {
        this.scopeLevel = "Scope" + level;
    }

    @Override
    public void closeScope() {
        this.level += 1;
    }

    @Override
    public void enterSymbol(String scopeLevel, NodeObject object) {
        symbolTable.put(scopeLevel, object);
    }

    @Override
    public NodeObject retrieveSymbol(String name) {
        return symbolTable.get(name);
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

    public void visitMain(MainNode mainNode) {
        visitBlock(mainNode.getBlockNode());
    }

    public void visitBlock(BlockNode blockNode) {
        openScope();
        for (StatementNode statementNode: blockNode.getStatementNodes()) {
            visitStatement(statementNode);
        }
        closeScope();
    }

    public void visitStatement(StatementNode statementNode) {
        if (statementNode instanceof VariableDeclarationNode)
            visitVariableDeclaration((VariableDeclarationNode) statementNode);
        else if (statementNode instanceof AssignmentNode)
            visitAssignment((AssignmentNode) statementNode);
    }

    public void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
        String variableName = variableDeclarationNode.getVariableName();

        // If a variable doesn't exist
        if(retrieveSymbol(variableName) == null) {
            DataType declarationType = variableDeclarationNode.getDataType();

            enterSymbol(this.scopeLevel, new NodeObject(declarationType, variableName, this.scopeLevel));
        }
        // If a variable already existed but not in the same scope
        else if (!(retrieveSymbol(variableName).getScopeLevel().equals(this.scopeLevel))) {
            DataType declarationType = variableDeclarationNode.getDataType();

            enterSymbol(this.scopeLevel, new NodeObject(declarationType, variableName, this.scopeLevel));
        }
        // If a variable already existed in the same scope
        else {
            throw new Error("ERROR: Variable name is already in use.");
        }
    }

    public void visitAssignment(AssignmentNode assignmentNode) {
        String variableName = assignmentNode.getVariableName();

        // If a variable exists
        if(retrieveSymbol(variableName) != null) {
            // If the variable has the same scope level as the Node
            if(retrieveSymbol(variableName).getScopeLevel().equals(this.scopeLevel)) {
                DataType assignmentType = retrieveSymbol(assignmentNode.getVariableName()).getType();

                enterSymbol(this.scopeLevel, new NodeObject(assignmentType, variableName, this.scopeLevel));
            }
        }
        else {
            throw new Error("ERROR: Variable is not declared in this scope.");
        }
    }

    public void visitClassDeclaration(ClassDeclarationNode classDeclarationNode) {
        String className = classDeclarationNode.getClassName();

        // If a class with this name doesn't exist
        if(retrieveSymbol(className) != null) {
            enterSymbol(this.scopeLevel, new NodeObject(className, this.scopeLevel));
        }
        else
            throw new Error("ERROR: Class name is already in use.");
    }

    public void visitRectangleDeclaration(RectangleDeclarationNode rectangleDeclarationNode) {
        //
    }

    public void visitFunctionDeclaration(FunctionDeclarationNode functionDeclarationNode) {
        String functionName = functionDeclarationNode.getFunctionName();

        StringBuilder sb = new StringBuilder();
        String attributes;

        // Find the function parameters and turn them into a string
        for (FunctionArgNode functionArgNode : functionDeclarationNode.getFunctionArgNodes()) {
            sb.append(functionArgNode.getDataType());
            sb.append(" ");
            sb.append(functionArgNode.getDataType());
        }
        attributes = sb.toString();

        // If a function with this name doesn't exist
        if(retrieveSymbol(functionName) != null) {
            enterSymbol(this.scopeLevel, new NodeObject(functionName, this.scopeLevel, attributes));
        }
        // If a function with the same name exists but doesn't have the same parameters
        else if (!(retrieveSymbol(functionName).getAttributes().equals(attributes))) {
            enterSymbol(this.scopeLevel, new NodeObject(functionName, this.scopeLevel, attributes));
        }
        else {
            throw new Error("ERROR: Function already exist with the same parameters");
        }
    }
}


