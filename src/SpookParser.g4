parser grammar SpookParser;
options { tokenVocab=SpookLexer; }

program: main (comment | classDecl | functionDecl)*;

// Classes (Optional), Functions (Optional), Shader() {} (Needed)
main: MAIN LEFT_BRACKET (declarations | comment)* RIGHT_BRACKET;

// One or more declarations
declarations: declaration declarations
    | declaration;

// Int/float/vector, comments
declaration: (numberDecl | boolDecl | objectDecl | objectFunctionCall) SEMICOLON;

// Single-line comment
comment: COMMENT_STRING;

// Class
classDecl: CLASS ID LEFT_BRACKET (numberDecl | functionDecl)* RIGHT_BRACKET;

// Object
objectDecl: classType ID ASSIGN LEFT_PAREN objectArgs* RIGHT_PAREN;
objectArgs: objectArg COMMA objectArgs
    | objectArg;
objectArg: (ID | realNumber | arithOperation);

// Object function calls
objectFunctionCall: (objectVariable DOT functionName ASSIGN LEFT_PAREN objectArgs* RIGHT_PAREN
    | objectVariable DOT functionName LEFT_PAREN objectArgs RIGHT_PAREN);

// Function
functionDecl: returnType ID LEFT_PAREN INT* RIGHT_PAREN LEFT_BRACKET (declaration)* RIGHT_BRACKET;

// Return types
returnType: VOID;



classType
    : CIRCLE
    | RECTANGLE
    | TRIANGLE
    | SHAPE
    | COLOR;

// Variable name
objectVariable: ID;
functionName: ID;

// Integer, float and vector declaration
numberDecl: (integerDecl
    | floatDecl
    | vector2Decl
    | vector3Decl
    | vector4Decl);

// Integer and float declarations
integerDecl: INT ID ASSIGN (arithOperations | digit);
floatDecl: FLOAT ID ASSIGN (arithOperations | mathFunction | realNumber);

// Recursive arithmetic operations
arithOperations: arithOperation arithOperations
    | arithOperation;

// Arithmetic operations
arithOperation: (realNumber | mathFunction | ID) OPERATOR (realNumber | mathFunction | ID | LEFT_PAREN arithOperation RIGHT_PAREN)
    | OPERATOR (realNumber | mathFunction | ID | LEFT_PAREN arithOperation RIGHT_PAREN)
    | LEFT_PAREN arithOperations RIGHT_PAREN; // Paranteser skal måske ikke håndteres her

// Mathematical functions
mathFunction: MATH_FUNCTION (ID | realNumber | mathFunction | UNIFORM) arithOperation* RIGHT_PAREN;

// Boolean declaration
boolDecl: BOOL ASSIGN (boolOperations | TRUE | FALSE);

// Recursive boolean operations
boolOperations: boolOperation boolOperations
    | boolOperation;

// Boolean operations
boolOperation: (TRUE | FALSE | ID) BOOLOPERATOR (TRUE | FALSE | ID | (LEFT_PAREN boolOperation RIGHT_PAREN))
    | BOOLOPERATOR (TRUE | FALSE | ID | (LEFT_PAREN boolOperation RIGHT_PAREN))
    | LEFT_PAREN boolOperation RIGHT_PAREN;

// Vector declarations
vector2Decl: VECTOR2 ID ASSIGN LEFT_PAREN realNumber COMMA realNumber RIGHT_PAREN;
vector3Decl: VECTOR3 ID ASSIGN LEFT_PAREN realNumber COMMA realNumber COMMA realNumber RIGHT_PAREN;
vector4Decl: VECTOR4 ID ASSIGN LEFT_PAREN realNumber COMMA realNumber COMMA realNumber COMMA realNumber RIGHT_PAREN;

/* Overvej det her. Ulempe: Vi kan ikke sørge for at der er PRÆCIST 2, 3 eller 4 arguments.
Måske vi kan fange den error et andet sted i compileren.
vectorArgs: real_number space* ',' space* vectorArgs
    | real_number;
*/

// Numbers
realNumber: digit | floatDigit;
digit: DIGIT;
floatDigit: FLOAT_DIGIT;
