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
		INT=1, FLOAT=2, BOOL=3, VECTOR2=4, VECTOR3=5, VECTOR4=6, VOID=7, CIRCLE=8, 
		RECTANGLE=9, TRIANGLE=10, SHAPE=11, COLOR=12, BLACK=13, WHITE=14, RED=15, 
		GREEN=16, BLUE=17, MAIN=18, CLASS=19, EXTENDS=20, IMPLEMENTS=21, RETURN=22, 
		IF=23, ELSE=24, DIGIT_NON=25, DIGIT_LITERAL=26, FLOAT_DIGIT=27, BOOL_LITERAL=28, 
		LEFT_BRACKET=29, RIGHT_BRACKET=30, LEFT_PAREN=31, RIGHT_PAREN=32, DOT=33, 
		COMMA=34, SEMICOLON=35, ASSIGN=36, ADD=37, SUB=38, MOD=39, DIV=40, MUL=41, 
		EQUAL=42, AND=43, OR=44, NOT_EQUAL=45, NOT=46, ABS=47, SIN=48, COS=49, 
		TAN=50, UNIFORM=51, ID=52, COMMENT_STRING=53, WS=54;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT", "FLOAT", "BOOL", "VECTOR2", "VECTOR3", "VECTOR4", "VOID", "CIRCLE", 
			"RECTANGLE", "TRIANGLE", "SHAPE", "COLOR", "BLACK", "WHITE", "RED", "GREEN", 
			"BLUE", "MAIN", "CLASS", "EXTENDS", "IMPLEMENTS", "RETURN", "IF", "ELSE", 
			"DIGIT_NON", "DIGIT_LITERAL", "FLOAT_DIGIT", "BOOL_LITERAL", "LEFT_BRACKET", 
			"RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", "DOT", "COMMA", "SEMICOLON", 
			"ASSIGN", "ADD", "SUB", "MOD", "DIV", "MUL", "EQUAL", "AND", "OR", "NOT_EQUAL", 
			"NOT", "ABS", "SIN", "COS", "TAN", "UNIFORM", "ID", "LETTER", "DIGIT", 
			"DIGIT_LITERAL_RULE", "DIGIT_NEGATIVE", "COMMENT_STRING", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'float'", "'bool'", "'vector2'", "'vector3'", "'vector4'", 
			"'void'", "'Circle'", "'Rectangle'", "'Triangle'", "'Shape'", "'Color'", 
			"'Black'", "'White'", "'Red'", "'Green'", "'Blue'", "'Shader'", "'class'", 
			"'extends'", "'implements'", "'return'", "'if'", "'else'", null, null, 
			null, null, "'{'", "'}'", "'('", "')'", "'.'", "','", "';'", "'='", "'+'", 
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
			"IF", "ELSE", "DIGIT_NON", "DIGIT_LITERAL", "FLOAT_DIGIT", "BOOL_LITERAL", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", "DOT", 
			"COMMA", "SEMICOLON", "ASSIGN", "ADD", "SUB", "MOD", "DIV", "MUL", "EQUAL", 
			"AND", "OR", "NOT_EQUAL", "NOT", "ABS", "SIN", "COS", "TAN", "UNIFORM", 
			"ID", "COMMENT_STRING", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\28\u019a\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\3\34\6\34\u011b\n\34\r\34\16\34\u011c\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0128\n\35\3\36\3\36\3\37"+
		"\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)"+
		"\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3-\3.\3.\3.\3/\3/\3\60\3\60\3\60\3\60\3"+
		"\60\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3"+
		"\63\3\63\3\64\3\64\3\64\3\64\3\64\3\65\3\65\6\65\u016d\n\65\r\65\16\65"+
		"\u016e\3\66\3\66\3\67\3\67\3\67\7\67\u0176\n\67\f\67\16\67\u0179\13\67"+
		"\5\67\u017b\n\67\38\38\58\u017f\n8\39\39\39\39\39\79\u0186\n9\f9\169\u0189"+
		"\139\39\39\3:\3:\7:\u018f\n:\f:\16:\u0192\13:\3;\6;\u0195\n;\r;\16;\u0196"+
		"\3;\3;\2\2<\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65"+
		"i\66k\2m\2o\2q\2s\67u8\3\2\5\3\2C|\4\2\13\f\17\17\5\2\13\f\17\17\"\"\2"+
		"\u019f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3"+
		"\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2"+
		"\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2s\3\2\2\2\2"+
		"u\3\2\2\2\3w\3\2\2\2\5{\3\2\2\2\7\u0081\3\2\2\2\t\u0086\3\2\2\2\13\u008e"+
		"\3\2\2\2\r\u0096\3\2\2\2\17\u009e\3\2\2\2\21\u00a3\3\2\2\2\23\u00aa\3"+
		"\2\2\2\25\u00b4\3\2\2\2\27\u00bd\3\2\2\2\31\u00c3\3\2\2\2\33\u00c9\3\2"+
		"\2\2\35\u00cf\3\2\2\2\37\u00d5\3\2\2\2!\u00d9\3\2\2\2#\u00df\3\2\2\2%"+
		"\u00e4\3\2\2\2\'\u00eb\3\2\2\2)\u00f1\3\2\2\2+\u00f9\3\2\2\2-\u0104\3"+
		"\2\2\2/\u010b\3\2\2\2\61\u010e\3\2\2\2\63\u0113\3\2\2\2\65\u0115\3\2\2"+
		"\2\67\u0117\3\2\2\29\u0127\3\2\2\2;\u0129\3\2\2\2=\u012b\3\2\2\2?\u012d"+
		"\3\2\2\2A\u012f\3\2\2\2C\u0131\3\2\2\2E\u0133\3\2\2\2G\u0135\3\2\2\2I"+
		"\u0137\3\2\2\2K\u0139\3\2\2\2M\u013b\3\2\2\2O\u013d\3\2\2\2Q\u013f\3\2"+
		"\2\2S\u0141\3\2\2\2U\u0143\3\2\2\2W\u0146\3\2\2\2Y\u0149\3\2\2\2[\u014c"+
		"\3\2\2\2]\u014f\3\2\2\2_\u0151\3\2\2\2a\u0156\3\2\2\2c\u015b\3\2\2\2e"+
		"\u0160\3\2\2\2g\u0165\3\2\2\2i\u016c\3\2\2\2k\u0170\3\2\2\2m\u017a\3\2"+
		"\2\2o\u017e\3\2\2\2q\u0180\3\2\2\2s\u018c\3\2\2\2u\u0194\3\2\2\2wx\7k"+
		"\2\2xy\7p\2\2yz\7v\2\2z\4\3\2\2\2{|\7h\2\2|}\7n\2\2}~\7q\2\2~\177\7c\2"+
		"\2\177\u0080\7v\2\2\u0080\6\3\2\2\2\u0081\u0082\7d\2\2\u0082\u0083\7q"+
		"\2\2\u0083\u0084\7q\2\2\u0084\u0085\7n\2\2\u0085\b\3\2\2\2\u0086\u0087"+
		"\7x\2\2\u0087\u0088\7g\2\2\u0088\u0089\7e\2\2\u0089\u008a\7v\2\2\u008a"+
		"\u008b\7q\2\2\u008b\u008c\7t\2\2\u008c\u008d\7\64\2\2\u008d\n\3\2\2\2"+
		"\u008e\u008f\7x\2\2\u008f\u0090\7g\2\2\u0090\u0091\7e\2\2\u0091\u0092"+
		"\7v\2\2\u0092\u0093\7q\2\2\u0093\u0094\7t\2\2\u0094\u0095\7\65\2\2\u0095"+
		"\f\3\2\2\2\u0096\u0097\7x\2\2\u0097\u0098\7g\2\2\u0098\u0099\7e\2\2\u0099"+
		"\u009a\7v\2\2\u009a\u009b\7q\2\2\u009b\u009c\7t\2\2\u009c\u009d\7\66\2"+
		"\2\u009d\16\3\2\2\2\u009e\u009f\7x\2\2\u009f\u00a0\7q\2\2\u00a0\u00a1"+
		"\7k\2\2\u00a1\u00a2\7f\2\2\u00a2\20\3\2\2\2\u00a3\u00a4\7E\2\2\u00a4\u00a5"+
		"\7k\2\2\u00a5\u00a6\7t\2\2\u00a6\u00a7\7e\2\2\u00a7\u00a8\7n\2\2\u00a8"+
		"\u00a9\7g\2\2\u00a9\22\3\2\2\2\u00aa\u00ab\7T\2\2\u00ab\u00ac\7g\2\2\u00ac"+
		"\u00ad\7e\2\2\u00ad\u00ae\7v\2\2\u00ae\u00af\7c\2\2\u00af\u00b0\7p\2\2"+
		"\u00b0\u00b1\7i\2\2\u00b1\u00b2\7n\2\2\u00b2\u00b3\7g\2\2\u00b3\24\3\2"+
		"\2\2\u00b4\u00b5\7V\2\2\u00b5\u00b6\7t\2\2\u00b6\u00b7\7k\2\2\u00b7\u00b8"+
		"\7c\2\2\u00b8\u00b9\7p\2\2\u00b9\u00ba\7i\2\2\u00ba\u00bb\7n\2\2\u00bb"+
		"\u00bc\7g\2\2\u00bc\26\3\2\2\2\u00bd\u00be\7U\2\2\u00be\u00bf\7j\2\2\u00bf"+
		"\u00c0\7c\2\2\u00c0\u00c1\7r\2\2\u00c1\u00c2\7g\2\2\u00c2\30\3\2\2\2\u00c3"+
		"\u00c4\7E\2\2\u00c4\u00c5\7q\2\2\u00c5\u00c6\7n\2\2\u00c6\u00c7\7q\2\2"+
		"\u00c7\u00c8\7t\2\2\u00c8\32\3\2\2\2\u00c9\u00ca\7D\2\2\u00ca\u00cb\7"+
		"n\2\2\u00cb\u00cc\7c\2\2\u00cc\u00cd\7e\2\2\u00cd\u00ce\7m\2\2\u00ce\34"+
		"\3\2\2\2\u00cf\u00d0\7Y\2\2\u00d0\u00d1\7j\2\2\u00d1\u00d2\7k\2\2\u00d2"+
		"\u00d3\7v\2\2\u00d3\u00d4\7g\2\2\u00d4\36\3\2\2\2\u00d5\u00d6\7T\2\2\u00d6"+
		"\u00d7\7g\2\2\u00d7\u00d8\7f\2\2\u00d8 \3\2\2\2\u00d9\u00da\7I\2\2\u00da"+
		"\u00db\7t\2\2\u00db\u00dc\7g\2\2\u00dc\u00dd\7g\2\2\u00dd\u00de\7p\2\2"+
		"\u00de\"\3\2\2\2\u00df\u00e0\7D\2\2\u00e0\u00e1\7n\2\2\u00e1\u00e2\7w"+
		"\2\2\u00e2\u00e3\7g\2\2\u00e3$\3\2\2\2\u00e4\u00e5\7U\2\2\u00e5\u00e6"+
		"\7j\2\2\u00e6\u00e7\7c\2\2\u00e7\u00e8\7f\2\2\u00e8\u00e9\7g\2\2\u00e9"+
		"\u00ea\7t\2\2\u00ea&\3\2\2\2\u00eb\u00ec\7e\2\2\u00ec\u00ed\7n\2\2\u00ed"+
		"\u00ee\7c\2\2\u00ee\u00ef\7u\2\2\u00ef\u00f0\7u\2\2\u00f0(\3\2\2\2\u00f1"+
		"\u00f2\7g\2\2\u00f2\u00f3\7z\2\2\u00f3\u00f4\7v\2\2\u00f4\u00f5\7g\2\2"+
		"\u00f5\u00f6\7p\2\2\u00f6\u00f7\7f\2\2\u00f7\u00f8\7u\2\2\u00f8*\3\2\2"+
		"\2\u00f9\u00fa\7k\2\2\u00fa\u00fb\7o\2\2\u00fb\u00fc\7r\2\2\u00fc\u00fd"+
		"\7n\2\2\u00fd\u00fe\7g\2\2\u00fe\u00ff\7o\2\2\u00ff\u0100\7g\2\2\u0100"+
		"\u0101\7p\2\2\u0101\u0102\7v\2\2\u0102\u0103\7u\2\2\u0103,\3\2\2\2\u0104"+
		"\u0105\7t\2\2\u0105\u0106\7g\2\2\u0106\u0107\7v\2\2\u0107\u0108\7w\2\2"+
		"\u0108\u0109\7t\2\2\u0109\u010a\7p\2\2\u010a.\3\2\2\2\u010b\u010c\7k\2"+
		"\2\u010c\u010d\7h\2\2\u010d\60\3\2\2\2\u010e\u010f\7g\2\2\u010f\u0110"+
		"\7n\2\2\u0110\u0111\7u\2\2\u0111\u0112\7g\2\2\u0112\62\3\2\2\2\u0113\u0114"+
		"\5m\67\2\u0114\64\3\2\2\2\u0115\u0116\5o8\2\u0116\66\3\2\2\2\u0117\u0118"+
		"\5m\67\2\u0118\u011a\7\60\2\2\u0119\u011b\5m\67\2\u011a\u0119\3\2\2\2"+
		"\u011b\u011c\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d8\3"+
		"\2\2\2\u011e\u011f\7v\2\2\u011f\u0120\7t\2\2\u0120\u0121\7w\2\2\u0121"+
		"\u0128\7g\2\2\u0122\u0123\7h\2\2\u0123\u0124\7c\2\2\u0124\u0125\7n\2\2"+
		"\u0125\u0126\7u\2\2\u0126\u0128\7g\2\2\u0127\u011e\3\2\2\2\u0127\u0122"+
		"\3\2\2\2\u0128:\3\2\2\2\u0129\u012a\7}\2\2\u012a<\3\2\2\2\u012b\u012c"+
		"\7\177\2\2\u012c>\3\2\2\2\u012d\u012e\7*\2\2\u012e@\3\2\2\2\u012f\u0130"+
		"\7+\2\2\u0130B\3\2\2\2\u0131\u0132\7\60\2\2\u0132D\3\2\2\2\u0133\u0134"+
		"\7.\2\2\u0134F\3\2\2\2\u0135\u0136\7=\2\2\u0136H\3\2\2\2\u0137\u0138\7"+
		"?\2\2\u0138J\3\2\2\2\u0139\u013a\7-\2\2\u013aL\3\2\2\2\u013b\u013c\7/"+
		"\2\2\u013cN\3\2\2\2\u013d\u013e\7\'\2\2\u013eP\3\2\2\2\u013f\u0140\7\61"+
		"\2\2\u0140R\3\2\2\2\u0141\u0142\7,\2\2\u0142T\3\2\2\2\u0143\u0144\7?\2"+
		"\2\u0144\u0145\7?\2\2\u0145V\3\2\2\2\u0146\u0147\7(\2\2\u0147\u0148\7"+
		"(\2\2\u0148X\3\2\2\2\u0149\u014a\7~\2\2\u014a\u014b\7~\2\2\u014bZ\3\2"+
		"\2\2\u014c\u014d\7#\2\2\u014d\u014e\7?\2\2\u014e\\\3\2\2\2\u014f\u0150"+
		"\7#\2\2\u0150^\3\2\2\2\u0151\u0152\7c\2\2\u0152\u0153\7d\2\2\u0153\u0154"+
		"\7u\2\2\u0154\u0155\7*\2\2\u0155`\3\2\2\2\u0156\u0157\7u\2\2\u0157\u0158"+
		"\7k\2\2\u0158\u0159\7p\2\2\u0159\u015a\7*\2\2\u015ab\3\2\2\2\u015b\u015c"+
		"\7e\2\2\u015c\u015d\7q\2\2\u015d\u015e\7u\2\2\u015e\u015f\7*\2\2\u015f"+
		"d\3\2\2\2\u0160\u0161\7v\2\2\u0161\u0162\7c\2\2\u0162\u0163\7p\2\2\u0163"+
		"\u0164\7*\2\2\u0164f\3\2\2\2\u0165\u0166\7V\2\2\u0166\u0167\7k\2\2\u0167"+
		"\u0168\7o\2\2\u0168\u0169\7g\2\2\u0169h\3\2\2\2\u016a\u016d\5k\66\2\u016b"+
		"\u016d\5\63\32\2\u016c\u016a\3\2\2\2\u016c\u016b\3\2\2\2\u016d\u016e\3"+
		"\2\2\2\u016e\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016fj\3\2\2\2\u0170\u0171"+
		"\t\2\2\2\u0171l\3\2\2\2\u0172\u017b\7\62\2\2\u0173\u0177\4\63;\2\u0174"+
		"\u0176\4\62;\2\u0175\u0174\3\2\2\2\u0176\u0179\3\2\2\2\u0177\u0175\3\2"+
		"\2\2\u0177\u0178\3\2\2\2\u0178\u017b\3\2\2\2\u0179\u0177\3\2\2\2\u017a"+
		"\u0172\3\2\2\2\u017a\u0173\3\2\2\2\u017bn\3\2\2\2\u017c\u017f\5m\67\2"+
		"\u017d\u017f\5q9\2\u017e\u017c\3\2\2\2\u017e\u017d\3\2\2\2\u017fp\3\2"+
		"\2\2\u0180\u0181\7*\2\2\u0181\u0182\7/\2\2\u0182\u0183\3\2\2\2\u0183\u0187"+
		"\4\63;\2\u0184\u0186\4\62;\2\u0185\u0184\3\2\2\2\u0186\u0189\3\2\2\2\u0187"+
		"\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u018a\3\2\2\2\u0189\u0187\3\2"+
		"\2\2\u018a\u018b\7+\2\2\u018br\3\2\2\2\u018c\u0190\7%\2\2\u018d\u018f"+
		"\n\3\2\2\u018e\u018d\3\2\2\2\u018f\u0192\3\2\2\2\u0190\u018e\3\2\2\2\u0190"+
		"\u0191\3\2\2\2\u0191t\3\2\2\2\u0192\u0190\3\2\2\2\u0193\u0195\t\4\2\2"+
		"\u0194\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0194\3\2\2\2\u0196\u0197"+
		"\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u0199\b;\2\2\u0199v\3\2\2\2\r\2\u011c"+
		"\u0127\u016c\u016e\u0177\u017a\u017e\u0187\u0190\u0196\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}