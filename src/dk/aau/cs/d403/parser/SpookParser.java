// Generated from /Users/Garrido/PycharmProjects/PythonProjects/P4/src/SpookParser.g4 by ANTLR 4.7.2
package dk.aau.cs.d403.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SpookParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, FLOAT=2, BOOL=3, VECTOR2=4, VECTOR3=5, VECTOR4=6, VOID=7, CIRCLE=8, 
		RECTANGLE=9, TRIANGLE=10, SHAPE=11, COLOR=12, CIRCLEGRADIENT=13, LINEGRADIENT=14, 
		BLACK=15, WHITE=16, RED=17, GREEN=18, BLUE=19, MAIN=20, CLASS=21, EXTENDS=22, 
		IMPLEMENTS=23, RETURN=24, IF=25, ELSE_IF=26, ELSE=27, FOR=28, TO=29, DIGIT=30, 
		DIGIT_NEGATIVE=31, FLOAT_DIGIT=32, FLOAT_DIGIT_NEGATIVE=33, BOOL_LITERAL=34, 
		LEFT_BRACKET=35, RIGHT_BRACKET=36, LEFT_PAREN=37, RIGHT_PAREN=38, DOT=39, 
		COMMA=40, SEMICOLON=41, QUESTION=42, COLON=43, ASSIGN=44, ADD=45, SUB=46, 
		MOD=47, DIV=48, MUL=49, EQUAL=50, AND=51, OR=52, NOT_EQUAL=53, NOT=54, 
		ABS=55, SIN=56, COS=57, TAN=58, UNIFORM=59, ID=60, COMMENT_STRING=61, 
		WS=62;
	public static final int
		RULE_program = 0, RULE_main = 1, RULE_declarations = 2, RULE_declaration = 3, 
		RULE_statements = 4, RULE_statement = 5, RULE_block = 6, RULE_functionBlock = 7, 
		RULE_classBlock = 8, RULE_assignment = 9, RULE_expression = 10, RULE_integerExpression = 11, 
		RULE_floatExpression = 12, RULE_vector2Expression = 13, RULE_vector3Expression = 14, 
		RULE_vector4Expression = 15, RULE_boolExpression = 16, RULE_ternaryOperator = 17, 
		RULE_conditionalStatement = 18, RULE_ifElseStatement = 19, RULE_comment = 20, 
		RULE_classDecl = 21, RULE_objectDecl = 22, RULE_objectArgs = 23, RULE_objectArg = 24, 
		RULE_functionCall = 25, RULE_nonObjectFunctionCall = 26, RULE_objectVariableAssign = 27, 
		RULE_objectFunctionCall = 28, RULE_classProperty = 29, RULE_functionDecl = 30, 
		RULE_functionArgs = 31, RULE_functionArg = 32, RULE_returnStatement = 33, 
		RULE_variableDecl = 34, RULE_arithOperand = 35, RULE_lowPrecedence = 36, 
		RULE_highPrecedence = 37, RULE_atomPrecedence = 38, RULE_mathFunction = 39, 
		RULE_iterativeStatement = 40, RULE_forStatement = 41, RULE_boolOperations = 42, 
		RULE_boolOperation = 43, RULE_realNumber = 44, RULE_naturalNumber = 45, 
		RULE_boolOperator = 46, RULE_function = 47, RULE_returnType = 48, RULE_classType = 49, 
		RULE_dataType = 50, RULE_predefinedFunctionName = 51, RULE_colorName = 52, 
		RULE_objectVariableName = 53, RULE_functionName = 54, RULE_variableName = 55, 
		RULE_className = 56, RULE_assignedVariableName = 57;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main", "declarations", "declaration", "statements", "statement", 
			"block", "functionBlock", "classBlock", "assignment", "expression", "integerExpression", 
			"floatExpression", "vector2Expression", "vector3Expression", "vector4Expression", 
			"boolExpression", "ternaryOperator", "conditionalStatement", "ifElseStatement", 
			"comment", "classDecl", "objectDecl", "objectArgs", "objectArg", "functionCall", 
			"nonObjectFunctionCall", "objectVariableAssign", "objectFunctionCall", 
			"classProperty", "functionDecl", "functionArgs", "functionArg", "returnStatement", 
			"variableDecl", "arithOperand", "lowPrecedence", "highPrecedence", "atomPrecedence", 
			"mathFunction", "iterativeStatement", "forStatement", "boolOperations", 
			"boolOperation", "realNumber", "naturalNumber", "boolOperator", "function", 
			"returnType", "classType", "dataType", "predefinedFunctionName", "colorName", 
			"objectVariableName", "functionName", "variableName", "className", "assignedVariableName"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Int'", "'Float'", "'Bool'", "'Vec2'", "'Vec3'", "'Vec4'", "'void'", 
			"'Circle'", "'Rectangle'", "'Triangle'", "'Shape'", "'Color'", "'CircleGradient'", 
			"'LineGradient'", "'Black'", "'White'", "'Red'", "'Green'", "'Blue'", 
			"'Shader'", "'class'", "'extends'", "'implements'", "'return'", "'if'", 
			"'else if'", "'else'", "'for'", "'to'", null, null, null, null, null, 
			"'{'", "'}'", "'('", "')'", "'.'", "','", "';'", "'?'", "':'", "'='", 
			"'+'", "'-'", "'%'", "'/'", "'*'", "'=='", "'&&'", "'||'", "'!='", "'!'", 
			"'abs'", "'sin'", "'cos'", "'tan'", "'Time'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "FLOAT", "BOOL", "VECTOR2", "VECTOR3", "VECTOR4", "VOID", 
			"CIRCLE", "RECTANGLE", "TRIANGLE", "SHAPE", "COLOR", "CIRCLEGRADIENT", 
			"LINEGRADIENT", "BLACK", "WHITE", "RED", "GREEN", "BLUE", "MAIN", "CLASS", 
			"EXTENDS", "IMPLEMENTS", "RETURN", "IF", "ELSE_IF", "ELSE", "FOR", "TO", 
			"DIGIT", "DIGIT_NEGATIVE", "FLOAT_DIGIT", "FLOAT_DIGIT_NEGATIVE", "BOOL_LITERAL", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", "DOT", 
			"COMMA", "SEMICOLON", "QUESTION", "COLON", "ASSIGN", "ADD", "SUB", "MOD", 
			"DIV", "MUL", "EQUAL", "AND", "OR", "NOT_EQUAL", "NOT", "ABS", "SIN", 
			"COS", "TAN", "UNIFORM", "ID", "COMMENT_STRING", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SpookParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SpookParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public List<ClassDeclContext> classDecl() {
			return getRuleContexts(ClassDeclContext.class);
		}
		public ClassDeclContext classDecl(int i) {
			return getRuleContext(ClassDeclContext.class,i);
		}
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			main();
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << VECTOR2) | (1L << VECTOR3) | (1L << VECTOR4) | (1L << VOID) | (1L << CLASS) | (1L << COMMENT_STRING))) != 0)) {
				{
				setState(120);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case COMMENT_STRING:
					{
					setState(117);
					comment();
					}
					break;
				case CLASS:
					{
					setState(118);
					classDecl();
					}
					break;
				case INT:
				case FLOAT:
				case BOOL:
				case VECTOR2:
				case VECTOR3:
				case VECTOR4:
				case VOID:
					{
					setState(119);
					functionDecl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainContext extends ParserRuleContext {
		public TerminalNode MAIN() { return getToken(SpookParser.MAIN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(MAIN);
			setState(126);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationsContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(SpookParser.SEMICOLON, 0); }
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declarations);
		try {
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				declaration();
				setState(129);
				match(SEMICOLON);
				setState(130);
				declarations();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				declaration();
				setState(133);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public VariableDeclContext variableDecl() {
			return getRuleContext(VariableDeclContext.class,0);
		}
		public ObjectDeclContext objectDecl() {
			return getRuleContext(ObjectDeclContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaration);
		try {
			setState(139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case BOOL:
			case VECTOR2:
			case VECTOR3:
			case VECTOR4:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				variableDecl();
				}
				break;
			case CIRCLE:
			case RECTANGLE:
			case TRIANGLE:
			case SHAPE:
			case COLOR:
			case CIRCLEGRADIENT:
			case LINEGRADIENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				objectDecl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statements);
		try {
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				statement();
				setState(142);
				statements();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(SpookParser.SEMICOLON, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public ObjectVariableAssignContext objectVariableAssign() {
			return getRuleContext(ObjectVariableAssignContext.class,0);
		}
		public ConditionalStatementContext conditionalStatement() {
			return getRuleContext(ConditionalStatementContext.class,0);
		}
		public IterativeStatementContext iterativeStatement() {
			return getRuleContext(IterativeStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		try {
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				declaration();
				setState(148);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				assignment();
				setState(151);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(153);
				functionCall();
				setState(154);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(156);
				objectVariableAssign();
				setState(157);
				match(SEMICOLON);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(159);
				conditionalStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(160);
				iterativeStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(161);
				returnStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACKET() { return getToken(SpookParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(SpookParser.RIGHT_BRACKET, 0); }
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(LEFT_BRACKET);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << VECTOR2) | (1L << VECTOR3) | (1L << VECTOR4) | (1L << CIRCLE) | (1L << RECTANGLE) | (1L << TRIANGLE) | (1L << SHAPE) | (1L << COLOR) | (1L << CIRCLEGRADIENT) | (1L << LINEGRADIENT) | (1L << RETURN) | (1L << IF) | (1L << FOR) | (1L << ID) | (1L << COMMENT_STRING))) != 0)) {
				{
				setState(167);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT:
				case FLOAT:
				case BOOL:
				case VECTOR2:
				case VECTOR3:
				case VECTOR4:
				case CIRCLE:
				case RECTANGLE:
				case TRIANGLE:
				case SHAPE:
				case COLOR:
				case CIRCLEGRADIENT:
				case LINEGRADIENT:
				case RETURN:
				case IF:
				case FOR:
				case ID:
					{
					setState(165);
					statements();
					}
					break;
				case COMMENT_STRING:
					{
					setState(166);
					comment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(172);
			match(RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionBlockContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACKET() { return getToken(SpookParser.LEFT_BRACKET, 0); }
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(SpookParser.RIGHT_BRACKET, 0); }
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public FunctionBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterFunctionBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitFunctionBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitFunctionBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionBlockContext functionBlock() throws RecognitionException {
		FunctionBlockContext _localctx = new FunctionBlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionBlock);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(LEFT_BRACKET);
			setState(179);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(177);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case INT:
					case FLOAT:
					case BOOL:
					case VECTOR2:
					case VECTOR3:
					case VECTOR4:
					case CIRCLE:
					case RECTANGLE:
					case TRIANGLE:
					case SHAPE:
					case COLOR:
					case CIRCLEGRADIENT:
					case LINEGRADIENT:
					case RETURN:
					case IF:
					case FOR:
					case ID:
						{
						setState(175);
						statements();
						}
						break;
					case COMMENT_STRING:
						{
						setState(176);
						comment();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(181);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(182);
			returnStatement();
			setState(183);
			match(RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBlockContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACKET() { return getToken(SpookParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(SpookParser.RIGHT_BRACKET, 0); }
		public List<DeclarationsContext> declarations() {
			return getRuleContexts(DeclarationsContext.class);
		}
		public DeclarationsContext declarations(int i) {
			return getRuleContext(DeclarationsContext.class,i);
		}
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public ClassBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterClassBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitClassBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitClassBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBlockContext classBlock() throws RecognitionException {
		ClassBlockContext _localctx = new ClassBlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_classBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(LEFT_BRACKET);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << VECTOR2) | (1L << VECTOR3) | (1L << VECTOR4) | (1L << VOID) | (1L << CIRCLE) | (1L << RECTANGLE) | (1L << TRIANGLE) | (1L << SHAPE) | (1L << COLOR) | (1L << CIRCLEGRADIENT) | (1L << LINEGRADIENT) | (1L << COMMENT_STRING))) != 0)) {
				{
				setState(189);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(186);
					declarations();
					}
					break;
				case 2:
					{
					setState(187);
					functionDecl();
					}
					break;
				case 3:
					{
					setState(188);
					comment();
					}
					break;
				}
				}
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(194);
			match(RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SpookParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignedVariableNameContext assignedVariableName() {
			return getRuleContext(AssignedVariableNameContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			variableName();
			setState(197);
			match(ASSIGN);
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(198);
				expression();
				}
				break;
			case 2:
				{
				setState(199);
				assignedVariableName();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public IntegerExpressionContext integerExpression() {
			return getRuleContext(IntegerExpressionContext.class,0);
		}
		public FloatExpressionContext floatExpression() {
			return getRuleContext(FloatExpressionContext.class,0);
		}
		public Vector2ExpressionContext vector2Expression() {
			return getRuleContext(Vector2ExpressionContext.class,0);
		}
		public Vector3ExpressionContext vector3Expression() {
			return getRuleContext(Vector3ExpressionContext.class,0);
		}
		public Vector4ExpressionContext vector4Expression() {
			return getRuleContext(Vector4ExpressionContext.class,0);
		}
		public BoolExpressionContext boolExpression() {
			return getRuleContext(BoolExpressionContext.class,0);
		}
		public TernaryOperatorContext ternaryOperator() {
			return getRuleContext(TernaryOperatorContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expression);
		try {
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				variableName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				integerExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(204);
				floatExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(205);
				vector2Expression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(206);
				vector3Expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(207);
				vector4Expression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(208);
				boolExpression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(209);
				ternaryOperator();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegerExpressionContext extends ParserRuleContext {
		public NaturalNumberContext naturalNumber() {
			return getRuleContext(NaturalNumberContext.class,0);
		}
		public LowPrecedenceContext lowPrecedence() {
			return getRuleContext(LowPrecedenceContext.class,0);
		}
		public MathFunctionContext mathFunction() {
			return getRuleContext(MathFunctionContext.class,0);
		}
		public IntegerExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterIntegerExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitIntegerExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitIntegerExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerExpressionContext integerExpression() throws RecognitionException {
		IntegerExpressionContext _localctx = new IntegerExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_integerExpression);
		try {
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				naturalNumber();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				lowPrecedence();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(214);
				mathFunction();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FloatExpressionContext extends ParserRuleContext {
		public RealNumberContext realNumber() {
			return getRuleContext(RealNumberContext.class,0);
		}
		public LowPrecedenceContext lowPrecedence() {
			return getRuleContext(LowPrecedenceContext.class,0);
		}
		public MathFunctionContext mathFunction() {
			return getRuleContext(MathFunctionContext.class,0);
		}
		public FloatExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterFloatExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitFloatExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitFloatExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FloatExpressionContext floatExpression() throws RecognitionException {
		FloatExpressionContext _localctx = new FloatExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_floatExpression);
		try {
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				realNumber();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				lowPrecedence();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(219);
				mathFunction();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Vector2ExpressionContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(SpookParser.LEFT_PAREN, 0); }
		public List<FloatExpressionContext> floatExpression() {
			return getRuleContexts(FloatExpressionContext.class);
		}
		public FloatExpressionContext floatExpression(int i) {
			return getRuleContext(FloatExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(SpookParser.COMMA, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
		public Vector2ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector2Expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterVector2Expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitVector2Expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitVector2Expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Vector2ExpressionContext vector2Expression() throws RecognitionException {
		Vector2ExpressionContext _localctx = new Vector2ExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_vector2Expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(LEFT_PAREN);
			setState(223);
			floatExpression();
			setState(224);
			match(COMMA);
			setState(225);
			floatExpression();
			setState(226);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Vector3ExpressionContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(SpookParser.LEFT_PAREN, 0); }
		public List<FloatExpressionContext> floatExpression() {
			return getRuleContexts(FloatExpressionContext.class);
		}
		public FloatExpressionContext floatExpression(int i) {
			return getRuleContext(FloatExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SpookParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SpookParser.COMMA, i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
		public Vector3ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector3Expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterVector3Expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitVector3Expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitVector3Expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Vector3ExpressionContext vector3Expression() throws RecognitionException {
		Vector3ExpressionContext _localctx = new Vector3ExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_vector3Expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(LEFT_PAREN);
			setState(229);
			floatExpression();
			setState(230);
			match(COMMA);
			setState(231);
			floatExpression();
			setState(232);
			match(COMMA);
			setState(233);
			floatExpression();
			setState(234);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Vector4ExpressionContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(SpookParser.LEFT_PAREN, 0); }
		public List<FloatExpressionContext> floatExpression() {
			return getRuleContexts(FloatExpressionContext.class);
		}
		public FloatExpressionContext floatExpression(int i) {
			return getRuleContext(FloatExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SpookParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SpookParser.COMMA, i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
		public Vector4ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector4Expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterVector4Expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitVector4Expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitVector4Expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Vector4ExpressionContext vector4Expression() throws RecognitionException {
		Vector4ExpressionContext _localctx = new Vector4ExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_vector4Expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(LEFT_PAREN);
			setState(237);
			floatExpression();
			setState(238);
			match(COMMA);
			setState(239);
			floatExpression();
			setState(240);
			match(COMMA);
			setState(241);
			floatExpression();
			setState(242);
			match(COMMA);
			setState(243);
			floatExpression();
			setState(244);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolExpressionContext extends ParserRuleContext {
		public TerminalNode BOOL_LITERAL() { return getToken(SpookParser.BOOL_LITERAL, 0); }
		public BoolOperationsContext boolOperations() {
			return getRuleContext(BoolOperationsContext.class,0);
		}
		public BoolExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterBoolExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitBoolExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitBoolExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolExpressionContext boolExpression() throws RecognitionException {
		BoolExpressionContext _localctx = new BoolExpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_boolExpression);
		try {
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				match(BOOL_LITERAL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				boolOperations();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TernaryOperatorContext extends ParserRuleContext {
		public BoolExpressionContext boolExpression() {
			return getRuleContext(BoolExpressionContext.class,0);
		}
		public TerminalNode QUESTION() { return getToken(SpookParser.QUESTION, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COLON() { return getToken(SpookParser.COLON, 0); }
		public TernaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterTernaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitTernaryOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitTernaryOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TernaryOperatorContext ternaryOperator() throws RecognitionException {
		TernaryOperatorContext _localctx = new TernaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_ternaryOperator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			boolExpression();
			setState(251);
			match(QUESTION);
			setState(252);
			expression();
			setState(253);
			match(COLON);
			setState(254);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalStatementContext extends ParserRuleContext {
		public IfElseStatementContext ifElseStatement() {
			return getRuleContext(IfElseStatementContext.class,0);
		}
		public ConditionalStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterConditionalStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitConditionalStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitConditionalStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalStatementContext conditionalStatement() throws RecognitionException {
		ConditionalStatementContext _localctx = new ConditionalStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_conditionalStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			ifElseStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfElseStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(SpookParser.IF, 0); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SpookParser.LEFT_PAREN); }
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SpookParser.LEFT_PAREN, i);
		}
		public List<BoolExpressionContext> boolExpression() {
			return getRuleContexts(BoolExpressionContext.class);
		}
		public BoolExpressionContext boolExpression(int i) {
			return getRuleContext(BoolExpressionContext.class,i);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SpookParser.RIGHT_PAREN); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SpookParser.RIGHT_PAREN, i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> ELSE_IF() { return getTokens(SpookParser.ELSE_IF); }
		public TerminalNode ELSE_IF(int i) {
			return getToken(SpookParser.ELSE_IF, i);
		}
		public TerminalNode ELSE() { return getToken(SpookParser.ELSE, 0); }
		public IfElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterIfElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitIfElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitIfElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfElseStatementContext ifElseStatement() throws RecognitionException {
		IfElseStatementContext _localctx = new IfElseStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_ifElseStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(IF);
			setState(259);
			match(LEFT_PAREN);
			setState(260);
			boolExpression();
			setState(261);
			match(RIGHT_PAREN);
			setState(264);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_BRACKET:
				{
				setState(262);
				block();
				}
				break;
			case INT:
			case FLOAT:
			case BOOL:
			case VECTOR2:
			case VECTOR3:
			case VECTOR4:
			case CIRCLE:
			case RECTANGLE:
			case TRIANGLE:
			case SHAPE:
			case COLOR:
			case CIRCLEGRADIENT:
			case LINEGRADIENT:
			case RETURN:
			case IF:
			case FOR:
			case ID:
				{
				setState(263);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(276);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(266);
					match(ELSE_IF);
					setState(267);
					match(LEFT_PAREN);
					setState(268);
					boolExpression();
					setState(269);
					match(RIGHT_PAREN);
					setState(272);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LEFT_BRACKET:
						{
						setState(270);
						block();
						}
						break;
					case INT:
					case FLOAT:
					case BOOL:
					case VECTOR2:
					case VECTOR3:
					case VECTOR4:
					case CIRCLE:
					case RECTANGLE:
					case TRIANGLE:
					case SHAPE:
					case COLOR:
					case CIRCLEGRADIENT:
					case LINEGRADIENT:
					case RETURN:
					case IF:
					case FOR:
					case ID:
						{
						setState(271);
						statement();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(278);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			setState(284);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(279);
				match(ELSE);
				setState(282);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LEFT_BRACKET:
					{
					setState(280);
					block();
					}
					break;
				case INT:
				case FLOAT:
				case BOOL:
				case VECTOR2:
				case VECTOR3:
				case VECTOR4:
				case CIRCLE:
				case RECTANGLE:
				case TRIANGLE:
				case SHAPE:
				case COLOR:
				case CIRCLEGRADIENT:
				case LINEGRADIENT:
				case RETURN:
				case IF:
				case FOR:
				case ID:
					{
					setState(281);
					statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommentContext extends ParserRuleContext {
		public TerminalNode COMMENT_STRING() { return getToken(SpookParser.COMMENT_STRING, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(COMMENT_STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(SpookParser.CLASS, 0); }
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public ClassBlockContext classBlock() {
			return getRuleContext(ClassBlockContext.class,0);
		}
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public TerminalNode EXTENDS() { return getToken(SpookParser.EXTENDS, 0); }
		public TerminalNode IMPLEMENTS() { return getToken(SpookParser.IMPLEMENTS, 0); }
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterClassDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitClassDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitClassDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(CLASS);
			setState(289);
			className();
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS || _la==IMPLEMENTS) {
				{
				setState(290);
				_la = _input.LA(1);
				if ( !(_la==EXTENDS || _la==IMPLEMENTS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(291);
				classType();
				}
			}

			setState(294);
			classBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectDeclContext extends ParserRuleContext {
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public ObjectVariableNameContext objectVariableName() {
			return getRuleContext(ObjectVariableNameContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SpookParser.ASSIGN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SpookParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
		public List<ObjectArgsContext> objectArgs() {
			return getRuleContexts(ObjectArgsContext.class);
		}
		public ObjectArgsContext objectArgs(int i) {
			return getRuleContext(ObjectArgsContext.class,i);
		}
		public ObjectDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterObjectDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitObjectDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitObjectDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectDeclContext objectDecl() throws RecognitionException {
		ObjectDeclContext _localctx = new ObjectDeclContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_objectDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			classType();
			setState(297);
			objectVariableName();
			setState(298);
			match(ASSIGN);
			setState(299);
			match(LEFT_PAREN);
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CIRCLE) | (1L << RECTANGLE) | (1L << TRIANGLE) | (1L << SHAPE) | (1L << COLOR) | (1L << CIRCLEGRADIENT) | (1L << LINEGRADIENT) | (1L << DIGIT) | (1L << DIGIT_NEGATIVE) | (1L << FLOAT_DIGIT) | (1L << FLOAT_DIGIT_NEGATIVE) | (1L << LEFT_PAREN) | (1L << SUB) | (1L << ABS) | (1L << SIN) | (1L << COS) | (1L << TAN) | (1L << UNIFORM) | (1L << ID))) != 0)) {
				{
				{
				setState(300);
				objectArgs();
				}
				}
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(306);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectArgsContext extends ParserRuleContext {
		public ObjectArgContext objectArg() {
			return getRuleContext(ObjectArgContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(SpookParser.COMMA, 0); }
		public ObjectArgsContext objectArgs() {
			return getRuleContext(ObjectArgsContext.class,0);
		}
		public ObjectArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterObjectArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitObjectArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitObjectArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectArgsContext objectArgs() throws RecognitionException {
		ObjectArgsContext _localctx = new ObjectArgsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_objectArgs);
		try {
			setState(313);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(308);
				objectArg();
				setState(309);
				match(COMMA);
				setState(310);
				objectArgs();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(312);
				objectArg();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectArgContext extends ParserRuleContext {
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public RealNumberContext realNumber() {
			return getRuleContext(RealNumberContext.class,0);
		}
		public LowPrecedenceContext lowPrecedence() {
			return getRuleContext(LowPrecedenceContext.class,0);
		}
		public ClassPropertyContext classProperty() {
			return getRuleContext(ClassPropertyContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public ObjectArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterObjectArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitObjectArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitObjectArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectArgContext objectArg() throws RecognitionException {
		ObjectArgContext _localctx = new ObjectArgContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_objectArg);
		try {
			setState(320);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(315);
				variableName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(316);
				realNumber();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(317);
				lowPrecedence();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(318);
				classProperty();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(319);
				functionCall();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public NonObjectFunctionCallContext nonObjectFunctionCall() {
			return getRuleContext(NonObjectFunctionCallContext.class,0);
		}
		public ObjectFunctionCallContext objectFunctionCall() {
			return getRuleContext(ObjectFunctionCallContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_functionCall);
		try {
			setState(324);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(322);
				nonObjectFunctionCall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(323);
				objectFunctionCall();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonObjectFunctionCallContext extends ParserRuleContext {
		public FunctionNameContext functionName() {
			return getRuleContext(FunctionNameContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SpookParser.LEFT_PAREN, 0); }
		public ObjectArgsContext objectArgs() {
			return getRuleContext(ObjectArgsContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
		public NonObjectFunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonObjectFunctionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterNonObjectFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitNonObjectFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitNonObjectFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonObjectFunctionCallContext nonObjectFunctionCall() throws RecognitionException {
		NonObjectFunctionCallContext _localctx = new NonObjectFunctionCallContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_nonObjectFunctionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			functionName();
			setState(327);
			match(LEFT_PAREN);
			setState(328);
			objectArgs();
			setState(329);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectVariableAssignContext extends ParserRuleContext {
		public ObjectVariableNameContext objectVariableName() {
			return getRuleContext(ObjectVariableNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SpookParser.DOT, 0); }
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SpookParser.ASSIGN, 0); }
		public MathFunctionContext mathFunction() {
			return getRuleContext(MathFunctionContext.class,0);
		}
		public ObjectArgContext objectArg() {
			return getRuleContext(ObjectArgContext.class,0);
		}
		public ObjectVariableAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectVariableAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterObjectVariableAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitObjectVariableAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitObjectVariableAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectVariableAssignContext objectVariableAssign() throws RecognitionException {
		ObjectVariableAssignContext _localctx = new ObjectVariableAssignContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_objectVariableAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			objectVariableName();
			setState(332);
			match(DOT);
			setState(333);
			variableName();
			setState(334);
			match(ASSIGN);
			setState(337);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(335);
				mathFunction();
				}
				break;
			case 2:
				{
				setState(336);
				objectArg();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectFunctionCallContext extends ParserRuleContext {
		public ObjectVariableNameContext objectVariableName() {
			return getRuleContext(ObjectVariableNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SpookParser.DOT, 0); }
		public FunctionNameContext functionName() {
			return getRuleContext(FunctionNameContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SpookParser.ASSIGN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SpookParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
		public ObjectArgsContext objectArgs() {
			return getRuleContext(ObjectArgsContext.class,0);
		}
		public ObjectFunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectFunctionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterObjectFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitObjectFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitObjectFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectFunctionCallContext objectFunctionCall() throws RecognitionException {
		ObjectFunctionCallContext _localctx = new ObjectFunctionCallContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_objectFunctionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(339);
				objectVariableName();
				setState(340);
				match(DOT);
				setState(341);
				functionName();
				setState(342);
				match(ASSIGN);
				setState(351);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(344);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						setState(343);
						objectArgs();
						}
						break;
					}
					}
					break;
				case 2:
					{
					setState(346);
					match(LEFT_PAREN);
					setState(348);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CIRCLE) | (1L << RECTANGLE) | (1L << TRIANGLE) | (1L << SHAPE) | (1L << COLOR) | (1L << CIRCLEGRADIENT) | (1L << LINEGRADIENT) | (1L << DIGIT) | (1L << DIGIT_NEGATIVE) | (1L << FLOAT_DIGIT) | (1L << FLOAT_DIGIT_NEGATIVE) | (1L << LEFT_PAREN) | (1L << SUB) | (1L << ABS) | (1L << SIN) | (1L << COS) | (1L << TAN) | (1L << UNIFORM) | (1L << ID))) != 0)) {
						{
						setState(347);
						objectArgs();
						}
					}

					setState(350);
					match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			case 2:
				{
				setState(353);
				objectVariableName();
				setState(354);
				match(DOT);
				setState(355);
				functionName();
				setState(356);
				match(LEFT_PAREN);
				setState(358);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CIRCLE) | (1L << RECTANGLE) | (1L << TRIANGLE) | (1L << SHAPE) | (1L << COLOR) | (1L << CIRCLEGRADIENT) | (1L << LINEGRADIENT) | (1L << DIGIT) | (1L << DIGIT_NEGATIVE) | (1L << FLOAT_DIGIT) | (1L << FLOAT_DIGIT_NEGATIVE) | (1L << LEFT_PAREN) | (1L << SUB) | (1L << ABS) | (1L << SIN) | (1L << COS) | (1L << TAN) | (1L << UNIFORM) | (1L << ID))) != 0)) {
					{
					setState(357);
					objectArgs();
					}
				}

				setState(360);
				match(RIGHT_PAREN);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassPropertyContext extends ParserRuleContext {
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SpookParser.DOT, 0); }
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public PredefinedFunctionNameContext predefinedFunctionName() {
			return getRuleContext(PredefinedFunctionNameContext.class,0);
		}
		public ClassPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterClassProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitClassProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitClassProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassPropertyContext classProperty() throws RecognitionException {
		ClassPropertyContext _localctx = new ClassPropertyContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_classProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			classType();
			setState(365);
			match(DOT);
			setState(368);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(366);
				variableName();
				}
				break;
			case BLACK:
			case WHITE:
			case RED:
			case GREEN:
			case BLUE:
				{
				setState(367);
				predefinedFunctionName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclContext extends ParserRuleContext {
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public FunctionNameContext functionName() {
			return getRuleContext(FunctionNameContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SpookParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
		public FunctionBlockContext functionBlock() {
			return getRuleContext(FunctionBlockContext.class,0);
		}
		public FunctionArgsContext functionArgs() {
			return getRuleContext(FunctionArgsContext.class,0);
		}
		public TerminalNode VOID() { return getToken(SpookParser.VOID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitFunctionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_functionDecl);
		int _la;
		try {
			setState(388);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case BOOL:
			case VECTOR2:
			case VECTOR3:
			case VECTOR4:
				enterOuterAlt(_localctx, 1);
				{
				setState(370);
				returnType();
				setState(371);
				functionName();
				setState(372);
				match(LEFT_PAREN);
				setState(374);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << VECTOR2) | (1L << VECTOR3) | (1L << VECTOR4))) != 0)) {
					{
					setState(373);
					functionArgs();
					}
				}

				setState(376);
				match(RIGHT_PAREN);
				setState(377);
				functionBlock();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(379);
				match(VOID);
				setState(380);
				functionName();
				setState(381);
				match(LEFT_PAREN);
				setState(383);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << VECTOR2) | (1L << VECTOR3) | (1L << VECTOR4))) != 0)) {
					{
					setState(382);
					functionArgs();
					}
				}

				setState(385);
				match(RIGHT_PAREN);
				setState(386);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionArgsContext extends ParserRuleContext {
		public FunctionArgContext functionArg() {
			return getRuleContext(FunctionArgContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(SpookParser.COMMA, 0); }
		public FunctionArgsContext functionArgs() {
			return getRuleContext(FunctionArgsContext.class,0);
		}
		public FunctionArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterFunctionArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitFunctionArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitFunctionArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgsContext functionArgs() throws RecognitionException {
		FunctionArgsContext _localctx = new FunctionArgsContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_functionArgs);
		try {
			setState(395);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(390);
				functionArg();
				setState(391);
				match(COMMA);
				setState(392);
				functionArgs();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(394);
				functionArg();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionArgContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public FunctionArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterFunctionArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitFunctionArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitFunctionArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgContext functionArg() throws RecognitionException {
		FunctionArgContext _localctx = new FunctionArgContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_functionArg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			dataType();
			setState(398);
			variableName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(SpookParser.RETURN, 0); }
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public RealNumberContext realNumber() {
			return getRuleContext(RealNumberContext.class,0);
		}
		public TerminalNode BOOL_LITERAL() { return getToken(SpookParser.BOOL_LITERAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			match(RETURN);
			setState(405);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(401);
				variableName();
				}
				break;
			case 2:
				{
				setState(402);
				realNumber();
				}
				break;
			case 3:
				{
				setState(403);
				match(BOOL_LITERAL);
				}
				break;
			case 4:
				{
				setState(404);
				expression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public VariableDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterVariableDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitVariableDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitVariableDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclContext variableDecl() throws RecognitionException {
		VariableDeclContext _localctx = new VariableDeclContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_variableDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			dataType();
			setState(410);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(408);
				variableName();
				}
				break;
			case 2:
				{
				setState(409);
				assignment();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithOperandContext extends ParserRuleContext {
		public RealNumberContext realNumber() {
			return getRuleContext(RealNumberContext.class,0);
		}
		public MathFunctionContext mathFunction() {
			return getRuleContext(MathFunctionContext.class,0);
		}
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public TerminalNode UNIFORM() { return getToken(SpookParser.UNIFORM, 0); }
		public ArithOperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithOperand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterArithOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitArithOperand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitArithOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithOperandContext arithOperand() throws RecognitionException {
		ArithOperandContext _localctx = new ArithOperandContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_arithOperand);
		try {
			setState(416);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIGIT:
			case DIGIT_NEGATIVE:
			case FLOAT_DIGIT:
			case FLOAT_DIGIT_NEGATIVE:
				enterOuterAlt(_localctx, 1);
				{
				setState(412);
				realNumber();
				}
				break;
			case ABS:
			case SIN:
			case COS:
			case TAN:
				enterOuterAlt(_localctx, 2);
				{
				setState(413);
				mathFunction();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(414);
				variableName();
				}
				break;
			case UNIFORM:
				enterOuterAlt(_localctx, 4);
				{
				setState(415);
				match(UNIFORM);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LowPrecedenceContext extends ParserRuleContext {
		public List<HighPrecedenceContext> highPrecedence() {
			return getRuleContexts(HighPrecedenceContext.class);
		}
		public HighPrecedenceContext highPrecedence(int i) {
			return getRuleContext(HighPrecedenceContext.class,i);
		}
		public List<TerminalNode> ADD() { return getTokens(SpookParser.ADD); }
		public TerminalNode ADD(int i) {
			return getToken(SpookParser.ADD, i);
		}
		public List<TerminalNode> SUB() { return getTokens(SpookParser.SUB); }
		public TerminalNode SUB(int i) {
			return getToken(SpookParser.SUB, i);
		}
		public LowPrecedenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lowPrecedence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterLowPrecedence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitLowPrecedence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitLowPrecedence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LowPrecedenceContext lowPrecedence() throws RecognitionException {
		LowPrecedenceContext _localctx = new LowPrecedenceContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_lowPrecedence);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			highPrecedence();
			setState(423);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(419);
					_la = _input.LA(1);
					if ( !(_la==ADD || _la==SUB) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(420);
					highPrecedence();
					}
					} 
				}
				setState(425);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HighPrecedenceContext extends ParserRuleContext {
		public List<AtomPrecedenceContext> atomPrecedence() {
			return getRuleContexts(AtomPrecedenceContext.class);
		}
		public AtomPrecedenceContext atomPrecedence(int i) {
			return getRuleContext(AtomPrecedenceContext.class,i);
		}
		public List<TerminalNode> MUL() { return getTokens(SpookParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(SpookParser.MUL, i);
		}
		public List<TerminalNode> MOD() { return getTokens(SpookParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(SpookParser.MOD, i);
		}
		public List<TerminalNode> DIV() { return getTokens(SpookParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(SpookParser.DIV, i);
		}
		public HighPrecedenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_highPrecedence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterHighPrecedence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitHighPrecedence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitHighPrecedence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HighPrecedenceContext highPrecedence() throws RecognitionException {
		HighPrecedenceContext _localctx = new HighPrecedenceContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_highPrecedence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			atomPrecedence();
			setState(431);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MOD) | (1L << DIV) | (1L << MUL))) != 0)) {
				{
				{
				setState(427);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MOD) | (1L << DIV) | (1L << MUL))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(428);
				atomPrecedence();
				}
				}
				setState(433);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomPrecedenceContext extends ParserRuleContext {
		public ArithOperandContext arithOperand() {
			return getRuleContext(ArithOperandContext.class,0);
		}
		public TerminalNode SUB() { return getToken(SpookParser.SUB, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SpookParser.LEFT_PAREN, 0); }
		public LowPrecedenceContext lowPrecedence() {
			return getRuleContext(LowPrecedenceContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
		public AtomPrecedenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomPrecedence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterAtomPrecedence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitAtomPrecedence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitAtomPrecedence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomPrecedenceContext atomPrecedence() throws RecognitionException {
		AtomPrecedenceContext _localctx = new AtomPrecedenceContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_atomPrecedence);
		int _la;
		try {
			setState(442);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIGIT:
			case DIGIT_NEGATIVE:
			case FLOAT_DIGIT:
			case FLOAT_DIGIT_NEGATIVE:
			case SUB:
			case ABS:
			case SIN:
			case COS:
			case TAN:
			case UNIFORM:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(435);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SUB) {
					{
					setState(434);
					match(SUB);
					}
				}

				setState(437);
				arithOperand();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(438);
				match(LEFT_PAREN);
				setState(439);
				lowPrecedence();
				setState(440);
				match(RIGHT_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MathFunctionContext extends ParserRuleContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SpookParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
		public ArithOperandContext arithOperand() {
			return getRuleContext(ArithOperandContext.class,0);
		}
		public LowPrecedenceContext lowPrecedence() {
			return getRuleContext(LowPrecedenceContext.class,0);
		}
		public MathFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterMathFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitMathFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitMathFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MathFunctionContext mathFunction() throws RecognitionException {
		MathFunctionContext _localctx = new MathFunctionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_mathFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			function();
			setState(445);
			match(LEFT_PAREN);
			setState(448);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(446);
				arithOperand();
				}
				break;
			case 2:
				{
				setState(447);
				lowPrecedence();
				}
				break;
			}
			setState(450);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IterativeStatementContext extends ParserRuleContext {
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public IterativeStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterativeStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterIterativeStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitIterativeStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitIterativeStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterativeStatementContext iterativeStatement() throws RecognitionException {
		IterativeStatementContext _localctx = new IterativeStatementContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_iterativeStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			forStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(SpookParser.FOR, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SpookParser.LEFT_PAREN, 0); }
		public TerminalNode TO() { return getToken(SpookParser.TO, 0); }
		public List<TerminalNode> DIGIT() { return getTokens(SpookParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(SpookParser.DIGIT, i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
		public VariableDeclContext variableDecl() {
			return getRuleContext(VariableDeclContext.class,0);
		}
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
			match(FOR);
			setState(455);
			match(LEFT_PAREN);
			setState(460);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				setState(456);
				match(DIGIT);
				}
				break;
			case 2:
				{
				setState(457);
				variableDecl();
				}
				break;
			case 3:
				{
				setState(458);
				variableName();
				}
				break;
			case 4:
				{
				setState(459);
				assignment();
				}
				break;
			}
			setState(462);
			match(TO);
			setState(463);
			match(DIGIT);
			setState(464);
			match(RIGHT_PAREN);
			setState(467);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_BRACKET:
				{
				setState(465);
				block();
				}
				break;
			case INT:
			case FLOAT:
			case BOOL:
			case VECTOR2:
			case VECTOR3:
			case VECTOR4:
			case CIRCLE:
			case RECTANGLE:
			case TRIANGLE:
			case SHAPE:
			case COLOR:
			case CIRCLEGRADIENT:
			case LINEGRADIENT:
			case RETURN:
			case IF:
			case FOR:
			case ID:
				{
				setState(466);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolOperationsContext extends ParserRuleContext {
		public BoolOperationContext boolOperation() {
			return getRuleContext(BoolOperationContext.class,0);
		}
		public BoolOperationsContext boolOperations() {
			return getRuleContext(BoolOperationsContext.class,0);
		}
		public BoolOperationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolOperations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterBoolOperations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitBoolOperations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitBoolOperations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolOperationsContext boolOperations() throws RecognitionException {
		BoolOperationsContext _localctx = new BoolOperationsContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_boolOperations);
		try {
			setState(473);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(469);
				boolOperation();
				setState(470);
				boolOperations();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(472);
				boolOperation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolOperationContext extends ParserRuleContext {
		public BoolOperatorContext boolOperator() {
			return getRuleContext(BoolOperatorContext.class,0);
		}
		public List<TerminalNode> BOOL_LITERAL() { return getTokens(SpookParser.BOOL_LITERAL); }
		public TerminalNode BOOL_LITERAL(int i) {
			return getToken(SpookParser.BOOL_LITERAL, i);
		}
		public List<VariableNameContext> variableName() {
			return getRuleContexts(VariableNameContext.class);
		}
		public VariableNameContext variableName(int i) {
			return getRuleContext(VariableNameContext.class,i);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SpookParser.LEFT_PAREN, 0); }
		public BoolOperationContext boolOperation() {
			return getRuleContext(BoolOperationContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
		public BoolOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterBoolOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitBoolOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitBoolOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolOperationContext boolOperation() throws RecognitionException {
		BoolOperationContext _localctx = new BoolOperationContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_boolOperation);
		try {
			setState(501);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL_LITERAL:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(477);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL_LITERAL:
					{
					setState(475);
					match(BOOL_LITERAL);
					}
					break;
				case ID:
					{
					setState(476);
					variableName();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(479);
				boolOperator();
				setState(486);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL_LITERAL:
					{
					setState(480);
					match(BOOL_LITERAL);
					}
					break;
				case ID:
					{
					setState(481);
					variableName();
					}
					break;
				case LEFT_PAREN:
					{
					{
					setState(482);
					match(LEFT_PAREN);
					setState(483);
					boolOperation();
					setState(484);
					match(RIGHT_PAREN);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case EQUAL:
			case AND:
			case OR:
			case NOT_EQUAL:
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(488);
				boolOperator();
				setState(495);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL_LITERAL:
					{
					setState(489);
					match(BOOL_LITERAL);
					}
					break;
				case ID:
					{
					setState(490);
					variableName();
					}
					break;
				case LEFT_PAREN:
					{
					{
					setState(491);
					match(LEFT_PAREN);
					setState(492);
					boolOperation();
					setState(493);
					match(RIGHT_PAREN);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(497);
				match(LEFT_PAREN);
				setState(498);
				boolOperation();
				setState(499);
				match(RIGHT_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RealNumberContext extends ParserRuleContext {
		public NaturalNumberContext naturalNumber() {
			return getRuleContext(NaturalNumberContext.class,0);
		}
		public TerminalNode FLOAT_DIGIT() { return getToken(SpookParser.FLOAT_DIGIT, 0); }
		public TerminalNode FLOAT_DIGIT_NEGATIVE() { return getToken(SpookParser.FLOAT_DIGIT_NEGATIVE, 0); }
		public RealNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_realNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterRealNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitRealNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitRealNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RealNumberContext realNumber() throws RecognitionException {
		RealNumberContext _localctx = new RealNumberContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_realNumber);
		try {
			setState(506);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIGIT:
			case DIGIT_NEGATIVE:
				enterOuterAlt(_localctx, 1);
				{
				setState(503);
				naturalNumber();
				}
				break;
			case FLOAT_DIGIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(504);
				match(FLOAT_DIGIT);
				}
				break;
			case FLOAT_DIGIT_NEGATIVE:
				enterOuterAlt(_localctx, 3);
				{
				setState(505);
				match(FLOAT_DIGIT_NEGATIVE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NaturalNumberContext extends ParserRuleContext {
		public TerminalNode DIGIT() { return getToken(SpookParser.DIGIT, 0); }
		public TerminalNode DIGIT_NEGATIVE() { return getToken(SpookParser.DIGIT_NEGATIVE, 0); }
		public NaturalNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_naturalNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterNaturalNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitNaturalNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitNaturalNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NaturalNumberContext naturalNumber() throws RecognitionException {
		NaturalNumberContext _localctx = new NaturalNumberContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_naturalNumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
			_la = _input.LA(1);
			if ( !(_la==DIGIT || _la==DIGIT_NEGATIVE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolOperatorContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(SpookParser.EQUAL, 0); }
		public TerminalNode OR() { return getToken(SpookParser.OR, 0); }
		public TerminalNode AND() { return getToken(SpookParser.AND, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(SpookParser.NOT_EQUAL, 0); }
		public TerminalNode NOT() { return getToken(SpookParser.NOT, 0); }
		public BoolOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterBoolOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitBoolOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitBoolOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolOperatorContext boolOperator() throws RecognitionException {
		BoolOperatorContext _localctx = new BoolOperatorContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_boolOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << AND) | (1L << OR) | (1L << NOT_EQUAL) | (1L << NOT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode ABS() { return getToken(SpookParser.ABS, 0); }
		public TerminalNode SIN() { return getToken(SpookParser.SIN, 0); }
		public TerminalNode COS() { return getToken(SpookParser.COS, 0); }
		public TerminalNode TAN() { return getToken(SpookParser.TAN, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(512);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABS) | (1L << SIN) | (1L << COS) | (1L << TAN))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnTypeContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterReturnType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitReturnType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitReturnType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_returnType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(514);
			dataType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassTypeContext extends ParserRuleContext {
		public TerminalNode CIRCLE() { return getToken(SpookParser.CIRCLE, 0); }
		public TerminalNode RECTANGLE() { return getToken(SpookParser.RECTANGLE, 0); }
		public TerminalNode TRIANGLE() { return getToken(SpookParser.TRIANGLE, 0); }
		public TerminalNode SHAPE() { return getToken(SpookParser.SHAPE, 0); }
		public TerminalNode COLOR() { return getToken(SpookParser.COLOR, 0); }
		public TerminalNode CIRCLEGRADIENT() { return getToken(SpookParser.CIRCLEGRADIENT, 0); }
		public TerminalNode LINEGRADIENT() { return getToken(SpookParser.LINEGRADIENT, 0); }
		public ClassTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterClassType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitClassType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitClassType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassTypeContext classType() throws RecognitionException {
		ClassTypeContext _localctx = new ClassTypeContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_classType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CIRCLE) | (1L << RECTANGLE) | (1L << TRIANGLE) | (1L << SHAPE) | (1L << COLOR) | (1L << CIRCLEGRADIENT) | (1L << LINEGRADIENT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataTypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(SpookParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(SpookParser.FLOAT, 0); }
		public TerminalNode BOOL() { return getToken(SpookParser.BOOL, 0); }
		public TerminalNode VECTOR2() { return getToken(SpookParser.VECTOR2, 0); }
		public TerminalNode VECTOR3() { return getToken(SpookParser.VECTOR3, 0); }
		public TerminalNode VECTOR4() { return getToken(SpookParser.VECTOR4, 0); }
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitDataType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_dataType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(518);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << VECTOR2) | (1L << VECTOR3) | (1L << VECTOR4))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredefinedFunctionNameContext extends ParserRuleContext {
		public ColorNameContext colorName() {
			return getRuleContext(ColorNameContext.class,0);
		}
		public PredefinedFunctionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predefinedFunctionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterPredefinedFunctionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitPredefinedFunctionName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitPredefinedFunctionName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredefinedFunctionNameContext predefinedFunctionName() throws RecognitionException {
		PredefinedFunctionNameContext _localctx = new PredefinedFunctionNameContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_predefinedFunctionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(520);
			colorName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColorNameContext extends ParserRuleContext {
		public TerminalNode BLACK() { return getToken(SpookParser.BLACK, 0); }
		public TerminalNode WHITE() { return getToken(SpookParser.WHITE, 0); }
		public TerminalNode RED() { return getToken(SpookParser.RED, 0); }
		public TerminalNode GREEN() { return getToken(SpookParser.GREEN, 0); }
		public TerminalNode BLUE() { return getToken(SpookParser.BLUE, 0); }
		public ColorNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colorName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterColorName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitColorName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitColorName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColorNameContext colorName() throws RecognitionException {
		ColorNameContext _localctx = new ColorNameContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_colorName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(522);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BLACK) | (1L << WHITE) | (1L << RED) | (1L << GREEN) | (1L << BLUE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectVariableNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SpookParser.ID, 0); }
		public ObjectVariableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectVariableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterObjectVariableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitObjectVariableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitObjectVariableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectVariableNameContext objectVariableName() throws RecognitionException {
		ObjectVariableNameContext _localctx = new ObjectVariableNameContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_objectVariableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SpookParser.ID, 0); }
		public FunctionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterFunctionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitFunctionName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitFunctionName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionNameContext functionName() throws RecognitionException {
		FunctionNameContext _localctx = new FunctionNameContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SpookParser.ID, 0); }
		public VariableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterVariableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitVariableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitVariableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableNameContext variableName() throws RecognitionException {
		VariableNameContext _localctx = new VariableNameContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_variableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(528);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SpookParser.ID, 0); }
		public ClassNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_className; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterClassName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitClassName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitClassName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassNameContext className() throws RecognitionException {
		ClassNameContext _localctx = new ClassNameContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_className);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(530);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignedVariableNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SpookParser.ID, 0); }
		public AssignedVariableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignedVariableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterAssignedVariableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitAssignedVariableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitAssignedVariableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignedVariableNameContext assignedVariableName() throws RecognitionException {
		AssignedVariableNameContext _localctx = new AssignedVariableNameContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_assignedVariableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(532);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3@\u0219\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\3\2\3\2\3\2"+
		"\3\2\7\2{\n\2\f\2\16\2~\13\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5"+
		"\4\u008a\n\4\3\5\3\5\5\5\u008e\n\5\3\6\3\6\3\6\3\6\5\6\u0094\n\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00a5\n\7\3"+
		"\b\3\b\3\b\7\b\u00aa\n\b\f\b\16\b\u00ad\13\b\3\b\3\b\3\t\3\t\3\t\7\t\u00b4"+
		"\n\t\f\t\16\t\u00b7\13\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\7\n\u00c0\n\n\f\n"+
		"\16\n\u00c3\13\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13\u00cb\n\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\5\f\u00d5\n\f\3\r\3\r\3\r\5\r\u00da\n\r\3\16\3"+
		"\16\3\16\5\16\u00df\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\5\22\u00fb\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u010b\n\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\5\25\u0113\n\25\7\25\u0115\n\25\f\25\16\25\u0118\13\25\3\25\3\25"+
		"\3\25\5\25\u011d\n\25\5\25\u011f\n\25\3\26\3\26\3\27\3\27\3\27\3\27\5"+
		"\27\u0127\n\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\7\30\u0130\n\30\f\30"+
		"\16\30\u0133\13\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\5\31\u013c\n\31"+
		"\3\32\3\32\3\32\3\32\3\32\5\32\u0143\n\32\3\33\3\33\5\33\u0147\n\33\3"+
		"\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0154\n\35"+
		"\3\36\3\36\3\36\3\36\3\36\5\36\u015b\n\36\3\36\3\36\5\36\u015f\n\36\3"+
		"\36\5\36\u0162\n\36\3\36\3\36\3\36\3\36\3\36\5\36\u0169\n\36\3\36\3\36"+
		"\5\36\u016d\n\36\3\37\3\37\3\37\3\37\5\37\u0173\n\37\3 \3 \3 \3 \5 \u0179"+
		"\n \3 \3 \3 \3 \3 \3 \3 \5 \u0182\n \3 \3 \3 \5 \u0187\n \3!\3!\3!\3!"+
		"\3!\5!\u018e\n!\3\"\3\"\3\"\3#\3#\3#\3#\3#\5#\u0198\n#\3$\3$\3$\5$\u019d"+
		"\n$\3%\3%\3%\3%\5%\u01a3\n%\3&\3&\3&\7&\u01a8\n&\f&\16&\u01ab\13&\3\'"+
		"\3\'\3\'\7\'\u01b0\n\'\f\'\16\'\u01b3\13\'\3(\5(\u01b6\n(\3(\3(\3(\3("+
		"\3(\5(\u01bd\n(\3)\3)\3)\3)\5)\u01c3\n)\3)\3)\3*\3*\3+\3+\3+\3+\3+\3+"+
		"\5+\u01cf\n+\3+\3+\3+\3+\3+\5+\u01d6\n+\3,\3,\3,\3,\5,\u01dc\n,\3-\3-"+
		"\5-\u01e0\n-\3-\3-\3-\3-\3-\3-\3-\5-\u01e9\n-\3-\3-\3-\3-\3-\3-\3-\5-"+
		"\u01f2\n-\3-\3-\3-\3-\5-\u01f8\n-\3.\3.\3.\5.\u01fd\n.\3/\3/\3\60\3\60"+
		"\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67"+
		"\38\38\39\39\3:\3:\3;\3;\3;\2\2<\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprt\2\13\3\2\30\31\3"+
		"\2/\60\3\2\61\63\3\2 !\3\2\648\3\29<\3\2\n\20\3\2\3\b\3\2\21\25\2\u0230"+
		"\2v\3\2\2\2\4\177\3\2\2\2\6\u0089\3\2\2\2\b\u008d\3\2\2\2\n\u0093\3\2"+
		"\2\2\f\u00a4\3\2\2\2\16\u00a6\3\2\2\2\20\u00b0\3\2\2\2\22\u00bb\3\2\2"+
		"\2\24\u00c6\3\2\2\2\26\u00d4\3\2\2\2\30\u00d9\3\2\2\2\32\u00de\3\2\2\2"+
		"\34\u00e0\3\2\2\2\36\u00e6\3\2\2\2 \u00ee\3\2\2\2\"\u00fa\3\2\2\2$\u00fc"+
		"\3\2\2\2&\u0102\3\2\2\2(\u0104\3\2\2\2*\u0120\3\2\2\2,\u0122\3\2\2\2."+
		"\u012a\3\2\2\2\60\u013b\3\2\2\2\62\u0142\3\2\2\2\64\u0146\3\2\2\2\66\u0148"+
		"\3\2\2\28\u014d\3\2\2\2:\u016c\3\2\2\2<\u016e\3\2\2\2>\u0186\3\2\2\2@"+
		"\u018d\3\2\2\2B\u018f\3\2\2\2D\u0192\3\2\2\2F\u0199\3\2\2\2H\u01a2\3\2"+
		"\2\2J\u01a4\3\2\2\2L\u01ac\3\2\2\2N\u01bc\3\2\2\2P\u01be\3\2\2\2R\u01c6"+
		"\3\2\2\2T\u01c8\3\2\2\2V\u01db\3\2\2\2X\u01f7\3\2\2\2Z\u01fc\3\2\2\2\\"+
		"\u01fe\3\2\2\2^\u0200\3\2\2\2`\u0202\3\2\2\2b\u0204\3\2\2\2d\u0206\3\2"+
		"\2\2f\u0208\3\2\2\2h\u020a\3\2\2\2j\u020c\3\2\2\2l\u020e\3\2\2\2n\u0210"+
		"\3\2\2\2p\u0212\3\2\2\2r\u0214\3\2\2\2t\u0216\3\2\2\2v|\5\4\3\2w{\5*\26"+
		"\2x{\5,\27\2y{\5> \2zw\3\2\2\2zx\3\2\2\2zy\3\2\2\2{~\3\2\2\2|z\3\2\2\2"+
		"|}\3\2\2\2}\3\3\2\2\2~|\3\2\2\2\177\u0080\7\26\2\2\u0080\u0081\5\16\b"+
		"\2\u0081\5\3\2\2\2\u0082\u0083\5\b\5\2\u0083\u0084\7+\2\2\u0084\u0085"+
		"\5\6\4\2\u0085\u008a\3\2\2\2\u0086\u0087\5\b\5\2\u0087\u0088\7+\2\2\u0088"+
		"\u008a\3\2\2\2\u0089\u0082\3\2\2\2\u0089\u0086\3\2\2\2\u008a\7\3\2\2\2"+
		"\u008b\u008e\5F$\2\u008c\u008e\5.\30\2\u008d\u008b\3\2\2\2\u008d\u008c"+
		"\3\2\2\2\u008e\t\3\2\2\2\u008f\u0090\5\f\7\2\u0090\u0091\5\n\6\2\u0091"+
		"\u0094\3\2\2\2\u0092\u0094\5\f\7\2\u0093\u008f\3\2\2\2\u0093\u0092\3\2"+
		"\2\2\u0094\13\3\2\2\2\u0095\u0096\5\b\5\2\u0096\u0097\7+\2\2\u0097\u00a5"+
		"\3\2\2\2\u0098\u0099\5\24\13\2\u0099\u009a\7+\2\2\u009a\u00a5\3\2\2\2"+
		"\u009b\u009c\5\64\33\2\u009c\u009d\7+\2\2\u009d\u00a5\3\2\2\2\u009e\u009f"+
		"\58\35\2\u009f\u00a0\7+\2\2\u00a0\u00a5\3\2\2\2\u00a1\u00a5\5&\24\2\u00a2"+
		"\u00a5\5R*\2\u00a3\u00a5\5D#\2\u00a4\u0095\3\2\2\2\u00a4\u0098\3\2\2\2"+
		"\u00a4\u009b\3\2\2\2\u00a4\u009e\3\2\2\2\u00a4\u00a1\3\2\2\2\u00a4\u00a2"+
		"\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\r\3\2\2\2\u00a6\u00ab\7%\2\2\u00a7"+
		"\u00aa\5\n\6\2\u00a8\u00aa\5*\26\2\u00a9\u00a7\3\2\2\2\u00a9\u00a8\3\2"+
		"\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00af\7&\2\2\u00af\17\3\2\2\2"+
		"\u00b0\u00b5\7%\2\2\u00b1\u00b4\5\n\6\2\u00b2\u00b4\5*\26\2\u00b3\u00b1"+
		"\3\2\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b9\5D"+
		"#\2\u00b9\u00ba\7&\2\2\u00ba\21\3\2\2\2\u00bb\u00c1\7%\2\2\u00bc\u00c0"+
		"\5\6\4\2\u00bd\u00c0\5> \2\u00be\u00c0\5*\26\2\u00bf\u00bc\3\2\2\2\u00bf"+
		"\u00bd\3\2\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2"+
		"\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4"+
		"\u00c5\7&\2\2\u00c5\23\3\2\2\2\u00c6\u00c7\5p9\2\u00c7\u00ca\7.\2\2\u00c8"+
		"\u00cb\5\26\f\2\u00c9\u00cb\5t;\2\u00ca\u00c8\3\2\2\2\u00ca\u00c9\3\2"+
		"\2\2\u00cb\25\3\2\2\2\u00cc\u00d5\5p9\2\u00cd\u00d5\5\30\r\2\u00ce\u00d5"+
		"\5\32\16\2\u00cf\u00d5\5\34\17\2\u00d0\u00d5\5\36\20\2\u00d1\u00d5\5 "+
		"\21\2\u00d2\u00d5\5\"\22\2\u00d3\u00d5\5$\23\2\u00d4\u00cc\3\2\2\2\u00d4"+
		"\u00cd\3\2\2\2\u00d4\u00ce\3\2\2\2\u00d4\u00cf\3\2\2\2\u00d4\u00d0\3\2"+
		"\2\2\u00d4\u00d1\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5"+
		"\27\3\2\2\2\u00d6\u00da\5\\/\2\u00d7\u00da\5J&\2\u00d8\u00da\5P)\2\u00d9"+
		"\u00d6\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00d8\3\2\2\2\u00da\31\3\2\2"+
		"\2\u00db\u00df\5Z.\2\u00dc\u00df\5J&\2\u00dd\u00df\5P)\2\u00de\u00db\3"+
		"\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00dd\3\2\2\2\u00df\33\3\2\2\2\u00e0"+
		"\u00e1\7\'\2\2\u00e1\u00e2\5\32\16\2\u00e2\u00e3\7*\2\2\u00e3\u00e4\5"+
		"\32\16\2\u00e4\u00e5\7(\2\2\u00e5\35\3\2\2\2\u00e6\u00e7\7\'\2\2\u00e7"+
		"\u00e8\5\32\16\2\u00e8\u00e9\7*\2\2\u00e9\u00ea\5\32\16\2\u00ea\u00eb"+
		"\7*\2\2\u00eb\u00ec\5\32\16\2\u00ec\u00ed\7(\2\2\u00ed\37\3\2\2\2\u00ee"+
		"\u00ef\7\'\2\2\u00ef\u00f0\5\32\16\2\u00f0\u00f1\7*\2\2\u00f1\u00f2\5"+
		"\32\16\2\u00f2\u00f3\7*\2\2\u00f3\u00f4\5\32\16\2\u00f4\u00f5\7*\2\2\u00f5"+
		"\u00f6\5\32\16\2\u00f6\u00f7\7(\2\2\u00f7!\3\2\2\2\u00f8\u00fb\7$\2\2"+
		"\u00f9\u00fb\5V,\2\u00fa\u00f8\3\2\2\2\u00fa\u00f9\3\2\2\2\u00fb#\3\2"+
		"\2\2\u00fc\u00fd\5\"\22\2\u00fd\u00fe\7,\2\2\u00fe\u00ff\5\26\f\2\u00ff"+
		"\u0100\7-\2\2\u0100\u0101\5\26\f\2\u0101%\3\2\2\2\u0102\u0103\5(\25\2"+
		"\u0103\'\3\2\2\2\u0104\u0105\7\33\2\2\u0105\u0106\7\'\2\2\u0106\u0107"+
		"\5\"\22\2\u0107\u010a\7(\2\2\u0108\u010b\5\16\b\2\u0109\u010b\5\f\7\2"+
		"\u010a\u0108\3\2\2\2\u010a\u0109\3\2\2\2\u010b\u0116\3\2\2\2\u010c\u010d"+
		"\7\34\2\2\u010d\u010e\7\'\2\2\u010e\u010f\5\"\22\2\u010f\u0112\7(\2\2"+
		"\u0110\u0113\5\16\b\2\u0111\u0113\5\f\7\2\u0112\u0110\3\2\2\2\u0112\u0111"+
		"\3\2\2\2\u0113\u0115\3\2\2\2\u0114\u010c\3\2\2\2\u0115\u0118\3\2\2\2\u0116"+
		"\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u011e\3\2\2\2\u0118\u0116\3\2"+
		"\2\2\u0119\u011c\7\35\2\2\u011a\u011d\5\16\b\2\u011b\u011d\5\f\7\2\u011c"+
		"\u011a\3\2\2\2\u011c\u011b\3\2\2\2\u011d\u011f\3\2\2\2\u011e\u0119\3\2"+
		"\2\2\u011e\u011f\3\2\2\2\u011f)\3\2\2\2\u0120\u0121\7?\2\2\u0121+\3\2"+
		"\2\2\u0122\u0123\7\27\2\2\u0123\u0126\5r:\2\u0124\u0125\t\2\2\2\u0125"+
		"\u0127\5d\63\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0128\3\2"+
		"\2\2\u0128\u0129\5\22\n\2\u0129-\3\2\2\2\u012a\u012b\5d\63\2\u012b\u012c"+
		"\5l\67\2\u012c\u012d\7.\2\2\u012d\u0131\7\'\2\2\u012e\u0130\5\60\31\2"+
		"\u012f\u012e\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132"+
		"\3\2\2\2\u0132\u0134\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0135\7(\2\2\u0135"+
		"/\3\2\2\2\u0136\u0137\5\62\32\2\u0137\u0138\7*\2\2\u0138\u0139\5\60\31"+
		"\2\u0139\u013c\3\2\2\2\u013a\u013c\5\62\32\2\u013b\u0136\3\2\2\2\u013b"+
		"\u013a\3\2\2\2\u013c\61\3\2\2\2\u013d\u0143\5p9\2\u013e\u0143\5Z.\2\u013f"+
		"\u0143\5J&\2\u0140\u0143\5<\37\2\u0141\u0143\5\64\33\2\u0142\u013d\3\2"+
		"\2\2\u0142\u013e\3\2\2\2\u0142\u013f\3\2\2\2\u0142\u0140\3\2\2\2\u0142"+
		"\u0141\3\2\2\2\u0143\63\3\2\2\2\u0144\u0147\5\66\34\2\u0145\u0147\5:\36"+
		"\2\u0146\u0144\3\2\2\2\u0146\u0145\3\2\2\2\u0147\65\3\2\2\2\u0148\u0149"+
		"\5n8\2\u0149\u014a\7\'\2\2\u014a\u014b\5\60\31\2\u014b\u014c\7(\2\2\u014c"+
		"\67\3\2\2\2\u014d\u014e\5l\67\2\u014e\u014f\7)\2\2\u014f\u0150\5p9\2\u0150"+
		"\u0153\7.\2\2\u0151\u0154\5P)\2\u0152\u0154\5\62\32\2\u0153\u0151\3\2"+
		"\2\2\u0153\u0152\3\2\2\2\u01549\3\2\2\2\u0155\u0156\5l\67\2\u0156\u0157"+
		"\7)\2\2\u0157\u0158\5n8\2\u0158\u0161\7.\2\2\u0159\u015b\5\60\31\2\u015a"+
		"\u0159\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u0162\3\2\2\2\u015c\u015e\7\'"+
		"\2\2\u015d\u015f\5\60\31\2\u015e\u015d\3\2\2\2\u015e\u015f\3\2\2\2\u015f"+
		"\u0160\3\2\2\2\u0160\u0162\7(\2\2\u0161\u015a\3\2\2\2\u0161\u015c\3\2"+
		"\2\2\u0162\u016d\3\2\2\2\u0163\u0164\5l\67\2\u0164\u0165\7)\2\2\u0165"+
		"\u0166\5n8\2\u0166\u0168\7\'\2\2\u0167\u0169\5\60\31\2\u0168\u0167\3\2"+
		"\2\2\u0168\u0169\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016b\7(\2\2\u016b"+
		"\u016d\3\2\2\2\u016c\u0155\3\2\2\2\u016c\u0163\3\2\2\2\u016d;\3\2\2\2"+
		"\u016e\u016f\5d\63\2\u016f\u0172\7)\2\2\u0170\u0173\5p9\2\u0171\u0173"+
		"\5h\65\2\u0172\u0170\3\2\2\2\u0172\u0171\3\2\2\2\u0173=\3\2\2\2\u0174"+
		"\u0175\5b\62\2\u0175\u0176\5n8\2\u0176\u0178\7\'\2\2\u0177\u0179\5@!\2"+
		"\u0178\u0177\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017b"+
		"\7(\2\2\u017b\u017c\5\20\t\2\u017c\u0187\3\2\2\2\u017d\u017e\7\t\2\2\u017e"+
		"\u017f\5n8\2\u017f\u0181\7\'\2\2\u0180\u0182\5@!\2\u0181\u0180\3\2\2\2"+
		"\u0181\u0182\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0184\7(\2\2\u0184\u0185"+
		"\5\16\b\2\u0185\u0187\3\2\2\2\u0186\u0174\3\2\2\2\u0186\u017d\3\2\2\2"+
		"\u0187?\3\2\2\2\u0188\u0189\5B\"\2\u0189\u018a\7*\2\2\u018a\u018b\5@!"+
		"\2\u018b\u018e\3\2\2\2\u018c\u018e\5B\"\2\u018d\u0188\3\2\2\2\u018d\u018c"+
		"\3\2\2\2\u018eA\3\2\2\2\u018f\u0190\5f\64\2\u0190\u0191\5p9\2\u0191C\3"+
		"\2\2\2\u0192\u0197\7\32\2\2\u0193\u0198\5p9\2\u0194\u0198\5Z.\2\u0195"+
		"\u0198\7$\2\2\u0196\u0198\5\26\f\2\u0197\u0193\3\2\2\2\u0197\u0194\3\2"+
		"\2\2\u0197\u0195\3\2\2\2\u0197\u0196\3\2\2\2\u0198E\3\2\2\2\u0199\u019c"+
		"\5f\64\2\u019a\u019d\5p9\2\u019b\u019d\5\24\13\2\u019c\u019a\3\2\2\2\u019c"+
		"\u019b\3\2\2\2\u019dG\3\2\2\2\u019e\u01a3\5Z.\2\u019f\u01a3\5P)\2\u01a0"+
		"\u01a3\5p9\2\u01a1\u01a3\7=\2\2\u01a2\u019e\3\2\2\2\u01a2\u019f\3\2\2"+
		"\2\u01a2\u01a0\3\2\2\2\u01a2\u01a1\3\2\2\2\u01a3I\3\2\2\2\u01a4\u01a9"+
		"\5L\'\2\u01a5\u01a6\t\3\2\2\u01a6\u01a8\5L\'\2\u01a7\u01a5\3\2\2\2\u01a8"+
		"\u01ab\3\2\2\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aaK\3\2\2\2"+
		"\u01ab\u01a9\3\2\2\2\u01ac\u01b1\5N(\2\u01ad\u01ae\t\4\2\2\u01ae\u01b0"+
		"\5N(\2\u01af\u01ad\3\2\2\2\u01b0\u01b3\3\2\2\2\u01b1\u01af\3\2\2\2\u01b1"+
		"\u01b2\3\2\2\2\u01b2M\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b4\u01b6\7\60\2\2"+
		"\u01b5\u01b4\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01bd"+
		"\5H%\2\u01b8\u01b9\7\'\2\2\u01b9\u01ba\5J&\2\u01ba\u01bb\7(\2\2\u01bb"+
		"\u01bd\3\2\2\2\u01bc\u01b5\3\2\2\2\u01bc\u01b8\3\2\2\2\u01bdO\3\2\2\2"+
		"\u01be\u01bf\5`\61\2\u01bf\u01c2\7\'\2\2\u01c0\u01c3\5H%\2\u01c1\u01c3"+
		"\5J&\2\u01c2\u01c0\3\2\2\2\u01c2\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4"+
		"\u01c5\7(\2\2\u01c5Q\3\2\2\2\u01c6\u01c7\5T+\2\u01c7S\3\2\2\2\u01c8\u01c9"+
		"\7\36\2\2\u01c9\u01ce\7\'\2\2\u01ca\u01cf\7 \2\2\u01cb\u01cf\5F$\2\u01cc"+
		"\u01cf\5p9\2\u01cd\u01cf\5\24\13\2\u01ce\u01ca\3\2\2\2\u01ce\u01cb\3\2"+
		"\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cd\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0"+
		"\u01d1\7\37\2\2\u01d1\u01d2\7 \2\2\u01d2\u01d5\7(\2\2\u01d3\u01d6\5\16"+
		"\b\2\u01d4\u01d6\5\f\7\2\u01d5\u01d3\3\2\2\2\u01d5\u01d4\3\2\2\2\u01d6"+
		"U\3\2\2\2\u01d7\u01d8\5X-\2\u01d8\u01d9\5V,\2\u01d9\u01dc\3\2\2\2\u01da"+
		"\u01dc\5X-\2\u01db\u01d7\3\2\2\2\u01db\u01da\3\2\2\2\u01dcW\3\2\2\2\u01dd"+
		"\u01e0\7$\2\2\u01de\u01e0\5p9\2\u01df\u01dd\3\2\2\2\u01df\u01de\3\2\2"+
		"\2\u01e0\u01e1\3\2\2\2\u01e1\u01e8\5^\60\2\u01e2\u01e9\7$\2\2\u01e3\u01e9"+
		"\5p9\2\u01e4\u01e5\7\'\2\2\u01e5\u01e6\5X-\2\u01e6\u01e7\7(\2\2\u01e7"+
		"\u01e9\3\2\2\2\u01e8\u01e2\3\2\2\2\u01e8\u01e3\3\2\2\2\u01e8\u01e4\3\2"+
		"\2\2\u01e9\u01f8\3\2\2\2\u01ea\u01f1\5^\60\2\u01eb\u01f2\7$\2\2\u01ec"+
		"\u01f2\5p9\2\u01ed\u01ee\7\'\2\2\u01ee\u01ef\5X-\2\u01ef\u01f0\7(\2\2"+
		"\u01f0\u01f2\3\2\2\2\u01f1\u01eb\3\2\2\2\u01f1\u01ec\3\2\2\2\u01f1\u01ed"+
		"\3\2\2\2\u01f2\u01f8\3\2\2\2\u01f3\u01f4\7\'\2\2\u01f4\u01f5\5X-\2\u01f5"+
		"\u01f6\7(\2\2\u01f6\u01f8\3\2\2\2\u01f7\u01df\3\2\2\2\u01f7\u01ea\3\2"+
		"\2\2\u01f7\u01f3\3\2\2\2\u01f8Y\3\2\2\2\u01f9\u01fd\5\\/\2\u01fa\u01fd"+
		"\7\"\2\2\u01fb\u01fd\7#\2\2\u01fc\u01f9\3\2\2\2\u01fc\u01fa\3\2\2\2\u01fc"+
		"\u01fb\3\2\2\2\u01fd[\3\2\2\2\u01fe\u01ff\t\5\2\2\u01ff]\3\2\2\2\u0200"+
		"\u0201\t\6\2\2\u0201_\3\2\2\2\u0202\u0203\t\7\2\2\u0203a\3\2\2\2\u0204"+
		"\u0205\5f\64\2\u0205c\3\2\2\2\u0206\u0207\t\b\2\2\u0207e\3\2\2\2\u0208"+
		"\u0209\t\t\2\2\u0209g\3\2\2\2\u020a\u020b\5j\66\2\u020bi\3\2\2\2\u020c"+
		"\u020d\t\n\2\2\u020dk\3\2\2\2\u020e\u020f\7>\2\2\u020fm\3\2\2\2\u0210"+
		"\u0211\7>\2\2\u0211o\3\2\2\2\u0212\u0213\7>\2\2\u0213q\3\2\2\2\u0214\u0215"+
		"\7>\2\2\u0215s\3\2\2\2\u0216\u0217\7>\2\2\u0217u\3\2\2\28z|\u0089\u008d"+
		"\u0093\u00a4\u00a9\u00ab\u00b3\u00b5\u00bf\u00c1\u00ca\u00d4\u00d9\u00de"+
		"\u00fa\u010a\u0112\u0116\u011c\u011e\u0126\u0131\u013b\u0142\u0146\u0153"+
		"\u015a\u015e\u0161\u0168\u016c\u0172\u0178\u0181\u0186\u018d\u0197\u019c"+
		"\u01a2\u01a9\u01b1\u01b5\u01bc\u01c2\u01ce\u01d5\u01db\u01df\u01e8\u01f1"+
		"\u01f7\u01fc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}