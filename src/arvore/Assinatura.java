package arvore;

import java.io.File;
import java.io.FileWriter;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;

public class Assinatura {
	//KEY_DEF IDENTIFICADOR ABRE_PAR param_formais 
	private String identificador;
	private ParamFormais paramFormais;
	private Tipo tipo;
	
	public Assinatura(String id, ParamFormais param, Tipo tp){
		this.identificador = id;
		this.paramFormais = param;
		this.tipo = tp;
		
	}
	
	public Assinatura(String id, ParamFormais param){
		this.identificador = id;
		this.paramFormais = param;
	}
	
	public String getIdentificador(){
		return this.identificador;
	}
	public ParamFormais getParamFormais() {
		return paramFormais;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public boolean verificar(PilhaTabelaDeSimbolos pilha){
		boolean result =  paramFormais.verificar(pilha);
		return result;
		
	}
	
	public String gerarCodigo(){
//		try{
//			File newTextFile = new File("finalCode.txt");
//			FileWriter fw = new FileWriter(newTextFile,true);
//			fw.write("\b"+identificador+"(");
//			paramFormais.gerarCodigo();
//			fw.write("): "+tipo);
//			fw.close();
//		}catch (Exception e){
//			
//		}
		
		String retorno = "";
		retorno+=identificador+"(";
		retorno+=paramFormais.gerarCodigo();
		retorno+=")\n";
		return retorno;
		
	}
	
	
}
