// Generated from /Users/Garrido/PycharmProjects/PythonProjects/P4/src/SpookLexer.g4 by ANTLR 4.7.2
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
		RECTANGLE=9, TRIANGLE=10, SQUARE=11, SHAPE=12, COLOR=13, CIRCLEGRADIENT=14, 
		LINEGRADIENT=15, BLACK=16, WHITE=17, RED=18, GREEN=19, BLUE=20, MAIN=21, 
		CLASS=22, EXTENDS=23, IMPLEMENTS=24, RETURN=25, IF=26, ELSE_IF=27, ELSE=28, 
		FOR=29, TO=30, DIGIT=31, DIGIT_NEGATIVE=32, FLOAT_DIGIT=33, FLOAT_DIGIT_NEGATIVE=34, 
		BOOL_LITERAL=35, LEFT_BRACKET=36, RIGHT_BRACKET=37, LEFT_PAREN=38, RIGHT_PAREN=39, 
		DOT=40, COMMA=41, SEMICOLON=42, QUESTION=43, COLON=44, ASSIGN=45, ADD=46, 
		SUB=47, MOD=48, DIV=49, MUL=50, EQUAL=51, AND=52, OR=53, NOT_EQUAL=54, 
		NOT=55, COORDINATE_SWIZZLE_MASK=56, COLOR_SWIZZLE_MASK=57, ABS=58, SIN=59, 
		COS=60, TAN=61, UNIFORM=62, ID=63, COMMENT_STRING=64, WS=65;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT", "FLOAT", "BOOL", "VECTOR2", "VECTOR3", "VECTOR4", "VOID", "CIRCLE", 
			"RECTANGLE", "TRIANGLE", "SQUARE", "SHAPE", "COLOR", "CIRCLEGRADIENT", 
			"LINEGRADIENT", "BLACK", "WHITE", "RED", "GREEN", "BLUE", "MAIN", "CLASS", 
			"EXTENDS", "IMPLEMENTS", "RETURN", "IF", "ELSE_IF", "ELSE", "FOR", "TO", 
			"DIGIT", "DIGIT_NEGATIVE", "FLOAT_DIGIT", "FLOAT_DIGIT_NEGATIVE", "BOOL_LITERAL", 
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
			"'Circle'", "'Rectangle'", "'Triangle'", "'Square'", "'Shape'", "'Color'", 
			"'CircleGradient'", "'LineGradient'", "'Black'", "'White'", "'Red'", 
			"'Green'", "'Blue'", "'Shader'", "'Class'", "'extends'", "'implements'", 
			"'return'", "'if'", "'else if'", "'else'", "'for'", "'to'", null, null, 
			null, null, null, "'{'", "'}'", "'('", "')'", "'.'", "','", "';'", "'?'", 
			"':'", "'='", "'+'", "'-'", "'%'", "'/'", "'*'", "'=='", "'&&'", "'||'", 
			"'!='", "'!'", null, null, "'abs'", "'sin'", "'cos'", "'tan'", "'Time'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "FLOAT", "BOOL", "VECTOR2", "VECTOR3", "VECTOR4", "VOID", 
			"CIRCLE", "RECTANGLE", "TRIANGLE", "SQUARE", "SHAPE", "COLOR", "CIRCLEGRADIENT", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2C\u01ec\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37"+
		"\3 \3 \3!\3!\3\"\3\"\3\"\6\"\u015c\n\"\r\"\16\"\u015d\3#\3#\3#\6#\u0163"+
		"\n#\r#\16#\u0164\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u0170\n$\3%\3%\3&\3&\3"+
		"\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61"+
		"\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66"+
		"\3\67\3\67\3\67\38\38\39\69\u019f\n9\r9\169\u01a0\3:\6:\u01a4\n:\r:\16"+
		":\u01a5\3;\3;\3;\3;\3<\3<\3<\3<\3=\3=\3=\3=\3>\3>\3>\3>\3?\3?\3?\3?\3"+
		"?\3@\3@\6@\u01bf\n@\r@\16@\u01c0\3A\3A\3B\3B\3B\7B\u01c8\nB\fB\16B\u01cb"+
		"\13B\5B\u01cd\nB\3C\3C\3C\3C\3C\7C\u01d4\nC\fC\16C\u01d7\13C\3C\3C\3D"+
		"\3D\3E\3E\3F\3F\7F\u01e1\nF\fF\16F\u01e4\13F\3G\6G\u01e7\nG\rG\16G\u01e8"+
		"\3G\3G\2\2H\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65"+
		"i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081\2\u0083\2\u0085\2\u0087\2\u0089"+
		"\2\u008bB\u008dC\3\2\6\3\2C|\5\2cdiitt\4\2\13\f\17\17\5\2\13\f\17\17\""+
		"\"\2\u01f2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2"+
		"\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y"+
		"\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3"+
		"\2\2\2\3\u008f\3\2\2\2\5\u0093\3\2\2\2\7\u0099\3\2\2\2\t\u009e\3\2\2\2"+
		"\13\u00a3\3\2\2\2\r\u00a8\3\2\2\2\17\u00ad\3\2\2\2\21\u00b2\3\2\2\2\23"+
		"\u00b9\3\2\2\2\25\u00c3\3\2\2\2\27\u00cc\3\2\2\2\31\u00d3\3\2\2\2\33\u00d9"+
		"\3\2\2\2\35\u00df\3\2\2\2\37\u00ee\3\2\2\2!\u00fb\3\2\2\2#\u0101\3\2\2"+
		"\2%\u0107\3\2\2\2\'\u010b\3\2\2\2)\u0111\3\2\2\2+\u0116\3\2\2\2-\u011d"+
		"\3\2\2\2/\u0123\3\2\2\2\61\u012b\3\2\2\2\63\u0136\3\2\2\2\65\u013d\3\2"+
		"\2\2\67\u0140\3\2\2\29\u0148\3\2\2\2;\u014d\3\2\2\2=\u0151\3\2\2\2?\u0154"+
		"\3\2\2\2A\u0156\3\2\2\2C\u0158\3\2\2\2E\u015f\3\2\2\2G\u016f\3\2\2\2I"+
		"\u0171\3\2\2\2K\u0173\3\2\2\2M\u0175\3\2\2\2O\u0177\3\2\2\2Q\u0179\3\2"+
		"\2\2S\u017b\3\2\2\2U\u017d\3\2\2\2W\u017f\3\2\2\2Y\u0181\3\2\2\2[\u0183"+
		"\3\2\2\2]\u0185\3\2\2\2_\u0187\3\2\2\2a\u0189\3\2\2\2c\u018b\3\2\2\2e"+
		"\u018d\3\2\2\2g\u018f\3\2\2\2i\u0192\3\2\2\2k\u0195\3\2\2\2m\u0198\3\2"+
		"\2\2o\u019b\3\2\2\2q\u019e\3\2\2\2s\u01a3\3\2\2\2u\u01a7\3\2\2\2w\u01ab"+
		"\3\2\2\2y\u01af\3\2\2\2{\u01b3\3\2\2\2}\u01b7\3\2\2\2\177\u01be\3\2\2"+
		"\2\u0081\u01c2\3\2\2\2\u0083\u01cc\3\2\2\2\u0085\u01ce\3\2\2\2\u0087\u01da"+
		"\3\2\2\2\u0089\u01dc\3\2\2\2\u008b\u01de\3\2\2\2\u008d\u01e6\3\2\2\2\u008f"+
		"\u0090\7K\2\2\u0090\u0091\7p\2\2\u0091\u0092\7v\2\2\u0092\4\3\2\2\2\u0093"+
		"\u0094\7H\2\2\u0094\u0095\7n\2\2\u0095\u0096\7q\2\2\u0096\u0097\7c\2\2"+
		"\u0097\u0098\7v\2\2\u0098\6\3\2\2\2\u0099\u009a\7D\2\2\u009a\u009b\7q"+
		"\2\2\u009b\u009c\7q\2\2\u009c\u009d\7n\2\2\u009d\b\3\2\2\2\u009e\u009f"+
		"\7X\2\2\u009f\u00a0\7g\2\2\u00a0\u00a1\7e\2\2\u00a1\u00a2\7\64\2\2\u00a2"+
		"\n\3\2\2\2\u00a3\u00a4\7X\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7e\2\2\u00a6"+
		"\u00a7\7\65\2\2\u00a7\f\3\2\2\2\u00a8\u00a9\7X\2\2\u00a9\u00aa\7g\2\2"+
		"\u00aa\u00ab\7e\2\2\u00ab\u00ac\7\66\2\2\u00ac\16\3\2\2\2\u00ad\u00ae"+
		"\7X\2\2\u00ae\u00af\7q\2\2\u00af\u00b0\7k\2\2\u00b0\u00b1\7f\2\2\u00b1"+
		"\20\3\2\2\2\u00b2\u00b3\7E\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b5\7t\2\2\u00b5"+
		"\u00b6\7e\2\2\u00b6\u00b7\7n\2\2\u00b7\u00b8\7g\2\2\u00b8\22\3\2\2\2\u00b9"+
		"\u00ba\7T\2\2\u00ba\u00bb\7g\2\2\u00bb\u00bc\7e\2\2\u00bc\u00bd\7v\2\2"+
		"\u00bd\u00be\7c\2\2\u00be\u00bf\7p\2\2\u00bf\u00c0\7i\2\2\u00c0\u00c1"+
		"\7n\2\2\u00c1\u00c2\7g\2\2\u00c2\24\3\2\2\2\u00c3\u00c4\7V\2\2\u00c4\u00c5"+
		"\7t\2\2\u00c5\u00c6\7k\2\2\u00c6\u00c7\7c\2\2\u00c7\u00c8\7p\2\2\u00c8"+
		"\u00c9\7i\2\2\u00c9\u00ca\7n\2\2\u00ca\u00cb\7g\2\2\u00cb\26\3\2\2\2\u00cc"+
		"\u00cd\7U\2\2\u00cd\u00ce\7s\2\2\u00ce\u00cf\7w\2\2\u00cf\u00d0\7c\2\2"+
		"\u00d0\u00d1\7t\2\2\u00d1\u00d2\7g\2\2\u00d2\30\3\2\2\2\u00d3\u00d4\7"+
		"U\2\2\u00d4\u00d5\7j\2\2\u00d5\u00d6\7c\2\2\u00d6\u00d7\7r\2\2\u00d7\u00d8"+
		"\7g\2\2\u00d8\32\3\2\2\2\u00d9\u00da\7E\2\2\u00da\u00db\7q\2\2\u00db\u00dc"+
		"\7n\2\2\u00dc\u00dd\7q\2\2\u00dd\u00de\7t\2\2\u00de\34\3\2\2\2\u00df\u00e0"+
		"\7E\2\2\u00e0\u00e1\7k\2\2\u00e1\u00e2\7t\2\2\u00e2\u00e3\7e\2\2\u00e3"+
		"\u00e4\7n\2\2\u00e4\u00e5\7g\2\2\u00e5\u00e6\7I\2\2\u00e6\u00e7\7t\2\2"+
		"\u00e7\u00e8\7c\2\2\u00e8\u00e9\7f\2\2\u00e9\u00ea\7k\2\2\u00ea\u00eb"+
		"\7g\2\2\u00eb\u00ec\7p\2\2\u00ec\u00ed\7v\2\2\u00ed\36\3\2\2\2\u00ee\u00ef"+
		"\7N\2\2\u00ef\u00f0\7k\2\2\u00f0\u00f1\7p\2\2\u00f1\u00f2\7g\2\2\u00f2"+
		"\u00f3\7I\2\2\u00f3\u00f4\7t\2\2\u00f4\u00f5\7c\2\2\u00f5\u00f6\7f\2\2"+
		"\u00f6\u00f7\7k\2\2\u00f7\u00f8\7g\2\2\u00f8\u00f9\7p\2\2\u00f9\u00fa"+
		"\7v\2\2\u00fa \3\2\2\2\u00fb\u00fc\7D\2\2\u00fc\u00fd\7n\2\2\u00fd\u00fe"+
		"\7c\2\2\u00fe\u00ff\7e\2\2\u00ff\u0100\7m\2\2\u0100\"\3\2\2\2\u0101\u0102"+
		"\7Y\2\2\u0102\u0103\7j\2\2\u0103\u0104\7k\2\2\u0104\u0105\7v\2\2\u0105"+
		"\u0106\7g\2\2\u0106$\3\2\2\2\u0107\u0108\7T\2\2\u0108\u0109\7g\2\2\u0109"+
		"\u010a\7f\2\2\u010a&\3\2\2\2\u010b\u010c\7I\2\2\u010c\u010d\7t\2\2\u010d"+
		"\u010e\7g\2\2\u010e\u010f\7g\2\2\u010f\u0110\7p\2\2\u0110(\3\2\2\2\u0111"+
		"\u0112\7D\2\2\u0112\u0113\7n\2\2\u0113\u0114\7w\2\2\u0114\u0115\7g\2\2"+
		"\u0115*\3\2\2\2\u0116\u0117\7U\2\2\u0117\u0118\7j\2\2\u0118\u0119\7c\2"+
		"\2\u0119\u011a\7f\2\2\u011a\u011b\7g\2\2\u011b\u011c\7t\2\2\u011c,\3\2"+
		"\2\2\u011d\u011e\7E\2\2\u011e\u011f\7n\2\2\u011f\u0120\7c\2\2\u0120\u0121"+
		"\7u\2\2\u0121\u0122\7u\2\2\u0122.\3\2\2\2\u0123\u0124\7g\2\2\u0124\u0125"+
		"\7z\2\2\u0125\u0126\7v\2\2\u0126\u0127\7g\2\2\u0127\u0128\7p\2\2\u0128"+
		"\u0129\7f\2\2\u0129\u012a\7u\2\2\u012a\60\3\2\2\2\u012b\u012c\7k\2\2\u012c"+
		"\u012d\7o\2\2\u012d\u012e\7r\2\2\u012e\u012f\7n\2\2\u012f\u0130\7g\2\2"+
		"\u0130\u0131\7o\2\2\u0131\u0132\7g\2\2\u0132\u0133\7p\2\2\u0133\u0134"+
		"\7v\2\2\u0134\u0135\7u\2\2\u0135\62\3\2\2\2\u0136\u0137\7t\2\2\u0137\u0138"+
		"\7g\2\2\u0138\u0139\7v\2\2\u0139\u013a\7w\2\2\u013a\u013b\7t\2\2\u013b"+
		"\u013c\7p\2\2\u013c\64\3\2\2\2\u013d\u013e\7k\2\2\u013e\u013f\7h\2\2\u013f"+
		"\66\3\2\2\2\u0140\u0141\7g\2\2\u0141\u0142\7n\2\2\u0142\u0143\7u\2\2\u0143"+
		"\u0144\7g\2\2\u0144\u0145\7\"\2\2\u0145\u0146\7k\2\2\u0146\u0147\7h\2"+
		"\2\u01478\3\2\2\2\u0148\u0149\7g\2\2\u0149\u014a\7n\2\2\u014a\u014b\7"+
		"u\2\2\u014b\u014c\7g\2\2\u014c:\3\2\2\2\u014d\u014e\7h\2\2\u014e\u014f"+
		"\7q\2\2\u014f\u0150\7t\2\2\u0150<\3\2\2\2\u0151\u0152\7v\2\2\u0152\u0153"+
		"\7q\2\2\u0153>\3\2\2\2\u0154\u0155\5\u0083B\2\u0155@\3\2\2\2\u0156\u0157"+
		"\5\u0085C\2\u0157B\3\2\2\2\u0158\u0159\5? \2\u0159\u015b\7\60\2\2\u015a"+
		"\u015c\5? \2\u015b\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015b\3\2\2"+
		"\2\u015d\u015e\3\2\2\2\u015eD\3\2\2\2\u015f\u0160\5A!\2\u0160\u0162\7"+
		"\60\2\2\u0161\u0163\5? \2\u0162\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164"+
		"\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165F\3\2\2\2\u0166\u0167\7v\2\2\u0167"+
		"\u0168\7t\2\2\u0168\u0169\7w\2\2\u0169\u0170\7g\2\2\u016a\u016b\7h\2\2"+
		"\u016b\u016c\7c\2\2\u016c\u016d\7n\2\2\u016d\u016e\7u\2\2\u016e\u0170"+
		"\7g\2\2\u016f\u0166\3\2\2\2\u016f\u016a\3\2\2\2\u0170H\3\2\2\2\u0171\u0172"+
		"\7}\2\2\u0172J\3\2\2\2\u0173\u0174\7\177\2\2\u0174L\3\2\2\2\u0175\u0176"+
		"\7*\2\2\u0176N\3\2\2\2\u0177\u0178\7+\2\2\u0178P\3\2\2\2\u0179\u017a\7"+
		"\60\2\2\u017aR\3\2\2\2\u017b\u017c\7.\2\2\u017cT\3\2\2\2\u017d\u017e\7"+
		"=\2\2\u017eV\3\2\2\2\u017f\u0180\7A\2\2\u0180X\3\2\2\2\u0181\u0182\7<"+
		"\2\2\u0182Z\3\2\2\2\u0183\u0184\7?\2\2\u0184\\\3\2\2\2\u0185\u0186\7-"+
		"\2\2\u0186^\3\2\2\2\u0187\u0188\7/\2\2\u0188`\3\2\2\2\u0189\u018a\7\'"+
		"\2\2\u018ab\3\2\2\2\u018b\u018c\7\61\2\2\u018cd\3\2\2\2\u018d\u018e\7"+
		",\2\2\u018ef\3\2\2\2\u018f\u0190\7?\2\2\u0190\u0191\7?\2\2\u0191h\3\2"+
		"\2\2\u0192\u0193\7(\2\2\u0193\u0194\7(\2\2\u0194j\3\2\2\2\u0195\u0196"+
		"\7~\2\2\u0196\u0197\7~\2\2\u0197l\3\2\2\2\u0198\u0199\7#\2\2\u0199\u019a"+
		"\7?\2\2\u019an\3\2\2\2\u019b\u019c\7#\2\2\u019cp\3\2\2\2\u019d\u019f\5"+
		"\u0087D\2\u019e\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u019e\3\2\2\2"+
		"\u01a0\u01a1\3\2\2\2\u01a1r\3\2\2\2\u01a2\u01a4\5\u0089E\2\u01a3\u01a2"+
		"\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6"+
		"t\3\2\2\2\u01a7\u01a8\7c\2\2\u01a8\u01a9\7d\2\2\u01a9\u01aa\7u\2\2\u01aa"+
		"v\3\2\2\2\u01ab\u01ac\7u\2\2\u01ac\u01ad\7k\2\2\u01ad\u01ae\7p\2\2\u01ae"+
		"x\3\2\2\2\u01af\u01b0\7e\2\2\u01b0\u01b1\7q\2\2\u01b1\u01b2\7u\2\2\u01b2"+
		"z\3\2\2\2\u01b3\u01b4\7v\2\2\u01b4\u01b5\7c\2\2\u01b5\u01b6\7p\2\2\u01b6"+
		"|\3\2\2\2\u01b7\u01b8\7V\2\2\u01b8\u01b9\7k\2\2\u01b9\u01ba\7o\2\2\u01ba"+
		"\u01bb\7g\2\2\u01bb~\3\2\2\2\u01bc\u01bf\5\u0081A\2\u01bd\u01bf\5? \2"+
		"\u01be\u01bc\3\2\2\2\u01be\u01bd\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01be"+
		"\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u0080\3\2\2\2\u01c2\u01c3\t\2\2\2\u01c3"+
		"\u0082\3\2\2\2\u01c4\u01cd\7\62\2\2\u01c5\u01c9\4\63;\2\u01c6\u01c8\4"+
		"\62;\2\u01c7\u01c6\3\2\2\2\u01c8\u01cb\3\2\2\2\u01c9\u01c7\3\2\2\2\u01c9"+
		"\u01ca\3\2\2\2\u01ca\u01cd\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cc\u01c4\3\2"+
		"\2\2\u01cc\u01c5\3\2\2\2\u01cd\u0084\3\2\2\2\u01ce\u01cf\7*\2\2\u01cf"+
		"\u01d0\7/\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d5\4\63;\2\u01d2\u01d4\4\62"+
		";\2\u01d3\u01d2\3\2\2\2\u01d4\u01d7\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d5"+
		"\u01d6\3\2\2\2\u01d6\u01d8\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d8\u01d9\7+"+
		"\2\2\u01d9\u0086\3\2\2\2\u01da\u01db\4y|\2\u01db\u0088\3\2\2\2\u01dc\u01dd"+
		"\t\3\2\2\u01dd\u008a\3\2\2\2\u01de\u01e2\7%\2\2\u01df\u01e1\n\4\2\2\u01e0"+
		"\u01df\3\2\2\2\u01e1\u01e4\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e2\u01e3\3\2"+
		"\2\2\u01e3\u008c\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e5\u01e7\t\5\2\2\u01e6"+
		"\u01e5\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e8\u01e9\3\2"+
		"\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01eb\bG\2\2\u01eb\u008e\3\2\2\2\17\2\u015d"+
		"\u0164\u016f\u01a0\u01a5\u01be\u01c0\u01c9\u01cc\u01d5\u01e2\u01e8\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}