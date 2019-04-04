// Generated from D:/GitHub/P4/src\Spook.g4 by ANTLR 4.7.2
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		LETTER=18, STRING=19, DIGIT=20, FLOAT_DIGIT=21, SEMICOLON=22, NEWLINE=23, 
		DOUBLE_SLASH=24, SPACE=25, ASSIGN=26, BOOLOPERATOR=27, OPERATOR=28, MATH_FUNCTION=29, 
		UNIFORM=30;
	public static final int
		RULE_program = 0, RULE_main = 1, RULE_declarations = 2, RULE_declaration = 3, 
		RULE_comment = 4, RULE_classDecl = 5, RULE_functionDecl = 6, RULE_returnType = 7, 
		RULE_dataType = 8, RULE_vectorType = 9, RULE_variable = 10, RULE_numberDecl = 11, 
		RULE_integerDecl = 12, RULE_floatDecl = 13, RULE_boolDecl = 14, RULE_boolOperation = 15, 
		RULE_vector2Decl = 16, RULE_vector3Decl = 17, RULE_vector4Decl = 18, RULE_dataTypeVariable = 19, 
		RULE_arithOperation = 20, RULE_math_function = 21, RULE_space = 22, RULE_real_number = 23, 
		RULE_digit = 24, RULE_float_digit = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main", "declarations", "declaration", "comment", "classDecl", 
			"functionDecl", "returnType", "dataType", "vectorType", "variable", "numberDecl", 
			"integerDecl", "floatDecl", "boolDecl", "boolOperation", "vector2Decl", 
			"vector3Decl", "vector4Decl", "dataTypeVariable", "arithOperation", "math_function", 
			"space", "real_number", "digit", "float_digit"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Shader {'", "'}'", "'#'", "'class'", "'{'", "'('", "')'", "'void'", 
			"'int'", "'float'", "'vector2'", "'vector3'", "'vector4'", "'boolean'", 
			"'true'", "'false'", "','", null, null, null, null, "';'", "'\n'", "'//'", 
			"' '", null, null, null, null, "'Time'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "LETTER", "STRING", "DIGIT", "FLOAT_DIGIT", 
			"SEMICOLON", "NEWLINE", "DOUBLE_SLASH", "SPACE", "ASSIGN", "BOOLOPERATOR", 
			"OPERATOR", "MATH_FUNCTION", "UNIFORM"
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
	public String getGrammarFileName() { return "Spook.g4"; }

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
		public List<TerminalNode> NEWLINE() { return getTokens(SpookParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SpookParser.NEWLINE, i);
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
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(52);
			main();
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << NEWLINE))) != 0)) {
				{
				setState(57);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NEWLINE:
					{
					setState(53);
					match(NEWLINE);
					}
					break;
				case T__2:
					{
					setState(54);
					comment();
					}
					break;
				case T__3:
					{
					setState(55);
					classDecl();
					}
					break;
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
					{
					setState(56);
					functionDecl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(61);
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
		public List<TerminalNode> NEWLINE() { return getTokens(SpookParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SpookParser.NEWLINE, i);
		}
		public List<SpaceContext> space() {
			return getRuleContexts(SpaceContext.class);
		}
		public SpaceContext space(int i) {
			return getRuleContext(SpaceContext.class,i);
		}
		public List<DeclarationsContext> declarations() {
			return getRuleContexts(DeclarationsContext.class);
		}
		public DeclarationsContext declarations(int i) {
			return getRuleContext(DeclarationsContext.class,i);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitMain(this);
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
			setState(62);
			match(T__0);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << NEWLINE) | (1L << SPACE))) != 0)) {
				{
				setState(66);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(63);
					match(NEWLINE);
					}
					break;
				case 2:
					{
					setState(64);
					space();
					}
					break;
				case 3:
					{
					setState(65);
					declarations();
					}
					break;
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
			match(T__1);
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
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declarations);
		try {
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				declaration();
				setState(74);
				declarations();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
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
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public NumberDeclContext numberDecl() {
			return getRuleContext(NumberDeclContext.class,0);
		}
		public BoolDeclContext boolDecl() {
			return getRuleContext(BoolDeclContext.class,0);
		}
		public List<SpaceContext> space() {
			return getRuleContexts(SpaceContext.class);
		}
		public SpaceContext space(int i) {
			return getRuleContext(SpaceContext.class,i);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(79);
				space();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				setState(85);
				comment();
				}
				break;
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
				{
				setState(86);
				numberDecl();
				}
				break;
			case T__13:
				{
				setState(87);
				boolDecl();
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
		public List<TerminalNode> LETTER() { return getTokens(SpookParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(SpookParser.LETTER, i);
		}
		public List<TerminalNode> STRING() { return getTokens(SpookParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(SpookParser.STRING, i);
		}
		public List<TerminalNode> SPACE() { return getTokens(SpookParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(SpookParser.SPACE, i);
		}
		public List<DigitContext> digit() {
			return getRuleContexts(DigitContext.class);
		}
		public DigitContext digit(int i) {
			return getRuleContext(DigitContext.class,i);
		}
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_comment);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(T__2);
			setState(97);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(95);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LETTER:
						{
						setState(91);
						match(LETTER);
						}
						break;
					case STRING:
						{
						setState(92);
						match(STRING);
						}
						break;
					case SPACE:
						{
						setState(93);
						match(SPACE);
						}
						break;
					case DIGIT:
						{
						setState(94);
						digit();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(99);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class ClassDeclContext extends ParserRuleContext {
		public List<SpaceContext> space() {
			return getRuleContexts(SpaceContext.class);
		}
		public SpaceContext space(int i) {
			return getRuleContext(SpaceContext.class,i);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SpookParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SpookParser.NEWLINE, i);
		}
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
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterClassDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitClassDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitClassDecl(this);
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
			match(T__3);
			setState(101);
			space();
			setState(102);
			variable();
			setState(103);
			space();
			setState(104);
			match(T__4);
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << NEWLINE) | (1L << SPACE))) != 0)) {
				{
				setState(109);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(105);
					space();
					}
					break;
				case 2:
					{
					setState(106);
					match(NEWLINE);
					}
					break;
				case 3:
					{
					setState(107);
					numberDecl();
					}
					break;
				case 4:
					{
					setState(108);
					functionDecl();
					}
					break;
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(114);
			match(T__1);
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
		public List<SpaceContext> space() {
			return getRuleContexts(SpaceContext.class);
		}
		public SpaceContext space(int i) {
			return getRuleContext(SpaceContext.class,i);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public List<DataTypeVariableContext> dataTypeVariable() {
			return getRuleContexts(DataTypeVariableContext.class);
		}
		public DataTypeVariableContext dataTypeVariable(int i) {
			return getRuleContext(DataTypeVariableContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SpookParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SpookParser.NEWLINE, i);
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
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitFunctionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			returnType();
			setState(117);
			space();
			setState(118);
			variable();
			setState(119);
			match(T__5);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) {
				{
				{
				setState(120);
				dataTypeVariable();
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
			match(T__6);
			setState(127);
			space();
			setState(128);
			match(T__4);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << NEWLINE) | (1L << SPACE))) != 0)) {
				{
				setState(132);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(129);
					space();
					}
					break;
				case 2:
					{
					setState(130);
					match(NEWLINE);
					}
					break;
				case 3:
					{
					setState(131);
					declaration();
					}
					break;
				}
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(137);
			match(T__1);
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
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterReturnType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitReturnType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitReturnType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_returnType);
		try {
			setState(141);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				match(T__7);
				}
				break;
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
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

	public static class DataTypeContext extends ParserRuleContext {
		public VectorTypeContext vectorType() {
			return getRuleContext(VectorTypeContext.class,0);
		}
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitDataType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_dataType);
		try {
			setState(146);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				match(T__8);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				match(T__9);
				}
				break;
			case T__10:
			case T__11:
			case T__12:
				enterOuterAlt(_localctx, 3);
				{
				setState(145);
				vectorType();
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

	public static class VectorTypeContext extends ParserRuleContext {
		public VectorTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vectorType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterVectorType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitVectorType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitVectorType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VectorTypeContext vectorType() throws RecognitionException {
		VectorTypeContext _localctx = new VectorTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_vectorType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) ) {
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

	public static class VariableContext extends ParserRuleContext {
		public List<TerminalNode> LETTER() { return getTokens(SpookParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(SpookParser.LETTER, i);
		}
		public List<TerminalNode> STRING() { return getTokens(SpookParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(SpookParser.STRING, i);
		}
		public List<SpaceContext> space() {
			return getRuleContexts(SpaceContext.class);
		}
		public SpaceContext space(int i) {
			return getRuleContext(SpaceContext.class,i);
		}
		public List<DigitContext> digit() {
			return getRuleContexts(DigitContext.class);
		}
		public DigitContext digit(int i) {
			return getRuleContext(DigitContext.class,i);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_variable);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(154);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LETTER:
						{
						setState(150);
						match(LETTER);
						}
						break;
					case STRING:
						{
						setState(151);
						match(STRING);
						}
						break;
					case SPACE:
						{
						setState(152);
						space();
						}
						break;
					case DIGIT:
						{
						setState(153);
						digit();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(158);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterNumberDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitNumberDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitNumberDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberDeclContext numberDecl() throws RecognitionException {
		NumberDeclContext _localctx = new NumberDeclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_numberDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(159);
				integerDecl();
				}
				break;
			case 2:
				{
				setState(160);
				floatDecl();
				}
				break;
			case 3:
				{
				setState(161);
				vector2Decl();
				}
				break;
			case 4:
				{
				setState(162);
				vector3Decl();
				}
				break;
			case 5:
				{
				setState(163);
				vector4Decl();
				}
				break;
			}
			setState(166);
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
		public DataTypeVariableContext dataTypeVariable() {
			return getRuleContext(DataTypeVariableContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SpookParser.ASSIGN, 0); }
		public DigitContext digit() {
			return getRuleContext(DigitContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public IntegerDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterIntegerDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitIntegerDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitIntegerDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerDeclContext integerDecl() throws RecognitionException {
		IntegerDeclContext _localctx = new IntegerDeclContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_integerDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			dataTypeVariable();
			setState(169);
			match(ASSIGN);
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(170);
				digit();
				}
				break;
			case 2:
				{
				setState(171);
				variable();
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
		public DataTypeVariableContext dataTypeVariable() {
			return getRuleContext(DataTypeVariableContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SpookParser.ASSIGN, 0); }
		public List<ArithOperationContext> arithOperation() {
			return getRuleContexts(ArithOperationContext.class);
		}
		public ArithOperationContext arithOperation(int i) {
			return getRuleContext(ArithOperationContext.class,i);
		}
		public FloatDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterFloatDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitFloatDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitFloatDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FloatDeclContext floatDecl() throws RecognitionException {
		FloatDeclContext _localctx = new FloatDeclContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_floatDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			dataTypeVariable();
			setState(175);
			match(ASSIGN);
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				setState(176);
				match(T__5);
				setState(177);
				arithOperation();
				setState(178);
				match(T__6);
				}
				break;
			case LETTER:
			case STRING:
			case DIGIT:
			case FLOAT_DIGIT:
			case SPACE:
			case OPERATOR:
			case MATH_FUNCTION:
				{
				setState(180);
				arithOperation();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LETTER) | (1L << STRING) | (1L << DIGIT) | (1L << FLOAT_DIGIT) | (1L << SPACE) | (1L << OPERATOR) | (1L << MATH_FUNCTION))) != 0)) {
				{
				{
				setState(183);
				arithOperation();
				}
				}
				setState(188);
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

	public static class BoolDeclContext extends ParserRuleContext {
		public SpaceContext space() {
			return getRuleContext(SpaceContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SpookParser.ASSIGN, 0); }
		public TerminalNode SEMICOLON() { return getToken(SpookParser.SEMICOLON, 0); }
		public List<BoolOperationContext> boolOperation() {
			return getRuleContexts(BoolOperationContext.class);
		}
		public BoolOperationContext boolOperation(int i) {
			return getRuleContext(BoolOperationContext.class,i);
		}
		public BoolDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterBoolDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitBoolDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitBoolDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolDeclContext boolDecl() throws RecognitionException {
		BoolDeclContext _localctx = new BoolDeclContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_boolDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(T__13);
			setState(190);
			space();
			setState(191);
			variable();
			setState(192);
			match(ASSIGN);
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(193);
				match(T__14);
				}
				break;
			case 2:
				{
				setState(194);
				match(T__15);
				}
				break;
			case 3:
				{
				setState(195);
				match(T__5);
				setState(196);
				boolOperation();
				setState(197);
				match(T__6);
				}
				break;
			case 4:
				{
				setState(199);
				boolOperation();
				}
				break;
			}
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << LETTER) | (1L << STRING) | (1L << DIGIT) | (1L << SPACE) | (1L << BOOLOPERATOR))) != 0)) {
				{
				{
				setState(202);
				boolOperation();
				}
				}
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(208);
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

	public static class BoolOperationContext extends ParserRuleContext {
		public TerminalNode BOOLOPERATOR() { return getToken(SpookParser.BOOLOPERATOR, 0); }
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public BoolOperationContext boolOperation() {
			return getRuleContext(BoolOperationContext.class,0);
		}
		public BoolOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterBoolOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitBoolOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitBoolOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolOperationContext boolOperation() throws RecognitionException {
		BoolOperationContext _localctx = new BoolOperationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_boolOperation);
		try {
			setState(235);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__14:
					{
					setState(210);
					match(T__14);
					}
					break;
				case T__15:
					{
					setState(211);
					match(T__15);
					}
					break;
				case LETTER:
				case STRING:
				case DIGIT:
				case SPACE:
				case BOOLOPERATOR:
					{
					setState(212);
					variable();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(215);
				match(BOOLOPERATOR);
				setState(223);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(216);
					variable();
					}
					break;
				case 2:
					{
					setState(217);
					match(T__14);
					}
					break;
				case 3:
					{
					setState(218);
					match(T__15);
					}
					break;
				case 4:
					{
					{
					setState(219);
					match(T__5);
					setState(220);
					boolOperation();
					setState(221);
					match(T__6);
					}
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
				match(BOOLOPERATOR);
				setState(233);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(226);
					variable();
					}
					break;
				case 2:
					{
					setState(227);
					match(T__14);
					}
					break;
				case 3:
					{
					setState(228);
					match(T__15);
					}
					break;
				case 4:
					{
					{
					setState(229);
					match(T__5);
					setState(230);
					boolOperation();
					setState(231);
					match(T__6);
					}
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

	public static class Vector2DeclContext extends ParserRuleContext {
		public List<SpaceContext> space() {
			return getRuleContexts(SpaceContext.class);
		}
		public SpaceContext space(int i) {
			return getRuleContext(SpaceContext.class,i);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SpookParser.ASSIGN, 0); }
		public List<Real_numberContext> real_number() {
			return getRuleContexts(Real_numberContext.class);
		}
		public Real_numberContext real_number(int i) {
			return getRuleContext(Real_numberContext.class,i);
		}
		public Vector2DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector2Decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterVector2Decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitVector2Decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitVector2Decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Vector2DeclContext vector2Decl() throws RecognitionException {
		Vector2DeclContext _localctx = new Vector2DeclContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_vector2Decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(T__10);
			setState(238);
			space();
			setState(239);
			variable();
			setState(240);
			match(ASSIGN);
			setState(241);
			match(T__5);
			setState(242);
			real_number();
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(243);
				space();
				}
				}
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(249);
			match(T__16);
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(250);
				space();
				}
				}
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(256);
			real_number();
			setState(257);
			match(T__6);
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
		public List<SpaceContext> space() {
			return getRuleContexts(SpaceContext.class);
		}
		public SpaceContext space(int i) {
			return getRuleContext(SpaceContext.class,i);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SpookParser.ASSIGN, 0); }
		public List<Real_numberContext> real_number() {
			return getRuleContexts(Real_numberContext.class);
		}
		public Real_numberContext real_number(int i) {
			return getRuleContext(Real_numberContext.class,i);
		}
		public Vector3DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector3Decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterVector3Decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitVector3Decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitVector3Decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Vector3DeclContext vector3Decl() throws RecognitionException {
		Vector3DeclContext _localctx = new Vector3DeclContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_vector3Decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(T__11);
			setState(260);
			space();
			setState(261);
			variable();
			setState(262);
			match(ASSIGN);
			setState(263);
			match(T__5);
			setState(264);
			real_number();
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(265);
				space();
				}
				}
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(271);
			match(T__16);
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(272);
				space();
				}
				}
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(278);
			real_number();
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(279);
				space();
				}
				}
				setState(284);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(285);
			match(T__16);
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(286);
				space();
				}
				}
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(292);
			real_number();
			setState(293);
			match(T__6);
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
		public List<SpaceContext> space() {
			return getRuleContexts(SpaceContext.class);
		}
		public SpaceContext space(int i) {
			return getRuleContext(SpaceContext.class,i);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SpookParser.ASSIGN, 0); }
		public List<Real_numberContext> real_number() {
			return getRuleContexts(Real_numberContext.class);
		}
		public Real_numberContext real_number(int i) {
			return getRuleContext(Real_numberContext.class,i);
		}
		public Vector4DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector4Decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterVector4Decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitVector4Decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitVector4Decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Vector4DeclContext vector4Decl() throws RecognitionException {
		Vector4DeclContext _localctx = new Vector4DeclContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_vector4Decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			match(T__12);
			setState(296);
			space();
			setState(297);
			variable();
			setState(298);
			match(ASSIGN);
			setState(299);
			match(T__5);
			setState(300);
			real_number();
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(301);
				space();
				}
				}
				setState(306);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(307);
			match(T__16);
			setState(311);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(308);
				space();
				}
				}
				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(314);
			real_number();
			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(315);
				space();
				}
				}
				setState(320);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(321);
			match(T__16);
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(322);
				space();
				}
				}
				setState(327);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(328);
			real_number();
			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(329);
				space();
				}
				}
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(335);
			match(T__16);
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(336);
				space();
				}
				}
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(342);
			real_number();
			setState(343);
			match(T__6);
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

	public static class DataTypeVariableContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public SpaceContext space() {
			return getRuleContext(SpaceContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public DataTypeVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataTypeVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterDataTypeVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitDataTypeVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitDataTypeVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeVariableContext dataTypeVariable() throws RecognitionException {
		DataTypeVariableContext _localctx = new DataTypeVariableContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_dataTypeVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			dataType();
			setState(346);
			space();
			setState(347);
			variable();
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
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public ArithOperationContext arithOperation() {
			return getRuleContext(ArithOperationContext.class,0);
		}
		public ArithOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterArithOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitArithOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitArithOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithOperationContext arithOperation() throws RecognitionException {
		ArithOperationContext _localctx = new ArithOperationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_arithOperation);
		try {
			setState(374);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(352);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
				case 1:
					{
					setState(349);
					real_number();
					}
					break;
				case 2:
					{
					setState(350);
					math_function();
					}
					break;
				case 3:
					{
					setState(351);
					variable();
					}
					break;
				}
				setState(354);
				match(OPERATOR);
				setState(362);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					setState(355);
					real_number();
					}
					break;
				case 2:
					{
					setState(356);
					math_function();
					}
					break;
				case 3:
					{
					setState(357);
					variable();
					}
					break;
				case 4:
					{
					setState(358);
					match(T__5);
					setState(359);
					arithOperation();
					setState(360);
					match(T__6);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(364);
				match(OPERATOR);
				setState(372);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(365);
					real_number();
					}
					break;
				case 2:
					{
					setState(366);
					math_function();
					}
					break;
				case 3:
					{
					setState(367);
					variable();
					}
					break;
				case 4:
					{
					setState(368);
					match(T__5);
					setState(369);
					arithOperation();
					setState(370);
					match(T__6);
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

	public static class Math_functionContext extends ParserRuleContext {
		public TerminalNode MATH_FUNCTION() { return getToken(SpookParser.MATH_FUNCTION, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
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
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterMath_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitMath_function(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitMath_function(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Math_functionContext math_function() throws RecognitionException {
		Math_functionContext _localctx = new Math_functionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_math_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			match(MATH_FUNCTION);
			setState(381);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(377);
				variable();
				}
				break;
			case 2:
				{
				setState(378);
				real_number();
				}
				break;
			case 3:
				{
				setState(379);
				math_function();
				}
				break;
			case 4:
				{
				setState(380);
				match(UNIFORM);
				}
				break;
			}
			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LETTER) | (1L << STRING) | (1L << DIGIT) | (1L << FLOAT_DIGIT) | (1L << SPACE) | (1L << OPERATOR) | (1L << MATH_FUNCTION))) != 0)) {
				{
				{
				setState(383);
				arithOperation();
				}
				}
				setState(388);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(389);
			match(T__6);
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

	public static class SpaceContext extends ParserRuleContext {
		public TerminalNode SPACE() { return getToken(SpookParser.SPACE, 0); }
		public SpaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_space; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterSpace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitSpace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitSpace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpaceContext space() throws RecognitionException {
		SpaceContext _localctx = new SpaceContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_space);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			match(SPACE);
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
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterReal_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitReal_number(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitReal_number(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Real_numberContext real_number() throws RecognitionException {
		Real_numberContext _localctx = new Real_numberContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_real_number);
		try {
			setState(395);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIGIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(393);
				digit();
				}
				break;
			case FLOAT_DIGIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(394);
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
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterDigit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitDigit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitDigit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DigitContext digit() throws RecognitionException {
		DigitContext _localctx = new DigitContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_digit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
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
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterFloat_digit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitFloat_digit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitFloat_digit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Float_digitContext float_digit() throws RecognitionException {
		Float_digitContext _localctx = new Float_digitContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_float_digit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 \u0194\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\7\2<\n\2\f\2\16\2?\13\2\3\3\3"+
		"\3\3\3\3\3\7\3E\n\3\f\3\16\3H\13\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4P\n\4\3"+
		"\5\7\5S\n\5\f\5\16\5V\13\5\3\5\3\5\3\5\5\5[\n\5\3\6\3\6\3\6\3\6\3\6\7"+
		"\6b\n\6\f\6\16\6e\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7p\n\7\f"+
		"\7\16\7s\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\7\b|\n\b\f\b\16\b\177\13\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\7\b\u0087\n\b\f\b\16\b\u008a\13\b\3\b\3\b\3\t\3"+
		"\t\5\t\u0090\n\t\3\n\3\n\3\n\5\n\u0095\n\n\3\13\3\13\3\f\3\f\3\f\3\f\7"+
		"\f\u009d\n\f\f\f\16\f\u00a0\13\f\3\r\3\r\3\r\3\r\3\r\5\r\u00a7\n\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\5\16\u00af\n\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\5\17\u00b8\n\17\3\17\7\17\u00bb\n\17\f\17\16\17\u00be\13\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00cb\n\20\3\20"+
		"\7\20\u00ce\n\20\f\20\16\20\u00d1\13\20\3\20\3\20\3\21\3\21\3\21\5\21"+
		"\u00d8\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00e2\n\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00ec\n\21\5\21\u00ee\n\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00f7\n\22\f\22\16\22\u00fa\13"+
		"\22\3\22\3\22\7\22\u00fe\n\22\f\22\16\22\u0101\13\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u010d\n\23\f\23\16\23\u0110\13"+
		"\23\3\23\3\23\7\23\u0114\n\23\f\23\16\23\u0117\13\23\3\23\3\23\7\23\u011b"+
		"\n\23\f\23\16\23\u011e\13\23\3\23\3\23\7\23\u0122\n\23\f\23\16\23\u0125"+
		"\13\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u0131\n"+
		"\24\f\24\16\24\u0134\13\24\3\24\3\24\7\24\u0138\n\24\f\24\16\24\u013b"+
		"\13\24\3\24\3\24\7\24\u013f\n\24\f\24\16\24\u0142\13\24\3\24\3\24\7\24"+
		"\u0146\n\24\f\24\16\24\u0149\13\24\3\24\3\24\7\24\u014d\n\24\f\24\16\24"+
		"\u0150\13\24\3\24\3\24\7\24\u0154\n\24\f\24\16\24\u0157\13\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\5\26\u0163\n\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\5\26\u016d\n\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\5\26\u0177\n\26\5\26\u0179\n\26\3\27\3\27\3\27\3\27\3\27\5"+
		"\27\u0180\n\27\3\27\7\27\u0183\n\27\f\27\16\27\u0186\13\27\3\27\3\27\3"+
		"\30\3\30\3\31\3\31\5\31\u018e\n\31\3\32\3\32\3\33\3\33\3\33\2\2\34\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\2\3\3\2\r\17\2\u01c5"+
		"\2\66\3\2\2\2\4@\3\2\2\2\6O\3\2\2\2\bT\3\2\2\2\n\\\3\2\2\2\ff\3\2\2\2"+
		"\16v\3\2\2\2\20\u008f\3\2\2\2\22\u0094\3\2\2\2\24\u0096\3\2\2\2\26\u009e"+
		"\3\2\2\2\30\u00a6\3\2\2\2\32\u00aa\3\2\2\2\34\u00b0\3\2\2\2\36\u00bf\3"+
		"\2\2\2 \u00ed\3\2\2\2\"\u00ef\3\2\2\2$\u0105\3\2\2\2&\u0129\3\2\2\2(\u015b"+
		"\3\2\2\2*\u0178\3\2\2\2,\u017a\3\2\2\2.\u0189\3\2\2\2\60\u018d\3\2\2\2"+
		"\62\u018f\3\2\2\2\64\u0191\3\2\2\2\66=\5\4\3\2\67<\7\31\2\28<\5\n\6\2"+
		"9<\5\f\7\2:<\5\16\b\2;\67\3\2\2\2;8\3\2\2\2;9\3\2\2\2;:\3\2\2\2<?\3\2"+
		"\2\2=;\3\2\2\2=>\3\2\2\2>\3\3\2\2\2?=\3\2\2\2@F\7\3\2\2AE\7\31\2\2BE\5"+
		".\30\2CE\5\6\4\2DA\3\2\2\2DB\3\2\2\2DC\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3"+
		"\2\2\2GI\3\2\2\2HF\3\2\2\2IJ\7\4\2\2J\5\3\2\2\2KL\5\b\5\2LM\5\6\4\2MP"+
		"\3\2\2\2NP\5\b\5\2OK\3\2\2\2ON\3\2\2\2P\7\3\2\2\2QS\5.\30\2RQ\3\2\2\2"+
		"SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UZ\3\2\2\2VT\3\2\2\2W[\5\n\6\2X[\5\30\r"+
		"\2Y[\5\36\20\2ZW\3\2\2\2ZX\3\2\2\2ZY\3\2\2\2[\t\3\2\2\2\\c\7\5\2\2]b\7"+
		"\24\2\2^b\7\25\2\2_b\7\33\2\2`b\5\62\32\2a]\3\2\2\2a^\3\2\2\2a_\3\2\2"+
		"\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\13\3\2\2\2ec\3\2\2\2fg\7\6"+
		"\2\2gh\5.\30\2hi\5\26\f\2ij\5.\30\2jq\7\7\2\2kp\5.\30\2lp\7\31\2\2mp\5"+
		"\30\r\2np\5\16\b\2ok\3\2\2\2ol\3\2\2\2om\3\2\2\2on\3\2\2\2ps\3\2\2\2q"+
		"o\3\2\2\2qr\3\2\2\2rt\3\2\2\2sq\3\2\2\2tu\7\4\2\2u\r\3\2\2\2vw\5\20\t"+
		"\2wx\5.\30\2xy\5\26\f\2y}\7\b\2\2z|\5(\25\2{z\3\2\2\2|\177\3\2\2\2}{\3"+
		"\2\2\2}~\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0081\7\t\2\2\u0081"+
		"\u0082\5.\30\2\u0082\u0088\7\7\2\2\u0083\u0087\5.\30\2\u0084\u0087\7\31"+
		"\2\2\u0085\u0087\5\b\5\2\u0086\u0083\3\2\2\2\u0086\u0084\3\2\2\2\u0086"+
		"\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2"+
		"\2\2\u0089\u008b\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c\7\4\2\2\u008c"+
		"\17\3\2\2\2\u008d\u0090\7\n\2\2\u008e\u0090\5\22\n\2\u008f\u008d\3\2\2"+
		"\2\u008f\u008e\3\2\2\2\u0090\21\3\2\2\2\u0091\u0095\7\13\2\2\u0092\u0095"+
		"\7\f\2\2\u0093\u0095\5\24\13\2\u0094\u0091\3\2\2\2\u0094\u0092\3\2\2\2"+
		"\u0094\u0093\3\2\2\2\u0095\23\3\2\2\2\u0096\u0097\t\2\2\2\u0097\25\3\2"+
		"\2\2\u0098\u009d\7\24\2\2\u0099\u009d\7\25\2\2\u009a\u009d\5.\30\2\u009b"+
		"\u009d\5\62\32\2\u009c\u0098\3\2\2\2\u009c\u0099\3\2\2\2\u009c\u009a\3"+
		"\2\2\2\u009c\u009b\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\27\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a7\5\32\16"+
		"\2\u00a2\u00a7\5\34\17\2\u00a3\u00a7\5\"\22\2\u00a4\u00a7\5$\23\2\u00a5"+
		"\u00a7\5&\24\2\u00a6\u00a1\3\2\2\2\u00a6\u00a2\3\2\2\2\u00a6\u00a3\3\2"+
		"\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\u00a9\7\30\2\2\u00a9\31\3\2\2\2\u00aa\u00ab\5(\25\2\u00ab\u00ae\7\34"+
		"\2\2\u00ac\u00af\5\62\32\2\u00ad\u00af\5\26\f\2\u00ae\u00ac\3\2\2\2\u00ae"+
		"\u00ad\3\2\2\2\u00af\33\3\2\2\2\u00b0\u00b1\5(\25\2\u00b1\u00b7\7\34\2"+
		"\2\u00b2\u00b3\7\b\2\2\u00b3\u00b4\5*\26\2\u00b4\u00b5\7\t\2\2\u00b5\u00b8"+
		"\3\2\2\2\u00b6\u00b8\5*\26\2\u00b7\u00b2\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8"+
		"\u00bc\3\2\2\2\u00b9\u00bb\5*\26\2\u00ba\u00b9\3\2\2\2\u00bb\u00be\3\2"+
		"\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\35\3\2\2\2\u00be\u00bc"+
		"\3\2\2\2\u00bf\u00c0\7\20\2\2\u00c0\u00c1\5.\30\2\u00c1\u00c2\5\26\f\2"+
		"\u00c2\u00ca\7\34\2\2\u00c3\u00cb\7\21\2\2\u00c4\u00cb\7\22\2\2\u00c5"+
		"\u00c6\7\b\2\2\u00c6\u00c7\5 \21\2\u00c7\u00c8\7\t\2\2\u00c8\u00cb\3\2"+
		"\2\2\u00c9\u00cb\5 \21\2\u00ca\u00c3\3\2\2\2\u00ca\u00c4\3\2\2\2\u00ca"+
		"\u00c5\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00cf\3\2\2\2\u00cc\u00ce\5 "+
		"\21\2\u00cd\u00cc\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf"+
		"\u00d0\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d3\7\30"+
		"\2\2\u00d3\37\3\2\2\2\u00d4\u00d8\7\21\2\2\u00d5\u00d8\7\22\2\2\u00d6"+
		"\u00d8\5\26\f\2\u00d7\u00d4\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d6\3"+
		"\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00e1\7\35\2\2\u00da\u00e2\5\26\f\2\u00db"+
		"\u00e2\7\21\2\2\u00dc\u00e2\7\22\2\2\u00dd\u00de\7\b\2\2\u00de\u00df\5"+
		" \21\2\u00df\u00e0\7\t\2\2\u00e0\u00e2\3\2\2\2\u00e1\u00da\3\2\2\2\u00e1"+
		"\u00db\3\2\2\2\u00e1\u00dc\3\2\2\2\u00e1\u00dd\3\2\2\2\u00e2\u00ee\3\2"+
		"\2\2\u00e3\u00eb\7\35\2\2\u00e4\u00ec\5\26\f\2\u00e5\u00ec\7\21\2\2\u00e6"+
		"\u00ec\7\22\2\2\u00e7\u00e8\7\b\2\2\u00e8\u00e9\5 \21\2\u00e9\u00ea\7"+
		"\t\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e4\3\2\2\2\u00eb\u00e5\3\2\2\2\u00eb"+
		"\u00e6\3\2\2\2\u00eb\u00e7\3\2\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00d7\3\2"+
		"\2\2\u00ed\u00e3\3\2\2\2\u00ee!\3\2\2\2\u00ef\u00f0\7\r\2\2\u00f0\u00f1"+
		"\5.\30\2\u00f1\u00f2\5\26\f\2\u00f2\u00f3\7\34\2\2\u00f3\u00f4\7\b\2\2"+
		"\u00f4\u00f8\5\60\31\2\u00f5\u00f7\5.\30\2\u00f6\u00f5\3\2\2\2\u00f7\u00fa"+
		"\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fb\3\2\2\2\u00fa"+
		"\u00f8\3\2\2\2\u00fb\u00ff\7\23\2\2\u00fc\u00fe\5.\30\2\u00fd\u00fc\3"+
		"\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100"+
		"\u0102\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\u0103\5\60\31\2\u0103\u0104\7"+
		"\t\2\2\u0104#\3\2\2\2\u0105\u0106\7\16\2\2\u0106\u0107\5.\30\2\u0107\u0108"+
		"\5\26\f\2\u0108\u0109\7\34\2\2\u0109\u010a\7\b\2\2\u010a\u010e\5\60\31"+
		"\2\u010b\u010d\5.\30\2\u010c\u010b\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c"+
		"\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0111\3\2\2\2\u0110\u010e\3\2\2\2\u0111"+
		"\u0115\7\23\2\2\u0112\u0114\5.\30\2\u0113\u0112\3\2\2\2\u0114\u0117\3"+
		"\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0118\3\2\2\2\u0117"+
		"\u0115\3\2\2\2\u0118\u011c\5\60\31\2\u0119\u011b\5.\30\2\u011a\u0119\3"+
		"\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d"+
		"\u011f\3\2\2\2\u011e\u011c\3\2\2\2\u011f\u0123\7\23\2\2\u0120\u0122\5"+
		".\30\2\u0121\u0120\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2\2\2\u0123"+
		"\u0124\3\2\2\2\u0124\u0126\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0127\5\60"+
		"\31\2\u0127\u0128\7\t\2\2\u0128%\3\2\2\2\u0129\u012a\7\17\2\2\u012a\u012b"+
		"\5.\30\2\u012b\u012c\5\26\f\2\u012c\u012d\7\34\2\2\u012d\u012e\7\b\2\2"+
		"\u012e\u0132\5\60\31\2\u012f\u0131\5.\30\2\u0130\u012f\3\2\2\2\u0131\u0134"+
		"\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0135\3\2\2\2\u0134"+
		"\u0132\3\2\2\2\u0135\u0139\7\23\2\2\u0136\u0138\5.\30\2\u0137\u0136\3"+
		"\2\2\2\u0138\u013b\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a"+
		"\u013c\3\2\2\2\u013b\u0139\3\2\2\2\u013c\u0140\5\60\31\2\u013d\u013f\5"+
		".\30\2\u013e\u013d\3\2\2\2\u013f\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0140"+
		"\u0141\3\2\2\2\u0141\u0143\3\2\2\2\u0142\u0140\3\2\2\2\u0143\u0147\7\23"+
		"\2\2\u0144\u0146\5.\30\2\u0145\u0144\3\2\2\2\u0146\u0149\3\2\2\2\u0147"+
		"\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u014a\3\2\2\2\u0149\u0147\3\2"+
		"\2\2\u014a\u014e\5\60\31\2\u014b\u014d\5.\30\2\u014c\u014b\3\2\2\2\u014d"+
		"\u0150\3\2\2\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0151\3\2"+
		"\2\2\u0150\u014e\3\2\2\2\u0151\u0155\7\23\2\2\u0152\u0154\5.\30\2\u0153"+
		"\u0152\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2"+
		"\2\2\u0156\u0158\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u0159\5\60\31\2\u0159"+
		"\u015a\7\t\2\2\u015a\'\3\2\2\2\u015b\u015c\5\22\n\2\u015c\u015d\5.\30"+
		"\2\u015d\u015e\5\26\f\2\u015e)\3\2\2\2\u015f\u0163\5\60\31\2\u0160\u0163"+
		"\5,\27\2\u0161\u0163\5\26\f\2\u0162\u015f\3\2\2\2\u0162\u0160\3\2\2\2"+
		"\u0162\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u016c\7\36\2\2\u0165\u016d"+
		"\5\60\31\2\u0166\u016d\5,\27\2\u0167\u016d\5\26\f\2\u0168\u0169\7\b\2"+
		"\2\u0169\u016a\5*\26\2\u016a\u016b\7\t\2\2\u016b\u016d\3\2\2\2\u016c\u0165"+
		"\3\2\2\2\u016c\u0166\3\2\2\2\u016c\u0167\3\2\2\2\u016c\u0168\3\2\2\2\u016d"+
		"\u0179\3\2\2\2\u016e\u0176\7\36\2\2\u016f\u0177\5\60\31\2\u0170\u0177"+
		"\5,\27\2\u0171\u0177\5\26\f\2\u0172\u0173\7\b\2\2\u0173\u0174\5*\26\2"+
		"\u0174\u0175\7\t\2\2\u0175\u0177\3\2\2\2\u0176\u016f\3\2\2\2\u0176\u0170"+
		"\3\2\2\2\u0176\u0171\3\2\2\2\u0176\u0172\3\2\2\2\u0177\u0179\3\2\2\2\u0178"+
		"\u0162\3\2\2\2\u0178\u016e\3\2\2\2\u0179+\3\2\2\2\u017a\u017f\7\37\2\2"+
		"\u017b\u0180\5\26\f\2\u017c\u0180\5\60\31\2\u017d\u0180\5,\27\2\u017e"+
		"\u0180\7 \2\2\u017f\u017b\3\2\2\2\u017f\u017c\3\2\2\2\u017f\u017d\3\2"+
		"\2\2\u017f\u017e\3\2\2\2\u0180\u0184\3\2\2\2\u0181\u0183\5*\26\2\u0182"+
		"\u0181\3\2\2\2\u0183\u0186\3\2\2\2\u0184\u0182\3\2\2\2\u0184\u0185\3\2"+
		"\2\2\u0185\u0187\3\2\2\2\u0186\u0184\3\2\2\2\u0187\u0188\7\t\2\2\u0188"+
		"-\3\2\2\2\u0189\u018a\7\33\2\2\u018a/\3\2\2\2\u018b\u018e\5\62\32\2\u018c"+
		"\u018e\5\64\33\2\u018d\u018b\3\2\2\2\u018d\u018c\3\2\2\2\u018e\61\3\2"+
		"\2\2\u018f\u0190\7\26\2\2\u0190\63\3\2\2\2\u0191\u0192\7\27\2\2\u0192"+
		"\65\3\2\2\2\61;=DFOTZacoq}\u0086\u0088\u008f\u0094\u009c\u009e\u00a6\u00ae"+
		"\u00b7\u00bc\u00ca\u00cf\u00d7\u00e1\u00eb\u00ed\u00f8\u00ff\u010e\u0115"+
		"\u011c\u0123\u0132\u0139\u0140\u0147\u014e\u0155\u0162\u016c\u0176\u0178"+
		"\u017f\u0184\u018d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}