package arvore.comando;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;
import arvore.Tipo;
import arvore.expressao.Expressao;

public class Retorno implements Comando {
	private Expressao expressao;
	static int nVariavel;
	

	public Retorno(Expressao expr) {
		this.expressao = expr;
	}
	
	
	
	public boolean verificar(PilhaTabelaDeSimbolos pilha){
		String nomeDaFuncao = null;
		Tipo tipoDaFuncao = null;
		boolean result = expressao.verificar(pilha);
		if (!result){
			return false;
		}else{
//			for (String key:pilha.getKeySetTabelaGlobal()){
//				if (pilha.get(key).ehVariavelOuFuncao()=="funcao"){
//					nomeDaFuncao = key;
//				}
			nomeDaFuncao = pilha.getNomeDaFuncaoAtual();
			tipoDaFuncao = pilha.getTipoDoRetornoDaFuncaoAtual();
				
			}
			if (nomeDaFuncao==null){
				System.out.println("Erro ao utilizar funcao, classe RETORNO");
				return false;
			}
//			if (expressao.getTipo()!=pilha.get(nomeDaFuncao).getTipo()){
			if (expressao.getTipo()!=tipoDaFuncao){
				System.out.println("Retorno da função diferente do informado na delaração: "+nomeDaFuncao);
				return false;
			}
		
		
		return true;
	}
	
	public String nextVar(){
		Retorno.nVariavel+=1;
		return ("rt"+(Retorno.nVariavel-1));
	}
	
	public String gerarCodigo(){
		String var = nextVar();
		String resultado = expressao.gerarCodigo(var);
//		String resultado = "return "+expressao.gerarCodigo();
		resultado = "return "+var+"\n";
		return resultado;
	}
	
}
