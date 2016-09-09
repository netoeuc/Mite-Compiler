package arvore;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import tabela_de_simbolos.PilhaTabelaDeSimbolos;

public class Programa {
	private List<DeclGlobal> declaracoes;
	private PilhaTabelaDeSimbolos pilhaTabelaDeSimbolos;
	
	
	public Programa() {
		declaracoes = new ArrayList<>();
		pilhaTabelaDeSimbolos = new PilhaTabelaDeSimbolos();
	}
	
	public void add(DeclGlobal dec) {
		this.declaracoes.add(dec);
	}
	
	public boolean verificar(){
		boolean result;
		
		
		
//		int i = 0;
		for (DeclGlobal declaracao:declaracoes){
//			System.out.println(i+1);
//			i++;
			result = declaracao.verificar(pilhaTabelaDeSimbolos);
			if (result==false){
				System.out.println();
				System.out.println("----------------------");
				System.out.println("Problema na semântica");
				System.out.println("----------------------");
				System.out.println();
				return false;
			}
		}
		System.out.println();
		System.out.println("----------------------");
		System.out.println("Semântica OK!");
		System.out.println("----------------------");
		System.out.println();
		return true;
	}

	public void gerarCodigo(String nomeDoArquivo){
//		File newTextFile = new File("finalCode.txt");
		File newTextFile = new File(nomeDoArquivo);
		try {
//            String str = ".class public TestPrint\n.super java/lang/Object\n\n.method public <init>()V\n\taload_0\n\tinvokenonvirtual java/lang/Object/<init>()V\n\treturn\n.end method\n\n";
            String str = "";

            FileWriter fFirst = new FileWriter(newTextFile);
            fFirst.write(str);
            fFirst.close();

            
            
            

        } catch (IOException iox) {
            //do stuff with exception
            iox.printStackTrace();
        }
		
//		FileWriter fw = new FileWriter(newTextFile,true);
		try{
//			String str = "\n\t.limit locals "+declaracoes.size();
//			File newTextFile = new File("finalCode.txt");
			FileWriter fw = new FileWriter(newTextFile,true);
//			fw.write(str);
			String code = "";
			for (DeclGlobal declaracao:declaracoes){
				code+=declaracao.gerarCodigo();
			}
			fw.write(code);
			fw.close();
		}catch (Exception e){
			
		}
//		try {
////            String str = "\n\n\n.end method";
//            
//
////            FileWriter fw = new FileWriter(newTextFile,true);
////            fw.write(str);
////            fw.close();
//
//        } catch (IOException iox) {
//            //do stuff with exception
//            iox.printStackTrace();
//        }
	
		
	}
	
}
