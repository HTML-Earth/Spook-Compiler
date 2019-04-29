// Generated from C:/Programming/P4/src\SpookLexer.g4 by ANTLR 4.7.2
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
		INT=1, FLOAT=2, BOOL=3, VECTOR2=4, VECTOR3=5, VECTOR4=6, VOID=7, MAIN=8, 
		CLASS=9, EXTENDS=10, IMPLEMENTS=11, RETURN=12, IF=13, ELSE_IF=14, ELSE=15, 
		FOR=16, TO=17, DIGIT=18, DIGIT_NEGATIVE=19, FLOAT_DIGIT=20, FLOAT_DIGIT_NEGATIVE=21, 
		BOOL_LITERAL=22, LEFT_BRACKET=23, RIGHT_BRACKET=24, LEFT_PAREN=25, RIGHT_PAREN=26, 
		DOT=27, COMMA=28, SEMICOLON=29, QUESTION=30, COLON=31, ASSIGN=32, ADD=33, 
		SUB=34, MOD=35, DIV=36, MUL=37, EQUAL=38, AND=39, OR=40, NOT_EQUAL=41, 
		NOT=42, COORDINATE_SWIZZLE_MASK=43, COLOR_SWIZZLE_MASK=44, ABS=45, SIN=46, 
		COS=47, TAN=48, UNIFORM=49, ID=50, COMMENT_STRING=51, WS=52;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT", "FLOAT", "BOOL", "VECTOR2", "VECTOR3", "VECTOR4", "VOID", "MAIN", 
			"CLASS", "EXTENDS", "IMPLEMENTS", "RETURN", "IF", "ELSE_IF", "ELSE", 
			"FOR", "TO", "DIGIT", "DIGIT_NEGATIVE", "FLOAT_DIGIT", "FLOAT_DIGIT_NEGATIVE", 
			"BOOL_LITERAL", "LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", 
			"DOT", "COMMA", "SEMICOLON", "QUESTION", "COLON", "ASSIGN", "ADD", "SUB", 
			"MOD", "DIV", "MUL", "EQUAL", "AND", "OR", "NOT_EQUAL", "NOT", "COORDINATE_SWIZZLE_MASK", 
			"COLOR_SWIZZLE_MASK", "ABS", "SIN", "COS", "TAN", "UNIFORM", "ID", "LETTER", 
			"DIGIT_RULE", "DIGIT_NEGATIVE_RULE", "COORDINATE_SWIZZLE_MASK_RULE", 
			"COLOR_SWIZZLE_MASK_RULE", "COMMENT_STRING", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Int'", "'Float'", "'Bool'", "'Vec2'", "'Vec3'", "'Vec4'", "'Void'", 
			"'Shader'", "'Class'", "'extends'", "'implements'", "'return'", "'if'", 
			"'else if'", "'else'", "'for'", "'to'", null, null, null, null, null, 
			"'{'", "'}'", "'('", "')'", "'.'", "','", "';'", "'?'", "':'", "'='", 
			"'+'", "'-'", "'%'", "'/'", "'*'", "'=='", "'&&'", "'||'", "'!='", "'!'", 
			null, null, "'abs'", "'sin'", "'cos'", "'tan'", "'Time'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "FLOAT", "BOOL", "VECTOR2", "VECTOR3", "VECTOR4", "VOID", 
			"MAIN", "CLASS", "EXTENDS", "IMPLEMENTS", "RETURN", "IF", "ELSE_IF", 
			"ELSE", "FOR", "TO", "DIGIT", "DIGIT_NEGATIVE", "FLOAT_DIGIT", "FLOAT_DIGIT_NEGATIVE", 
			"BOOL_LITERAL", "LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", 
			"DOT", "COMMA", "SEMICOLON", "QUESTION", "COLON", "ASSIGN", "ADD", "SUB", 
			"MOD", "DIV", "MUL", "EQUAL", "AND", "OR", "NOT_EQUAL", "NOT", "COORDINATE_SWIZZLE_MASK", 
			"COLOR_SWIZZLE_MASK", "ABS", "SIN", "COS", "TAN", "UNIFORM", "ID", "COMMENT_STRING", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\66\u016e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3"+
		"\24\3\25\3\25\3\25\6\25\u00de\n\25\r\25\16\25\u00df\3\26\3\26\3\26\6\26"+
		"\u00e5\n\26\r\26\16\26\u00e6\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\5\27\u00f2\n\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34"+
		"\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3"+
		"&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3,\6,\u0121\n,\r,\16"+
		",\u0122\3-\6-\u0126\n-\r-\16-\u0127\3.\3.\3.\3.\3/\3/\3/\3/\3\60\3\60"+
		"\3\60\3\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\63\3\63\6\63"+
		"\u0141\n\63\r\63\16\63\u0142\3\64\3\64\3\65\3\65\3\65\7\65\u014a\n\65"+
		"\f\65\16\65\u014d\13\65\5\65\u014f\n\65\3\66\3\66\3\66\3\66\3\66\7\66"+
		"\u0156\n\66\f\66\16\66\u0159\13\66\3\66\3\66\3\67\3\67\38\38\39\39\79"+
		"\u0163\n9\f9\169\u0166\139\3:\6:\u0169\n:\r:\16:\u016a\3:\3:\2\2;\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\2i\2k\2m\2o\2q\65"+
		"s\66\3\2\6\3\2C|\5\2cdiitt\4\2\13\f\17\17\5\2\13\f\17\17\"\"\2\u0174\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U"+
		"\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2"+
		"\2\2\2c\3\2\2\2\2e\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\3u\3\2\2\2\5y\3\2\2\2"+
		"\7\177\3\2\2\2\t\u0084\3\2\2\2\13\u0089\3\2\2\2\r\u008e\3\2\2\2\17\u0093"+
		"\3\2\2\2\21\u0098\3\2\2\2\23\u009f\3\2\2\2\25\u00a5\3\2\2\2\27\u00ad\3"+
		"\2\2\2\31\u00b8\3\2\2\2\33\u00bf\3\2\2\2\35\u00c2\3\2\2\2\37\u00ca\3\2"+
		"\2\2!\u00cf\3\2\2\2#\u00d3\3\2\2\2%\u00d6\3\2\2\2\'\u00d8\3\2\2\2)\u00da"+
		"\3\2\2\2+\u00e1\3\2\2\2-\u00f1\3\2\2\2/\u00f3\3\2\2\2\61\u00f5\3\2\2\2"+
		"\63\u00f7\3\2\2\2\65\u00f9\3\2\2\2\67\u00fb\3\2\2\29\u00fd\3\2\2\2;\u00ff"+
		"\3\2\2\2=\u0101\3\2\2\2?\u0103\3\2\2\2A\u0105\3\2\2\2C\u0107\3\2\2\2E"+
		"\u0109\3\2\2\2G\u010b\3\2\2\2I\u010d\3\2\2\2K\u010f\3\2\2\2M\u0111\3\2"+
		"\2\2O\u0114\3\2\2\2Q\u0117\3\2\2\2S\u011a\3\2\2\2U\u011d\3\2\2\2W\u0120"+
		"\3\2\2\2Y\u0125\3\2\2\2[\u0129\3\2\2\2]\u012d\3\2\2\2_\u0131\3\2\2\2a"+
		"\u0135\3\2\2\2c\u0139\3\2\2\2e\u0140\3\2\2\2g\u0144\3\2\2\2i\u014e\3\2"+
		"\2\2k\u0150\3\2\2\2m\u015c\3\2\2\2o\u015e\3\2\2\2q\u0160\3\2\2\2s\u0168"+
		"\3\2\2\2uv\7K\2\2vw\7p\2\2wx\7v\2\2x\4\3\2\2\2yz\7H\2\2z{\7n\2\2{|\7q"+
		"\2\2|}\7c\2\2}~\7v\2\2~\6\3\2\2\2\177\u0080\7D\2\2\u0080\u0081\7q\2\2"+
		"\u0081\u0082\7q\2\2\u0082\u0083\7n\2\2\u0083\b\3\2\2\2\u0084\u0085\7X"+
		"\2\2\u0085\u0086\7g\2\2\u0086\u0087\7e\2\2\u0087\u0088\7\64\2\2\u0088"+
		"\n\3\2\2\2\u0089\u008a\7X\2\2\u008a\u008b\7g\2\2\u008b\u008c\7e\2\2\u008c"+
		"\u008d\7\65\2\2\u008d\f\3\2\2\2\u008e\u008f\7X\2\2\u008f\u0090\7g\2\2"+
		"\u0090\u0091\7e\2\2\u0091\u0092\7\66\2\2\u0092\16\3\2\2\2\u0093\u0094"+
		"\7X\2\2\u0094\u0095\7q\2\2\u0095\u0096\7k\2\2\u0096\u0097\7f\2\2\u0097"+
		"\20\3\2\2\2\u0098\u0099\7U\2\2\u0099\u009a\7j\2\2\u009a\u009b\7c\2\2\u009b"+
		"\u009c\7f\2\2\u009c\u009d\7g\2\2\u009d\u009e\7t\2\2\u009e\22\3\2\2\2\u009f"+
		"\u00a0\7E\2\2\u00a0\u00a1\7n\2\2\u00a1\u00a2\7c\2\2\u00a2\u00a3\7u\2\2"+
		"\u00a3\u00a4\7u\2\2\u00a4\24\3\2\2\2\u00a5\u00a6\7g\2\2\u00a6\u00a7\7"+
		"z\2\2\u00a7\u00a8\7v\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7p\2\2\u00aa\u00ab"+
		"\7f\2\2\u00ab\u00ac\7u\2\2\u00ac\26\3\2\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af"+
		"\7o\2\2\u00af\u00b0\7r\2\2\u00b0\u00b1\7n\2\2\u00b1\u00b2\7g\2\2\u00b2"+
		"\u00b3\7o\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5\7p\2\2\u00b5\u00b6\7v\2\2"+
		"\u00b6\u00b7\7u\2\2\u00b7\30\3\2\2\2\u00b8\u00b9\7t\2\2\u00b9\u00ba\7"+
		"g\2\2\u00ba\u00bb\7v\2\2\u00bb\u00bc\7w\2\2\u00bc\u00bd\7t\2\2\u00bd\u00be"+
		"\7p\2\2\u00be\32\3\2\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c1\7h\2\2\u00c1\34"+
		"\3\2\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4\7n\2\2\u00c4\u00c5\7u\2\2\u00c5"+
		"\u00c6\7g\2\2\u00c6\u00c7\7\"\2\2\u00c7\u00c8\7k\2\2\u00c8\u00c9\7h\2"+
		"\2\u00c9\36\3\2\2\2\u00ca\u00cb\7g\2\2\u00cb\u00cc\7n\2\2\u00cc\u00cd"+
		"\7u\2\2\u00cd\u00ce\7g\2\2\u00ce \3\2\2\2\u00cf\u00d0\7h\2\2\u00d0\u00d1"+
		"\7q\2\2\u00d1\u00d2\7t\2\2\u00d2\"\3\2\2\2\u00d3\u00d4\7v\2\2\u00d4\u00d5"+
		"\7q\2\2\u00d5$\3\2\2\2\u00d6\u00d7\5i\65\2\u00d7&\3\2\2\2\u00d8\u00d9"+
		"\5k\66\2\u00d9(\3\2\2\2\u00da\u00db\5%\23\2\u00db\u00dd\7\60\2\2\u00dc"+
		"\u00de\5%\23\2\u00dd\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00dd\3\2"+
		"\2\2\u00df\u00e0\3\2\2\2\u00e0*\3\2\2\2\u00e1\u00e2\5\'\24\2\u00e2\u00e4"+
		"\7\60\2\2\u00e3\u00e5\5%\23\2\u00e4\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2"+
		"\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7,\3\2\2\2\u00e8\u00e9\7"+
		"v\2\2\u00e9\u00ea\7t\2\2\u00ea\u00eb\7w\2\2\u00eb\u00f2\7g\2\2\u00ec\u00ed"+
		"\7h\2\2\u00ed\u00ee\7c\2\2\u00ee\u00ef\7n\2\2\u00ef\u00f0\7u\2\2\u00f0"+
		"\u00f2\7g\2\2\u00f1\u00e8\3\2\2\2\u00f1\u00ec\3\2\2\2\u00f2.\3\2\2\2\u00f3"+
		"\u00f4\7}\2\2\u00f4\60\3\2\2\2\u00f5\u00f6\7\177\2\2\u00f6\62\3\2\2\2"+
		"\u00f7\u00f8\7*\2\2\u00f8\64\3\2\2\2\u00f9\u00fa\7+\2\2\u00fa\66\3\2\2"+
		"\2\u00fb\u00fc\7\60\2\2\u00fc8\3\2\2\2\u00fd\u00fe\7.\2\2\u00fe:\3\2\2"+
		"\2\u00ff\u0100\7=\2\2\u0100<\3\2\2\2\u0101\u0102\7A\2\2\u0102>\3\2\2\2"+
		"\u0103\u0104\7<\2\2\u0104@\3\2\2\2\u0105\u0106\7?\2\2\u0106B\3\2\2\2\u0107"+
		"\u0108\7-\2\2\u0108D\3\2\2\2\u0109\u010a\7/\2\2\u010aF\3\2\2\2\u010b\u010c"+
		"\7\'\2\2\u010cH\3\2\2\2\u010d\u010e\7\61\2\2\u010eJ\3\2\2\2\u010f\u0110"+
		"\7,\2\2\u0110L\3\2\2\2\u0111\u0112\7?\2\2\u0112\u0113\7?\2\2\u0113N\3"+
		"\2\2\2\u0114\u0115\7(\2\2\u0115\u0116\7(\2\2\u0116P\3\2\2\2\u0117\u0118"+
		"\7~\2\2\u0118\u0119\7~\2\2\u0119R\3\2\2\2\u011a\u011b\7#\2\2\u011b\u011c"+
		"\7?\2\2\u011cT\3\2\2\2\u011d\u011e\7#\2\2\u011eV\3\2\2\2\u011f\u0121\5"+
		"m\67\2\u0120\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0120\3\2\2\2\u0122"+
		"\u0123\3\2\2\2\u0123X\3\2\2\2\u0124\u0126\5o8\2\u0125\u0124\3\2\2\2\u0126"+
		"\u0127\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128Z\3\2\2\2"+
		"\u0129\u012a\7c\2\2\u012a\u012b\7d\2\2\u012b\u012c\7u\2\2\u012c\\\3\2"+
		"\2\2\u012d\u012e\7u\2\2\u012e\u012f\7k\2\2\u012f\u0130\7p\2\2\u0130^\3"+
		"\2\2\2\u0131\u0132\7e\2\2\u0132\u0133\7q\2\2\u0133\u0134\7u\2\2\u0134"+
		"`\3\2\2\2\u0135\u0136\7v\2\2\u0136\u0137\7c\2\2\u0137\u0138\7p\2\2\u0138"+
		"b\3\2\2\2\u0139\u013a\7V\2\2\u013a\u013b\7k\2\2\u013b\u013c\7o\2\2\u013c"+
		"\u013d\7g\2\2\u013dd\3\2\2\2\u013e\u0141\5g\64\2\u013f\u0141\5%\23\2\u0140"+
		"\u013e\3\2\2\2\u0140\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0140\3\2"+
		"\2\2\u0142\u0143\3\2\2\2\u0143f\3\2\2\2\u0144\u0145\t\2\2\2\u0145h\3\2"+
		"\2\2\u0146\u014f\7\62\2\2\u0147\u014b\4\63;\2\u0148\u014a\4\62;\2\u0149"+
		"\u0148\3\2\2\2\u014a\u014d\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2"+
		"\2\2\u014c\u014f\3\2\2\2\u014d\u014b\3\2\2\2\u014e\u0146\3\2\2\2\u014e"+
		"\u0147\3\2\2\2\u014fj\3\2\2\2\u0150\u0151\7*\2\2\u0151\u0152\7/\2\2\u0152"+
		"\u0153\3\2\2\2\u0153\u0157\4\63;\2\u0154\u0156\4\62;\2\u0155\u0154\3\2"+
		"\2\2\u0156\u0159\3\2\2\2\u0157\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158"+
		"\u015a\3\2\2\2\u0159\u0157\3\2\2\2\u015a\u015b\7+\2\2\u015bl\3\2\2\2\u015c"+
		"\u015d\4y|\2\u015dn\3\2\2\2\u015e\u015f\t\3\2\2\u015fp\3\2\2\2\u0160\u0164"+
		"\7%\2\2\u0161\u0163\n\4\2\2\u0162\u0161\3\2\2\2\u0163\u0166\3\2\2\2\u0164"+
		"\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165r\3\2\2\2\u0166\u0164\3\2\2\2"+
		"\u0167\u0169\t\5\2\2\u0168\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u0168"+
		"\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016d\b:\2\2\u016d"+
		"t\3\2\2\2\17\2\u00df\u00e6\u00f1\u0122\u0127\u0140\u0142\u014b\u014e\u0157"+
		"\u0164\u016a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}