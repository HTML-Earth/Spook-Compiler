package dk.aau.cs.d403.semantics;

import dk.aau.cs.d403.ast.*;
import dk.aau.cs.d403.parser.SpookParserBaseVisitor;

public class SymbolTableFilling {
    public void visitProgram(ProgramNode programNode) {
        visitMain(programNode.getMainNode());
    }

    public MainNode visitMain(MainNode mainNode) {
        visitBlock(mainNode.getBlockNode());
        return mainNode;
    }

    public BlockNode visitBlock(BlockNode blockNode) {

        for (StatementNode statementNode: blockNode.getStatementNodes()) {
            visitStatement(statementNode);
        }
        return blockNode;
    }

    public StatementNode visitStatement(StatementNode statementNode) {
        if (statementNode instanceof VariableDeclarationNode) {
            visitVariableDeclaration((VariableDeclarationNode) statementNode);
        }

        visitDeclaration(statementNode.getDeclarationNode);

        vistiAssignment(statementNode.getAssignmentNode);

        visitObjectFunctionCall(statementNode.getObjectFunctionCallNode);


        //
    }

    public VariableDeclarationNode visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
        variableDeclarationNode.getDataType();

    }

    public AssignmentNode visitAssignment(AssignmentNode assignmentNode) {
        visitVariableName(assignmentNode.getVariableName);
        //
        visitExpression(assignmentNode.getExpression);
    }

    public VariableNameNode visitVariableName(VariableNameNode variableNameNode) {
        //
    }

    public ExpressionNode visitExpression(ExpressionNode expressionNode) {

    }
}


