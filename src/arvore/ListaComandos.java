package arvore;

import java.util.LinkedList;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;
import arvore.comando.Comando;

//
public class ListaComandos {
	private LinkedList<Comando> listaDeComandos;
	
	public ListaComandos (){
		this.listaDeComandos = new LinkedList<Comando>();
	}
	
	public void addLast(Comando c){
		this.listaDeComandos.addLast(c);
	}
	
	public boolean verificar(PilhaTabelaDeSimbolos pilha){
		boolean result;
		for (Comando c:listaDeComandos){
			result = c.verificar(pilha);
			if (result==false){
				return false;
			}
		}
		return true;
	}
	
	public void gerarCodigo(){
		
	}

}
