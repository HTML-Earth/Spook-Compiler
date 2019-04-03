grammar Test;
main: declarations;
declarations: declaration declarations
    | declaration;
declaration: numberDecl;
numberDecl: (integer | float) SEMICOLON ('\n')+;

integer: 'int ' DIGIT;
float: 'float ' DIGIT'.'DIGIT;


DIGIT: '0'
    | '1'..'9' '0'..'9'*;
SEMICOLON: ';';
