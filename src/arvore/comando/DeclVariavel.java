package arvore.comando;

import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;
import tabela_de_simbolos.Variavel;
import arvore.DeclGlobal;
import arvore.Tipo;


public class DeclVariavel implements Comando, DeclGlobal {
	private LinkedList<String> idents;
	private Tipo tipo;
	
	public DeclVariavel(LinkedList<String> ids, Tipo t) {
		this.idents = ids;
		this.tipo = t;
	}
	
	public boolean verificar(PilhaTabelaDeSimbolos pilha){
		for (String id:idents){
			if (!(pilha.jaExisteNoEscopoAtual(id))){
				Variavel variavel = new Variavel(id, this.tipo);
				
				
				boolean t = pilha.addVariavel(id, variavel);
				if (!t){
					return false;
				}
			}else{
				System.out.println("Variável declarada mais de uma vez: "+id);
				return false;
			}
		}
		return true;
	}
	

	@Override
	public String gerarCodigo() {
		return ""; //As variáveis não são declaradas, apenas utilizadas
		
	}

	
	
	
}
