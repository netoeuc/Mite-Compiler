package arvore.expressao;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;
import arvore.Tipo;


public class ExprRelacional implements Expressao {
	
	private Expressao expr1;
	private Expressao expr2;
	private String operador;
	static int nVariavel = 0;
	
	public ExprRelacional(Expressao expr1, Expressao expr2, String operador){
		this.expr1 = expr1;
		this.expr2 = expr2;
		this.operador = operador;
	}
	
	

	@Override
	public boolean verificar(PilhaTabelaDeSimbolos pilha) {
		boolean r1 = expr1.verificar(pilha);
		if (!r1){
//			System.out.println("foi1");
			return false;
		}
		
		boolean r2 = expr2.verificar(pilha);
		if (!r2){
//			System.out.println("foi2");
			return false;
		}
		
		
		if (operador.equals("==") || operador.equals("!=")){
			Tipo a1 = expr1.getTipo();
			Tipo a2 = expr2.getTipo();
			
			if ((a1==a2) && (a1!=Tipo.STRING)){
				return true;
			}else{
				System.out.println("Os operandos da comparação são incopatíveis (expressão relacional)");
//				System.out.println("Tipo epressão 1: " + a1.toString());
//				System.out.println("Tipo epressão 2: " + a2.toString());
				System.out.println(operador);
				return false;
			}
		}else{
			if (operador.equals("<") || operador.equals("<=") || operador.equals(">=") || operador.equals(">")){
				Tipo a1 = expr1.getTipo();
				Tipo a2 = expr2.getTipo();
				
				if ((a1==a2) && (a1!=Tipo.CHAR) && (a1!=Tipo.STRING)){
					return true;
				}else{
					System.out.println("Os operandos da comparação não são iguais ou são de tipos não numéricos (expressão relacional)");
//					System.out.println("Tipo epressão 1: " + a1.toString());
//					System.out.println("Tipo epressão 1: " + expr1.toString());
//					System.out.println("Tipo epressão 2: " + a2.toString());
					System.out.println("Operador: " + operador);
					return false;
				}
			}else{
				System.out.println("Operador (relacional) inválido");
				System.out.println("Operação: " + operador);
				return false;
			}
		}
	}

	@Override
	public Tipo getTipo() {
		return Tipo.BOOLEAN;
		
	}
	
	public String nextVar(){
		ExprRelacional.nVariavel+=1;
		return ("exprRelacional"+(ExprRelacional.nVariavel-1));
	}
	
	public String gerarCodigo(String varFinal){
//		String result = "";
//		result+=expr1.gerarCodigo();
//		result+=operador;
//		result+=expr2.gerarCodigo();
		
		
		
		String result = "";
		String varExpr1 = nextVar();
		String varExpr2 = nextVar();
		result+=expr1.gerarCodigo(varExpr1)+"\n";
//		result+=operador;
		result+=expr2.gerarCodigo(varExpr2)+"\n";
		result+=varFinal +"="+ varExpr1+" "+operador+" "+varExpr2+"\n";
		
		
		
		
		
		return result;
	}

}
	