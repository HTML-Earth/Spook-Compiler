package dk.aau.cs.d403.semantics;

import java.util.*;

import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.ast.statements.*;
import dk.aau.cs.d403.ast.structure.*;

public class SymbolTableFilling implements SymbolTable{

    private HashMap<String, NodeObject> symbolTable;
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
    public void enterSymbol(String name, NodeObject object) {
        if(retrieveSymbol(name) != null) {
            String varNumber = "0";
            varNumber += name;
            symbolTable.put(varNumber, object);
        }
        else
            symbolTable.put(name, object);
    }

    @Override
    public NodeObject retrieveSymbol(String name) {
        return symbolTable.get(name);
    }

    public void printSymbolTable() {
        System.out.println("Size of symbol table: " + symbolTable.size());

        System.out.println("Symbol table:\n----------------------------------");
        System.out.println(String.format("%5s, %5s, %5s %5s, %5s, %5s", "Name", "Data type", "Class type", "Return type", "Attributes", "Scopelevel"));
        for (Map.Entry entry : symbolTable.entrySet()) {
            System.out.println(String.format("%5s, %5s", entry.getKey(), entry.getValue()));
        }
        System.out.println("----------------------------------");
    }

    private void setupPredefinedElements(ProgramNode programNode) {
        // Lists
        ArrayList<FunctionDeclarationNode> shapeFunctions = new ArrayList<>();
        ArrayList<DeclarationNode> shapeDeclarations = new ArrayList<>();
        ArrayList<StatementNode> setPositionStatements = new ArrayList<>();
        ArrayList<FunctionArgNode> positionFunctionArgs = new ArrayList<>();

        // Variable Declarations
        VariableDeclarationNode positionXDecl = new VariableDeclarationNode(Enums.DataType.INT, "positionX");
        VariableDeclarationNode positionYDecl = new VariableDeclarationNode(Enums.DataType.INT, "positionY");
        shapeDeclarations.add(positionXDecl);
        shapeDeclarations.add(positionYDecl);

        // Function Blocks

        //StatementNode setPositionXAssign = new AssignmentNode("positionX", "funcPositionX");
        //StatementNode setPositionYAssign = new AssignmentNode("positionY", "funcPositionY");

        //setPositionStatements.add(setPositionXAssign);
        //setPositionStatements.add(setPositionYAssign);
        BlockNode positionBlockNode = new BlockNode(setPositionStatements);

        // Position function arguments
        FunctionArgNode positionXArg = new FunctionArgNode(Enums.DataType.INT, "funcPositionX");
        FunctionArgNode positionYArg = new FunctionArgNode(Enums.DataType.INT, "funcPositionY");
        positionFunctionArgs.add(positionXArg);
        positionFunctionArgs.add(positionYArg);

        // Function Declarations
        FunctionDeclarationNode positionFunction = new FunctionDeclarationNode(Enums.ReturnType.VOID, "position", positionFunctionArgs, positionBlockNode);
        shapeFunctions.add(positionFunction);

        // Predefined Class Block Nodes
        ClassBlockNode shapeBlockNode = new ClassBlockNode(shapeDeclarations, shapeFunctions);
        ClassBlockNode colorBlockNode = new ClassBlockNode(null, null);

        // Predefined Classes
        ClassDeclarationNode shapeClass = new ClassDeclarationNode("Shape", shapeBlockNode);
        ClassDeclarationNode circleClass = new ClassDeclarationNode("Circle", shapeBlockNode);
        ClassDeclarationNode rectangleClass = new ClassDeclarationNode("Rectangle", shapeBlockNode);
        ClassDeclarationNode triangleClass = new ClassDeclarationNode("Triangle", shapeBlockNode);
        ClassDeclarationNode colorClass = new ClassDeclarationNode("Color", colorBlockNode);


        // Enter classes into the program node
        programNode.getClassDeclarationNodes().add(shapeClass);
        programNode.getClassDeclarationNodes().add(circleClass);
        programNode.getClassDeclarationNodes().add(rectangleClass);
        programNode.getClassDeclarationNodes().add(triangleClass);
        programNode.getClassDeclarationNodes().add(colorClass);
    }


    public void visitProgram(ProgramNode programNode) {
        //setupPredefinedElements(programNode);
        openScope();

        visitMain(programNode.getMainNode());

        for (ClassDeclarationNode classDecl : programNode.getClassDeclarationNodes()) {
            visitClassDeclaration(classDecl);
        }

        for (FunctionDeclarationNode functionDecl : programNode.getFunctionDeclarationNodes()) {
            visitFunctionDeclaration(functionDecl);
        }

        closeScope();
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
        else if (statementNode instanceof ObjectFunctionCallNode)
            visitObjectFunctionCall((ObjectFunctionCallNode) statementNode);
    }

    private void visitVariableDeclaration(VariableDeclarationNode variableDeclarationNode) {
        String variableName = variableDeclarationNode.getVariableName();
        Enums.DataType declarationType = variableDeclarationNode.getDataType();

        // SCOPE CHECK: If a variable doesn't exist
        if(retrieveSymbol(variableName) == null) {
            enterSymbol(variableName, new NodeObject(declarationType, variableName, this.scopeLevel));
        }
        // SCOPE CHECK: If a variable already existed but not of the same type
        else if (!(retrieveSymbol(variableName).getType().equals(declarationType))) {
            enterSymbol(variableName, new NodeObject(declarationType, variableName, this.scopeLevel));
        }
        // SCOPE CHECK: If a variable already existed but not in the same scope
        else if (!(retrieveSymbol(variableName).getScopeLevel().equals(this.scopeLevel))) {
            enterSymbol(variableName, new NodeObject(declarationType, variableName, this.scopeLevel));
        }
        // If a variable already existed in the same scope
        else {
            throw new RuntimeException("ERROR: Variable name is already in use.");
        }
    }

    private void visitObjectDeclaration(ObjectDeclarationNode objectDeclarationNode) {
        String variableName = objectDeclarationNode.getVariableName();
        Enums.ClassType objectType = objectDeclarationNode.getClassType();
        ArrayList<ObjectArgumentNode> objectArguments = objectDeclarationNode.getObjectArguments();

        // SCOPE CHECK: If a variable doesn't exist
        if (retrieveSymbol(variableName) == null) {
            enterSymbol(variableName, new NodeObject(objectType, variableName, this.scopeLevel, objectArguments));
        }
        // SCOPE CHECK: If a variable already existed but not of the same type
        else if (!(retrieveSymbol(variableName).getClassType().equals(objectType))) {
            enterSymbol(variableName, new NodeObject(objectType, variableName, this.scopeLevel, objectArguments));
        }
        // SCOPE CHECK: If a variable already existed but not in the same scope
        else if (!(retrieveSymbol(variableName).getScopeLevel().equals(this.scopeLevel))) {
            enterSymbol(variableName, new NodeObject(objectType, variableName, this.scopeLevel, objectArguments));
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

                enterSymbol(variableName, new NodeObject(assignmentType, variableName, this.scopeLevel, expression));
            }
            else
                throw new RuntimeException("ERROR: Variable is not declared in this scope.");
        }
        else {
            throw new RuntimeException("ERROR: Variable is not declared.");
        }
    }

    private void visitObjectFunctionCall(ObjectFunctionCallNode objectFunctionCallNode) {
        String objectVariableName = objectFunctionCallNode.getObjectVariableName();
        String functionName = objectFunctionCallNode.getFunctionName();
        ArrayList<ObjectArgumentNode> objectArgumentNodes = objectFunctionCallNode.getObjectArguments();

        // SCOPE CHECK: If a variable with the same name did not exist
        if(retrieveSymbol(objectVariableName) == null) {
            enterSymbol(objectVariableName, new NodeObject(objectVariableName, functionName, this.scopeLevel, objectArgumentNodes));
        }
        else
            throw new RuntimeException("ERROR: Object is not declared.");
    }

    private void visitClassDeclaration(ClassDeclarationNode classDeclarationNode) {
        String className = classDeclarationNode.getClassName();

        // SCOPE CHECK: If a class with this name doesn't exist
        if(retrieveSymbol(className) == null) {
            enterSymbol(className, new NodeObject(className, this.scopeLevel));
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
            enterSymbol(functionName, new NodeObject(returnType, functionName, this.scopeLevel, functionArgs));
        }
        // SCOPE CHECK: If a function with the same name exists but is in a different scope
        else if(!(retrieveSymbol(functionName).getScopeLevel().equals(this.scopeLevel))) {
            enterSymbol(functionName, new NodeObject(returnType, functionName, this.scopeLevel, functionArgs));
        }
        // SCOPE CHECK: If a function with the same name exists but the arguments are different
        else if(!(retrieveSymbol(functionName).getFunctionArguments().toString().equals(functionArgs.toString()))) {
            enterSymbol(functionName, new NodeObject(returnType, functionName, this.scopeLevel, functionArgs));
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



