// Generated from C:/Programming/P4/src\Test.g4 by ANTLR 4.7.2
package dk.aau.cs.d403.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TestParser}.
 */
public interface TestListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TestParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(TestParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(TestParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterDeclarations(TestParser.DeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitDeclarations(TestParser.DeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(TestParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(TestParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#numberDecl}.
	 * @param ctx the parse tree
	 */
	void enterNumberDecl(TestParser.NumberDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#numberDecl}.
	 * @param ctx the parse tree
	 */
	void exitNumberDecl(TestParser.NumberDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#integerDecl}.
	 * @param ctx the parse tree
	 */
	void enterIntegerDecl(TestParser.IntegerDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#integerDecl}.
	 * @param ctx the parse tree
	 */
	void exitIntegerDecl(TestParser.IntegerDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#floatDecl}.
	 * @param ctx the parse tree
	 */
	void enterFloatDecl(TestParser.FloatDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#floatDecl}.
	 * @param ctx the parse tree
	 */
	void exitFloatDecl(TestParser.FloatDeclContext ctx);
}