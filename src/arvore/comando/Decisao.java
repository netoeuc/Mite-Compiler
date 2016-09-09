package arvore.comando;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;
import arvore.Tipo;
import arvore.expressao.Expressao;

public class Decisao implements Comando {
	private Expressao expressao;
	private Comando comandoIf;
	private Comando comandoElse;
	static int numeroIf=0;
	static int nVariavel = 0;
	static int nVariavelExp = 0;

	/**
	 * Construtor para if-else completo. 
	 */
	public Decisao(Expressao expr, Comando cmdIf, Comando cmdElse) {
		this.expressao = expr;
		this.comandoIf = cmdIf;
		this.comandoElse = cmdElse;
		Decisao.numeroIf+=1;
	}

	/**
	 * Construtor para if sem else. 
	 */
	public Decisao(Expressao expr, Comando cmdIf) {
		this.expressao = expr;
		this.comandoIf = cmdIf;
		this.comandoElse = null;
		Decisao.numeroIf+=1;
	}

	public boolean verificar(PilhaTabelaDeSimbolos pilha){
		boolean result1 = expressao.verificar(pilha);
		if (result1==false ){
//			System.out.println("O valo...");
			return false;
		}
		if (expressao.getTipo()!=Tipo.BOOLEAN){
			System.out.println("O Tipo da expressão é diferente de boolean (comando if)");
			return false;
		}
		boolean result2 = comandoIf.verificar(pilha);
		if (result2==false){
//			System.out.println("O valor...");
			return false;
		}
		if (comandoElse!=null){
			boolean result3 = comandoElse.verificar(pilha);
			if (result3==false){
//				System.out.println("O valor...");
				return false;
			}
		}
		return true;
	}
	
	public int nextVar(){
		Decisao.nVariavel+=1;
		return Decisao.nVariavel-1;
	}
	
	public String nextVarRetornoExpr(){
		Decisao.nVariavelExp+=1;
		return ("dec"+(Decisao.nVariavelExp-1));
	}
	
	public String gerarCodigo(){
		String var = "varIf"+this.nextVar();
		String LElse = "LElse"+Decisao.numeroIf;
		String LDepois = "LDepois"+Decisao.numeroIf;
		
		String varExpr =nextVarRetornoExpr(); 
		String result = expressao.gerarCodigo(varExpr)+"\n";
//		String result = var+ " = "+expressao.gerarCodigo()+"\n";
		result+= var+ " = "+varExpr+"\n";
		result+= "ifFalse "+ var +" goto "+ LElse+"\n";
		result+=comandoIf.gerarCodigo()+"\n";
		result+="goto "+ LDepois+"\n";
		result+=LElse+"\n";
		
		if (comandoElse==null){
			result+="\n";
		}else{
			result+=comandoElse.gerarCodigo()+"\n";
		}
		
		result+=LDepois+"\n";
		
		
		
		
		return result;
	}
	
}
