package arvore.comando;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;

public class Bloco implements Comando {
	private LinkedList<Comando> listaDeComandos;
	
	public Bloco() {
		this.listaDeComandos = new LinkedList<Comando>();
	}
	
	public Bloco(LinkedList<Comando> l) {
		this.listaDeComandos = l;
	}
	
	
	public void add(Comando cmd) {
		this.listaDeComandos.add(cmd);
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
	
	
	public String gerarCodigo(){
		String str = "";
		for (Comando c:listaDeComandos){
			str+=c.gerarCodigo()+"\n";
		}
		return str;
		
	}
}
