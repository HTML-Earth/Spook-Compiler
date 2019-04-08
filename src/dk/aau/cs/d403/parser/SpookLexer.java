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
		RECTANGLE=9, TRIANGLE=10, SHAPE=11, COLOR=12, MAIN=13, CLASS=14, EXTENDS=15, 
		IMPLEMENTS=16, RETURN=17, IF=18, ELSE=19, DIGIT=20, FLOAT_DIGIT=21, BOOL_LITERAL=22, 
		LEFT_BRACKET=23, RIGHT_BRACKET=24, LEFT_PAREN=25, RIGHT_PAREN=26, DOT=27, 
		COMMA=28, SEMICOLON=29, ASSIGN=30, ADD=31, SUB=32, MOD=33, DIV=34, MUL=35, 
		EQUAL=36, AND=37, OR=38, NOT_EQUAL=39, NOT=40, ABS=41, SIN=42, COS=43, 
		TAN=44, UNIFORM=45, ID=46, COMMENT_STRING=47, WS=48;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT", "FLOAT", "BOOL", "VECTOR2", "VECTOR3", "VECTOR4", "VOID", "CIRCLE", 
			"RECTANGLE", "TRIANGLE", "SHAPE", "COLOR", "MAIN", "CLASS", "EXTENDS", 
			"IMPLEMENTS", "RETURN", "IF", "ELSE", "DIGIT", "FLOAT_DIGIT", "BOOL_LITERAL", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", "DOT", 
			"COMMA", "SEMICOLON", "ASSIGN", "ADD", "SUB", "MOD", "DIV", "MUL", "EQUAL", 
			"AND", "OR", "NOT_EQUAL", "NOT", "ABS", "SIN", "COS", "TAN", "UNIFORM", 
			"ID", "LETTER", "COMMENT_STRING", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'float'", "'bool'", "'vector2'", "'vector3'", "'vector4'", 
			"'void'", "'Circle'", "'Rectangle'", "'Triangle'", "'Shape'", "'Color'", 
			"'Shader'", "'class'", "'extends'", "'implements'", "'return'", "'if'", 
			"'else'", null, null, null, "'{'", "'}'", "'('", "')'", "'.'", "','", 
			"';'", "'='", "'+'", "'-'", "'%'", "'/'", "'*'", "'=='", "'&&'", "'||'", 
			"'!='", "'!'", "'abs('", "'sin('", "'cos('", "'tan('", "'Time'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "FLOAT", "BOOL", "VECTOR2", "VECTOR3", "VECTOR4", "VOID", 
			"CIRCLE", "RECTANGLE", "TRIANGLE", "SHAPE", "COLOR", "MAIN", "CLASS", 
			"EXTENDS", "IMPLEMENTS", "RETURN", "IF", "ELSE", "DIGIT", "FLOAT_DIGIT", 
			"BOOL_LITERAL", "LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", 
			"DOT", "COMMA", "SEMICOLON", "ASSIGN", "ADD", "SUB", "MOD", "DIV", "MUL", 
			"EQUAL", "AND", "OR", "NOT_EQUAL", "NOT", "ABS", "SIN", "COS", "TAN", 
			"UNIFORM", "ID", "COMMENT_STRING", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\62\u0163\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\7\25\u00ea\n\25\f\25\16\25\u00ed\13\25\3\25\3\25\3\25"+
		"\3\25\3\25\7\25\u00f4\n\25\f\25\16\25\u00f7\13\25\3\25\5\25\u00fa\n\25"+
		"\3\26\3\26\3\26\6\26\u00ff\n\26\r\26\16\26\u0100\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\5\27\u010c\n\27\3\30\3\30\3\31\3\31\3\32\3\32"+
		"\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\""+
		"\3#\3#\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3*\3*\3*\3*"+
		"\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3/\6/"+
		"\u0150\n/\r/\16/\u0151\3\60\3\60\3\61\3\61\7\61\u0158\n\61\f\61\16\61"+
		"\u015b\13\61\3\62\6\62\u015e\n\62\r\62\16\62\u015f\3\62\3\62\2\2\63\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\2a\61c\62\3\2\5\3\2C|\4\2\13\f"+
		"\17\17\5\2\13\f\17\17\"\"\2\u016a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2"+
		"O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3"+
		"\2\2\2\2]\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\3e\3\2\2\2\5i\3\2\2\2\7o\3\2\2"+
		"\2\tt\3\2\2\2\13|\3\2\2\2\r\u0084\3\2\2\2\17\u008c\3\2\2\2\21\u0091\3"+
		"\2\2\2\23\u0098\3\2\2\2\25\u00a2\3\2\2\2\27\u00ab\3\2\2\2\31\u00b1\3\2"+
		"\2\2\33\u00b7\3\2\2\2\35\u00be\3\2\2\2\37\u00c4\3\2\2\2!\u00cc\3\2\2\2"+
		"#\u00d7\3\2\2\2%\u00de\3\2\2\2\'\u00e1\3\2\2\2)\u00f9\3\2\2\2+\u00fb\3"+
		"\2\2\2-\u010b\3\2\2\2/\u010d\3\2\2\2\61\u010f\3\2\2\2\63\u0111\3\2\2\2"+
		"\65\u0113\3\2\2\2\67\u0115\3\2\2\29\u0117\3\2\2\2;\u0119\3\2\2\2=\u011b"+
		"\3\2\2\2?\u011d\3\2\2\2A\u011f\3\2\2\2C\u0121\3\2\2\2E\u0123\3\2\2\2G"+
		"\u0125\3\2\2\2I\u0127\3\2\2\2K\u012a\3\2\2\2M\u012d\3\2\2\2O\u0130\3\2"+
		"\2\2Q\u0133\3\2\2\2S\u0135\3\2\2\2U\u013a\3\2\2\2W\u013f\3\2\2\2Y\u0144"+
		"\3\2\2\2[\u0149\3\2\2\2]\u014f\3\2\2\2_\u0153\3\2\2\2a\u0155\3\2\2\2c"+
		"\u015d\3\2\2\2ef\7k\2\2fg\7p\2\2gh\7v\2\2h\4\3\2\2\2ij\7h\2\2jk\7n\2\2"+
		"kl\7q\2\2lm\7c\2\2mn\7v\2\2n\6\3\2\2\2op\7d\2\2pq\7q\2\2qr\7q\2\2rs\7"+
		"n\2\2s\b\3\2\2\2tu\7x\2\2uv\7g\2\2vw\7e\2\2wx\7v\2\2xy\7q\2\2yz\7t\2\2"+
		"z{\7\64\2\2{\n\3\2\2\2|}\7x\2\2}~\7g\2\2~\177\7e\2\2\177\u0080\7v\2\2"+
		"\u0080\u0081\7q\2\2\u0081\u0082\7t\2\2\u0082\u0083\7\65\2\2\u0083\f\3"+
		"\2\2\2\u0084\u0085\7x\2\2\u0085\u0086\7g\2\2\u0086\u0087\7e\2\2\u0087"+
		"\u0088\7v\2\2\u0088\u0089\7q\2\2\u0089\u008a\7t\2\2\u008a\u008b\7\66\2"+
		"\2\u008b\16\3\2\2\2\u008c\u008d\7x\2\2\u008d\u008e\7q\2\2\u008e\u008f"+
		"\7k\2\2\u008f\u0090\7f\2\2\u0090\20\3\2\2\2\u0091\u0092\7E\2\2\u0092\u0093"+
		"\7k\2\2\u0093\u0094\7t\2\2\u0094\u0095\7e\2\2\u0095\u0096\7n\2\2\u0096"+
		"\u0097\7g\2\2\u0097\22\3\2\2\2\u0098\u0099\7T\2\2\u0099\u009a\7g\2\2\u009a"+
		"\u009b\7e\2\2\u009b\u009c\7v\2\2\u009c\u009d\7c\2\2\u009d\u009e\7p\2\2"+
		"\u009e\u009f\7i\2\2\u009f\u00a0\7n\2\2\u00a0\u00a1\7g\2\2\u00a1\24\3\2"+
		"\2\2\u00a2\u00a3\7V\2\2\u00a3\u00a4\7t\2\2\u00a4\u00a5\7k\2\2\u00a5\u00a6"+
		"\7c\2\2\u00a6\u00a7\7p\2\2\u00a7\u00a8\7i\2\2\u00a8\u00a9\7n\2\2\u00a9"+
		"\u00aa\7g\2\2\u00aa\26\3\2\2\2\u00ab\u00ac\7U\2\2\u00ac\u00ad\7j\2\2\u00ad"+
		"\u00ae\7c\2\2\u00ae\u00af\7r\2\2\u00af\u00b0\7g\2\2\u00b0\30\3\2\2\2\u00b1"+
		"\u00b2\7E\2\2\u00b2\u00b3\7q\2\2\u00b3\u00b4\7n\2\2\u00b4\u00b5\7q\2\2"+
		"\u00b5\u00b6\7t\2\2\u00b6\32\3\2\2\2\u00b7\u00b8\7U\2\2\u00b8\u00b9\7"+
		"j\2\2\u00b9\u00ba\7c\2\2\u00ba\u00bb\7f\2\2\u00bb\u00bc\7g\2\2\u00bc\u00bd"+
		"\7t\2\2\u00bd\34\3\2\2\2\u00be\u00bf\7e\2\2\u00bf\u00c0\7n\2\2\u00c0\u00c1"+
		"\7c\2\2\u00c1\u00c2\7u\2\2\u00c2\u00c3\7u\2\2\u00c3\36\3\2\2\2\u00c4\u00c5"+
		"\7g\2\2\u00c5\u00c6\7z\2\2\u00c6\u00c7\7v\2\2\u00c7\u00c8\7g\2\2\u00c8"+
		"\u00c9\7p\2\2\u00c9\u00ca\7f\2\2\u00ca\u00cb\7u\2\2\u00cb \3\2\2\2\u00cc"+
		"\u00cd\7k\2\2\u00cd\u00ce\7o\2\2\u00ce\u00cf\7r\2\2\u00cf\u00d0\7n\2\2"+
		"\u00d0\u00d1\7g\2\2\u00d1\u00d2\7o\2\2\u00d2\u00d3\7g\2\2\u00d3\u00d4"+
		"\7p\2\2\u00d4\u00d5\7v\2\2\u00d5\u00d6\7u\2\2\u00d6\"\3\2\2\2\u00d7\u00d8"+
		"\7t\2\2\u00d8\u00d9\7g\2\2\u00d9\u00da\7v\2\2\u00da\u00db\7w\2\2\u00db"+
		"\u00dc\7t\2\2\u00dc\u00dd\7p\2\2\u00dd$\3\2\2\2\u00de\u00df\7k\2\2\u00df"+
		"\u00e0\7h\2\2\u00e0&\3\2\2\2\u00e1\u00e2\7g\2\2\u00e2\u00e3\7n\2\2\u00e3"+
		"\u00e4\7u\2\2\u00e4\u00e5\7g\2\2\u00e5(\3\2\2\2\u00e6\u00fa\7\62\2\2\u00e7"+
		"\u00eb\4\63;\2\u00e8\u00ea\4\62;\2\u00e9\u00e8\3\2\2\2\u00ea\u00ed\3\2"+
		"\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00fa\3\2\2\2\u00ed"+
		"\u00eb\3\2\2\2\u00ee\u00ef\7*\2\2\u00ef\u00f0\7/\2\2\u00f0\u00f1\3\2\2"+
		"\2\u00f1\u00f5\4\63;\2\u00f2\u00f4\4\62;\2\u00f3\u00f2\3\2\2\2\u00f4\u00f7"+
		"\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f8\3\2\2\2\u00f7"+
		"\u00f5\3\2\2\2\u00f8\u00fa\7+\2\2\u00f9\u00e6\3\2\2\2\u00f9\u00e7\3\2"+
		"\2\2\u00f9\u00ee\3\2\2\2\u00fa*\3\2\2\2\u00fb\u00fc\5)\25\2\u00fc\u00fe"+
		"\7\60\2\2\u00fd\u00ff\5)\25\2\u00fe\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2"+
		"\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101,\3\2\2\2\u0102\u0103\7"+
		"v\2\2\u0103\u0104\7t\2\2\u0104\u0105\7w\2\2\u0105\u010c\7g\2\2\u0106\u0107"+
		"\7h\2\2\u0107\u0108\7c\2\2\u0108\u0109\7n\2\2\u0109\u010a\7u\2\2\u010a"+
		"\u010c\7g\2\2\u010b\u0102\3\2\2\2\u010b\u0106\3\2\2\2\u010c.\3\2\2\2\u010d"+
		"\u010e\7}\2\2\u010e\60\3\2\2\2\u010f\u0110\7\177\2\2\u0110\62\3\2\2\2"+
		"\u0111\u0112\7*\2\2\u0112\64\3\2\2\2\u0113\u0114\7+\2\2\u0114\66\3\2\2"+
		"\2\u0115\u0116\7\60\2\2\u01168\3\2\2\2\u0117\u0118\7.\2\2\u0118:\3\2\2"+
		"\2\u0119\u011a\7=\2\2\u011a<\3\2\2\2\u011b\u011c\7?\2\2\u011c>\3\2\2\2"+
		"\u011d\u011e\7-\2\2\u011e@\3\2\2\2\u011f\u0120\7/\2\2\u0120B\3\2\2\2\u0121"+
		"\u0122\7\'\2\2\u0122D\3\2\2\2\u0123\u0124\7\61\2\2\u0124F\3\2\2\2\u0125"+
		"\u0126\7,\2\2\u0126H\3\2\2\2\u0127\u0128\7?\2\2\u0128\u0129\7?\2\2\u0129"+
		"J\3\2\2\2\u012a\u012b\7(\2\2\u012b\u012c\7(\2\2\u012cL\3\2\2\2\u012d\u012e"+
		"\7~\2\2\u012e\u012f\7~\2\2\u012fN\3\2\2\2\u0130\u0131\7#\2\2\u0131\u0132"+
		"\7?\2\2\u0132P\3\2\2\2\u0133\u0134\7#\2\2\u0134R\3\2\2\2\u0135\u0136\7"+
		"c\2\2\u0136\u0137\7d\2\2\u0137\u0138\7u\2\2\u0138\u0139\7*\2\2\u0139T"+
		"\3\2\2\2\u013a\u013b\7u\2\2\u013b\u013c\7k\2\2\u013c\u013d\7p\2\2\u013d"+
		"\u013e\7*\2\2\u013eV\3\2\2\2\u013f\u0140\7e\2\2\u0140\u0141\7q\2\2\u0141"+
		"\u0142\7u\2\2\u0142\u0143\7*\2\2\u0143X\3\2\2\2\u0144\u0145\7v\2\2\u0145"+
		"\u0146\7c\2\2\u0146\u0147\7p\2\2\u0147\u0148\7*\2\2\u0148Z\3\2\2\2\u0149"+
		"\u014a\7V\2\2\u014a\u014b\7k\2\2\u014b\u014c\7o\2\2\u014c\u014d\7g\2\2"+
		"\u014d\\\3\2\2\2\u014e\u0150\5_\60\2\u014f\u014e\3\2\2\2\u0150\u0151\3"+
		"\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152^\3\2\2\2\u0153\u0154"+
		"\t\2\2\2\u0154`\3\2\2\2\u0155\u0159\7%\2\2\u0156\u0158\n\3\2\2\u0157\u0156"+
		"\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a"+
		"b\3\2\2\2\u015b\u0159\3\2\2\2\u015c\u015e\t\4\2\2\u015d\u015c\3\2\2\2"+
		"\u015e\u015f\3\2\2\2\u015f\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0161"+
		"\3\2\2\2\u0161\u0162\b\62\2\2\u0162d\3\2\2\2\13\2\u00eb\u00f5\u00f9\u0100"+
		"\u010b\u0151\u0159\u015f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}