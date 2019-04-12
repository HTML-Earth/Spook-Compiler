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
		RECTANGLE=9, TRIANGLE=10, SHAPE=11, COLOR=12, BLACK=13, WHITE=14, RED=15, 
		GREEN=16, BLUE=17, MAIN=18, CLASS=19, EXTENDS=20, IMPLEMENTS=21, RETURN=22, 
		IF=23, ELSE_IF=24, ELSE=25, FOR=26, TO=27, DIGIT=28, DIGIT_NEGATIVE=29, 
		FLOAT_DIGIT=30, FLOAT_DIGIT_NEGATIVE=31, BOOL_LITERAL=32, LEFT_BRACKET=33, 
		RIGHT_BRACKET=34, LEFT_PAREN=35, RIGHT_PAREN=36, DOT=37, COMMA=38, SEMICOLON=39, 
		QUESTION=40, COLON=41, ASSIGN=42, ADD=43, SUB=44, MOD=45, DIV=46, MUL=47, 
		EQUAL=48, AND=49, OR=50, NOT_EQUAL=51, NOT=52, ABS=53, SIN=54, COS=55, 
		TAN=56, UNIFORM=57, ID=58, COMMENT_STRING=59, WS=60;
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
			"ELSE", "FOR", "TO", "DIGIT", "DIGIT_NEGATIVE", "FLOAT_DIGIT", "FLOAT_DIGIT_NEGATIVE", 
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
			"'implements'", "'return'", "'if'", "'else if'", "'else'", "'for'", "'to'", 
			null, null, null, null, null, "'{'", "'}'", "'('", "')'", "'.'", "','", 
			"';'", "'?'", "':'", "'='", "'+'", "'-'", "'%'", "'/'", "'*'", "'=='", 
			"'&&'", "'||'", "'!='", "'!'", "'abs'", "'sin'", "'cos'", "'tan'", "'Time'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "FLOAT", "BOOL", "VECTOR2", "VECTOR3", "VECTOR4", "VOID", 
			"CIRCLE", "RECTANGLE", "TRIANGLE", "SHAPE", "COLOR", "BLACK", "WHITE", 
			"RED", "GREEN", "BLUE", "MAIN", "CLASS", "EXTENDS", "IMPLEMENTS", "RETURN", 
			"IF", "ELSE_IF", "ELSE", "FOR", "TO", "DIGIT", "DIGIT_NEGATIVE", "FLOAT_DIGIT", 
			"FLOAT_DIGIT_NEGATIVE", "BOOL_LITERAL", "LEFT_BRACKET", "RIGHT_BRACKET", 
			"LEFT_PAREN", "RIGHT_PAREN", "DOT", "COMMA", "SEMICOLON", "QUESTION", 
			"COLON", "ASSIGN", "ADD", "SUB", "MOD", "DIV", "MUL", "EQUAL", "AND", 
			"OR", "NOT_EQUAL", "NOT", "ABS", "SIN", "COS", "TAN", "UNIFORM", "ID", 
			"COMMENT_STRING", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2>\u01ad\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\37\3\37\3\37\6\37\u012b\n\37\r\37\16\37\u012c\3 \3 "+
		"\3 \6 \u0132\n \r \16 \u0133\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u013f\n!\3"+
		"\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3"+
		"-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63"+
		"\3\64\3\64\3\64\3\65\3\65\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\38\3"+
		"8\38\38\39\39\39\39\3:\3:\3:\3:\3:\3;\3;\6;\u0184\n;\r;\16;\u0185\3<\3"+
		"<\3=\3=\3=\7=\u018d\n=\f=\16=\u0190\13=\5=\u0192\n=\3>\3>\3>\3>\3>\7>"+
		"\u0199\n>\f>\16>\u019c\13>\3>\3>\3?\3?\7?\u01a2\n?\f?\16?\u01a5\13?\3"+
		"@\6@\u01a8\n@\r@\16@\u01a9\3@\3@\2\2A\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w\2y\2{\2}=\177>\3\2\5\3\2"+
		"C|\4\2\13\f\17\17\5\2\13\f\17\17\"\"\2\u01b3\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2"+
		"\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2"+
		"s\3\2\2\2\2u\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\3\u0081\3\2\2\2\5\u0085"+
		"\3\2\2\2\7\u008b\3\2\2\2\t\u0090\3\2\2\2\13\u0095\3\2\2\2\r\u009a\3\2"+
		"\2\2\17\u009f\3\2\2\2\21\u00a4\3\2\2\2\23\u00ab\3\2\2\2\25\u00b5\3\2\2"+
		"\2\27\u00be\3\2\2\2\31\u00c4\3\2\2\2\33\u00ca\3\2\2\2\35\u00d0\3\2\2\2"+
		"\37\u00d6\3\2\2\2!\u00da\3\2\2\2#\u00e0\3\2\2\2%\u00e5\3\2\2\2\'\u00ec"+
		"\3\2\2\2)\u00f2\3\2\2\2+\u00fa\3\2\2\2-\u0105\3\2\2\2/\u010c\3\2\2\2\61"+
		"\u010f\3\2\2\2\63\u0117\3\2\2\2\65\u011c\3\2\2\2\67\u0120\3\2\2\29\u0123"+
		"\3\2\2\2;\u0125\3\2\2\2=\u0127\3\2\2\2?\u012e\3\2\2\2A\u013e\3\2\2\2C"+
		"\u0140\3\2\2\2E\u0142\3\2\2\2G\u0144\3\2\2\2I\u0146\3\2\2\2K\u0148\3\2"+
		"\2\2M\u014a\3\2\2\2O\u014c\3\2\2\2Q\u014e\3\2\2\2S\u0150\3\2\2\2U\u0152"+
		"\3\2\2\2W\u0154\3\2\2\2Y\u0156\3\2\2\2[\u0158\3\2\2\2]\u015a\3\2\2\2_"+
		"\u015c\3\2\2\2a\u015e\3\2\2\2c\u0161\3\2\2\2e\u0164\3\2\2\2g\u0167\3\2"+
		"\2\2i\u016a\3\2\2\2k\u016c\3\2\2\2m\u0170\3\2\2\2o\u0174\3\2\2\2q\u0178"+
		"\3\2\2\2s\u017c\3\2\2\2u\u0183\3\2\2\2w\u0187\3\2\2\2y\u0191\3\2\2\2{"+
		"\u0193\3\2\2\2}\u019f\3\2\2\2\177\u01a7\3\2\2\2\u0081\u0082\7K\2\2\u0082"+
		"\u0083\7p\2\2\u0083\u0084\7v\2\2\u0084\4\3\2\2\2\u0085\u0086\7H\2\2\u0086"+
		"\u0087\7n\2\2\u0087\u0088\7q\2\2\u0088\u0089\7c\2\2\u0089\u008a\7v\2\2"+
		"\u008a\6\3\2\2\2\u008b\u008c\7D\2\2\u008c\u008d\7q\2\2\u008d\u008e\7q"+
		"\2\2\u008e\u008f\7n\2\2\u008f\b\3\2\2\2\u0090\u0091\7X\2\2\u0091\u0092"+
		"\7g\2\2\u0092\u0093\7e\2\2\u0093\u0094\7\64\2\2\u0094\n\3\2\2\2\u0095"+
		"\u0096\7X\2\2\u0096\u0097\7g\2\2\u0097\u0098\7e\2\2\u0098\u0099\7\65\2"+
		"\2\u0099\f\3\2\2\2\u009a\u009b\7X\2\2\u009b\u009c\7g\2\2\u009c\u009d\7"+
		"e\2\2\u009d\u009e\7\66\2\2\u009e\16\3\2\2\2\u009f\u00a0\7x\2\2\u00a0\u00a1"+
		"\7q\2\2\u00a1\u00a2\7k\2\2\u00a2\u00a3\7f\2\2\u00a3\20\3\2\2\2\u00a4\u00a5"+
		"\7E\2\2\u00a5\u00a6\7k\2\2\u00a6\u00a7\7t\2\2\u00a7\u00a8\7e\2\2\u00a8"+
		"\u00a9\7n\2\2\u00a9\u00aa\7g\2\2\u00aa\22\3\2\2\2\u00ab\u00ac\7T\2\2\u00ac"+
		"\u00ad\7g\2\2\u00ad\u00ae\7e\2\2\u00ae\u00af\7v\2\2\u00af\u00b0\7c\2\2"+
		"\u00b0\u00b1\7p\2\2\u00b1\u00b2\7i\2\2\u00b2\u00b3\7n\2\2\u00b3\u00b4"+
		"\7g\2\2\u00b4\24\3\2\2\2\u00b5\u00b6\7V\2\2\u00b6\u00b7\7t\2\2\u00b7\u00b8"+
		"\7k\2\2\u00b8\u00b9\7c\2\2\u00b9\u00ba\7p\2\2\u00ba\u00bb\7i\2\2\u00bb"+
		"\u00bc\7n\2\2\u00bc\u00bd\7g\2\2\u00bd\26\3\2\2\2\u00be\u00bf\7U\2\2\u00bf"+
		"\u00c0\7j\2\2\u00c0\u00c1\7c\2\2\u00c1\u00c2\7r\2\2\u00c2\u00c3\7g\2\2"+
		"\u00c3\30\3\2\2\2\u00c4\u00c5\7E\2\2\u00c5\u00c6\7q\2\2\u00c6\u00c7\7"+
		"n\2\2\u00c7\u00c8\7q\2\2\u00c8\u00c9\7t\2\2\u00c9\32\3\2\2\2\u00ca\u00cb"+
		"\7D\2\2\u00cb\u00cc\7n\2\2\u00cc\u00cd\7c\2\2\u00cd\u00ce\7e\2\2\u00ce"+
		"\u00cf\7m\2\2\u00cf\34\3\2\2\2\u00d0\u00d1\7Y\2\2\u00d1\u00d2\7j\2\2\u00d2"+
		"\u00d3\7k\2\2\u00d3\u00d4\7v\2\2\u00d4\u00d5\7g\2\2\u00d5\36\3\2\2\2\u00d6"+
		"\u00d7\7T\2\2\u00d7\u00d8\7g\2\2\u00d8\u00d9\7f\2\2\u00d9 \3\2\2\2\u00da"+
		"\u00db\7I\2\2\u00db\u00dc\7t\2\2\u00dc\u00dd\7g\2\2\u00dd\u00de\7g\2\2"+
		"\u00de\u00df\7p\2\2\u00df\"\3\2\2\2\u00e0\u00e1\7D\2\2\u00e1\u00e2\7n"+
		"\2\2\u00e2\u00e3\7w\2\2\u00e3\u00e4\7g\2\2\u00e4$\3\2\2\2\u00e5\u00e6"+
		"\7U\2\2\u00e6\u00e7\7j\2\2\u00e7\u00e8\7c\2\2\u00e8\u00e9\7f\2\2\u00e9"+
		"\u00ea\7g\2\2\u00ea\u00eb\7t\2\2\u00eb&\3\2\2\2\u00ec\u00ed\7e\2\2\u00ed"+
		"\u00ee\7n\2\2\u00ee\u00ef\7c\2\2\u00ef\u00f0\7u\2\2\u00f0\u00f1\7u\2\2"+
		"\u00f1(\3\2\2\2\u00f2\u00f3\7g\2\2\u00f3\u00f4\7z\2\2\u00f4\u00f5\7v\2"+
		"\2\u00f5\u00f6\7g\2\2\u00f6\u00f7\7p\2\2\u00f7\u00f8\7f\2\2\u00f8\u00f9"+
		"\7u\2\2\u00f9*\3\2\2\2\u00fa\u00fb\7k\2\2\u00fb\u00fc\7o\2\2\u00fc\u00fd"+
		"\7r\2\2\u00fd\u00fe\7n\2\2\u00fe\u00ff\7g\2\2\u00ff\u0100\7o\2\2\u0100"+
		"\u0101\7g\2\2\u0101\u0102\7p\2\2\u0102\u0103\7v\2\2\u0103\u0104\7u\2\2"+
		"\u0104,\3\2\2\2\u0105\u0106\7t\2\2\u0106\u0107\7g\2\2\u0107\u0108\7v\2"+
		"\2\u0108\u0109\7w\2\2\u0109\u010a\7t\2\2\u010a\u010b\7p\2\2\u010b.\3\2"+
		"\2\2\u010c\u010d\7k\2\2\u010d\u010e\7h\2\2\u010e\60\3\2\2\2\u010f\u0110"+
		"\7g\2\2\u0110\u0111\7n\2\2\u0111\u0112\7u\2\2\u0112\u0113\7g\2\2\u0113"+
		"\u0114\7\"\2\2\u0114\u0115\7k\2\2\u0115\u0116\7h\2\2\u0116\62\3\2\2\2"+
		"\u0117\u0118\7g\2\2\u0118\u0119\7n\2\2\u0119\u011a\7u\2\2\u011a\u011b"+
		"\7g\2\2\u011b\64\3\2\2\2\u011c\u011d\7h\2\2\u011d\u011e\7q\2\2\u011e\u011f"+
		"\7t\2\2\u011f\66\3\2\2\2\u0120\u0121\7v\2\2\u0121\u0122\7q\2\2\u01228"+
		"\3\2\2\2\u0123\u0124\5y=\2\u0124:\3\2\2\2\u0125\u0126\5{>\2\u0126<\3\2"+
		"\2\2\u0127\u0128\59\35\2\u0128\u012a\7\60\2\2\u0129\u012b\59\35\2\u012a"+
		"\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2"+
		"\2\2\u012d>\3\2\2\2\u012e\u012f\5;\36\2\u012f\u0131\7\60\2\2\u0130\u0132"+
		"\59\35\2\u0131\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0131\3\2\2\2\u0133"+
		"\u0134\3\2\2\2\u0134@\3\2\2\2\u0135\u0136\7v\2\2\u0136\u0137\7t\2\2\u0137"+
		"\u0138\7w\2\2\u0138\u013f\7g\2\2\u0139\u013a\7h\2\2\u013a\u013b\7c\2\2"+
		"\u013b\u013c\7n\2\2\u013c\u013d\7u\2\2\u013d\u013f\7g\2\2\u013e\u0135"+
		"\3\2\2\2\u013e\u0139\3\2\2\2\u013fB\3\2\2\2\u0140\u0141\7}\2\2\u0141D"+
		"\3\2\2\2\u0142\u0143\7\177\2\2\u0143F\3\2\2\2\u0144\u0145\7*\2\2\u0145"+
		"H\3\2\2\2\u0146\u0147\7+\2\2\u0147J\3\2\2\2\u0148\u0149\7\60\2\2\u0149"+
		"L\3\2\2\2\u014a\u014b\7.\2\2\u014bN\3\2\2\2\u014c\u014d\7=\2\2\u014dP"+
		"\3\2\2\2\u014e\u014f\7A\2\2\u014fR\3\2\2\2\u0150\u0151\7<\2\2\u0151T\3"+
		"\2\2\2\u0152\u0153\7?\2\2\u0153V\3\2\2\2\u0154\u0155\7-\2\2\u0155X\3\2"+
		"\2\2\u0156\u0157\7/\2\2\u0157Z\3\2\2\2\u0158\u0159\7\'\2\2\u0159\\\3\2"+
		"\2\2\u015a\u015b\7\61\2\2\u015b^\3\2\2\2\u015c\u015d\7,\2\2\u015d`\3\2"+
		"\2\2\u015e\u015f\7?\2\2\u015f\u0160\7?\2\2\u0160b\3\2\2\2\u0161\u0162"+
		"\7(\2\2\u0162\u0163\7(\2\2\u0163d\3\2\2\2\u0164\u0165\7~\2\2\u0165\u0166"+
		"\7~\2\2\u0166f\3\2\2\2\u0167\u0168\7#\2\2\u0168\u0169\7?\2\2\u0169h\3"+
		"\2\2\2\u016a\u016b\7#\2\2\u016bj\3\2\2\2\u016c\u016d\7c\2\2\u016d\u016e"+
		"\7d\2\2\u016e\u016f\7u\2\2\u016fl\3\2\2\2\u0170\u0171\7u\2\2\u0171\u0172"+
		"\7k\2\2\u0172\u0173\7p\2\2\u0173n\3\2\2\2\u0174\u0175\7e\2\2\u0175\u0176"+
		"\7q\2\2\u0176\u0177\7u\2\2\u0177p\3\2\2\2\u0178\u0179\7v\2\2\u0179\u017a"+
		"\7c\2\2\u017a\u017b\7p\2\2\u017br\3\2\2\2\u017c\u017d\7V\2\2\u017d\u017e"+
		"\7k\2\2\u017e\u017f\7o\2\2\u017f\u0180\7g\2\2\u0180t\3\2\2\2\u0181\u0184"+
		"\5w<\2\u0182\u0184\59\35\2\u0183\u0181\3\2\2\2\u0183\u0182\3\2\2\2\u0184"+
		"\u0185\3\2\2\2\u0185\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186v\3\2\2\2"+
		"\u0187\u0188\t\2\2\2\u0188x\3\2\2\2\u0189\u0192\7\62\2\2\u018a\u018e\4"+
		"\63;\2\u018b\u018d\4\62;\2\u018c\u018b\3\2\2\2\u018d\u0190\3\2\2\2\u018e"+
		"\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0192\3\2\2\2\u0190\u018e\3\2"+
		"\2\2\u0191\u0189\3\2\2\2\u0191\u018a\3\2\2\2\u0192z\3\2\2\2\u0193\u0194"+
		"\7*\2\2\u0194\u0195\7/\2\2\u0195\u0196\3\2\2\2\u0196\u019a\4\63;\2\u0197"+
		"\u0199\4\62;\2\u0198\u0197\3\2\2\2\u0199\u019c\3\2\2\2\u019a\u0198\3\2"+
		"\2\2\u019a\u019b\3\2\2\2\u019b\u019d\3\2\2\2\u019c\u019a\3\2\2\2\u019d"+
		"\u019e\7+\2\2\u019e|\3\2\2\2\u019f\u01a3\7%\2\2\u01a0\u01a2\n\3\2\2\u01a1"+
		"\u01a0\3\2\2\2\u01a2\u01a5\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a4\3\2"+
		"\2\2\u01a4~\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a6\u01a8\t\4\2\2\u01a7\u01a6"+
		"\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa"+
		"\u01ab\3\2\2\2\u01ab\u01ac\b@\2\2\u01ac\u0080\3\2\2\2\r\2\u012c\u0133"+
		"\u013e\u0183\u0185\u018e\u0191\u019a\u01a3\u01a9\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}