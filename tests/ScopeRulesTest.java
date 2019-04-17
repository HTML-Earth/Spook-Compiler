import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.ast.AstBuilder;
import dk.aau.cs.d403.ast.expressions.ExpressionNode;
import dk.aau.cs.d403.ast.expressions.IntegerExpressionNode;
import dk.aau.cs.d403.ast.expressions.NaturalNumberNode;
import dk.aau.cs.d403.ast.statements.*;
import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.structure.*;
import dk.aau.cs.d403.parser.SpookLexer;
import dk.aau.cs.d403.parser.SpookParser;
import dk.aau.cs.d403.semantics.SymbolTableFilling;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
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

    // Duplication of scopeRuleDeclarationTest06
    // but with a text file instead representing the test.
    @Test
    void scopeRuleDeclarationTest07() {
        try {
            SpookLexer lexer = new SpookLexer(CharStreams.fromFileName("Resources/ScopeRuleDeclarationTest07.spook"));
            SpookParser parser = new SpookParser(new CommonTokenStream(lexer));

            AstBuilder astBuilder = new AstBuilder();
            ProgramNode programNode = (ProgramNode) astBuilder.visitProgram(parser.program());

            symbolTableFilling.visitProgram(programNode);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Tests if the compiler
    // throws an error when a variable is assigned before it is declared
    // in the same scope.
    @Test
    void scopeRuleAssignmentTest01() {
        // Main
            // Assignment
        NaturalNumberNode naturalNumber = new NaturalNumberNode(2);
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
        NaturalNumberNode naturalNumber = new NaturalNumberNode(2);
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
        NaturalNumberNode naturalNumber = new NaturalNumberNode(2);
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
        NaturalNumberNode naturalNumber = new NaturalNumberNode(2);
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

    /* Testing a giant Global scope
     with several functions, classes
     and function inside classes. Also
     includes a main scope.
     The goal is to get a large symbol table.
    */
    @Test
    void giantScopeRulesTest() {

        // First we make 3 variables in the Main scope.
        // - Int var1 = 2;
        // - Bool var2 = true;
        // - Float var3 = 2.5;
        ExpressionNode var1Express = new IntegerExpressionNode(new NaturalNumberNode(2));
        AssignmentNode var1Ass = new AssignmentNode("var1", var1Express);

        ExpressionNode var2Express = new BoolExpressionNode(true);
        AssignmentNode var2Ass = new AssignmentNode("var2", var2Express);

        ExpressionNode var3Express = new FloatExpressionNode(new RealNumberNode((float)2.5));
        AssignmentNode var3Ass = new AssignmentNode("var3", var3Express);

        StatementNode var1 = new VariableDeclarationNode (Enums.DataType.INT, var1Ass);
        StatementNode var2 = new VariableDeclarationNode(Enums.DataType.BOOL, var2Ass);
        StatementNode var3 = new VariableDeclarationNode(Enums.DataType.FLOAT, var3Ass);
        statementNodes.add(var1);
        statementNodes.add(var2);
        statementNodes.add(var3);

        /* We make 2 functions in the Global scope:
         - Int func1(Int arg1, Bool arg2) {}
         - Bool func2() {
              int var1 = 4; }
        */

        ExpressionNode func2var1Express = new IntegerExpressionNode(new NaturalNumberNode(4));
        AssignmentNode func2var1Ass = new AssignmentNode("var1", func2var1Express);
        StatementNode func2var1 = new VariableDeclarationNode (Enums.DataType.INT, func2var1Ass);

        ArrayList<StatementNode> func1StatementNodes = new ArrayList<>();
        ArrayList<StatementNode> func2StatementNodes = new ArrayList<>();
        func2StatementNodes.add(func2var1);

        ArrayList<FunctionArgNode> func1Args = new ArrayList<>();
        FunctionArgNode func1Arg1 = new FunctionArgNode(Enums.DataType.INT, "arg1");
        FunctionArgNode func1Arg2 = new FunctionArgNode(Enums.DataType.BOOL, "arg2");
        func1Args.add(func1Arg1);
        func1Args.add(func1Arg2);

        BlockNode func1Block = new BlockNode(func1StatementNodes);
        BlockNode func2Block = new BlockNode(func2StatementNodes);

        FunctionDeclarationNode func1 = new FunctionDeclarationNode(Enums.ReturnType.INT, "func1", func1Args, func1Block);
        FunctionDeclarationNode func2 = new FunctionDeclarationNode(Enums.ReturnType.BOOL, "func2", func2Block);
        functionDeclarationNodes.add(func1);
        functionDeclarationNodes.add(func2);

        /* We make 2 classes in the Global scope:
         - Class Class1 {
              Int  func1() { Int var1 = 8; }
              Bool func2() { Bool var1 = true; }
           }

         - Class class2 {
              Float var1 = 1.2;

              Float func1() { Float var1 = 2.1}
           }
        */

        //class1

        ExpressionNode class1func1var1Express = new IntegerExpressionNode(new NaturalNumberNode(8));
        AssignmentNode class1func1var1Ass = new AssignmentNode("var1", class1func1var1Express);

        ExpressionNode class1func2var1Express = new BoolExpressionNode(true);
        AssignmentNode class1func2var1Ass = new AssignmentNode("var1", class1func2var1Express);

        StatementNode class1func1var1 = new VariableDeclarationNode (Enums.DataType.INT, class1func1var1Ass);
        StatementNode class1func1var2 = new VariableDeclarationNode (Enums.DataType.BOOL, class1func2var1Ass);

        ArrayList<StatementNode> class1func1StatementNodes = new ArrayList<>();
        ArrayList<StatementNode> class1func2StatementNodes = new ArrayList<>();

        class1func1StatementNodes.add(class1func1var1);
        class1func2StatementNodes.add(class1func1var2);

        BlockNode class1func1BlockNode = new BlockNode(class1func1StatementNodes);
        BlockNode class1func2BlockNode = new BlockNode(class1func2StatementNodes);

        FunctionDeclarationNode class1func1Node = new FunctionDeclarationNode(Enums.ReturnType.INT, "func1", class1func1BlockNode);
        FunctionDeclarationNode class1func2Node = new FunctionDeclarationNode(Enums.ReturnType.BOOL, "func2", class1func2BlockNode);

        ArrayList<FunctionDeclarationNode> class1funcNodes = new ArrayList<>();
        class1funcNodes.add(class1func1Node);
        class1funcNodes.add(class1func2Node);

        ArrayList<DeclarationNode> class1declarations = new ArrayList<>();

        ClassBlockNode class1BlockNode = new ClassBlockNode(class1declarations, class1funcNodes);
        ClassDeclarationNode class1Node = new ClassDeclarationNode("class1", class1BlockNode);
        classDeclarationNodes.add(class1Node);

        //class2
        ExpressionNode class2var1Express = new FloatExpressionNode(new RealNumberNode((float)1.2));
        AssignmentNode class2var1Ass = new AssignmentNode("var1", class2var1Express);

        DeclarationNode class2var1 = new VariableDeclarationNode(Enums.DataType.FLOAT, class2var1Ass);
        ArrayList<DeclarationNode> class2declarations = new ArrayList<>();
        class2declarations.add(class2var1);

        ExpressionNode class2func1var1Express = new FloatExpressionNode(new RealNumberNode((float)2.1));
        AssignmentNode class2func1var1Ass = new AssignmentNode("var1", class2func1var1Express);

        StatementNode class2func1var1 = new VariableDeclarationNode(Enums.DataType.FLOAT, class2func1var1Ass);
        ArrayList<StatementNode> class2func1StatementNodes = new ArrayList<>();

        class2func1StatementNodes.add(class2func1var1);

        BlockNode class2func1BlockNode = new BlockNode(class2func1StatementNodes);

        FunctionDeclarationNode class2func1Node = new FunctionDeclarationNode(Enums.ReturnType.FLOAT, "func1", class2func1BlockNode);
        ArrayList<FunctionDeclarationNode> class2funcNodes = new ArrayList<>();
        class2funcNodes.add(class2func1Node);

        ClassBlockNode class2BlockNode = new ClassBlockNode(class2declarations, class2funcNodes);
        ClassDeclarationNode class2Node = new ClassDeclarationNode("class2", class2BlockNode);
        classDeclarationNodes.add(class2Node);

        setupNodes();
        symbolTableFilling.visitProgram(programNode);



        /**
         * // Class function block
         *         StatementNode statementNode2 = new VariableDeclarationNode(Enums.DataType.INT, "var1");
         *         ArrayList<StatementNode> functionStatementNodes = new ArrayList<>();
         *         functionStatementNodes.add(statementNode2);
         *
         *         BlockNode funcBlockNode = new BlockNode(functionStatementNodes);
         *
         *         // Class functions
         *         FunctionDeclarationNode functionNode1 = new FunctionDeclarationNode(Enums.ReturnType.VOID, "func1", funcBlockNode);
         *         ArrayList<FunctionDeclarationNode> functionNodes = new ArrayList<>();
         *         functionNodes.add(functionNode1);
         *
         *         // Class decl
         *         ClassBlockNode classBlockNode = new ClassBlockNode(declarationNodes, functionNodes);
         *         ClassDeclarationNode classNode = new ClassDeclarationNode("class1", classBlockNode);
         *         classDeclarationNodes.add(classNode);
         *
         *
         *
         *         // Class declarations
         *         DeclarationNode declarationNode1 = new VariableDeclarationNode(Enums.DataType.INT, "var1");
         *         ArrayList<DeclarationNode> declarationNodes = new ArrayList<>();
         *         declarationNodes.add(declarationNode1);
         */

    }
}
