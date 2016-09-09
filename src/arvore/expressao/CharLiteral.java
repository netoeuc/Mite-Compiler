package arvore.expressao;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;
import arvore.Tipo;


public class CharLiteral implements Expressao {
	private char charLiteral;
	private String charLiteralStr;
	
	
	public CharLiteral(char c){
		this.charLiteral = c;
		
	}
	
	public CharLiteral(String c){
		this.charLiteralStr = c;
		
	}
	
	public boolean verificar(PilhaTabelaDeSimbolos pilha){
		return true;
	}
	
	public Tipo getTipo(){
		return Tipo.CHAR;
	}
	
	public String gerarCodigo(String varFinal){
		return (varFinal + " = "+charLiteralStr+"\n");
	}
}
