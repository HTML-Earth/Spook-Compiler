grammar Spook;

program: main (NEWLINE | comment | classDecl | functionDecl)*;

// Classes (Optional), Functions (Optional), Shader() {} (Needed)
main: 'Shader() {' (NEWLINE | space | declarations)* '}';

// One or more declarations
declarations: declaration declarations
    | declaration;

// Int/float/vector, comments
declaration: space* (comment | numberDecl);

// Single-line comment
comment: '#' (LETTER | STRING | SPACE | digit)*;

// Class
classDecl: 'class' space variable space '{' (space | NEWLINE | numberDecl | functionDecl)* '}';

// Function
functionDecl: returnType space variable '(' (dataTypeVariable)* ')' space '{' (space | NEWLINE | declaration)* '}';

// Return types
returnType: 'void'
    | 'int'
    | 'float'
    | 'vector2'
    | 'vector3'
    | 'vector4';

// Data types
dataType: 'int'
    | 'float'
    | vectorType;

// Vector types
vectorType: 'vector2'
    | 'vector3'
    | 'vector4';

// Variable name
variable: (LETTER | STRING | space | digit)*;

// Integer, float and vector declaration
numberDecl: (integerDecl
    | floatDecl
    | vector2Decl
    | vector3Decl
    | vector4Decl) SEMICOLON;

// Integer and float declarations
integerDecl: dataTypeVariable ASSIGN (digit | variable);
floatDecl: dataTypeVariable ASSIGN ('(' arithExpression ')' | arithExpression) arithOperation*;

// Vector declarations
vector2Decl: dataTypeVariable ASSIGN '('real_number space* ',' space* real_number')';
vector3Decl: dataTypeVariable ASSIGN '('real_number space* ',' space* real_number space* ',' space* real_number')';
vector4Decl: dataTypeVariable ASSIGN '('real_number space* ',' space* real_number space* ',' space* real_number space* ',' space* real_number')';

// Data type and variable - Example: int value
dataTypeVariable: dataType space variable;

// Arithmetic operations
arithOperation: OPERATOR variable
    | OPERATOR real_number
    | OPERATOR math_function
    | OPERATOR '(' arithExpression ')';

// Arithmetic Expression
arithExpression: (real_number | math_function | variable) arithOperation*;
math_function: MATH_FUNCTION (variable | real_number | math_function | UNIFORM) arithOperation* ')';

// Strings
reserved_word: UNIFORM;
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