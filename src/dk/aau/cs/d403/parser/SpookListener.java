// Generated from C:/Programming/P4/src\Spook.g4 by ANTLR 4.7.2
package dk.aau.cs.d403.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SpookParser}.
 */
public interface SpookListener extends ParseTreeListener {
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
	 * Enter a parse tree produced by {@link SpookParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(SpookParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(SpookParser.VariableContext ctx);
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
	 * Enter a parse tree produced by {@link SpookParser#arith}.
	 * @param ctx the parse tree
	 */
	void enterArith(SpookParser.ArithContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#arith}.
	 * @param ctx the parse tree
	 */
	void exitArith(SpookParser.ArithContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#math_function}.
	 * @param ctx the parse tree
	 */
	void enterMath_function(SpookParser.Math_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#math_function}.
	 * @param ctx the parse tree
	 */
	void exitMath_function(SpookParser.Math_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#real_number}.
	 * @param ctx the parse tree
	 */
	void enterReal_number(SpookParser.Real_numberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#real_number}.
	 * @param ctx the parse tree
	 */
	void exitReal_number(SpookParser.Real_numberContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#reserved_word}.
	 * @param ctx the parse tree
	 */
	void enterReserved_word(SpookParser.Reserved_wordContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#reserved_word}.
	 * @param ctx the parse tree
	 */
	void exitReserved_word(SpookParser.Reserved_wordContext ctx);
}