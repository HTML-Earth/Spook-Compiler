grammar Test;
main: decl;
decl: (number SEMICOLON)+;
number: integer | float;
integer: 'int ' DIGIT+;
float: 'float ' DIGIT+'.'DIGIT+;


DIGIT: '1'..'9' '0'..'9'*;
SEMICOLON: ';';
