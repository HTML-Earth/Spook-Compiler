// Generated from C:/Users/the_p/Desktop/P4/src\SpookParser.g4 by ANTLR 4.7.2
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
		RECTANGLE=9, TRIANGLE=10, SHAPE=11, COLOR=12, BLACK=13, WHITE=14, RED=15, 
		GREEN=16, BLUE=17, MAIN=18, CLASS=19, EXTENDS=20, IMPLEMENTS=21, RETURN=22, 
		IF=23, ELSE_IF=24, ELSE=25, FOR=26, TO=27, DIGIT=28, DIGIT_NEGATIVE=29, 
		FLOAT_DIGIT=30, FLOAT_DIGIT_NEGATIVE=31, BOOL_LITERAL=32, LEFT_BRACKET=33, 
		RIGHT_BRACKET=34, LEFT_PAREN=35, RIGHT_PAREN=36, DOT=37, COMMA=38, SEMICOLON=39, 
		QUESTION=40, COLON=41, ASSIGN=42, ADD=43, SUB=44, MOD=45, DIV=46, MUL=47, 
		EQUAL=48, AND=49, OR=50, NOT_EQUAL=51, NOT=52, ABS=53, SIN=54, COS=55, 
		TAN=56, UNIFORM=57, ID=58, COMMENT_STRING=59, WS=60;
	public static final int
		RULE_program = 0, RULE_main = 1, RULE_declarations = 2, RULE_declaration = 3, 
		RULE_statements = 4, RULE_statement = 5, RULE_block = 6, RULE_classBlock = 7, 
		RULE_assignment = 8, RULE_expression = 9, RULE_integerExpression = 10, 
		RULE_floatExpression = 11, RULE_vector2Expression = 12, RULE_vector3Expression = 13, 
		RULE_vector4Expression = 14, RULE_boolExpression = 15, RULE_ternaryOperator = 16, 
		RULE_conditionalStatement = 17, RULE_ifElseStatement = 18, RULE_comment = 19, 
		RULE_classDecl = 20, RULE_objectDecl = 21, RULE_objectArgs = 22, RULE_objectArg = 23, 
		RULE_objectFunctionCall = 24, RULE_classProperty = 25, RULE_functionDecl = 26, 
		RULE_functionArgs = 27, RULE_functionArg = 28, RULE_variableDecl = 29, 
		RULE_variableDeclVarNameOrAss = 30, RULE_arithOperations = 31, RULE_arithOperation = 32, 
		RULE_arithOperand = 33, RULE_mathFunction = 34, RULE_iterativeStatement = 35, 
		RULE_forStatement = 36, RULE_boolOperations = 37, RULE_boolOperation = 38, 
		RULE_realNumber = 39, RULE_naturalNumber = 40, RULE_operator = 41, RULE_boolOperator = 42, 
		RULE_function = 43, RULE_returnType = 44, RULE_classType = 45, RULE_dataType = 46, 
		RULE_objectVariableName = 47, RULE_functionName = 48, RULE_variableName = 49, 
		RULE_className = 50;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main", "declarations", "declaration", "statements", "statement", 
			"block", "classBlock", "assignment", "expression", "integerExpression", 
			"floatExpression", "vector2Expression", "vector3Expression", "vector4Expression", 
			"boolExpression", "ternaryOperator", "conditionalStatement", "ifElseStatement", 
			"comment", "classDecl", "objectDecl", "objectArgs", "objectArg", "objectFunctionCall", 
			"classProperty", "functionDecl", "functionArgs", "functionArg", "variableDecl", 
			"variableDeclVarNameOrAss", "arithOperations", "arithOperation", "arithOperand", 
			"mathFunction", "iterativeStatement", "forStatement", "boolOperations", 
			"boolOperation", "realNumber", "naturalNumber", "operator", "boolOperator", 
			"function", "returnType", "classType", "dataType", "objectVariableName", 
			"functionName", "variableName", "className"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Int'", "'Float'", "'Bool'", "'Vec2'", "'Vec3'", "'Vec4'", "'void'", 
			"'Circle'", "'Rectangle'", "'Triangle'", "'Shape'", "'Color'", "'Black'", 
			"'White'", "'Red'", "'Green'", "'Blue'", "'Shader'", "'class'", "'extends'", 
			"'implements'", "'return'", "'if'", "'else if'", "'else'", "'for'", "'to'", 
			null, null, null, null, null, "'{'", "'}'", "'('", "')'", "'.'", "','", 
			"';'", "'?'", "':'", "'='", "'+'", "'-'", "'%'", "'/'", "'*'", "'=='", 
			"'&&'", "'||'", "'!='", "'!'", "'abs'", "'sin'", "'cos'", "'tan'", "'Time'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "FLOAT", "BOOL", "VECTOR2", "VECTOR3", "VECTOR4", "VOID", 
			"CIRCLE", "RECTANGLE", "TRIANGLE", "SHAPE", "COLOR", "BLACK", "WHITE", 
			"RED", "GREEN", "BLUE", "MAIN", "CLASS", "EXTENDS", "IMPLEMENTS", "RETURN", 
			"IF", "ELSE_IF", "ELSE", "FOR", "TO", "DIGIT", "DIGIT_NEGATIVE", "FLOAT_DIGIT", 
			"FLOAT_DIGIT_NEGATIVE", "BOOL_LITERAL", "LEFT_BRACKET", "RIGHT_BRACKET", 
			"LEFT_PAREN", "RIGHT_PAREN", "DOT", "COMMA", "SEMICOLON", "QUESTION", 
			"COLON", "ASSIGN", "ADD", "SUB", "MOD", "DIV", "MUL", "EQUAL", "AND", 
			"OR", "NOT_EQUAL", "NOT", "ABS", "SIN", "COS", "TAN", "UNIFORM", "ID", 
			"COMMENT_STRING", "WS"
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
			setState(102);
			main();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << VECTOR2) | (1L << VECTOR3) | (1L << VECTOR4) | (1L << VOID) | (1L << CLASS) | (1L << COMMENT_STRING))) != 0)) {
				{
				setState(106);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case COMMENT_STRING:
					{
					setState(103);
					comment();
					}
					break;
				case CLASS:
					{
					setState(104);
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
					setState(105);
					functionDecl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(110);
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
			setState(111);
			match(MAIN);
			setState(112);
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
			setState(121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				declaration();
				setState(115);
				match(SEMICOLON);
				setState(116);
				declarations();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				declaration();
				setState(119);
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
			setState(125);
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
				setState(123);
				variableDecl();
				}
				break;
			case CIRCLE:
			case RECTANGLE:
			case TRIANGLE:
			case SHAPE:
			case COLOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
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
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				statement();
				setState(128);
				statements();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
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
		public ObjectFunctionCallContext objectFunctionCall() {
			return getRuleContext(ObjectFunctionCallContext.class,0);
		}
		public ConditionalStatementContext conditionalStatement() {
			return getRuleContext(ConditionalStatementContext.class,0);
		}
		public IterativeStatementContext iterativeStatement() {
			return getRuleContext(IterativeStatementContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(SpookParser.RETURN, 0); }
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public RealNumberContext realNumber() {
			return getRuleContext(RealNumberContext.class,0);
		}
		public TerminalNode BOOL_LITERAL() { return getToken(SpookParser.BOOL_LITERAL, 0); }
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
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				declaration();
				setState(134);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				assignment();
				setState(137);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(139);
				objectFunctionCall();
				setState(140);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(142);
				conditionalStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(143);
				iterativeStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(144);
				match(RETURN);
				setState(148);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(145);
					variableName();
					}
					break;
				case DIGIT:
				case DIGIT_NEGATIVE:
				case FLOAT_DIGIT:
				case FLOAT_DIGIT_NEGATIVE:
					{
					setState(146);
					realNumber();
					}
					break;
				case BOOL_LITERAL:
					{
					setState(147);
					match(BOOL_LITERAL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(150);
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
			setState(153);
			match(LEFT_BRACKET);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << VECTOR2) | (1L << VECTOR3) | (1L << VECTOR4) | (1L << CIRCLE) | (1L << RECTANGLE) | (1L << TRIANGLE) | (1L << SHAPE) | (1L << COLOR) | (1L << RETURN) | (1L << IF) | (1L << FOR) | (1L << ID) | (1L << COMMENT_STRING))) != 0)) {
				{
				setState(156);
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
				case RETURN:
				case IF:
				case FOR:
				case ID:
					{
					setState(154);
					statements();
					}
					break;
				case COMMENT_STRING:
					{
					setState(155);
					comment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(161);
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
		enterRule(_localctx, 14, RULE_classBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(LEFT_BRACKET);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << VECTOR2) | (1L << VECTOR3) | (1L << VECTOR4) | (1L << VOID) | (1L << CIRCLE) | (1L << RECTANGLE) | (1L << TRIANGLE) | (1L << SHAPE) | (1L << COLOR) | (1L << COMMENT_STRING))) != 0)) {
				{
				setState(167);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(164);
					declarations();
					}
					break;
				case 2:
					{
					setState(165);
					functionDecl();
					}
					break;
				case 3:
					{
					setState(166);
					comment();
					}
					break;
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

	public static class AssignmentContext extends ParserRuleContext {
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SpookParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 16, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			variableName();
			setState(175);
			match(ASSIGN);
			setState(176);
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

	public static class ExpressionContext extends ParserRuleContext {
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
		enterRule(_localctx, 18, RULE_expression);
		try {
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				integerExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				floatExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(180);
				vector2Expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(181);
				vector3Expression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(182);
				vector4Expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(183);
				boolExpression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(184);
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
		public ArithOperationsContext arithOperations() {
			return getRuleContext(ArithOperationsContext.class,0);
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
		enterRule(_localctx, 20, RULE_integerExpression);
		try {
			setState(190);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				naturalNumber();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				arithOperations();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(189);
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
		public ArithOperationsContext arithOperations() {
			return getRuleContext(ArithOperationsContext.class,0);
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
		enterRule(_localctx, 22, RULE_floatExpression);
		try {
			setState(195);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				realNumber();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				arithOperations();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(194);
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
		enterRule(_localctx, 24, RULE_vector2Expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(LEFT_PAREN);
			setState(198);
			floatExpression();
			setState(199);
			match(COMMA);
			setState(200);
			floatExpression();
			setState(201);
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
		enterRule(_localctx, 26, RULE_vector3Expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(LEFT_PAREN);
			setState(204);
			floatExpression();
			setState(205);
			match(COMMA);
			setState(206);
			floatExpression();
			setState(207);
			match(COMMA);
			setState(208);
			floatExpression();
			setState(209);
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
		enterRule(_localctx, 28, RULE_vector4Expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(LEFT_PAREN);
			setState(212);
			floatExpression();
			setState(213);
			match(COMMA);
			setState(214);
			floatExpression();
			setState(215);
			match(COMMA);
			setState(216);
			floatExpression();
			setState(217);
			match(COMMA);
			setState(218);
			floatExpression();
			setState(219);
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
		enterRule(_localctx, 30, RULE_boolExpression);
		try {
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				match(BOOL_LITERAL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
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
		enterRule(_localctx, 32, RULE_ternaryOperator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			boolExpression();
			setState(226);
			match(QUESTION);
			setState(227);
			expression();
			setState(228);
			match(COLON);
			setState(229);
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
		enterRule(_localctx, 34, RULE_conditionalStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
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
		enterRule(_localctx, 36, RULE_ifElseStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(IF);
			setState(234);
			match(LEFT_PAREN);
			setState(235);
			boolExpression();
			setState(236);
			match(RIGHT_PAREN);
			setState(239);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_BRACKET:
				{
				setState(237);
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
			case RETURN:
			case IF:
			case FOR:
			case ID:
				{
				setState(238);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(251);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(241);
					match(ELSE_IF);
					setState(242);
					match(LEFT_PAREN);
					setState(243);
					boolExpression();
					setState(244);
					match(RIGHT_PAREN);
					setState(247);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LEFT_BRACKET:
						{
						setState(245);
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
					case RETURN:
					case IF:
					case FOR:
					case ID:
						{
						setState(246);
						statement();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(253);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(259);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(254);
				match(ELSE);
				setState(257);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LEFT_BRACKET:
					{
					setState(255);
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
				case RETURN:
				case IF:
				case FOR:
				case ID:
					{
					setState(256);
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
		enterRule(_localctx, 38, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
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
		enterRule(_localctx, 40, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(CLASS);
			setState(264);
			className();
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS || _la==IMPLEMENTS) {
				{
				setState(265);
				_la = _input.LA(1);
				if ( !(_la==EXTENDS || _la==IMPLEMENTS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(266);
				classType();
				}
			}

			setState(269);
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
		enterRule(_localctx, 42, RULE_objectDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			classType();
			setState(272);
			objectVariableName();
			setState(273);
			match(ASSIGN);
			setState(274);
			match(LEFT_PAREN);
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CIRCLE) | (1L << RECTANGLE) | (1L << TRIANGLE) | (1L << SHAPE) | (1L << COLOR) | (1L << DIGIT) | (1L << DIGIT_NEGATIVE) | (1L << FLOAT_DIGIT) | (1L << FLOAT_DIGIT_NEGATIVE) | (1L << LEFT_PAREN) | (1L << ADD) | (1L << SUB) | (1L << MOD) | (1L << DIV) | (1L << MUL) | (1L << ABS) | (1L << SIN) | (1L << COS) | (1L << TAN) | (1L << UNIFORM) | (1L << ID))) != 0)) {
				{
				{
				setState(275);
				objectArgs();
				}
				}
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(281);
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
		enterRule(_localctx, 44, RULE_objectArgs);
		try {
			setState(288);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(283);
				objectArg();
				setState(284);
				match(COMMA);
				setState(285);
				objectArgs();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(287);
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
		public ArithOperationContext arithOperation() {
			return getRuleContext(ArithOperationContext.class,0);
		}
		public ClassPropertyContext classProperty() {
			return getRuleContext(ClassPropertyContext.class,0);
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
		enterRule(_localctx, 46, RULE_objectArg);
		try {
			setState(294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(290);
				variableName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(291);
				realNumber();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(292);
				arithOperation();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(293);
				classProperty();
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
		enterRule(_localctx, 48, RULE_objectFunctionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(296);
				objectVariableName();
				setState(297);
				match(DOT);
				setState(298);
				functionName();
				setState(299);
				match(ASSIGN);
				setState(308);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(301);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CIRCLE) | (1L << RECTANGLE) | (1L << TRIANGLE) | (1L << SHAPE) | (1L << COLOR) | (1L << DIGIT) | (1L << DIGIT_NEGATIVE) | (1L << FLOAT_DIGIT) | (1L << FLOAT_DIGIT_NEGATIVE) | (1L << LEFT_PAREN) | (1L << ADD) | (1L << SUB) | (1L << MOD) | (1L << DIV) | (1L << MUL) | (1L << ABS) | (1L << SIN) | (1L << COS) | (1L << TAN) | (1L << UNIFORM) | (1L << ID))) != 0)) {
						{
						setState(300);
						objectArgs();
						}
					}

					}
					break;
				case 2:
					{
					setState(303);
					match(LEFT_PAREN);
					setState(305);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CIRCLE) | (1L << RECTANGLE) | (1L << TRIANGLE) | (1L << SHAPE) | (1L << COLOR) | (1L << DIGIT) | (1L << DIGIT_NEGATIVE) | (1L << FLOAT_DIGIT) | (1L << FLOAT_DIGIT_NEGATIVE) | (1L << LEFT_PAREN) | (1L << ADD) | (1L << SUB) | (1L << MOD) | (1L << DIV) | (1L << MUL) | (1L << ABS) | (1L << SIN) | (1L << COS) | (1L << TAN) | (1L << UNIFORM) | (1L << ID))) != 0)) {
						{
						setState(304);
						objectArgs();
						}
					}

					setState(307);
					match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			case 2:
				{
				setState(310);
				objectVariableName();
				setState(311);
				match(DOT);
				setState(312);
				functionName();
				setState(313);
				match(LEFT_PAREN);
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CIRCLE) | (1L << RECTANGLE) | (1L << TRIANGLE) | (1L << SHAPE) | (1L << COLOR) | (1L << DIGIT) | (1L << DIGIT_NEGATIVE) | (1L << FLOAT_DIGIT) | (1L << FLOAT_DIGIT_NEGATIVE) | (1L << LEFT_PAREN) | (1L << ADD) | (1L << SUB) | (1L << MOD) | (1L << DIV) | (1L << MUL) | (1L << ABS) | (1L << SIN) | (1L << COS) | (1L << TAN) | (1L << UNIFORM) | (1L << ID))) != 0)) {
					{
					setState(314);
					objectArgs();
					}
				}

				setState(317);
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
		enterRule(_localctx, 50, RULE_classProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			classType();
			setState(322);
			match(DOT);
			setState(323);
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

	public static class FunctionDeclContext extends ParserRuleContext {
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public FunctionNameContext functionName() {
			return getRuleContext(FunctionNameContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SpookParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionArgsContext functionArgs() {
			return getRuleContext(FunctionArgsContext.class,0);
		}
		public TerminalNode VOID() { return getToken(SpookParser.VOID, 0); }
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
		enterRule(_localctx, 52, RULE_functionDecl);
		int _la;
		try {
			setState(343);
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
				setState(325);
				returnType();
				setState(326);
				functionName();
				setState(327);
				match(LEFT_PAREN);
				setState(329);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << VECTOR2) | (1L << VECTOR3) | (1L << VECTOR4))) != 0)) {
					{
					setState(328);
					functionArgs();
					}
				}

				setState(331);
				match(RIGHT_PAREN);
				setState(332);
				block();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(334);
				match(VOID);
				setState(335);
				functionName();
				setState(336);
				match(LEFT_PAREN);
				setState(338);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << VECTOR2) | (1L << VECTOR3) | (1L << VECTOR4))) != 0)) {
					{
					setState(337);
					functionArgs();
					}
				}

				setState(340);
				match(RIGHT_PAREN);
				setState(341);
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
		enterRule(_localctx, 54, RULE_functionArgs);
		try {
			setState(350);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(345);
				functionArg();
				setState(346);
				match(COMMA);
				setState(347);
				functionArgs();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
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
		enterRule(_localctx, 56, RULE_functionArg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			dataType();
			setState(353);
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

	public static class VariableDeclContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public List<VariableDeclVarNameOrAssContext> variableDeclVarNameOrAss() {
			return getRuleContexts(VariableDeclVarNameOrAssContext.class);
		}
		public VariableDeclVarNameOrAssContext variableDeclVarNameOrAss(int i) {
			return getRuleContext(VariableDeclVarNameOrAssContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SpookParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SpookParser.COMMA, i);
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
		enterRule(_localctx, 58, RULE_variableDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			dataType();
			setState(356);
			variableDeclVarNameOrAss();
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(357);
				match(COMMA);
				setState(358);
				variableDeclVarNameOrAss();
				}
				}
				setState(363);
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

	public static class VariableDeclVarNameOrAssContext extends ParserRuleContext {
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public VariableDeclVarNameOrAssContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclVarNameOrAss; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterVariableDeclVarNameOrAss(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitVariableDeclVarNameOrAss(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitVariableDeclVarNameOrAss(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclVarNameOrAssContext variableDeclVarNameOrAss() throws RecognitionException {
		VariableDeclVarNameOrAssContext _localctx = new VariableDeclVarNameOrAssContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_variableDeclVarNameOrAss);
		try {
			setState(366);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(364);
				variableName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(365);
				assignment();
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

	public static class ArithOperationsContext extends ParserRuleContext {
		public ArithOperationContext arithOperation() {
			return getRuleContext(ArithOperationContext.class,0);
		}
		public ArithOperationsContext arithOperations() {
			return getRuleContext(ArithOperationsContext.class,0);
		}
		public ArithOperationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithOperations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterArithOperations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitArithOperations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitArithOperations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithOperationsContext arithOperations() throws RecognitionException {
		ArithOperationsContext _localctx = new ArithOperationsContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_arithOperations);
		try {
			setState(372);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(368);
				arithOperation();
				setState(369);
				arithOperations();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(371);
				arithOperation();
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

	public static class ArithOperationContext extends ParserRuleContext {
		public List<ArithOperandContext> arithOperand() {
			return getRuleContexts(ArithOperandContext.class);
		}
		public ArithOperandContext arithOperand(int i) {
			return getRuleContext(ArithOperandContext.class,i);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SpookParser.LEFT_PAREN, 0); }
		public ArithOperationsContext arithOperations() {
			return getRuleContext(ArithOperationsContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
		public ArithOperationContext arithOperation() {
			return getRuleContext(ArithOperationContext.class,0);
		}
		public ArithOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterArithOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitArithOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitArithOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithOperationContext arithOperation() throws RecognitionException {
		ArithOperationContext _localctx = new ArithOperationContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_arithOperation);
		try {
			setState(395);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIGIT:
			case DIGIT_NEGATIVE:
			case FLOAT_DIGIT:
			case FLOAT_DIGIT_NEGATIVE:
			case ABS:
			case SIN:
			case COS:
			case TAN:
			case UNIFORM:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(374);
				arithOperand();
				setState(375);
				operator();
				setState(381);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DIGIT:
				case DIGIT_NEGATIVE:
				case FLOAT_DIGIT:
				case FLOAT_DIGIT_NEGATIVE:
				case ABS:
				case SIN:
				case COS:
				case TAN:
				case UNIFORM:
				case ID:
					{
					setState(376);
					arithOperand();
					}
					break;
				case LEFT_PAREN:
					{
					setState(377);
					match(LEFT_PAREN);
					setState(378);
					arithOperations();
					setState(379);
					match(RIGHT_PAREN);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case ADD:
			case SUB:
			case MOD:
			case DIV:
			case MUL:
				enterOuterAlt(_localctx, 2);
				{
				setState(383);
				operator();
				setState(389);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DIGIT:
				case DIGIT_NEGATIVE:
				case FLOAT_DIGIT:
				case FLOAT_DIGIT_NEGATIVE:
				case ABS:
				case SIN:
				case COS:
				case TAN:
				case UNIFORM:
				case ID:
					{
					setState(384);
					arithOperand();
					}
					break;
				case LEFT_PAREN:
					{
					setState(385);
					match(LEFT_PAREN);
					setState(386);
					arithOperation();
					setState(387);
					match(RIGHT_PAREN);
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
				setState(391);
				match(LEFT_PAREN);
				setState(392);
				arithOperations();
				setState(393);
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
		enterRule(_localctx, 66, RULE_arithOperand);
		try {
			setState(401);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIGIT:
			case DIGIT_NEGATIVE:
			case FLOAT_DIGIT:
			case FLOAT_DIGIT_NEGATIVE:
				enterOuterAlt(_localctx, 1);
				{
				setState(397);
				realNumber();
				}
				break;
			case ABS:
			case SIN:
			case COS:
			case TAN:
				enterOuterAlt(_localctx, 2);
				{
				setState(398);
				mathFunction();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(399);
				variableName();
				}
				break;
			case UNIFORM:
				enterOuterAlt(_localctx, 4);
				{
				setState(400);
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

	public static class MathFunctionContext extends ParserRuleContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SpookParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
		public ArithOperandContext arithOperand() {
			return getRuleContext(ArithOperandContext.class,0);
		}
		public ArithOperationsContext arithOperations() {
			return getRuleContext(ArithOperationsContext.class,0);
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
		enterRule(_localctx, 68, RULE_mathFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			function();
			setState(404);
			match(LEFT_PAREN);
			setState(407);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				setState(405);
				arithOperand();
				}
				break;
			case 2:
				{
				setState(406);
				arithOperations();
				}
				break;
			}
			setState(409);
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
		enterRule(_localctx, 70, RULE_iterativeStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
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
		public List<TerminalNode> DIGIT() { return getTokens(SpookParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(SpookParser.DIGIT, i);
		}
		public TerminalNode TO() { return getToken(SpookParser.TO, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
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
		enterRule(_localctx, 72, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			match(FOR);
			setState(414);
			match(LEFT_PAREN);
			setState(415);
			match(DIGIT);
			setState(416);
			match(TO);
			setState(417);
			match(DIGIT);
			setState(418);
			match(RIGHT_PAREN);
			setState(421);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_BRACKET:
				{
				setState(419);
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
			case RETURN:
			case IF:
			case FOR:
			case ID:
				{
				setState(420);
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
		enterRule(_localctx, 74, RULE_boolOperations);
		try {
			setState(427);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(423);
				boolOperation();
				setState(424);
				boolOperations();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(426);
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
		enterRule(_localctx, 76, RULE_boolOperation);
		try {
			setState(455);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL_LITERAL:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(431);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL_LITERAL:
					{
					setState(429);
					match(BOOL_LITERAL);
					}
					break;
				case ID:
					{
					setState(430);
					variableName();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(433);
				boolOperator();
				setState(440);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL_LITERAL:
					{
					setState(434);
					match(BOOL_LITERAL);
					}
					break;
				case ID:
					{
					setState(435);
					variableName();
					}
					break;
				case LEFT_PAREN:
					{
					{
					setState(436);
					match(LEFT_PAREN);
					setState(437);
					boolOperation();
					setState(438);
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
				setState(442);
				boolOperator();
				setState(449);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL_LITERAL:
					{
					setState(443);
					match(BOOL_LITERAL);
					}
					break;
				case ID:
					{
					setState(444);
					variableName();
					}
					break;
				case LEFT_PAREN:
					{
					{
					setState(445);
					match(LEFT_PAREN);
					setState(446);
					boolOperation();
					setState(447);
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
				setState(451);
				match(LEFT_PAREN);
				setState(452);
				boolOperation();
				setState(453);
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
		enterRule(_localctx, 78, RULE_realNumber);
		try {
			setState(460);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIGIT:
			case DIGIT_NEGATIVE:
				enterOuterAlt(_localctx, 1);
				{
				setState(457);
				naturalNumber();
				}
				break;
			case FLOAT_DIGIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(458);
				match(FLOAT_DIGIT);
				}
				break;
			case FLOAT_DIGIT_NEGATIVE:
				enterOuterAlt(_localctx, 3);
				{
				setState(459);
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
		enterRule(_localctx, 80, RULE_naturalNumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
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

	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(SpookParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(SpookParser.SUB, 0); }
		public TerminalNode MOD() { return getToken(SpookParser.MOD, 0); }
		public TerminalNode DIV() { return getToken(SpookParser.DIV, 0); }
		public TerminalNode MUL() { return getToken(SpookParser.MUL, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MOD) | (1L << DIV) | (1L << MUL))) != 0)) ) {
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
		enterRule(_localctx, 84, RULE_boolOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
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
		enterRule(_localctx, 86, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
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
		enterRule(_localctx, 88, RULE_returnType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(470);
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
		enterRule(_localctx, 90, RULE_classType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CIRCLE) | (1L << RECTANGLE) | (1L << TRIANGLE) | (1L << SHAPE) | (1L << COLOR))) != 0)) ) {
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
		enterRule(_localctx, 92, RULE_dataType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
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
		enterRule(_localctx, 94, RULE_objectVariableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
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
		enterRule(_localctx, 96, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
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
		enterRule(_localctx, 98, RULE_variableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(480);
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
		enterRule(_localctx, 100, RULE_className);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(482);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3>\u01e7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\3\2\3\2\3\2\3\2\7\2m\n\2\f\2\16\2p\13\2\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\4|\n\4\3\5\3\5\5\5\u0080\n\5\3\6\3\6\3\6\3\6\5\6\u0086"+
		"\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0097"+
		"\n\7\3\7\5\7\u009a\n\7\3\b\3\b\3\b\7\b\u009f\n\b\f\b\16\b\u00a2\13\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\7\t\u00aa\n\t\f\t\16\t\u00ad\13\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00bc\n\13\3\f\3\f"+
		"\3\f\5\f\u00c1\n\f\3\r\3\r\3\r\5\r\u00c6\n\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\5\21\u00e2\n\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00f2\n\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u00fa\n\24\7\24\u00fc\n\24\f\24\16\24\u00ff"+
		"\13\24\3\24\3\24\3\24\5\24\u0104\n\24\5\24\u0106\n\24\3\25\3\25\3\26\3"+
		"\26\3\26\3\26\5\26\u010e\n\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\7\27"+
		"\u0117\n\27\f\27\16\27\u011a\13\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30"+
		"\5\30\u0123\n\30\3\31\3\31\3\31\3\31\5\31\u0129\n\31\3\32\3\32\3\32\3"+
		"\32\3\32\5\32\u0130\n\32\3\32\3\32\5\32\u0134\n\32\3\32\5\32\u0137\n\32"+
		"\3\32\3\32\3\32\3\32\3\32\5\32\u013e\n\32\3\32\3\32\5\32\u0142\n\32\3"+
		"\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\5\34\u014c\n\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\5\34\u0155\n\34\3\34\3\34\3\34\5\34\u015a\n\34\3"+
		"\35\3\35\3\35\3\35\3\35\5\35\u0161\n\35\3\36\3\36\3\36\3\37\3\37\3\37"+
		"\3\37\7\37\u016a\n\37\f\37\16\37\u016d\13\37\3 \3 \5 \u0171\n \3!\3!\3"+
		"!\3!\5!\u0177\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0180\n\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\5\"\u0188\n\"\3\"\3\"\3\"\3\"\5\"\u018e\n\"\3#\3#\3#\3#\5"+
		"#\u0194\n#\3$\3$\3$\3$\5$\u019a\n$\3$\3$\3%\3%\3&\3&\3&\3&\3&\3&\3&\3"+
		"&\5&\u01a8\n&\3\'\3\'\3\'\3\'\5\'\u01ae\n\'\3(\3(\5(\u01b2\n(\3(\3(\3"+
		"(\3(\3(\3(\3(\5(\u01bb\n(\3(\3(\3(\3(\3(\3(\3(\5(\u01c4\n(\3(\3(\3(\3"+
		"(\5(\u01ca\n(\3)\3)\3)\5)\u01cf\n)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3"+
		"/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\64\2\2\65\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRT"+
		"VXZ\\^`bdf\2\t\3\2\26\27\3\2\36\37\3\2-\61\3\2\62\66\3\2\67:\3\2\n\16"+
		"\3\2\3\b\2\u01fa\2h\3\2\2\2\4q\3\2\2\2\6{\3\2\2\2\b\177\3\2\2\2\n\u0085"+
		"\3\2\2\2\f\u0099\3\2\2\2\16\u009b\3\2\2\2\20\u00a5\3\2\2\2\22\u00b0\3"+
		"\2\2\2\24\u00bb\3\2\2\2\26\u00c0\3\2\2\2\30\u00c5\3\2\2\2\32\u00c7\3\2"+
		"\2\2\34\u00cd\3\2\2\2\36\u00d5\3\2\2\2 \u00e1\3\2\2\2\"\u00e3\3\2\2\2"+
		"$\u00e9\3\2\2\2&\u00eb\3\2\2\2(\u0107\3\2\2\2*\u0109\3\2\2\2,\u0111\3"+
		"\2\2\2.\u0122\3\2\2\2\60\u0128\3\2\2\2\62\u0141\3\2\2\2\64\u0143\3\2\2"+
		"\2\66\u0159\3\2\2\28\u0160\3\2\2\2:\u0162\3\2\2\2<\u0165\3\2\2\2>\u0170"+
		"\3\2\2\2@\u0176\3\2\2\2B\u018d\3\2\2\2D\u0193\3\2\2\2F\u0195\3\2\2\2H"+
		"\u019d\3\2\2\2J\u019f\3\2\2\2L\u01ad\3\2\2\2N\u01c9\3\2\2\2P\u01ce\3\2"+
		"\2\2R\u01d0\3\2\2\2T\u01d2\3\2\2\2V\u01d4\3\2\2\2X\u01d6\3\2\2\2Z\u01d8"+
		"\3\2\2\2\\\u01da\3\2\2\2^\u01dc\3\2\2\2`\u01de\3\2\2\2b\u01e0\3\2\2\2"+
		"d\u01e2\3\2\2\2f\u01e4\3\2\2\2hn\5\4\3\2im\5(\25\2jm\5*\26\2km\5\66\34"+
		"\2li\3\2\2\2lj\3\2\2\2lk\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o\3\3\2"+
		"\2\2pn\3\2\2\2qr\7\24\2\2rs\5\16\b\2s\5\3\2\2\2tu\5\b\5\2uv\7)\2\2vw\5"+
		"\6\4\2w|\3\2\2\2xy\5\b\5\2yz\7)\2\2z|\3\2\2\2{t\3\2\2\2{x\3\2\2\2|\7\3"+
		"\2\2\2}\u0080\5<\37\2~\u0080\5,\27\2\177}\3\2\2\2\177~\3\2\2\2\u0080\t"+
		"\3\2\2\2\u0081\u0082\5\f\7\2\u0082\u0083\5\n\6\2\u0083\u0086\3\2\2\2\u0084"+
		"\u0086\5\f\7\2\u0085\u0081\3\2\2\2\u0085\u0084\3\2\2\2\u0086\13\3\2\2"+
		"\2\u0087\u0088\5\b\5\2\u0088\u0089\7)\2\2\u0089\u009a\3\2\2\2\u008a\u008b"+
		"\5\22\n\2\u008b\u008c\7)\2\2\u008c\u009a\3\2\2\2\u008d\u008e\5\62\32\2"+
		"\u008e\u008f\7)\2\2\u008f\u009a\3\2\2\2\u0090\u009a\5$\23\2\u0091\u009a"+
		"\5H%\2\u0092\u0096\7\30\2\2\u0093\u0097\5d\63\2\u0094\u0097\5P)\2\u0095"+
		"\u0097\7\"\2\2\u0096\u0093\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0095\3\2"+
		"\2\2\u0097\u0098\3\2\2\2\u0098\u009a\7)\2\2\u0099\u0087\3\2\2\2\u0099"+
		"\u008a\3\2\2\2\u0099\u008d\3\2\2\2\u0099\u0090\3\2\2\2\u0099\u0091\3\2"+
		"\2\2\u0099\u0092\3\2\2\2\u009a\r\3\2\2\2\u009b\u00a0\7#\2\2\u009c\u009f"+
		"\5\n\6\2\u009d\u009f\5(\25\2\u009e\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009f"+
		"\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3\3\2"+
		"\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4\7$\2\2\u00a4\17\3\2\2\2\u00a5\u00ab"+
		"\7#\2\2\u00a6\u00aa\5\6\4\2\u00a7\u00aa\5\66\34\2\u00a8\u00aa\5(\25\2"+
		"\u00a9\u00a6\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ad"+
		"\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\u00ae\u00af\7$\2\2\u00af\21\3\2\2\2\u00b0\u00b1\5d\63\2"+
		"\u00b1\u00b2\7,\2\2\u00b2\u00b3\5\24\13\2\u00b3\23\3\2\2\2\u00b4\u00bc"+
		"\5\26\f\2\u00b5\u00bc\5\30\r\2\u00b6\u00bc\5\32\16\2\u00b7\u00bc\5\34"+
		"\17\2\u00b8\u00bc\5\36\20\2\u00b9\u00bc\5 \21\2\u00ba\u00bc\5\"\22\2\u00bb"+
		"\u00b4\3\2\2\2\u00bb\u00b5\3\2\2\2\u00bb\u00b6\3\2\2\2\u00bb\u00b7\3\2"+
		"\2\2\u00bb\u00b8\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc"+
		"\25\3\2\2\2\u00bd\u00c1\5R*\2\u00be\u00c1\5@!\2\u00bf\u00c1\5F$\2\u00c0"+
		"\u00bd\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\27\3\2\2"+
		"\2\u00c2\u00c6\5P)\2\u00c3\u00c6\5@!\2\u00c4\u00c6\5F$\2\u00c5\u00c2\3"+
		"\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\31\3\2\2\2\u00c7"+
		"\u00c8\7%\2\2\u00c8\u00c9\5\30\r\2\u00c9\u00ca\7(\2\2\u00ca\u00cb\5\30"+
		"\r\2\u00cb\u00cc\7&\2\2\u00cc\33\3\2\2\2\u00cd\u00ce\7%\2\2\u00ce\u00cf"+
		"\5\30\r\2\u00cf\u00d0\7(\2\2\u00d0\u00d1\5\30\r\2\u00d1\u00d2\7(\2\2\u00d2"+
		"\u00d3\5\30\r\2\u00d3\u00d4\7&\2\2\u00d4\35\3\2\2\2\u00d5\u00d6\7%\2\2"+
		"\u00d6\u00d7\5\30\r\2\u00d7\u00d8\7(\2\2\u00d8\u00d9\5\30\r\2\u00d9\u00da"+
		"\7(\2\2\u00da\u00db\5\30\r\2\u00db\u00dc\7(\2\2\u00dc\u00dd\5\30\r\2\u00dd"+
		"\u00de\7&\2\2\u00de\37\3\2\2\2\u00df\u00e2\7\"\2\2\u00e0\u00e2\5L\'\2"+
		"\u00e1\u00df\3\2\2\2\u00e1\u00e0\3\2\2\2\u00e2!\3\2\2\2\u00e3\u00e4\5"+
		" \21\2\u00e4\u00e5\7*\2\2\u00e5\u00e6\5\24\13\2\u00e6\u00e7\7+\2\2\u00e7"+
		"\u00e8\5\24\13\2\u00e8#\3\2\2\2\u00e9\u00ea\5&\24\2\u00ea%\3\2\2\2\u00eb"+
		"\u00ec\7\31\2\2\u00ec\u00ed\7%\2\2\u00ed\u00ee\5 \21\2\u00ee\u00f1\7&"+
		"\2\2\u00ef\u00f2\5\16\b\2\u00f0\u00f2\5\f\7\2\u00f1\u00ef\3\2\2\2\u00f1"+
		"\u00f0\3\2\2\2\u00f2\u00fd\3\2\2\2\u00f3\u00f4\7\32\2\2\u00f4\u00f5\7"+
		"%\2\2\u00f5\u00f6\5 \21\2\u00f6\u00f9\7&\2\2\u00f7\u00fa\5\16\b\2\u00f8"+
		"\u00fa\5\f\7\2\u00f9\u00f7\3\2\2\2\u00f9\u00f8\3\2\2\2\u00fa\u00fc\3\2"+
		"\2\2\u00fb\u00f3\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\u0105\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0103\7\33"+
		"\2\2\u0101\u0104\5\16\b\2\u0102\u0104\5\f\7\2\u0103\u0101\3\2\2\2\u0103"+
		"\u0102\3\2\2\2\u0104\u0106\3\2\2\2\u0105\u0100\3\2\2\2\u0105\u0106\3\2"+
		"\2\2\u0106\'\3\2\2\2\u0107\u0108\7=\2\2\u0108)\3\2\2\2\u0109\u010a\7\25"+
		"\2\2\u010a\u010d\5f\64\2\u010b\u010c\t\2\2\2\u010c\u010e\5\\/\2\u010d"+
		"\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\5\20"+
		"\t\2\u0110+\3\2\2\2\u0111\u0112\5\\/\2\u0112\u0113\5`\61\2\u0113\u0114"+
		"\7,\2\2\u0114\u0118\7%\2\2\u0115\u0117\5.\30\2\u0116\u0115\3\2\2\2\u0117"+
		"\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011b\3\2"+
		"\2\2\u011a\u0118\3\2\2\2\u011b\u011c\7&\2\2\u011c-\3\2\2\2\u011d\u011e"+
		"\5\60\31\2\u011e\u011f\7(\2\2\u011f\u0120\5.\30\2\u0120\u0123\3\2\2\2"+
		"\u0121\u0123\5\60\31\2\u0122\u011d\3\2\2\2\u0122\u0121\3\2\2\2\u0123/"+
		"\3\2\2\2\u0124\u0129\5d\63\2\u0125\u0129\5P)\2\u0126\u0129\5B\"\2\u0127"+
		"\u0129\5\64\33\2\u0128\u0124\3\2\2\2\u0128\u0125\3\2\2\2\u0128\u0126\3"+
		"\2\2\2\u0128\u0127\3\2\2\2\u0129\61\3\2\2\2\u012a\u012b\5`\61\2\u012b"+
		"\u012c\7\'\2\2\u012c\u012d\5b\62\2\u012d\u0136\7,\2\2\u012e\u0130\5.\30"+
		"\2\u012f\u012e\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0137\3\2\2\2\u0131\u0133"+
		"\7%\2\2\u0132\u0134\5.\30\2\u0133\u0132\3\2\2\2\u0133\u0134\3\2\2\2\u0134"+
		"\u0135\3\2\2\2\u0135\u0137\7&\2\2\u0136\u012f\3\2\2\2\u0136\u0131\3\2"+
		"\2\2\u0137\u0142\3\2\2\2\u0138\u0139\5`\61\2\u0139\u013a\7\'\2\2\u013a"+
		"\u013b\5b\62\2\u013b\u013d\7%\2\2\u013c\u013e\5.\30\2\u013d\u013c\3\2"+
		"\2\2\u013d\u013e\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0140\7&\2\2\u0140"+
		"\u0142\3\2\2\2\u0141\u012a\3\2\2\2\u0141\u0138\3\2\2\2\u0142\63\3\2\2"+
		"\2\u0143\u0144\5\\/\2\u0144\u0145\7\'\2\2\u0145\u0146\5d\63\2\u0146\65"+
		"\3\2\2\2\u0147\u0148\5Z.\2\u0148\u0149\5b\62\2\u0149\u014b\7%\2\2\u014a"+
		"\u014c\58\35\2\u014b\u014a\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014d\3\2"+
		"\2\2\u014d\u014e\7&\2\2\u014e\u014f\5\16\b\2\u014f\u015a\3\2\2\2\u0150"+
		"\u0151\7\t\2\2\u0151\u0152\5b\62\2\u0152\u0154\7%\2\2\u0153\u0155\58\35"+
		"\2\u0154\u0153\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0157"+
		"\7&\2\2\u0157\u0158\5\16\b\2\u0158\u015a\3\2\2\2\u0159\u0147\3\2\2\2\u0159"+
		"\u0150\3\2\2\2\u015a\67\3\2\2\2\u015b\u015c\5:\36\2\u015c\u015d\7(\2\2"+
		"\u015d\u015e\58\35\2\u015e\u0161\3\2\2\2\u015f\u0161\5:\36\2\u0160\u015b"+
		"\3\2\2\2\u0160\u015f\3\2\2\2\u01619\3\2\2\2\u0162\u0163\5^\60\2\u0163"+
		"\u0164\5d\63\2\u0164;\3\2\2\2\u0165\u0166\5^\60\2\u0166\u016b\5> \2\u0167"+
		"\u0168\7(\2\2\u0168\u016a\5> \2\u0169\u0167\3\2\2\2\u016a\u016d\3\2\2"+
		"\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c=\3\2\2\2\u016d\u016b"+
		"\3\2\2\2\u016e\u0171\5d\63\2\u016f\u0171\5\22\n\2\u0170\u016e\3\2\2\2"+
		"\u0170\u016f\3\2\2\2\u0171?\3\2\2\2\u0172\u0173\5B\"\2\u0173\u0174\5@"+
		"!\2\u0174\u0177\3\2\2\2\u0175\u0177\5B\"\2\u0176\u0172\3\2\2\2\u0176\u0175"+
		"\3\2\2\2\u0177A\3\2\2\2\u0178\u0179\5D#\2\u0179\u017f\5T+\2\u017a\u0180"+
		"\5D#\2\u017b\u017c\7%\2\2\u017c\u017d\5@!\2\u017d\u017e\7&\2\2\u017e\u0180"+
		"\3\2\2\2\u017f\u017a\3\2\2\2\u017f\u017b\3\2\2\2\u0180\u018e\3\2\2\2\u0181"+
		"\u0187\5T+\2\u0182\u0188\5D#\2\u0183\u0184\7%\2\2\u0184\u0185\5B\"\2\u0185"+
		"\u0186\7&\2\2\u0186\u0188\3\2\2\2\u0187\u0182\3\2\2\2\u0187\u0183\3\2"+
		"\2\2\u0188\u018e\3\2\2\2\u0189\u018a\7%\2\2\u018a\u018b\5@!\2\u018b\u018c"+
		"\7&\2\2\u018c\u018e\3\2\2\2\u018d\u0178\3\2\2\2\u018d\u0181\3\2\2\2\u018d"+
		"\u0189\3\2\2\2\u018eC\3\2\2\2\u018f\u0194\5P)\2\u0190\u0194\5F$\2\u0191"+
		"\u0194\5d\63\2\u0192\u0194\7;\2\2\u0193\u018f\3\2\2\2\u0193\u0190\3\2"+
		"\2\2\u0193\u0191\3\2\2\2\u0193\u0192\3\2\2\2\u0194E\3\2\2\2\u0195\u0196"+
		"\5X-\2\u0196\u0199\7%\2\2\u0197\u019a\5D#\2\u0198\u019a\5@!\2\u0199\u0197"+
		"\3\2\2\2\u0199\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019c\7&\2\2\u019c"+
		"G\3\2\2\2\u019d\u019e\5J&\2\u019eI\3\2\2\2\u019f\u01a0\7\34\2\2\u01a0"+
		"\u01a1\7%\2\2\u01a1\u01a2\7\36\2\2\u01a2\u01a3\7\35\2\2\u01a3\u01a4\7"+
		"\36\2\2\u01a4\u01a7\7&\2\2\u01a5\u01a8\5\16\b\2\u01a6\u01a8\5\f\7\2\u01a7"+
		"\u01a5\3\2\2\2\u01a7\u01a6\3\2\2\2\u01a8K\3\2\2\2\u01a9\u01aa\5N(\2\u01aa"+
		"\u01ab\5L\'\2\u01ab\u01ae\3\2\2\2\u01ac\u01ae\5N(\2\u01ad\u01a9\3\2\2"+
		"\2\u01ad\u01ac\3\2\2\2\u01aeM\3\2\2\2\u01af\u01b2\7\"\2\2\u01b0\u01b2"+
		"\5d\63\2\u01b1\u01af\3\2\2\2\u01b1\u01b0\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3"+
		"\u01ba\5V,\2\u01b4\u01bb\7\"\2\2\u01b5\u01bb\5d\63\2\u01b6\u01b7\7%\2"+
		"\2\u01b7\u01b8\5N(\2\u01b8\u01b9\7&\2\2\u01b9\u01bb\3\2\2\2\u01ba\u01b4"+
		"\3\2\2\2\u01ba\u01b5\3\2\2\2\u01ba\u01b6\3\2\2\2\u01bb\u01ca\3\2\2\2\u01bc"+
		"\u01c3\5V,\2\u01bd\u01c4\7\"\2\2\u01be\u01c4\5d\63\2\u01bf\u01c0\7%\2"+
		"\2\u01c0\u01c1\5N(\2\u01c1\u01c2\7&\2\2\u01c2\u01c4\3\2\2\2\u01c3\u01bd"+
		"\3\2\2\2\u01c3\u01be\3\2\2\2\u01c3\u01bf\3\2\2\2\u01c4\u01ca\3\2\2\2\u01c5"+
		"\u01c6\7%\2\2\u01c6\u01c7\5N(\2\u01c7\u01c8\7&\2\2\u01c8\u01ca\3\2\2\2"+
		"\u01c9\u01b1\3\2\2\2\u01c9\u01bc\3\2\2\2\u01c9\u01c5\3\2\2\2\u01caO\3"+
		"\2\2\2\u01cb\u01cf\5R*\2\u01cc\u01cf\7 \2\2\u01cd\u01cf\7!\2\2\u01ce\u01cb"+
		"\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cd\3\2\2\2\u01cfQ\3\2\2\2\u01d0"+
		"\u01d1\t\3\2\2\u01d1S\3\2\2\2\u01d2\u01d3\t\4\2\2\u01d3U\3\2\2\2\u01d4"+
		"\u01d5\t\5\2\2\u01d5W\3\2\2\2\u01d6\u01d7\t\6\2\2\u01d7Y\3\2\2\2\u01d8"+
		"\u01d9\5^\60\2\u01d9[\3\2\2\2\u01da\u01db\t\7\2\2\u01db]\3\2\2\2\u01dc"+
		"\u01dd\t\b\2\2\u01dd_\3\2\2\2\u01de\u01df\7<\2\2\u01dfa\3\2\2\2\u01e0"+
		"\u01e1\7<\2\2\u01e1c\3\2\2\2\u01e2\u01e3\7<\2\2\u01e3e\3\2\2\2\u01e4\u01e5"+
		"\7<\2\2\u01e5g\3\2\2\2\62ln{\177\u0085\u0096\u0099\u009e\u00a0\u00a9\u00ab"+
		"\u00bb\u00c0\u00c5\u00e1\u00f1\u00f9\u00fd\u0103\u0105\u010d\u0118\u0122"+
		"\u0128\u012f\u0133\u0136\u013d\u0141\u014b\u0154\u0159\u0160\u016b\u0170"+
		"\u0176\u017f\u0187\u018d\u0193\u0199\u01a7\u01ad\u01b1\u01ba\u01c3\u01c9"+
		"\u01ce";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}