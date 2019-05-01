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
		NUM=1, BOOL=2, VECTOR2=3, VECTOR3=4, VECTOR4=5, VOID=6, MAIN=7, CLASS=8, 
		EXTENDS=9, IMPLEMENTS=10, RETURN=11, IF=12, ELSE_IF=13, ELSE=14, FOR=15, 
		TO=16, DIGIT=17, DIGIT_NEGATIVE=18, FLOAT_DIGIT=19, FLOAT_DIGIT_NEGATIVE=20, 
		BOOL_LITERAL=21, LEFT_BRACKET=22, RIGHT_BRACKET=23, LEFT_PAREN=24, RIGHT_PAREN=25, 
		DOT=26, COMMA=27, SEMICOLON=28, QUESTION=29, COLON=30, ASSIGN=31, ADD=32, 
		SUB=33, MOD=34, DIV=35, MUL=36, EQUAL=37, AND=38, OR=39, NOT_EQUAL=40, 
		NOT=41, GREATER_THAN=42, GREATER_OR_EQUAL=43, LESS_THAN=44, LESS_OR_EQUAL=45, 
		COORDINATE_SWIZZLE_MASK=46, COLOR_SWIZZLE_MASK=47, ID=48, COMMENT_STRING=49, 
		WS=50;
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
			"GREATER_OR_EQUAL", "LESS_THAN", "LESS_OR_EQUAL", "COORDINATE_SWIZZLE_MASK", 
			"COLOR_SWIZZLE_MASK", "ID", "LETTER", "DIGIT_RULE", "DIGIT_NEGATIVE_RULE", 
			"COORDINATE_SWIZZLE_MASK_RULE", "COLOR_SWIZZLE_MASK_RULE", "COMMENT_STRING", 
			"WS"
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
			"GREATER_OR_EQUAL", "LESS_THAN", "LESS_OR_EQUAL", "COORDINATE_SWIZZLE_MASK", 
			"COLOR_SWIZZLE_MASK", "ID", "COMMENT_STRING", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\64\u0159\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\6\24\u00d4\n\24"+
		"\r\24\16\24\u00d5\3\25\3\25\3\25\6\25\u00db\n\25\r\25\16\25\u00dc\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00e8\n\26\3\27\3\27\3\30"+
		"\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37"+
		"\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3"+
		"(\3(\3)\3)\3)\3*\3*\3+\3+\3,\3,\3,\3-\3-\3.\3.\3.\3/\6/\u0121\n/\r/\16"+
		"/\u0122\3\60\6\60\u0126\n\60\r\60\16\60\u0127\3\61\3\61\6\61\u012c\n\61"+
		"\r\61\16\61\u012d\3\62\3\62\3\63\3\63\3\63\7\63\u0135\n\63\f\63\16\63"+
		"\u0138\13\63\5\63\u013a\n\63\3\64\3\64\3\64\3\64\3\64\7\64\u0141\n\64"+
		"\f\64\16\64\u0144\13\64\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\7\67\u014e"+
		"\n\67\f\67\16\67\u0151\13\67\38\68\u0154\n8\r8\168\u0155\38\38\2\29\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\2e\2g\2i\2k\2m\63o\64\3"+
		"\2\6\3\2C|\5\2cdiitt\4\2\13\f\17\17\5\2\13\f\17\17\"\"\2\u015f\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3"+
		"\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2"+
		"\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2"+
		"m\3\2\2\2\2o\3\2\2\2\3q\3\2\2\2\5u\3\2\2\2\7z\3\2\2\2\t\177\3\2\2\2\13"+
		"\u0084\3\2\2\2\r\u0089\3\2\2\2\17\u008e\3\2\2\2\21\u0095\3\2\2\2\23\u009b"+
		"\3\2\2\2\25\u00a3\3\2\2\2\27\u00ae\3\2\2\2\31\u00b5\3\2\2\2\33\u00b8\3"+
		"\2\2\2\35\u00c0\3\2\2\2\37\u00c5\3\2\2\2!\u00c9\3\2\2\2#\u00cc\3\2\2\2"+
		"%\u00ce\3\2\2\2\'\u00d0\3\2\2\2)\u00d7\3\2\2\2+\u00e7\3\2\2\2-\u00e9\3"+
		"\2\2\2/\u00eb\3\2\2\2\61\u00ed\3\2\2\2\63\u00ef\3\2\2\2\65\u00f1\3\2\2"+
		"\2\67\u00f3\3\2\2\29\u00f5\3\2\2\2;\u00f7\3\2\2\2=\u00f9\3\2\2\2?\u00fb"+
		"\3\2\2\2A\u00fd\3\2\2\2C\u00ff\3\2\2\2E\u0101\3\2\2\2G\u0103\3\2\2\2I"+
		"\u0105\3\2\2\2K\u0107\3\2\2\2M\u010a\3\2\2\2O\u010d\3\2\2\2Q\u0110\3\2"+
		"\2\2S\u0113\3\2\2\2U\u0115\3\2\2\2W\u0117\3\2\2\2Y\u011a\3\2\2\2[\u011c"+
		"\3\2\2\2]\u0120\3\2\2\2_\u0125\3\2\2\2a\u012b\3\2\2\2c\u012f\3\2\2\2e"+
		"\u0139\3\2\2\2g\u013b\3\2\2\2i\u0147\3\2\2\2k\u0149\3\2\2\2m\u014b\3\2"+
		"\2\2o\u0153\3\2\2\2qr\7P\2\2rs\7w\2\2st\7o\2\2t\4\3\2\2\2uv\7D\2\2vw\7"+
		"q\2\2wx\7q\2\2xy\7n\2\2y\6\3\2\2\2z{\7X\2\2{|\7g\2\2|}\7e\2\2}~\7\64\2"+
		"\2~\b\3\2\2\2\177\u0080\7X\2\2\u0080\u0081\7g\2\2\u0081\u0082\7e\2\2\u0082"+
		"\u0083\7\65\2\2\u0083\n\3\2\2\2\u0084\u0085\7X\2\2\u0085\u0086\7g\2\2"+
		"\u0086\u0087\7e\2\2\u0087\u0088\7\66\2\2\u0088\f\3\2\2\2\u0089\u008a\7"+
		"X\2\2\u008a\u008b\7q\2\2\u008b\u008c\7k\2\2\u008c\u008d\7f\2\2\u008d\16"+
		"\3\2\2\2\u008e\u008f\7U\2\2\u008f\u0090\7j\2\2\u0090\u0091\7c\2\2\u0091"+
		"\u0092\7f\2\2\u0092\u0093\7g\2\2\u0093\u0094\7t\2\2\u0094\20\3\2\2\2\u0095"+
		"\u0096\7E\2\2\u0096\u0097\7n\2\2\u0097\u0098\7c\2\2\u0098\u0099\7u\2\2"+
		"\u0099\u009a\7u\2\2\u009a\22\3\2\2\2\u009b\u009c\7g\2\2\u009c\u009d\7"+
		"z\2\2\u009d\u009e\7v\2\2\u009e\u009f\7g\2\2\u009f\u00a0\7p\2\2\u00a0\u00a1"+
		"\7f\2\2\u00a1\u00a2\7u\2\2\u00a2\24\3\2\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5"+
		"\7o\2\2\u00a5\u00a6\7r\2\2\u00a6\u00a7\7n\2\2\u00a7\u00a8\7g\2\2\u00a8"+
		"\u00a9\7o\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7p\2\2\u00ab\u00ac\7v\2\2"+
		"\u00ac\u00ad\7u\2\2\u00ad\26\3\2\2\2\u00ae\u00af\7t\2\2\u00af\u00b0\7"+
		"g\2\2\u00b0\u00b1\7v\2\2\u00b1\u00b2\7w\2\2\u00b2\u00b3\7t\2\2\u00b3\u00b4"+
		"\7p\2\2\u00b4\30\3\2\2\2\u00b5\u00b6\7k\2\2\u00b6\u00b7\7h\2\2\u00b7\32"+
		"\3\2\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba\7n\2\2\u00ba\u00bb\7u\2\2\u00bb"+
		"\u00bc\7g\2\2\u00bc\u00bd\7\"\2\2\u00bd\u00be\7k\2\2\u00be\u00bf\7h\2"+
		"\2\u00bf\34\3\2\2\2\u00c0\u00c1\7g\2\2\u00c1\u00c2\7n\2\2\u00c2\u00c3"+
		"\7u\2\2\u00c3\u00c4\7g\2\2\u00c4\36\3\2\2\2\u00c5\u00c6\7h\2\2\u00c6\u00c7"+
		"\7q\2\2\u00c7\u00c8\7t\2\2\u00c8 \3\2\2\2\u00c9\u00ca\7v\2\2\u00ca\u00cb"+
		"\7q\2\2\u00cb\"\3\2\2\2\u00cc\u00cd\5e\63\2\u00cd$\3\2\2\2\u00ce\u00cf"+
		"\5g\64\2\u00cf&\3\2\2\2\u00d0\u00d1\5#\22\2\u00d1\u00d3\7\60\2\2\u00d2"+
		"\u00d4\5#\22\2\u00d3\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d3\3\2"+
		"\2\2\u00d5\u00d6\3\2\2\2\u00d6(\3\2\2\2\u00d7\u00d8\5%\23\2\u00d8\u00da"+
		"\7\60\2\2\u00d9\u00db\5#\22\2\u00da\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2"+
		"\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd*\3\2\2\2\u00de\u00df\7"+
		"v\2\2\u00df\u00e0\7t\2\2\u00e0\u00e1\7w\2\2\u00e1\u00e8\7g\2\2\u00e2\u00e3"+
		"\7h\2\2\u00e3\u00e4\7c\2\2\u00e4\u00e5\7n\2\2\u00e5\u00e6\7u\2\2\u00e6"+
		"\u00e8\7g\2\2\u00e7\u00de\3\2\2\2\u00e7\u00e2\3\2\2\2\u00e8,\3\2\2\2\u00e9"+
		"\u00ea\7}\2\2\u00ea.\3\2\2\2\u00eb\u00ec\7\177\2\2\u00ec\60\3\2\2\2\u00ed"+
		"\u00ee\7*\2\2\u00ee\62\3\2\2\2\u00ef\u00f0\7+\2\2\u00f0\64\3\2\2\2\u00f1"+
		"\u00f2\7\60\2\2\u00f2\66\3\2\2\2\u00f3\u00f4\7.\2\2\u00f48\3\2\2\2\u00f5"+
		"\u00f6\7=\2\2\u00f6:\3\2\2\2\u00f7\u00f8\7A\2\2\u00f8<\3\2\2\2\u00f9\u00fa"+
		"\7<\2\2\u00fa>\3\2\2\2\u00fb\u00fc\7?\2\2\u00fc@\3\2\2\2\u00fd\u00fe\7"+
		"-\2\2\u00feB\3\2\2\2\u00ff\u0100\7/\2\2\u0100D\3\2\2\2\u0101\u0102\7\'"+
		"\2\2\u0102F\3\2\2\2\u0103\u0104\7\61\2\2\u0104H\3\2\2\2\u0105\u0106\7"+
		",\2\2\u0106J\3\2\2\2\u0107\u0108\7?\2\2\u0108\u0109\7?\2\2\u0109L\3\2"+
		"\2\2\u010a\u010b\7(\2\2\u010b\u010c\7(\2\2\u010cN\3\2\2\2\u010d\u010e"+
		"\7~\2\2\u010e\u010f\7~\2\2\u010fP\3\2\2\2\u0110\u0111\7#\2\2\u0111\u0112"+
		"\7?\2\2\u0112R\3\2\2\2\u0113\u0114\7#\2\2\u0114T\3\2\2\2\u0115\u0116\7"+
		"@\2\2\u0116V\3\2\2\2\u0117\u0118\7@\2\2\u0118\u0119\7?\2\2\u0119X\3\2"+
		"\2\2\u011a\u011b\7>\2\2\u011bZ\3\2\2\2\u011c\u011d\7>\2\2\u011d\u011e"+
		"\7?\2\2\u011e\\\3\2\2\2\u011f\u0121\5i\65\2\u0120\u011f\3\2\2\2\u0121"+
		"\u0122\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123^\3\2\2\2"+
		"\u0124\u0126\5k\66\2\u0125\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0125"+
		"\3\2\2\2\u0127\u0128\3\2\2\2\u0128`\3\2\2\2\u0129\u012c\5c\62\2\u012a"+
		"\u012c\5#\22\2\u012b\u0129\3\2\2\2\u012b\u012a\3\2\2\2\u012c\u012d\3\2"+
		"\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012eb\3\2\2\2\u012f\u0130"+
		"\t\2\2\2\u0130d\3\2\2\2\u0131\u013a\7\62\2\2\u0132\u0136\4\63;\2\u0133"+
		"\u0135\4\62;\2\u0134\u0133\3\2\2\2\u0135\u0138\3\2\2\2\u0136\u0134\3\2"+
		"\2\2\u0136\u0137\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0139"+
		"\u0131\3\2\2\2\u0139\u0132\3\2\2\2\u013af\3\2\2\2\u013b\u013c\7*\2\2\u013c"+
		"\u013d\7/\2\2\u013d\u013e\3\2\2\2\u013e\u0142\4\63;\2\u013f\u0141\4\62"+
		";\2\u0140\u013f\3\2\2\2\u0141\u0144\3\2\2\2\u0142\u0140\3\2\2\2\u0142"+
		"\u0143\3\2\2\2\u0143\u0145\3\2\2\2\u0144\u0142\3\2\2\2\u0145\u0146\7+"+
		"\2\2\u0146h\3\2\2\2\u0147\u0148\4y|\2\u0148j\3\2\2\2\u0149\u014a\t\3\2"+
		"\2\u014al\3\2\2\2\u014b\u014f\7%\2\2\u014c\u014e\n\4\2\2\u014d\u014c\3"+
		"\2\2\2\u014e\u0151\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150"+
		"n\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u0154\t\5\2\2\u0153\u0152\3\2\2\2"+
		"\u0154\u0155\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0157"+
		"\3\2\2\2\u0157\u0158\b8\2\2\u0158p\3\2\2\2\17\2\u00d5\u00dc\u00e7\u0122"+
		"\u0127\u012b\u012d\u0136\u0139\u0142\u014f\u0155\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}