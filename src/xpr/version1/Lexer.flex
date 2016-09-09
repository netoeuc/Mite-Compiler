package xpr.version1;
import java_cup.runtime.*;

%%

%class Lexer
%public

 %cup
//%function nextToken
//%type Token



%line
%column

//antigo whiteSpace -> whiteSpace=([ \n\t\f\r]+)
whiteSpace=([ \n\t\f\r]+)
letra=[a-zA-Z]
numero=[0-9]

%%

{whiteSpace} { 
	// Caracteres ignorados.
	// Nenhum token � retornado.
}

"##"[^\n]* {}
//"(*"[^"/*)"]*"*)" {}
"(*" [^*] ~"*)" | "(*" "*"+ ")" {}


";" { return new Symbol(sym.PONTO_VIRGULA,(yyline+1),(yycolumn+1)); }
"+" { return new Symbol(sym.SOMA,(yyline+1),(yycolumn+1)); }
"-" { return new Symbol(sym.SUB,(yyline+1),(yycolumn+1)); }
"*" { return new Symbol(sym.MULT,(yyline+1),(yycolumn+1)); }
"/" { return new Symbol(sym.DIV,(yyline+1),(yycolumn+1)); }
"(" { return new Symbol(sym.ABRE_PAR,(yyline+1),(yycolumn+1)); }
")" { return new Symbol(sym.FECHA_PAR,(yyline+1),(yycolumn+1)); }
"=" { return new Symbol(sym.ATRIBUICAO,(yyline+1),(yycolumn+1)); }
"," { return new Symbol(sym.VIRGULA,(yyline+1),(yycolumn+1)); }
":" { return new Symbol(sym.DOIS_PONTOS,(yyline+1),(yycolumn+1)); }
"{" { return new Symbol(sym.ABRE_CHAVE,(yyline+1),(yycolumn+1)); }
"}" { return new Symbol(sym.FECHA_CHAVE,(yyline+1),(yycolumn+1)); }



">" { return new Symbol(sym.OP_MAIOR_QUE,(yyline+1),(yycolumn+1)); }
"<" { return new Symbol(sym.OP_MENOR_QUE,(yyline+1),(yycolumn+1)); }
">=" { return new Symbol(sym.OP_MAIOR_OU_IGUAL,(yyline+1),(yycolumn+1)); }
"<=" { return new Symbol(sym.OP_MENOR_OU_IGUAL,(yyline+1),(yycolumn+1)); }
"==" { return new Symbol(sym.OP_IGUAL,(yyline+1),(yycolumn+1)); }
"!=" { return new Symbol(sym.OP_DIFERENTE,(yyline+1),(yycolumn+1)); }
"%" { return new Symbol(sym.RESTO,(yyline+1),(yycolumn+1)); }

//Palavras Reservadas
"and" { return new Symbol(sym.AND,(yyline+1),(yycolumn+1)); }
"or"  { return new Symbol(sym.OR,(yyline+1),(yycolumn+1)); }
"not" { return new Symbol(sym.NOT,(yyline+1),(yycolumn+1)); }
"if"  { return new Symbol(sym.KEY_IF,(yyline+1),(yycolumn+1)); }
"else" { return new Symbol(sym.KEY_ELSE,(yyline+1),(yycolumn+1)); }
"while" { return new Symbol(sym.KEY_WHILE,(yyline+1),(yycolumn+1)); }
"return" { return new Symbol(sym.KEY_RETURN,(yyline+1),(yycolumn+1)); }
"float" { return new Symbol(sym.KEY_FLOAT,(yyline+1),(yycolumn+1)); }
"char" { return new Symbol(sym.KEY_CHAR,(yyline+1),(yycolumn+1)); }
"print" { return new Symbol(sym.KEY_PRINT,(yyline+1),(yycolumn+1)); }
"int" { return new Symbol(sym.KEY_INT,(yyline+1),(yycolumn+1)); }
"string" { return new Symbol(sym.KEY_STRING,(yyline+1),(yycolumn+1)); }
"call" { return new Symbol(sym.KEY_CALL,(yyline+1),(yycolumn+1)); }



"def"      { return new Symbol(sym.KEY_DEF,(yyline+1),(yycolumn+1)); }
{numero}*{letra}({letra}|{numero})*   { return new Symbol(sym.IDENTIFICADOR,(yyline+1),(yycolumn+1), yytext()); }


//Inteiro Literal
{numero}+  { return new Symbol(sym.INT_LITERAL,(yyline+1),(yycolumn+1), yytext()); }

//Ponto flutuante
{numero}+\.{numero}+ { return new Symbol(sym.FLOAT_LITERAL,(yyline+1),(yycolumn+1), yytext()); }

//Caracter
"'"({numero}|{letra}|"\\n"|"\\t"|" ")"'" { return new Symbol(sym.CHAR_LITERAL,(yyline+1),(yycolumn+1), yytext()); }

//String_literal
"\""({numero}|{letra}|"\\n"|"\\t"|" "|","|"("|")"|":")*"\"" { return new Symbol(sym.STRING_LITERAL,(yyline+1),(yycolumn+1), yytext()); }



. { 
    // Casa com qualquer caracter que n�o casar com as expressoes acima.
    System.out.println("Illegal character at line "+ ((yyline+1))+" column "+(yycolumn+1)+": " + yytext());
}

<<EOF>> {
	// Casa com o fim do arquivo apenas.
	return new Symbol(sym.EOF,(yyline+1),(yycolumn+1));
}
