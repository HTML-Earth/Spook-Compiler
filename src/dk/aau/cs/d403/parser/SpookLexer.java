// Generated from C:/Users/the_p/Desktop/P4/src\SpookLexer.g4 by ANTLR 4.7.2
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
		NUM=1, BOOL=2, VECTOR2=3, VECTOR3=4, VECTOR4=5, VOID=6, MAIN=7, CLASS=8, 
		EXTENDS=9, IMPLEMENTS=10, RETURN=11, IF=12, ELSE_IF=13, ELSE=14, FOR=15, 
		TO=16, DIGIT=17, DIGIT_NEGATIVE=18, FLOAT_DIGIT=19, FLOAT_DIGIT_NEGATIVE=20, 
		BOOL_LITERAL=21, LEFT_BRACKET=22, RIGHT_BRACKET=23, LEFT_PAREN=24, RIGHT_PAREN=25, 
		DOT=26, COMMA=27, SEMICOLON=28, QUESTION=29, COLON=30, ASSIGN=31, ADD=32, 
		SUB=33, MOD=34, DIV=35, MUL=36, EQUAL=37, AND=38, OR=39, NOT_EQUAL=40, 
		NOT=41, GREATER_THAN=42, GREATER_OR_EQUAL=43, LESS_THAN=44, LESS_OR_EQUAL=45, 
		ID=46, COMMENT_STRING=47, WS=48;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NUM", "BOOL", "VECTOR2", "VECTOR3", "VECTOR4", "VOID", "MAIN", "CLASS", 
			"EXTENDS", "IMPLEMENTS", "RETURN", "IF", "ELSE_IF", "ELSE", "FOR", "TO", 
			"DIGIT", "DIGIT_NEGATIVE", "FLOAT_DIGIT", "FLOAT_DIGIT_NEGATIVE", "BOOL_LITERAL", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", "DOT", 
			"COMMA", "SEMICOLON", "QUESTION", "COLON", "ASSIGN", "ADD", "SUB", "MOD", 
			"DIV", "MUL", "EQUAL", "AND", "OR", "NOT_EQUAL", "NOT", "GREATER_THAN", 
			"GREATER_OR_EQUAL", "LESS_THAN", "LESS_OR_EQUAL", "ID", "LETTER", "DIGIT_RULE", 
			"DIGIT_NEGATIVE_RULE", "COMMENT_STRING", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Num'", "'Bool'", "'Vec2'", "'Vec3'", "'Vec4'", "'Void'", "'Shader'", 
			"'Class'", "'extends'", "'implements'", "'return'", "'if'", "'else if'", 
			"'else'", "'for'", "'to'", null, null, null, null, null, "'{'", "'}'", 
			"'('", "')'", "'.'", "','", "';'", "'?'", "':'", "'='", "'+'", "'-'", 
			"'%'", "'/'", "'*'", "'=='", "'&&'", "'||'", "'!='", "'!'", "'>'", "'>='", 
			"'<'", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NUM", "BOOL", "VECTOR2", "VECTOR3", "VECTOR4", "VOID", "MAIN", 
			"CLASS", "EXTENDS", "IMPLEMENTS", "RETURN", "IF", "ELSE_IF", "ELSE", 
			"FOR", "TO", "DIGIT", "DIGIT_NEGATIVE", "FLOAT_DIGIT", "FLOAT_DIGIT_NEGATIVE", 
			"BOOL_LITERAL", "LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", 
			"DOT", "COMMA", "SEMICOLON", "QUESTION", "COLON", "ASSIGN", "ADD", "SUB", 
			"MOD", "DIV", "MUL", "EQUAL", "AND", "OR", "NOT_EQUAL", "NOT", "GREATER_THAN", 
			"GREATER_OR_EQUAL", "LESS_THAN", "LESS_OR_EQUAL", "ID", "COMMENT_STRING", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\62\u0147\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\24\6\24\u00cc\n\24\r\24\16\24\u00cd\3\25\3\25\3\25\6\25\u00d3"+
		"\n\25\r\25\16\25\u00d4\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5"+
		"\26\u00e0\n\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3"+
		"%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3+\3+\3,\3,\3,\3-\3"+
		"-\3.\3.\3.\3/\3/\3/\7/\u011b\n/\f/\16/\u011e\13/\3\60\3\60\3\61\3\61\3"+
		"\61\7\61\u0125\n\61\f\61\16\61\u0128\13\61\5\61\u012a\n\61\3\62\3\62\3"+
		"\62\3\62\3\62\7\62\u0131\n\62\f\62\16\62\u0134\13\62\3\62\3\62\3\63\3"+
		"\63\7\63\u013a\n\63\f\63\16\63\u013d\13\63\3\63\3\63\3\64\6\64\u0142\n"+
		"\64\r\64\16\64\u0143\3\64\3\64\2\2\65\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\2a\2c\2e\61g\62\3\2\5\3\2C|\4\2\13\f\17\17\5\2\13\f\17\17\"\"\2"+
		"\u014d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3"+
		"\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2e\3\2\2"+
		"\2\2g\3\2\2\2\3i\3\2\2\2\5m\3\2\2\2\7r\3\2\2\2\tw\3\2\2\2\13|\3\2\2\2"+
		"\r\u0081\3\2\2\2\17\u0086\3\2\2\2\21\u008d\3\2\2\2\23\u0093\3\2\2\2\25"+
		"\u009b\3\2\2\2\27\u00a6\3\2\2\2\31\u00ad\3\2\2\2\33\u00b0\3\2\2\2\35\u00b8"+
		"\3\2\2\2\37\u00bd\3\2\2\2!\u00c1\3\2\2\2#\u00c4\3\2\2\2%\u00c6\3\2\2\2"+
		"\'\u00c8\3\2\2\2)\u00cf\3\2\2\2+\u00df\3\2\2\2-\u00e1\3\2\2\2/\u00e3\3"+
		"\2\2\2\61\u00e5\3\2\2\2\63\u00e7\3\2\2\2\65\u00e9\3\2\2\2\67\u00eb\3\2"+
		"\2\29\u00ed\3\2\2\2;\u00ef\3\2\2\2=\u00f1\3\2\2\2?\u00f3\3\2\2\2A\u00f5"+
		"\3\2\2\2C\u00f7\3\2\2\2E\u00f9\3\2\2\2G\u00fb\3\2\2\2I\u00fd\3\2\2\2K"+
		"\u00ff\3\2\2\2M\u0102\3\2\2\2O\u0105\3\2\2\2Q\u0108\3\2\2\2S\u010b\3\2"+
		"\2\2U\u010d\3\2\2\2W\u010f\3\2\2\2Y\u0112\3\2\2\2[\u0114\3\2\2\2]\u0117"+
		"\3\2\2\2_\u011f\3\2\2\2a\u0129\3\2\2\2c\u012b\3\2\2\2e\u0137\3\2\2\2g"+
		"\u0141\3\2\2\2ij\7P\2\2jk\7w\2\2kl\7o\2\2l\4\3\2\2\2mn\7D\2\2no\7q\2\2"+
		"op\7q\2\2pq\7n\2\2q\6\3\2\2\2rs\7X\2\2st\7g\2\2tu\7e\2\2uv\7\64\2\2v\b"+
		"\3\2\2\2wx\7X\2\2xy\7g\2\2yz\7e\2\2z{\7\65\2\2{\n\3\2\2\2|}\7X\2\2}~\7"+
		"g\2\2~\177\7e\2\2\177\u0080\7\66\2\2\u0080\f\3\2\2\2\u0081\u0082\7X\2"+
		"\2\u0082\u0083\7q\2\2\u0083\u0084\7k\2\2\u0084\u0085\7f\2\2\u0085\16\3"+
		"\2\2\2\u0086\u0087\7U\2\2\u0087\u0088\7j\2\2\u0088\u0089\7c\2\2\u0089"+
		"\u008a\7f\2\2\u008a\u008b\7g\2\2\u008b\u008c\7t\2\2\u008c\20\3\2\2\2\u008d"+
		"\u008e\7E\2\2\u008e\u008f\7n\2\2\u008f\u0090\7c\2\2\u0090\u0091\7u\2\2"+
		"\u0091\u0092\7u\2\2\u0092\22\3\2\2\2\u0093\u0094\7g\2\2\u0094\u0095\7"+
		"z\2\2\u0095\u0096\7v\2\2\u0096\u0097\7g\2\2\u0097\u0098\7p\2\2\u0098\u0099"+
		"\7f\2\2\u0099\u009a\7u\2\2\u009a\24\3\2\2\2\u009b\u009c\7k\2\2\u009c\u009d"+
		"\7o\2\2\u009d\u009e\7r\2\2\u009e\u009f\7n\2\2\u009f\u00a0\7g\2\2\u00a0"+
		"\u00a1\7o\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7p\2\2\u00a3\u00a4\7v\2\2"+
		"\u00a4\u00a5\7u\2\2\u00a5\26\3\2\2\2\u00a6\u00a7\7t\2\2\u00a7\u00a8\7"+
		"g\2\2\u00a8\u00a9\7v\2\2\u00a9\u00aa\7w\2\2\u00aa\u00ab\7t\2\2\u00ab\u00ac"+
		"\7p\2\2\u00ac\30\3\2\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7h\2\2\u00af\32"+
		"\3\2\2\2\u00b0\u00b1\7g\2\2\u00b1\u00b2\7n\2\2\u00b2\u00b3\7u\2\2\u00b3"+
		"\u00b4\7g\2\2\u00b4\u00b5\7\"\2\2\u00b5\u00b6\7k\2\2\u00b6\u00b7\7h\2"+
		"\2\u00b7\34\3\2\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba\7n\2\2\u00ba\u00bb"+
		"\7u\2\2\u00bb\u00bc\7g\2\2\u00bc\36\3\2\2\2\u00bd\u00be\7h\2\2\u00be\u00bf"+
		"\7q\2\2\u00bf\u00c0\7t\2\2\u00c0 \3\2\2\2\u00c1\u00c2\7v\2\2\u00c2\u00c3"+
		"\7q\2\2\u00c3\"\3\2\2\2\u00c4\u00c5\5a\61\2\u00c5$\3\2\2\2\u00c6\u00c7"+
		"\5c\62\2\u00c7&\3\2\2\2\u00c8\u00c9\5#\22\2\u00c9\u00cb\7\60\2\2\u00ca"+
		"\u00cc\5#\22\2\u00cb\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cb\3\2"+
		"\2\2\u00cd\u00ce\3\2\2\2\u00ce(\3\2\2\2\u00cf\u00d0\5%\23\2\u00d0\u00d2"+
		"\7\60\2\2\u00d1\u00d3\5#\22\2\u00d2\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2"+
		"\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5*\3\2\2\2\u00d6\u00d7\7"+
		"v\2\2\u00d7\u00d8\7t\2\2\u00d8\u00d9\7w\2\2\u00d9\u00e0\7g\2\2\u00da\u00db"+
		"\7h\2\2\u00db\u00dc\7c\2\2\u00dc\u00dd\7n\2\2\u00dd\u00de\7u\2\2\u00de"+
		"\u00e0\7g\2\2\u00df\u00d6\3\2\2\2\u00df\u00da\3\2\2\2\u00e0,\3\2\2\2\u00e1"+
		"\u00e2\7}\2\2\u00e2.\3\2\2\2\u00e3\u00e4\7\177\2\2\u00e4\60\3\2\2\2\u00e5"+
		"\u00e6\7*\2\2\u00e6\62\3\2\2\2\u00e7\u00e8\7+\2\2\u00e8\64\3\2\2\2\u00e9"+
		"\u00ea\7\60\2\2\u00ea\66\3\2\2\2\u00eb\u00ec\7.\2\2\u00ec8\3\2\2\2\u00ed"+
		"\u00ee\7=\2\2\u00ee:\3\2\2\2\u00ef\u00f0\7A\2\2\u00f0<\3\2\2\2\u00f1\u00f2"+
		"\7<\2\2\u00f2>\3\2\2\2\u00f3\u00f4\7?\2\2\u00f4@\3\2\2\2\u00f5\u00f6\7"+
		"-\2\2\u00f6B\3\2\2\2\u00f7\u00f8\7/\2\2\u00f8D\3\2\2\2\u00f9\u00fa\7\'"+
		"\2\2\u00faF\3\2\2\2\u00fb\u00fc\7\61\2\2\u00fcH\3\2\2\2\u00fd\u00fe\7"+
		",\2\2\u00feJ\3\2\2\2\u00ff\u0100\7?\2\2\u0100\u0101\7?\2\2\u0101L\3\2"+
		"\2\2\u0102\u0103\7(\2\2\u0103\u0104\7(\2\2\u0104N\3\2\2\2\u0105\u0106"+
		"\7~\2\2\u0106\u0107\7~\2\2\u0107P\3\2\2\2\u0108\u0109\7#\2\2\u0109\u010a"+
		"\7?\2\2\u010aR\3\2\2\2\u010b\u010c\7#\2\2\u010cT\3\2\2\2\u010d\u010e\7"+
		"@\2\2\u010eV\3\2\2\2\u010f\u0110\7@\2\2\u0110\u0111\7?\2\2\u0111X\3\2"+
		"\2\2\u0112\u0113\7>\2\2\u0113Z\3\2\2\2\u0114\u0115\7>\2\2\u0115\u0116"+
		"\7?\2\2\u0116\\\3\2\2\2\u0117\u011c\5_\60\2\u0118\u011b\5_\60\2\u0119"+
		"\u011b\5#\22\2\u011a\u0118\3\2\2\2\u011a\u0119\3\2\2\2\u011b\u011e\3\2"+
		"\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d^\3\2\2\2\u011e\u011c"+
		"\3\2\2\2\u011f\u0120\t\2\2\2\u0120`\3\2\2\2\u0121\u012a\7\62\2\2\u0122"+
		"\u0126\4\63;\2\u0123\u0125\4\62;\2\u0124\u0123\3\2\2\2\u0125\u0128\3\2"+
		"\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u012a\3\2\2\2\u0128"+
		"\u0126\3\2\2\2\u0129\u0121\3\2\2\2\u0129\u0122\3\2\2\2\u012ab\3\2\2\2"+
		"\u012b\u012c\7*\2\2\u012c\u012d\7/\2\2\u012d\u012e\3\2\2\2\u012e\u0132"+
		"\4\63;\2\u012f\u0131\4\62;\2\u0130\u012f\3\2\2\2\u0131\u0134\3\2\2\2\u0132"+
		"\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0135\3\2\2\2\u0134\u0132\3\2"+
		"\2\2\u0135\u0136\7+\2\2\u0136d\3\2\2\2\u0137\u013b\7%\2\2\u0138\u013a"+
		"\n\3\2\2\u0139\u0138\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\u013e\3\2\2\2\u013d\u013b\3\2\2\2\u013e\u013f\b\63"+
		"\2\2\u013ff\3\2\2\2\u0140\u0142\t\4\2\2\u0141\u0140\3\2\2\2\u0142\u0143"+
		"\3\2\2\2\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\3\2\2\2\u0145"+
		"\u0146\b\64\2\2\u0146h\3\2\2\2\r\2\u00cd\u00d4\u00df\u011a\u011c\u0126"+
		"\u0129\u0132\u013b\u0143\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}