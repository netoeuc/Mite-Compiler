package arvore.expressao;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;
import arvore.Tipo;


public class StringLiteral implements Expressao {
	
	private String stringLiteral;
	
	public StringLiteral(String stringLiteral){
		this.stringLiteral = stringLiteral;
		
	}

	@Override
	public boolean verificar(PilhaTabelaDeSimbolos pilha) {
		return true;
	}

	@Override
	public Tipo getTipo() {
		return Tipo.STRING;
	}

	public String gerarCodigo(String varFinal){
		return (varFinal + " = " + stringLiteral + "\n");
	}
	
}
