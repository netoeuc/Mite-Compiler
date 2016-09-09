package arvore.expressao;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;
import arvore.Tipo;

public interface Expressao {
	public boolean verificar(PilhaTabelaDeSimbolos pilha);
	public Tipo getTipo();
	public String gerarCodigo(String varFinal);
		
}
