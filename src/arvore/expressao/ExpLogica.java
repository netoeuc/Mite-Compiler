package arvore.expressao;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;
import arvore.Tipo;


public class ExpLogica implements Expressao {
	private Expressao exp1;
	private Expressao exp2;
	private String operLogico;
	private boolean result = false;
	static int nVariavel;
	
	
	public ExpLogica(Expressao e1, Expressao e2, String oper){
	this.exp1 = e1;
	this.exp2 = e2;
	this.operLogico = oper;
	}
	
	public boolean verificar(PilhaTabelaDeSimbolos pilha){
		if (operLogico.equals("and") || operLogico.equals("or") || operLogico.equals("not")){
			Tipo a1 = exp1.getTipo();
			Tipo a2 = exp2.getTipo();
			
			if ((a1==a2) && (a1==Tipo.BOOLEAN)){
				return true;
			}else{
				System.out.println("Esperado operadores do tipo BOOLEAN");
				return false;
			}
		}else{
			System.out.println("Operador lógico inválido");
			return false;
		}
		
		
	}

	@Override
	public Tipo getTipo() {
		return Tipo.BOOLEAN;
	}
	
	public String nextVar(){
		ExpLogica.nVariavel+=1;
		return ("expLogica"+(ExpLogica.nVariavel-1));
	}
	
	
	public String gerarCodigo(String varFinal){
//		String result = "";
//		result+=exp1.gerarCodigo();
//		result+=operLogico;
//		result+=exp2.gerarCodigo();
//		return result;
		
		
		
		String result = "";
		String varExpr1 = nextVar();
		String varExpr2 = nextVar();
		
		
		result+=exp1.gerarCodigo(varExpr1)+"\n";
//		result+=operLogico;
		result+=exp2.gerarCodigo(varExpr2) + "\n";
		result+=varFinal+"="+varExpr1 + " "+operLogico+" "+varExpr2;
		return result;
		
	}
	
	
}
