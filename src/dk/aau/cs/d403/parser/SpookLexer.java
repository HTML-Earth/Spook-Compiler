// Generated from C:/Programming/P4/src\Spook.g4 by ANTLR 4.7.2
package dk.aau.cs.d403.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SpookLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, LETTER=12, DIGIT=13, FLOAT_DIGIT=14, SEMICOLON=15, 
		NEWLINE=16, SPACE=17, ASSIGN=18, OPERATOR=19, MATH_FUNCTION=20, UNIFORM=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "LETTER", "DIGIT", "FLOAT_DIGIT", "SEMICOLON", "NEWLINE", 
			"SPACE", "ASSIGN", "OPERATOR", "MATH_FUNCTION", "UNIFORM"
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


	public SpookLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Spook.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u00bc\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\7\16p\n\16\f\16\16\16s\13"+
		"\16\3\16\3\16\3\16\3\16\3\16\7\16z\n\16\f\16\16\16}\13\16\3\16\5\16\u0080"+
		"\n\16\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\7\23\u008d"+
		"\n\23\f\23\16\23\u0090\13\23\3\23\3\23\7\23\u0094\n\23\f\23\16\23\u0097"+
		"\13\23\3\24\7\24\u009a\n\24\f\24\16\24\u009d\13\24\3\24\3\24\7\24\u00a1"+
		"\n\24\f\24\16\24\u00a4\13\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00b6\n\25\3\26\3\26\3\26"+
		"\3\26\3\26\2\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27\3\2\3\6\2\'\',-//\61\61"+
		"\2\u00c6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2"+
		"\58\3\2\2\2\7:\3\2\2\2\t=\3\2\2\2\13B\3\2\2\2\rI\3\2\2\2\17R\3\2\2\2\21"+
		"T\3\2\2\2\23V\3\2\2\2\25X\3\2\2\2\27a\3\2\2\2\31j\3\2\2\2\33\177\3\2\2"+
		"\2\35\u0081\3\2\2\2\37\u0085\3\2\2\2!\u0087\3\2\2\2#\u0089\3\2\2\2%\u008e"+
		"\3\2\2\2\'\u009b\3\2\2\2)\u00b5\3\2\2\2+\u00b7\3\2\2\2-.\7u\2\2./\7j\2"+
		"\2/\60\7c\2\2\60\61\7f\2\2\61\62\7g\2\2\62\63\7t\2\2\63\64\7*\2\2\64\65"+
		"\7+\2\2\65\66\7\"\2\2\66\67\7}\2\2\67\4\3\2\2\289\7\177\2\29\6\3\2\2\2"+
		":;\7\61\2\2;<\7\61\2\2<\b\3\2\2\2=>\7k\2\2>?\7p\2\2?@\7v\2\2@A\7\"\2\2"+
		"A\n\3\2\2\2BC\7h\2\2CD\7n\2\2DE\7q\2\2EF\7c\2\2FG\7v\2\2GH\7\"\2\2H\f"+
		"\3\2\2\2IJ\7x\2\2JK\7g\2\2KL\7e\2\2LM\7v\2\2MN\7q\2\2NO\7t\2\2OP\7\64"+
		"\2\2PQ\7\"\2\2Q\16\3\2\2\2RS\7*\2\2S\20\3\2\2\2TU\7.\2\2U\22\3\2\2\2V"+
		"W\7+\2\2W\24\3\2\2\2XY\7x\2\2YZ\7g\2\2Z[\7e\2\2[\\\7v\2\2\\]\7q\2\2]^"+
		"\7t\2\2^_\7\65\2\2_`\7\"\2\2`\26\3\2\2\2ab\7x\2\2bc\7g\2\2cd\7e\2\2de"+
		"\7v\2\2ef\7q\2\2fg\7t\2\2gh\7\66\2\2hi\7\"\2\2i\30\3\2\2\2jk\4C|\2k\32"+
		"\3\2\2\2l\u0080\7\62\2\2mq\4\63;\2np\4\62;\2on\3\2\2\2ps\3\2\2\2qo\3\2"+
		"\2\2qr\3\2\2\2r\u0080\3\2\2\2sq\3\2\2\2tu\7*\2\2uv\7/\2\2vw\3\2\2\2w{"+
		"\4\63;\2xz\4\62;\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|~\3\2\2\2}"+
		"{\3\2\2\2~\u0080\7+\2\2\177l\3\2\2\2\177m\3\2\2\2\177t\3\2\2\2\u0080\34"+
		"\3\2\2\2\u0081\u0082\5\33\16\2\u0082\u0083\7\60\2\2\u0083\u0084\5\33\16"+
		"\2\u0084\36\3\2\2\2\u0085\u0086\7=\2\2\u0086 \3\2\2\2\u0087\u0088\7\f"+
		"\2\2\u0088\"\3\2\2\2\u0089\u008a\7\"\2\2\u008a$\3\2\2\2\u008b\u008d\5"+
		"#\22\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0095\7?"+
		"\2\2\u0092\u0094\5#\22\2\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095"+
		"\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096&\3\2\2\2\u0097\u0095\3\2\2\2"+
		"\u0098\u009a\5#\22\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099"+
		"\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009e\3\2\2\2\u009d\u009b\3\2\2\2\u009e"+
		"\u00a2\t\2\2\2\u009f\u00a1\5#\22\2\u00a0\u009f\3\2\2\2\u00a1\u00a4\3\2"+
		"\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3(\3\2\2\2\u00a4\u00a2"+
		"\3\2\2\2\u00a5\u00a6\7c\2\2\u00a6\u00a7\7d\2\2\u00a7\u00a8\7u\2\2\u00a8"+
		"\u00b6\7*\2\2\u00a9\u00aa\7u\2\2\u00aa\u00ab\7k\2\2\u00ab\u00ac\7p\2\2"+
		"\u00ac\u00b6\7*\2\2\u00ad\u00ae\7e\2\2\u00ae\u00af\7q\2\2\u00af\u00b0"+
		"\7u\2\2\u00b0\u00b6\7*\2\2\u00b1\u00b2\7v\2\2\u00b2\u00b3\7c\2\2\u00b3"+
		"\u00b4\7p\2\2\u00b4\u00b6\7*\2\2\u00b5\u00a5\3\2\2\2\u00b5\u00a9\3\2\2"+
		"\2\u00b5\u00ad\3\2\2\2\u00b5\u00b1\3\2\2\2\u00b6*\3\2\2\2\u00b7\u00b8"+
		"\7V\2\2\u00b8\u00b9\7k\2\2\u00b9\u00ba\7o\2\2\u00ba\u00bb\7g\2\2\u00bb"+
		",\3\2\2\2\13\2q{\177\u008e\u0095\u009b\u00a2\u00b5\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}