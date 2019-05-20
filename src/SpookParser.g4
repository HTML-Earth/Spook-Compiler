parser grammar SpookParser;
options { tokenVocab=SpookLexer; }



/*      PROGRAM START        */
// Shader() {} (Needed)
// Comments, Classes and functions can be declared outside (under) of the main function
// variableName to catch errors
program
    : main (classDecl | functionDecl | variableName)*;




/*      MAIN             */
// Shader() {} (Needed), Declarations (Optional), Comments (Optional)
main
    : MAIN block;

// Main block (Block with return statement is functionBlock)
block: LEFT_BRACKET (statement)* RIGHT_BRACKET;

// Statements
statement
    : declaration
    | assignment SEMICOLON
    | functionCall SEMICOLON
    | conditionalStatement
    | iterativeStatement
    | returnStatement; //Typechecking




/*      DECLARATIONS       */
declaration
    : variableDecl SEMICOLON
    | objectDecl SEMICOLON;

// Variable declaration
variableDecl
    : dataType variableDeclInit (COMMA variableDeclInit)*;

variableDeclInit
    : variableName | assignment;

// Object declaration
objectDecl
    : className objectVariableName ASSIGN objectConstructor;

objectConstructor
    : LEFT_PAREN objectArgs? RIGHT_PAREN
    | functionCall
    | objectVariableName;


/*      ASSIGNMENT       */
assignment
    : (variableName | swizzle) ASSIGN expression;


expression
    : arithExpression
    | boolExpression
    | ternaryOperator;



// Expressions
arithExpression: lowPrecedence;
vector2Expression: LEFT_PAREN arithExpression COMMA arithExpression RIGHT_PAREN;
vector3Expression: LEFT_PAREN arithExpression COMMA arithExpression COMMA arithExpression RIGHT_PAREN;
vector4Expression: LEFT_PAREN arithExpression COMMA arithExpression COMMA arithExpression COMMA arithExpression RIGHT_PAREN;
boolExpression: boolOperations;
ternaryOperator: (boolExpression | variableName | functionCall) QUESTION expression COLON expression;

arithOperand
    : realNumber | variableName | functionCall | swizzle | vector2Expression | vector3Expression | vector4Expression;

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
    : NOT? boolOperation boolOperationExtend*
    | NOT? arithExpression boolOperationExtend+;

// Boolean operations
boolOperation
    : BOOL_LITERAL
    | LEFT_PAREN boolOperations RIGHT_PAREN;

boolOperationExtend
    : boolOperator NOT? (boolOperation | arithExpression);

swizzle
    : objectVariableName DOT functionName;


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
    : objectArg (COMMA objectArg)*;
objectArg
    : lowPrecedence
    | boolExpression;


/*      CONDITIONAL STATEMENTS      */
conditionalStatement
    : ifElseStatement;

// If-else statement
ifElseStatement:  ifStatement elseIfStatement* elseStatement?;

// Statements
ifStatement: IF LEFT_PAREN conditionalExpression RIGHT_PAREN conditionalBlock;
elseIfStatement: ELSE_IF LEFT_PAREN conditionalExpression RIGHT_PAREN conditionalBlock;
elseStatement: ELSE conditionalBlock;

// Expressions
conditionalExpression: boolExpression | variableName | functionCall;

// Blocks
conditionalBlock: statement | block;


/*      LOOPS        */
iterativeStatement
    : forStatement;

// For loop
forStatement
    : FOR LEFT_PAREN forLoopExpression TO forLoopExpression RIGHT_PAREN conditionalBlock;

forLoopExpression: (atomPrecedence | variableDecl | variableName | assignment);




/*      CLASSES     */
// Class declaration
classDecl
    : CLASS className ((EXTENDS | IMPLEMENTS) className)? classBlock;

// Class block
classBlock: LEFT_BRACKET (declaration | constructor | functionDecl)* RIGHT_BRACKET;

// Class constructor
constructor: className LEFT_PAREN functionArgs? RIGHT_PAREN constructorBlock;

// Class constructor block
constructorBlock: LEFT_BRACKET (assignment SEMICOLON)* RIGHT_BRACKET;


/*      FUNCTIONS    */
/* Function declaration */
functionDecl
    : VOID functionName LEFT_PAREN functionArgs? RIGHT_PAREN block
    | (dataType | className) functionName LEFT_PAREN functionArgs? RIGHT_PAREN block;


functionArgs
    : functionArg COMMA functionArgs
    | functionArg;
functionArg
    : (dataType | className) variableName;

// Return statement
returnStatement: RETURN expression SEMICOLON;




/*      HELPERS       */
// Numbers
realNumber: integerNumber | FLOAT_DIGIT | FLOAT_DIGIT_NEGATIVE;
integerNumber: DIGIT | DIGIT_NEGATIVE;

// Boolean operators, NOT does not fit here (True ! False)
boolOperator
    : EQUAL
    | OR
    | AND
    | NOT_EQUAL
    | GREATER_THAN
    | GREATER_OR_EQUAL
    | LESS_THAN
    | LESS_OR_EQUAL;

// Data types
dataType
    : NUM
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
