grammar Spook;
main: 'shader() {' NEWLINE* declarations* '}';

// One or more declarations
declarations: declaration declarations
    | declaration;
// Int/floats, comments
declaration: (numberDecl | comment) NEWLINE*;
// Comments - multiline comment?
comment: SPACE* '//'(' ' | LETTER | DIGIT)*;
// Variable
variable: LETTER (LETTER | DIGIT | reserved_word)*;
// Integers and floats
numberDecl: SPACE* (integerDecl | floatDecl | vector2Decl | vector3Decl | vector4Decl) SEMICOLON SPACE*;

integerDecl: 'int ' variable ASSIGN (DIGIT | variable);
floatDecl: 'float ' variable ASSIGN (real_number | math_function | variable) arith*;

vector2Decl: 'vector2 ' variable ASSIGN '('real_number SPACE* ',' SPACE* real_number')';
vector3Decl: 'vector3 ' variable ASSIGN '('real_number SPACE* ',' SPACE* real_number SPACE* ',' SPACE* real_number')';
vector4Decl: 'vector4 ' variable ASSIGN '('real_number SPACE* ',' SPACE* real_number SPACE* ',' SPACE* real_number SPACE* ',' SPACE* real_number')';

arith: OPERATOR variable
    | OPERATOR real_number
    | OPERATOR math_function;
math_function: MATH_FUNCTION (variable | real_number | math_function | UNIFORM) arith* ')';

real_number: DIGIT | FLOAT_DIGIT;
reserved_word: UNIFORM;

// Helpers
LETTER: 'A'..'z';
DIGIT: '0'
    | '1'..'9' '0'..'9'*
    | '(-'('1'..'9') ('0'..'9')*')';
FLOAT_DIGIT: DIGIT'.'DIGIT;
SEMICOLON: ';';
NEWLINE: '\n';
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