import dk.aau.cs.d403.ast.Enums;
import dk.aau.cs.d403.ast.expressions.*;
import dk.aau.cs.d403.ast.statements.AssignmentNode;
import dk.aau.cs.d403.ast.statements.StatementNode;
import dk.aau.cs.d403.ast.statements.VariableDeclarationNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TypeCheckingTest extends ScopeRulesTest{

    @Test
    void TypeCheckingTest01() {
        // Main
            // Variable declaration
        StatementNode statement1 = new VariableDeclarationNode(Enums.DataType.INT, "var1");

            // Assignment
                // Natural number
        NaturalNumberNode naturalNumber = new NaturalNumberNode(2);
                // Expression
        ExpressionNode expression1 = new IntegerExpressionNode(naturalNumber);
                // Assignment
        StatementNode assignment1 = new AssignmentNode("var1", expression1);

            // Add statements to list of statements
        statementNodes.add(statement1);
        statementNodes.add(assignment1);

        setupNodes();

        // Fill symbol table
        symbolTableFilling.visitProgram(programNode);
    }

    @Test
    void TypeCheckingTest02() {
        // Main
            // Variable declaration
        StatementNode statement1 = new VariableDeclarationNode(Enums.DataType.INT, "var1");

            // Assignment
                // Real number
        RealNumberNode realNumber = new RealNumberNode((float) 2.2);
                // Expression
        ExpressionNode expression1 = new FloatExpressionNode(realNumber);
                // Assignment
        StatementNode assignment1 = new AssignmentNode("var1", expression1);

        // Add statements to list of statements
        statementNodes.add(statement1);
        statementNodes.add(assignment1);

        setupNodes();
        assertThrows(RuntimeException.class, ()->{
            symbolTableFilling.visitProgram(programNode);
        });
    }

    @Test
    void TypeCheckingTest03() {
        // Main
        // Variable declaration
        StatementNode statement1 = new VariableDeclarationNode(Enums.DataType.BOOL, "var1");

        // Assignment
        // Expression
        ExpressionNode expression1 = new BoolExpressionNode(true);
        // Assignment
        StatementNode assignment1 = new AssignmentNode("var1", expression1);

        // Add statements to list of statements
        statementNodes.add(statement1);
        statementNodes.add(assignment1);

        setupNodes();
        symbolTableFilling.visitProgram(programNode);
    }
}
