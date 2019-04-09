// Generated from C:/Programming/P4/src\SpookParser.g4 by ANTLR 4.7.2
package dk.aau.cs.d403.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SpookParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SpookParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SpookParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(SpookParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(SpookParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarations(SpookParser.DeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(SpookParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(SpookParser.CommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecl(SpookParser.ClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#objectDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectDecl(SpookParser.ObjectDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#objectArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectArgs(SpookParser.ObjectArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#objectArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectArg(SpookParser.ObjectArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#objectFunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectFunctionCall(SpookParser.ObjectFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#colorFunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColorFunctionCall(SpookParser.ColorFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(SpookParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#numberDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberDecl(SpookParser.NumberDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#integerDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerDecl(SpookParser.IntegerDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#floatDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatDecl(SpookParser.FloatDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#arithOperations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithOperations(SpookParser.ArithOperationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#arithOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithOperation(SpookParser.ArithOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#mathFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathFunction(SpookParser.MathFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#vector2Decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVector2Decl(SpookParser.Vector2DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#vector3Decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVector3Decl(SpookParser.Vector3DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#vector4Decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVector4Decl(SpookParser.Vector4DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#boolDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolDecl(SpookParser.BoolDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#boolOperations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolOperations(SpookParser.BoolOperationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#boolOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolOperation(SpookParser.BoolOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#realNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealNumber(SpookParser.RealNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#naturalNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNaturalNumber(SpookParser.NaturalNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#colorFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColorFunction(SpookParser.ColorFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(SpookParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#boolOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolOperator(SpookParser.BoolOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(SpookParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(SpookParser.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#classType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(SpookParser.ClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(SpookParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#objectVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectVariable(SpookParser.ObjectVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(SpookParser.FunctionNameContext ctx);
}