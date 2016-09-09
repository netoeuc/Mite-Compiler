package arvore;

import java.util.HashMap;
import java.util.LinkedList;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;
import tabela_de_simbolos.Variavel;

public class RestoParamFormais {
//	VIRGULA IDENTIFICADOR DOIS_PONTOS tipo resto_param_formais
//	private LinkedList<String> identificador;
//	private LinkedList<Tipo> tipo;
	private HashMap<String, Tipo> restoParamFormais;
	private boolean erroAoAdicionar = false;
	private String variavelErrada;
	
	
//	public RestoParamFormais(LinkedList<String> id, LinkedList<Tipo> tp){
//		this.identificador = id;
//		this.tipo = tp;
//		
//		
//	}
	
	public void addFirst(String id, Tipo tp){
		if (restoParamFormais.get(id)!=null){
//			System.out.println("Variável declarada mais de uma vez: "+id);
			this.erroAoAdicionar = true;
//			System.out.println(this.variavelErrada==null);
//			if (this.variavelErrada==null){
//				this.variavelErrada = id;
//			}
			this.variavelErrada = id;
		}
		this.restoParamFormais.put(id,tp);
//		this.identificador.addFirst(id);
		
//		this.tipo.addFirst(tp);
	}
	
	public RestoParamFormais(){
//		this.identificador = new LinkedList<String>();
//		this.tipo = new LinkedList<Tipo>();
		this.restoParamFormais = new HashMap<String, Tipo>();
		
	}
	
	public HashMap<String, Tipo> getRestoParamFormais(){
		return restoParamFormais;
	}
	
	public boolean verificar(PilhaTabelaDeSimbolos pilha){
		if (this.erroAoAdicionar==true){
			System.out.println("Variável declarada mais de uma vez: "+this.variavelErrada);
			return false;
		}
		for (String key:restoParamFormais.keySet()){
			
			Variavel v = new Variavel(key, restoParamFormais.get(key));
			
//			System.out.println(pilha);
			boolean foi = pilha.addVariavel(key,v);
//			System.out.println(key);
//			System.out.println(foi);
			if (!foi){
				System.out.println("Variável declarada mais de uma vez: "+key);
				return false;
			}
		}
		return true;
		
	}
	
	public String gerarCodigo(){
		String result = "";
		String temp = "";
		int t = 0;
		for(String i:restoParamFormais.keySet()){
			if (t>0){
				temp+=",";
			}
			temp+=i;
			t++;
		}
		result = temp;
		return result;
	}


}
