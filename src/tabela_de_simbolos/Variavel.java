package tabela_de_simbolos;

import arvore.RestoParamFormais;
import arvore.Tipo;

public class Variavel implements EntradaDaTabela{
	private Tipo tipo;
	private String identificador;
	
	public Variavel(String id, Tipo tp){
		this.tipo = tp;
		this.identificador = id;
		
	}

	
	public String ehVariavelOuFuncao(){
		return "variavel";
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	
	
	public RestoParamFormais getRestoParamFormais(){
		return null;
	}

}
