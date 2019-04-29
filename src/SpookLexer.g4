lexer grammar SpookLexer;

// Data types
INT: 'Int';
FLOAT: 'Float';
BOOL: 'Bool';
VECTOR2: 'Vec2';
VECTOR3: 'Vec3';
VECTOR4: 'Vec4';

// Return types (without data types)
VOID: 'Void';

// Keywords
MAIN: 'Shader';
CLASS: 'Class';
EXTENDS: 'extends';
IMPLEMENTS: 'implements';
RETURN: 'return';
IF: 'if';
ELSE_IF: 'else if';
ELSE: 'else';
FOR: 'for';
TO: 'to';

// Numbers and bool
DIGIT: DIGIT_RULE;
DIGIT_NEGATIVE: DIGIT_NEGATIVE_RULE;

FLOAT_DIGIT: DIGIT'.'DIGIT+;
FLOAT_DIGIT_NEGATIVE: DIGIT_NEGATIVE'.'DIGIT+;

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
QUESTION: '?';
COLON: ':';

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

/* Swizzle masks */
// Coordinate swizzle mask
COORDINATE_SWIZZLE_MASK
    : COORDINATE_SWIZZLE_MASK_RULE+;

// Color swizzle mask
COLOR_SWIZZLE_MASK
    : COLOR_SWIZZLE_MASK_RULE+;


// Mathematical functions
ABS: 'abs';
SIN: 'sin';
COS: 'cos';
TAN: 'tan';

// Uniforms
UNIFORM: 'Time';

// Identifier - chars and non-negative digits
ID: (LETTER | DIGIT)+;

// Fragment rules
fragment LETTER: [A-z];

fragment DIGIT_RULE
    : '0'
    | '1'..'9' '0'..'9'*;
fragment DIGIT_NEGATIVE_RULE: '(-'('1'..'9') ('0'..'9')*')';

fragment COORDINATE_SWIZZLE_MASK_RULE
    : 'x'
    | 'y'
    | 'z'
    | 'w';
fragment COLOR_SWIZZLE_MASK_RULE
    : 'r'
    | 'g'
    | 'b'
    | 'a';

// MISC
COMMENT_STRING: '#' ~( '\r' | '\n' | '\t')*;
WS: [ \t\r\n]+ -> skip;