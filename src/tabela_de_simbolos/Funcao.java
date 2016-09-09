package tabela_de_simbolos;

import arvore.Assinatura;
import arvore.ParamFormais;
import arvore.RestoParamFormais;
import arvore.Tipo;
import arvore.comando.Bloco;

public class Funcao implements EntradaDaTabela{
	private Tipo tipo;
	private String identificador;
	private ParamFormais paramFormais;
	private Bloco bloco;
	private RestoParamFormais restoParamFormais;
	
	public Funcao(Assinatura assinatura, Bloco bloco){
		this.tipo = assinatura.getTipo();
		this.identificador = assinatura.getIdentificador();
		this.paramFormais = assinatura.getParamFormais();
		this.bloco = bloco;
		this.restoParamFormais = this.paramFormais.getRestoParamFormais();
	}
	
	public String getIdentificador(){
		return identificador;
	}
	
	public String ehVariavelOuFuncao(){
		return "funcao";
	}
	
	public RestoParamFormais getRestoParamFormais(){
		return this.restoParamFormais;
	}
	
	public Tipo getTipo() {
		return tipo;
	}

}
