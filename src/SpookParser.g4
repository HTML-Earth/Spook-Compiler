parser grammar SpookParser;
options { tokenVocab=SpookLexer; }

// Shader() {} (Needed)
// Comments, Classes and functions can be declared outside (under) of the main function
program
    : main (comment | classDecl | functionDecl)*;

// Shader() {} (Needed), Declarations (Optional), Comments (Optional)
main
    : MAIN LEFT_BRACKET (declarations | comment)* RIGHT_BRACKET;

// One or more declarations
declarations
    : declaration declarations
    | declaration;

// Int/float/vector, booleans, object declarations and object function calls
declaration
    : (numberDecl
    | boolDecl
    | objectDecl
    | objectFunctionCall) SEMICOLON;

// Single-line comment
comment
    : COMMENT_STRING;

/* Class declaration */
classDecl
    : CLASS ID ((EXTENDS | IMPLEMENTS) classType)? LEFT_BRACKET declarations? functionDecl* RIGHT_BRACKET;

/* Object */
objectDecl
    : classType ID ASSIGN LEFT_PAREN objectArgs* RIGHT_PAREN;
objectArgs
    : objectArg COMMA objectArgs
    | objectArg;
objectArg
    : ID
    | realNumber
    | arithOperation
    | colorFunctionCall;

// Object function calls
objectFunctionCall
    : (objectVariable DOT functionName ASSIGN (objectArg? | LEFT_PAREN objectArgs* RIGHT_PAREN)
    | objectVariable DOT functionName LEFT_PAREN objectArgs* RIGHT_PAREN);

// Color function call
colorFunctionCall
    : COLOR DOT colorFunction;


/* Function declaration */
functionDecl
    : returnType ID LEFT_PAREN (dataType ID)* RIGHT_PAREN LEFT_BRACKET declarations? RETURN returnType SEMICOLON RIGHT_BRACKET
    | VOID ID LEFT_PAREN (dataType ID)* RIGHT_PAREN LEFT_BRACKET declarations? RIGHT_BRACKET;


/* Integer, float and vector declaration */
numberDecl
    : integerDecl
    | floatDecl
    | vector2Decl
    | vector3Decl
    | vector4Decl;

// Integer and float declarations
integerDecl
    : INT ID ASSIGN (arithOperations | mathFunction | naturalNumber);
floatDecl
    : FLOAT ID ASSIGN (arithOperations | mathFunction | realNumber);

// Recursive arithmetic operations
arithOperations
    : arithOperation arithOperations
    | arithOperation;

// Arithmetic operations
arithOperation
    : (realNumber | mathFunction | ID) operator (realNumber | mathFunction | ID | LEFT_PAREN arithOperation RIGHT_PAREN)
    | operator (realNumber | mathFunction | ID | LEFT_PAREN arithOperation RIGHT_PAREN)
    | LEFT_PAREN arithOperations RIGHT_PAREN;

// Mathematical functions
mathFunction
    : function (ID | realNumber | mathFunction | UNIFORM) arithOperation* RIGHT_PAREN;


/* Vector declarations */
vector2Decl
    : VECTOR2 ID ASSIGN LEFT_PAREN realNumber COMMA realNumber RIGHT_PAREN;
vector3Decl
    : VECTOR3 ID ASSIGN LEFT_PAREN realNumber COMMA realNumber COMMA realNumber RIGHT_PAREN;
vector4Decl
    : VECTOR4 ID ASSIGN LEFT_PAREN realNumber COMMA realNumber COMMA realNumber COMMA realNumber RIGHT_PAREN;

/* Overvej det her. Ulempe: Vi kan ikke sørge for at der er PRÆCIST 2, 3 eller 4 arguments.
Måske vi kan fange den error et andet sted i compileren.
vectorArgs: real_number space* ',' space* vectorArgs
    | real_number;
*/


/* Boolean declaration */
boolDecl
    : BOOL ID ASSIGN (boolOperations | BOOL_LITERAL);

// Recursive boolean operations
boolOperations
    : boolOperation boolOperations
    | boolOperation;

// Boolean operations
boolOperation
    : (BOOL_LITERAL | ID) boolOperator (BOOL_LITERAL | ID | (LEFT_PAREN boolOperation RIGHT_PAREN))
    | boolOperator (BOOL_LITERAL | ID | (LEFT_PAREN boolOperation RIGHT_PAREN))
    | LEFT_PAREN boolOperation RIGHT_PAREN;






// Numbers
realNumber: naturalNumber | FLOAT_DIGIT | FLOAT_DIGIT_NEGATIVE;
naturalNumber: DIGIT | DIGIT_NEGATIVE;

// Pre-defined colors
colorFunction
    : BLACK
    | WHITE
    | RED
    | GREEN
    | BLUE;

// Arithmetic operators
operator
    : ADD
    | SUB
    | MOD
    | DIV
    | MUL;

// Boolean operators
boolOperator
    : EQUAL
    | OR
    | AND
    | NOT_EQUAL
    | NOT;

// Math functions
function
    : ABS
    | SIN
    | COS
    | TAN;

// Return types
returnType
    : VOID
    | dataType;

// Pre-defined classes
classType
    : CIRCLE
    | RECTANGLE
    | TRIANGLE
    | SHAPE
    | COLOR;

// Data types
dataType
    : INT
    | FLOAT
    | BOOL
    | VECTOR2
    | VECTOR3
    | VECTOR4;

// Variable name
objectVariable
    : ID;
functionName
    : ID;