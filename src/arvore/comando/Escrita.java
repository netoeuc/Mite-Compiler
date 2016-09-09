package arvore.comando;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;
import arvore.expressao.Expressao;

public class Escrita implements Comando {
	private Expressao expressao;
	static int nVariavel = 0;

	public Escrita(Expressao ex){
		this.expressao = ex;
	}
	
	public boolean verificar(PilhaTabelaDeSimbolos pilha){
		boolean result = expressao.verificar(pilha);
		return result;
	}
	
	public String nextVar(){
		Escrita.nVariavel+=1;
		return ("esc"+(Escrita.nVariavel-1));
	}
	
	public String gerarCodigo(){
		String str = "";
		String var = nextVar();
		str+=expressao.gerarCodigo(var)+"\n";
//		str+="param "+expressao.gerarCodigo()+"\n";
		str+="param "+var+"\n";
		str+="call "+"print"+"\n";
		return str;
	}
}
