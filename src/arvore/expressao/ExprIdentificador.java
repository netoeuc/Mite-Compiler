package arvore.expressao;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;
import arvore.Tipo;

public class ExprIdentificador implements Expressao {
	private String ident;
	private Tipo tipo;
	
	public ExprIdentificador(String id){
		this.ident = id;
		
	}

	public boolean verificar(PilhaTabelaDeSimbolos pilha){
		try{
//			System.out.println("");
//			System.out.println(ident);
//			System.out.println("Ja existe no escopo atual?"+pilha.jaExisteNoEscopoAtual(ident));
//			System.out.println("Ja existe no escopo global?"+pilha.jaExisteNoEscopoGlobal(ident));
			
			tipo = pilha.get(ident).getTipo();
			
			
		}catch (Exception e){
			//ERRO
			System.out.println("Identificador não declarado: "+ident);
			System.out.println(ident);
			return false;
//			tipo = null;
		}
		return true;
	}

	@Override
	public Tipo getTipo() {
		return tipo;
	}
	
	public String gerarCodigo(String varFinal){
		return( varFinal + " = " + ident);
		
	}
}
