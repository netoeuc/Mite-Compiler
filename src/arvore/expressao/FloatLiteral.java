package arvore.expressao;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;
import arvore.Tipo;


public class FloatLiteral implements Expressao {
	private float valor;
	private String strValue;
	
	
	public FloatLiteral(float value){
		this.valor = value;
		
	}
	
	public FloatLiteral(String value){
		this.strValue = value;
		this.valor = Float.parseFloat(value); 
		
	}
	
	

	@Override
	public boolean verificar(PilhaTabelaDeSimbolos pilha) {
		return true;
	}

	@Override
	public Tipo getTipo() {
		return Tipo.FLOAT;
	}
	
	public String gerarCodigo(String varFinal){
		return (varFinal + " = " + strValue+ "\n");
		
	}
}
