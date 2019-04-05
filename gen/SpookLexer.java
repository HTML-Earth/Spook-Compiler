// Generated from /Users/Garrido/PycharmProjects/PythonProjects/P4/src/SpookLexer.g4 by ANTLR 4.7.2
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
		MAIN=1, INT=2, FLOAT=3, BOOL=4, VECTOR2=5, VECTOR3=6, VECTOR4=7, ID=8, 
		DIGIT=9, FLOAT_DIGIT=10, SEMICOLON=11, DOUBLE_SLASH=12, ASSIGN=13, BOOLOPERATOR=14, 
		OPERATOR=15, MATH_FUNCTION=16, UNIFORM=17, COMMENT_STRING=18, WS=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"MAIN", "INT", "FLOAT", "BOOL", "VECTOR2", "VECTOR3", "VECTOR4", "ID", 
			"DIGIT", "FLOAT_DIGIT", "SEMICOLON", "DOUBLE_SLASH", "ASSIGN", "BOOLOPERATOR", 
			"OPERATOR", "MATH_FUNCTION", "UNIFORM", "COMMENT_STRING", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Shader'", "'int'", "'float'", "'bool'", "'vector2'", "'vector3'", 
			"'vector4'", null, null, null, "';'", "'//'", "'='", null, null, null, 
			"'Time'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "MAIN", "INT", "FLOAT", "BOOL", "VECTOR2", "VECTOR3", "VECTOR4", 
			"ID", "DIGIT", "FLOAT_DIGIT", "SEMICOLON", "DOUBLE_SLASH", "ASSIGN", 
			"BOOLOPERATOR", "OPERATOR", "MATH_FUNCTION", "UNIFORM", "COMMENT_STRING", 
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


	public SpookLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SpookLexer.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u00b1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\t\6\tY\n\t\r\t\16\tZ\3\n\3\n\3\n\7\n`\n\n\f\n\16\nc\13\n\3\n\3\n\3"+
		"\n\3\n\3\n\7\nj\n\n\f\n\16\nm\13\n\3\n\5\np\n\n\3\13\3\13\3\13\6\13u\n"+
		"\13\r\13\16\13v\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\5\17\u0089\n\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u009d\n\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\7\23\u00a6\n\23\f\23\16\23\u00a9\13"+
		"\23\3\24\6\24\u00ac\n\24\r\24\16\24\u00ad\3\24\3\24\2\2\25\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25\3\2\6\3\2C|\6\2\'\',-//\61\61\4\2\13\f\17\17\5\2\13\f\17\17"+
		"\"\"\2\u00bf\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5\60\3\2\2\2\7\64\3"+
		"\2\2\2\t:\3\2\2\2\13?\3\2\2\2\rG\3\2\2\2\17O\3\2\2\2\21X\3\2\2\2\23o\3"+
		"\2\2\2\25q\3\2\2\2\27x\3\2\2\2\31z\3\2\2\2\33}\3\2\2\2\35\u0088\3\2\2"+
		"\2\37\u008a\3\2\2\2!\u009c\3\2\2\2#\u009e\3\2\2\2%\u00a3\3\2\2\2\'\u00ab"+
		"\3\2\2\2)*\7U\2\2*+\7j\2\2+,\7c\2\2,-\7f\2\2-.\7g\2\2./\7t\2\2/\4\3\2"+
		"\2\2\60\61\7k\2\2\61\62\7p\2\2\62\63\7v\2\2\63\6\3\2\2\2\64\65\7h\2\2"+
		"\65\66\7n\2\2\66\67\7q\2\2\678\7c\2\289\7v\2\29\b\3\2\2\2:;\7d\2\2;<\7"+
		"q\2\2<=\7q\2\2=>\7n\2\2>\n\3\2\2\2?@\7x\2\2@A\7g\2\2AB\7e\2\2BC\7v\2\2"+
		"CD\7q\2\2DE\7t\2\2EF\7\64\2\2F\f\3\2\2\2GH\7x\2\2HI\7g\2\2IJ\7e\2\2JK"+
		"\7v\2\2KL\7q\2\2LM\7t\2\2MN\7\65\2\2N\16\3\2\2\2OP\7x\2\2PQ\7g\2\2QR\7"+
		"e\2\2RS\7v\2\2ST\7q\2\2TU\7t\2\2UV\7\66\2\2V\20\3\2\2\2WY\t\2\2\2XW\3"+
		"\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\22\3\2\2\2\\p\7\62\2\2]a\4\63;\2"+
		"^`\4\62;\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2bp\3\2\2\2ca\3\2\2\2"+
		"de\7*\2\2ef\7/\2\2fg\3\2\2\2gk\4\63;\2hj\4\62;\2ih\3\2\2\2jm\3\2\2\2k"+
		"i\3\2\2\2kl\3\2\2\2ln\3\2\2\2mk\3\2\2\2np\7+\2\2o\\\3\2\2\2o]\3\2\2\2"+
		"od\3\2\2\2p\24\3\2\2\2qr\5\23\n\2rt\7\60\2\2su\5\23\n\2ts\3\2\2\2uv\3"+
		"\2\2\2vt\3\2\2\2vw\3\2\2\2w\26\3\2\2\2xy\7=\2\2y\30\3\2\2\2z{\7\61\2\2"+
		"{|\7\61\2\2|\32\3\2\2\2}~\7?\2\2~\34\3\2\2\2\177\u0080\7?\2\2\u0080\u0089"+
		"\7?\2\2\u0081\u0082\7~\2\2\u0082\u0089\7~\2\2\u0083\u0084\7(\2\2\u0084"+
		"\u0089\7(\2\2\u0085\u0086\7#\2\2\u0086\u0089\7?\2\2\u0087\u0089\7#\2\2"+
		"\u0088\177\3\2\2\2\u0088\u0081\3\2\2\2\u0088\u0083\3\2\2\2\u0088\u0085"+
		"\3\2\2\2\u0088\u0087\3\2\2\2\u0089\36\3\2\2\2\u008a\u008b\t\3\2\2\u008b"+
		" \3\2\2\2\u008c\u008d\7c\2\2\u008d\u008e\7d\2\2\u008e\u008f\7u\2\2\u008f"+
		"\u009d\7*\2\2\u0090\u0091\7u\2\2\u0091\u0092\7k\2\2\u0092\u0093\7p\2\2"+
		"\u0093\u009d\7*\2\2\u0094\u0095\7e\2\2\u0095\u0096\7q\2\2\u0096\u0097"+
		"\7u\2\2\u0097\u009d\7*\2\2\u0098\u0099\7v\2\2\u0099\u009a\7c\2\2\u009a"+
		"\u009b\7p\2\2\u009b\u009d\7*\2\2\u009c\u008c\3\2\2\2\u009c\u0090\3\2\2"+
		"\2\u009c\u0094\3\2\2\2\u009c\u0098\3\2\2\2\u009d\"\3\2\2\2\u009e\u009f"+
		"\7V\2\2\u009f\u00a0\7k\2\2\u00a0\u00a1\7o\2\2\u00a1\u00a2\7g\2\2\u00a2"+
		"$\3\2\2\2\u00a3\u00a7\7%\2\2\u00a4\u00a6\n\4\2\2\u00a5\u00a4\3\2\2\2\u00a6"+
		"\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8&\3\2\2\2"+
		"\u00a9\u00a7\3\2\2\2\u00aa\u00ac\t\5\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00ad"+
		"\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		"\u00b0\b\24\2\2\u00b0(\3\2\2\2\f\2Zakov\u0088\u009c\u00a7\u00ad\3\b\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}