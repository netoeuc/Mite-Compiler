package arvore.expressao;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;
import arvore.Tipo;


public class ExpAritmetica implements Expressao{

	private Expressao exp1;
	private Expressao exp2;
	private String operacao;
	private Tipo tipo;
	static int nExpressaoAritmetica;
	
	public ExpAritmetica(Expressao exp1,Expressao exp2,String operacao){
		this.exp1 = exp1;
		this.exp2 = exp2;
		this.operacao = operacao;
	}
	
	public boolean verificar(PilhaTabelaDeSimbolos pilha){
		boolean result1 = exp1.verificar(pilha);
		if (result1==false){
			return false;
		}
		
		boolean result2 = exp2.verificar(pilha);
		if (result2==false){
			return false;
		}
		
		
		
		if ( (operacao.equals("+")) || (operacao.equals("-")) || (operacao.contentEquals("*")) || (operacao.contentEquals("/")) || (operacao.contentEquals("%"))){
			
			Tipo A1 = exp1.getTipo();
			if ((A1!=Tipo.CHAR) && (A1!=Tipo.INT) && (A1!=Tipo.FLOAT)){
				System.out.println("Tipo de operandos incompatíveis (expressão aritmética)");
//				System.out.println("Tipo expressao 1: " + exp1.getTipo().toString());
//				System.out.println("Tipo expressao 2: " + exp2.getTipo().toString());
				return false;
			}
			Tipo A2 = exp2.getTipo();
			if ((A2!=Tipo.INT) && (A2!=Tipo.FLOAT)){
				System.out.println("Tipo de operandos incompatíveis (expressão aritmética)");
//				System.out.println("Tipo expressao 1: " + exp1.getTipo().toString());
//				System.out.println("Tipo expressao 2: " + exp2.getTipo().toString());
				return false;
			}
			
			
			if (A1==A2 && (A1==Tipo.FLOAT || A1==Tipo.INT)){
				//continue
				this.tipo = A1;
				return true;
			}else{
				if ( (operacao.equals("+")) || (operacao.equals("-"))){
					if (A1==Tipo.CHAR && A2==Tipo.INT){
						this.tipo = Tipo.CHAR;
						return true;
					}else{
						System.out.println("Tipo de operandos incompatíveis (expressão aritmética)");
//						System.out.println("Tipo expressao 1: " + exp1.getTipo().toString());
//						System.out.println("Tipo expressao 2: " + exp2.getTipo().toString());
						return false;
					}
				}else{
					System.out.println("Operador inválido (expressão aritmética)");
					System.out.println("Operador: " + operacao.toString());
					return false;
				}
			}
						
			
		
		}else{
			System.out.println("Operação inválida: "+operacao);
			return false;
		}
	}

	@Override
	public Tipo getTipo() {
//		if (exp1.getTipo()==Tipo.CHAR){
//			return Tipo.INT;
//		}
//		if (exp1.getTipo()==Tipo.INT){
//			return Tipo.INT;
//		}
//		if (exp1.getTipo()==Tipo.FLOAT){
//			return Tipo.FLOAT;
//		}
//		return null;
		return this.tipo;
	}
	
	public String nextVar(){
		ExpAritmetica.nExpressaoAritmetica+=1;
		return ("expA"+(nExpressaoAritmetica-1));
	}
	
	public String gerarCodigo(String varFinal){
		
//		result+=exp1.gerarCodigo();
//		result+=operacao;
//		result+=exp2.gerarCodigo();
		
		String result = "";
		String varExpr1 = nextVar();
		String varExpr2 = nextVar();
		result+=exp1.gerarCodigo(varExpr1)+"\n";
//		result+=operacao;
		result+=exp2.gerarCodigo(varExpr2)+"\n";
		result+=varFinal+"="+varExpr1+" "+operacao+" "+varExpr2;
		
		return result;
		
	}
}
