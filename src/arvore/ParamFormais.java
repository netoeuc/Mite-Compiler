package arvore;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;

public class ParamFormais {
	private RestoParamFormais restoParamFormais;
//	IDENTIFICADOR DOIS_PONTOS tipo resto_param_formais
	
	
	public ParamFormais(RestoParamFormais r){
		this.restoParamFormais = r;
	}
	
	public ParamFormais(){
		this.restoParamFormais = new RestoParamFormais();
	}
	
	public RestoParamFormais getRestoParamFormais(){
		return restoParamFormais;
	}
	
	
	public boolean verificar(PilhaTabelaDeSimbolos pilha){
		boolean result = restoParamFormais.verificar(pilha);
		return result;
	}
	
	public String gerarCodigo(){
//		File newTextFile = new File("finalCode.txt");
//		FileWriter fw = new FileWriter(newTextFile,true);
//		fw.write("No meio");
//		fw.close();
		
		String param = restoParamFormais.gerarCodigo();
		return param;
		
	}

}
