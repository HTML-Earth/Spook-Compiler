parser grammar SpookParser;
options { tokenVocab=SpookLexer; }

// Shader() {} (Needed)
// Comments, Classes and functions can be declared outside (under) of the main function
program
    : main (comment | classDecl | functionDecl)*;

// Shader() {} (Needed), Declarations (Optional), Comments (Optional)
main
    : MAIN block;

// One or more declarations
declarations
    : declaration SEMICOLON declarations
    | declaration SEMICOLON;

// Int/float/vector, booleans, object declarations and object function calls
declaration
    : variableDecl
    | objectDecl;

statements
    : statement statements
    | statement;

statement
    : declaration SEMICOLON
    | assignment SEMICOLON
    | objectFunctionCall SEMICOLON
    | conditionalStatement
    //| iterativeStatement
    | RETURN (variableName | realNumber | BOOL_LITERAL) SEMICOLON;

/* Blocks */
block: LEFT_BRACKET (statements | comment)* RIGHT_BRACKET;
classBlock: LEFT_BRACKET (declarations | functionDecl | comment)* RIGHT_BRACKET;

// Assignment
assignment
    : variableName ASSIGN expression;

expression
    : integerExpression
    | floatExpression
    | vector2Expression
    | vector3Expression
    | vector4Expression
    | boolExpression
    | ternaryOperator;

// Expressions
integerExpression: arithOperations | mathFunction | naturalNumber;
floatExpression: arithOperations | mathFunction | realNumber;
vector2Expression: LEFT_PAREN realNumber COMMA realNumber RIGHT_PAREN;
vector3Expression: LEFT_PAREN realNumber COMMA realNumber COMMA realNumber RIGHT_PAREN;
vector4Expression: LEFT_PAREN realNumber COMMA realNumber COMMA realNumber COMMA realNumber RIGHT_PAREN;
boolExpression: boolOperations | BOOL_LITERAL;

// Conditional statements
conditionalStatement
    : ifElseStatement
    | ternaryOperator;

// If-else if-else
ifElseStatement: IF LEFT_PAREN boolExpression RIGHT_PAREN block (ELSE_IF LEFT_PAREN boolExpression RIGHT_PAREN block)* (ELSE block)?;
ternaryOperator: boolExpression QUESTION expression COLON expression;

// Single-line comment
comment
    : COMMENT_STRING;

/* Class declaration */
classDecl
    : CLASS className ((EXTENDS | IMPLEMENTS) classType)? classBlock;

/* Object */
objectDecl
    : classType objectVariableName ASSIGN LEFT_PAREN objectArgs* RIGHT_PAREN;
objectArgs
    : objectArg COMMA objectArgs
    | objectArg;
objectArg
    : variableName
    | realNumber
    | arithOperation
    | classProperty;

// Object function calls
objectFunctionCall
    : (objectVariableName DOT functionName ASSIGN (objectArg? | LEFT_PAREN objectArgs* RIGHT_PAREN)
    | objectVariableName DOT functionName LEFT_PAREN objectArgs* RIGHT_PAREN);

// Color function call
classProperty
    : classType DOT variableName;


/* Function declaration */
functionDecl
    : returnType functionName LEFT_PAREN (dataType variableName)* RIGHT_PAREN block
    | VOID functionName LEFT_PAREN (dataType variableName)* RIGHT_PAREN block;


/* Integer, float and vector declaration */
variableDecl
    : dataType (assignment | variableName);


// Recursive arithmetic operations
arithOperations
    : arithOperation arithOperations
    | arithOperation;

// Arithmetic operations
arithOperation
    : (realNumber | mathFunction | variableName) operator (realNumber | mathFunction | variableName | LEFT_PAREN arithOperation RIGHT_PAREN)
    | operator (realNumber | mathFunction | variableName | LEFT_PAREN arithOperation RIGHT_PAREN)
    | LEFT_PAREN arithOperations RIGHT_PAREN;

// Mathematical functions
mathFunction
    : function (variableName | realNumber | mathFunction | UNIFORM) arithOperation* RIGHT_PAREN;


// Recursive boolean operations
boolOperations
    : boolOperation boolOperations
    | boolOperation;

// Boolean operations
boolOperation
    : (BOOL_LITERAL | variableName) boolOperator (BOOL_LITERAL | variableName | (LEFT_PAREN boolOperation RIGHT_PAREN))
    | boolOperator (BOOL_LITERAL | variableName | (LEFT_PAREN boolOperation RIGHT_PAREN))
    | LEFT_PAREN boolOperation RIGHT_PAREN;






// Numbers
realNumber: naturalNumber | FLOAT_DIGIT | FLOAT_DIGIT_NEGATIVE;
naturalNumber: DIGIT | DIGIT_NEGATIVE;

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
    : dataType;

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
objectVariableName
    : ID;
functionName
    : ID;
variableName
    : ID;
className
    : ID;