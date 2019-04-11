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
		IF=23, ELSE_IF=24, ELSE=25, DIGIT=26, DIGIT_NEGATIVE=27, FLOAT_DIGIT=28, 
		FLOAT_DIGIT_NEGATIVE=29, BOOL_LITERAL=30, LEFT_BRACKET=31, RIGHT_BRACKET=32, 
		LEFT_PAREN=33, RIGHT_PAREN=34, DOT=35, COMMA=36, SEMICOLON=37, QUESTION=38, 
		COLON=39, ASSIGN=40, ADD=41, SUB=42, MOD=43, DIV=44, MUL=45, EQUAL=46, 
		AND=47, OR=48, NOT_EQUAL=49, NOT=50, ABS=51, SIN=52, COS=53, TAN=54, UNIFORM=55, 
		ID=56, COMMENT_STRING=57, WS=58;
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
			"BLUE", "MAIN", "CLASS", "EXTENDS", "IMPLEMENTS", "RETURN", "IF", "ELSE_IF", 
			"ELSE", "DIGIT", "DIGIT_NEGATIVE", "FLOAT_DIGIT", "FLOAT_DIGIT_NEGATIVE", 
			"BOOL_LITERAL", "LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", 
			"DOT", "COMMA", "SEMICOLON", "QUESTION", "COLON", "ASSIGN", "ADD", "SUB", 
			"MOD", "DIV", "MUL", "EQUAL", "AND", "OR", "NOT_EQUAL", "NOT", "ABS", 
			"SIN", "COS", "TAN", "UNIFORM", "ID", "LETTER", "DIGIT_RULE", "DIGIT_NEGATIVE_RULE", 
			"COMMENT_STRING", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Int'", "'Float'", "'Bool'", "'Vec2'", "'Vec3'", "'Vec4'", "'void'", 
			"'Circle'", "'Rectangle'", "'Triangle'", "'Shape'", "'Color'", "'Black'", 
			"'White'", "'Red'", "'Green'", "'Blue'", "'Shader'", "'class'", "'extends'", 
			"'implements'", "'return'", "'if'", "'else if'", "'else'", null, null, 
			null, null, null, "'{'", "'}'", "'('", "')'", "'.'", "','", "';'", "'?'", 
			"':'", "'='", "'+'", "'-'", "'%'", "'/'", "'*'", "'=='", "'&&'", "'||'", 
			"'!='", "'!'", "'abs'", "'sin'", "'cos'", "'tan'", "'Time'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "FLOAT", "BOOL", "VECTOR2", "VECTOR3", "VECTOR4", "VOID", 
			"CIRCLE", "RECTANGLE", "TRIANGLE", "SHAPE", "COLOR", "BLACK", "WHITE", 
			"RED", "GREEN", "BLUE", "MAIN", "CLASS", "EXTENDS", "IMPLEMENTS", "RETURN", 
			"IF", "ELSE_IF", "ELSE", "DIGIT", "DIGIT_NEGATIVE", "FLOAT_DIGIT", "FLOAT_DIGIT_NEGATIVE", 
			"BOOL_LITERAL", "LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", 
			"DOT", "COMMA", "SEMICOLON", "QUESTION", "COLON", "ASSIGN", "ADD", "SUB", 
			"MOD", "DIV", "MUL", "EQUAL", "AND", "OR", "NOT_EQUAL", "NOT", "ABS", 
			"SIN", "COS", "TAN", "UNIFORM", "ID", "COMMENT_STRING", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2<\u01a2\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3"+
		"\32\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\6\35\u0120\n\35"+
		"\r\35\16\35\u0121\3\36\3\36\3\36\6\36\u0127\n\36\r\36\16\36\u0128\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0134\n\37\3 \3 \3!\3!\3"+
		"\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3"+
		"-\3-\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63"+
		"\3\63\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\67"+
		"\3\67\3\67\3\67\38\38\38\38\38\39\39\69\u0179\n9\r9\169\u017a\3:\3:\3"+
		";\3;\3;\7;\u0182\n;\f;\16;\u0185\13;\5;\u0187\n;\3<\3<\3<\3<\3<\7<\u018e"+
		"\n<\f<\16<\u0191\13<\3<\3<\3=\3=\7=\u0197\n=\f=\16=\u019a\13=\3>\6>\u019d"+
		"\n>\r>\16>\u019e\3>\3>\2\2?\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a"+
		"\62c\63e\64g\65i\66k\67m8o9q:s\2u\2w\2y;{<\3\2\5\3\2C|\4\2\13\f\17\17"+
		"\5\2\13\f\17\17\"\"\2\u01a8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C"+
		"\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2"+
		"\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2"+
		"\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i"+
		"\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2y\3\2\2\2\2{\3\2"+
		"\2\2\3}\3\2\2\2\5\u0081\3\2\2\2\7\u0087\3\2\2\2\t\u008c\3\2\2\2\13\u0091"+
		"\3\2\2\2\r\u0096\3\2\2\2\17\u009b\3\2\2\2\21\u00a0\3\2\2\2\23\u00a7\3"+
		"\2\2\2\25\u00b1\3\2\2\2\27\u00ba\3\2\2\2\31\u00c0\3\2\2\2\33\u00c6\3\2"+
		"\2\2\35\u00cc\3\2\2\2\37\u00d2\3\2\2\2!\u00d6\3\2\2\2#\u00dc\3\2\2\2%"+
		"\u00e1\3\2\2\2\'\u00e8\3\2\2\2)\u00ee\3\2\2\2+\u00f6\3\2\2\2-\u0101\3"+
		"\2\2\2/\u0108\3\2\2\2\61\u010b\3\2\2\2\63\u0113\3\2\2\2\65\u0118\3\2\2"+
		"\2\67\u011a\3\2\2\29\u011c\3\2\2\2;\u0123\3\2\2\2=\u0133\3\2\2\2?\u0135"+
		"\3\2\2\2A\u0137\3\2\2\2C\u0139\3\2\2\2E\u013b\3\2\2\2G\u013d\3\2\2\2I"+
		"\u013f\3\2\2\2K\u0141\3\2\2\2M\u0143\3\2\2\2O\u0145\3\2\2\2Q\u0147\3\2"+
		"\2\2S\u0149\3\2\2\2U\u014b\3\2\2\2W\u014d\3\2\2\2Y\u014f\3\2\2\2[\u0151"+
		"\3\2\2\2]\u0153\3\2\2\2_\u0156\3\2\2\2a\u0159\3\2\2\2c\u015c\3\2\2\2e"+
		"\u015f\3\2\2\2g\u0161\3\2\2\2i\u0165\3\2\2\2k\u0169\3\2\2\2m\u016d\3\2"+
		"\2\2o\u0171\3\2\2\2q\u0178\3\2\2\2s\u017c\3\2\2\2u\u0186\3\2\2\2w\u0188"+
		"\3\2\2\2y\u0194\3\2\2\2{\u019c\3\2\2\2}~\7K\2\2~\177\7p\2\2\177\u0080"+
		"\7v\2\2\u0080\4\3\2\2\2\u0081\u0082\7H\2\2\u0082\u0083\7n\2\2\u0083\u0084"+
		"\7q\2\2\u0084\u0085\7c\2\2\u0085\u0086\7v\2\2\u0086\6\3\2\2\2\u0087\u0088"+
		"\7D\2\2\u0088\u0089\7q\2\2\u0089\u008a\7q\2\2\u008a\u008b\7n\2\2\u008b"+
		"\b\3\2\2\2\u008c\u008d\7X\2\2\u008d\u008e\7g\2\2\u008e\u008f\7e\2\2\u008f"+
		"\u0090\7\64\2\2\u0090\n\3\2\2\2\u0091\u0092\7X\2\2\u0092\u0093\7g\2\2"+
		"\u0093\u0094\7e\2\2\u0094\u0095\7\65\2\2\u0095\f\3\2\2\2\u0096\u0097\7"+
		"X\2\2\u0097\u0098\7g\2\2\u0098\u0099\7e\2\2\u0099\u009a\7\66\2\2\u009a"+
		"\16\3\2\2\2\u009b\u009c\7x\2\2\u009c\u009d\7q\2\2\u009d\u009e\7k\2\2\u009e"+
		"\u009f\7f\2\2\u009f\20\3\2\2\2\u00a0\u00a1\7E\2\2\u00a1\u00a2\7k\2\2\u00a2"+
		"\u00a3\7t\2\2\u00a3\u00a4\7e\2\2\u00a4\u00a5\7n\2\2\u00a5\u00a6\7g\2\2"+
		"\u00a6\22\3\2\2\2\u00a7\u00a8\7T\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7"+
		"e\2\2\u00aa\u00ab\7v\2\2\u00ab\u00ac\7c\2\2\u00ac\u00ad\7p\2\2\u00ad\u00ae"+
		"\7i\2\2\u00ae\u00af\7n\2\2\u00af\u00b0\7g\2\2\u00b0\24\3\2\2\2\u00b1\u00b2"+
		"\7V\2\2\u00b2\u00b3\7t\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b5\7c\2\2\u00b5"+
		"\u00b6\7p\2\2\u00b6\u00b7\7i\2\2\u00b7\u00b8\7n\2\2\u00b8\u00b9\7g\2\2"+
		"\u00b9\26\3\2\2\2\u00ba\u00bb\7U\2\2\u00bb\u00bc\7j\2\2\u00bc\u00bd\7"+
		"c\2\2\u00bd\u00be\7r\2\2\u00be\u00bf\7g\2\2\u00bf\30\3\2\2\2\u00c0\u00c1"+
		"\7E\2\2\u00c1\u00c2\7q\2\2\u00c2\u00c3\7n\2\2\u00c3\u00c4\7q\2\2\u00c4"+
		"\u00c5\7t\2\2\u00c5\32\3\2\2\2\u00c6\u00c7\7D\2\2\u00c7\u00c8\7n\2\2\u00c8"+
		"\u00c9\7c\2\2\u00c9\u00ca\7e\2\2\u00ca\u00cb\7m\2\2\u00cb\34\3\2\2\2\u00cc"+
		"\u00cd\7Y\2\2\u00cd\u00ce\7j\2\2\u00ce\u00cf\7k\2\2\u00cf\u00d0\7v\2\2"+
		"\u00d0\u00d1\7g\2\2\u00d1\36\3\2\2\2\u00d2\u00d3\7T\2\2\u00d3\u00d4\7"+
		"g\2\2\u00d4\u00d5\7f\2\2\u00d5 \3\2\2\2\u00d6\u00d7\7I\2\2\u00d7\u00d8"+
		"\7t\2\2\u00d8\u00d9\7g\2\2\u00d9\u00da\7g\2\2\u00da\u00db\7p\2\2\u00db"+
		"\"\3\2\2\2\u00dc\u00dd\7D\2\2\u00dd\u00de\7n\2\2\u00de\u00df\7w\2\2\u00df"+
		"\u00e0\7g\2\2\u00e0$\3\2\2\2\u00e1\u00e2\7U\2\2\u00e2\u00e3\7j\2\2\u00e3"+
		"\u00e4\7c\2\2\u00e4\u00e5\7f\2\2\u00e5\u00e6\7g\2\2\u00e6\u00e7\7t\2\2"+
		"\u00e7&\3\2\2\2\u00e8\u00e9\7e\2\2\u00e9\u00ea\7n\2\2\u00ea\u00eb\7c\2"+
		"\2\u00eb\u00ec\7u\2\2\u00ec\u00ed\7u\2\2\u00ed(\3\2\2\2\u00ee\u00ef\7"+
		"g\2\2\u00ef\u00f0\7z\2\2\u00f0\u00f1\7v\2\2\u00f1\u00f2\7g\2\2\u00f2\u00f3"+
		"\7p\2\2\u00f3\u00f4\7f\2\2\u00f4\u00f5\7u\2\2\u00f5*\3\2\2\2\u00f6\u00f7"+
		"\7k\2\2\u00f7\u00f8\7o\2\2\u00f8\u00f9\7r\2\2\u00f9\u00fa\7n\2\2\u00fa"+
		"\u00fb\7g\2\2\u00fb\u00fc\7o\2\2\u00fc\u00fd\7g\2\2\u00fd\u00fe\7p\2\2"+
		"\u00fe\u00ff\7v\2\2\u00ff\u0100\7u\2\2\u0100,\3\2\2\2\u0101\u0102\7t\2"+
		"\2\u0102\u0103\7g\2\2\u0103\u0104\7v\2\2\u0104\u0105\7w\2\2\u0105\u0106"+
		"\7t\2\2\u0106\u0107\7p\2\2\u0107.\3\2\2\2\u0108\u0109\7k\2\2\u0109\u010a"+
		"\7h\2\2\u010a\60\3\2\2\2\u010b\u010c\7g\2\2\u010c\u010d\7n\2\2\u010d\u010e"+
		"\7u\2\2\u010e\u010f\7g\2\2\u010f\u0110\7\"\2\2\u0110\u0111\7k\2\2\u0111"+
		"\u0112\7h\2\2\u0112\62\3\2\2\2\u0113\u0114\7g\2\2\u0114\u0115\7n\2\2\u0115"+
		"\u0116\7u\2\2\u0116\u0117\7g\2\2\u0117\64\3\2\2\2\u0118\u0119\5u;\2\u0119"+
		"\66\3\2\2\2\u011a\u011b\5w<\2\u011b8\3\2\2\2\u011c\u011d\5\65\33\2\u011d"+
		"\u011f\7\60\2\2\u011e\u0120\5\65\33\2\u011f\u011e\3\2\2\2\u0120\u0121"+
		"\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122:\3\2\2\2\u0123"+
		"\u0124\5\67\34\2\u0124\u0126\7\60\2\2\u0125\u0127\5\65\33\2\u0126\u0125"+
		"\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129"+
		"<\3\2\2\2\u012a\u012b\7v\2\2\u012b\u012c\7t\2\2\u012c\u012d\7w\2\2\u012d"+
		"\u0134\7g\2\2\u012e\u012f\7h\2\2\u012f\u0130\7c\2\2\u0130\u0131\7n\2\2"+
		"\u0131\u0132\7u\2\2\u0132\u0134\7g\2\2\u0133\u012a\3\2\2\2\u0133\u012e"+
		"\3\2\2\2\u0134>\3\2\2\2\u0135\u0136\7}\2\2\u0136@\3\2\2\2\u0137\u0138"+
		"\7\177\2\2\u0138B\3\2\2\2\u0139\u013a\7*\2\2\u013aD\3\2\2\2\u013b\u013c"+
		"\7+\2\2\u013cF\3\2\2\2\u013d\u013e\7\60\2\2\u013eH\3\2\2\2\u013f\u0140"+
		"\7.\2\2\u0140J\3\2\2\2\u0141\u0142\7=\2\2\u0142L\3\2\2\2\u0143\u0144\7"+
		"A\2\2\u0144N\3\2\2\2\u0145\u0146\7<\2\2\u0146P\3\2\2\2\u0147\u0148\7?"+
		"\2\2\u0148R\3\2\2\2\u0149\u014a\7-\2\2\u014aT\3\2\2\2\u014b\u014c\7/\2"+
		"\2\u014cV\3\2\2\2\u014d\u014e\7\'\2\2\u014eX\3\2\2\2\u014f\u0150\7\61"+
		"\2\2\u0150Z\3\2\2\2\u0151\u0152\7,\2\2\u0152\\\3\2\2\2\u0153\u0154\7?"+
		"\2\2\u0154\u0155\7?\2\2\u0155^\3\2\2\2\u0156\u0157\7(\2\2\u0157\u0158"+
		"\7(\2\2\u0158`\3\2\2\2\u0159\u015a\7~\2\2\u015a\u015b\7~\2\2\u015bb\3"+
		"\2\2\2\u015c\u015d\7#\2\2\u015d\u015e\7?\2\2\u015ed\3\2\2\2\u015f\u0160"+
		"\7#\2\2\u0160f\3\2\2\2\u0161\u0162\7c\2\2\u0162\u0163\7d\2\2\u0163\u0164"+
		"\7u\2\2\u0164h\3\2\2\2\u0165\u0166\7u\2\2\u0166\u0167\7k\2\2\u0167\u0168"+
		"\7p\2\2\u0168j\3\2\2\2\u0169\u016a\7e\2\2\u016a\u016b\7q\2\2\u016b\u016c"+
		"\7u\2\2\u016cl\3\2\2\2\u016d\u016e\7v\2\2\u016e\u016f\7c\2\2\u016f\u0170"+
		"\7p\2\2\u0170n\3\2\2\2\u0171\u0172\7V\2\2\u0172\u0173\7k\2\2\u0173\u0174"+
		"\7o\2\2\u0174\u0175\7g\2\2\u0175p\3\2\2\2\u0176\u0179\5s:\2\u0177\u0179"+
		"\5\65\33\2\u0178\u0176\3\2\2\2\u0178\u0177\3\2\2\2\u0179\u017a\3\2\2\2"+
		"\u017a\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017br\3\2\2\2\u017c\u017d\t"+
		"\2\2\2\u017dt\3\2\2\2\u017e\u0187\7\62\2\2\u017f\u0183\4\63;\2\u0180\u0182"+
		"\4\62;\2\u0181\u0180\3\2\2\2\u0182\u0185\3\2\2\2\u0183\u0181\3\2\2\2\u0183"+
		"\u0184\3\2\2\2\u0184\u0187\3\2\2\2\u0185\u0183\3\2\2\2\u0186\u017e\3\2"+
		"\2\2\u0186\u017f\3\2\2\2\u0187v\3\2\2\2\u0188\u0189\7*\2\2\u0189\u018a"+
		"\7/\2\2\u018a\u018b\3\2\2\2\u018b\u018f\4\63;\2\u018c\u018e\4\62;\2\u018d"+
		"\u018c\3\2\2\2\u018e\u0191\3\2\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2"+
		"\2\2\u0190\u0192\3\2\2\2\u0191\u018f\3\2\2\2\u0192\u0193\7+\2\2\u0193"+
		"x\3\2\2\2\u0194\u0198\7%\2\2\u0195\u0197\n\3\2\2\u0196\u0195\3\2\2\2\u0197"+
		"\u019a\3\2\2\2\u0198\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199z\3\2\2\2"+
		"\u019a\u0198\3\2\2\2\u019b\u019d\t\4\2\2\u019c\u019b\3\2\2\2\u019d\u019e"+
		"\3\2\2\2\u019e\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0"+
		"\u01a1\b>\2\2\u01a1|\3\2\2\2\r\2\u0121\u0128\u0133\u0178\u017a\u0183\u0186"+
		"\u018f\u0198\u019e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}