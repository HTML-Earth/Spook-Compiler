package dk.aau.cs.d403.optimization;

import dk.aau.cs.d403.errorhandling.CompilerException;
import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.ast.statements.*;
import dk.aau.cs.d403.ast.structure.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Unrolling {
    private HashMap<String, VariableDeclarationNode> variables;

    public ProgramNode unrollProgram(ProgramNode programNode) {
        variables = new HashMap<>();

        ArrayList<FunctionDeclarationNode> functionDeclarationNodes;
        ArrayList<ClassDeclarationNode> classDeclarationNodes;
        MainNode mainNode;

        functionDeclarationNodes = programNode.getFunctionDeclarationNodes();
        classDeclarationNodes = programNode.getClassDeclarationNodes();
        mainNode = unrollMainNode(programNode.getMainNode());

        ProgramNode newProgramNode = new ProgramNode(mainNode, classDeclarationNodes, functionDeclarationNodes);
        newProgramNode.setCodePosition(programNode.getCodePosition());

        return newProgramNode;
    }

    private MainNode unrollMainNode(MainNode mainNode) {
        BlockNode blockNode = unrollBlockNode(mainNode.getBlockNode());
        MainNode newMainNode = new MainNode(blockNode);
        newMainNode.setCodePosition(mainNode.getCodePosition());
        return newMainNode;
    }

    private BlockNode unrollBlockNode(BlockNode blockNode) {
        ArrayList<StatementNode> statementNodes = unrollStatementNodes(blockNode.getStatementNodes());
        BlockNode newBlockNode = new BlockNode(statementNodes);
        newBlockNode.setCodePosition(blockNode.getCodePosition());
        return newBlockNode;
    }

    private ArrayList<StatementNode> unrollStatementNodes(ArrayList<StatementNode> statementNodes) {
        ArrayList<StatementNode> newStatementNodes = new ArrayList<>();

        for (StatementNode statementNode : statementNodes) {
            if (statementNode instanceof ForLoopStatementNode)
                newStatementNodes.addAll(unrollForLoop((ForLoopStatementNode)statementNode));
            else if (statementNode instanceof DeclarationNode)
                newStatementNodes.add(unrollDeclaration((DeclarationNode)statementNode));
            else
                newStatementNodes.add(statementNode);
        }

        return newStatementNodes;
    }

    private DeclarationNode unrollDeclaration(DeclarationNode declarationNode) {
        if (declarationNode instanceof VariableDeclarationNode) {
            VariableDeclarationNode visitedVariableDeclarationNode = (VariableDeclarationNode)declarationNode;
            for (VarDeclInitNode varDeclInitNode : visitedVariableDeclarationNode.getVarDeclInitNodes()) {
                variables.put(varDeclInitNode.getAssignmentNode().getVariableName(), visitedVariableDeclarationNode);
            }
        }

        return declarationNode;
    }

    private ArrayList<StatementNode> unrollForLoop(ForLoopStatementNode forLoopStatementNode) {
        ArrayList<StatementNode> unrolledStatementNodes = new ArrayList<>();

        ConditionalBlockNode conditionalBlockNode = forLoopStatementNode.getConditionalBlockNode();

        ForLoopExpressionNode expressionNode1 = forLoopStatementNode.getForLoopExpressionNode1();
        ForLoopExpressionNode expressionNode2 = forLoopStatementNode.getForLoopExpressionNode2();

        double expr1 = evaluateForLoopExpression(expressionNode1);
        double expr2 = evaluateForLoopExpression(expressionNode2);

        boolean countDown = false;
        if (expr1 > expr2)
            countDown = true;

        //SIMULATE FOR LOOP ITERATION
        while (countDown ? expr1 >= expr2 : expr1 <= expr2) {

            // CREATE FIXED EXPRESSION NODE

            ArrayList<AtomPrecedenceNode> atomPrecedenceNodes = new ArrayList<>();
            atomPrecedenceNodes.add(
                new AtomPrecedenceNode(
                    new ArithOperandNode(
                        new RealNumberNode(expr1)
                    )
                )
            );

            ArrayList<HighPrecedenceNode> highPrecedenceNodes = new ArrayList<>();
            highPrecedenceNodes.add(new HighPrecedenceNode(atomPrecedenceNodes));

            ArithExpressionNode fixedExpressionNode = new ArithExpressionNode(
                new LowPrecedenceNode(highPrecedenceNodes)
            );

            fixedExpressionNode.setCodePosition(forLoopStatementNode.getCodePosition());

            // CHECK FOR VARIABLE DECLARATION OR ASSIGNMENT

            if (expressionNode1.getVariableDeclarationNode() != null) {
                if (expressionNode1.getVariableDeclarationNode().getVarDeclInitNodes() != null) {
                    //CREATE NEW VARIABLE DECLARATION
                    ArrayList<VarDeclInitNode> varDeclInitNodes = expressionNode1.getVariableDeclarationNode().getVarDeclInitNodes();
                    AssignmentNode assignmentNode = varDeclInitNodes.get(0).getAssignmentNode();

                    ArrayList<VarDeclInitNode> fixedVarDeclInitNodes = new ArrayList<>();
                    fixedVarDeclInitNodes.add(
                        new VarDeclInitNode(
                            new AssignmentNode(assignmentNode.getVariableName(), fixedExpressionNode)
                        )
                    );

                    VariableDeclarationNode newVariableDeclarationNode = new VariableDeclarationNode(
                        expressionNode1.getVariableDeclarationNode().getDataType(), fixedVarDeclInitNodes
                    );
                    newVariableDeclarationNode.setCodePosition(expressionNode1.getCodePosition());

                    //ADD VARIABLE DECLARATION TO STATEMENT LIST
                    unrolledStatementNodes.add(newVariableDeclarationNode);
                }
            }
            else if (expressionNode1.getAssignmentNode() != null) {
                //CREATE NEW ASSIGNMENT
                AssignmentNode newAssignmentNode = new AssignmentNode(
                        expressionNode1.getAssignmentNode().getVariableName(), fixedExpressionNode
                );
                newAssignmentNode.setCodePosition(expressionNode1.getCodePosition());

                //ADD ASSIGNMENT TO STATEMENT LIST
                unrolledStatementNodes.add(newAssignmentNode);
            }

            // ADD LOOP STATEMENTS TO STATEMENT LIST

            if (conditionalBlockNode != null) {
                if (conditionalBlockNode.getStatementNode() != null)
                    unrolledStatementNodes.add(conditionalBlockNode.getStatementNode());
                else if (conditionalBlockNode.getBlockNode() != null)
                    unrolledStatementNodes.addAll(conditionalBlockNode.getBlockNode().getStatementNodes());
                else if (conditionalBlockNode.getReturnNode() != null)
                    unrolledStatementNodes.add(conditionalBlockNode.getReturnNode()); //TODO: maybe illegal?
            }
            else
                throw new CompilerException("Invalid ForLoopStatement", forLoopStatementNode.getCodePosition());

            //INCREMENT OR DECREMENT EXPRESSION
            if (countDown)
                expr1--;
            else
                expr1++;
        }

        return unrolledStatementNodes;
    }

    // FOR LOOP EVALUATION

    private double evaluateForLoopExpression(ForLoopExpressionNode expressionNode) {
        if (expressionNode.getAssignmentNode() != null)
            return evaluateAssignment(expressionNode.getAssignmentNode());
        else if (expressionNode.getAtomPrecedenceNode() != null && expressionNode.getAtomPrecedenceNode().getOperand().getRealNumberNode() != null)
            return expressionNode.getAtomPrecedenceNode().getOperand().getRealNumberNode().getNumber();
        else if (expressionNode.getVariableDeclarationNode() != null)
            return evaluateVariableDeclaration(expressionNode.getVariableDeclarationNode());
        else if (expressionNode.getVariableName() != null)
            return evaluateVariable(expressionNode.getVariableName());
        else
            throw new CompilerException("Invalid for loop expression", expressionNode.getCodePosition());
    }

    private double evaluateVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
        if (variableDeclarationNode.getDataType() == Enums.DataType.NUM) {
            AssignmentNode assignmentNode = variableDeclarationNode.getVarDeclInitNodes().get(0).getAssignmentNode();

            if (assignmentNode != null)
                return evaluateAssignment(variableDeclarationNode.getVarDeclInitNodes().get(0).getAssignmentNode());
            else
                return evaluateVariable(variableDeclarationNode.getVarDeclInitNodes().get(0).getAssignmentNode().getVariableName());
        }
        else
            throw new CompilerException("For loop variable is not Num", variableDeclarationNode.getCodePosition());
    }

    private double evaluateAssignment(AssignmentNode assignmentNode) {
        if (assignmentNode.getSwizzleNode() != null)
            throw new CompilerException("This assignment node probably shouldn't have a swizzle node", assignmentNode.getCodePosition());

        return evaluateExpression(assignmentNode.getExpressionNode());
    }

    private double evaluateVariable(String variableName) {
        VariableDeclarationNode variableDeclarationNode = variables.get(variableName);
        if (variableDeclarationNode != null)
            return evaluateVariableDeclaration(variableDeclarationNode);
        else
            throw new RuntimeException("Variable " + variableName + " not found");
    }

    private double evaluateExpression(ExpressionNode expressionNode) {
        if (expressionNode instanceof ArithExpressionNode) {
            ArithExpressionNode arithExpressionNode = (ArithExpressionNode)expressionNode;
            return evaluateLowPrecedence(arithExpressionNode.getLowPrecedenceNode());
        }
        else
            throw new CompilerException("For loop expression is not arith expression", expressionNode.getCodePosition());
    }

    private double evaluateLowPrecedence(LowPrecedenceNode lowPrecedenceNode) {
        double result = evaluateHighPrecedence(lowPrecedenceNode.getHighPrecedenceNodes().get(0));

        if (lowPrecedenceNode.getOperators() != null) {
            int operatorAmt = lowPrecedenceNode.getOperators().size();
            for (int i = 0; i < operatorAmt; i++) {
                double operand = evaluateHighPrecedence(lowPrecedenceNode.getHighPrecedenceNodes().get(i+1));
                result = evaluateOperation(lowPrecedenceNode.getOperators().get(i), result, operand);
            }
        }

        return result;
    }

    private double evaluateHighPrecedence(HighPrecedenceNode highPrecedenceNode) {
        double result = evaluateAtomPrecedence(highPrecedenceNode.getAtomPrecedenceNodes().get(0));

        if (highPrecedenceNode.getOperators() != null) {
            int operatorAmt = highPrecedenceNode.getOperators().size();
            for (int i = 0; i < operatorAmt; i++) {
                double operand = evaluateAtomPrecedence(highPrecedenceNode.getAtomPrecedenceNodes().get(i+1));
                result = evaluateOperation(highPrecedenceNode.getOperators().get(i), result, operand);
            }
        }

        return result;
    }

    private double evaluateAtomPrecedence(AtomPrecedenceNode atomPrecedenceNode) {
        if (atomPrecedenceNode.getLowPrecedenceNode() != null)
            return evaluateLowPrecedence(atomPrecedenceNode.getLowPrecedenceNode());
        else if (atomPrecedenceNode.getOperator() != null) {
            if (atomPrecedenceNode.getOperator() == Enums.Operator.SUB)
                return 0 - evaluateArithOperand(atomPrecedenceNode.getOperand());
            else if (atomPrecedenceNode.getOperator() == Enums.Operator.ADD)
                return evaluateArithOperand(atomPrecedenceNode.getOperand());
            else
                throw new CompilerException(atomPrecedenceNode.getOperator().toString() + " before single operand is illegal", atomPrecedenceNode.getCodePosition());
        }
        else
            return evaluateArithOperand(atomPrecedenceNode.getOperand());
    }

    private double evaluateArithOperand(ArithOperandNode arithOperandNode) {
        RealNumberNode realNumberNode = arithOperandNode.getRealNumberNode();
        NonObjectFunctionCallNode nonObjectFunctionCallNode = arithOperandNode.getNonObjectFunctionCallNode();
        ObjectFunctionCallNode objectFunctionCallNode = arithOperandNode.getObjectFunctionCallNode();
        String variableName = arithOperandNode.getVariableName();
        SwizzleNode swizzleNode = arithOperandNode.getSwizzleNode();

        if (realNumberNode != null) {
            return realNumberNode.getNumber();
        }
        else if (nonObjectFunctionCallNode != null) {
            throw new CompilerException("Evaluation not yet implemented", arithOperandNode.getCodePosition());
        }
        else if (objectFunctionCallNode != null) {
            throw new CompilerException("Evaluation not yet implemented", arithOperandNode.getCodePosition());
        }
        else if (variableName != null) {
            return evaluateVariable(variableName);
        }
        else if (swizzleNode != null) {
            return evaluateSwizzle(swizzleNode);
        }
        else
            throw new CompilerException("Invalid Arith Operand", arithOperandNode.getCodePosition());
    }

    private double evaluateOperation(Enums.Operator operator, double left, double right) {
        switch (operator) {
            case ADD:
                return left + right;
            case SUB:
                return left - right;
            case MOD:
                return left % right;
            case DIV:
                return left / right;
            case MUL:
                return left * right;
            default:
                throw new RuntimeException("Invalid operation");
        }
    }

    private double evaluateSwizzle(SwizzleNode swizzleNode) {
        throw new CompilerException("Swizzle not yet implemented", swizzleNode.getCodePosition());
    }
}
