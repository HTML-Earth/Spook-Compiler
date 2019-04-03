grammar Test;
main: declarations;
declarations: declaration declarations
    | declaration;
declaration: numberDecl;
numberDecl: (integerDecl | floatDecl) SEMICOLON ('\n')+;

integerDecl: 'int ' DIGIT;
floatDecl: 'float ' DIGIT'.'DIGIT;


DIGIT: '0'
    | '1'..'9' '0'..'9'*;
SEMICOLON: ';';
