package arvore;

import java.io.FileWriter;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;

public interface DeclGlobal {
	public boolean verificar(PilhaTabelaDeSimbolos pilha);
	public String gerarCodigo();
}
