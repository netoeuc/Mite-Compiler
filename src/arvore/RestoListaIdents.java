package arvore;

import java.util.LinkedList;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;




public class RestoListaIdents {
	private LinkedList<String> restoListaIdents;
	
	public RestoListaIdents(){
		this.restoListaIdents = new LinkedList<String>();
		
	}
	
	public void addFirst(String id){
		this.restoListaIdents.addFirst(id);
	}

	public boolean verificar(PilhaTabelaDeSimbolos pilha){
		return true;
		
	}
	
	public void gerarCodigo(){
		
	}
	
}
