parser grammar EqlParser;

options {
	tokenVocab=EqlLexer;
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Statements

statement
	: selectStatement EOF
	;

selectStatement
	: querySpec
	;

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// QUERY SPEC - general structure of root sqm or sub sqm

querySpec
	: fromClause whereClause? orderByClause?
	;

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// FROM clause

fromClause
	: FROM fromClauseSpace
	;

fromClauseSpace
	: pathRoot
	;

pathRoot
	: entityName (identificationVariableDef)?
	;

entityName
	: IDENTIFIER
	;

identificationVariableDef
	: (AS)? IDENTIFIER
	;

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Path structures
path
	: generalPathFragment
	;

generalPathFragment
	: dotIdentifierSequence (indexedPathAccessFragment)?
	;

indexedPathAccessFragment
	: LEFT_BRACKET expression RIGHT_BRACKET (DOT generalPathFragment)?
	;

dotIdentifierSequence
	: IDENTIFIER dotIdentifierSequenceContinuation*
	;

dotIdentifierSequenceContinuation
	: DOT IDENTIFIER
	;

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ORDER BY clause

orderByClause
	: ORDER BY sortSpecification (COMMA sortSpecification)*
	;

sortSpecification
	: sortExpression orderingSpecification?
	;

sortExpression
	: IDENTIFIER
	;

orderingSpecification
	: ASC
	| DESC
	;

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// WHERE clause & Predicates

whereClause
	: WHERE predicate
	;

predicate
	: LEFT_PAREN predicate RIGHT_PAREN						# GroupedPredicate
	| predicate OR predicate								# OrPredicate
	| predicate AND predicate								# AndPredicate
	| NOT predicate											# NegatedPredicate
	| expression IS (NOT)? NULL								# IsNullPredicate
	| expression IS (NOT)? EMPTY							# IsEmptyPredicate
	| expression EQUAL expression							# EqualityPredicate
	| expression NOT_EQUAL expression						# InequalityPredicate
	| expression GREATER expression							# GreaterThanPredicate
	| expression GREATER_EQUAL expression					# GreaterThanOrEqualPredicate
	| expression LESS expression							# LessThanPredicate
	| expression LESS_EQUAL expression						# LessThanOrEqualPredicate
	| expression (NOT)? IN inList							# InPredicate
	| expression (NOT)? BETWEEN expression AND expression	# BetweenPredicate
	| expression (NOT)? LIKE expression             		# LikePredicate
	;

inList
	: LEFT_PAREN expression (COMMA expression)*	RIGHT_PAREN			# ExplicitTupleInList
	| expression													# SubQueryInList
	;

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Expression

expression
	: expression DOUBLE_PIPE expression			# ConcatenationExpression
	| expression PLUS expression				# AdditionExpression
	| expression MINUS expression				# SubtractionExpression
	| expression ASTERISK expression			# MultiplicationExpression
	| expression SLASH expression				# DivisionExpression
	| expression PERCENT expression				# ModuloExpression
	| MINUS expression							# UnaryMinusExpression
	| PLUS expression							# UnaryPlusExpression
	| literal									# LiteralExpression
	| parameter									# ParameterExpression
	| path										# PathExpression
	| function									# FunctionExpression
	;

literal
	: STRING_LITERAL
	| CHARACTER_LITERAL
	| INTEGER_LITERAL
	| LONG_LITERAL
	| BIG_INTEGER_LITERAL
	| FLOAT_LITERAL
	| DOUBLE_LITERAL
	| BIG_DECIMAL_LITERAL
	| HEX_LITERAL
	| OCTAL_LITERAL
	| NULL
	| TRUE
	| FALSE
	;

parameter
	: COLON IDENTIFIER					# NamedParameter
	;

function
	: nonStandardFunction
	;

nonStandardFunction
	: nonStandardFunctionName LEFT_PAREN nonStandardFunctionArguments? RIGHT_PAREN
	;

nonStandardFunctionName
	: dotIdentifierSequence
	;

nonStandardFunctionArguments
	: expression (COMMA expression)*
	;
