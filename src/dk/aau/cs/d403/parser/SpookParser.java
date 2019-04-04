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
		RULE_integerDecl = 12, RULE_floatDecl = 13, RULE_arithOperations = 14, 
		RULE_arithOperation = 15, RULE_math_function = 16, RULE_boolDecl = 17, 
		RULE_boolOperations = 18, RULE_boolOperation = 19, RULE_vector2Decl = 20, 
		RULE_vector3Decl = 21, RULE_vector4Decl = 22, RULE_dataTypeVariable = 23, 
		RULE_space = 24, RULE_real_number = 25, RULE_digit = 26, RULE_float_digit = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main", "declarations", "declaration", "comment", "classDecl", 
			"functionDecl", "returnType", "dataType", "vectorType", "variable", "numberDecl", 
			"integerDecl", "floatDecl", "arithOperations", "arithOperation", "math_function", 
			"boolDecl", "boolOperations", "boolOperation", "vector2Decl", "vector3Decl", 
			"vector4Decl", "dataTypeVariable", "space", "real_number", "digit", "float_digit"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Shader {'", "'}'", "'#'", "'class'", "'{'", "'('", "')'", "'void'", 
			"'int'", "'float'", "'boolean'", "'vector2'", "'vector3'", "'vector4'", 
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
			setState(56);
			main();
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << NEWLINE))) != 0)) {
				{
				setState(61);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NEWLINE:
					{
					setState(57);
					match(NEWLINE);
					}
					break;
				case T__2:
					{
					setState(58);
					comment();
					}
					break;
				case T__3:
					{
					setState(59);
					classDecl();
					}
					break;
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__13:
					{
					setState(60);
					functionDecl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(65);
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
			setState(66);
			match(T__0);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << NEWLINE) | (1L << SPACE))) != 0)) {
				{
				setState(70);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(67);
					match(NEWLINE);
					}
					break;
				case 2:
					{
					setState(68);
					space();
					}
					break;
				case 3:
					{
					setState(69);
					declarations();
					}
					break;
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75);
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
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				declaration();
				setState(78);
				declarations();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
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
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(83);
				space();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(89);
				comment();
				}
				break;
			case 2:
				{
				setState(90);
				numberDecl();
				}
				break;
			case 3:
				{
				setState(91);
				boolDecl();
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
			setState(94);
			match(T__2);
			setState(101);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(99);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LETTER:
						{
						setState(95);
						match(LETTER);
						}
						break;
					case STRING:
						{
						setState(96);
						match(STRING);
						}
						break;
					case SPACE:
						{
						setState(97);
						match(SPACE);
						}
						break;
					case DIGIT:
						{
						setState(98);
						digit();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(103);
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
			setState(104);
			match(T__3);
			setState(105);
			space();
			setState(106);
			variable();
			setState(107);
			space();
			setState(108);
			match(T__4);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << NEWLINE) | (1L << SPACE))) != 0)) {
				{
				setState(113);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(109);
					space();
					}
					break;
				case 2:
					{
					setState(110);
					match(NEWLINE);
					}
					break;
				case 3:
					{
					setState(111);
					numberDecl();
					}
					break;
				case 4:
					{
					setState(112);
					functionDecl();
					}
					break;
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
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
			setState(120);
			returnType();
			setState(121);
			space();
			setState(122);
			variable();
			setState(123);
			match(T__5);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) {
				{
				{
				setState(124);
				dataTypeVariable();
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(130);
			match(T__6);
			setState(131);
			space();
			setState(132);
			match(T__4);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << NEWLINE) | (1L << SPACE))) != 0)) {
				{
				setState(136);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(133);
					space();
					}
					break;
				case 2:
					{
					setState(134);
					match(NEWLINE);
					}
					break;
				case 3:
					{
					setState(135);
					declaration();
					}
					break;
				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(141);
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
			setState(145);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				match(T__7);
				}
				break;
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
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
			setState(151);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				match(T__8);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				match(T__9);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(149);
				match(T__10);
				}
				break;
			case T__11:
			case T__12:
			case T__13:
				enterOuterAlt(_localctx, 4);
				{
				setState(150);
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
			setState(153);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) ) {
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
			setState(159); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(159);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LETTER:
						{
						setState(155);
						match(LETTER);
						}
						break;
					case STRING:
						{
						setState(156);
						match(STRING);
						}
						break;
					case SPACE:
						{
						setState(157);
						space();
						}
						break;
					case DIGIT:
						{
						setState(158);
						digit();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(161); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(163);
				integerDecl();
				}
				break;
			case 2:
				{
				setState(164);
				floatDecl();
				}
				break;
			case 3:
				{
				setState(165);
				vector2Decl();
				}
				break;
			case 4:
				{
				setState(166);
				vector3Decl();
				}
				break;
			case 5:
				{
				setState(167);
				vector4Decl();
				}
				break;
			}
			setState(170);
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
			setState(172);
			dataTypeVariable();
			setState(173);
			match(ASSIGN);
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(174);
				digit();
				}
				break;
			case 2:
				{
				setState(175);
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
		public ArithOperationsContext arithOperations() {
			return getRuleContext(ArithOperationsContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			dataTypeVariable();
			setState(179);
			match(ASSIGN);
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(180);
				arithOperations();
				}
				break;
			case 2:
				{
				setState(181);
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
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterArithOperations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitArithOperations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitArithOperations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithOperationsContext arithOperations() throws RecognitionException {
		ArithOperationsContext _localctx = new ArithOperationsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_arithOperations);
		try {
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				arithOperation();
				setState(185);
				arithOperations();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(187);
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
		enterRule(_localctx, 30, RULE_arithOperation);
		try {
			setState(219);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
			case STRING:
			case DIGIT:
			case FLOAT_DIGIT:
			case SPACE:
			case MATH_FUNCTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(190);
					real_number();
					}
					break;
				case 2:
					{
					setState(191);
					math_function();
					}
					break;
				case 3:
					{
					setState(192);
					variable();
					}
					break;
				}
				setState(195);
				match(OPERATOR);
				setState(203);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(196);
					real_number();
					}
					break;
				case 2:
					{
					setState(197);
					math_function();
					}
					break;
				case 3:
					{
					setState(198);
					variable();
					}
					break;
				case 4:
					{
					setState(199);
					match(T__5);
					setState(200);
					arithOperation();
					setState(201);
					match(T__6);
					}
					break;
				}
				}
				break;
			case OPERATOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				match(OPERATOR);
				setState(213);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(206);
					real_number();
					}
					break;
				case 2:
					{
					setState(207);
					math_function();
					}
					break;
				case 3:
					{
					setState(208);
					variable();
					}
					break;
				case 4:
					{
					setState(209);
					match(T__5);
					setState(210);
					arithOperation();
					setState(211);
					match(T__6);
					}
					break;
				}
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(215);
				match(T__5);
				setState(216);
				arithOperation();
				setState(217);
				match(T__6);
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
		enterRule(_localctx, 32, RULE_math_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(MATH_FUNCTION);
			setState(226);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(222);
				variable();
				}
				break;
			case 2:
				{
				setState(223);
				real_number();
				}
				break;
			case 3:
				{
				setState(224);
				math_function();
				}
				break;
			case 4:
				{
				setState(225);
				match(UNIFORM);
				}
				break;
			}
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << LETTER) | (1L << STRING) | (1L << DIGIT) | (1L << FLOAT_DIGIT) | (1L << SPACE) | (1L << OPERATOR) | (1L << MATH_FUNCTION))) != 0)) {
				{
				{
				setState(228);
				arithOperation();
				}
				}
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(234);
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

	public static class BoolDeclContext extends ParserRuleContext {
		public DataTypeVariableContext dataTypeVariable() {
			return getRuleContext(DataTypeVariableContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SpookParser.ASSIGN, 0); }
		public TerminalNode SEMICOLON() { return getToken(SpookParser.SEMICOLON, 0); }
		public BoolOperationsContext boolOperations() {
			return getRuleContext(BoolOperationsContext.class,0);
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
		enterRule(_localctx, 34, RULE_boolDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			dataTypeVariable();
			setState(237);
			match(ASSIGN);
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(238);
				boolOperations();
				}
				break;
			case 2:
				{
				setState(239);
				match(T__14);
				}
				break;
			case 3:
				{
				setState(240);
				match(T__15);
				}
				break;
			}
			setState(243);
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
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterBoolOperations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitBoolOperations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitBoolOperations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolOperationsContext boolOperations() throws RecognitionException {
		BoolOperationsContext _localctx = new BoolOperationsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_boolOperations);
		try {
			setState(249);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(245);
				boolOperation();
				setState(246);
				boolOperations();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(248);
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
		enterRule(_localctx, 38, RULE_boolOperation);
		try {
			setState(280);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
			case T__15:
			case LETTER:
			case STRING:
			case DIGIT:
			case SPACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__14:
					{
					setState(251);
					match(T__14);
					}
					break;
				case T__15:
					{
					setState(252);
					match(T__15);
					}
					break;
				case LETTER:
				case STRING:
				case DIGIT:
				case SPACE:
					{
					setState(253);
					variable();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(256);
				match(BOOLOPERATOR);
				setState(264);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__14:
					{
					setState(257);
					match(T__14);
					}
					break;
				case T__15:
					{
					setState(258);
					match(T__15);
					}
					break;
				case LETTER:
				case STRING:
				case DIGIT:
				case SPACE:
					{
					setState(259);
					variable();
					}
					break;
				case T__5:
					{
					{
					setState(260);
					match(T__5);
					setState(261);
					boolOperation();
					setState(262);
					match(T__6);
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
				setState(266);
				match(BOOLOPERATOR);
				setState(274);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__14:
					{
					setState(267);
					match(T__14);
					}
					break;
				case T__15:
					{
					setState(268);
					match(T__15);
					}
					break;
				case LETTER:
				case STRING:
				case DIGIT:
				case SPACE:
					{
					setState(269);
					variable();
					}
					break;
				case T__5:
					{
					{
					setState(270);
					match(T__5);
					setState(271);
					boolOperation();
					setState(272);
					match(T__6);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(276);
				match(T__5);
				setState(277);
				boolOperation();
				setState(278);
				match(T__6);
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
		enterRule(_localctx, 40, RULE_vector2Decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			match(T__11);
			setState(283);
			space();
			setState(284);
			variable();
			setState(285);
			match(ASSIGN);
			setState(286);
			match(T__5);
			setState(287);
			real_number();
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(288);
				space();
				}
				}
				setState(293);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(294);
			match(T__16);
			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(295);
				space();
				}
				}
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(301);
			real_number();
			setState(302);
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
		enterRule(_localctx, 42, RULE_vector3Decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(T__12);
			setState(305);
			space();
			setState(306);
			variable();
			setState(307);
			match(ASSIGN);
			setState(308);
			match(T__5);
			setState(309);
			real_number();
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(310);
				space();
				}
				}
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(316);
			match(T__16);
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(317);
				space();
				}
				}
				setState(322);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(323);
			real_number();
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(324);
				space();
				}
				}
				setState(329);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(330);
			match(T__16);
			setState(334);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(331);
				space();
				}
				}
				setState(336);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(337);
			real_number();
			setState(338);
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
		enterRule(_localctx, 44, RULE_vector4Decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(T__13);
			setState(341);
			space();
			setState(342);
			variable();
			setState(343);
			match(ASSIGN);
			setState(344);
			match(T__5);
			setState(345);
			real_number();
			setState(349);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(346);
				space();
				}
				}
				setState(351);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(352);
			match(T__16);
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(353);
				space();
				}
				}
				setState(358);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(359);
			real_number();
			setState(363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(360);
				space();
				}
				}
				setState(365);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(366);
			match(T__16);
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(367);
				space();
				}
				}
				setState(372);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(373);
			real_number();
			setState(377);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(374);
				space();
				}
				}
				setState(379);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(380);
			match(T__16);
			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(381);
				space();
				}
				}
				setState(386);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(387);
			real_number();
			setState(388);
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
		enterRule(_localctx, 46, RULE_dataTypeVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			dataType();
			setState(391);
			space();
			setState(392);
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
		enterRule(_localctx, 48, RULE_space);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
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
		enterRule(_localctx, 50, RULE_real_number);
		try {
			setState(398);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIGIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(396);
				digit();
				}
				break;
			case FLOAT_DIGIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(397);
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
		enterRule(_localctx, 52, RULE_digit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
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
		enterRule(_localctx, 54, RULE_float_digit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 \u0197\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\3\2\7\2@\n\2"+
		"\f\2\16\2C\13\2\3\3\3\3\3\3\3\3\7\3I\n\3\f\3\16\3L\13\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\5\4T\n\4\3\5\7\5W\n\5\f\5\16\5Z\13\5\3\5\3\5\3\5\5\5_\n\5\3"+
		"\6\3\6\3\6\3\6\3\6\7\6f\n\6\f\6\16\6i\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\7\7t\n\7\f\7\16\7w\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\7\b\u0080"+
		"\n\b\f\b\16\b\u0083\13\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u008b\n\b\f\b\16"+
		"\b\u008e\13\b\3\b\3\b\3\t\3\t\5\t\u0094\n\t\3\n\3\n\3\n\3\n\5\n\u009a"+
		"\n\n\3\13\3\13\3\f\3\f\3\f\3\f\6\f\u00a2\n\f\r\f\16\f\u00a3\3\r\3\r\3"+
		"\r\3\r\3\r\5\r\u00ab\n\r\3\r\3\r\3\16\3\16\3\16\3\16\5\16\u00b3\n\16\3"+
		"\17\3\17\3\17\3\17\5\17\u00b9\n\17\3\20\3\20\3\20\3\20\5\20\u00bf\n\20"+
		"\3\21\3\21\3\21\5\21\u00c4\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u00ce\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00d8\n"+
		"\21\3\21\3\21\3\21\3\21\5\21\u00de\n\21\3\22\3\22\3\22\3\22\3\22\5\22"+
		"\u00e5\n\22\3\22\7\22\u00e8\n\22\f\22\16\22\u00eb\13\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u00f4\n\23\3\23\3\23\3\24\3\24\3\24\3\24\5\24"+
		"\u00fc\n\24\3\25\3\25\3\25\5\25\u0101\n\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\5\25\u010b\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u0115\n\25\3\25\3\25\3\25\3\25\5\25\u011b\n\25\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\7\26\u0124\n\26\f\26\16\26\u0127\13\26\3\26\3\26\7"+
		"\26\u012b\n\26\f\26\16\26\u012e\13\26\3\26\3\26\3\26\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\7\27\u013a\n\27\f\27\16\27\u013d\13\27\3\27\3\27\7"+
		"\27\u0141\n\27\f\27\16\27\u0144\13\27\3\27\3\27\7\27\u0148\n\27\f\27\16"+
		"\27\u014b\13\27\3\27\3\27\7\27\u014f\n\27\f\27\16\27\u0152\13\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u015e\n\30\f\30\16"+
		"\30\u0161\13\30\3\30\3\30\7\30\u0165\n\30\f\30\16\30\u0168\13\30\3\30"+
		"\3\30\7\30\u016c\n\30\f\30\16\30\u016f\13\30\3\30\3\30\7\30\u0173\n\30"+
		"\f\30\16\30\u0176\13\30\3\30\3\30\7\30\u017a\n\30\f\30\16\30\u017d\13"+
		"\30\3\30\3\30\7\30\u0181\n\30\f\30\16\30\u0184\13\30\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\5\33\u0191\n\33\3\34\3\34\3\35"+
		"\3\35\3\35\2\2\36\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668\2\3\3\2\16\20\2\u01c8\2:\3\2\2\2\4D\3\2\2\2\6S\3\2\2\2\bX\3\2"+
		"\2\2\n`\3\2\2\2\fj\3\2\2\2\16z\3\2\2\2\20\u0093\3\2\2\2\22\u0099\3\2\2"+
		"\2\24\u009b\3\2\2\2\26\u00a1\3\2\2\2\30\u00aa\3\2\2\2\32\u00ae\3\2\2\2"+
		"\34\u00b4\3\2\2\2\36\u00be\3\2\2\2 \u00dd\3\2\2\2\"\u00df\3\2\2\2$\u00ee"+
		"\3\2\2\2&\u00fb\3\2\2\2(\u011a\3\2\2\2*\u011c\3\2\2\2,\u0132\3\2\2\2."+
		"\u0156\3\2\2\2\60\u0188\3\2\2\2\62\u018c\3\2\2\2\64\u0190\3\2\2\2\66\u0192"+
		"\3\2\2\28\u0194\3\2\2\2:A\5\4\3\2;@\7\31\2\2<@\5\n\6\2=@\5\f\7\2>@\5\16"+
		"\b\2?;\3\2\2\2?<\3\2\2\2?=\3\2\2\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2"+
		"\2\2B\3\3\2\2\2CA\3\2\2\2DJ\7\3\2\2EI\7\31\2\2FI\5\62\32\2GI\5\6\4\2H"+
		"E\3\2\2\2HF\3\2\2\2HG\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KM\3\2\2\2"+
		"LJ\3\2\2\2MN\7\4\2\2N\5\3\2\2\2OP\5\b\5\2PQ\5\6\4\2QT\3\2\2\2RT\5\b\5"+
		"\2SO\3\2\2\2SR\3\2\2\2T\7\3\2\2\2UW\5\62\32\2VU\3\2\2\2WZ\3\2\2\2XV\3"+
		"\2\2\2XY\3\2\2\2Y^\3\2\2\2ZX\3\2\2\2[_\5\n\6\2\\_\5\30\r\2]_\5$\23\2^"+
		"[\3\2\2\2^\\\3\2\2\2^]\3\2\2\2_\t\3\2\2\2`g\7\5\2\2af\7\24\2\2bf\7\25"+
		"\2\2cf\7\33\2\2df\5\66\34\2ea\3\2\2\2eb\3\2\2\2ec\3\2\2\2ed\3\2\2\2fi"+
		"\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\13\3\2\2\2ig\3\2\2\2jk\7\6\2\2kl\5\62\32"+
		"\2lm\5\26\f\2mn\5\62\32\2nu\7\7\2\2ot\5\62\32\2pt\7\31\2\2qt\5\30\r\2"+
		"rt\5\16\b\2so\3\2\2\2sp\3\2\2\2sq\3\2\2\2sr\3\2\2\2tw\3\2\2\2us\3\2\2"+
		"\2uv\3\2\2\2vx\3\2\2\2wu\3\2\2\2xy\7\4\2\2y\r\3\2\2\2z{\5\20\t\2{|\5\62"+
		"\32\2|}\5\26\f\2}\u0081\7\b\2\2~\u0080\5\60\31\2\177~\3\2\2\2\u0080\u0083"+
		"\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083"+
		"\u0081\3\2\2\2\u0084\u0085\7\t\2\2\u0085\u0086\5\62\32\2\u0086\u008c\7"+
		"\7\2\2\u0087\u008b\5\62\32\2\u0088\u008b\7\31\2\2\u0089\u008b\5\b\5\2"+
		"\u008a\u0087\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u0089\3\2\2\2\u008b\u008e"+
		"\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\3\2\2\2\u008e"+
		"\u008c\3\2\2\2\u008f\u0090\7\4\2\2\u0090\17\3\2\2\2\u0091\u0094\7\n\2"+
		"\2\u0092\u0094\5\22\n\2\u0093\u0091\3\2\2\2\u0093\u0092\3\2\2\2\u0094"+
		"\21\3\2\2\2\u0095\u009a\7\13\2\2\u0096\u009a\7\f\2\2\u0097\u009a\7\r\2"+
		"\2\u0098\u009a\5\24\13\2\u0099\u0095\3\2\2\2\u0099\u0096\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u0099\u0098\3\2\2\2\u009a\23\3\2\2\2\u009b\u009c\t\2\2"+
		"\2\u009c\25\3\2\2\2\u009d\u00a2\7\24\2\2\u009e\u00a2\7\25\2\2\u009f\u00a2"+
		"\5\62\32\2\u00a0\u00a2\5\66\34\2\u00a1\u009d\3\2\2\2\u00a1\u009e\3\2\2"+
		"\2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a1"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\27\3\2\2\2\u00a5\u00ab\5\32\16\2\u00a6"+
		"\u00ab\5\34\17\2\u00a7\u00ab\5*\26\2\u00a8\u00ab\5,\27\2\u00a9\u00ab\5"+
		".\30\2\u00aa\u00a5\3\2\2\2\u00aa\u00a6\3\2\2\2\u00aa\u00a7\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\7\30"+
		"\2\2\u00ad\31\3\2\2\2\u00ae\u00af\5\60\31\2\u00af\u00b2\7\34\2\2\u00b0"+
		"\u00b3\5\66\34\2\u00b1\u00b3\5\26\f\2\u00b2\u00b0\3\2\2\2\u00b2\u00b1"+
		"\3\2\2\2\u00b3\33\3\2\2\2\u00b4\u00b5\5\60\31\2\u00b5\u00b8\7\34\2\2\u00b6"+
		"\u00b9\5\36\20\2\u00b7\u00b9\5\64\33\2\u00b8\u00b6\3\2\2\2\u00b8\u00b7"+
		"\3\2\2\2\u00b9\35\3\2\2\2\u00ba\u00bb\5 \21\2\u00bb\u00bc\5\36\20\2\u00bc"+
		"\u00bf\3\2\2\2\u00bd\u00bf\5 \21\2\u00be\u00ba\3\2\2\2\u00be\u00bd\3\2"+
		"\2\2\u00bf\37\3\2\2\2\u00c0\u00c4\5\64\33\2\u00c1\u00c4\5\"\22\2\u00c2"+
		"\u00c4\5\26\f\2\u00c3\u00c0\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c2\3"+
		"\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00cd\7\36\2\2\u00c6\u00ce\5\64\33\2"+
		"\u00c7\u00ce\5\"\22\2\u00c8\u00ce\5\26\f\2\u00c9\u00ca\7\b\2\2\u00ca\u00cb"+
		"\5 \21\2\u00cb\u00cc\7\t\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00c6\3\2\2\2\u00cd"+
		"\u00c7\3\2\2\2\u00cd\u00c8\3\2\2\2\u00cd\u00c9\3\2\2\2\u00ce\u00de\3\2"+
		"\2\2\u00cf\u00d7\7\36\2\2\u00d0\u00d8\5\64\33\2\u00d1\u00d8\5\"\22\2\u00d2"+
		"\u00d8\5\26\f\2\u00d3\u00d4\7\b\2\2\u00d4\u00d5\5 \21\2\u00d5\u00d6\7"+
		"\t\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00d0\3\2\2\2\u00d7\u00d1\3\2\2\2\u00d7"+
		"\u00d2\3\2\2\2\u00d7\u00d3\3\2\2\2\u00d8\u00de\3\2\2\2\u00d9\u00da\7\b"+
		"\2\2\u00da\u00db\5 \21\2\u00db\u00dc\7\t\2\2\u00dc\u00de\3\2\2\2\u00dd"+
		"\u00c3\3\2\2\2\u00dd\u00cf\3\2\2\2\u00dd\u00d9\3\2\2\2\u00de!\3\2\2\2"+
		"\u00df\u00e4\7\37\2\2\u00e0\u00e5\5\26\f\2\u00e1\u00e5\5\64\33\2\u00e2"+
		"\u00e5\5\"\22\2\u00e3\u00e5\7 \2\2\u00e4\u00e0\3\2\2\2\u00e4\u00e1\3\2"+
		"\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e9\3\2\2\2\u00e6"+
		"\u00e8\5 \21\2\u00e7\u00e6\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2"+
		"\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec"+
		"\u00ed\7\t\2\2\u00ed#\3\2\2\2\u00ee\u00ef\5\60\31\2\u00ef\u00f3\7\34\2"+
		"\2\u00f0\u00f4\5&\24\2\u00f1\u00f4\7\21\2\2\u00f2\u00f4\7\22\2\2\u00f3"+
		"\u00f0\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4\u00f5\3\2"+
		"\2\2\u00f5\u00f6\7\30\2\2\u00f6%\3\2\2\2\u00f7\u00f8\5(\25\2\u00f8\u00f9"+
		"\5&\24\2\u00f9\u00fc\3\2\2\2\u00fa\u00fc\5(\25\2\u00fb\u00f7\3\2\2\2\u00fb"+
		"\u00fa\3\2\2\2\u00fc\'\3\2\2\2\u00fd\u0101\7\21\2\2\u00fe\u0101\7\22\2"+
		"\2\u00ff\u0101\5\26\f\2\u0100\u00fd\3\2\2\2\u0100\u00fe\3\2\2\2\u0100"+
		"\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u010a\7\35\2\2\u0103\u010b\7"+
		"\21\2\2\u0104\u010b\7\22\2\2\u0105\u010b\5\26\f\2\u0106\u0107\7\b\2\2"+
		"\u0107\u0108\5(\25\2\u0108\u0109\7\t\2\2\u0109\u010b\3\2\2\2\u010a\u0103"+
		"\3\2\2\2\u010a\u0104\3\2\2\2\u010a\u0105\3\2\2\2\u010a\u0106\3\2\2\2\u010b"+
		"\u011b\3\2\2\2\u010c\u0114\7\35\2\2\u010d\u0115\7\21\2\2\u010e\u0115\7"+
		"\22\2\2\u010f\u0115\5\26\f\2\u0110\u0111\7\b\2\2\u0111\u0112\5(\25\2\u0112"+
		"\u0113\7\t\2\2\u0113\u0115\3\2\2\2\u0114\u010d\3\2\2\2\u0114\u010e\3\2"+
		"\2\2\u0114\u010f\3\2\2\2\u0114\u0110\3\2\2\2\u0115\u011b\3\2\2\2\u0116"+
		"\u0117\7\b\2\2\u0117\u0118\5(\25\2\u0118\u0119\7\t\2\2\u0119\u011b\3\2"+
		"\2\2\u011a\u0100\3\2\2\2\u011a\u010c\3\2\2\2\u011a\u0116\3\2\2\2\u011b"+
		")\3\2\2\2\u011c\u011d\7\16\2\2\u011d\u011e\5\62\32\2\u011e\u011f\5\26"+
		"\f\2\u011f\u0120\7\34\2\2\u0120\u0121\7\b\2\2\u0121\u0125\5\64\33\2\u0122"+
		"\u0124\5\62\32\2\u0123\u0122\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3"+
		"\2\2\2\u0125\u0126\3\2\2\2\u0126\u0128\3\2\2\2\u0127\u0125\3\2\2\2\u0128"+
		"\u012c\7\23\2\2\u0129\u012b\5\62\32\2\u012a\u0129\3\2\2\2\u012b\u012e"+
		"\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012f\3\2\2\2\u012e"+
		"\u012c\3\2\2\2\u012f\u0130\5\64\33\2\u0130\u0131\7\t\2\2\u0131+\3\2\2"+
		"\2\u0132\u0133\7\17\2\2\u0133\u0134\5\62\32\2\u0134\u0135\5\26\f\2\u0135"+
		"\u0136\7\34\2\2\u0136\u0137\7\b\2\2\u0137\u013b\5\64\33\2\u0138\u013a"+
		"\5\62\32\2\u0139\u0138\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2\2\2"+
		"\u013b\u013c\3\2\2\2\u013c\u013e\3\2\2\2\u013d\u013b\3\2\2\2\u013e\u0142"+
		"\7\23\2\2\u013f\u0141\5\62\32\2\u0140\u013f\3\2\2\2\u0141\u0144\3\2\2"+
		"\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0145\3\2\2\2\u0144\u0142"+
		"\3\2\2\2\u0145\u0149\5\64\33\2\u0146\u0148\5\62\32\2\u0147\u0146\3\2\2"+
		"\2\u0148\u014b\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014c"+
		"\3\2\2\2\u014b\u0149\3\2\2\2\u014c\u0150\7\23\2\2\u014d\u014f\5\62\32"+
		"\2\u014e\u014d\3\2\2\2\u014f\u0152\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151"+
		"\3\2\2\2\u0151\u0153\3\2\2\2\u0152\u0150\3\2\2\2\u0153\u0154\5\64\33\2"+
		"\u0154\u0155\7\t\2\2\u0155-\3\2\2\2\u0156\u0157\7\20\2\2\u0157\u0158\5"+
		"\62\32\2\u0158\u0159\5\26\f\2\u0159\u015a\7\34\2\2\u015a\u015b\7\b\2\2"+
		"\u015b\u015f\5\64\33\2\u015c\u015e\5\62\32\2\u015d\u015c\3\2\2\2\u015e"+
		"\u0161\3\2\2\2\u015f\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0162\3\2"+
		"\2\2\u0161\u015f\3\2\2\2\u0162\u0166\7\23\2\2\u0163\u0165\5\62\32\2\u0164"+
		"\u0163\3\2\2\2\u0165\u0168\3\2\2\2\u0166\u0164\3\2\2\2\u0166\u0167\3\2"+
		"\2\2\u0167\u0169\3\2\2\2\u0168\u0166\3\2\2\2\u0169\u016d\5\64\33\2\u016a"+
		"\u016c\5\62\32\2\u016b\u016a\3\2\2\2\u016c\u016f\3\2\2\2\u016d\u016b\3"+
		"\2\2\2\u016d\u016e\3\2\2\2\u016e\u0170\3\2\2\2\u016f\u016d\3\2\2\2\u0170"+
		"\u0174\7\23\2\2\u0171\u0173\5\62\32\2\u0172\u0171\3\2\2\2\u0173\u0176"+
		"\3\2\2\2\u0174\u0172\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0177\3\2\2\2\u0176"+
		"\u0174\3\2\2\2\u0177\u017b\5\64\33\2\u0178\u017a\5\62\32\2\u0179\u0178"+
		"\3\2\2\2\u017a\u017d\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c"+
		"\u017e\3\2\2\2\u017d\u017b\3\2\2\2\u017e\u0182\7\23\2\2\u017f\u0181\5"+
		"\62\32\2\u0180\u017f\3\2\2\2\u0181\u0184\3\2\2\2\u0182\u0180\3\2\2\2\u0182"+
		"\u0183\3\2\2\2\u0183\u0185\3\2\2\2\u0184\u0182\3\2\2\2\u0185\u0186\5\64"+
		"\33\2\u0186\u0187\7\t\2\2\u0187/\3\2\2\2\u0188\u0189\5\22\n\2\u0189\u018a"+
		"\5\62\32\2\u018a\u018b\5\26\f\2\u018b\61\3\2\2\2\u018c\u018d\7\33\2\2"+
		"\u018d\63\3\2\2\2\u018e\u0191\5\66\34\2\u018f\u0191\58\35\2\u0190\u018e"+
		"\3\2\2\2\u0190\u018f\3\2\2\2\u0191\65\3\2\2\2\u0192\u0193\7\26\2\2\u0193"+
		"\67\3\2\2\2\u0194\u0195\7\27\2\2\u01959\3\2\2\2\61?AHJSX^egsu\u0081\u008a"+
		"\u008c\u0093\u0099\u00a1\u00a3\u00aa\u00b2\u00b8\u00be\u00c3\u00cd\u00d7"+
		"\u00dd\u00e4\u00e9\u00f3\u00fb\u0100\u010a\u0114\u011a\u0125\u012c\u013b"+
		"\u0142\u0149\u0150\u015f\u0166\u016d\u0174\u017b\u0182\u0190";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}