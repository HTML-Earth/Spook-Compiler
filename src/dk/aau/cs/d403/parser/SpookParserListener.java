// Generated from C:/Programming/P4/src\SpookParser.g4 by ANTLR 4.7.2
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
	 * Enter a parse tree produced by {@link SpookParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterDeclarations(SpookParser.DeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitDeclarations(SpookParser.DeclarationsContext ctx);
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
	 * Enter a parse tree produced by {@link SpookParser#colorFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterColorFunctionCall(SpookParser.ColorFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#colorFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitColorFunctionCall(SpookParser.ColorFunctionCallContext ctx);
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
	 * Enter a parse tree produced by {@link SpookParser#numberDecl}.
	 * @param ctx the parse tree
	 */
	void enterNumberDecl(SpookParser.NumberDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#numberDecl}.
	 * @param ctx the parse tree
	 */
	void exitNumberDecl(SpookParser.NumberDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#integerDecl}.
	 * @param ctx the parse tree
	 */
	void enterIntegerDecl(SpookParser.IntegerDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#integerDecl}.
	 * @param ctx the parse tree
	 */
	void exitIntegerDecl(SpookParser.IntegerDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#floatDecl}.
	 * @param ctx the parse tree
	 */
	void enterFloatDecl(SpookParser.FloatDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#floatDecl}.
	 * @param ctx the parse tree
	 */
	void exitFloatDecl(SpookParser.FloatDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#arithOperations}.
	 * @param ctx the parse tree
	 */
	void enterArithOperations(SpookParser.ArithOperationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#arithOperations}.
	 * @param ctx the parse tree
	 */
	void exitArithOperations(SpookParser.ArithOperationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#arithOperation}.
	 * @param ctx the parse tree
	 */
	void enterArithOperation(SpookParser.ArithOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#arithOperation}.
	 * @param ctx the parse tree
	 */
	void exitArithOperation(SpookParser.ArithOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#mathFunction}.
	 * @param ctx the parse tree
	 */
	void enterMathFunction(SpookParser.MathFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#mathFunction}.
	 * @param ctx the parse tree
	 */
	void exitMathFunction(SpookParser.MathFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#vector2Decl}.
	 * @param ctx the parse tree
	 */
	void enterVector2Decl(SpookParser.Vector2DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#vector2Decl}.
	 * @param ctx the parse tree
	 */
	void exitVector2Decl(SpookParser.Vector2DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#vector3Decl}.
	 * @param ctx the parse tree
	 */
	void enterVector3Decl(SpookParser.Vector3DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#vector3Decl}.
	 * @param ctx the parse tree
	 */
	void exitVector3Decl(SpookParser.Vector3DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#vector4Decl}.
	 * @param ctx the parse tree
	 */
	void enterVector4Decl(SpookParser.Vector4DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#vector4Decl}.
	 * @param ctx the parse tree
	 */
	void exitVector4Decl(SpookParser.Vector4DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#boolDecl}.
	 * @param ctx the parse tree
	 */
	void enterBoolDecl(SpookParser.BoolDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#boolDecl}.
	 * @param ctx the parse tree
	 */
	void exitBoolDecl(SpookParser.BoolDeclContext ctx);
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
	 * Enter a parse tree produced by {@link SpookParser#naturalNumber}.
	 * @param ctx the parse tree
	 */
	void enterNaturalNumber(SpookParser.NaturalNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#naturalNumber}.
	 * @param ctx the parse tree
	 */
	void exitNaturalNumber(SpookParser.NaturalNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#colorFunction}.
	 * @param ctx the parse tree
	 */
	void enterColorFunction(SpookParser.ColorFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#colorFunction}.
	 * @param ctx the parse tree
	 */
	void exitColorFunction(SpookParser.ColorFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(SpookParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(SpookParser.OperatorContext ctx);
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
	 * Enter a parse tree produced by {@link SpookParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(SpookParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(SpookParser.FunctionContext ctx);
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
	 * Enter a parse tree produced by {@link SpookParser#classType}.
	 * @param ctx the parse tree
	 */
	void enterClassType(SpookParser.ClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#classType}.
	 * @param ctx the parse tree
	 */
	void exitClassType(SpookParser.ClassTypeContext ctx);
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
	 * Enter a parse tree produced by {@link SpookParser#objectVariable}.
	 * @param ctx the parse tree
	 */
	void enterObjectVariable(SpookParser.ObjectVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#objectVariable}.
	 * @param ctx the parse tree
	 */
	void exitObjectVariable(SpookParser.ObjectVariableContext ctx);
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
}