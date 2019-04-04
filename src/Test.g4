grammar Test;
main: 'shader() {' NEWLINE* (declarations) '}';

// One or more declarations
declarations: declaration declarations
    | declaration;
// Int/floats, comments
declaration: (numberDecl | comment) NEWLINE*;
// Comments - multiline comment?
comment: '//'(' ' | LETTER | DIGIT)*;
// Variable
variable: LETTER (LETTER | DIGIT)*;
// Integers and floats
numberDecl: (integerDecl | floatDecl | vector2Decl | vector3Decl | vector4Decl) SEMICOLON;

integerDecl: 'int ' variable ASSIGN (DIGIT | variable);
floatDecl: 'float ' variable ASSIGN real_number arith*;

vector2Decl: 'vector2' variable ASSIGN '('real_number','real_number')';
vector3Decl: 'vector3' variable ASSIGN '('real_number','real_number','real_number')';
vector4Decl: 'vector4' variable ASSIGN '('real_number','real_number','real_number','real_number','')';

arith: OPERATOR variable
    | OPERATOR real_number;

real_number: DIGIT | FLOAT_DIGIT;

// Helpers
LETTER: 'A'..'z';
DIGIT: '0'
    | '1'..'9' '0'..'9'*;
FLOAT_DIGIT: DIGIT'.'DIGIT;
SEMICOLON: ';';
NEWLINE: '\n';
SPACE: ' ';
ASSIGN: SPACE* '=' SPACE*;
MATH_FUNCTION: 'abs' | 'sin' | 'cos' | 'tan';
OPERATOR: SPACE*('+' | '-' | '%' | '/' | '*')SPACE*;
UNIFORM: 'Time';
