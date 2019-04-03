grammar Test;
main: declarations;

// One or more declarations
declarations: declaration declarations
    | declaration;
// Int/floats, comments, more to come (variables)
declaration: (numberDecl | comment) NEWLINE*;
// Comments - multiline comment?
comment: '//'(' ' | LETTER)*;
// Integers and floats - variables?
numberDecl: (integerDecl | floatDecl) SEMICOLON;

integerDecl: 'int ' DIGIT;
floatDecl: 'float ' DIGIT'.'DIGIT;

// Helpers
LETTER: 'A'..'z';
DIGIT: '0'
    | '1'..'9' '0'..'9'*;
SEMICOLON: ';';
NEWLINE: '\n';
