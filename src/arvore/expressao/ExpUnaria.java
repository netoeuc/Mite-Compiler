package arvore.expressao;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;
import arvore.Tipo;


public class ExpUnaria implements Expressao{
	private Expressao expr;
	private String operacao;
	static int nVariavel = 0;
	
	public ExpUnaria(String operacao,Expressao expr){
		this.operacao = operacao;
		this.expr = expr;
	}
	
	

	@Override
	public boolean verificar(PilhaTabelaDeSimbolos pilha) {
		if ((expr.getTipo()!=Tipo.CHAR && expr.getTipo()!=Tipo.STRING && expr.getTipo()!=Tipo.BOOLEAN) && operacao.equals("-")){
			boolean result = expr.verificar(pilha);
			return result;
		}else{
			System.out.println("Problema com operador unário (Tipo/expressão inválida): "+operacao);
			return false;
		}
	}

	@Override
	public Tipo getTipo() {
		return expr.getTipo();
	}
	
	public String nextVar(){
		ExpUnaria.nVariavel+=1;
		return ("expU"+(ExpUnaria.nVariavel-1));
	}
	
	
	public String gerarCodigo(String varFinal){
		String varU = nextVar();
		String result = expr.gerarCodigo(varU)+"\n";
		
//		String result = operacao+expr.gerarCodigo();
		result+= varFinal+ " = "+operacao+varU;
		return result;
		
	}
	
}
