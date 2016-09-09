package tabela_de_simbolos;

import java.util.HashMap;
import java.util.Set;

import arvore.Tipo;

public class PilhaTabelaDeSimbolos {
	private HashMap<String, EntradaDaTabela> tabelaGlobal;
	private HashMap<String, EntradaDaTabela> tabelaLocal;
	private Tipo TipoDoRetornoDaFuncaoAtual;
	private String NomeDaFuncaoAtual;
	
	public PilhaTabelaDeSimbolos(){
		this.tabelaGlobal = new HashMap<String, EntradaDaTabela>();
		this.tabelaLocal = null;
	}
	
	
	public void addTabelaLocal(){
		this.tabelaLocal = new HashMap<String, EntradaDaTabela>();
	}

	
	public void removeTabelaLocal(){
		this.tabelaLocal = null;
	}
		
	public Set<String> getKeySetTabelaGlobal(){
		return tabelaGlobal.keySet();
	}
	
	
	public Tipo getTipoDoRetornoDaFuncaoAtual(){
		return this.TipoDoRetornoDaFuncaoAtual;
	}
	
	public String getNomeDaFuncaoAtual(){
		return this.NomeDaFuncaoAtual;
	}
	
	public EntradaDaTabela get(String id){
		EntradaDaTabela result = null;
		if ((this.tabelaLocal!=null) && (this.tabelaLocal.get(id)!=null)){
			result = this.tabelaLocal.get(id);
		}else{
			result = this.tabelaGlobal.get(id);
		}
		return result;
	}
	
	public boolean jaExisteNoEscopoAtual(String id){
		boolean result = false;
		if (tabelaLocal!=null){
			if (tabelaLocal.get(id)!=null){
				return true;
			}else{
				return false;
			}
		}else{
			if (tabelaGlobal.get(id)!=null){
				return true;
			}else{
				return false;
			}
		}
	}
	
	public boolean jaExisteNoEscopoGlobal(String id){
		if (tabelaGlobal.get(id)!=null){
			return true;
		}else{			
			return false;
		}
	}

	
	public boolean addVariavel(String id, Variavel v){
		if (this.tabelaLocal!=null){
			if(this.jaExisteNoEscopoAtual(id)){
				System.out.println("Variável já foi declarada na pilha");
				return false;
			}
			this.tabelaLocal.put(id, v);
			return true;
		}else{
			if(this.jaExisteNoEscopoAtual(id)){
				System.out.println("Variável já foi declarada na pilha");
				return false;
			}
			this.tabelaGlobal.put(id, v);
			return true;
		}
	}
	
	
	public boolean addFuncao(String id,Funcao f){
		if (this.tabelaLocal!=null){
			if(this.jaExisteNoEscopoAtual(id)){
				System.out.println("Variável já foi declarada na pilha");
				return false;
			}
			this.tabelaLocal.put(id, f);
			return true;
		}else{
			if(this.jaExisteNoEscopoAtual(id)){
				System.out.println("Variável já foi declarada na pilha");
				return false;
			}
			this.tabelaGlobal.put(id, f);
			this.TipoDoRetornoDaFuncaoAtual = f.getTipo();
			this.NomeDaFuncaoAtual = id;
			return true;
		}
	}
	
	
	
	
}
