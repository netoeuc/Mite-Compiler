package arvore.comando;

import java.util.List;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;
import arvore.expressao.Expressao;

public class Atribuicao implements Comando{
	private List<String> listaIdents;
	private Expressao expressao;
	static int nVariavel=0;
	
	public Atribuicao(List<String> list, Expressao ex){
		this.listaIdents = list;
		this.expressao = ex;
	}
	
	public boolean verificar(PilhaTabelaDeSimbolos pilha){
		boolean result = expressao.verificar(pilha);
		if (!result){
			return false;
		}else{
			for (String s:listaIdents){
				if (pilha.get(s)==null){
					System.out.println("Variável não declarada anteriormente: "+s);
					return false;
				}
				if (pilha.get(s).getTipo()!=expressao.getTipo()){
					System.out.println(pilha.get(s).getTipo());
					System.out.println(expressao.getTipo());
					System.out.println("Tipos inválidos na atribuição: "+s);
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	
	public String nextVarAtribuicao(){
		Atribuicao.nVariavel+=1;
		return ("at"+(Atribuicao.nVariavel-1));
	}
	
	
	public String gerarCodigo(){
		
//		String result = "";
//		String temp = "";
//		int t = 0;
//		for(String i:listaIdents){
//			if (t>0){
//				temp+=",";
//			}
//			temp+=i;
//			t++;
//		}
//		result = temp;
//		result+=" = "+expressao.gerarCodigo();
		
		String variavel = this.nextVarAtribuicao();
		String result = expressao.gerarCodigo(variavel)+"\n";
		for(String i:listaIdents){
			result+= i + " = " + variavel + "\n";
		}
		
		
		
		return result;
	}
	
}
