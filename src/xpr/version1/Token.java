package xpr.version1;


/**
 * Cada token � um par formado pelo lexema e a classifica��o dele.
 * 
 * @author Pablo Sampaio
 */
public class Token {
	private TokenType tipo;
	private String lexema;
	private int yyline;
	private int yycolumn;
	
	

	public Token(TokenType tipo, int yyline, int yycolumn) {
		this.tipo = tipo;
		this.yycolumn = yycolumn; //+1;
		this.yyline = yyline; //+1;
	}
	
	
	//construtor linha coluna
		public Token(TokenType tipo, String lexema, int yyline, int yycolumn){
			this.tipo = tipo;
			this.lexema = lexema;
			this.yyline = yyline; //+1;
			this.yycolumn = yycolumn; //+1;
			
		}
	
	public TokenType getType() {
		return tipo;
	}
	
	public String getLexeme() {
		return lexema;
	}
	
	public int getYyline(){
		return this.yyline;
	}

	public int getYycolumn(){
		return this.yycolumn;
	}

	
	public String toString() {
		if (lexema == null || lexema.length() == 0) {
			return "[" + tipo + "]";	
		} else {
			return "[" + tipo + "," + lexema + "]";
		}
	}

}

