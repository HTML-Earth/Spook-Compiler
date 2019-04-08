// Generated from C:/Programming/P4/src\SpookParser.g4 by ANTLR 4.7.2
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
		IF=23, ELSE=24, DIGIT=25, FLOAT_DIGIT=26, BOOL_LITERAL=27, LEFT_BRACKET=28, 
		RIGHT_BRACKET=29, LEFT_PAREN=30, RIGHT_PAREN=31, DOT=32, COMMA=33, SEMICOLON=34, 
		ASSIGN=35, ADD=36, SUB=37, MOD=38, DIV=39, MUL=40, EQUAL=41, AND=42, OR=43, 
		NOT_EQUAL=44, NOT=45, ABS=46, SIN=47, COS=48, TAN=49, UNIFORM=50, ID=51, 
		COMMENT_STRING=52, WS=53;
	public static final int
		RULE_program = 0, RULE_main = 1, RULE_declarations = 2, RULE_declaration = 3, 
		RULE_comment = 4, RULE_classDecl = 5, RULE_objectDecl = 6, RULE_objectArgs = 7, 
		RULE_objectArg = 8, RULE_objectFunctionCall = 9, RULE_colorFunctionCall = 10, 
		RULE_functionDecl = 11, RULE_numberDecl = 12, RULE_integerDecl = 13, RULE_floatDecl = 14, 
		RULE_arithOperations = 15, RULE_arithOperation = 16, RULE_mathFunction = 17, 
		RULE_vector2Decl = 18, RULE_vector3Decl = 19, RULE_vector4Decl = 20, RULE_boolDecl = 21, 
		RULE_boolOperations = 22, RULE_boolOperation = 23, RULE_realNumber = 24, 
		RULE_colorFunction = 25, RULE_operator = 26, RULE_boolOperator = 27, RULE_function = 28, 
		RULE_returnType = 29, RULE_classType = 30, RULE_dataType = 31, RULE_objectVariable = 32, 
		RULE_functionName = 33;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main", "declarations", "declaration", "comment", "classDecl", 
			"objectDecl", "objectArgs", "objectArg", "objectFunctionCall", "colorFunctionCall", 
			"functionDecl", "numberDecl", "integerDecl", "floatDecl", "arithOperations", 
			"arithOperation", "mathFunction", "vector2Decl", "vector3Decl", "vector4Decl", 
			"boolDecl", "boolOperations", "boolOperation", "realNumber", "colorFunction", 
			"operator", "boolOperator", "function", "returnType", "classType", "dataType", 
			"objectVariable", "functionName"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'float'", "'bool'", "'vector2'", "'vector3'", "'vector4'", 
			"'void'", "'Circle'", "'Rectangle'", "'Triangle'", "'Shape'", "'Color'", 
			"'Black'", "'White'", "'Red'", "'Green'", "'Blue'", "'Shader'", "'class'", 
			"'extends'", "'implements'", "'return'", "'if'", "'else'", null, null, 
			null, "'{'", "'}'", "'('", "')'", "'.'", "','", "';'", "'='", "'+'", 
			"'-'", "'%'", "'/'", "'*'", "'=='", "'&&'", "'||'", "'!='", "'!'", "'abs('", 
			"'sin('", "'cos('", "'tan('", "'Time'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "FLOAT", "BOOL", "VECTOR2", "VECTOR3", "VECTOR4", "VOID", 
			"CIRCLE", "RECTANGLE", "TRIANGLE", "SHAPE", "COLOR", "BLACK", "WHITE", 
			"RED", "GREEN", "BLUE", "MAIN", "CLASS", "EXTENDS", "IMPLEMENTS", "RETURN", 
			"IF", "ELSE", "DIGIT", "FLOAT_DIGIT", "BOOL_LITERAL", "LEFT_BRACKET", 
			"RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", "DOT", "COMMA", "SEMICOLON", 
			"ASSIGN", "ADD", "SUB", "MOD", "DIV", "MUL", "EQUAL", "AND", "OR", "NOT_EQUAL", 
			"NOT", "ABS", "SIN", "COS", "TAN", "UNIFORM", "ID", "COMMENT_STRING", 
			"WS"
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
			setState(68);
			main();
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << VECTOR2) | (1L << VECTOR3) | (1L << VECTOR4) | (1L << VOID) | (1L << CLASS) | (1L << COMMENT_STRING))) != 0)) {
				{
				setState(72);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case COMMENT_STRING:
					{
					setState(69);
					comment();
					}
					break;
				case CLASS:
					{
					setState(70);
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
					setState(71);
					functionDecl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(76);
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
		public TerminalNode LEFT_BRACKET() { return getToken(SpookParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(SpookParser.RIGHT_BRACKET, 0); }
		public List<DeclarationsContext> declarations() {
			return getRuleContexts(DeclarationsContext.class);
		}
		public DeclarationsContext declarations(int i) {
			return getRuleContext(DeclarationsContext.class,i);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(MAIN);
			setState(78);
			match(LEFT_BRACKET);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << VECTOR2) | (1L << VECTOR3) | (1L << VECTOR4) | (1L << CIRCLE) | (1L << RECTANGLE) | (1L << TRIANGLE) | (1L << SHAPE) | (1L << COLOR) | (1L << ID) | (1L << COMMENT_STRING))) != 0)) {
				{
				setState(81);
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
				case ID:
					{
					setState(79);
					declarations();
					}
					break;
				case COMMENT_STRING:
					{
					setState(80);
					comment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(86);
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

	public static class DeclarationsContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
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
			setState(92);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				declaration();
				setState(89);
				declarations();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				declaration();
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
		public TerminalNode SEMICOLON() { return getToken(SpookParser.SEMICOLON, 0); }
		public NumberDeclContext numberDecl() {
			return getRuleContext(NumberDeclContext.class,0);
		}
		public BoolDeclContext boolDecl() {
			return getRuleContext(BoolDeclContext.class,0);
		}
		public ObjectDeclContext objectDecl() {
			return getRuleContext(ObjectDeclContext.class,0);
		}
		public ObjectFunctionCallContext objectFunctionCall() {
			return getRuleContext(ObjectFunctionCallContext.class,0);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case VECTOR2:
			case VECTOR3:
			case VECTOR4:
				{
				setState(94);
				numberDecl();
				}
				break;
			case BOOL:
				{
				setState(95);
				boolDecl();
				}
				break;
			case CIRCLE:
			case RECTANGLE:
			case TRIANGLE:
			case SHAPE:
			case COLOR:
				{
				setState(96);
				objectDecl();
				}
				break;
			case ID:
				{
				setState(97);
				objectFunctionCall();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(100);
			match(SEMICOLON);
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
		enterRule(_localctx, 8, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
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
		public TerminalNode ID() { return getToken(SpookParser.ID, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(SpookParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(SpookParser.RIGHT_BRACKET, 0); }
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
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
		enterRule(_localctx, 10, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(CLASS);
			setState(105);
			match(ID);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS || _la==IMPLEMENTS) {
				{
				setState(106);
				_la = _input.LA(1);
				if ( !(_la==EXTENDS || _la==IMPLEMENTS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(107);
				classType();
				}
			}

			setState(110);
			match(LEFT_BRACKET);
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(111);
				declarations();
				}
				break;
			}
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << VECTOR2) | (1L << VECTOR3) | (1L << VECTOR4) | (1L << VOID))) != 0)) {
				{
				{
				setState(114);
				functionDecl();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(120);
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

	public static class ObjectDeclContext extends ParserRuleContext {
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SpookParser.ID, 0); }
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
		enterRule(_localctx, 12, RULE_objectDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			classType();
			setState(123);
			match(ID);
			setState(124);
			match(ASSIGN);
			setState(125);
			match(LEFT_PAREN);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COLOR) | (1L << DIGIT) | (1L << FLOAT_DIGIT) | (1L << LEFT_PAREN) | (1L << ADD) | (1L << SUB) | (1L << MOD) | (1L << DIV) | (1L << MUL) | (1L << ABS) | (1L << SIN) | (1L << COS) | (1L << TAN) | (1L << ID))) != 0)) {
				{
				{
				setState(126);
				objectArgs();
				}
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(132);
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
		enterRule(_localctx, 14, RULE_objectArgs);
		try {
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				objectArg();
				setState(135);
				match(COMMA);
				setState(136);
				objectArgs();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
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
		public TerminalNode ID() { return getToken(SpookParser.ID, 0); }
		public RealNumberContext realNumber() {
			return getRuleContext(RealNumberContext.class,0);
		}
		public ArithOperationContext arithOperation() {
			return getRuleContext(ArithOperationContext.class,0);
		}
		public ColorFunctionCallContext colorFunctionCall() {
			return getRuleContext(ColorFunctionCallContext.class,0);
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
		enterRule(_localctx, 16, RULE_objectArg);
		try {
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				realNumber();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(143);
				arithOperation();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(144);
				colorFunctionCall();
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
		public ObjectVariableContext objectVariable() {
			return getRuleContext(ObjectVariableContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SpookParser.DOT, 0); }
		public FunctionNameContext functionName() {
			return getRuleContext(FunctionNameContext.class,0);
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
		public ObjectArgContext objectArg() {
			return getRuleContext(ObjectArgContext.class,0);
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
		enterRule(_localctx, 18, RULE_objectFunctionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(147);
				objectVariable();
				setState(148);
				match(DOT);
				setState(149);
				functionName();
				setState(150);
				match(ASSIGN);
				setState(162);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(152);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COLOR) | (1L << DIGIT) | (1L << FLOAT_DIGIT) | (1L << LEFT_PAREN) | (1L << ADD) | (1L << SUB) | (1L << MOD) | (1L << DIV) | (1L << MUL) | (1L << ABS) | (1L << SIN) | (1L << COS) | (1L << TAN) | (1L << ID))) != 0)) {
						{
						setState(151);
						objectArg();
						}
					}

					}
					break;
				case 2:
					{
					setState(154);
					match(LEFT_PAREN);
					setState(158);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COLOR) | (1L << DIGIT) | (1L << FLOAT_DIGIT) | (1L << LEFT_PAREN) | (1L << ADD) | (1L << SUB) | (1L << MOD) | (1L << DIV) | (1L << MUL) | (1L << ABS) | (1L << SIN) | (1L << COS) | (1L << TAN) | (1L << ID))) != 0)) {
						{
						{
						setState(155);
						objectArgs();
						}
						}
						setState(160);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(161);
					match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			case 2:
				{
				setState(164);
				objectVariable();
				setState(165);
				match(DOT);
				setState(166);
				functionName();
				setState(167);
				match(LEFT_PAREN);
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COLOR) | (1L << DIGIT) | (1L << FLOAT_DIGIT) | (1L << LEFT_PAREN) | (1L << ADD) | (1L << SUB) | (1L << MOD) | (1L << DIV) | (1L << MUL) | (1L << ABS) | (1L << SIN) | (1L << COS) | (1L << TAN) | (1L << ID))) != 0)) {
					{
					{
					setState(168);
					objectArgs();
					}
					}
					setState(173);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(174);
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

	public static class ColorFunctionCallContext extends ParserRuleContext {
		public TerminalNode COLOR() { return getToken(SpookParser.COLOR, 0); }
		public TerminalNode DOT() { return getToken(SpookParser.DOT, 0); }
		public ColorFunctionContext colorFunction() {
			return getRuleContext(ColorFunctionContext.class,0);
		}
		public ColorFunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colorFunctionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterColorFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitColorFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitColorFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColorFunctionCallContext colorFunctionCall() throws RecognitionException {
		ColorFunctionCallContext _localctx = new ColorFunctionCallContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_colorFunctionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(COLOR);
			setState(179);
			match(DOT);
			setState(180);
			colorFunction();
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
		public List<TerminalNode> ID() { return getTokens(SpookParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SpookParser.ID, i);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SpookParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(SpookParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(SpookParser.RIGHT_BRACKET, 0); }
		public List<DataTypeContext> dataType() {
			return getRuleContexts(DataTypeContext.class);
		}
		public DataTypeContext dataType(int i) {
			return getRuleContext(DataTypeContext.class,i);
		}
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
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
		enterRule(_localctx, 22, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			returnType();
			setState(183);
			match(ID);
			setState(184);
			match(LEFT_PAREN);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << VECTOR2) | (1L << VECTOR3) | (1L << VECTOR4))) != 0)) {
				{
				{
				setState(185);
				dataType();
				setState(186);
				match(ID);
				}
				}
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(193);
			match(RIGHT_PAREN);
			setState(194);
			match(LEFT_BRACKET);
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << VECTOR2) | (1L << VECTOR3) | (1L << VECTOR4) | (1L << CIRCLE) | (1L << RECTANGLE) | (1L << TRIANGLE) | (1L << SHAPE) | (1L << COLOR) | (1L << ID))) != 0)) {
				{
				setState(195);
				declarations();
				}
			}

			setState(198);
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

	public static class NumberDeclContext extends ParserRuleContext {
		public IntegerDeclContext integerDecl() {
			return getRuleContext(IntegerDeclContext.class,0);
		}
		public FloatDeclContext floatDecl() {
			return getRuleContext(FloatDeclContext.class,0);
		}
		public Vector2DeclContext vector2Decl() {
			return getRuleContext(Vector2DeclContext.class,0);
		}
		public Vector3DeclContext vector3Decl() {
			return getRuleContext(Vector3DeclContext.class,0);
		}
		public Vector4DeclContext vector4Decl() {
			return getRuleContext(Vector4DeclContext.class,0);
		}
		public NumberDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterNumberDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitNumberDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitNumberDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberDeclContext numberDecl() throws RecognitionException {
		NumberDeclContext _localctx = new NumberDeclContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_numberDecl);
		try {
			setState(205);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				integerDecl();
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				floatDecl();
				}
				break;
			case VECTOR2:
				enterOuterAlt(_localctx, 3);
				{
				setState(202);
				vector2Decl();
				}
				break;
			case VECTOR3:
				enterOuterAlt(_localctx, 4);
				{
				setState(203);
				vector3Decl();
				}
				break;
			case VECTOR4:
				enterOuterAlt(_localctx, 5);
				{
				setState(204);
				vector4Decl();
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

	public static class IntegerDeclContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(SpookParser.INT, 0); }
		public TerminalNode ID() { return getToken(SpookParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(SpookParser.ASSIGN, 0); }
		public ArithOperationsContext arithOperations() {
			return getRuleContext(ArithOperationsContext.class,0);
		}
		public MathFunctionContext mathFunction() {
			return getRuleContext(MathFunctionContext.class,0);
		}
		public TerminalNode DIGIT() { return getToken(SpookParser.DIGIT, 0); }
		public IntegerDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterIntegerDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitIntegerDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitIntegerDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerDeclContext integerDecl() throws RecognitionException {
		IntegerDeclContext _localctx = new IntegerDeclContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_integerDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(INT);
			setState(208);
			match(ID);
			setState(209);
			match(ASSIGN);
			setState(213);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(210);
				arithOperations();
				}
				break;
			case 2:
				{
				setState(211);
				mathFunction();
				}
				break;
			case 3:
				{
				setState(212);
				match(DIGIT);
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

	public static class FloatDeclContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(SpookParser.FLOAT, 0); }
		public TerminalNode ID() { return getToken(SpookParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(SpookParser.ASSIGN, 0); }
		public ArithOperationsContext arithOperations() {
			return getRuleContext(ArithOperationsContext.class,0);
		}
		public MathFunctionContext mathFunction() {
			return getRuleContext(MathFunctionContext.class,0);
		}
		public RealNumberContext realNumber() {
			return getRuleContext(RealNumberContext.class,0);
		}
		public FloatDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterFloatDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitFloatDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitFloatDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FloatDeclContext floatDecl() throws RecognitionException {
		FloatDeclContext _localctx = new FloatDeclContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_floatDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(FLOAT);
			setState(216);
			match(ID);
			setState(217);
			match(ASSIGN);
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(218);
				arithOperations();
				}
				break;
			case 2:
				{
				setState(219);
				mathFunction();
				}
				break;
			case 3:
				{
				setState(220);
				realNumber();
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
		enterRule(_localctx, 30, RULE_arithOperations);
		try {
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(223);
				arithOperation();
				setState(224);
				arithOperations();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
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
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public List<RealNumberContext> realNumber() {
			return getRuleContexts(RealNumberContext.class);
		}
		public RealNumberContext realNumber(int i) {
			return getRuleContext(RealNumberContext.class,i);
		}
		public List<MathFunctionContext> mathFunction() {
			return getRuleContexts(MathFunctionContext.class);
		}
		public MathFunctionContext mathFunction(int i) {
			return getRuleContext(MathFunctionContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(SpookParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SpookParser.ID, i);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SpookParser.LEFT_PAREN, 0); }
		public ArithOperationContext arithOperation() {
			return getRuleContext(ArithOperationContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
		public ArithOperationsContext arithOperations() {
			return getRuleContext(ArithOperationsContext.class,0);
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
		enterRule(_localctx, 32, RULE_arithOperation);
		try {
			setState(258);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIGIT:
			case FLOAT_DIGIT:
			case ABS:
			case SIN:
			case COS:
			case TAN:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DIGIT:
				case FLOAT_DIGIT:
					{
					setState(229);
					realNumber();
					}
					break;
				case ABS:
				case SIN:
				case COS:
				case TAN:
					{
					setState(230);
					mathFunction();
					}
					break;
				case ID:
					{
					setState(231);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(234);
				operator();
				setState(242);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DIGIT:
				case FLOAT_DIGIT:
					{
					setState(235);
					realNumber();
					}
					break;
				case ABS:
				case SIN:
				case COS:
				case TAN:
					{
					setState(236);
					mathFunction();
					}
					break;
				case ID:
					{
					setState(237);
					match(ID);
					}
					break;
				case LEFT_PAREN:
					{
					setState(238);
					match(LEFT_PAREN);
					setState(239);
					arithOperation();
					setState(240);
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
				setState(244);
				operator();
				setState(252);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DIGIT:
				case FLOAT_DIGIT:
					{
					setState(245);
					realNumber();
					}
					break;
				case ABS:
				case SIN:
				case COS:
				case TAN:
					{
					setState(246);
					mathFunction();
					}
					break;
				case ID:
					{
					setState(247);
					match(ID);
					}
					break;
				case LEFT_PAREN:
					{
					setState(248);
					match(LEFT_PAREN);
					setState(249);
					arithOperation();
					setState(250);
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
				setState(254);
				match(LEFT_PAREN);
				setState(255);
				arithOperations();
				setState(256);
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
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
		public TerminalNode ID() { return getToken(SpookParser.ID, 0); }
		public RealNumberContext realNumber() {
			return getRuleContext(RealNumberContext.class,0);
		}
		public MathFunctionContext mathFunction() {
			return getRuleContext(MathFunctionContext.class,0);
		}
		public TerminalNode UNIFORM() { return getToken(SpookParser.UNIFORM, 0); }
		public List<ArithOperationContext> arithOperation() {
			return getRuleContexts(ArithOperationContext.class);
		}
		public ArithOperationContext arithOperation(int i) {
			return getRuleContext(ArithOperationContext.class,i);
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
		enterRule(_localctx, 34, RULE_mathFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			function();
			setState(265);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(261);
				match(ID);
				}
				break;
			case DIGIT:
			case FLOAT_DIGIT:
				{
				setState(262);
				realNumber();
				}
				break;
			case ABS:
			case SIN:
			case COS:
			case TAN:
				{
				setState(263);
				mathFunction();
				}
				break;
			case UNIFORM:
				{
				setState(264);
				match(UNIFORM);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIGIT) | (1L << FLOAT_DIGIT) | (1L << LEFT_PAREN) | (1L << ADD) | (1L << SUB) | (1L << MOD) | (1L << DIV) | (1L << MUL) | (1L << ABS) | (1L << SIN) | (1L << COS) | (1L << TAN) | (1L << ID))) != 0)) {
				{
				{
				setState(267);
				arithOperation();
				}
				}
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(273);
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

	public static class Vector2DeclContext extends ParserRuleContext {
		public TerminalNode VECTOR2() { return getToken(SpookParser.VECTOR2, 0); }
		public TerminalNode ID() { return getToken(SpookParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(SpookParser.ASSIGN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SpookParser.LEFT_PAREN, 0); }
		public List<RealNumberContext> realNumber() {
			return getRuleContexts(RealNumberContext.class);
		}
		public RealNumberContext realNumber(int i) {
			return getRuleContext(RealNumberContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(SpookParser.COMMA, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
		public Vector2DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector2Decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterVector2Decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitVector2Decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitVector2Decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Vector2DeclContext vector2Decl() throws RecognitionException {
		Vector2DeclContext _localctx = new Vector2DeclContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_vector2Decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(VECTOR2);
			setState(276);
			match(ID);
			setState(277);
			match(ASSIGN);
			setState(278);
			match(LEFT_PAREN);
			setState(279);
			realNumber();
			setState(280);
			match(COMMA);
			setState(281);
			realNumber();
			setState(282);
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

	public static class Vector3DeclContext extends ParserRuleContext {
		public TerminalNode VECTOR3() { return getToken(SpookParser.VECTOR3, 0); }
		public TerminalNode ID() { return getToken(SpookParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(SpookParser.ASSIGN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SpookParser.LEFT_PAREN, 0); }
		public List<RealNumberContext> realNumber() {
			return getRuleContexts(RealNumberContext.class);
		}
		public RealNumberContext realNumber(int i) {
			return getRuleContext(RealNumberContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SpookParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SpookParser.COMMA, i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
		public Vector3DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector3Decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterVector3Decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitVector3Decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitVector3Decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Vector3DeclContext vector3Decl() throws RecognitionException {
		Vector3DeclContext _localctx = new Vector3DeclContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_vector3Decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(VECTOR3);
			setState(285);
			match(ID);
			setState(286);
			match(ASSIGN);
			setState(287);
			match(LEFT_PAREN);
			setState(288);
			realNumber();
			setState(289);
			match(COMMA);
			setState(290);
			realNumber();
			setState(291);
			match(COMMA);
			setState(292);
			realNumber();
			setState(293);
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

	public static class Vector4DeclContext extends ParserRuleContext {
		public TerminalNode VECTOR4() { return getToken(SpookParser.VECTOR4, 0); }
		public TerminalNode ID() { return getToken(SpookParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(SpookParser.ASSIGN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SpookParser.LEFT_PAREN, 0); }
		public List<RealNumberContext> realNumber() {
			return getRuleContexts(RealNumberContext.class);
		}
		public RealNumberContext realNumber(int i) {
			return getRuleContext(RealNumberContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SpookParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SpookParser.COMMA, i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
		public Vector4DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector4Decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterVector4Decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitVector4Decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitVector4Decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Vector4DeclContext vector4Decl() throws RecognitionException {
		Vector4DeclContext _localctx = new Vector4DeclContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_vector4Decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			match(VECTOR4);
			setState(296);
			match(ID);
			setState(297);
			match(ASSIGN);
			setState(298);
			match(LEFT_PAREN);
			setState(299);
			realNumber();
			setState(300);
			match(COMMA);
			setState(301);
			realNumber();
			setState(302);
			match(COMMA);
			setState(303);
			realNumber();
			setState(304);
			match(COMMA);
			setState(305);
			realNumber();
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

	public static class BoolDeclContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(SpookParser.BOOL, 0); }
		public TerminalNode ID() { return getToken(SpookParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(SpookParser.ASSIGN, 0); }
		public BoolOperationsContext boolOperations() {
			return getRuleContext(BoolOperationsContext.class,0);
		}
		public TerminalNode BOOL_LITERAL() { return getToken(SpookParser.BOOL_LITERAL, 0); }
		public BoolDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterBoolDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitBoolDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitBoolDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolDeclContext boolDecl() throws RecognitionException {
		BoolDeclContext _localctx = new BoolDeclContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_boolDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(BOOL);
			setState(309);
			match(ID);
			setState(310);
			match(ASSIGN);
			setState(313);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(311);
				boolOperations();
				}
				break;
			case 2:
				{
				setState(312);
				match(BOOL_LITERAL);
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
		enterRule(_localctx, 44, RULE_boolOperations);
		try {
			setState(319);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(315);
				boolOperation();
				setState(316);
				boolOperations();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(318);
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
		public List<TerminalNode> ID() { return getTokens(SpookParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SpookParser.ID, i);
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
		enterRule(_localctx, 46, RULE_boolOperation);
		int _la;
		try {
			setState(344);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL_LITERAL:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(321);
				_la = _input.LA(1);
				if ( !(_la==BOOL_LITERAL || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(322);
				boolOperator();
				setState(329);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL_LITERAL:
					{
					setState(323);
					match(BOOL_LITERAL);
					}
					break;
				case ID:
					{
					setState(324);
					match(ID);
					}
					break;
				case LEFT_PAREN:
					{
					{
					setState(325);
					match(LEFT_PAREN);
					setState(326);
					boolOperation();
					setState(327);
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
				setState(331);
				boolOperator();
				setState(338);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL_LITERAL:
					{
					setState(332);
					match(BOOL_LITERAL);
					}
					break;
				case ID:
					{
					setState(333);
					match(ID);
					}
					break;
				case LEFT_PAREN:
					{
					{
					setState(334);
					match(LEFT_PAREN);
					setState(335);
					boolOperation();
					setState(336);
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
				setState(340);
				match(LEFT_PAREN);
				setState(341);
				boolOperation();
				setState(342);
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
		public TerminalNode DIGIT() { return getToken(SpookParser.DIGIT, 0); }
		public TerminalNode FLOAT_DIGIT() { return getToken(SpookParser.FLOAT_DIGIT, 0); }
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
		enterRule(_localctx, 48, RULE_realNumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			_la = _input.LA(1);
			if ( !(_la==DIGIT || _la==FLOAT_DIGIT) ) {
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

	public static class ColorFunctionContext extends ParserRuleContext {
		public TerminalNode BLACK() { return getToken(SpookParser.BLACK, 0); }
		public TerminalNode WHITE() { return getToken(SpookParser.WHITE, 0); }
		public TerminalNode RED() { return getToken(SpookParser.RED, 0); }
		public TerminalNode GREEN() { return getToken(SpookParser.GREEN, 0); }
		public TerminalNode BLUE() { return getToken(SpookParser.BLUE, 0); }
		public ColorFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colorFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterColorFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitColorFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitColorFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColorFunctionContext colorFunction() throws RecognitionException {
		ColorFunctionContext _localctx = new ColorFunctionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_colorFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
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
		enterRule(_localctx, 52, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
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
		enterRule(_localctx, 54, RULE_boolOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
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
		enterRule(_localctx, 56, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
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
		public TerminalNode VOID() { return getToken(SpookParser.VOID, 0); }
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
		enterRule(_localctx, 58, RULE_returnType);
		try {
			setState(358);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(356);
				match(VOID);
				}
				break;
			case INT:
			case FLOAT:
			case BOOL:
			case VECTOR2:
			case VECTOR3:
			case VECTOR4:
				enterOuterAlt(_localctx, 2);
				{
				setState(357);
				dataType();
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
		enterRule(_localctx, 60, RULE_classType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
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
		enterRule(_localctx, 62, RULE_dataType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
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

	public static class ObjectVariableContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SpookParser.ID, 0); }
		public ObjectVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterObjectVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitObjectVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitObjectVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectVariableContext objectVariable() throws RecognitionException {
		ObjectVariableContext _localctx = new ObjectVariableContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_objectVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
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
		enterRule(_localctx, 66, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\67\u0173\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\7\2K\n\2\f\2\16\2N\13\2\3\3\3\3\3\3"+
		"\3\3\7\3T\n\3\f\3\16\3W\13\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4_\n\4\3\5\3\5"+
		"\3\5\3\5\5\5e\n\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\5\7o\n\7\3\7\3\7\5\7"+
		"s\n\7\3\7\7\7v\n\7\f\7\16\7y\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\7\b\u0082"+
		"\n\b\f\b\16\b\u0085\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\5\t\u008e\n\t\3\n"+
		"\3\n\3\n\3\n\5\n\u0094\n\n\3\13\3\13\3\13\3\13\3\13\5\13\u009b\n\13\3"+
		"\13\3\13\7\13\u009f\n\13\f\13\16\13\u00a2\13\13\3\13\5\13\u00a5\n\13\3"+
		"\13\3\13\3\13\3\13\3\13\7\13\u00ac\n\13\f\13\16\13\u00af\13\13\3\13\3"+
		"\13\5\13\u00b3\n\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00bf"+
		"\n\r\f\r\16\r\u00c2\13\r\3\r\3\r\3\r\5\r\u00c7\n\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\5\16\u00d0\n\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00d8"+
		"\n\17\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00e0\n\20\3\21\3\21\3\21\3\21"+
		"\5\21\u00e6\n\21\3\22\3\22\3\22\5\22\u00eb\n\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\5\22\u00f5\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\5\22\u00ff\n\22\3\22\3\22\3\22\3\22\5\22\u0105\n\22\3\23\3\23\3"+
		"\23\3\23\3\23\5\23\u010c\n\23\3\23\7\23\u010f\n\23\f\23\16\23\u0112\13"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\5\27\u013c"+
		"\n\27\3\30\3\30\3\30\3\30\5\30\u0142\n\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\5\31\u014c\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0155"+
		"\n\31\3\31\3\31\3\31\3\31\5\31\u015b\n\31\3\32\3\32\3\33\3\33\3\34\3\34"+
		"\3\35\3\35\3\36\3\36\3\37\3\37\5\37\u0169\n\37\3 \3 \3!\3!\3\"\3\"\3#"+
		"\3#\3#\2\2$\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>@BD\2\13\3\2\26\27\4\2\35\35\65\65\3\2\33\34\3\2\17\23\3\2&*\3\2+"+
		"/\3\2\60\63\3\2\n\16\3\2\3\b\2\u0188\2F\3\2\2\2\4O\3\2\2\2\6^\3\2\2\2"+
		"\bd\3\2\2\2\nh\3\2\2\2\fj\3\2\2\2\16|\3\2\2\2\20\u008d\3\2\2\2\22\u0093"+
		"\3\2\2\2\24\u00b2\3\2\2\2\26\u00b4\3\2\2\2\30\u00b8\3\2\2\2\32\u00cf\3"+
		"\2\2\2\34\u00d1\3\2\2\2\36\u00d9\3\2\2\2 \u00e5\3\2\2\2\"\u0104\3\2\2"+
		"\2$\u0106\3\2\2\2&\u0115\3\2\2\2(\u011e\3\2\2\2*\u0129\3\2\2\2,\u0136"+
		"\3\2\2\2.\u0141\3\2\2\2\60\u015a\3\2\2\2\62\u015c\3\2\2\2\64\u015e\3\2"+
		"\2\2\66\u0160\3\2\2\28\u0162\3\2\2\2:\u0164\3\2\2\2<\u0168\3\2\2\2>\u016a"+
		"\3\2\2\2@\u016c\3\2\2\2B\u016e\3\2\2\2D\u0170\3\2\2\2FL\5\4\3\2GK\5\n"+
		"\6\2HK\5\f\7\2IK\5\30\r\2JG\3\2\2\2JH\3\2\2\2JI\3\2\2\2KN\3\2\2\2LJ\3"+
		"\2\2\2LM\3\2\2\2M\3\3\2\2\2NL\3\2\2\2OP\7\24\2\2PU\7\36\2\2QT\5\6\4\2"+
		"RT\5\n\6\2SQ\3\2\2\2SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2VX\3\2\2\2"+
		"WU\3\2\2\2XY\7\37\2\2Y\5\3\2\2\2Z[\5\b\5\2[\\\5\6\4\2\\_\3\2\2\2]_\5\b"+
		"\5\2^Z\3\2\2\2^]\3\2\2\2_\7\3\2\2\2`e\5\32\16\2ae\5,\27\2be\5\16\b\2c"+
		"e\5\24\13\2d`\3\2\2\2da\3\2\2\2db\3\2\2\2dc\3\2\2\2ef\3\2\2\2fg\7$\2\2"+
		"g\t\3\2\2\2hi\7\66\2\2i\13\3\2\2\2jk\7\25\2\2kn\7\65\2\2lm\t\2\2\2mo\5"+
		"> \2nl\3\2\2\2no\3\2\2\2op\3\2\2\2pr\7\36\2\2qs\5\6\4\2rq\3\2\2\2rs\3"+
		"\2\2\2sw\3\2\2\2tv\5\30\r\2ut\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2xz"+
		"\3\2\2\2yw\3\2\2\2z{\7\37\2\2{\r\3\2\2\2|}\5> \2}~\7\65\2\2~\177\7%\2"+
		"\2\177\u0083\7 \2\2\u0080\u0082\5\20\t\2\u0081\u0080\3\2\2\2\u0082\u0085"+
		"\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0086\u0087\7!\2\2\u0087\17\3\2\2\2\u0088\u0089\5\22\n"+
		"\2\u0089\u008a\7#\2\2\u008a\u008b\5\20\t\2\u008b\u008e\3\2\2\2\u008c\u008e"+
		"\5\22\n\2\u008d\u0088\3\2\2\2\u008d\u008c\3\2\2\2\u008e\21\3\2\2\2\u008f"+
		"\u0094\7\65\2\2\u0090\u0094\5\62\32\2\u0091\u0094\5\"\22\2\u0092\u0094"+
		"\5\26\f\2\u0093\u008f\3\2\2\2\u0093\u0090\3\2\2\2\u0093\u0091\3\2\2\2"+
		"\u0093\u0092\3\2\2\2\u0094\23\3\2\2\2\u0095\u0096\5B\"\2\u0096\u0097\7"+
		"\"\2\2\u0097\u0098\5D#\2\u0098\u00a4\7%\2\2\u0099\u009b\5\22\n\2\u009a"+
		"\u0099\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u00a5\3\2\2\2\u009c\u00a0\7 "+
		"\2\2\u009d\u009f\5\20\t\2\u009e\u009d\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0"+
		"\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2\u00a0\3\2"+
		"\2\2\u00a3\u00a5\7!\2\2\u00a4\u009a\3\2\2\2\u00a4\u009c\3\2\2\2\u00a5"+
		"\u00b3\3\2\2\2\u00a6\u00a7\5B\"\2\u00a7\u00a8\7\"\2\2\u00a8\u00a9\5D#"+
		"\2\u00a9\u00ad\7 \2\2\u00aa\u00ac\5\20\t\2\u00ab\u00aa\3\2\2\2\u00ac\u00af"+
		"\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b0\3\2\2\2\u00af"+
		"\u00ad\3\2\2\2\u00b0\u00b1\7!\2\2\u00b1\u00b3\3\2\2\2\u00b2\u0095\3\2"+
		"\2\2\u00b2\u00a6\3\2\2\2\u00b3\25\3\2\2\2\u00b4\u00b5\7\16\2\2\u00b5\u00b6"+
		"\7\"\2\2\u00b6\u00b7\5\64\33\2\u00b7\27\3\2\2\2\u00b8\u00b9\5<\37\2\u00b9"+
		"\u00ba\7\65\2\2\u00ba\u00c0\7 \2\2\u00bb\u00bc\5@!\2\u00bc\u00bd\7\65"+
		"\2\2\u00bd\u00bf\3\2\2\2\u00be\u00bb\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0"+
		"\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00c0\3\2"+
		"\2\2\u00c3\u00c4\7!\2\2\u00c4\u00c6\7\36\2\2\u00c5\u00c7\5\6\4\2\u00c6"+
		"\u00c5\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\7\37"+
		"\2\2\u00c9\31\3\2\2\2\u00ca\u00d0\5\34\17\2\u00cb\u00d0\5\36\20\2\u00cc"+
		"\u00d0\5&\24\2\u00cd\u00d0\5(\25\2\u00ce\u00d0\5*\26\2\u00cf\u00ca\3\2"+
		"\2\2\u00cf\u00cb\3\2\2\2\u00cf\u00cc\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf"+
		"\u00ce\3\2\2\2\u00d0\33\3\2\2\2\u00d1\u00d2\7\3\2\2\u00d2\u00d3\7\65\2"+
		"\2\u00d3\u00d7\7%\2\2\u00d4\u00d8\5 \21\2\u00d5\u00d8\5$\23\2\u00d6\u00d8"+
		"\7\33\2\2\u00d7\u00d4\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d6\3\2\2\2"+
		"\u00d8\35\3\2\2\2\u00d9\u00da\7\4\2\2\u00da\u00db\7\65\2\2\u00db\u00df"+
		"\7%\2\2\u00dc\u00e0\5 \21\2\u00dd\u00e0\5$\23\2\u00de\u00e0\5\62\32\2"+
		"\u00df\u00dc\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00de\3\2\2\2\u00e0\37"+
		"\3\2\2\2\u00e1\u00e2\5\"\22\2\u00e2\u00e3\5 \21\2\u00e3\u00e6\3\2\2\2"+
		"\u00e4\u00e6\5\"\22\2\u00e5\u00e1\3\2\2\2\u00e5\u00e4\3\2\2\2\u00e6!\3"+
		"\2\2\2\u00e7\u00eb\5\62\32\2\u00e8\u00eb\5$\23\2\u00e9\u00eb\7\65\2\2"+
		"\u00ea\u00e7\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ec"+
		"\3\2\2\2\u00ec\u00f4\5\66\34\2\u00ed\u00f5\5\62\32\2\u00ee\u00f5\5$\23"+
		"\2\u00ef\u00f5\7\65\2\2\u00f0\u00f1\7 \2\2\u00f1\u00f2\5\"\22\2\u00f2"+
		"\u00f3\7!\2\2\u00f3\u00f5\3\2\2\2\u00f4\u00ed\3\2\2\2\u00f4\u00ee\3\2"+
		"\2\2\u00f4\u00ef\3\2\2\2\u00f4\u00f0\3\2\2\2\u00f5\u0105\3\2\2\2\u00f6"+
		"\u00fe\5\66\34\2\u00f7\u00ff\5\62\32\2\u00f8\u00ff\5$\23\2\u00f9\u00ff"+
		"\7\65\2\2\u00fa\u00fb\7 \2\2\u00fb\u00fc\5\"\22\2\u00fc\u00fd\7!\2\2\u00fd"+
		"\u00ff\3\2\2\2\u00fe\u00f7\3\2\2\2\u00fe\u00f8\3\2\2\2\u00fe\u00f9\3\2"+
		"\2\2\u00fe\u00fa\3\2\2\2\u00ff\u0105\3\2\2\2\u0100\u0101\7 \2\2\u0101"+
		"\u0102\5 \21\2\u0102\u0103\7!\2\2\u0103\u0105\3\2\2\2\u0104\u00ea\3\2"+
		"\2\2\u0104\u00f6\3\2\2\2\u0104\u0100\3\2\2\2\u0105#\3\2\2\2\u0106\u010b"+
		"\5:\36\2\u0107\u010c\7\65\2\2\u0108\u010c\5\62\32\2\u0109\u010c\5$\23"+
		"\2\u010a\u010c\7\64\2\2\u010b\u0107\3\2\2\2\u010b\u0108\3\2\2\2\u010b"+
		"\u0109\3\2\2\2\u010b\u010a\3\2\2\2\u010c\u0110\3\2\2\2\u010d\u010f\5\""+
		"\22\2\u010e\u010d\3\2\2\2\u010f\u0112\3\2\2\2\u0110\u010e\3\2\2\2\u0110"+
		"\u0111\3\2\2\2\u0111\u0113\3\2\2\2\u0112\u0110\3\2\2\2\u0113\u0114\7!"+
		"\2\2\u0114%\3\2\2\2\u0115\u0116\7\6\2\2\u0116\u0117\7\65\2\2\u0117\u0118"+
		"\7%\2\2\u0118\u0119\7 \2\2\u0119\u011a\5\62\32\2\u011a\u011b\7#\2\2\u011b"+
		"\u011c\5\62\32\2\u011c\u011d\7!\2\2\u011d\'\3\2\2\2\u011e\u011f\7\7\2"+
		"\2\u011f\u0120\7\65\2\2\u0120\u0121\7%\2\2\u0121\u0122\7 \2\2\u0122\u0123"+
		"\5\62\32\2\u0123\u0124\7#\2\2\u0124\u0125\5\62\32\2\u0125\u0126\7#\2\2"+
		"\u0126\u0127\5\62\32\2\u0127\u0128\7!\2\2\u0128)\3\2\2\2\u0129\u012a\7"+
		"\b\2\2\u012a\u012b\7\65\2\2\u012b\u012c\7%\2\2\u012c\u012d\7 \2\2\u012d"+
		"\u012e\5\62\32\2\u012e\u012f\7#\2\2\u012f\u0130\5\62\32\2\u0130\u0131"+
		"\7#\2\2\u0131\u0132\5\62\32\2\u0132\u0133\7#\2\2\u0133\u0134\5\62\32\2"+
		"\u0134\u0135\7!\2\2\u0135+\3\2\2\2\u0136\u0137\7\5\2\2\u0137\u0138\7\65"+
		"\2\2\u0138\u013b\7%\2\2\u0139\u013c\5.\30\2\u013a\u013c\7\35\2\2\u013b"+
		"\u0139\3\2\2\2\u013b\u013a\3\2\2\2\u013c-\3\2\2\2\u013d\u013e\5\60\31"+
		"\2\u013e\u013f\5.\30\2\u013f\u0142\3\2\2\2\u0140\u0142\5\60\31\2\u0141"+
		"\u013d\3\2\2\2\u0141\u0140\3\2\2\2\u0142/\3\2\2\2\u0143\u0144\t\3\2\2"+
		"\u0144\u014b\58\35\2\u0145\u014c\7\35\2\2\u0146\u014c\7\65\2\2\u0147\u0148"+
		"\7 \2\2\u0148\u0149\5\60\31\2\u0149\u014a\7!\2\2\u014a\u014c\3\2\2\2\u014b"+
		"\u0145\3\2\2\2\u014b\u0146\3\2\2\2\u014b\u0147\3\2\2\2\u014c\u015b\3\2"+
		"\2\2\u014d\u0154\58\35\2\u014e\u0155\7\35\2\2\u014f\u0155\7\65\2\2\u0150"+
		"\u0151\7 \2\2\u0151\u0152\5\60\31\2\u0152\u0153\7!\2\2\u0153\u0155\3\2"+
		"\2\2\u0154\u014e\3\2\2\2\u0154\u014f\3\2\2\2\u0154\u0150\3\2\2\2\u0155"+
		"\u015b\3\2\2\2\u0156\u0157\7 \2\2\u0157\u0158\5\60\31\2\u0158\u0159\7"+
		"!\2\2\u0159\u015b\3\2\2\2\u015a\u0143\3\2\2\2\u015a\u014d\3\2\2\2\u015a"+
		"\u0156\3\2\2\2\u015b\61\3\2\2\2\u015c\u015d\t\4\2\2\u015d\63\3\2\2\2\u015e"+
		"\u015f\t\5\2\2\u015f\65\3\2\2\2\u0160\u0161\t\6\2\2\u0161\67\3\2\2\2\u0162"+
		"\u0163\t\7\2\2\u01639\3\2\2\2\u0164\u0165\t\b\2\2\u0165;\3\2\2\2\u0166"+
		"\u0169\7\t\2\2\u0167\u0169\5@!\2\u0168\u0166\3\2\2\2\u0168\u0167\3\2\2"+
		"\2\u0169=\3\2\2\2\u016a\u016b\t\t\2\2\u016b?\3\2\2\2\u016c\u016d\t\n\2"+
		"\2\u016dA\3\2\2\2\u016e\u016f\7\65\2\2\u016fC\3\2\2\2\u0170\u0171\7\65"+
		"\2\2\u0171E\3\2\2\2%JLSU^dnrw\u0083\u008d\u0093\u009a\u00a0\u00a4\u00ad"+
		"\u00b2\u00c0\u00c6\u00cf\u00d7\u00df\u00e5\u00ea\u00f4\u00fe\u0104\u010b"+
		"\u0110\u013b\u0141\u014b\u0154\u015a\u0168";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}