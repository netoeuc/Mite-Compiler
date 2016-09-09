package arvore.expressao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;
import arvore.Tipo;

public class ChamadaFunc implements Expressao {
	private String nomeFuncao;
	private List<Expressao> listaExprs;
	private Tipo tipoChamadaFunc;
	static int nVariavel;
	

	public ChamadaFunc(String nome, List<Expressao> list){
		this.nomeFuncao = nome;
		this.listaExprs = list;
	}

	public boolean verificar(PilhaTabelaDeSimbolos pilha){
		try{
//			System.out.println(nomeFuncao);
//			System.out.println("Ja existe no escopo atual?"+pilha.jaExisteNoEscopoAtual(nomeFuncao));
//			System.out.println("Ja existe no escopo global?"+pilha.jaExisteNoEscopoGlobal(nomeFuncao));
			tipoChamadaFunc = pilha.get(nomeFuncao).getTipo();
		} catch (Exception e){
			//ERRO
			System.out.println("Função não declarada ou utilizada antes da declaração: "+nomeFuncao);
			System.out.println("");
			return false;
//			tipoChamadaFunc = null;
		}
		
		HashMap<String, Tipo> parametros = pilha.get(nomeFuncao).getRestoParamFormais().getRestoParamFormais();
		ArrayList<Tipo> listaDeEntradasEsperadas = new ArrayList<Tipo>();
		for (String key:parametros.keySet()){
			listaDeEntradasEsperadas.add(parametros.get(key));
		}
		boolean result;
		ArrayList<Tipo> listaDeEntradasFornecidas = new ArrayList<Tipo>();
		for (Expressao ex:listaExprs){
			result = ex.verificar(pilha);
			if (result==false){
				return false;
			}
			listaDeEntradasFornecidas.add(ex.getTipo());
		}
		if (!(listaDeEntradasEsperadas.size()==listaDeEntradasFornecidas.size())){
			System.out.println("Quantidade de parâmetros fornecidos é diferente da esperada: "+nomeFuncao);
			return false;
		}
		if (!listaDeEntradasEsperadas.equals(listaDeEntradasFornecidas)){
//			System.out.println(listaDeEntradasFornecidas);
			System.out.println("Tipo(s) dos parâmetros fornecidos é(são) diferente(s) do esperado: "+nomeFuncao);
			return false;
		}
		return true;
	}

	@Override
	public Tipo getTipo() {
		return tipoChamadaFunc;
	}
	
	
	public String nextVar(){
		ChamadaFunc.nVariavel+=1;
		return ("chamadaf" + (ChamadaFunc.nVariavel-1));
	}
	
	public String gerarCodigo(String varFinal){
//		String result = "";
//		for(Expressao i:listaExprs){
//			result+="param "+i.gerarCodigo()+"\n";
//		}
//		result+="call "+nomeFuncao+"\n";
		
		String result = "";
		String var;
		ArrayList<String> listaVar = new ArrayList();
		for(Expressao i:listaExprs){
			var = nextVar();
			result+=i.gerarCodigo(var)+"\n";
			listaVar.add(var);
		}
		//for1
//		for(String i:listaVar){
//			result+="param "+ i + "\n";
//		}
		
		//for2
		String param = "";
		int it = 0;
		for(String i:listaVar){
			if (it==0){
				param+=i;
			}else{
				param+=","+i;
				
			}
			it++;
		}
		
		//for1
//		result+=varFinal + " = " + "call "+nomeFuncao+"\n"+"//Como conversamos, nao haverá \"call\", mas os parametros serão passados como 'param'";
		
		//for2
		result+=varFinal + " = " + nomeFuncao+"("+param+")"+" //Como conversamos, neste caso, nao haverá \"call\", os parâmetros serão passados"+"\n";
				
		
		
		return result;
		
	}
	
}
