// Generated from D:/GitHub/P4/src\Spook.g4 by ANTLR 4.7.2
package dk.aau.cs.d403.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SpookParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SpookVisitor<T> extends ParseTreeVisitor<T> {
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
	 * Visit a parse tree produced by {@link SpookParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(SpookParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(SpookParser.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(SpookParser.DataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#vectorType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVectorType(SpookParser.VectorTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(SpookParser.VariableContext ctx);
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
	 * Visit a parse tree produced by {@link SpookParser#boolDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolDecl(SpookParser.BoolDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#boolOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolOperation(SpookParser.BoolOperationContext ctx);
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
	 * Visit a parse tree produced by {@link SpookParser#dataTypeVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataTypeVariable(SpookParser.DataTypeVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#arithOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithOperation(SpookParser.ArithOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#math_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath_function(SpookParser.Math_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#space}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpace(SpookParser.SpaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#real_number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal_number(SpookParser.Real_numberContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#digit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDigit(SpookParser.DigitContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpookParser#float_digit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloat_digit(SpookParser.Float_digitContext ctx);
}