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
		MAIN=1, CLASS=2, INT=3, FLOAT=4, BOOL=5, VECTOR2=6, VECTOR3=7, VECTOR4=8, 
		VOID=9, CIRCLE=10, RECTANGLE=11, TRIANGLE=12, SHAPE=13, COLOR=14, ID=15, 
		DIGIT=16, FLOAT_DIGIT=17, BOOL_LITERAL=18, LEFT_BRACKET=19, RIGHT_BRACKET=20, 
		LEFT_PAREN=21, RIGHT_PAREN=22, DOT=23, COMMA=24, SEMICOLON=25, ASSIGN=26, 
		ADD=27, SUB=28, MOD=29, DIV=30, MUL=31, EQUAL=32, AND=33, OR=34, NOT_EQUAL=35, 
		NOT=36, ABS=37, SIN=38, COS=39, TAN=40, UNIFORM=41, COMMENT_STRING=42, 
		WS=43;
	public static final int
		RULE_program = 0, RULE_main = 1, RULE_declarations = 2, RULE_declaration = 3, 
		RULE_comment = 4, RULE_classDecl = 5, RULE_objectDecl = 6, RULE_objectArgs = 7, 
		RULE_objectArg = 8, RULE_objectFunctionCall = 9, RULE_functionDecl = 10, 
		RULE_numberDecl = 11, RULE_integerDecl = 12, RULE_floatDecl = 13, RULE_arithOperations = 14, 
		RULE_arithOperation = 15, RULE_mathFunction = 16, RULE_vector2Decl = 17, 
		RULE_vector3Decl = 18, RULE_vector4Decl = 19, RULE_boolDecl = 20, RULE_boolOperations = 21, 
		RULE_boolOperation = 22, RULE_realNumber = 23, RULE_operator = 24, RULE_boolOperator = 25, 
		RULE_function = 26, RULE_returnType = 27, RULE_classType = 28, RULE_dataType = 29, 
		RULE_objectVariable = 30, RULE_functionName = 31;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main", "declarations", "declaration", "comment", "classDecl", 
			"objectDecl", "objectArgs", "objectArg", "objectFunctionCall", "functionDecl", 
			"numberDecl", "integerDecl", "floatDecl", "arithOperations", "arithOperation", 
			"mathFunction", "vector2Decl", "vector3Decl", "vector4Decl", "boolDecl", 
			"boolOperations", "boolOperation", "realNumber", "operator", "boolOperator", 
			"function", "returnType", "classType", "dataType", "objectVariable", 
			"functionName"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Shader'", "'class'", "'int'", "'float'", "'bool'", "'vector2'", 
			"'vector3'", "'vector4'", "'void'", "'Circle'", "'Rectangle'", "'Triangle'", 
			"'Shape'", "'Color'", null, null, null, null, "'{'", "'}'", "'('", "')'", 
			"'.'", "','", "';'", "'='", "'+'", "'-'", "'%'", "'/'", "'*'", "'=='", 
			"'&&'", "'||'", "'!='", "'!'", "'abs('", "'sin('", "'cos('", "'tan('", 
			"'Time'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "MAIN", "CLASS", "INT", "FLOAT", "BOOL", "VECTOR2", "VECTOR3", 
			"VECTOR4", "VOID", "CIRCLE", "RECTANGLE", "TRIANGLE", "SHAPE", "COLOR", 
			"ID", "DIGIT", "FLOAT_DIGIT", "BOOL_LITERAL", "LEFT_BRACKET", "RIGHT_BRACKET", 
			"LEFT_PAREN", "RIGHT_PAREN", "DOT", "COMMA", "SEMICOLON", "ASSIGN", "ADD", 
			"SUB", "MOD", "DIV", "MUL", "EQUAL", "AND", "OR", "NOT_EQUAL", "NOT", 
			"ABS", "SIN", "COS", "TAN", "UNIFORM", "COMMENT_STRING", "WS"
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
			setState(64);
			main();
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS) | (1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << VECTOR2) | (1L << VECTOR3) | (1L << VECTOR4) | (1L << VOID) | (1L << COMMENT_STRING))) != 0)) {
				{
				setState(68);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case COMMENT_STRING:
					{
					setState(65);
					comment();
					}
					break;
				case CLASS:
					{
					setState(66);
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
					setState(67);
					functionDecl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(72);
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
			setState(73);
			match(MAIN);
			setState(74);
			match(LEFT_BRACKET);
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << VECTOR2) | (1L << VECTOR3) | (1L << VECTOR4) | (1L << CIRCLE) | (1L << RECTANGLE) | (1L << TRIANGLE) | (1L << SHAPE) | (1L << COLOR) | (1L << ID) | (1L << COMMENT_STRING))) != 0)) {
				{
				setState(77);
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
					setState(75);
					declarations();
					}
					break;
				case COMMENT_STRING:
					{
					setState(76);
					comment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
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
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				declaration();
				setState(85);
				declarations();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
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
			setState(94);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case VECTOR2:
			case VECTOR3:
			case VECTOR4:
				{
				setState(90);
				numberDecl();
				}
				break;
			case BOOL:
				{
				setState(91);
				boolDecl();
				}
				break;
			case CIRCLE:
			case RECTANGLE:
			case TRIANGLE:
			case SHAPE:
			case COLOR:
				{
				setState(92);
				objectDecl();
				}
				break;
			case ID:
				{
				setState(93);
				objectFunctionCall();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(96);
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
			setState(98);
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
		public List<NumberDeclContext> numberDecl() {
			return getRuleContexts(NumberDeclContext.class);
		}
		public NumberDeclContext numberDecl(int i) {
			return getRuleContext(NumberDeclContext.class,i);
		}
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
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
			setState(100);
			match(CLASS);
			setState(101);
			match(ID);
			setState(102);
			match(LEFT_BRACKET);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << VECTOR2) | (1L << VECTOR3) | (1L << VECTOR4) | (1L << VOID))) != 0)) {
				{
				setState(105);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(103);
					numberDecl();
					}
					break;
				case 2:
					{
					setState(104);
					functionDecl();
					}
					break;
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(110);
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
			setState(112);
			classType();
			setState(113);
			match(ID);
			setState(114);
			match(ASSIGN);
			setState(115);
			match(LEFT_PAREN);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << DIGIT) | (1L << FLOAT_DIGIT) | (1L << LEFT_PAREN) | (1L << ADD) | (1L << SUB) | (1L << MOD) | (1L << DIV) | (1L << MUL) | (1L << ABS) | (1L << SIN) | (1L << COS) | (1L << TAN))) != 0)) {
				{
				{
				setState(116);
				objectArgs();
				}
				}
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(122);
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
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				objectArg();
				setState(125);
				match(COMMA);
				setState(126);
				objectArgs();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
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
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				realNumber();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
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
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(136);
				objectVariable();
				setState(137);
				match(DOT);
				setState(138);
				functionName();
				setState(139);
				match(ASSIGN);
				setState(140);
				match(LEFT_PAREN);
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << DIGIT) | (1L << FLOAT_DIGIT) | (1L << LEFT_PAREN) | (1L << ADD) | (1L << SUB) | (1L << MOD) | (1L << DIV) | (1L << MUL) | (1L << ABS) | (1L << SIN) | (1L << COS) | (1L << TAN))) != 0)) {
					{
					{
					setState(141);
					objectArgs();
					}
					}
					setState(146);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(147);
				match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(149);
				objectVariable();
				setState(150);
				match(DOT);
				setState(151);
				functionName();
				setState(152);
				match(LEFT_PAREN);
				setState(153);
				objectArgs();
				setState(154);
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
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
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
		enterRule(_localctx, 20, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			returnType();
			setState(159);
			match(ID);
			setState(160);
			match(LEFT_PAREN);
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << VECTOR2) | (1L << VECTOR3) | (1L << VECTOR4))) != 0)) {
				{
				{
				setState(161);
				dataType();
				setState(162);
				match(ID);
				}
				}
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(169);
			match(RIGHT_PAREN);
			setState(170);
			match(LEFT_BRACKET);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << VECTOR2) | (1L << VECTOR3) | (1L << VECTOR4) | (1L << CIRCLE) | (1L << RECTANGLE) | (1L << TRIANGLE) | (1L << SHAPE) | (1L << COLOR) | (1L << ID))) != 0)) {
				{
				{
				setState(171);
				declaration();
				}
				}
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(177);
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
		enterRule(_localctx, 22, RULE_numberDecl);
		try {
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				integerDecl();
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				floatDecl();
				}
				break;
			case VECTOR2:
				enterOuterAlt(_localctx, 3);
				{
				setState(181);
				vector2Decl();
				}
				break;
			case VECTOR3:
				enterOuterAlt(_localctx, 4);
				{
				setState(182);
				vector3Decl();
				}
				break;
			case VECTOR4:
				enterOuterAlt(_localctx, 5);
				{
				setState(183);
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
		enterRule(_localctx, 24, RULE_integerDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(INT);
			setState(187);
			match(ID);
			setState(188);
			match(ASSIGN);
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(189);
				arithOperations();
				}
				break;
			case 2:
				{
				setState(190);
				mathFunction();
				}
				break;
			case 3:
				{
				setState(191);
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
		enterRule(_localctx, 26, RULE_floatDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(FLOAT);
			setState(195);
			match(ID);
			setState(196);
			match(ASSIGN);
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(197);
				arithOperations();
				}
				break;
			case 2:
				{
				setState(198);
				mathFunction();
				}
				break;
			case 3:
				{
				setState(199);
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
		enterRule(_localctx, 28, RULE_arithOperations);
		try {
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				arithOperation();
				setState(203);
				arithOperations();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
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
		enterRule(_localctx, 30, RULE_arithOperation);
		try {
			setState(237);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case DIGIT:
			case FLOAT_DIGIT:
			case ABS:
			case SIN:
			case COS:
			case TAN:
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DIGIT:
				case FLOAT_DIGIT:
					{
					setState(208);
					realNumber();
					}
					break;
				case ABS:
				case SIN:
				case COS:
				case TAN:
					{
					setState(209);
					mathFunction();
					}
					break;
				case ID:
					{
					setState(210);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(213);
				operator();
				setState(221);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DIGIT:
				case FLOAT_DIGIT:
					{
					setState(214);
					realNumber();
					}
					break;
				case ABS:
				case SIN:
				case COS:
				case TAN:
					{
					setState(215);
					mathFunction();
					}
					break;
				case ID:
					{
					setState(216);
					match(ID);
					}
					break;
				case LEFT_PAREN:
					{
					setState(217);
					match(LEFT_PAREN);
					setState(218);
					arithOperation();
					setState(219);
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
				setState(223);
				operator();
				setState(231);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DIGIT:
				case FLOAT_DIGIT:
					{
					setState(224);
					realNumber();
					}
					break;
				case ABS:
				case SIN:
				case COS:
				case TAN:
					{
					setState(225);
					mathFunction();
					}
					break;
				case ID:
					{
					setState(226);
					match(ID);
					}
					break;
				case LEFT_PAREN:
					{
					setState(227);
					match(LEFT_PAREN);
					setState(228);
					arithOperation();
					setState(229);
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
				setState(233);
				match(LEFT_PAREN);
				setState(234);
				arithOperations();
				setState(235);
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
		enterRule(_localctx, 32, RULE_mathFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			function();
			setState(244);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(240);
				match(ID);
				}
				break;
			case DIGIT:
			case FLOAT_DIGIT:
				{
				setState(241);
				realNumber();
				}
				break;
			case ABS:
			case SIN:
			case COS:
			case TAN:
				{
				setState(242);
				mathFunction();
				}
				break;
			case UNIFORM:
				{
				setState(243);
				match(UNIFORM);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << DIGIT) | (1L << FLOAT_DIGIT) | (1L << LEFT_PAREN) | (1L << ADD) | (1L << SUB) | (1L << MOD) | (1L << DIV) | (1L << MUL) | (1L << ABS) | (1L << SIN) | (1L << COS) | (1L << TAN))) != 0)) {
				{
				{
				setState(246);
				arithOperation();
				}
				}
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(252);
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
		enterRule(_localctx, 34, RULE_vector2Decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(VECTOR2);
			setState(255);
			match(ID);
			setState(256);
			match(ASSIGN);
			setState(257);
			match(LEFT_PAREN);
			setState(258);
			realNumber();
			setState(259);
			match(COMMA);
			setState(260);
			realNumber();
			setState(261);
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
		enterRule(_localctx, 36, RULE_vector3Decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(VECTOR3);
			setState(264);
			match(ID);
			setState(265);
			match(ASSIGN);
			setState(266);
			match(LEFT_PAREN);
			setState(267);
			realNumber();
			setState(268);
			match(COMMA);
			setState(269);
			realNumber();
			setState(270);
			match(COMMA);
			setState(271);
			realNumber();
			setState(272);
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
		enterRule(_localctx, 38, RULE_vector4Decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(VECTOR4);
			setState(275);
			match(ID);
			setState(276);
			match(ASSIGN);
			setState(277);
			match(LEFT_PAREN);
			setState(278);
			realNumber();
			setState(279);
			match(COMMA);
			setState(280);
			realNumber();
			setState(281);
			match(COMMA);
			setState(282);
			realNumber();
			setState(283);
			match(COMMA);
			setState(284);
			realNumber();
			setState(285);
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
		enterRule(_localctx, 40, RULE_boolDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(BOOL);
			setState(288);
			match(ID);
			setState(289);
			match(ASSIGN);
			setState(292);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(290);
				boolOperations();
				}
				break;
			case 2:
				{
				setState(291);
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
		enterRule(_localctx, 42, RULE_boolOperations);
		try {
			setState(298);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(294);
				boolOperation();
				setState(295);
				boolOperations();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(297);
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
		enterRule(_localctx, 44, RULE_boolOperation);
		int _la;
		try {
			setState(323);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case BOOL_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(300);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==BOOL_LITERAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(301);
				boolOperator();
				setState(308);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL_LITERAL:
					{
					setState(302);
					match(BOOL_LITERAL);
					}
					break;
				case ID:
					{
					setState(303);
					match(ID);
					}
					break;
				case LEFT_PAREN:
					{
					{
					setState(304);
					match(LEFT_PAREN);
					setState(305);
					boolOperation();
					setState(306);
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
				setState(310);
				boolOperator();
				setState(317);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL_LITERAL:
					{
					setState(311);
					match(BOOL_LITERAL);
					}
					break;
				case ID:
					{
					setState(312);
					match(ID);
					}
					break;
				case LEFT_PAREN:
					{
					{
					setState(313);
					match(LEFT_PAREN);
					setState(314);
					boolOperation();
					setState(315);
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
				setState(319);
				match(LEFT_PAREN);
				setState(320);
				boolOperation();
				setState(321);
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
		enterRule(_localctx, 46, RULE_realNumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
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
		enterRule(_localctx, 48, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
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
		enterRule(_localctx, 50, RULE_boolOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
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
		enterRule(_localctx, 52, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
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
		enterRule(_localctx, 54, RULE_returnType);
		try {
			setState(335);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(333);
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
				setState(334);
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
		enterRule(_localctx, 56, RULE_classType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
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
		enterRule(_localctx, 58, RULE_dataType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
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
		enterRule(_localctx, 60, RULE_objectVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
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
		enterRule(_localctx, 62, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u015c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\2\7\2G\n\2\f\2\16\2J\13\2\3\3\3\3\3\3\3\3\7\3P\n\3\f"+
		"\3\16\3S\13\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4[\n\4\3\5\3\5\3\5\3\5\5\5a\n"+
		"\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7l\n\7\f\7\16\7o\13\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\7\bx\n\b\f\b\16\b{\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\5\t\u0084\n\t\3\n\3\n\3\n\5\n\u0089\n\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\7\13\u0091\n\13\f\13\16\13\u0094\13\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13\u009f\n\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00a7\n"+
		"\f\f\f\16\f\u00aa\13\f\3\f\3\f\3\f\7\f\u00af\n\f\f\f\16\f\u00b2\13\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\5\r\u00bb\n\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\5\16\u00c3\n\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00cb\n\17\3\20\3"+
		"\20\3\20\3\20\5\20\u00d1\n\20\3\21\3\21\3\21\5\21\u00d6\n\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00e0\n\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\5\21\u00ea\n\21\3\21\3\21\3\21\3\21\5\21\u00f0\n\21\3"+
		"\22\3\22\3\22\3\22\3\22\5\22\u00f7\n\22\3\22\7\22\u00fa\n\22\f\22\16\22"+
		"\u00fd\13\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3"+
		"\26\5\26\u0127\n\26\3\27\3\27\3\27\3\27\5\27\u012d\n\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\5\30\u0137\n\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\5\30\u0140\n\30\3\30\3\30\3\30\3\30\5\30\u0146\n\30\3\31\3\31\3"+
		"\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\5\35\u0152\n\35\3\36\3\36\3\37"+
		"\3\37\3 \3 \3!\3!\3!\2\2\"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$"+
		"&(*,.\60\62\64\668:<>@\2\t\4\2\21\21\24\24\3\2\22\23\3\2\35!\3\2\"&\3"+
		"\2\'*\3\2\f\20\3\2\5\n\2\u016e\2B\3\2\2\2\4K\3\2\2\2\6Z\3\2\2\2\b`\3\2"+
		"\2\2\nd\3\2\2\2\ff\3\2\2\2\16r\3\2\2\2\20\u0083\3\2\2\2\22\u0088\3\2\2"+
		"\2\24\u009e\3\2\2\2\26\u00a0\3\2\2\2\30\u00ba\3\2\2\2\32\u00bc\3\2\2\2"+
		"\34\u00c4\3\2\2\2\36\u00d0\3\2\2\2 \u00ef\3\2\2\2\"\u00f1\3\2\2\2$\u0100"+
		"\3\2\2\2&\u0109\3\2\2\2(\u0114\3\2\2\2*\u0121\3\2\2\2,\u012c\3\2\2\2."+
		"\u0145\3\2\2\2\60\u0147\3\2\2\2\62\u0149\3\2\2\2\64\u014b\3\2\2\2\66\u014d"+
		"\3\2\2\28\u0151\3\2\2\2:\u0153\3\2\2\2<\u0155\3\2\2\2>\u0157\3\2\2\2@"+
		"\u0159\3\2\2\2BH\5\4\3\2CG\5\n\6\2DG\5\f\7\2EG\5\26\f\2FC\3\2\2\2FD\3"+
		"\2\2\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\3\3\2\2\2JH\3\2\2\2KL"+
		"\7\3\2\2LQ\7\25\2\2MP\5\6\4\2NP\5\n\6\2OM\3\2\2\2ON\3\2\2\2PS\3\2\2\2"+
		"QO\3\2\2\2QR\3\2\2\2RT\3\2\2\2SQ\3\2\2\2TU\7\26\2\2U\5\3\2\2\2VW\5\b\5"+
		"\2WX\5\6\4\2X[\3\2\2\2Y[\5\b\5\2ZV\3\2\2\2ZY\3\2\2\2[\7\3\2\2\2\\a\5\30"+
		"\r\2]a\5*\26\2^a\5\16\b\2_a\5\24\13\2`\\\3\2\2\2`]\3\2\2\2`^\3\2\2\2`"+
		"_\3\2\2\2ab\3\2\2\2bc\7\33\2\2c\t\3\2\2\2de\7,\2\2e\13\3\2\2\2fg\7\4\2"+
		"\2gh\7\21\2\2hm\7\25\2\2il\5\30\r\2jl\5\26\f\2ki\3\2\2\2kj\3\2\2\2lo\3"+
		"\2\2\2mk\3\2\2\2mn\3\2\2\2np\3\2\2\2om\3\2\2\2pq\7\26\2\2q\r\3\2\2\2r"+
		"s\5:\36\2st\7\21\2\2tu\7\34\2\2uy\7\27\2\2vx\5\20\t\2wv\3\2\2\2x{\3\2"+
		"\2\2yw\3\2\2\2yz\3\2\2\2z|\3\2\2\2{y\3\2\2\2|}\7\30\2\2}\17\3\2\2\2~\177"+
		"\5\22\n\2\177\u0080\7\32\2\2\u0080\u0081\5\20\t\2\u0081\u0084\3\2\2\2"+
		"\u0082\u0084\5\22\n\2\u0083~\3\2\2\2\u0083\u0082\3\2\2\2\u0084\21\3\2"+
		"\2\2\u0085\u0089\7\21\2\2\u0086\u0089\5\60\31\2\u0087\u0089\5 \21\2\u0088"+
		"\u0085\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0087\3\2\2\2\u0089\23\3\2\2"+
		"\2\u008a\u008b\5> \2\u008b\u008c\7\31\2\2\u008c\u008d\5@!\2\u008d\u008e"+
		"\7\34\2\2\u008e\u0092\7\27\2\2\u008f\u0091\5\20\t\2\u0090\u008f\3\2\2"+
		"\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095"+
		"\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0096\7\30\2\2\u0096\u009f\3\2\2\2"+
		"\u0097\u0098\5> \2\u0098\u0099\7\31\2\2\u0099\u009a\5@!\2\u009a\u009b"+
		"\7\27\2\2\u009b\u009c\5\20\t\2\u009c\u009d\7\30\2\2\u009d\u009f\3\2\2"+
		"\2\u009e\u008a\3\2\2\2\u009e\u0097\3\2\2\2\u009f\25\3\2\2\2\u00a0\u00a1"+
		"\58\35\2\u00a1\u00a2\7\21\2\2\u00a2\u00a8\7\27\2\2\u00a3\u00a4\5<\37\2"+
		"\u00a4\u00a5\7\21\2\2\u00a5\u00a7\3\2\2\2\u00a6\u00a3\3\2\2\2\u00a7\u00aa"+
		"\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00ab\u00ac\7\30\2\2\u00ac\u00b0\7\25\2\2\u00ad\u00af\5"+
		"\b\5\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b4\7\26"+
		"\2\2\u00b4\27\3\2\2\2\u00b5\u00bb\5\32\16\2\u00b6\u00bb\5\34\17\2\u00b7"+
		"\u00bb\5$\23\2\u00b8\u00bb\5&\24\2\u00b9\u00bb\5(\25\2\u00ba\u00b5\3\2"+
		"\2\2\u00ba\u00b6\3\2\2\2\u00ba\u00b7\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba"+
		"\u00b9\3\2\2\2\u00bb\31\3\2\2\2\u00bc\u00bd\7\5\2\2\u00bd\u00be\7\21\2"+
		"\2\u00be\u00c2\7\34\2\2\u00bf\u00c3\5\36\20\2\u00c0\u00c3\5\"\22\2\u00c1"+
		"\u00c3\7\22\2\2\u00c2\u00bf\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c1\3"+
		"\2\2\2\u00c3\33\3\2\2\2\u00c4\u00c5\7\6\2\2\u00c5\u00c6\7\21\2\2\u00c6"+
		"\u00ca\7\34\2\2\u00c7\u00cb\5\36\20\2\u00c8\u00cb\5\"\22\2\u00c9\u00cb"+
		"\5\60\31\2\u00ca\u00c7\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00c9\3\2\2\2"+
		"\u00cb\35\3\2\2\2\u00cc\u00cd\5 \21\2\u00cd\u00ce\5\36\20\2\u00ce\u00d1"+
		"\3\2\2\2\u00cf\u00d1\5 \21\2\u00d0\u00cc\3\2\2\2\u00d0\u00cf\3\2\2\2\u00d1"+
		"\37\3\2\2\2\u00d2\u00d6\5\60\31\2\u00d3\u00d6\5\"\22\2\u00d4\u00d6\7\21"+
		"\2\2\u00d5\u00d2\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6"+
		"\u00d7\3\2\2\2\u00d7\u00df\5\62\32\2\u00d8\u00e0\5\60\31\2\u00d9\u00e0"+
		"\5\"\22\2\u00da\u00e0\7\21\2\2\u00db\u00dc\7\27\2\2\u00dc\u00dd\5 \21"+
		"\2\u00dd\u00de\7\30\2\2\u00de\u00e0\3\2\2\2\u00df\u00d8\3\2\2\2\u00df"+
		"\u00d9\3\2\2\2\u00df\u00da\3\2\2\2\u00df\u00db\3\2\2\2\u00e0\u00f0\3\2"+
		"\2\2\u00e1\u00e9\5\62\32\2\u00e2\u00ea\5\60\31\2\u00e3\u00ea\5\"\22\2"+
		"\u00e4\u00ea\7\21\2\2\u00e5\u00e6\7\27\2\2\u00e6\u00e7\5 \21\2\u00e7\u00e8"+
		"\7\30\2\2\u00e8\u00ea\3\2\2\2\u00e9\u00e2\3\2\2\2\u00e9\u00e3\3\2\2\2"+
		"\u00e9\u00e4\3\2\2\2\u00e9\u00e5\3\2\2\2\u00ea\u00f0\3\2\2\2\u00eb\u00ec"+
		"\7\27\2\2\u00ec\u00ed\5\36\20\2\u00ed\u00ee\7\30\2\2\u00ee\u00f0\3\2\2"+
		"\2\u00ef\u00d5\3\2\2\2\u00ef\u00e1\3\2\2\2\u00ef\u00eb\3\2\2\2\u00f0!"+
		"\3\2\2\2\u00f1\u00f6\5\66\34\2\u00f2\u00f7\7\21\2\2\u00f3\u00f7\5\60\31"+
		"\2\u00f4\u00f7\5\"\22\2\u00f5\u00f7\7+\2\2\u00f6\u00f2\3\2\2\2\u00f6\u00f3"+
		"\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f5\3\2\2\2\u00f7\u00fb\3\2\2\2\u00f8"+
		"\u00fa\5 \21\2\u00f9\u00f8\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2"+
		"\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fe\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe"+
		"\u00ff\7\30\2\2\u00ff#\3\2\2\2\u0100\u0101\7\b\2\2\u0101\u0102\7\21\2"+
		"\2\u0102\u0103\7\34\2\2\u0103\u0104\7\27\2\2\u0104\u0105\5\60\31\2\u0105"+
		"\u0106\7\32\2\2\u0106\u0107\5\60\31\2\u0107\u0108\7\30\2\2\u0108%\3\2"+
		"\2\2\u0109\u010a\7\t\2\2\u010a\u010b\7\21\2\2\u010b\u010c\7\34\2\2\u010c"+
		"\u010d\7\27\2\2\u010d\u010e\5\60\31\2\u010e\u010f\7\32\2\2\u010f\u0110"+
		"\5\60\31\2\u0110\u0111\7\32\2\2\u0111\u0112\5\60\31\2\u0112\u0113\7\30"+
		"\2\2\u0113\'\3\2\2\2\u0114\u0115\7\n\2\2\u0115\u0116\7\21\2\2\u0116\u0117"+
		"\7\34\2\2\u0117\u0118\7\27\2\2\u0118\u0119\5\60\31\2\u0119\u011a\7\32"+
		"\2\2\u011a\u011b\5\60\31\2\u011b\u011c\7\32\2\2\u011c\u011d\5\60\31\2"+
		"\u011d\u011e\7\32\2\2\u011e\u011f\5\60\31\2\u011f\u0120\7\30\2\2\u0120"+
		")\3\2\2\2\u0121\u0122\7\7\2\2\u0122\u0123\7\21\2\2\u0123\u0126\7\34\2"+
		"\2\u0124\u0127\5,\27\2\u0125\u0127\7\24\2\2\u0126\u0124\3\2\2\2\u0126"+
		"\u0125\3\2\2\2\u0127+\3\2\2\2\u0128\u0129\5.\30\2\u0129\u012a\5,\27\2"+
		"\u012a\u012d\3\2\2\2\u012b\u012d\5.\30\2\u012c\u0128\3\2\2\2\u012c\u012b"+
		"\3\2\2\2\u012d-\3\2\2\2\u012e\u012f\t\2\2\2\u012f\u0136\5\64\33\2\u0130"+
		"\u0137\7\24\2\2\u0131\u0137\7\21\2\2\u0132\u0133\7\27\2\2\u0133\u0134"+
		"\5.\30\2\u0134\u0135\7\30\2\2\u0135\u0137\3\2\2\2\u0136\u0130\3\2\2\2"+
		"\u0136\u0131\3\2\2\2\u0136\u0132\3\2\2\2\u0137\u0146\3\2\2\2\u0138\u013f"+
		"\5\64\33\2\u0139\u0140\7\24\2\2\u013a\u0140\7\21\2\2\u013b\u013c\7\27"+
		"\2\2\u013c\u013d\5.\30\2\u013d\u013e\7\30\2\2\u013e\u0140\3\2\2\2\u013f"+
		"\u0139\3\2\2\2\u013f\u013a\3\2\2\2\u013f\u013b\3\2\2\2\u0140\u0146\3\2"+
		"\2\2\u0141\u0142\7\27\2\2\u0142\u0143\5.\30\2\u0143\u0144\7\30\2\2\u0144"+
		"\u0146\3\2\2\2\u0145\u012e\3\2\2\2\u0145\u0138\3\2\2\2\u0145\u0141\3\2"+
		"\2\2\u0146/\3\2\2\2\u0147\u0148\t\3\2\2\u0148\61\3\2\2\2\u0149\u014a\t"+
		"\4\2\2\u014a\63\3\2\2\2\u014b\u014c\t\5\2\2\u014c\65\3\2\2\2\u014d\u014e"+
		"\t\6\2\2\u014e\67\3\2\2\2\u014f\u0152\7\13\2\2\u0150\u0152\5<\37\2\u0151"+
		"\u014f\3\2\2\2\u0151\u0150\3\2\2\2\u01529\3\2\2\2\u0153\u0154\t\7\2\2"+
		"\u0154;\3\2\2\2\u0155\u0156\t\b\2\2\u0156=\3\2\2\2\u0157\u0158\7\21\2"+
		"\2\u0158?\3\2\2\2\u0159\u015a\7\21\2\2\u015aA\3\2\2\2!FHOQZ`kmy\u0083"+
		"\u0088\u0092\u009e\u00a8\u00b0\u00ba\u00c2\u00ca\u00d0\u00d5\u00df\u00e9"+
		"\u00ef\u00f6\u00fb\u0126\u012c\u0136\u013f\u0145\u0151";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}