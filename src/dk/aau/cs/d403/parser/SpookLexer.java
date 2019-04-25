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
		INT=1, FLOAT=2, BOOL=3, VECTOR2=4, VECTOR3=5, VECTOR4=6, VOID=7, CIRCLE=8, 
		RECTANGLE=9, TRIANGLE=10, SHAPE=11, COLOR=12, CIRCLEGRADIENT=13, LINEGRADIENT=14, 
		BLACK=15, WHITE=16, RED=17, GREEN=18, BLUE=19, MAIN=20, CLASS=21, EXTENDS=22, 
		IMPLEMENTS=23, RETURN=24, IF=25, ELSE_IF=26, ELSE=27, FOR=28, TO=29, DIGIT=30, 
		DIGIT_NEGATIVE=31, FLOAT_DIGIT=32, FLOAT_DIGIT_NEGATIVE=33, BOOL_LITERAL=34, 
		LEFT_BRACKET=35, RIGHT_BRACKET=36, LEFT_PAREN=37, RIGHT_PAREN=38, DOT=39, 
		COMMA=40, SEMICOLON=41, QUESTION=42, COLON=43, ASSIGN=44, ADD=45, SUB=46, 
		MOD=47, DIV=48, MUL=49, EQUAL=50, AND=51, OR=52, NOT_EQUAL=53, NOT=54, 
		COORDINATE_SWIZZLE_MASK=55, COLOR_SWIZZLE_MASK=56, ABS=57, SIN=58, COS=59, 
		TAN=60, UNIFORM=61, ID=62, COMMENT_STRING=63, WS=64;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT", "FLOAT", "BOOL", "VECTOR2", "VECTOR3", "VECTOR4", "VOID", "CIRCLE", 
			"RECTANGLE", "TRIANGLE", "SHAPE", "COLOR", "CIRCLEGRADIENT", "LINEGRADIENT", 
			"BLACK", "WHITE", "RED", "GREEN", "BLUE", "MAIN", "CLASS", "EXTENDS", 
			"IMPLEMENTS", "RETURN", "IF", "ELSE_IF", "ELSE", "FOR", "TO", "DIGIT", 
			"DIGIT_NEGATIVE", "FLOAT_DIGIT", "FLOAT_DIGIT_NEGATIVE", "BOOL_LITERAL", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", "DOT", 
			"COMMA", "SEMICOLON", "QUESTION", "COLON", "ASSIGN", "ADD", "SUB", "MOD", 
			"DIV", "MUL", "EQUAL", "AND", "OR", "NOT_EQUAL", "NOT", "COORDINATE_SWIZZLE_MASK", 
			"COLOR_SWIZZLE_MASK", "ABS", "SIN", "COS", "TAN", "UNIFORM", "ID", "LETTER", 
			"DIGIT_RULE", "DIGIT_NEGATIVE_RULE", "COORDINATE_SWIZZLE_MASK_RULE", 
			"COLOR_SWIZZLE_MASK_RULE", "COMMENT_STRING", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Int'", "'Float'", "'Bool'", "'Vec2'", "'Vec3'", "'Vec4'", "'Void'", 
			"'Circle'", "'Rectangle'", "'Triangle'", "'Shape'", "'Color'", "'CircleGradient'", 
			"'LineGradient'", "'Black'", "'White'", "'Red'", "'Green'", "'Blue'", 
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
			"CIRCLE", "RECTANGLE", "TRIANGLE", "SHAPE", "COLOR", "CIRCLEGRADIENT", 
			"LINEGRADIENT", "BLACK", "WHITE", "RED", "GREEN", "BLUE", "MAIN", "CLASS", 
			"EXTENDS", "IMPLEMENTS", "RETURN", "IF", "ELSE_IF", "ELSE", "FOR", "TO", 
			"DIGIT", "DIGIT_NEGATIVE", "FLOAT_DIGIT", "FLOAT_DIGIT_NEGATIVE", "BOOL_LITERAL", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", "DOT", 
			"COMMA", "SEMICOLON", "QUESTION", "COLON", "ASSIGN", "ADD", "SUB", "MOD", 
			"DIV", "MUL", "EQUAL", "AND", "OR", "NOT_EQUAL", "NOT", "COORDINATE_SWIZZLE_MASK", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2B\u01e3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\6!\u0153\n!\r"+
		"!\16!\u0154\3\"\3\"\3\"\6\"\u015a\n\"\r\"\16\"\u015b\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\5#\u0167\n#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+"+
		"\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3"+
		"\63\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\38\68\u0196"+
		"\n8\r8\168\u0197\39\69\u019b\n9\r9\169\u019c\3:\3:\3:\3:\3;\3;\3;\3;\3"+
		"<\3<\3<\3<\3=\3=\3=\3=\3>\3>\3>\3>\3>\3?\3?\6?\u01b6\n?\r?\16?\u01b7\3"+
		"@\3@\3A\3A\3A\7A\u01bf\nA\fA\16A\u01c2\13A\5A\u01c4\nA\3B\3B\3B\3B\3B"+
		"\7B\u01cb\nB\fB\16B\u01ce\13B\3B\3B\3C\3C\3D\3D\3E\3E\7E\u01d8\nE\fE\16"+
		"E\u01db\13E\3F\6F\u01de\nF\rF\16F\u01df\3F\3F\2\2G\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'"+
		"M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177"+
		"\2\u0081\2\u0083\2\u0085\2\u0087\2\u0089A\u008bB\3\2\6\3\2C|\5\2cdiit"+
		"t\4\2\13\f\17\17\5\2\13\f\17\17\"\"\2\u01e9\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2"+
		"\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2"+
		"s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\u0089"+
		"\3\2\2\2\2\u008b\3\2\2\2\3\u008d\3\2\2\2\5\u0091\3\2\2\2\7\u0097\3\2\2"+
		"\2\t\u009c\3\2\2\2\13\u00a1\3\2\2\2\r\u00a6\3\2\2\2\17\u00ab\3\2\2\2\21"+
		"\u00b0\3\2\2\2\23\u00b7\3\2\2\2\25\u00c1\3\2\2\2\27\u00ca\3\2\2\2\31\u00d0"+
		"\3\2\2\2\33\u00d6\3\2\2\2\35\u00e5\3\2\2\2\37\u00f2\3\2\2\2!\u00f8\3\2"+
		"\2\2#\u00fe\3\2\2\2%\u0102\3\2\2\2\'\u0108\3\2\2\2)\u010d\3\2\2\2+\u0114"+
		"\3\2\2\2-\u011a\3\2\2\2/\u0122\3\2\2\2\61\u012d\3\2\2\2\63\u0134\3\2\2"+
		"\2\65\u0137\3\2\2\2\67\u013f\3\2\2\29\u0144\3\2\2\2;\u0148\3\2\2\2=\u014b"+
		"\3\2\2\2?\u014d\3\2\2\2A\u014f\3\2\2\2C\u0156\3\2\2\2E\u0166\3\2\2\2G"+
		"\u0168\3\2\2\2I\u016a\3\2\2\2K\u016c\3\2\2\2M\u016e\3\2\2\2O\u0170\3\2"+
		"\2\2Q\u0172\3\2\2\2S\u0174\3\2\2\2U\u0176\3\2\2\2W\u0178\3\2\2\2Y\u017a"+
		"\3\2\2\2[\u017c\3\2\2\2]\u017e\3\2\2\2_\u0180\3\2\2\2a\u0182\3\2\2\2c"+
		"\u0184\3\2\2\2e\u0186\3\2\2\2g\u0189\3\2\2\2i\u018c\3\2\2\2k\u018f\3\2"+
		"\2\2m\u0192\3\2\2\2o\u0195\3\2\2\2q\u019a\3\2\2\2s\u019e\3\2\2\2u\u01a2"+
		"\3\2\2\2w\u01a6\3\2\2\2y\u01aa\3\2\2\2{\u01ae\3\2\2\2}\u01b5\3\2\2\2\177"+
		"\u01b9\3\2\2\2\u0081\u01c3\3\2\2\2\u0083\u01c5\3\2\2\2\u0085\u01d1\3\2"+
		"\2\2\u0087\u01d3\3\2\2\2\u0089\u01d5\3\2\2\2\u008b\u01dd\3\2\2\2\u008d"+
		"\u008e\7K\2\2\u008e\u008f\7p\2\2\u008f\u0090\7v\2\2\u0090\4\3\2\2\2\u0091"+
		"\u0092\7H\2\2\u0092\u0093\7n\2\2\u0093\u0094\7q\2\2\u0094\u0095\7c\2\2"+
		"\u0095\u0096\7v\2\2\u0096\6\3\2\2\2\u0097\u0098\7D\2\2\u0098\u0099\7q"+
		"\2\2\u0099\u009a\7q\2\2\u009a\u009b\7n\2\2\u009b\b\3\2\2\2\u009c\u009d"+
		"\7X\2\2\u009d\u009e\7g\2\2\u009e\u009f\7e\2\2\u009f\u00a0\7\64\2\2\u00a0"+
		"\n\3\2\2\2\u00a1\u00a2\7X\2\2\u00a2\u00a3\7g\2\2\u00a3\u00a4\7e\2\2\u00a4"+
		"\u00a5\7\65\2\2\u00a5\f\3\2\2\2\u00a6\u00a7\7X\2\2\u00a7\u00a8\7g\2\2"+
		"\u00a8\u00a9\7e\2\2\u00a9\u00aa\7\66\2\2\u00aa\16\3\2\2\2\u00ab\u00ac"+
		"\7X\2\2\u00ac\u00ad\7q\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7f\2\2\u00af"+
		"\20\3\2\2\2\u00b0\u00b1\7E\2\2\u00b1\u00b2\7k\2\2\u00b2\u00b3\7t\2\2\u00b3"+
		"\u00b4\7e\2\2\u00b4\u00b5\7n\2\2\u00b5\u00b6\7g\2\2\u00b6\22\3\2\2\2\u00b7"+
		"\u00b8\7T\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba\7e\2\2\u00ba\u00bb\7v\2\2"+
		"\u00bb\u00bc\7c\2\2\u00bc\u00bd\7p\2\2\u00bd\u00be\7i\2\2\u00be\u00bf"+
		"\7n\2\2\u00bf\u00c0\7g\2\2\u00c0\24\3\2\2\2\u00c1\u00c2\7V\2\2\u00c2\u00c3"+
		"\7t\2\2\u00c3\u00c4\7k\2\2\u00c4\u00c5\7c\2\2\u00c5\u00c6\7p\2\2\u00c6"+
		"\u00c7\7i\2\2\u00c7\u00c8\7n\2\2\u00c8\u00c9\7g\2\2\u00c9\26\3\2\2\2\u00ca"+
		"\u00cb\7U\2\2\u00cb\u00cc\7j\2\2\u00cc\u00cd\7c\2\2\u00cd\u00ce\7r\2\2"+
		"\u00ce\u00cf\7g\2\2\u00cf\30\3\2\2\2\u00d0\u00d1\7E\2\2\u00d1\u00d2\7"+
		"q\2\2\u00d2\u00d3\7n\2\2\u00d3\u00d4\7q\2\2\u00d4\u00d5\7t\2\2\u00d5\32"+
		"\3\2\2\2\u00d6\u00d7\7E\2\2\u00d7\u00d8\7k\2\2\u00d8\u00d9\7t\2\2\u00d9"+
		"\u00da\7e\2\2\u00da\u00db\7n\2\2\u00db\u00dc\7g\2\2\u00dc\u00dd\7I\2\2"+
		"\u00dd\u00de\7t\2\2\u00de\u00df\7c\2\2\u00df\u00e0\7f\2\2\u00e0\u00e1"+
		"\7k\2\2\u00e1\u00e2\7g\2\2\u00e2\u00e3\7p\2\2\u00e3\u00e4\7v\2\2\u00e4"+
		"\34\3\2\2\2\u00e5\u00e6\7N\2\2\u00e6\u00e7\7k\2\2\u00e7\u00e8\7p\2\2\u00e8"+
		"\u00e9\7g\2\2\u00e9\u00ea\7I\2\2\u00ea\u00eb\7t\2\2\u00eb\u00ec\7c\2\2"+
		"\u00ec\u00ed\7f\2\2\u00ed\u00ee\7k\2\2\u00ee\u00ef\7g\2\2\u00ef\u00f0"+
		"\7p\2\2\u00f0\u00f1\7v\2\2\u00f1\36\3\2\2\2\u00f2\u00f3\7D\2\2\u00f3\u00f4"+
		"\7n\2\2\u00f4\u00f5\7c\2\2\u00f5\u00f6\7e\2\2\u00f6\u00f7\7m\2\2\u00f7"+
		" \3\2\2\2\u00f8\u00f9\7Y\2\2\u00f9\u00fa\7j\2\2\u00fa\u00fb\7k\2\2\u00fb"+
		"\u00fc\7v\2\2\u00fc\u00fd\7g\2\2\u00fd\"\3\2\2\2\u00fe\u00ff\7T\2\2\u00ff"+
		"\u0100\7g\2\2\u0100\u0101\7f\2\2\u0101$\3\2\2\2\u0102\u0103\7I\2\2\u0103"+
		"\u0104\7t\2\2\u0104\u0105\7g\2\2\u0105\u0106\7g\2\2\u0106\u0107\7p\2\2"+
		"\u0107&\3\2\2\2\u0108\u0109\7D\2\2\u0109\u010a\7n\2\2\u010a\u010b\7w\2"+
		"\2\u010b\u010c\7g\2\2\u010c(\3\2\2\2\u010d\u010e\7U\2\2\u010e\u010f\7"+
		"j\2\2\u010f\u0110\7c\2\2\u0110\u0111\7f\2\2\u0111\u0112\7g\2\2\u0112\u0113"+
		"\7t\2\2\u0113*\3\2\2\2\u0114\u0115\7E\2\2\u0115\u0116\7n\2\2\u0116\u0117"+
		"\7c\2\2\u0117\u0118\7u\2\2\u0118\u0119\7u\2\2\u0119,\3\2\2\2\u011a\u011b"+
		"\7g\2\2\u011b\u011c\7z\2\2\u011c\u011d\7v\2\2\u011d\u011e\7g\2\2\u011e"+
		"\u011f\7p\2\2\u011f\u0120\7f\2\2\u0120\u0121\7u\2\2\u0121.\3\2\2\2\u0122"+
		"\u0123\7k\2\2\u0123\u0124\7o\2\2\u0124\u0125\7r\2\2\u0125\u0126\7n\2\2"+
		"\u0126\u0127\7g\2\2\u0127\u0128\7o\2\2\u0128\u0129\7g\2\2\u0129\u012a"+
		"\7p\2\2\u012a\u012b\7v\2\2\u012b\u012c\7u\2\2\u012c\60\3\2\2\2\u012d\u012e"+
		"\7t\2\2\u012e\u012f\7g\2\2\u012f\u0130\7v\2\2\u0130\u0131\7w\2\2\u0131"+
		"\u0132\7t\2\2\u0132\u0133\7p\2\2\u0133\62\3\2\2\2\u0134\u0135\7k\2\2\u0135"+
		"\u0136\7h\2\2\u0136\64\3\2\2\2\u0137\u0138\7g\2\2\u0138\u0139\7n\2\2\u0139"+
		"\u013a\7u\2\2\u013a\u013b\7g\2\2\u013b\u013c\7\"\2\2\u013c\u013d\7k\2"+
		"\2\u013d\u013e\7h\2\2\u013e\66\3\2\2\2\u013f\u0140\7g\2\2\u0140\u0141"+
		"\7n\2\2\u0141\u0142\7u\2\2\u0142\u0143\7g\2\2\u01438\3\2\2\2\u0144\u0145"+
		"\7h\2\2\u0145\u0146\7q\2\2\u0146\u0147\7t\2\2\u0147:\3\2\2\2\u0148\u0149"+
		"\7v\2\2\u0149\u014a\7q\2\2\u014a<\3\2\2\2\u014b\u014c\5\u0081A\2\u014c"+
		">\3\2\2\2\u014d\u014e\5\u0083B\2\u014e@\3\2\2\2\u014f\u0150\5=\37\2\u0150"+
		"\u0152\7\60\2\2\u0151\u0153\5=\37\2\u0152\u0151\3\2\2\2\u0153\u0154\3"+
		"\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155B\3\2\2\2\u0156\u0157"+
		"\5? \2\u0157\u0159\7\60\2\2\u0158\u015a\5=\37\2\u0159\u0158\3\2\2\2\u015a"+
		"\u015b\3\2\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015cD\3\2\2\2"+
		"\u015d\u015e\7v\2\2\u015e\u015f\7t\2\2\u015f\u0160\7w\2\2\u0160\u0167"+
		"\7g\2\2\u0161\u0162\7h\2\2\u0162\u0163\7c\2\2\u0163\u0164\7n\2\2\u0164"+
		"\u0165\7u\2\2\u0165\u0167\7g\2\2\u0166\u015d\3\2\2\2\u0166\u0161\3\2\2"+
		"\2\u0167F\3\2\2\2\u0168\u0169\7}\2\2\u0169H\3\2\2\2\u016a\u016b\7\177"+
		"\2\2\u016bJ\3\2\2\2\u016c\u016d\7*\2\2\u016dL\3\2\2\2\u016e\u016f\7+\2"+
		"\2\u016fN\3\2\2\2\u0170\u0171\7\60\2\2\u0171P\3\2\2\2\u0172\u0173\7.\2"+
		"\2\u0173R\3\2\2\2\u0174\u0175\7=\2\2\u0175T\3\2\2\2\u0176\u0177\7A\2\2"+
		"\u0177V\3\2\2\2\u0178\u0179\7<\2\2\u0179X\3\2\2\2\u017a\u017b\7?\2\2\u017b"+
		"Z\3\2\2\2\u017c\u017d\7-\2\2\u017d\\\3\2\2\2\u017e\u017f\7/\2\2\u017f"+
		"^\3\2\2\2\u0180\u0181\7\'\2\2\u0181`\3\2\2\2\u0182\u0183\7\61\2\2\u0183"+
		"b\3\2\2\2\u0184\u0185\7,\2\2\u0185d\3\2\2\2\u0186\u0187\7?\2\2\u0187\u0188"+
		"\7?\2\2\u0188f\3\2\2\2\u0189\u018a\7(\2\2\u018a\u018b\7(\2\2\u018bh\3"+
		"\2\2\2\u018c\u018d\7~\2\2\u018d\u018e\7~\2\2\u018ej\3\2\2\2\u018f\u0190"+
		"\7#\2\2\u0190\u0191\7?\2\2\u0191l\3\2\2\2\u0192\u0193\7#\2\2\u0193n\3"+
		"\2\2\2\u0194\u0196\5\u0085C\2\u0195\u0194\3\2\2\2\u0196\u0197\3\2\2\2"+
		"\u0197\u0195\3\2\2\2\u0197\u0198\3\2\2\2\u0198p\3\2\2\2\u0199\u019b\5"+
		"\u0087D\2\u019a\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019a\3\2\2\2"+
		"\u019c\u019d\3\2\2\2\u019dr\3\2\2\2\u019e\u019f\7c\2\2\u019f\u01a0\7d"+
		"\2\2\u01a0\u01a1\7u\2\2\u01a1t\3\2\2\2\u01a2\u01a3\7u\2\2\u01a3\u01a4"+
		"\7k\2\2\u01a4\u01a5\7p\2\2\u01a5v\3\2\2\2\u01a6\u01a7\7e\2\2\u01a7\u01a8"+
		"\7q\2\2\u01a8\u01a9\7u\2\2\u01a9x\3\2\2\2\u01aa\u01ab\7v\2\2\u01ab\u01ac"+
		"\7c\2\2\u01ac\u01ad\7p\2\2\u01adz\3\2\2\2\u01ae\u01af\7V\2\2\u01af\u01b0"+
		"\7k\2\2\u01b0\u01b1\7o\2\2\u01b1\u01b2\7g\2\2\u01b2|\3\2\2\2\u01b3\u01b6"+
		"\5\177@\2\u01b4\u01b6\5=\37\2\u01b5\u01b3\3\2\2\2\u01b5\u01b4\3\2\2\2"+
		"\u01b6\u01b7\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8~\3"+
		"\2\2\2\u01b9\u01ba\t\2\2\2\u01ba\u0080\3\2\2\2\u01bb\u01c4\7\62\2\2\u01bc"+
		"\u01c0\4\63;\2\u01bd\u01bf\4\62;\2\u01be\u01bd\3\2\2\2\u01bf\u01c2\3\2"+
		"\2\2\u01c0\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c4\3\2\2\2\u01c2"+
		"\u01c0\3\2\2\2\u01c3\u01bb\3\2\2\2\u01c3\u01bc\3\2\2\2\u01c4\u0082\3\2"+
		"\2\2\u01c5\u01c6\7*\2\2\u01c6\u01c7\7/\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01cc"+
		"\4\63;\2\u01c9\u01cb\4\62;\2\u01ca\u01c9\3\2\2\2\u01cb\u01ce\3\2\2\2\u01cc"+
		"\u01ca\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01cf\3\2\2\2\u01ce\u01cc\3\2"+
		"\2\2\u01cf\u01d0\7+\2\2\u01d0\u0084\3\2\2\2\u01d1\u01d2\4y|\2\u01d2\u0086"+
		"\3\2\2\2\u01d3\u01d4\t\3\2\2\u01d4\u0088\3\2\2\2\u01d5\u01d9\7%\2\2\u01d6"+
		"\u01d8\n\4\2\2\u01d7\u01d6\3\2\2\2\u01d8\u01db\3\2\2\2\u01d9\u01d7\3\2"+
		"\2\2\u01d9\u01da\3\2\2\2\u01da\u008a\3\2\2\2\u01db\u01d9\3\2\2\2\u01dc"+
		"\u01de\t\5\2\2\u01dd\u01dc\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u01dd\3\2"+
		"\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01e2\bF\2\2\u01e2"+
		"\u008c\3\2\2\2\17\2\u0154\u015b\u0166\u0197\u019c\u01b5\u01b7\u01c0\u01c3"+
		"\u01cc\u01d9\u01df\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}