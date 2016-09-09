package arvore;

import java.util.LinkedList;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;
import arvore.expressao.Expressao;


//NAO ESTÁ SENDO UTILIZADA

public class RestoListaExpr {
private LinkedList<Expressao> listaDeExpr;
	
	public RestoListaExpr(){
		this.listaDeExpr = new LinkedList<Expressao>();
	}
	
	public void addFirst(Expressao ex){
		this.listaDeExpr.addFirst(ex);
	}
	
	public void addLast(Expressao ex){
		this.listaDeExpr.addLast(ex);
	}
	
	public boolean verificar(PilhaTabelaDeSimbolos pilha){
		boolean result;
		for (Expressao ex:listaDeExpr){
			result = ex.verificar(pilha);
			if (result==false){
				return false;
			}
		}
		return true;
	}
	
	public void gerarCodigo(){
		
	}
	
}
