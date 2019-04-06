lexer grammar SpookLexer;

MAIN: 'Shader';
CLASS: 'class';

// Data types
INT: 'int';
FLOAT: 'float';
BOOL: 'bool';
VECTOR2: 'vector2';
VECTOR3: 'vector3';
VECTOR4: 'vector4';

CIRCLE: 'Circle';
RECTANGLE: 'Rectangle';
TRIANGLE: 'Triangle';
SHAPE: 'Shape';
COLOR: 'Color';

VOID: 'void';

ID: [A-z]+;

DIGIT: '0'
    | '1'..'9' '0'..'9'*
    | '(-'('1'..'9') ('0'..'9')*')';
FLOAT_DIGIT: DIGIT'.'DIGIT+;

TRUE: 'true';
FALSE: 'false';

SEMICOLON: ';';
DOUBLE_SLASH: '//';
ASSIGN: '=';

LEFT_BRACKET: '{';
RIGHT_BRACKET: '}';

LEFT_PAREN: '(';
RIGHT_PAREN: ')';

DOT: '.';
COMMA: ',';

BOOL_OPERATOR: ('=='
    | '||'
    | '&&'
    | '!='
    | '!');

OPERATOR: ('+'
    | '-'
    | '%'
    | '/'
    | '*');
MATH_FUNCTION: 'abs('
    | 'sin('
    | 'cos('
    | 'tan(';
UNIFORM: 'Time';

COMMENT_STRING: '#' ~( '\r' | '\n' | '\t')*;
WS: [ \t\r\n]+ -> skip;