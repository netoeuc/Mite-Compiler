package arvore.comando;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;
import arvore.expressao.Expressao;

public class Iteracao implements Comando {
	
	private Expressao expressao;
	private Comando comando;
	static int numeroWhile=0;
	static int nVariavel=0;
	static int nVariavelExpr=0;
	
	public Iteracao(Expressao ex, Comando cmd){
		this.expressao = ex;
		this.comando = cmd;
		Iteracao.numeroWhile+=1;
	}
	
	public boolean verificar(PilhaTabelaDeSimbolos pilha){
		boolean result1 = expressao.verificar(pilha);
		if (result1==false){
			return false;
		}
		boolean result2 = comando.verificar(pilha);
		if (result2==false){
			return false;
		}
		return true;
	}
	
	
	public int nextVar(){
		Iteracao.nVariavel+=1;
		return Iteracao.nVariavel-1;
	}
	
	public String nextVarExpr(){
		Iteracao.nVariavelExpr+=1;
		return ("wh"+(Iteracao.nVariavelExpr-1));
	}
	public String gerarCodigo(){
		String var = "varWhile"+this.nextVar();
		String LWInicio = "LWInicio"+Iteracao.numeroWhile;
		String LWResto = "LWResto"+Iteracao.numeroWhile;
		String varExpr = nextVarExpr();
		String result = expressao.gerarCodigo(varExpr)+"\n";
		result+= var+ " = "+varExpr+"\n";
//		String result = var+ " = "+expressao.gerarCodigo()+"\n";
		result+=LWInicio+"\n";
		result+= "ifFalse "+ var +" goto "+ LWResto+"\n";
		result+=comando.gerarCodigo()+"\n";
		result+="goto "+ LWInicio+"\n";
		result+=LWResto+"\n";
		
		return result;
	}
	
}
