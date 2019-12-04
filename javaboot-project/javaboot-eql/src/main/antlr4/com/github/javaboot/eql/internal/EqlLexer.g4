lexer grammar EqlLexer;

WS : ( ' ' | '\t' | '\f' | EOL ) -> skip;

fragment
EOL	: [\r\n]+;

INTEGER_LITERAL : INTEGER_NUMBER ;

fragment
INTEGER_NUMBER : ('0' | '1'..'9' '0'..'9'*) ;

LONG_LITERAL : INTEGER_NUMBER ('l'|'L');

BIG_INTEGER_LITERAL : INTEGER_NUMBER ('bi'|'BI') ;

HEX_LITERAL : '0' ('x'|'X') HEX_DIGIT+ ('l'|'L')? ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

OCTAL_LITERAL : '0' ('0'..'7')+ ('l'|'L')? ;

FLOAT_LITERAL : FLOATING_POINT_NUMBER ('f'|'F')? ;

fragment
FLOATING_POINT_NUMBER
	: ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
	| '.' ('0'..'9')+ EXPONENT?
	| ('0'..'9')+ EXPONENT
	| ('0'..'9')+
	;

DOUBLE_LITERAL : FLOATING_POINT_NUMBER ('d'|'D') ;

BIG_DECIMAL_LITERAL : FLOATING_POINT_NUMBER ('bd'|'BD') ;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

CHARACTER_LITERAL
	:	'\'' ( ESCAPE_SEQUENCE | ~('\''|'\\') ) '\'' {setText(getText().substring(1, getText().length()-1));}
	;

STRING_LITERAL
	:	'"' ( ESCAPE_SEQUENCE | ~('\\'|'"') )* '"' {setText(getText().substring(1, getText().length()-1));}
	|	('\'' ( ESCAPE_SEQUENCE | ~('\\'|'\'') )* '\'')+ {setText(getText().substring(1, getText().length()-1).replace("''", "'"));}
	;

fragment
ESCAPE_SEQUENCE
	:	'\\' ('b'|'t'|'n'|'f'|'r'|'\\"'|'\''|'\\')
	|	UNICODE_ESCAPE
	|	OCTAL_ESCAPE
	;

fragment
OCTAL_ESCAPE
	:	'\\' ('0'..'3') ('0'..'7') ('0'..'7')
	|	'\\' ('0'..'7') ('0'..'7')
	|	'\\' ('0'..'7')
	;

fragment
UNICODE_ESCAPE
	:	'\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
	;

EQUAL : '=';
NOT_EQUAL : '!=' | '^=' | '<>';
GREATER : '>';
GREATER_EQUAL : '>=';
LESS : '<';
LESS_EQUAL : '<=';

COMMA :	',';
DOT	: '.';
LEFT_PAREN : '(';
RIGHT_PAREN	: ')';
LEFT_BRACKET : '[';
RIGHT_BRACKET : ']';
LEFT_BRACE : '{';
RIGHT_BRACE : '}';
PLUS : '+';
MINUS :	'-';
ASTERISK : '*';
SLASH : '/';
PERCENT	: '%';
AMPERSAND : '&';
SEMICOLON :	';';
COLON : ':';
PIPE : '|';
DOUBLE_PIPE : '||';
QUESTION_MARK :	'?';
ARROW :	'->';


// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Keywords

AND					: [aA] [nN] [dD];
AS					: [aA] [sS];
ASC					: [aA] [sS] [cC];
BY					: [bB] [yY];
BETWEEN	 			: [bB] [eE] [tT] [wW] [eE] [eE] [nN];
CURRENT_DATE		: [cC] [uU] [rR] [rR] [eE] [nN] [tT] '_' [dD] [aA] [tT] [eE];
CURRENT_INSTANT		: [cC] [uU] [rR] [rR] [eE] [nN] [tT] '_' [iI] [nN] [sS] [tT] [aA] [nN] [tT];
CURRENT_TIME		: [cC] [uU] [rR] [rR] [eE] [nN] [tT] '_' [tT] [iI] [mM] [eE];
CURRENT_TIMESTAMP	: [cC] [uU] [rR] [rR] [eE] [nN] [tT] '_' [tT] [iI] [mM] [eE] [sS] [tT] [aA] [mM] [pP];
DESC				: [dD] [eE] [sS] [cC];
EMPTY				: [eE] [mM] [pP] [tT] [yY];
FROM				: [fF] [rR] [oO] [mM];
IN					: [iI] [nN];
IS					: [iI] [sS];
LIKE				: [lL] [iI] [kK] [eE];
LN  				: [lL] [nN];
NOT					: [nN] [oO] [tT];
OR					: [oO] [rR];
ORDER				: [oO] [rR] [dD] [eE] [rR];
SELECT				: [sS] [eE] [lL] [eE] [cC] [tT];
WHERE				: [wW] [hH] [eE] [rR] [eE];

// case-insensitive true, false and null recognition (split vote :)
TRUE 	: [tT] [rR] [uU] [eE];
FALSE 	: [fF] [aA] [lL] [sS] [eE];
NULL 	: [nN] [uU] [lL] [lL];

// Identifiers
IDENTIFIER
	:	('a'..'z'|'A'..'Z'|'_'|'$'|'\u0080'..'\ufffe')('a'..'z'|'A'..'Z'|'_'|'$'|'0'..'9'|'\u0080'..'\ufffe')*
	;

QUOTED_IDENTIFIER
	: '`' ( ESCAPE_SEQUENCE | ~('\\'|'`') )* '`'
	;
