lexer grammar SpookLexer;

// Data types
INT: 'int';
FLOAT: 'float';
BOOL: 'bool';
VECTOR2: 'vector2';
VECTOR3: 'vector3';
VECTOR4: 'vector4';

// Return types (without data types)
VOID: 'void';

// Pre-defined classes
CIRCLE: 'Circle';
RECTANGLE: 'Rectangle';
TRIANGLE: 'Triangle';
SHAPE: 'Shape';
COLOR: 'Color';

// Keywords
MAIN: 'Shader';
CLASS: 'class';
EXTENDS: 'extends';
IMPLEMENTS: 'implements';
RETURN: 'return';
IF: 'if';
ELSE: 'else';

// Numbers and bool
DIGIT
    : '0'
    | '1'..'9' '0'..'9'*
    | '(-'('1'..'9') ('0'..'9')*')';
FLOAT_DIGIT
    : DIGIT'.'DIGIT+;

BOOL_LITERAL
    : 'true'
    | 'false';

// Separators
LEFT_BRACKET: '{';
RIGHT_BRACKET: '}';
LEFT_PAREN: '(';
RIGHT_PAREN: ')';
DOT: '.';
COMMA: ',';
SEMICOLON: ';';

// Operators
ASSIGN: '=';
ADD: '+';
SUB: '-';
MOD: '%';
DIV: '/';
MUL: '*';
EQUAL: '==';
AND: '&&';
OR: '||';
NOT_EQUAL: '!=';
NOT: '!';

// Mathematical functions
// abs, sin, cos, tan makes conflicts if not ended with a parenthesis
ABS: 'abs(';
SIN: 'sin(';
COS: 'cos(';
TAN: 'tan(';

// Uniforms
UNIFORM: 'Time';

// Identifier
ID: LETTER+;
fragment LETTER: [A-z];

// MISC
COMMENT_STRING: '#' ~( '\r' | '\n' | '\t')*;
WS: [ \t\r\n]+ -> skip;