package arvore;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import tabela_de_simbolos.Funcao;
import tabela_de_simbolos.PilhaTabelaDeSimbolos;
import javafx.util.Pair;
import arvore.comando.Bloco;

public class DeclFuncao implements DeclGlobal {
//	decl_funcao ::= assinatura:s bloco:b
	private Assinatura assinatura;
	private Bloco bloco;
	
	
	public DeclFuncao(Assinatura s, Bloco b){
		this.bloco = b;
		this.assinatura = s;
		
	}
	
	public boolean verificar(PilhaTabelaDeSimbolos pilha){
//		System.out.println("Inicio da "+ assinatura.getIdentificador());
//		System.out.println("");
		Funcao funcao = new Funcao(assinatura, bloco);
		if (!(pilha.jaExisteNoEscopoAtual(assinatura.getIdentificador()))){
			boolean t = pilha.addFuncao(assinatura.getIdentificador(),funcao);
			if (!t){
				return false;
			}
		}else{
			//ERRO
			System.out.println("Função declarada mais de uma vez: "+assinatura.getIdentificador());
			return false;
		}
		
		
		
		
		pilha.addTabelaLocal(); //ajustar metodo addTabel (checar se ja existe)
		boolean result1 = assinatura.verificar(pilha);
		if (result1==false){
			return false;
		}
		boolean result2 = bloco.verificar(pilha);
		if (result2==false){
			return false;
		}
		pilha.removeTabelaLocal();
//		System.out.println("fim da "+ assinatura.getIdentificador());
//		System.out.println("");
		return true;
	}
	
	public String gerarCodigo(){
//		try{
//			String str1 = "def \n"; //++declaracoes.size();
//			File newTextFile = new File("finalCode.txt");
//			FileWriter fw = new FileWriter(newTextFile,true);
//			fw.write(str1);
			
//			fw.write("{\n");
//			bloco.gerarCodigo();
//			fw.write("\n}\n\n");
//			fw.close();
//		}catch (Exception e){
			
//		}
		String str1 = "def "; //++declaracoes.size();
		str1+=assinatura.gerarCodigo();
		str1+="\n";
		str1+=bloco.gerarCodigo();
		str1+=".end function \n\n";
		return str1;
		
	}
	
	
}
