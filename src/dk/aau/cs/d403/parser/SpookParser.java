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
		MAIN=1, CLASS=2, INT=3, FLOAT=4, BOOL=5, VECTOR2=6, VECTOR3=7, VECTOR4=8, 
		CIRCLE=9, RECTANGLE=10, TRIANGLE=11, SHAPE=12, COLOR=13, VOID=14, ID=15, 
		DIGIT=16, FLOAT_DIGIT=17, TRUE=18, FALSE=19, SEMICOLON=20, DOUBLE_SLASH=21, 
		ASSIGN=22, LEFT_BRACKET=23, RIGHT_BRACKET=24, LEFT_PAREN=25, RIGHT_PAREN=26, 
		DOT=27, COMMA=28, BOOLOPERATOR=29, OPERATOR=30, MATH_FUNCTION=31, UNIFORM=32, 
		COMMENT_STRING=33, WS=34;
	public static final int
		RULE_program = 0, RULE_main = 1, RULE_declarations = 2, RULE_declaration = 3, 
		RULE_comment = 4, RULE_classDecl = 5, RULE_objectDecl = 6, RULE_objectArgs = 7, 
		RULE_objectArg = 8, RULE_objectFunctionCall = 9, RULE_functionDecl = 10, 
		RULE_returnType = 11, RULE_classType = 12, RULE_objectVariable = 13, RULE_functionName = 14, 
		RULE_numberDecl = 15, RULE_integerDecl = 16, RULE_floatDecl = 17, RULE_arithOperations = 18, 
		RULE_arithOperation = 19, RULE_math_function = 20, RULE_boolDecl = 21, 
		RULE_boolOperations = 22, RULE_boolOperation = 23, RULE_vector2Decl = 24, 
		RULE_vector3Decl = 25, RULE_vector4Decl = 26, RULE_real_number = 27, RULE_digit = 28, 
		RULE_float_digit = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main", "declarations", "declaration", "comment", "classDecl", 
			"objectDecl", "objectArgs", "objectArg", "objectFunctionCall", "functionDecl", 
			"returnType", "classType", "objectVariable", "functionName", "numberDecl", 
			"integerDecl", "floatDecl", "arithOperations", "arithOperation", "math_function", 
			"boolDecl", "boolOperations", "boolOperation", "vector2Decl", "vector3Decl", 
			"vector4Decl", "real_number", "digit", "float_digit"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Shader'", "'class'", "'int'", "'float'", "'bool'", "'vector2'", 
			"'vector3'", "'vector4'", "'Circle'", "'Rectangle'", "'Triangle'", "'Shape'", 
			"'Color'", "'void'", null, null, null, "'true'", "'false'", "';'", "'//'", 
			"'='", "'{'", "'}'", "'('", "')'", "'.'", "','", null, null, null, "'Time'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "MAIN", "CLASS", "INT", "FLOAT", "BOOL", "VECTOR2", "VECTOR3", 
			"VECTOR4", "CIRCLE", "RECTANGLE", "TRIANGLE", "SHAPE", "COLOR", "VOID", 
			"ID", "DIGIT", "FLOAT_DIGIT", "TRUE", "FALSE", "SEMICOLON", "DOUBLE_SLASH", 
			"ASSIGN", "LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", 
			"DOT", "COMMA", "BOOLOPERATOR", "OPERATOR", "MATH_FUNCTION", "UNIFORM", 
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
			setState(60);
			main();
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS) | (1L << VOID) | (1L << COMMENT_STRING))) != 0)) {
				{
				setState(64);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case COMMENT_STRING:
					{
					setState(61);
					comment();
					}
					break;
				case CLASS:
					{
					setState(62);
					classDecl();
					}
					break;
				case VOID:
					{
					setState(63);
					functionDecl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(68);
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
			setState(69);
			match(MAIN);
			setState(70);
			match(LEFT_BRACKET);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << VECTOR2) | (1L << VECTOR3) | (1L << VECTOR4) | (1L << CIRCLE) | (1L << RECTANGLE) | (1L << TRIANGLE) | (1L << SHAPE) | (1L << COLOR) | (1L << ID) | (1L << COMMENT_STRING))) != 0)) {
				{
				setState(73);
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
					setState(71);
					declarations();
					}
					break;
				case COMMENT_STRING:
					{
					setState(72);
					comment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78);
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
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				declaration();
				setState(81);
				declarations();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
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
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case VECTOR2:
			case VECTOR3:
			case VECTOR4:
				{
				setState(86);
				numberDecl();
				}
				break;
			case BOOL:
				{
				setState(87);
				boolDecl();
				}
				break;
			case CIRCLE:
			case RECTANGLE:
			case TRIANGLE:
			case SHAPE:
			case COLOR:
				{
				setState(88);
				objectDecl();
				}
				break;
			case ID:
				{
				setState(89);
				objectFunctionCall();
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
			setState(92);
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
			setState(94);
			match(CLASS);
			setState(95);
			match(ID);
			setState(96);
			match(LEFT_BRACKET);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << VECTOR2) | (1L << VECTOR3) | (1L << VECTOR4) | (1L << VOID))) != 0)) {
				{
				setState(99);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT:
				case FLOAT:
				case VECTOR2:
				case VECTOR3:
				case VECTOR4:
					{
					setState(97);
					numberDecl();
					}
					break;
				case VOID:
					{
					setState(98);
					functionDecl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(104);
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
		public ObjectArgsContext objectArgs() {
			return getRuleContext(ObjectArgsContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			classType();
			setState(107);
			match(ID);
			setState(108);
			match(ASSIGN);
			setState(109);
			match(LEFT_PAREN);
			setState(110);
			objectArgs();
			setState(111);
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
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				objectArg();
				setState(114);
				objectArgs();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
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
		public TerminalNode COMMA() { return getToken(SpookParser.COMMA, 0); }
		public TerminalNode ID() { return getToken(SpookParser.ID, 0); }
		public Real_numberContext real_number() {
			return getRuleContext(Real_numberContext.class,0);
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
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(119);
					match(ID);
					}
					break;
				case 2:
					{
					setState(120);
					real_number();
					}
					break;
				case 3:
					{
					setState(121);
					arithOperation();
					}
					break;
				}
				setState(124);
				match(COMMA);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(125);
					match(ID);
					}
					break;
				case 2:
					{
					setState(126);
					real_number();
					}
					break;
				case 3:
					{
					setState(127);
					arithOperation();
					}
					break;
				}
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
		public ObjectArgsContext objectArgs() {
			return getRuleContext(ObjectArgsContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(132);
				objectVariable();
				setState(133);
				match(DOT);
				setState(134);
				functionName();
				setState(135);
				match(ASSIGN);
				setState(136);
				match(LEFT_PAREN);
				setState(137);
				objectArgs();
				setState(138);
				match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(140);
				objectVariable();
				setState(141);
				match(DOT);
				setState(142);
				functionName();
				setState(143);
				match(LEFT_PAREN);
				setState(144);
				objectArgs();
				setState(145);
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
		public TerminalNode ID() { return getToken(SpookParser.ID, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SpookParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(SpookParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(SpookParser.RIGHT_BRACKET, 0); }
		public List<TerminalNode> INT() { return getTokens(SpookParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(SpookParser.INT, i);
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
			setState(149);
			returnType();
			setState(150);
			match(ID);
			setState(151);
			match(LEFT_PAREN);
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INT) {
				{
				{
				setState(152);
				match(INT);
				}
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(158);
			match(RIGHT_PAREN);
			setState(159);
			match(LEFT_BRACKET);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << VECTOR2) | (1L << VECTOR3) | (1L << VECTOR4) | (1L << CIRCLE) | (1L << RECTANGLE) | (1L << TRIANGLE) | (1L << SHAPE) | (1L << COLOR) | (1L << ID))) != 0)) {
				{
				{
				setState(160);
				declaration();
				}
				}
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(166);
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

	public static class ReturnTypeContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(SpookParser.VOID, 0); }
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
		enterRule(_localctx, 22, RULE_returnType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(VOID);
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
		enterRule(_localctx, 24, RULE_classType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
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
		enterRule(_localctx, 26, RULE_objectVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
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
		enterRule(_localctx, 28, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
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

	public static class NumberDeclContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(SpookParser.SEMICOLON, 0); }
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
		enterRule(_localctx, 30, RULE_numberDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(176);
				integerDecl();
				}
				break;
			case FLOAT:
				{
				setState(177);
				floatDecl();
				}
				break;
			case VECTOR2:
				{
				setState(178);
				vector2Decl();
				}
				break;
			case VECTOR3:
				{
				setState(179);
				vector3Decl();
				}
				break;
			case VECTOR4:
				{
				setState(180);
				vector4Decl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(183);
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

	public static class IntegerDeclContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(SpookParser.INT, 0); }
		public TerminalNode ID() { return getToken(SpookParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(SpookParser.ASSIGN, 0); }
		public ArithOperationsContext arithOperations() {
			return getRuleContext(ArithOperationsContext.class,0);
		}
		public DigitContext digit() {
			return getRuleContext(DigitContext.class,0);
		}
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
		enterRule(_localctx, 32, RULE_integerDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(INT);
			setState(186);
			match(ID);
			setState(187);
			match(ASSIGN);
			setState(190);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(188);
				arithOperations();
				}
				break;
			case 2:
				{
				setState(189);
				digit();
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
		public Math_functionContext math_function() {
			return getRuleContext(Math_functionContext.class,0);
		}
		public Real_numberContext real_number() {
			return getRuleContext(Real_numberContext.class,0);
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
		enterRule(_localctx, 34, RULE_floatDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(FLOAT);
			setState(193);
			match(ID);
			setState(194);
			match(ASSIGN);
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(195);
				arithOperations();
				}
				break;
			case 2:
				{
				setState(196);
				math_function();
				}
				break;
			case 3:
				{
				setState(197);
				real_number();
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
		enterRule(_localctx, 36, RULE_arithOperations);
		try {
			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				arithOperation();
				setState(201);
				arithOperations();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
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
		public TerminalNode OPERATOR() { return getToken(SpookParser.OPERATOR, 0); }
		public List<Real_numberContext> real_number() {
			return getRuleContexts(Real_numberContext.class);
		}
		public Real_numberContext real_number(int i) {
			return getRuleContext(Real_numberContext.class,i);
		}
		public List<Math_functionContext> math_function() {
			return getRuleContexts(Math_functionContext.class);
		}
		public Math_functionContext math_function(int i) {
			return getRuleContext(Math_functionContext.class,i);
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
		enterRule(_localctx, 38, RULE_arithOperation);
		try {
			setState(235);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case DIGIT:
			case FLOAT_DIGIT:
			case MATH_FUNCTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DIGIT:
				case FLOAT_DIGIT:
					{
					setState(206);
					real_number();
					}
					break;
				case MATH_FUNCTION:
					{
					setState(207);
					math_function();
					}
					break;
				case ID:
					{
					setState(208);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(211);
				match(OPERATOR);
				setState(219);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DIGIT:
				case FLOAT_DIGIT:
					{
					setState(212);
					real_number();
					}
					break;
				case MATH_FUNCTION:
					{
					setState(213);
					math_function();
					}
					break;
				case ID:
					{
					setState(214);
					match(ID);
					}
					break;
				case LEFT_PAREN:
					{
					setState(215);
					match(LEFT_PAREN);
					setState(216);
					arithOperation();
					setState(217);
					match(RIGHT_PAREN);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case OPERATOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				match(OPERATOR);
				setState(229);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DIGIT:
				case FLOAT_DIGIT:
					{
					setState(222);
					real_number();
					}
					break;
				case MATH_FUNCTION:
					{
					setState(223);
					math_function();
					}
					break;
				case ID:
					{
					setState(224);
					match(ID);
					}
					break;
				case LEFT_PAREN:
					{
					setState(225);
					match(LEFT_PAREN);
					setState(226);
					arithOperation();
					setState(227);
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
				setState(231);
				match(LEFT_PAREN);
				setState(232);
				arithOperations();
				setState(233);
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

	public static class Math_functionContext extends ParserRuleContext {
		public TerminalNode MATH_FUNCTION() { return getToken(SpookParser.MATH_FUNCTION, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SpookParser.RIGHT_PAREN, 0); }
		public TerminalNode ID() { return getToken(SpookParser.ID, 0); }
		public Real_numberContext real_number() {
			return getRuleContext(Real_numberContext.class,0);
		}
		public Math_functionContext math_function() {
			return getRuleContext(Math_functionContext.class,0);
		}
		public TerminalNode UNIFORM() { return getToken(SpookParser.UNIFORM, 0); }
		public List<ArithOperationContext> arithOperation() {
			return getRuleContexts(ArithOperationContext.class);
		}
		public ArithOperationContext arithOperation(int i) {
			return getRuleContext(ArithOperationContext.class,i);
		}
		public Math_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterMath_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitMath_function(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitMath_function(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Math_functionContext math_function() throws RecognitionException {
		Math_functionContext _localctx = new Math_functionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_math_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(MATH_FUNCTION);
			setState(242);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(238);
				match(ID);
				}
				break;
			case DIGIT:
			case FLOAT_DIGIT:
				{
				setState(239);
				real_number();
				}
				break;
			case MATH_FUNCTION:
				{
				setState(240);
				math_function();
				}
				break;
			case UNIFORM:
				{
				setState(241);
				match(UNIFORM);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << DIGIT) | (1L << FLOAT_DIGIT) | (1L << LEFT_PAREN) | (1L << OPERATOR) | (1L << MATH_FUNCTION))) != 0)) {
				{
				{
				setState(244);
				arithOperation();
				}
				}
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(250);
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
		public TerminalNode ASSIGN() { return getToken(SpookParser.ASSIGN, 0); }
		public TerminalNode SEMICOLON() { return getToken(SpookParser.SEMICOLON, 0); }
		public BoolOperationsContext boolOperations() {
			return getRuleContext(BoolOperationsContext.class,0);
		}
		public TerminalNode TRUE() { return getToken(SpookParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SpookParser.FALSE, 0); }
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
			setState(252);
			match(BOOL);
			setState(253);
			match(ASSIGN);
			setState(257);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(254);
				boolOperations();
				}
				break;
			case 2:
				{
				setState(255);
				match(TRUE);
				}
				break;
			case 3:
				{
				setState(256);
				match(FALSE);
				}
				break;
			}
			setState(259);
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
			setState(265);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				boolOperation();
				setState(262);
				boolOperations();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
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
		public TerminalNode BOOLOPERATOR() { return getToken(SpookParser.BOOLOPERATOR, 0); }
		public List<TerminalNode> TRUE() { return getTokens(SpookParser.TRUE); }
		public TerminalNode TRUE(int i) {
			return getToken(SpookParser.TRUE, i);
		}
		public List<TerminalNode> FALSE() { return getTokens(SpookParser.FALSE); }
		public TerminalNode FALSE(int i) {
			return getToken(SpookParser.FALSE, i);
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
			setState(292);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(267);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << TRUE) | (1L << FALSE))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(268);
				match(BOOLOPERATOR);
				setState(276);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TRUE:
					{
					setState(269);
					match(TRUE);
					}
					break;
				case FALSE:
					{
					setState(270);
					match(FALSE);
					}
					break;
				case ID:
					{
					setState(271);
					match(ID);
					}
					break;
				case LEFT_PAREN:
					{
					{
					setState(272);
					match(LEFT_PAREN);
					setState(273);
					boolOperation();
					setState(274);
					match(RIGHT_PAREN);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case BOOLOPERATOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(278);
				match(BOOLOPERATOR);
				setState(286);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TRUE:
					{
					setState(279);
					match(TRUE);
					}
					break;
				case FALSE:
					{
					setState(280);
					match(FALSE);
					}
					break;
				case ID:
					{
					setState(281);
					match(ID);
					}
					break;
				case LEFT_PAREN:
					{
					{
					setState(282);
					match(LEFT_PAREN);
					setState(283);
					boolOperation();
					setState(284);
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
				setState(288);
				match(LEFT_PAREN);
				setState(289);
				boolOperation();
				setState(290);
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

	public static class Vector2DeclContext extends ParserRuleContext {
		public TerminalNode VECTOR2() { return getToken(SpookParser.VECTOR2, 0); }
		public TerminalNode ID() { return getToken(SpookParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(SpookParser.ASSIGN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SpookParser.LEFT_PAREN, 0); }
		public List<Real_numberContext> real_number() {
			return getRuleContexts(Real_numberContext.class);
		}
		public Real_numberContext real_number(int i) {
			return getRuleContext(Real_numberContext.class,i);
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
		enterRule(_localctx, 48, RULE_vector2Decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(VECTOR2);
			setState(295);
			match(ID);
			setState(296);
			match(ASSIGN);
			setState(297);
			match(LEFT_PAREN);
			setState(298);
			real_number();
			setState(299);
			match(COMMA);
			setState(300);
			real_number();
			setState(301);
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
		public List<Real_numberContext> real_number() {
			return getRuleContexts(Real_numberContext.class);
		}
		public Real_numberContext real_number(int i) {
			return getRuleContext(Real_numberContext.class,i);
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
		enterRule(_localctx, 50, RULE_vector3Decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			match(VECTOR3);
			setState(304);
			match(ID);
			setState(305);
			match(ASSIGN);
			setState(306);
			match(LEFT_PAREN);
			setState(307);
			real_number();
			setState(308);
			match(COMMA);
			setState(309);
			real_number();
			setState(310);
			match(COMMA);
			setState(311);
			real_number();
			setState(312);
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
		public List<Real_numberContext> real_number() {
			return getRuleContexts(Real_numberContext.class);
		}
		public Real_numberContext real_number(int i) {
			return getRuleContext(Real_numberContext.class,i);
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
		enterRule(_localctx, 52, RULE_vector4Decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(VECTOR4);
			setState(315);
			match(ID);
			setState(316);
			match(ASSIGN);
			setState(317);
			match(LEFT_PAREN);
			setState(318);
			real_number();
			setState(319);
			match(COMMA);
			setState(320);
			real_number();
			setState(321);
			match(COMMA);
			setState(322);
			real_number();
			setState(323);
			match(COMMA);
			setState(324);
			real_number();
			setState(325);
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

	public static class Real_numberContext extends ParserRuleContext {
		public DigitContext digit() {
			return getRuleContext(DigitContext.class,0);
		}
		public Float_digitContext float_digit() {
			return getRuleContext(Float_digitContext.class,0);
		}
		public Real_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_real_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterReal_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitReal_number(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitReal_number(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Real_numberContext real_number() throws RecognitionException {
		Real_numberContext _localctx = new Real_numberContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_real_number);
		try {
			setState(329);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIGIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(327);
				digit();
				}
				break;
			case FLOAT_DIGIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(328);
				float_digit();
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

	public static class DigitContext extends ParserRuleContext {
		public TerminalNode DIGIT() { return getToken(SpookParser.DIGIT, 0); }
		public DigitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_digit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterDigit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitDigit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitDigit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DigitContext digit() throws RecognitionException {
		DigitContext _localctx = new DigitContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_digit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			match(DIGIT);
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

	public static class Float_digitContext extends ParserRuleContext {
		public TerminalNode FLOAT_DIGIT() { return getToken(SpookParser.FLOAT_DIGIT, 0); }
		public Float_digitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_float_digit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).enterFloat_digit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookParserListener ) ((SpookParserListener)listener).exitFloat_digit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookParserVisitor ) return ((SpookParserVisitor<? extends T>)visitor).visitFloat_digit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Float_digitContext float_digit() throws RecognitionException {
		Float_digitContext _localctx = new Float_digitContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_float_digit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			match(FLOAT_DIGIT);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u0152\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\2\3\2\7\2C\n\2\f\2\16\2F\13\2\3\3\3\3\3\3\3\3\7\3L\n\3\f\3\16\3O\13\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\5\4W\n\4\3\5\3\5\3\5\3\5\5\5]\n\5\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\7\7f\n\7\f\7\16\7i\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\5\tx\n\t\3\n\3\n\3\n\5\n}\n\n\3\n\3\n\3\n\3\n\5"+
		"\n\u0083\n\n\5\n\u0085\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0096\n\13\3\f\3\f\3\f\3\f\7\f\u009c"+
		"\n\f\f\f\16\f\u009f\13\f\3\f\3\f\3\f\7\f\u00a4\n\f\f\f\16\f\u00a7\13\f"+
		"\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u00b8\n\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\5\22\u00c1\n\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\5\23\u00c9\n\23\3\24\3\24\3\24\3\24\5\24"+
		"\u00cf\n\24\3\25\3\25\3\25\5\25\u00d4\n\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\5\25\u00de\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u00e8\n\25\3\25\3\25\3\25\3\25\5\25\u00ee\n\25\3\26\3\26\3\26\3"+
		"\26\3\26\5\26\u00f5\n\26\3\26\7\26\u00f8\n\26\f\26\16\26\u00fb\13\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\27\3\27\5\27\u0104\n\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\5\30\u010c\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\5\31\u0117\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0121\n"+
		"\31\3\31\3\31\3\31\3\31\5\31\u0127\n\31\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35"+
		"\3\35\5\35\u014c\n\35\3\36\3\36\3\37\3\37\3\37\2\2 \2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<\2\4\3\2\13\17\4\2\21\21"+
		"\24\25\2\u0169\2>\3\2\2\2\4G\3\2\2\2\6V\3\2\2\2\b\\\3\2\2\2\n^\3\2\2\2"+
		"\f`\3\2\2\2\16l\3\2\2\2\20w\3\2\2\2\22\u0084\3\2\2\2\24\u0095\3\2\2\2"+
		"\26\u0097\3\2\2\2\30\u00aa\3\2\2\2\32\u00ac\3\2\2\2\34\u00ae\3\2\2\2\36"+
		"\u00b0\3\2\2\2 \u00b7\3\2\2\2\"\u00bb\3\2\2\2$\u00c2\3\2\2\2&\u00ce\3"+
		"\2\2\2(\u00ed\3\2\2\2*\u00ef\3\2\2\2,\u00fe\3\2\2\2.\u010b\3\2\2\2\60"+
		"\u0126\3\2\2\2\62\u0128\3\2\2\2\64\u0131\3\2\2\2\66\u013c\3\2\2\28\u014b"+
		"\3\2\2\2:\u014d\3\2\2\2<\u014f\3\2\2\2>D\5\4\3\2?C\5\n\6\2@C\5\f\7\2A"+
		"C\5\26\f\2B?\3\2\2\2B@\3\2\2\2BA\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2"+
		"E\3\3\2\2\2FD\3\2\2\2GH\7\3\2\2HM\7\31\2\2IL\5\6\4\2JL\5\n\6\2KI\3\2\2"+
		"\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2\2\2OM\3\2\2\2PQ\7\32"+
		"\2\2Q\5\3\2\2\2RS\5\b\5\2ST\5\6\4\2TW\3\2\2\2UW\5\b\5\2VR\3\2\2\2VU\3"+
		"\2\2\2W\7\3\2\2\2X]\5 \21\2Y]\5,\27\2Z]\5\16\b\2[]\5\24\13\2\\X\3\2\2"+
		"\2\\Y\3\2\2\2\\Z\3\2\2\2\\[\3\2\2\2]\t\3\2\2\2^_\7#\2\2_\13\3\2\2\2`a"+
		"\7\4\2\2ab\7\21\2\2bg\7\31\2\2cf\5 \21\2df\5\26\f\2ec\3\2\2\2ed\3\2\2"+
		"\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2hj\3\2\2\2ig\3\2\2\2jk\7\32\2\2k\r\3\2"+
		"\2\2lm\5\32\16\2mn\7\21\2\2no\7\30\2\2op\7\33\2\2pq\5\20\t\2qr\7\34\2"+
		"\2r\17\3\2\2\2st\5\22\n\2tu\5\20\t\2ux\3\2\2\2vx\5\22\n\2ws\3\2\2\2wv"+
		"\3\2\2\2x\21\3\2\2\2y}\7\21\2\2z}\58\35\2{}\5(\25\2|y\3\2\2\2|z\3\2\2"+
		"\2|{\3\2\2\2}~\3\2\2\2~\u0085\7\36\2\2\177\u0083\7\21\2\2\u0080\u0083"+
		"\58\35\2\u0081\u0083\5(\25\2\u0082\177\3\2\2\2\u0082\u0080\3\2\2\2\u0082"+
		"\u0081\3\2\2\2\u0083\u0085\3\2\2\2\u0084|\3\2\2\2\u0084\u0082\3\2\2\2"+
		"\u0085\23\3\2\2\2\u0086\u0087\5\34\17\2\u0087\u0088\7\35\2\2\u0088\u0089"+
		"\5\36\20\2\u0089\u008a\7\30\2\2\u008a\u008b\7\33\2\2\u008b\u008c\5\20"+
		"\t\2\u008c\u008d\7\34\2\2\u008d\u0096\3\2\2\2\u008e\u008f\5\34\17\2\u008f"+
		"\u0090\7\35\2\2\u0090\u0091\5\36\20\2\u0091\u0092\7\33\2\2\u0092\u0093"+
		"\5\20\t\2\u0093\u0094\7\34\2\2\u0094\u0096\3\2\2\2\u0095\u0086\3\2\2\2"+
		"\u0095\u008e\3\2\2\2\u0096\25\3\2\2\2\u0097\u0098\5\30\r\2\u0098\u0099"+
		"\7\21\2\2\u0099\u009d\7\33\2\2\u009a\u009c\7\5\2\2\u009b\u009a\3\2\2\2"+
		"\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a0"+
		"\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a1\7\34\2\2\u00a1\u00a5\7\31\2\2"+
		"\u00a2\u00a4\5\b\5\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3"+
		"\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8"+
		"\u00a9\7\32\2\2\u00a9\27\3\2\2\2\u00aa\u00ab\7\20\2\2\u00ab\31\3\2\2\2"+
		"\u00ac\u00ad\t\2\2\2\u00ad\33\3\2\2\2\u00ae\u00af\7\21\2\2\u00af\35\3"+
		"\2\2\2\u00b0\u00b1\7\21\2\2\u00b1\37\3\2\2\2\u00b2\u00b8\5\"\22\2\u00b3"+
		"\u00b8\5$\23\2\u00b4\u00b8\5\62\32\2\u00b5\u00b8\5\64\33\2\u00b6\u00b8"+
		"\5\66\34\2\u00b7\u00b2\3\2\2\2\u00b7\u00b3\3\2\2\2\u00b7\u00b4\3\2\2\2"+
		"\u00b7\u00b5\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba"+
		"\7\26\2\2\u00ba!\3\2\2\2\u00bb\u00bc\7\5\2\2\u00bc\u00bd\7\21\2\2\u00bd"+
		"\u00c0\7\30\2\2\u00be\u00c1\5&\24\2\u00bf\u00c1\5:\36\2\u00c0\u00be\3"+
		"\2\2\2\u00c0\u00bf\3\2\2\2\u00c1#\3\2\2\2\u00c2\u00c3\7\6\2\2\u00c3\u00c4"+
		"\7\21\2\2\u00c4\u00c8\7\30\2\2\u00c5\u00c9\5&\24\2\u00c6\u00c9\5*\26\2"+
		"\u00c7\u00c9\58\35\2\u00c8\u00c5\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c7"+
		"\3\2\2\2\u00c9%\3\2\2\2\u00ca\u00cb\5(\25\2\u00cb\u00cc\5&\24\2\u00cc"+
		"\u00cf\3\2\2\2\u00cd\u00cf\5(\25\2\u00ce\u00ca\3\2\2\2\u00ce\u00cd\3\2"+
		"\2\2\u00cf\'\3\2\2\2\u00d0\u00d4\58\35\2\u00d1\u00d4\5*\26\2\u00d2\u00d4"+
		"\7\21\2\2\u00d3\u00d0\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d2\3\2\2\2"+
		"\u00d4\u00d5\3\2\2\2\u00d5\u00dd\7 \2\2\u00d6\u00de\58\35\2\u00d7\u00de"+
		"\5*\26\2\u00d8\u00de\7\21\2\2\u00d9\u00da\7\33\2\2\u00da\u00db\5(\25\2"+
		"\u00db\u00dc\7\34\2\2\u00dc\u00de\3\2\2\2\u00dd\u00d6\3\2\2\2\u00dd\u00d7"+
		"\3\2\2\2\u00dd\u00d8\3\2\2\2\u00dd\u00d9\3\2\2\2\u00de\u00ee\3\2\2\2\u00df"+
		"\u00e7\7 \2\2\u00e0\u00e8\58\35\2\u00e1\u00e8\5*\26\2\u00e2\u00e8\7\21"+
		"\2\2\u00e3\u00e4\7\33\2\2\u00e4\u00e5\5(\25\2\u00e5\u00e6\7\34\2\2\u00e6"+
		"\u00e8\3\2\2\2\u00e7\u00e0\3\2\2\2\u00e7\u00e1\3\2\2\2\u00e7\u00e2\3\2"+
		"\2\2\u00e7\u00e3\3\2\2\2\u00e8\u00ee\3\2\2\2\u00e9\u00ea\7\33\2\2\u00ea"+
		"\u00eb\5&\24\2\u00eb\u00ec\7\34\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00d3\3"+
		"\2\2\2\u00ed\u00df\3\2\2\2\u00ed\u00e9\3\2\2\2\u00ee)\3\2\2\2\u00ef\u00f4"+
		"\7!\2\2\u00f0\u00f5\7\21\2\2\u00f1\u00f5\58\35\2\u00f2\u00f5\5*\26\2\u00f3"+
		"\u00f5\7\"\2\2\u00f4\u00f0\3\2\2\2\u00f4\u00f1\3\2\2\2\u00f4\u00f2\3\2"+
		"\2\2\u00f4\u00f3\3\2\2\2\u00f5\u00f9\3\2\2\2\u00f6\u00f8\5(\25\2\u00f7"+
		"\u00f6\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2"+
		"\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fd\7\34\2\2\u00fd"+
		"+\3\2\2\2\u00fe\u00ff\7\7\2\2\u00ff\u0103\7\30\2\2\u0100\u0104\5.\30\2"+
		"\u0101\u0104\7\24\2\2\u0102\u0104\7\25\2\2\u0103\u0100\3\2\2\2\u0103\u0101"+
		"\3\2\2\2\u0103\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0106\7\26\2\2"+
		"\u0106-\3\2\2\2\u0107\u0108\5\60\31\2\u0108\u0109\5.\30\2\u0109\u010c"+
		"\3\2\2\2\u010a\u010c\5\60\31\2\u010b\u0107\3\2\2\2\u010b\u010a\3\2\2\2"+
		"\u010c/\3\2\2\2\u010d\u010e\t\3\2\2\u010e\u0116\7\37\2\2\u010f\u0117\7"+
		"\24\2\2\u0110\u0117\7\25\2\2\u0111\u0117\7\21\2\2\u0112\u0113\7\33\2\2"+
		"\u0113\u0114\5\60\31\2\u0114\u0115\7\34\2\2\u0115\u0117\3\2\2\2\u0116"+
		"\u010f\3\2\2\2\u0116\u0110\3\2\2\2\u0116\u0111\3\2\2\2\u0116\u0112\3\2"+
		"\2\2\u0117\u0127\3\2\2\2\u0118\u0120\7\37\2\2\u0119\u0121\7\24\2\2\u011a"+
		"\u0121\7\25\2\2\u011b\u0121\7\21\2\2\u011c\u011d\7\33\2\2\u011d\u011e"+
		"\5\60\31\2\u011e\u011f\7\34\2\2\u011f\u0121\3\2\2\2\u0120\u0119\3\2\2"+
		"\2\u0120\u011a\3\2\2\2\u0120\u011b\3\2\2\2\u0120\u011c\3\2\2\2\u0121\u0127"+
		"\3\2\2\2\u0122\u0123\7\33\2\2\u0123\u0124\5\60\31\2\u0124\u0125\7\34\2"+
		"\2\u0125\u0127\3\2\2\2\u0126\u010d\3\2\2\2\u0126\u0118\3\2\2\2\u0126\u0122"+
		"\3\2\2\2\u0127\61\3\2\2\2\u0128\u0129\7\b\2\2\u0129\u012a\7\21\2\2\u012a"+
		"\u012b\7\30\2\2\u012b\u012c\7\33\2\2\u012c\u012d\58\35\2\u012d\u012e\7"+
		"\36\2\2\u012e\u012f\58\35\2\u012f\u0130\7\34\2\2\u0130\63\3\2\2\2\u0131"+
		"\u0132\7\t\2\2\u0132\u0133\7\21\2\2\u0133\u0134\7\30\2\2\u0134\u0135\7"+
		"\33\2\2\u0135\u0136\58\35\2\u0136\u0137\7\36\2\2\u0137\u0138\58\35\2\u0138"+
		"\u0139\7\36\2\2\u0139\u013a\58\35\2\u013a\u013b\7\34\2\2\u013b\65\3\2"+
		"\2\2\u013c\u013d\7\n\2\2\u013d\u013e\7\21\2\2\u013e\u013f\7\30\2\2\u013f"+
		"\u0140\7\33\2\2\u0140\u0141\58\35\2\u0141\u0142\7\36\2\2\u0142\u0143\5"+
		"8\35\2\u0143\u0144\7\36\2\2\u0144\u0145\58\35\2\u0145\u0146\7\36\2\2\u0146"+
		"\u0147\58\35\2\u0147\u0148\7\34\2\2\u0148\67\3\2\2\2\u0149\u014c\5:\36"+
		"\2\u014a\u014c\5<\37\2\u014b\u0149\3\2\2\2\u014b\u014a\3\2\2\2\u014c9"+
		"\3\2\2\2\u014d\u014e\7\22\2\2\u014e;\3\2\2\2\u014f\u0150\7\23\2\2\u0150"+
		"=\3\2\2\2!BDKMV\\egw|\u0082\u0084\u0095\u009d\u00a5\u00b7\u00c0\u00c8"+
		"\u00ce\u00d3\u00dd\u00e7\u00ed\u00f4\u00f9\u0103\u010b\u0116\u0120\u0126"+
		"\u014b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}