grammar Spook;

program: main (NEWLINE | comment | classDecl | functionDecl)*;

// Classes (Optional), Functions (Optional), Shader() {} (Needed)
main: 'Shader {' (NEWLINE | space | declarations | comment)* '}';

// One or more declarations
declarations: declaration declarations
    | declaration;

// Int/float/vector, comments
declaration: space* (numberDecl | boolDecl | objectDecl | objectFunctionCall);

// Single-line comment
comment: COMMENT_STRING;

// Class
classDecl: 'class' space variable space '{' (space | NEWLINE | numberDecl | functionDecl)* '}';

// Object
objectDecl: classType variable ASSIGN '(' objectArgs ')';
objectArgs: objectArg objectArgs
    | objectArg;
objectArg: (variable | real_number | arithOperation) ','
    | (variable | real_number | arithOperation);

// Object function calls
objectFunctionCall: (objectVariable'.'functionName ASSIGN '(' objectArgs ')'
    | objectVariable'.'functionName '(' objectArgs ')');

// Function
functionDecl: returnType space variable '(' (dataTypeVariable)* ')' space '{' (space | NEWLINE | declaration)* '}';

// Return types
returnType: 'void'
    | dataType;

// Data types
dataType: 'int'
    | 'float'
    | 'bool'
    | vectorType;

// Vector types
vectorType: 'vector2'
    | 'vector3'
    | 'vector4';

classType
    : 'Circle'
    | 'Rectangle'
    | 'Triangle'
    | 'Shape'
    | 'Color';

// Variable name
variable: (LETTER | STRING | space | digit)+;
objectVariable: variable;
functionName: variable;

// Integer, float and vector declaration
numberDecl: (integerDecl
    | floatDecl
    | vector2Decl
    | vector3Decl
    | vector4Decl) SEMICOLON;

// Integer and float declarations
integerDecl: dataTypeVariable ASSIGN (arithOperations | digit);
floatDecl: dataTypeVariable ASSIGN (arithOperations | math_function | real_number);

// Recursive arithmetic operations
arithOperations: arithOperation arithOperations
    | arithOperation;

// Arithmetic operations
arithOperation: (real_number | math_function | variable) OPERATOR (real_number | math_function | variable | '(' arithOperation ')')
    | OPERATOR (real_number | math_function | variable | '(' arithOperation ')')
    | '(' arithOperations ')'; // Paranteser skal måske ikke håndteres her

// Mathematical functions
math_function: MATH_FUNCTION (variable | real_number | math_function | UNIFORM) arithOperation* ')';

// Boolean declaration
boolDecl: dataTypeVariable ASSIGN (boolOperations | boolean) SEMICOLON;

// Recursive boolean operations
boolOperations: boolOperation boolOperations
    | boolOperation;

// Boolean operations
boolOperation: (boolean | variable) BOOLOPERATOR (boolean | variable | ('(' boolOperation ')'))
    | BOOLOPERATOR (boolean | variable | ('(' boolOperation ')'))
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
boolean: 'true' | 'false';

// Helpers
LETTER: [A-z];
STRING: LETTER+;
DIGIT: '0'
    | '1'..'9' '0'..'9'*
    | '(-'('1'..'9') ('0'..'9')*')';
FLOAT_DIGIT: DIGIT'.'DIGIT+;

SEMICOLON: ';';
NEWLINE: '\n' | '\r' | '\t';
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

COMMENT_STRING: '#' ~( '\r' | '\n' | '\t')*;