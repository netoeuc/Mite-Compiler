package arvore.comando;

import java.util.List;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;
import arvore.expressao.ChamadaFunc;
import arvore.expressao.Expressao;

public class ChamadaFuncCmd implements Comando {
	private ChamadaFunc chamadaFunc;
	static int nVariavel;

	public ChamadaFuncCmd(ChamadaFunc ch){
		this.chamadaFunc = ch;
	}

	
	public boolean verificar(PilhaTabelaDeSimbolos pilha){
		boolean result = chamadaFunc.verificar(pilha);
		return result;
	}
	
	public String nextVar(){
		ChamadaFuncCmd.nVariavel+=1;
		return ("chamadaFCmd"+(ChamadaFuncCmd.nVariavel-1));
	}
	
	public String gerarCodigo(){
		String var = nextVar();
		String resultado = "\n"+chamadaFunc.gerarCodigo(var);
		return resultado;
	}

}
