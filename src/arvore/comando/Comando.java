package arvore.comando;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;

public interface Comando {
	public boolean verificar(PilhaTabelaDeSimbolos pilha);
	public String gerarCodigo();
		
	
	

}
