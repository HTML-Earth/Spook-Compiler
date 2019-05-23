package dk.aau.cs.d403.optimization;

import dk.aau.cs.d403.errorhandling.CompilerException;
import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.ast.statements.*;
import dk.aau.cs.d403.ast.structure.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Unrolling {
    private HashMap<String, VariableDeclarationNode> variableDeclarations;
    private Stack<HashMap<String, Integer>> variableNameUsage;
    private ArrayList<FunctionDeclarationNode> functionDeclarationNodes;
    private void openScope() {
        HashMap<String, Integer> newVariableMap = new HashMap<>();
        variableNameUsage.push(newVariableMap);
    }

    private void closeScope() {
        variableNameUsage.pop();
    }

    private void useVariableName(String variableName) {
        int currentUsage = 0;

        if (variableNameUsage.peek().get(variableName) != null)
            currentUsage = variableNameUsage.peek().get(variableName) + 1;

        variableNameUsage.peek().put(variableName, currentUsage);
    }

    private String getNewVariableName(String variableName) {
        if (variableNameUsage.peek().get(variableName) != null && variableNameUsage.peek().get(variableName) > 0)
            return variableName + "_v" +  variableNameUsage.peek().get(variableName);
        else
            return variableName;
    }

    public ProgramNode unrollProgram(ProgramNode programNode) {
        variableDeclarations = new HashMap<>();
        variableNameUsage = new Stack<>();

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
        openScope();
        ArrayList<StatementNode> statementNodes = unrollStatementNodes(blockNode.getStatementNodes());
        closeScope();

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
            else if (statementNode instanceof AssignmentNode)
                newStatementNodes.add(unrollAssignment((AssignmentNode)statementNode));
            else if (statementNode instanceof ObjectFunctionCallNode)
                newStatementNodes.add(unrollObjectFunctionCall((ObjectFunctionCallNode)statementNode));
            else if (statementNode instanceof NonObjectFunctionCallNode) {
                newStatementNodes.addAll(unrollNonObjectFunctionCall((NonObjectFunctionCallNode)statementNode));
            }
            else
                newStatementNodes.add(statementNode);
        }

        return newStatementNodes;
    }

    private ArrayList<StatementNode> unrollStatementNode(StatementNode statementNode) {
        ArrayList<StatementNode> statementNodes = new ArrayList<>();
        statementNodes.add(statementNode);
        return unrollStatementNodes(statementNodes);
    }

    private void renameVarsInStatement(StatementNode statementNode, String oldName, String newName) {
        if (statementNode instanceof DeclarationNode)
            renameVarsInDeclaration((DeclarationNode)statementNode, oldName, newName);
        else if (statementNode instanceof AssignmentNode)
            renameVarsInAssignment((AssignmentNode) statementNode, oldName, newName);
        else if (statementNode instanceof ObjectFunctionCallNode)
            renameVarsObjectFunctionCall((ObjectFunctionCallNode) statementNode, oldName, newName);
        else if (statementNode instanceof NonObjectFunctionCallNode)
            renameVarsInNonObjectFunctionCall((NonObjectFunctionCallNode) statementNode, oldName, newName);
        else
            throw new CompilerException("NOT YET IMPLEMENTED");
    }

    private void renameVarsInDeclaration(DeclarationNode declarationNode, String oldName, String newName) {
        if (declarationNode instanceof VariableDeclarationNode) {
            for (VarDeclInitNode varDeclInitNode : ((VariableDeclarationNode)declarationNode).getVarDeclInitNodes()) {
                renameVarsInAssignment(varDeclInitNode.getAssignmentNode(), oldName, newName);
            }
        }
        else if (declarationNode instanceof ObjectDeclarationNode) {
            throw new CompilerException("NOT YET IMPLEMENTED");
        }
    }

    private void renameVarsInAssignment(AssignmentNode assignmentNode, String oldName, String newName) {
        if (assignmentNode.getVariableName().equals(oldName))
            assignmentNode.renameVariable(newName);

        renameVarsInExpression(assignmentNode.getExpressionNode(), oldName, newName);
    }

    private void renameVarsInExpression(ExpressionNode expressionNode, String oldName, String newName) {
        if (expressionNode instanceof ArithExpressionNode) {
            ArithExpressionNode arithExpressionNode = (ArithExpressionNode)expressionNode;
            renameVarsInLowPrecedence(arithExpressionNode.getLowPrecedenceNode(), oldName, newName);
        }
        else if (expressionNode instanceof BoolExpressionNode) {
            BoolExpressionNode boolExpressionNode = (BoolExpressionNode)expressionNode;
            renameVarsInBoolOperations(boolExpressionNode.getBoolOperationsNode(), oldName, newName);
        }
        else if (expressionNode instanceof Vector4ExpressionNode) {
            Vector4ExpressionNode vector4ExpressionNode = (Vector4ExpressionNode)expressionNode;
            renameVarsInExpression(vector4ExpressionNode.getArithExpressionNode1(), oldName, newName);
            renameVarsInExpression(vector4ExpressionNode.getArithExpressionNode2(), oldName, newName);
            renameVarsInExpression(vector4ExpressionNode.getArithExpressionNode3(), oldName, newName);
            renameVarsInExpression(vector4ExpressionNode.getArithExpressionNode4(), oldName, newName);
        }
        else if (expressionNode instanceof Vector3ExpressionNode) {
            Vector3ExpressionNode vector3ExpressionNode = (Vector3ExpressionNode)expressionNode;
            renameVarsInExpression(vector3ExpressionNode.getArithExpressionNode1(), oldName, newName);
            renameVarsInExpression(vector3ExpressionNode.getArithExpressionNode2(), oldName, newName);
            renameVarsInExpression(vector3ExpressionNode.getArithExpressionNode3(), oldName, newName);
        }
        else if (expressionNode instanceof Vector2ExpressionNode) {
            Vector2ExpressionNode vector2ExpressionNode = (Vector2ExpressionNode)expressionNode;
            renameVarsInExpression(vector2ExpressionNode.getArithExpressionNode1(), oldName, newName);
            renameVarsInExpression(vector2ExpressionNode.getArithExpressionNode2(), oldName, newName);
        }
        else throw new CompilerException("NOT YET IMPLEMENTED");
    }

    private void renameVarsInLowPrecedence(LowPrecedenceNode lowPrecedenceNode, String oldName, String newName) {
        for (HighPrecedenceNode highPrecedenceNode : lowPrecedenceNode.getHighPrecedenceNodes())
            renameVarsInHighPrecedence(highPrecedenceNode, oldName, newName);
    }

    private void renameVarsInHighPrecedence(HighPrecedenceNode highPrecedenceNode, String oldName, String newName) {
        for (AtomPrecedenceNode atomPrecedenceNode : highPrecedenceNode.getAtomPrecedenceNodes())
            renameVarsInAtomPrecedence(atomPrecedenceNode, oldName, newName);
    }

    private void renameVarsInAtomPrecedence(AtomPrecedenceNode atomPrecedenceNode, String oldName, String newName) {
        if (atomPrecedenceNode.getLowPrecedenceNode() != null)
            renameVarsInLowPrecedence(atomPrecedenceNode.getLowPrecedenceNode(), oldName, newName);

        if (atomPrecedenceNode.getOperand() != null)
            if (atomPrecedenceNode.getOperand().getVariableName().equals(oldName))
                atomPrecedenceNode.getOperand().renameVariable(newName);
    }

    private void renameVarsObjectFunctionCall(ObjectFunctionCallNode objectFunctionCallNode, String oldName, String newName) {
        for (ObjectArgumentNode objectArgumentNode : objectFunctionCallNode.getObjectArguments()) {
            if (objectArgumentNode.isOnlyVariableName()) {
                if (objectArgumentNode.getVariableName().equals(oldName))
                    objectArgumentNode.renameVariable(newName);
            }
        }
    }

    private void renameVarsInBoolOperations(BoolOperationsNode boolOperationsNode, String oldName, String newName) {
        throw new CompilerException("NOT YET IMPLEMENTED");
    }

    private void renameVarsInNonObjectFunctionCall(NonObjectFunctionCallNode nonObjectFunctionCallNode, String oldName, String newName) {
        throw new CompilerException("NOT YET IMPLEMENTED");
    }

    private ObjectFunctionCallNode unrollObjectFunctionCall(ObjectFunctionCallNode objectFunctionCallNode) {
        ObjectFunctionCallNode newObjFunCall = null;

        String newObjName = getNewVariableName(objectFunctionCallNode.getObjectVariableName());

        if (objectFunctionCallNode.getObjectArguments() != null) {
            ArrayList<ObjectArgumentNode> objectArgumentNodes = unrollObjectArguments(objectFunctionCallNode.getObjectArguments());
            newObjFunCall = new ObjectFunctionCallNode(newObjName, objectFunctionCallNode.getFunctionName(), objectArgumentNodes);
        }
        else
            newObjFunCall = new ObjectFunctionCallNode(newObjName, objectFunctionCallNode.getFunctionName());

        return newObjFunCall;
    }

    private ArrayList<StatementNode> unrollNonObjectFunctionCall(NonObjectFunctionCallNode nonObjectFunctionCallNode) {
        ArrayList<StatementNode> statementNodes = new ArrayList<>();

        String functionName = nonObjectFunctionCallNode.getFunctionName();
        boolean foundFunction = false;
        boolean correctArguments = false;

        for (FunctionDeclarationNode declarationNode : functionDeclarationNodes) {

            if (functionName.equals(declarationNode.getFunctionName())) {
                foundFunction = true;

                // ARGUMENTS
                if (nonObjectFunctionCallNode.getArgumentNodes() != null) {
                    if (declarationNode.getFunctionArgNodes() != null) {
                        if (nonObjectFunctionCallNode.getArgumentNodes().size() == declarationNode.getFunctionArgNodes().size()) {
                            correctArguments = true;

                            // NO RETURN TYPE
                            if (declarationNode.getReturnType() == null) {
                                for (int i = 0; i < declarationNode.getFunctionArgNodes().size(); i++) {
                                    FunctionArgNode argNode = declarationNode.getFunctionArgNodes().get(i);
                                    ObjectArgumentNode objArgNode = nonObjectFunctionCallNode.getArgumentNodes().get(i);

                                    if (objArgNode.isOnlyVariableName()) {
                                        for (StatementNode statementNode : declarationNode.getBlockNode().getStatementNodes()) {
                                            renameVarsInStatement(statementNode, argNode.getVariableName(), objArgNode.getVariableName());
                                        }
                                    }
                                    else {
                                        // VARIABLE DECLARATIONS
                                        if (argNode.getDataType() != null) {
                                            ExpressionNode expression;
                                            if (objArgNode.getBoolExpression() != null) {
                                                expression = objArgNode.getBoolExpression();
                                            }
                                            else if (objArgNode.getLowPrecedence() != null) {
                                                expression = new ArithExpressionNode(objArgNode.getLowPrecedence());
                                            }
                                            else throw new CompilerException("Invalid argument", objArgNode.getCodePosition());

                                            VarDeclInitNode varDeclInit = new VarDeclInitNode(argNode.getVariableName(), expression);
                                            VariableDeclarationNode varDec = new VariableDeclarationNode(argNode.getDataType(), varDeclInit);
                                            statementNodes.add(varDec);
                                        }

                                        // OBJECT DECLARATIONS
                                        else if (argNode.getClassName() != null) {
                                            throw new CompilerException("This should not happen. An argument of object type should only be a single variable name", nonObjectFunctionCallNode.getCodePosition());
                                        }
                                    }
                                }
                                statementNodes.addAll(declarationNode.getBlockNode().getStatementNodes());
                            }
                            // RETURN TYPE
                            else throw new CompilerException("Only functions that return Void are implemented");
                        }
                    }
                }

                //NO ARGUMENTS
                else {
                    if (declarationNode.getFunctionArgNodes() == null) {
                        correctArguments = true;

                        if (declarationNode.getReturnType() == null) {
                            statementNodes.addAll(declarationNode.getBlockNode().getStatementNodes());
                        }
                        else throw new CompilerException("Only functions that return Void are implemented");
                    }
                }
            }
        }

        if (!foundFunction)
            throw new CompilerException("No function '" + functionName + "' was found", nonObjectFunctionCallNode.getCodePosition());

        if (!correctArguments)
            throw new CompilerException("Amount of arguments does not match", nonObjectFunctionCallNode.getCodePosition());

        return statementNodes;
    }

    private DeclarationNode unrollDeclaration(DeclarationNode declarationNode) {
        if (declarationNode instanceof VariableDeclarationNode) {
            Enums.DataType dataType = ((VariableDeclarationNode)declarationNode).getDataType();
            ArrayList<VarDeclInitNode> varDeclInitNodes = new ArrayList<>();

            VariableDeclarationNode visitedVariableDeclarationNode = new VariableDeclarationNode(dataType, varDeclInitNodes);

            for (VarDeclInitNode varDeclInitNode : ((VariableDeclarationNode)declarationNode).getVarDeclInitNodes()) {
                String variableName = varDeclInitNode.getAssignmentNode().getVariableName();
                useVariableName(variableName);

                String newVarName = getNewVariableName(variableName);
                ExpressionNode newExpressionNode = unrollExpression(varDeclInitNode.getAssignmentNode().getExpressionNode());

                AssignmentNode newAssignmentNode = new AssignmentNode(newVarName, newExpressionNode);
                newAssignmentNode.setCodePosition(varDeclInitNode.getAssignmentNode().getCodePosition());

                VarDeclInitNode newVarDeclInit = new VarDeclInitNode(newAssignmentNode);
                newVarDeclInit.setCodePosition(varDeclInitNode.getCodePosition());

                visitedVariableDeclarationNode.getVarDeclInitNodes().add(newVarDeclInit);
                variableDeclarations.put(newVarName, visitedVariableDeclarationNode);
            }

            return visitedVariableDeclarationNode;
        }
        else if (declarationNode instanceof ObjectDeclarationNode) {
            ObjectDeclarationNode objectDeclarationNode = (ObjectDeclarationNode)declarationNode;

            useVariableName(objectDeclarationNode.getVariableName());
            String newObjName = getNewVariableName(objectDeclarationNode.getVariableName());
            ObjectContructorNode newObjectConstructor = objectDeclarationNode.getObjectContructorNode();

            ObjectDeclarationNode visitedObjectDeclarationNode = new ObjectDeclarationNode(objectDeclarationNode.getClassName(), newObjName, newObjectConstructor);
            visitedObjectDeclarationNode.setCodePosition(objectDeclarationNode.getCodePosition());

            return visitedObjectDeclarationNode;
        }
        else
            return declarationNode;
    }

    private AssignmentNode unrollAssignment(AssignmentNode assignmentNode) {
        AssignmentNode newAssignmentNode = null;

        if (assignmentNode.getVariableName() != null) {
            String newVarName = getNewVariableName(assignmentNode.getVariableName());
            newAssignmentNode = new AssignmentNode(newVarName, assignmentNode.getExpressionNode());
        }
        else if (assignmentNode.getSwizzleNode() != null) {
            String newVarName = getNewVariableName(assignmentNode.getSwizzleNode().getVariableName());
            SwizzleNode newSwizzle = new SwizzleNode(newVarName, assignmentNode.getSwizzleNode().getSwizzle());
            newSwizzle.setCodePosition(assignmentNode.getSwizzleNode().getCodePosition());

            newAssignmentNode = new AssignmentNode(assignmentNode.getSwizzleNode(), assignmentNode.getExpressionNode());
        }

        newAssignmentNode.setCodePosition(assignmentNode.getCodePosition());

        return newAssignmentNode;
    }

    private ExpressionNode unrollExpression(ExpressionNode expressionNode) {
        ExpressionNode newExpressionNode = expressionNode;

        if (expressionNode instanceof ArithExpressionNode) {
            ArithExpressionNode arithExpressionNode = (ArithExpressionNode)expressionNode;
            return unrollArithExpression(arithExpressionNode);
        }
        else if (expressionNode instanceof BoolExpressionNode) {
            BoolExpressionNode boolExpressionNode = (BoolExpressionNode)expressionNode;
            return unrollBoolExpression(boolExpressionNode);
        }
        else if (expressionNode instanceof Vector4ExpressionNode) {
            Vector4ExpressionNode vector4ExpressionNode = (Vector4ExpressionNode)expressionNode;
            return unrollVector4Expression(vector4ExpressionNode);
        }
        else if (expressionNode instanceof Vector3ExpressionNode) {
            Vector3ExpressionNode vector3ExpressionNode = (Vector3ExpressionNode)expressionNode;
            return unrollVector3Expression(vector3ExpressionNode);
        }
        else if (expressionNode instanceof Vector2ExpressionNode) {
            Vector2ExpressionNode vector2ExpressionNode = (Vector2ExpressionNode)expressionNode;
            return unrollVector2Expression(vector2ExpressionNode);
        }
        else
            return newExpressionNode;
    }

    private BoolExpressionNode unrollBoolExpression(BoolExpressionNode boolExpressionNode) {
        return boolExpressionNode; //TODO: fill in method
    }

    private Vector4ExpressionNode unrollVector4Expression(Vector4ExpressionNode vector4ExpressionNode) {
        ArithExpressionNode expr1 = unrollArithExpression(vector4ExpressionNode.getArithExpressionNode1());
        ArithExpressionNode expr2 = unrollArithExpression(vector4ExpressionNode.getArithExpressionNode2());
        ArithExpressionNode expr3 = unrollArithExpression(vector4ExpressionNode.getArithExpressionNode3());
        ArithExpressionNode expr4 = unrollArithExpression(vector4ExpressionNode.getArithExpressionNode4());

        Vector4ExpressionNode newVector4Expression = new Vector4ExpressionNode(expr1, expr2, expr3, expr4);

        newVector4Expression.setCodePosition(vector4ExpressionNode.getCodePosition());
        return newVector4Expression;
    }

    private Vector3ExpressionNode unrollVector3Expression(Vector3ExpressionNode vector3ExpressionNode) {
        ArithExpressionNode expr1 = unrollArithExpression(vector3ExpressionNode.getArithExpressionNode1());
        ArithExpressionNode expr2 = unrollArithExpression(vector3ExpressionNode.getArithExpressionNode2());
        ArithExpressionNode expr3 = unrollArithExpression(vector3ExpressionNode.getArithExpressionNode3());

        Vector3ExpressionNode newVector3Expression = new Vector3ExpressionNode(expr1, expr2, expr3);

        newVector3Expression.setCodePosition(vector3ExpressionNode.getCodePosition());
        return newVector3Expression;
    }

    private Vector2ExpressionNode unrollVector2Expression(Vector2ExpressionNode vector2ExpressionNode) {
        ArithExpressionNode expr1 = unrollArithExpression(vector2ExpressionNode.getArithExpressionNode1());
        ArithExpressionNode expr2 = unrollArithExpression(vector2ExpressionNode.getArithExpressionNode2());

        Vector2ExpressionNode newVector2Expression = new Vector2ExpressionNode(expr1, expr2);

        newVector2Expression.setCodePosition(vector2ExpressionNode.getCodePosition());
        return newVector2Expression;
    }

    private ArithExpressionNode unrollArithExpression(ArithExpressionNode arithExpressionNode) {
        LowPrecedenceNode newLowPre = unrollLowPrecedence(arithExpressionNode.getLowPrecedenceNode());

        ArithExpressionNode newArithExpressionNode = new ArithExpressionNode(newLowPre);

        newArithExpressionNode.setCodePosition(arithExpressionNode.getCodePosition());
        return newArithExpressionNode;
    }

    private LowPrecedenceNode unrollLowPrecedence(LowPrecedenceNode lowPrecedenceNode) {
        LowPrecedenceNode newLowPre = null;

        ArrayList<HighPrecedenceNode> highPrecedenceNodes = new ArrayList<>();

        for(HighPrecedenceNode highPrecedenceNode: lowPrecedenceNode.getHighPrecedenceNodes()) {
            highPrecedenceNodes.add(unrollHighPrecedence(highPrecedenceNode));
        }

        if (lowPrecedenceNode.getOperators() != null)
            newLowPre = new LowPrecedenceNode(highPrecedenceNodes, lowPrecedenceNode.getOperators());
        else
            newLowPre = new LowPrecedenceNode(highPrecedenceNodes);

        newLowPre.setCodePosition(lowPrecedenceNode.getCodePosition());

        return newLowPre;
    }

    private HighPrecedenceNode unrollHighPrecedence(HighPrecedenceNode highPrecedenceNode) {
        HighPrecedenceNode newHighPre = null;
        ArrayList<AtomPrecedenceNode> atomPrecedenceNodes = new ArrayList<>();

        for(AtomPrecedenceNode atomPrecedenceNode : highPrecedenceNode.getAtomPrecedenceNodes()) {
            atomPrecedenceNodes.add(unrollAtomPrecedence(atomPrecedenceNode));
        }

        if (highPrecedenceNode.getOperators() != null)
            newHighPre = new HighPrecedenceNode(atomPrecedenceNodes, highPrecedenceNode.getOperators());
        else
            newHighPre = new HighPrecedenceNode(atomPrecedenceNodes);

        newHighPre.setCodePosition(highPrecedenceNode.getCodePosition());

        return newHighPre;
    }

    private AtomPrecedenceNode unrollAtomPrecedence(AtomPrecedenceNode atomPrecedenceNode) {
        AtomPrecedenceNode newAtomPrecedenceNode = null;

        if (atomPrecedenceNode.getOperand() != null) {
            ArithOperandNode newOperand = unrollArithOperand(atomPrecedenceNode.getOperand());

            if (atomPrecedenceNode.getOperator() != null)
                newAtomPrecedenceNode = new AtomPrecedenceNode(atomPrecedenceNode.getOperator(), newOperand);
            else
                newAtomPrecedenceNode = new AtomPrecedenceNode(newOperand);
        }
        else if (atomPrecedenceNode.getLowPrecedenceNode() != null) {
            LowPrecedenceNode newLoPre = unrollLowPrecedence(atomPrecedenceNode.getLowPrecedenceNode());

            newAtomPrecedenceNode = new AtomPrecedenceNode(newLoPre);
        }
        else
            return atomPrecedenceNode;

        newAtomPrecedenceNode.setCodePosition(atomPrecedenceNode.getCodePosition());
        return newAtomPrecedenceNode;
    }

    private ArithOperandNode unrollArithOperand(ArithOperandNode arithOperandNode) {
        ArithOperandNode newArithOperandNode = null;

        NonObjectFunctionCallNode nonObjectFunctionCallNode = arithOperandNode.getNonObjectFunctionCallNode();
        ObjectFunctionCallNode objectFunctionCallNode = arithOperandNode.getObjectFunctionCallNode();
        String variableName = arithOperandNode.getVariableName();
        SwizzleNode swizzleNode = arithOperandNode.getSwizzleNode();

        if (nonObjectFunctionCallNode != null) {
            NonObjectFunctionCallNode newNonObjectFunCall;

            if (nonObjectFunctionCallNode.getArgumentNodes() != null)
                newNonObjectFunCall = new NonObjectFunctionCallNode(nonObjectFunctionCallNode.getFunctionName(), unrollObjectArguments(nonObjectFunctionCallNode.getArgumentNodes()));
            else
                newNonObjectFunCall = new NonObjectFunctionCallNode(nonObjectFunctionCallNode.getFunctionName());

            newNonObjectFunCall.setCodePosition(nonObjectFunctionCallNode.getCodePosition());

            newArithOperandNode = new ArithOperandNode(newNonObjectFunCall);
        }
        else if (objectFunctionCallNode != null) {
            ObjectFunctionCallNode newObjFunCall = unrollObjectFunctionCall(objectFunctionCallNode);
            newArithOperandNode = new ArithOperandNode(newObjFunCall);
        }
        else if (variableName != null) {
            String newVarName = getNewVariableName(variableName);

            newArithOperandNode = new ArithOperandNode(newVarName);
        }
        else if (swizzleNode != null) {
            String newVarName = getNewVariableName(swizzleNode.getVariableName());

            SwizzleNode newSwizzleNode = new SwizzleNode(newVarName, swizzleNode.getSwizzle());
            newSwizzleNode.setCodePosition(swizzleNode.getCodePosition());

            newArithOperandNode = new ArithOperandNode(newSwizzleNode);
        }
        else
            return arithOperandNode;


        newArithOperandNode.setCodePosition(arithOperandNode.getCodePosition());

        return newArithOperandNode;
    }

    private ArrayList<ObjectArgumentNode> unrollObjectArguments(ArrayList<ObjectArgumentNode> objectArgumentNodes) {
        ArrayList<ObjectArgumentNode> newObjectArgs = new ArrayList<>();

        for (ObjectArgumentNode objArg : objectArgumentNodes) {
            if (objArg.getLowPrecedence() != null) {
                LowPrecedenceNode newLowPre = unrollLowPrecedence(objArg.getLowPrecedence());

                ObjectArgumentNode newObjArg = new ObjectArgumentNode(newLowPre);
                newObjArg.setCodePosition(objArg.getCodePosition());
                newObjectArgs.add(newObjArg);
            }
            else if (objArg.getBoolExpression() != null) {
                BoolExpressionNode boolExp = unrollBoolExpression(objArg.getBoolExpression());

                ObjectArgumentNode newObjArg = new ObjectArgumentNode(boolExp);
                newObjArg.setCodePosition(objArg.getCodePosition());
                newObjectArgs.add(newObjArg);
            }
            else
                newObjectArgs.add(objArg);
        }

        return newObjectArgs;
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

                    useVariableName(assignmentNode.getVariableName());
                    String newVarName = getNewVariableName(assignmentNode.getVariableName());

                    ArrayList<VarDeclInitNode> fixedVarDeclInitNodes = new ArrayList<>();
                    fixedVarDeclInitNodes.add(
                        new VarDeclInitNode(
                            new AssignmentNode(newVarName, fixedExpressionNode)
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
                useVariableName(expressionNode1.getAssignmentNode().getVariableName());
                String newVarName = getNewVariableName(expressionNode1.getAssignmentNode().getVariableName());

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
                    unrolledStatementNodes.addAll(unrollStatementNode(conditionalBlockNode.getStatementNode()));
                else if (conditionalBlockNode.getBlockNode() != null)
                    unrolledStatementNodes.addAll(unrollStatementNodes(conditionalBlockNode.getBlockNode().getStatementNodes()));
                else if (conditionalBlockNode.getReturnNode() != null)
                    unrolledStatementNodes.addAll(unrollStatementNode(conditionalBlockNode.getReturnNode())); //TODO: maybe illegal?
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
        else if (expressionNode.getAtomPrecedenceNode() != null)
            return evaluateAtomPrecedence(expressionNode.getAtomPrecedenceNode());
        else if (expressionNode.getVariableDeclarationNode() != null)
            return evaluateVariableDeclaration(expressionNode.getVariableDeclarationNode());
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
        VariableDeclarationNode variableDeclarationNode = variableDeclarations.get(variableName);
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
