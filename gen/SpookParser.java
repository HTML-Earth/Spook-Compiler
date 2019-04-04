// Generated from /Users/Garrido/PycharmProjects/PythonProjects/P4/src/Spook.g4 by ANTLR 4.7.2
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
		T__9=10, T__10=11, LETTER=12, DIGIT=13, FLOAT_DIGIT=14, SEMICOLON=15, 
		NEWLINE=16, SPACE=17, ASSIGN=18, OPERATOR=19, MATH_FUNCTION=20, UNIFORM=21;
	public static final int
		RULE_main = 0, RULE_declarations = 1, RULE_declaration = 2, RULE_comment = 3, 
		RULE_variable = 4, RULE_numberDecl = 5, RULE_integerDecl = 6, RULE_floatDecl = 7, 
		RULE_vector2Decl = 8, RULE_vector3Decl = 9, RULE_vector4Decl = 10, RULE_arith = 11, 
		RULE_math_function = 12, RULE_real_number = 13, RULE_reserved_word = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"main", "declarations", "declaration", "comment", "variable", "numberDecl", 
			"integerDecl", "floatDecl", "vector2Decl", "vector3Decl", "vector4Decl", 
			"arith", "math_function", "real_number", "reserved_word"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'shader() {'", "'}'", "'//'", "'int '", "'float '", "'vector2 '", 
			"'('", "','", "')'", "'vector3 '", "'vector4 '", null, null, null, "';'", 
			"'\n'", "' '", null, null, null, "'Time'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"LETTER", "DIGIT", "FLOAT_DIGIT", "SEMICOLON", "NEWLINE", "SPACE", "ASSIGN", 
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

	public static class MainContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(SpookParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SpookParser.NEWLINE, i);
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
		enterRule(_localctx, 0, RULE_main);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(T__0);
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(31);
				match(NEWLINE);
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__9) | (1L << T__10) | (1L << SPACE))) != 0)) {
				{
				{
				setState(37);
				declarations();
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
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
		enterRule(_localctx, 2, RULE_declarations);
		try {
			setState(49);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				declaration();
				setState(46);
				declarations();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
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
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SpookParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SpookParser.NEWLINE, i);
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
		enterRule(_localctx, 4, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(51);
				numberDecl();
				}
				break;
			case 2:
				{
				setState(52);
				comment();
				}
				break;
			}
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(55);
				match(NEWLINE);
				}
				}
				setState(60);
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

	public static class CommentContext extends ParserRuleContext {
		public List<TerminalNode> SPACE() { return getTokens(SpookParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(SpookParser.SPACE, i);
		}
		public List<TerminalNode> LETTER() { return getTokens(SpookParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(SpookParser.LETTER, i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(SpookParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(SpookParser.DIGIT, i);
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
		enterRule(_localctx, 6, RULE_comment);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(61);
				match(SPACE);
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
			match(T__2);
			setState(71);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(68);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LETTER) | (1L << DIGIT) | (1L << SPACE))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
		public List<TerminalNode> DIGIT() { return getTokens(SpookParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(SpookParser.DIGIT, i);
		}
		public List<Reserved_wordContext> reserved_word() {
			return getRuleContexts(Reserved_wordContext.class);
		}
		public Reserved_wordContext reserved_word(int i) {
			return getRuleContext(Reserved_wordContext.class,i);
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
		enterRule(_localctx, 8, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(LETTER);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LETTER) | (1L << DIGIT) | (1L << UNIFORM))) != 0)) {
				{
				setState(78);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LETTER:
					{
					setState(75);
					match(LETTER);
					}
					break;
				case DIGIT:
					{
					setState(76);
					match(DIGIT);
					}
					break;
				case UNIFORM:
					{
					setState(77);
					reserved_word();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(82);
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
		public List<TerminalNode> SPACE() { return getTokens(SpookParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(SpookParser.SPACE, i);
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
		enterRule(_localctx, 10, RULE_numberDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(83);
				match(SPACE);
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				setState(89);
				integerDecl();
				}
				break;
			case T__4:
				{
				setState(90);
				floatDecl();
				}
				break;
			case T__5:
				{
				setState(91);
				vector2Decl();
				}
				break;
			case T__9:
				{
				setState(92);
				vector3Decl();
				}
				break;
			case T__10:
				{
				setState(93);
				vector4Decl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(96);
			match(SEMICOLON);
			setState(100);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(97);
					match(SPACE);
					}
					} 
				}
				setState(102);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class IntegerDeclContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(SpookParser.ASSIGN, 0); }
		public TerminalNode DIGIT() { return getToken(SpookParser.DIGIT, 0); }
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
		enterRule(_localctx, 12, RULE_integerDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__3);
			setState(104);
			variable();
			setState(105);
			match(ASSIGN);
			setState(108);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIGIT:
				{
				setState(106);
				match(DIGIT);
				}
				break;
			case LETTER:
				{
				setState(107);
				variable();
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

	public static class FloatDeclContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(SpookParser.ASSIGN, 0); }
		public Real_numberContext real_number() {
			return getRuleContext(Real_numberContext.class,0);
		}
		public Math_functionContext math_function() {
			return getRuleContext(Math_functionContext.class,0);
		}
		public List<ArithContext> arith() {
			return getRuleContexts(ArithContext.class);
		}
		public ArithContext arith(int i) {
			return getRuleContext(ArithContext.class,i);
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
		enterRule(_localctx, 14, RULE_floatDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(T__4);
			setState(111);
			variable();
			setState(112);
			match(ASSIGN);
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIGIT:
			case FLOAT_DIGIT:
				{
				setState(113);
				real_number();
				}
				break;
			case MATH_FUNCTION:
				{
				setState(114);
				math_function();
				}
				break;
			case LETTER:
				{
				setState(115);
				variable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPERATOR) {
				{
				{
				setState(118);
				arith();
				}
				}
				setState(123);
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

	public static class Vector2DeclContext extends ParserRuleContext {
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
		public List<TerminalNode> SPACE() { return getTokens(SpookParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(SpookParser.SPACE, i);
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
		enterRule(_localctx, 16, RULE_vector2Decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__5);
			setState(125);
			variable();
			setState(126);
			match(ASSIGN);
			setState(127);
			match(T__6);
			setState(128);
			real_number();
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(129);
				match(SPACE);
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(135);
			match(T__7);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(136);
				match(SPACE);
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(142);
			real_number();
			setState(143);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
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
		public List<TerminalNode> SPACE() { return getTokens(SpookParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(SpookParser.SPACE, i);
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
		enterRule(_localctx, 18, RULE_vector3Decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(T__9);
			setState(146);
			variable();
			setState(147);
			match(ASSIGN);
			setState(148);
			match(T__6);
			setState(149);
			real_number();
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(150);
				match(SPACE);
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(156);
			match(T__7);
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(157);
				match(SPACE);
				}
				}
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(163);
			real_number();
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(164);
				match(SPACE);
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170);
			match(T__7);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(171);
				match(SPACE);
				}
				}
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(177);
			real_number();
			setState(178);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
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
		public List<TerminalNode> SPACE() { return getTokens(SpookParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(SpookParser.SPACE, i);
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
		enterRule(_localctx, 20, RULE_vector4Decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(T__10);
			setState(181);
			variable();
			setState(182);
			match(ASSIGN);
			setState(183);
			match(T__6);
			setState(184);
			real_number();
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(185);
				match(SPACE);
				}
				}
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(191);
			match(T__7);
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(192);
				match(SPACE);
				}
				}
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(198);
			real_number();
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(199);
				match(SPACE);
				}
				}
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(205);
			match(T__7);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(206);
				match(SPACE);
				}
				}
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(212);
			real_number();
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(213);
				match(SPACE);
				}
				}
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(219);
			match(T__7);
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(220);
				match(SPACE);
				}
				}
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(226);
			real_number();
			setState(227);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithContext extends ParserRuleContext {
		public TerminalNode OPERATOR() { return getToken(SpookParser.OPERATOR, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Real_numberContext real_number() {
			return getRuleContext(Real_numberContext.class,0);
		}
		public Math_functionContext math_function() {
			return getRuleContext(Math_functionContext.class,0);
		}
		public ArithContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterArith(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitArith(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitArith(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithContext arith() throws RecognitionException {
		ArithContext _localctx = new ArithContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_arith);
		try {
			setState(235);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				match(OPERATOR);
				setState(230);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(231);
				match(OPERATOR);
				setState(232);
				real_number();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(233);
				match(OPERATOR);
				setState(234);
				math_function();
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
		public List<ArithContext> arith() {
			return getRuleContexts(ArithContext.class);
		}
		public ArithContext arith(int i) {
			return getRuleContext(ArithContext.class,i);
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
		enterRule(_localctx, 24, RULE_math_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(MATH_FUNCTION);
			setState(242);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
				{
				setState(238);
				variable();
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
			while (_la==OPERATOR) {
				{
				{
				setState(244);
				arith();
				}
				}
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(250);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode DIGIT() { return getToken(SpookParser.DIGIT, 0); }
		public TerminalNode FLOAT_DIGIT() { return getToken(SpookParser.FLOAT_DIGIT, 0); }
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
		enterRule(_localctx, 26, RULE_real_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
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

	public static class Reserved_wordContext extends ParserRuleContext {
		public TerminalNode UNIFORM() { return getToken(SpookParser.UNIFORM, 0); }
		public Reserved_wordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reserved_word; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).enterReserved_word(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpookListener ) ((SpookListener)listener).exitReserved_word(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpookVisitor ) return ((SpookVisitor<? extends T>)visitor).visitReserved_word(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Reserved_wordContext reserved_word() throws RecognitionException {
		Reserved_wordContext _localctx = new Reserved_wordContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_reserved_word);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(UNIFORM);
			}
		}
		catch (RecognitionException re) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\27\u0103\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\7\2#\n\2\f"+
		"\2\16\2&\13\2\3\2\7\2)\n\2\f\2\16\2,\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3"+
		"\64\n\3\3\4\3\4\5\48\n\4\3\4\7\4;\n\4\f\4\16\4>\13\4\3\5\7\5A\n\5\f\5"+
		"\16\5D\13\5\3\5\3\5\7\5H\n\5\f\5\16\5K\13\5\3\6\3\6\3\6\3\6\7\6Q\n\6\f"+
		"\6\16\6T\13\6\3\7\7\7W\n\7\f\7\16\7Z\13\7\3\7\3\7\3\7\3\7\3\7\5\7a\n\7"+
		"\3\7\3\7\7\7e\n\7\f\7\16\7h\13\7\3\b\3\b\3\b\3\b\3\b\5\bo\n\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\5\tw\n\t\3\t\7\tz\n\t\f\t\16\t}\13\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\7\n\u0085\n\n\f\n\16\n\u0088\13\n\3\n\3\n\7\n\u008c\n\n\f\n\16"+
		"\n\u008f\13\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u009a\n\13"+
		"\f\13\16\13\u009d\13\13\3\13\3\13\7\13\u00a1\n\13\f\13\16\13\u00a4\13"+
		"\13\3\13\3\13\7\13\u00a8\n\13\f\13\16\13\u00ab\13\13\3\13\3\13\7\13\u00af"+
		"\n\13\f\13\16\13\u00b2\13\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\7"+
		"\f\u00bd\n\f\f\f\16\f\u00c0\13\f\3\f\3\f\7\f\u00c4\n\f\f\f\16\f\u00c7"+
		"\13\f\3\f\3\f\7\f\u00cb\n\f\f\f\16\f\u00ce\13\f\3\f\3\f\7\f\u00d2\n\f"+
		"\f\f\16\f\u00d5\13\f\3\f\3\f\7\f\u00d9\n\f\f\f\16\f\u00dc\13\f\3\f\3\f"+
		"\7\f\u00e0\n\f\f\f\16\f\u00e3\13\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\5\r\u00ee\n\r\3\16\3\16\3\16\3\16\3\16\5\16\u00f5\n\16\3\16\7\16\u00f8"+
		"\n\16\f\16\16\16\u00fb\13\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\2\2\21"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\4\4\2\16\17\23\23\3\2\17\20"+
		"\2\u0119\2 \3\2\2\2\4\63\3\2\2\2\6\67\3\2\2\2\bB\3\2\2\2\nL\3\2\2\2\f"+
		"X\3\2\2\2\16i\3\2\2\2\20p\3\2\2\2\22~\3\2\2\2\24\u0093\3\2\2\2\26\u00b6"+
		"\3\2\2\2\30\u00ed\3\2\2\2\32\u00ef\3\2\2\2\34\u00fe\3\2\2\2\36\u0100\3"+
		"\2\2\2 $\7\3\2\2!#\7\22\2\2\"!\3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2"+
		"%*\3\2\2\2&$\3\2\2\2\')\5\4\3\2(\'\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2"+
		"\2+-\3\2\2\2,*\3\2\2\2-.\7\4\2\2.\3\3\2\2\2/\60\5\6\4\2\60\61\5\4\3\2"+
		"\61\64\3\2\2\2\62\64\5\6\4\2\63/\3\2\2\2\63\62\3\2\2\2\64\5\3\2\2\2\65"+
		"8\5\f\7\2\668\5\b\5\2\67\65\3\2\2\2\67\66\3\2\2\28<\3\2\2\29;\7\22\2\2"+
		":9\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=\7\3\2\2\2><\3\2\2\2?A\7\23\2"+
		"\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2CE\3\2\2\2DB\3\2\2\2EI\7\5\2"+
		"\2FH\t\2\2\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J\t\3\2\2\2KI\3\2"+
		"\2\2LR\7\16\2\2MQ\7\16\2\2NQ\7\17\2\2OQ\5\36\20\2PM\3\2\2\2PN\3\2\2\2"+
		"PO\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\13\3\2\2\2TR\3\2\2\2UW\7\23"+
		"\2\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y`\3\2\2\2ZX\3\2\2\2[a\5\16"+
		"\b\2\\a\5\20\t\2]a\5\22\n\2^a\5\24\13\2_a\5\26\f\2`[\3\2\2\2`\\\3\2\2"+
		"\2`]\3\2\2\2`^\3\2\2\2`_\3\2\2\2ab\3\2\2\2bf\7\21\2\2ce\7\23\2\2dc\3\2"+
		"\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\r\3\2\2\2hf\3\2\2\2ij\7\6\2\2jk\5"+
		"\n\6\2kn\7\24\2\2lo\7\17\2\2mo\5\n\6\2nl\3\2\2\2nm\3\2\2\2o\17\3\2\2\2"+
		"pq\7\7\2\2qr\5\n\6\2rv\7\24\2\2sw\5\34\17\2tw\5\32\16\2uw\5\n\6\2vs\3"+
		"\2\2\2vt\3\2\2\2vu\3\2\2\2w{\3\2\2\2xz\5\30\r\2yx\3\2\2\2z}\3\2\2\2{y"+
		"\3\2\2\2{|\3\2\2\2|\21\3\2\2\2}{\3\2\2\2~\177\7\b\2\2\177\u0080\5\n\6"+
		"\2\u0080\u0081\7\24\2\2\u0081\u0082\7\t\2\2\u0082\u0086\5\34\17\2\u0083"+
		"\u0085\7\23\2\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3"+
		"\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089"+
		"\u008d\7\n\2\2\u008a\u008c\7\23\2\2\u008b\u008a\3\2\2\2\u008c\u008f\3"+
		"\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0090\3\2\2\2\u008f"+
		"\u008d\3\2\2\2\u0090\u0091\5\34\17\2\u0091\u0092\7\13\2\2\u0092\23\3\2"+
		"\2\2\u0093\u0094\7\f\2\2\u0094\u0095\5\n\6\2\u0095\u0096\7\24\2\2\u0096"+
		"\u0097\7\t\2\2\u0097\u009b\5\34\17\2\u0098\u009a\7\23\2\2\u0099\u0098"+
		"\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\u009e\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u00a2\7\n\2\2\u009f\u00a1\7\23"+
		"\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\u00a5\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a9\5\34"+
		"\17\2\u00a6\u00a8\7\23\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9"+
		"\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9\3\2"+
		"\2\2\u00ac\u00b0\7\n\2\2\u00ad\u00af\7\23\2\2\u00ae\u00ad\3\2\2\2\u00af"+
		"\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\3\2"+
		"\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b4\5\34\17\2\u00b4\u00b5\7\13\2\2\u00b5"+
		"\25\3\2\2\2\u00b6\u00b7\7\r\2\2\u00b7\u00b8\5\n\6\2\u00b8\u00b9\7\24\2"+
		"\2\u00b9\u00ba\7\t\2\2\u00ba\u00be\5\34\17\2\u00bb\u00bd\7\23\2\2\u00bc"+
		"\u00bb\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2"+
		"\2\2\u00bf\u00c1\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c5\7\n\2\2\u00c2"+
		"\u00c4\7\23\2\2\u00c3\u00c2\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3"+
		"\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8"+
		"\u00cc\5\34\17\2\u00c9\u00cb\7\23\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00ce"+
		"\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cf\3\2\2\2\u00ce"+
		"\u00cc\3\2\2\2\u00cf\u00d3\7\n\2\2\u00d0\u00d2\7\23\2\2\u00d1\u00d0\3"+
		"\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d6\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00da\5\34\17\2\u00d7\u00d9\7"+
		"\23\2\2\u00d8\u00d7\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00dd\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00e1\7\n"+
		"\2\2\u00de\u00e0\7\23\2\2\u00df\u00de\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1"+
		"\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00e1\3\2"+
		"\2\2\u00e4\u00e5\5\34\17\2\u00e5\u00e6\7\13\2\2\u00e6\27\3\2\2\2\u00e7"+
		"\u00e8\7\25\2\2\u00e8\u00ee\5\n\6\2\u00e9\u00ea\7\25\2\2\u00ea\u00ee\5"+
		"\34\17\2\u00eb\u00ec\7\25\2\2\u00ec\u00ee\5\32\16\2\u00ed\u00e7\3\2\2"+
		"\2\u00ed\u00e9\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\31\3\2\2\2\u00ef\u00f4"+
		"\7\26\2\2\u00f0\u00f5\5\n\6\2\u00f1\u00f5\5\34\17\2\u00f2\u00f5\5\32\16"+
		"\2\u00f3\u00f5\7\27\2\2\u00f4\u00f0\3\2\2\2\u00f4\u00f1\3\2\2\2\u00f4"+
		"\u00f2\3\2\2\2\u00f4\u00f3\3\2\2\2\u00f5\u00f9\3\2\2\2\u00f6\u00f8\5\30"+
		"\r\2\u00f7\u00f6\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9"+
		"\u00fa\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fd\7\13"+
		"\2\2\u00fd\33\3\2\2\2\u00fe\u00ff\t\3\2\2\u00ff\35\3\2\2\2\u0100\u0101"+
		"\7\27\2\2\u0101\37\3\2\2\2 $*\63\67<BIPRX`fnv{\u0086\u008d\u009b\u00a2"+
		"\u00a9\u00b0\u00be\u00c5\u00cc\u00d3\u00da\u00e1\u00ed\u00f4\u00f9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}