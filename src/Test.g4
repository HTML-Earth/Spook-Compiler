grammar Test;
main: declarations;
declarations: declaration declarations
    | declaration;
declaration: numberDecl | comment;
numberDecl: (integerDecl | floatDecl) SEMICOLON ('\n')*;
comment: '//'(' ' | LETTER)* ('\n')*;

integerDecl: 'int ' DIGIT;
floatDecl: 'float ' DIGIT'.'DIGIT;

LETTER: 'A'..'z';
DIGIT: '0'
    | '1'..'9' '0'..'9'*;
SEMICOLON: ';';
