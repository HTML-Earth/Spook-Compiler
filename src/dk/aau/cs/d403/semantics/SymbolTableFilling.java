package dk.aau.cs.d403.semantics;

import dk.aau.cs.d403.ast.*;
import java.util.HashMap;
import dk.aau.cs.d403.ast.VariableDeclarationNode.DataType;

public class SymbolTableFilling implements SymbolTable{

    public HashMap<String, NodeObject> SymbolTable;
    public String id;
    private int level = 1;

    @Override
    public void openScope() {
        this.id = "Scope" + level;
    }

    @Override
    public void closeScope() {
        this.level += 1;
    }

    @Override
    public void enterSymbol(String name, NodeObject object) {
        SymbolTable.put(name, object);
    }

    @Override
    public NodeObject retrieveSymbol(String name) {
        return SymbolTable.get(name);
    }

    public void visitProgram(ProgramNode programNode) {
        visitMain(programNode.getMainNode());
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

        if(retrieveSymbol(variableName) == null) {
            DataType declarationType = variableDeclarationNode.getDataType();

            enterSymbol(this.id, new NodeObject(declarationType, variableName));
        }
        else {
            throw new Error("ERROR: Variable name is already in use.");
        }
    }

    public void visitAssignment(AssignmentNode assignmentNode) {
        String variableName = assignmentNode.getVariableName();
        if(retrieveSymbol(variableName) != null) {
            DataType assignmentType = retrieveSymbol(assignmentNode.getVariableName()).getType();

            enterSymbol(this.id, new NodeObject(assignmentType, variableName));
        }
        else {
            throw new Error("ERROR: Variable is not declared in this scope.");
        }
    }

    public void visitClassDeclaration(ClassDeclarationNode classDeclarationNode) {
        //
    }

    public void visitRectangleDeclaration(RectangleDeclarationNode rectangleDeclarationNode) {
        //
    }

    public void visitFunctionDeclaration(FunctionDeclarationNode functionDeclarationNode) {
        //
    }
}


