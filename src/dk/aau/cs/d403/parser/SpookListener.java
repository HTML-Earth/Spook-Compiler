// Generated from D:/GitHub/P4/src\Spook.g4 by ANTLR 4.7.2
package dk.aau.cs.d403.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SpookParser}.
 */
public interface SpookListener extends ParseTreeListener {
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
	 * Enter a parse tree produced by {@link SpookParser#vectorType}.
	 * @param ctx the parse tree
	 */
	void enterVectorType(SpookParser.VectorTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#vectorType}.
	 * @param ctx the parse tree
	 */
	void exitVectorType(SpookParser.VectorTypeContext ctx);
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
	 * Enter a parse tree produced by {@link SpookParser#dataTypeVariable}.
	 * @param ctx the parse tree
	 */
	void enterDataTypeVariable(SpookParser.DataTypeVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#dataTypeVariable}.
	 * @param ctx the parse tree
	 */
	void exitDataTypeVariable(SpookParser.DataTypeVariableContext ctx);
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
	 * Enter a parse tree produced by {@link SpookParser#space}.
	 * @param ctx the parse tree
	 */
	void enterSpace(SpookParser.SpaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#space}.
	 * @param ctx the parse tree
	 */
	void exitSpace(SpookParser.SpaceContext ctx);
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
	 * Enter a parse tree produced by {@link SpookParser#digit}.
	 * @param ctx the parse tree
	 */
	void enterDigit(SpookParser.DigitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#digit}.
	 * @param ctx the parse tree
	 */
	void exitDigit(SpookParser.DigitContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpookParser#float_digit}.
	 * @param ctx the parse tree
	 */
	void enterFloat_digit(SpookParser.Float_digitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpookParser#float_digit}.
	 * @param ctx the parse tree
	 */
	void exitFloat_digit(SpookParser.Float_digitContext ctx);
}