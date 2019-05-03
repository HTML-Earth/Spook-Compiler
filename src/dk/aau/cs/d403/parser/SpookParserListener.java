// Generated from C:/Users/the_p/Desktop/P4/src\SpookParser.g4 by ANTLR 4.7.2
package dk.aau.cs.d403.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SpookParser}.
 */
public interface SpookParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SpookParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SpookParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SpookParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(SpookParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(SpookParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SpookParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SpookParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(SpookParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(SpookParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SpookParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SpookParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(SpookParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(SpookParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void enterVariableDecl(SpookParser.VariableDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void exitVariableDecl(SpookParser.VariableDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#objectDecl}.
	 * @param ctx the parse tree
	 */
	void enterObjectDecl(SpookParser.ObjectDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#objectDecl}.
	 * @param ctx the parse tree
	 */
	void exitObjectDecl(SpookParser.ObjectDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SpookParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SpookParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SpookParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SpookParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#arithExpression}.
	 * @param ctx the parse tree
	 */
	void enterArithExpression(SpookParser.ArithExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#arithExpression}.
	 * @param ctx the parse tree
	 */
	void exitArithExpression(SpookParser.ArithExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#vector2Expression}.
	 * @param ctx the parse tree
	 */
	void enterVector2Expression(SpookParser.Vector2ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#vector2Expression}.
	 * @param ctx the parse tree
	 */
	void exitVector2Expression(SpookParser.Vector2ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#vector3Expression}.
	 * @param ctx the parse tree
	 */
	void enterVector3Expression(SpookParser.Vector3ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#vector3Expression}.
	 * @param ctx the parse tree
	 */
	void exitVector3Expression(SpookParser.Vector3ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#vector4Expression}.
	 * @param ctx the parse tree
	 */
	void enterVector4Expression(SpookParser.Vector4ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#vector4Expression}.
	 * @param ctx the parse tree
	 */
	void exitVector4Expression(SpookParser.Vector4ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#boolExpression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(SpookParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#boolExpression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(SpookParser.BoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#ternaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterTernaryOperator(SpookParser.TernaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#ternaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitTernaryOperator(SpookParser.TernaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#arithOperand}.
	 * @param ctx the parse tree
	 */
	void enterArithOperand(SpookParser.ArithOperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#arithOperand}.
	 * @param ctx the parse tree
	 */
	void exitArithOperand(SpookParser.ArithOperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#lowPrecedence}.
	 * @param ctx the parse tree
	 */
	void enterLowPrecedence(SpookParser.LowPrecedenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#lowPrecedence}.
	 * @param ctx the parse tree
	 */
	void exitLowPrecedence(SpookParser.LowPrecedenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#highPrecedence}.
	 * @param ctx the parse tree
	 */
	void enterHighPrecedence(SpookParser.HighPrecedenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#highPrecedence}.
	 * @param ctx the parse tree
	 */
	void exitHighPrecedence(SpookParser.HighPrecedenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#atomPrecedence}.
	 * @param ctx the parse tree
	 */
	void enterAtomPrecedence(SpookParser.AtomPrecedenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#atomPrecedence}.
	 * @param ctx the parse tree
	 */
	void exitAtomPrecedence(SpookParser.AtomPrecedenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#highOperator}.
	 * @param ctx the parse tree
	 */
	void enterHighOperator(SpookParser.HighOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#highOperator}.
	 * @param ctx the parse tree
	 */
	void exitHighOperator(SpookParser.HighOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#lowOperator}.
	 * @param ctx the parse tree
	 */
	void enterLowOperator(SpookParser.LowOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#lowOperator}.
	 * @param ctx the parse tree
	 */
	void exitLowOperator(SpookParser.LowOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#boolOperations}.
	 * @param ctx the parse tree
	 */
	void enterBoolOperations(SpookParser.BoolOperationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#boolOperations}.
	 * @param ctx the parse tree
	 */
	void exitBoolOperations(SpookParser.BoolOperationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#boolOperation}.
	 * @param ctx the parse tree
	 */
	void enterBoolOperation(SpookParser.BoolOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#boolOperation}.
	 * @param ctx the parse tree
	 */
	void exitBoolOperation(SpookParser.BoolOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#boolOperationExtend}.
	 * @param ctx the parse tree
	 */
	void enterBoolOperationExtend(SpookParser.BoolOperationExtendContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#boolOperationExtend}.
	 * @param ctx the parse tree
	 */
	void exitBoolOperationExtend(SpookParser.BoolOperationExtendContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#swizzle}.
	 * @param ctx the parse tree
	 */
	void enterSwizzle(SpookParser.SwizzleContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#swizzle}.
	 * @param ctx the parse tree
	 */
	void exitSwizzle(SpookParser.SwizzleContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#coordinateSwizzle}.
	 * @param ctx the parse tree
	 */
	void enterCoordinateSwizzle(SpookParser.CoordinateSwizzleContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#coordinateSwizzle}.
	 * @param ctx the parse tree
	 */
	void exitCoordinateSwizzle(SpookParser.CoordinateSwizzleContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#colorSwizzle}.
	 * @param ctx the parse tree
	 */
	void enterColorSwizzle(SpookParser.ColorSwizzleContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#colorSwizzle}.
	 * @param ctx the parse tree
	 */
	void exitColorSwizzle(SpookParser.ColorSwizzleContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(SpookParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(SpookParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#nonObjectFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterNonObjectFunctionCall(SpookParser.NonObjectFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#nonObjectFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitNonObjectFunctionCall(SpookParser.NonObjectFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#objectFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterObjectFunctionCall(SpookParser.ObjectFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#objectFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitObjectFunctionCall(SpookParser.ObjectFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#objectArgs}.
	 * @param ctx the parse tree
	 */
	void enterObjectArgs(SpookParser.ObjectArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#objectArgs}.
	 * @param ctx the parse tree
	 */
	void exitObjectArgs(SpookParser.ObjectArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#objectArg}.
	 * @param ctx the parse tree
	 */
	void enterObjectArg(SpookParser.ObjectArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#objectArg}.
	 * @param ctx the parse tree
	 */
	void exitObjectArg(SpookParser.ObjectArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void enterConditionalStatement(SpookParser.ConditionalStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void exitConditionalStatement(SpookParser.ConditionalStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#ifElseStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStatement(SpookParser.IfElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#ifElseStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStatement(SpookParser.IfElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(SpookParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(SpookParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStatement(SpookParser.ElseIfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStatement(SpookParser.ElseIfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(SpookParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(SpookParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#ifBoolExpression}.
	 * @param ctx the parse tree
	 */
	void enterIfBoolExpression(SpookParser.IfBoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#ifBoolExpression}.
	 * @param ctx the parse tree
	 */
	void exitIfBoolExpression(SpookParser.IfBoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#elseifBoolExpression}.
	 * @param ctx the parse tree
	 */
	void enterElseifBoolExpression(SpookParser.ElseifBoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#elseifBoolExpression}.
	 * @param ctx the parse tree
	 */
	void exitElseifBoolExpression(SpookParser.ElseifBoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void enterIfBlock(SpookParser.IfBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void exitIfBlock(SpookParser.IfBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#elseIfBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseIfBlock(SpookParser.ElseIfBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#elseIfBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseIfBlock(SpookParser.ElseIfBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseBlock(SpookParser.ElseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseBlock(SpookParser.ElseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#conditionalBlock}.
	 * @param ctx the parse tree
	 */
	void enterConditionalBlock(SpookParser.ConditionalBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#conditionalBlock}.
	 * @param ctx the parse tree
	 */
	void exitConditionalBlock(SpookParser.ConditionalBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#iterativeStatement}.
	 * @param ctx the parse tree
	 */
	void enterIterativeStatement(SpookParser.IterativeStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#iterativeStatement}.
	 * @param ctx the parse tree
	 */
	void exitIterativeStatement(SpookParser.IterativeStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(SpookParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(SpookParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#forLoopExpression}.
	 * @param ctx the parse tree
	 */
	void enterForLoopExpression(SpookParser.ForLoopExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#forLoopExpression}.
	 * @param ctx the parse tree
	 */
	void exitForLoopExpression(SpookParser.ForLoopExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void enterClassDecl(SpookParser.ClassDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void exitClassDecl(SpookParser.ClassDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#classBlock}.
	 * @param ctx the parse tree
	 */
	void enterClassBlock(SpookParser.ClassBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#classBlock}.
	 * @param ctx the parse tree
	 */
	void exitClassBlock(SpookParser.ClassBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterConstructor(SpookParser.ConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitConstructor(SpookParser.ConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#constructorBlock}.
	 * @param ctx the parse tree
	 */
	void enterConstructorBlock(SpookParser.ConstructorBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#constructorBlock}.
	 * @param ctx the parse tree
	 */
	void exitConstructorBlock(SpookParser.ConstructorBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(SpookParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(SpookParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#functionArgs}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArgs(SpookParser.FunctionArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#functionArgs}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArgs(SpookParser.FunctionArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#functionArg}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArg(SpookParser.FunctionArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#functionArg}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArg(SpookParser.FunctionArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#functionBlock}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBlock(SpookParser.FunctionBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#functionBlock}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBlock(SpookParser.FunctionBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(SpookParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(SpookParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#realNumber}.
	 * @param ctx the parse tree
	 */
	void enterRealNumber(SpookParser.RealNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#realNumber}.
	 * @param ctx the parse tree
	 */
	void exitRealNumber(SpookParser.RealNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#integerNumber}.
	 * @param ctx the parse tree
	 */
	void enterIntegerNumber(SpookParser.IntegerNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#integerNumber}.
	 * @param ctx the parse tree
	 */
	void exitIntegerNumber(SpookParser.IntegerNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#boolOperator}.
	 * @param ctx the parse tree
	 */
	void enterBoolOperator(SpookParser.BoolOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#boolOperator}.
	 * @param ctx the parse tree
	 */
	void exitBoolOperator(SpookParser.BoolOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(SpookParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(SpookParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(SpookParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(SpookParser.DataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#objectVariableName}.
	 * @param ctx the parse tree
	 */
	void enterObjectVariableName(SpookParser.ObjectVariableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#objectVariableName}.
	 * @param ctx the parse tree
	 */
	void exitObjectVariableName(SpookParser.ObjectVariableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(SpookParser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(SpookParser.FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#variableName}.
	 * @param ctx the parse tree
	 */
	void enterVariableName(SpookParser.VariableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#variableName}.
	 * @param ctx the parse tree
	 */
	void exitVariableName(SpookParser.VariableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(SpookParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(SpookParser.ClassNameContext ctx);
}