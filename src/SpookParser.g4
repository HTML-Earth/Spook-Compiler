parser grammar SpookParser;
options { tokenVocab=SpookLexer; }



/*      PROGRAM START        */
// Shader() {} (Needed)
// Comments, Classes and functions can be declared outside (under) of the main function
// ID to catch errors
program
    : main (comment | classDecl | functionDecl | variableName)*;




/*      MAIN             */
// Shader() {} (Needed), Declarations (Optional), Comments (Optional)
main
    : MAIN block;

// Main block
block: LEFT_BRACKET (statement | comment)* RIGHT_BRACKET;

// Comment: Single-line
comment
    : COMMENT_STRING;

// Statements
statement
    : declaration
    | assignment SEMICOLON
    | functionCall SEMICOLON
    | conditionalStatement
    | iterativeStatement;




/*      DECLARATIONS       */
declaration
    : variableDecl SEMICOLON
    | objectDecl SEMICOLON;

// Variable declaration
variableDecl
    : dataType (variableName | assignment) (COMMA (variableName | assignment))*;

// Object declaration
objectDecl
    : className objectVariableName ASSIGN LEFT_PAREN objectArgs? RIGHT_PAREN;




/*      ASSIGNMENT       */
assignment
    : (variableName | swizzle) ASSIGN expression;

expression
    : arithExpression
    | vector2Expression
    | vector3Expression
    | vector4Expression
    | boolExpression
    | ternaryOperator
    | functionCall;

// Expressions
arithExpression: lowPrecedence;
vector2Expression: LEFT_PAREN arithExpression COMMA arithExpression RIGHT_PAREN;
vector3Expression: LEFT_PAREN arithExpression COMMA arithExpression COMMA arithExpression RIGHT_PAREN;
vector4Expression: LEFT_PAREN arithExpression COMMA arithExpression COMMA arithExpression COMMA arithExpression RIGHT_PAREN;
boolExpression: boolOperations;
ternaryOperator: boolExpression QUESTION expression COLON expression;

arithOperand
    : realNumber | variableName | functionCall | swizzle;

//Precedence, goes through low to high, ends at atom
lowPrecedence
    : highPrecedence (lowOperator highPrecedence)*;
highPrecedence
    : atomPrecedence (highOperator atomPrecedence)*;
atomPrecedence
    : SUB? arithOperand
    | LEFT_PAREN lowPrecedence RIGHT_PAREN;


highOperator
    : MUL
    | DIV
    | MOD;

lowOperator
    : ADD
    | SUB;

// Recursive boolean operations
boolOperations
    : NOT? boolOperation boolOperationExtend*;

// Boolean operations
boolOperation
    : BOOL_LITERAL
    | variableName
    | LEFT_PAREN boolOperations RIGHT_PAREN
    | boolGreaterLess;

boolOperationExtend
    : boolOperator NOT? (BOOL_LITERAL | variableName | boolGreaterLess | (LEFT_PAREN boolOperation RIGHT_PAREN));

boolGreaterLess
    :(variableName | DIGIT) boolNumberCompareOp (variableName | DIGIT);

// Swizzling
swizzle
    : variableName DOT coordinateSwizzle
    | variableName DOT colorSwizzle;

coordinateSwizzle: COORDINATE_SWIZZLE_MASK;
colorSwizzle: COLOR_SWIZZLE_MASK;




/*      FUNCTION CALLS       */
functionCall
    : nonObjectFunctionCall
    | objectFunctionCall;


// Non-object funtion calls (Global functions)
nonObjectFunctionCall
    : functionName LEFT_PAREN objectArgs? RIGHT_PAREN;

// Object function calls
objectFunctionCall
    :objectVariableName DOT functionName LEFT_PAREN objectArgs? RIGHT_PAREN;

// Object arguments
objectArgs
    : objectArg COMMA objectArgs
    | objectArg;
objectArg
    : lowPrecedence;


/*      CONDITIONAL STATEMENTS      */
conditionalStatement
    : ifElseStatement;

// If-else statement
ifElseStatement:  ifStatement elseIfStatement* elseStatement?;

// Statements
ifStatement: IF LEFT_PAREN ifBoolExpression RIGHT_PAREN ifBlock;
elseIfStatement: ELSE_IF LEFT_PAREN elseifBoolExpression RIGHT_PAREN elseIfBlock;
elseStatement: ELSE elseBlock;

// Expressions
ifBoolExpression: boolExpression;
elseifBoolExpression: boolExpression;

// Blocks
ifBlock: conditionalBlock;
elseIfBlock: conditionalBlock;
elseBlock: conditionalBlock;
conditionalBlock: block | statement;


/*      LOOPS        */
iterativeStatement
    : forStatement;

// For loop
forStatement
    : FOR LEFT_PAREN forLoopExpression TO forLoopExpression RIGHT_PAREN (block | statement);

forLoopExpression: (DIGIT | variableDecl | variableName | assignment);




/*      CLASSES     */
// Class declaration
classDecl
    : CLASS className ((EXTENDS | IMPLEMENTS) className)? classBlock;

// Class block
classBlock: LEFT_BRACKET (declaration | constructor | functionDecl | comment)* RIGHT_BRACKET;

// Class constructor
constructor: className LEFT_PAREN functionArgs? RIGHT_PAREN constructorBlock;

// Class constructor block
constructorBlock: LEFT_BRACKET (assignment SEMICOLON)* RIGHT_BRACKET;


/*      FUNCTIONS    */
/* Function declaration */
functionDecl
    : VOID functionName LEFT_PAREN functionArgs? RIGHT_PAREN block
    | returnType functionName LEFT_PAREN functionArgs? RIGHT_PAREN functionBlock;

functionArgs
    : functionArg COMMA functionArgs
    | functionArg;
functionArg
    : (dataType | className) variableName;

// Function block
functionBlock: LEFT_BRACKET (statement | comment)* returnStatement RIGHT_BRACKET;

// Return statement
returnStatement: RETURN expression SEMICOLON;




/*      HELPERS       */
// Numbers
realNumber: integerNumber | FLOAT_DIGIT | FLOAT_DIGIT_NEGATIVE;
integerNumber: DIGIT | DIGIT_NEGATIVE;

// Boolean operators
boolOperator
    : EQUAL
    | OR
    | AND
    | NOT_EQUAL
    | NOT;

// Booloean ops for numbers
boolNumberCompareOp
    : GREATER_THAN
    | GREATER_OR_EQUAL
    | LESS_THAN
    | LESS_OR_EQUAL
    | EQUAL
    | NOT_EQUAL;

// Return types
returnType
    : dataType
    | className;

// Data types
dataType
    : INT
    | FLOAT
    | BOOL
    | VECTOR2
    | VECTOR3
    | VECTOR4;

// Variable names
objectVariableName
    : ID;
functionName
    : ID;
variableName
    : ID;
className
    : ID;
