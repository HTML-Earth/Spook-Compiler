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
		IF=23, ELSE=24, DIGIT=25, FLOAT_DIGIT=26, BOOL_LITERAL=27, LEFT_BRACKET=28, 
		RIGHT_BRACKET=29, LEFT_PAREN=30, RIGHT_PAREN=31, DOT=32, COMMA=33, SEMICOLON=34, 
		ASSIGN=35, ADD=36, SUB=37, MOD=38, DIV=39, MUL=40, EQUAL=41, AND=42, OR=43, 
		NOT_EQUAL=44, NOT=45, ABS=46, SIN=47, COS=48, TAN=49, UNIFORM=50, ID=51, 
		COMMENT_STRING=52, WS=53;
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
			"DIGIT", "FLOAT_DIGIT", "BOOL_LITERAL", "LEFT_BRACKET", "RIGHT_BRACKET", 
			"LEFT_PAREN", "RIGHT_PAREN", "DOT", "COMMA", "SEMICOLON", "ASSIGN", "ADD", 
			"SUB", "MOD", "DIV", "MUL", "EQUAL", "AND", "OR", "NOT_EQUAL", "NOT", 
			"ABS", "SIN", "COS", "TAN", "UNIFORM", "ID", "LETTER", "COMMENT_STRING", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'float'", "'bool'", "'vector2'", "'vector3'", "'vector4'", 
			"'void'", "'Circle'", "'Rectangle'", "'Triangle'", "'Shape'", "'Color'", 
			"'Black'", "'White'", "'Red'", "'Green'", "'Blue'", "'Shader'", "'class'", 
			"'extends'", "'implements'", "'return'", "'if'", "'else'", null, null, 
			null, "'{'", "'}'", "'('", "')'", "'.'", "','", "';'", "'='", "'+'", 
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
			"IF", "ELSE", "DIGIT", "FLOAT_DIGIT", "BOOL_LITERAL", "LEFT_BRACKET", 
			"RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", "DOT", "COMMA", "SEMICOLON", 
			"ASSIGN", "ADD", "SUB", "MOD", "DIV", "MUL", "EQUAL", "AND", "OR", "NOT_EQUAL", 
			"NOT", "ABS", "SIN", "COS", "TAN", "UNIFORM", "ID", "COMMENT_STRING", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\67\u0189\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\7\32\u010f"+
		"\n\32\f\32\16\32\u0112\13\32\3\32\3\32\3\32\3\32\3\32\7\32\u0119\n\32"+
		"\f\32\16\32\u011c\13\32\3\32\5\32\u011f\n\32\3\33\3\33\3\33\6\33\u0124"+
		"\n\33\r\33\16\33\u0125\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5"+
		"\34\u0131\n\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3"+
		"#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3,\3-"+
		"\3-\3-\3.\3.\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3"+
		"\61\3\61\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\64\3\64\6"+
		"\64\u0176\n\64\r\64\16\64\u0177\3\65\3\65\3\66\3\66\7\66\u017e\n\66\f"+
		"\66\16\66\u0181\13\66\3\67\6\67\u0184\n\67\r\67\16\67\u0185\3\67\3\67"+
		"\2\28\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\2k\66"+
		"m\67\3\2\5\3\2C|\4\2\13\f\17\17\5\2\13\f\17\17\"\"\2\u0191\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W"+
		"\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2"+
		"\2\2\2e\3\2\2\2\2g\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\3o\3\2\2\2\5s\3\2\2\2"+
		"\7y\3\2\2\2\t~\3\2\2\2\13\u0086\3\2\2\2\r\u008e\3\2\2\2\17\u0096\3\2\2"+
		"\2\21\u009b\3\2\2\2\23\u00a2\3\2\2\2\25\u00ac\3\2\2\2\27\u00b5\3\2\2\2"+
		"\31\u00bb\3\2\2\2\33\u00c1\3\2\2\2\35\u00c7\3\2\2\2\37\u00cd\3\2\2\2!"+
		"\u00d1\3\2\2\2#\u00d7\3\2\2\2%\u00dc\3\2\2\2\'\u00e3\3\2\2\2)\u00e9\3"+
		"\2\2\2+\u00f1\3\2\2\2-\u00fc\3\2\2\2/\u0103\3\2\2\2\61\u0106\3\2\2\2\63"+
		"\u011e\3\2\2\2\65\u0120\3\2\2\2\67\u0130\3\2\2\29\u0132\3\2\2\2;\u0134"+
		"\3\2\2\2=\u0136\3\2\2\2?\u0138\3\2\2\2A\u013a\3\2\2\2C\u013c\3\2\2\2E"+
		"\u013e\3\2\2\2G\u0140\3\2\2\2I\u0142\3\2\2\2K\u0144\3\2\2\2M\u0146\3\2"+
		"\2\2O\u0148\3\2\2\2Q\u014a\3\2\2\2S\u014c\3\2\2\2U\u014f\3\2\2\2W\u0152"+
		"\3\2\2\2Y\u0155\3\2\2\2[\u0158\3\2\2\2]\u015a\3\2\2\2_\u015f\3\2\2\2a"+
		"\u0164\3\2\2\2c\u0169\3\2\2\2e\u016e\3\2\2\2g\u0175\3\2\2\2i\u0179\3\2"+
		"\2\2k\u017b\3\2\2\2m\u0183\3\2\2\2op\7k\2\2pq\7p\2\2qr\7v\2\2r\4\3\2\2"+
		"\2st\7h\2\2tu\7n\2\2uv\7q\2\2vw\7c\2\2wx\7v\2\2x\6\3\2\2\2yz\7d\2\2z{"+
		"\7q\2\2{|\7q\2\2|}\7n\2\2}\b\3\2\2\2~\177\7x\2\2\177\u0080\7g\2\2\u0080"+
		"\u0081\7e\2\2\u0081\u0082\7v\2\2\u0082\u0083\7q\2\2\u0083\u0084\7t\2\2"+
		"\u0084\u0085\7\64\2\2\u0085\n\3\2\2\2\u0086\u0087\7x\2\2\u0087\u0088\7"+
		"g\2\2\u0088\u0089\7e\2\2\u0089\u008a\7v\2\2\u008a\u008b\7q\2\2\u008b\u008c"+
		"\7t\2\2\u008c\u008d\7\65\2\2\u008d\f\3\2\2\2\u008e\u008f\7x\2\2\u008f"+
		"\u0090\7g\2\2\u0090\u0091\7e\2\2\u0091\u0092\7v\2\2\u0092\u0093\7q\2\2"+
		"\u0093\u0094\7t\2\2\u0094\u0095\7\66\2\2\u0095\16\3\2\2\2\u0096\u0097"+
		"\7x\2\2\u0097\u0098\7q\2\2\u0098\u0099\7k\2\2\u0099\u009a\7f\2\2\u009a"+
		"\20\3\2\2\2\u009b\u009c\7E\2\2\u009c\u009d\7k\2\2\u009d\u009e\7t\2\2\u009e"+
		"\u009f\7e\2\2\u009f\u00a0\7n\2\2\u00a0\u00a1\7g\2\2\u00a1\22\3\2\2\2\u00a2"+
		"\u00a3\7T\2\2\u00a3\u00a4\7g\2\2\u00a4\u00a5\7e\2\2\u00a5\u00a6\7v\2\2"+
		"\u00a6\u00a7\7c\2\2\u00a7\u00a8\7p\2\2\u00a8\u00a9\7i\2\2\u00a9\u00aa"+
		"\7n\2\2\u00aa\u00ab\7g\2\2\u00ab\24\3\2\2\2\u00ac\u00ad\7V\2\2\u00ad\u00ae"+
		"\7t\2\2\u00ae\u00af\7k\2\2\u00af\u00b0\7c\2\2\u00b0\u00b1\7p\2\2\u00b1"+
		"\u00b2\7i\2\2\u00b2\u00b3\7n\2\2\u00b3\u00b4\7g\2\2\u00b4\26\3\2\2\2\u00b5"+
		"\u00b6\7U\2\2\u00b6\u00b7\7j\2\2\u00b7\u00b8\7c\2\2\u00b8\u00b9\7r\2\2"+
		"\u00b9\u00ba\7g\2\2\u00ba\30\3\2\2\2\u00bb\u00bc\7E\2\2\u00bc\u00bd\7"+
		"q\2\2\u00bd\u00be\7n\2\2\u00be\u00bf\7q\2\2\u00bf\u00c0\7t\2\2\u00c0\32"+
		"\3\2\2\2\u00c1\u00c2\7D\2\2\u00c2\u00c3\7n\2\2\u00c3\u00c4\7c\2\2\u00c4"+
		"\u00c5\7e\2\2\u00c5\u00c6\7m\2\2\u00c6\34\3\2\2\2\u00c7\u00c8\7Y\2\2\u00c8"+
		"\u00c9\7j\2\2\u00c9\u00ca\7k\2\2\u00ca\u00cb\7v\2\2\u00cb\u00cc\7g\2\2"+
		"\u00cc\36\3\2\2\2\u00cd\u00ce\7T\2\2\u00ce\u00cf\7g\2\2\u00cf\u00d0\7"+
		"f\2\2\u00d0 \3\2\2\2\u00d1\u00d2\7I\2\2\u00d2\u00d3\7t\2\2\u00d3\u00d4"+
		"\7g\2\2\u00d4\u00d5\7g\2\2\u00d5\u00d6\7p\2\2\u00d6\"\3\2\2\2\u00d7\u00d8"+
		"\7D\2\2\u00d8\u00d9\7n\2\2\u00d9\u00da\7w\2\2\u00da\u00db\7g\2\2\u00db"+
		"$\3\2\2\2\u00dc\u00dd\7U\2\2\u00dd\u00de\7j\2\2\u00de\u00df\7c\2\2\u00df"+
		"\u00e0\7f\2\2\u00e0\u00e1\7g\2\2\u00e1\u00e2\7t\2\2\u00e2&\3\2\2\2\u00e3"+
		"\u00e4\7e\2\2\u00e4\u00e5\7n\2\2\u00e5\u00e6\7c\2\2\u00e6\u00e7\7u\2\2"+
		"\u00e7\u00e8\7u\2\2\u00e8(\3\2\2\2\u00e9\u00ea\7g\2\2\u00ea\u00eb\7z\2"+
		"\2\u00eb\u00ec\7v\2\2\u00ec\u00ed\7g\2\2\u00ed\u00ee\7p\2\2\u00ee\u00ef"+
		"\7f\2\2\u00ef\u00f0\7u\2\2\u00f0*\3\2\2\2\u00f1\u00f2\7k\2\2\u00f2\u00f3"+
		"\7o\2\2\u00f3\u00f4\7r\2\2\u00f4\u00f5\7n\2\2\u00f5\u00f6\7g\2\2\u00f6"+
		"\u00f7\7o\2\2\u00f7\u00f8\7g\2\2\u00f8\u00f9\7p\2\2\u00f9\u00fa\7v\2\2"+
		"\u00fa\u00fb\7u\2\2\u00fb,\3\2\2\2\u00fc\u00fd\7t\2\2\u00fd\u00fe\7g\2"+
		"\2\u00fe\u00ff\7v\2\2\u00ff\u0100\7w\2\2\u0100\u0101\7t\2\2\u0101\u0102"+
		"\7p\2\2\u0102.\3\2\2\2\u0103\u0104\7k\2\2\u0104\u0105\7h\2\2\u0105\60"+
		"\3\2\2\2\u0106\u0107\7g\2\2\u0107\u0108\7n\2\2\u0108\u0109\7u\2\2\u0109"+
		"\u010a\7g\2\2\u010a\62\3\2\2\2\u010b\u011f\7\62\2\2\u010c\u0110\4\63;"+
		"\2\u010d\u010f\4\62;\2\u010e\u010d\3\2\2\2\u010f\u0112\3\2\2\2\u0110\u010e"+
		"\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u011f\3\2\2\2\u0112\u0110\3\2\2\2\u0113"+
		"\u0114\7*\2\2\u0114\u0115\7/\2\2\u0115\u0116\3\2\2\2\u0116\u011a\4\63"+
		";\2\u0117\u0119\4\62;\2\u0118\u0117\3\2\2\2\u0119\u011c\3\2\2\2\u011a"+
		"\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011d\3\2\2\2\u011c\u011a\3\2"+
		"\2\2\u011d\u011f\7+\2\2\u011e\u010b\3\2\2\2\u011e\u010c\3\2\2\2\u011e"+
		"\u0113\3\2\2\2\u011f\64\3\2\2\2\u0120\u0121\5\63\32\2\u0121\u0123\7\60"+
		"\2\2\u0122\u0124\5\63\32\2\u0123\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125"+
		"\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\66\3\2\2\2\u0127\u0128\7v\2\2"+
		"\u0128\u0129\7t\2\2\u0129\u012a\7w\2\2\u012a\u0131\7g\2\2\u012b\u012c"+
		"\7h\2\2\u012c\u012d\7c\2\2\u012d\u012e\7n\2\2\u012e\u012f\7u\2\2\u012f"+
		"\u0131\7g\2\2\u0130\u0127\3\2\2\2\u0130\u012b\3\2\2\2\u01318\3\2\2\2\u0132"+
		"\u0133\7}\2\2\u0133:\3\2\2\2\u0134\u0135\7\177\2\2\u0135<\3\2\2\2\u0136"+
		"\u0137\7*\2\2\u0137>\3\2\2\2\u0138\u0139\7+\2\2\u0139@\3\2\2\2\u013a\u013b"+
		"\7\60\2\2\u013bB\3\2\2\2\u013c\u013d\7.\2\2\u013dD\3\2\2\2\u013e\u013f"+
		"\7=\2\2\u013fF\3\2\2\2\u0140\u0141\7?\2\2\u0141H\3\2\2\2\u0142\u0143\7"+
		"-\2\2\u0143J\3\2\2\2\u0144\u0145\7/\2\2\u0145L\3\2\2\2\u0146\u0147\7\'"+
		"\2\2\u0147N\3\2\2\2\u0148\u0149\7\61\2\2\u0149P\3\2\2\2\u014a\u014b\7"+
		",\2\2\u014bR\3\2\2\2\u014c\u014d\7?\2\2\u014d\u014e\7?\2\2\u014eT\3\2"+
		"\2\2\u014f\u0150\7(\2\2\u0150\u0151\7(\2\2\u0151V\3\2\2\2\u0152\u0153"+
		"\7~\2\2\u0153\u0154\7~\2\2\u0154X\3\2\2\2\u0155\u0156\7#\2\2\u0156\u0157"+
		"\7?\2\2\u0157Z\3\2\2\2\u0158\u0159\7#\2\2\u0159\\\3\2\2\2\u015a\u015b"+
		"\7c\2\2\u015b\u015c\7d\2\2\u015c\u015d\7u\2\2\u015d\u015e\7*\2\2\u015e"+
		"^\3\2\2\2\u015f\u0160\7u\2\2\u0160\u0161\7k\2\2\u0161\u0162\7p\2\2\u0162"+
		"\u0163\7*\2\2\u0163`\3\2\2\2\u0164\u0165\7e\2\2\u0165\u0166\7q\2\2\u0166"+
		"\u0167\7u\2\2\u0167\u0168\7*\2\2\u0168b\3\2\2\2\u0169\u016a\7v\2\2\u016a"+
		"\u016b\7c\2\2\u016b\u016c\7p\2\2\u016c\u016d\7*\2\2\u016dd\3\2\2\2\u016e"+
		"\u016f\7V\2\2\u016f\u0170\7k\2\2\u0170\u0171\7o\2\2\u0171\u0172\7g\2\2"+
		"\u0172f\3\2\2\2\u0173\u0176\5i\65\2\u0174\u0176\5\63\32\2\u0175\u0173"+
		"\3\2\2\2\u0175\u0174\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0175\3\2\2\2\u0177"+
		"\u0178\3\2\2\2\u0178h\3\2\2\2\u0179\u017a\t\2\2\2\u017aj\3\2\2\2\u017b"+
		"\u017f\7%\2\2\u017c\u017e\n\3\2\2\u017d\u017c\3\2\2\2\u017e\u0181\3\2"+
		"\2\2\u017f\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180l\3\2\2\2\u0181\u017f"+
		"\3\2\2\2\u0182\u0184\t\4\2\2\u0183\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185"+
		"\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0188\b\67"+
		"\2\2\u0188n\3\2\2\2\f\2\u0110\u011a\u011e\u0125\u0130\u0175\u0177\u017f"+
		"\u0185\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}