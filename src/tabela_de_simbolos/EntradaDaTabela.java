package tabela_de_simbolos;

import arvore.RestoParamFormais;
import arvore.Tipo;

public interface EntradaDaTabela {
	public Tipo getTipo();
	public String ehVariavelOuFuncao();
	public RestoParamFormais getRestoParamFormais();

}
