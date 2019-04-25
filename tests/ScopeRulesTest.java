import dk.aau.cs.d403.ast.expressions.ExpressionNode;
import dk.aau.cs.d403.ast.expressions.IntegerExpressionNode;
import dk.aau.cs.d403.ast.expressions.IntegerNumberNode;
import dk.aau.cs.d403.ast.statements.*;
import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.structure.*;
import dk.aau.cs.d403.semantics.SymbolTableFilling;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ScopeRulesTest {
    ArrayList<StatementNode> statementNodes;
    ArrayList<ClassDeclarationNode> classDeclarationNodes;
    ArrayList<FunctionDeclarationNode> functionDeclarationNodes;

    ProgramNode programNode;

    SymbolTableFilling symbolTableFilling;

    @BeforeEach
    void setup() {
        statementNodes = new ArrayList<>();
        classDeclarationNodes = new ArrayList<>();
        functionDeclarationNodes = new ArrayList<>();

        symbolTableFilling = new SymbolTableFilling();
    }

    void setupNodes() {
        BlockNode blockNode = new BlockNode(statementNodes);
        MainNode mainNode = new MainNode(blockNode);
        programNode = new ProgramNode(mainNode, classDeclarationNodes, functionDeclarationNodes);
    }

    @AfterEach
    void printSymbolTable() {
        symbolTableFilling.printSymbolTable();
    }

    // Tests if the compiler
    // allows the declaration of variables.
    @Test
    void scopeRuleDeclarationTest01() {
        // Main
        StatementNode statementNode = new VariableDeclarationNode(Enums.DataType.INT, "var1");
        StatementNode statementNode1 = new VariableDeclarationNode(Enums.DataType.FLOAT, "var2");
        statementNodes.add(statementNode);
        statementNodes.add(statementNode1);

        setupNodes();

        symbolTableFilling.visitProgram(programNode);
    }

    // Tests if the compiler
    // throws an error when a variable is declared with
    // the same name in the same scope.
    @Test
    void scopeRuleDeclarationTest02() {
        // Main
        StatementNode statementNode = new VariableDeclarationNode(Enums.DataType.INT, "var1");
        StatementNode statementNode1 = new VariableDeclarationNode(Enums.DataType.INT, "var1");
        statementNodes.add(statementNode);
        statementNodes.add(statementNode1);

        setupNodes();

        assertThrows(RuntimeException.class, ()->{
            symbolTableFilling.visitProgram(programNode);
        });
    }

    // Tests if the compiler
    // allows when a variable is declared with
    // the same name but different type in the same scope.
    @Test
    void scopeRuleDeclarationTest03() {
        // Main
        StatementNode statementNode = new VariableDeclarationNode(Enums.DataType.INT, "var1");
        StatementNode statementNode1 = new VariableDeclarationNode(Enums.DataType.FLOAT, "var1");
        statementNodes.add(statementNode);
        statementNodes.add(statementNode1);

        setupNodes();


        symbolTableFilling.visitProgram(programNode);
    }

    // Tests if the compiler allows
    // the declaration of variables with
    // the same name in main scope and function scope.
    @Test
    void scopeRuleDeclarationTest04() {
        // Main
        StatementNode statementNode1 = new VariableDeclarationNode(Enums.DataType.INT, "var1");
        statementNodes.add(statementNode1);

        // New function
        ArrayList<StatementNode> funcStatementNodes = new ArrayList<>();
        StatementNode statementNode2 = new VariableDeclarationNode(Enums.DataType.INT, "var1");
        funcStatementNodes.add(statementNode2);

        BlockNode funcBlockNode = new BlockNode(funcStatementNodes);
        FunctionDeclarationNode functionDeclarationNode = new FunctionDeclarationNode(Enums.ReturnType.INT, "func1", funcBlockNode);
        functionDeclarationNodes.add(functionDeclarationNode);

        setupNodes();

        symbolTableFilling.visitProgram(programNode);
    }

    // Tests if the compiler allows
    // the declaration of variables with
    // the same name in main scope and class scope.
    @Test
    void scopeRuleDeclarationTest05() {
        // Main
        StatementNode statementNode1 = new VariableDeclarationNode(Enums.DataType.INT, "var1");
        statementNodes.add(statementNode1);

        // New class
        ArrayList<DeclarationNode> classStatementNodes = new ArrayList<>();
        DeclarationNode statementNode2 = new VariableDeclarationNode(Enums.DataType.INT, "var1");
        classStatementNodes.add(statementNode2);

        ClassBlockNode classBlockNode = new ClassBlockNode(classStatementNodes, functionDeclarationNodes);
        ClassDeclarationNode classDeclarationNode = new ClassDeclarationNode("class1", classBlockNode);
        classDeclarationNodes.add(classDeclarationNode);

        setupNodes();
        symbolTableFilling.visitProgram(programNode);
    }

    // Tests if the compiler allows
    // the declaration of variables with
    // the same name in main scope, function scope and function scope within class scope.
    @Test
    void scopeRuleDeclarationTest06() {
        // Main
        StatementNode statementNode1 = new VariableDeclarationNode(Enums.DataType.INT, "var1");
        statementNodes.add(statementNode1);

        // Class declarations
        DeclarationNode declarationNode1 = new VariableDeclarationNode(Enums.DataType.INT, "var1");
        ArrayList<DeclarationNode> declarationNodes = new ArrayList<>();
        declarationNodes.add(declarationNode1);

        // Class function block
        StatementNode statementNode2 = new VariableDeclarationNode(Enums.DataType.INT, "var1");
        ArrayList<StatementNode> functionStatementNodes = new ArrayList<>();
        functionStatementNodes.add(statementNode2);

        BlockNode funcBlockNode = new BlockNode(functionStatementNodes);

        // Class functions
        FunctionDeclarationNode functionNode1 = new FunctionDeclarationNode(Enums.ReturnType.VOID, "func1", funcBlockNode);
        ArrayList<FunctionDeclarationNode> functionNodes = new ArrayList<>();
        functionNodes.add(functionNode1);

        // Class decl
        ClassBlockNode classBlockNode = new ClassBlockNode(declarationNodes, functionNodes);
        ClassDeclarationNode classNode = new ClassDeclarationNode("class1", classBlockNode);
        classDeclarationNodes.add(classNode);

        setupNodes();
        symbolTableFilling.visitProgram(programNode);
    }


    // Tests if the compiler
    // throws an error when a variable is assigned before it is declared
    // in the same scope.
    @Test
    void scopeRuleAssignmentTest01() {
        // Main
            // Assignment
        IntegerNumberNode naturalNumber = new IntegerNumberNode(2);
        ExpressionNode expression1 = new IntegerExpressionNode(naturalNumber);
        StatementNode statement1 = new AssignmentNode("var1", expression1);
        statementNodes.add(statement1);

            // Variable declaration
        StatementNode declaration1 = new VariableDeclarationNode(Enums.DataType.INT, "var1");
        statementNodes.add(declaration1);
        setupNodes();


        assertThrows(RuntimeException.class, ()->{
            symbolTableFilling.visitProgram(programNode);
        });
    }


    // Tests if the compiler allows
    // assignment of variable to a declared variable
    // in the same scope.
    @Test
    void scopeRuleAssignmentTest02() {
        // Main

            // Variable declaration
        StatementNode declaration1 = new VariableDeclarationNode(Enums.DataType.INT, "var1");
        statementNodes.add(declaration1);

            // Assignment
        IntegerNumberNode naturalNumber = new IntegerNumberNode(2);
        ExpressionNode expression1 = new IntegerExpressionNode(naturalNumber);
        StatementNode statement1 = new AssignmentNode("var1", expression1);
        statementNodes.add(statement1);

        setupNodes();
        symbolTableFilling.visitProgram(programNode);
    }


    // Tests if the compiler allows
    // assignment of variable to a declared variable with a different name
    // in the same scope.
    @Test
    void scopeRuleAssignmentTest03() {
        // Main

            // Variable declaration
        StatementNode declaration1 = new VariableDeclarationNode(Enums.DataType.INT, "var1");
        statementNodes.add(declaration1);

            // Assignment
        IntegerNumberNode naturalNumber = new IntegerNumberNode(2);
        ExpressionNode expression1 = new IntegerExpressionNode(naturalNumber);
        StatementNode statement1 = new AssignmentNode("var2", expression1);
        statementNodes.add(statement1);

        setupNodes();

        assertThrows(RuntimeException.class, ()->{
            symbolTableFilling.visitProgram(programNode);
        });
    }

    // Tests if the compiler allows
    // assignment of variable to a declared variable with the same name
    // in different scopes.
    @Test
    void scopeRuleAssignmentTest04() {
        // Main
            // Variable declaration
        StatementNode declaration1 = new VariableDeclarationNode(Enums.DataType.INT, "var1");
        statementNodes.add(declaration1);

        // Function
        // New function
        IntegerNumberNode naturalNumber = new IntegerNumberNode(2);
        ExpressionNode expression1 = new IntegerExpressionNode(naturalNumber);

        ArrayList<StatementNode> funcStatementNodes = new ArrayList<>();
        StatementNode statementNode2 = new AssignmentNode("var1", expression1);
        funcStatementNodes.add(statementNode2);

        BlockNode funcBlockNode = new BlockNode(funcStatementNodes);
        FunctionDeclarationNode functionDeclarationNode = new FunctionDeclarationNode(Enums.ReturnType.INT, "func1", funcBlockNode);
        functionDeclarationNodes.add(functionDeclarationNode);

        setupNodes();

        assertThrows(RuntimeException.class, ()->{
            symbolTableFilling.visitProgram(programNode);
        });
    }

    // Tests if the compiler allows
    // declaration of a function with the same name as a variable
    // in the same scope. (Class block)
    @Test
    void scopeRuleFunctionDeclarationTest01() {
        ArrayList<StatementNode> functionStatementNodes = new ArrayList<>();

        ArrayList<FunctionArgNode> functionArgs1 = new ArrayList<>();
        FunctionArgNode functionArg1 = new FunctionArgNode(Enums.DataType.INT, "arg1");
        functionArgs1.add(functionArg1);

        ArrayList<FunctionArgNode> functionArgs2 = new ArrayList<>();
        FunctionArgNode functionArg2 = new FunctionArgNode(Enums.DataType.INT, "arg2");
        functionArgs2.add(functionArg2);

        BlockNode funcBlock1 = new BlockNode(functionStatementNodes);
        BlockNode funcBlock2 = new BlockNode(functionStatementNodes);

        FunctionDeclarationNode function1 = new FunctionDeclarationNode(Enums.ReturnType.INT, "func1", functionArgs1, funcBlock1);
        FunctionDeclarationNode function2 = new FunctionDeclarationNode(Enums.ReturnType.INT, "func1", functionArgs2, funcBlock2);
        functionDeclarationNodes.add(function1);
        functionDeclarationNodes.add(function2);

        setupNodes();
        symbolTableFilling.visitProgram(programNode);
    }
}
