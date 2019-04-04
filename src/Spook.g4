grammar Spook;

program: main (NEWLINE | comment | classDecl | functionDecl)*;

// Classes (Optional), Functions (Optional), Shader() {} (Needed)
main: 'Shader() {' (NEWLINE | space | declarations)* '}';

// One or more declarations
declarations: declaration declarations
    | declaration;

// Int/float/vector, comments
declaration: space* (comment | numberDecl | boolDecl);

// Single-line comment
comment: '#' (LETTER | STRING | SPACE | digit)*;

// Class
classDecl: 'class' space variable space '{' (space | NEWLINE | numberDecl | functionDecl)* '}';

// Function
functionDecl: returnType space variable '(' (dataTypeVariable)* ')' space '{' (space | NEWLINE | declaration)* '}';

// Return types
returnType: 'void'
    | dataType;

// Data types
dataType: 'int'
    | 'float'
    | 'boolean'
    | vectorType;

// Vector types
vectorType: 'vector2'
    | 'vector3'
    | 'vector4';

// Variable name
variable: (LETTER | STRING | space | digit)+;

// Integer, float and vector declaration
numberDecl: (integerDecl
    | floatDecl
    | vector2Decl
    | vector3Decl
    | vector4Decl) SEMICOLON;

// Integer and float declarations
integerDecl: dataTypeVariable ASSIGN (digit | variable);
floatDecl: dataTypeVariable ASSIGN (arithOperations | real_number);

// Recursive arithmetic operations
arithOperations: arithOperation arithOperations
    | arithOperation;

// Arithmetic operations
arithOperation: (real_number | math_function | variable) OPERATOR (real_number | math_function | variable | '(' arithOperation ')')
    | OPERATOR (real_number | math_function | variable | '(' arithOperation ')')
    | '(' arithOperation ')'; // Paranteser skal måske ikke håndteres her

// Mathematical functions
math_function: MATH_FUNCTION (variable | real_number | math_function | UNIFORM) arithOperation* ')';

// Boolean declaration
boolDecl: dataTypeVariable ASSIGN (boolOperations | 'true' | 'false') SEMICOLON;

// Recursive boolean operations
boolOperations: boolOperation boolOperations
    | boolOperation;

// Boolean operations
boolOperation: ('true' | 'false' | variable) BOOLOPERATOR ('true' | 'false' | variable | ('(' boolOperation ')'))
    | BOOLOPERATOR ('true' | 'false' | variable | ('(' boolOperation ')'))
    | '(' boolOperation ')';

// Vector declarations
vector2Decl: 'vector2' space variable ASSIGN '('real_number space* ',' space* real_number')';
vector3Decl: 'vector3' space variable ASSIGN '('real_number space* ',' space* real_number space* ',' space* real_number')';
vector4Decl: 'vector4' space variable ASSIGN '('real_number space* ',' space* real_number space* ',' space* real_number space* ',' space* real_number')';

/* Overvej det her. Ulempe: Vi kan ikke sørge for at der er PRÆCIST 2, 3 eller 4 arguments.
Måske vi kan fange den error et andet sted i compileren.
vectorArgs: real_number space* ',' space* vectorArgs
    | real_number;
*/

// Data type and variable - Example: int value
dataTypeVariable: dataType space variable;

// Strings
space: SPACE;

// Numbers
real_number: digit | float_digit;
digit: DIGIT;
float_digit: FLOAT_DIGIT;

// Helpers
LETTER: [A-z];
STRING: LETTER+;
DIGIT: '0'
    | '1'..'9' '0'..'9'*
    | '(-'('1'..'9') ('0'..'9')*')';
FLOAT_DIGIT: DIGIT'.'DIGIT+;

SEMICOLON: ';';
NEWLINE: '\n';
DOUBLE_SLASH: '//';
SPACE: ' ';
ASSIGN: SPACE* '=' SPACE*;

BOOLOPERATOR: SPACE* ('=='
    | '||'
    | '&&'
    | '!='
    | '!') SPACE*;

OPERATOR: SPACE* ('+'
    | '-'
    | '%'
    | '/'
    | '*') SPACE*;
MATH_FUNCTION: 'abs('
    | 'sin('
    | 'cos('
    | 'tan(';
UNIFORM: 'Time';