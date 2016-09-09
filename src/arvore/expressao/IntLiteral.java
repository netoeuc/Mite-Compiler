package arvore.expressao;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;
import arvore.Tipo;


public class IntLiteral implements Expressao{
	private Integer intLiteral;

	public IntLiteral(Integer intLiteral) {
		super();
		this.intLiteral = intLiteral;
	}
	
	public boolean verificar(PilhaTabelaDeSimbolos pilha){
		return true;
	}
	public Tipo getTipo(){
		return Tipo.INT;
	}
	
	public String gerarCodigo(String varFinal){
		return (varFinal + " = " + String.valueOf(intLiteral)+ "\n");
		
	}
}
