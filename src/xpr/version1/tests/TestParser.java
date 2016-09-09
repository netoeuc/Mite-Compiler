package xpr.version1.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import java_cup.runtime.Symbol;
import arvore.Programa;
import xpr.version1.Lexer;
import xpr.version1.Parser;


/**
 * Exemplo de integra��o do analisador l�xico gerado pelo JFLex 
 * com o parser gerador pelo CUP.
 * 
 * Este exemplo usa um arquivo como entrada. 
 *
 * Pablo Azevedo Sampaio
 * 14/03/2009
 */

public class TestParser {

	public static void main(String args[]) throws IOException {
		Lexer lexer;
		Parser parser;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String arquivo;
        String nomeDoArquivoDeSaida;
		
		
		if (args.length == 0) {
			System.out.print("Digite o nome do arquivo: ");
			arquivo = in.readLine();
			nomeDoArquivoDeSaida = arquivo+".asm";
		} else {
			arquivo = args[0];
			nomeDoArquivoDeSaida = arquivo+".asm";
		}	
		
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("Digite o nome do arquivo: ");
//        String arquivo = in.readLine();
        System.out.println();
		
		try {
			lexer = new Lexer(new FileInputStream(arquivo));
			parser = new Parser(lexer);
			
			Symbol symbol = parser.parse();
			
			
			Programa TREE = (Programa) symbol.value;
			boolean analiseSemanticaSemProblemas = TREE.verificar();
			
			System.out.println("Sintaxe OK!");
			
			System.out.println("Resultado da interpretacao: ");
//			TREE.interpret();
			
			System.out.println("Árvore" + TREE);
			
			System.out.println(analiseSemanticaSemProblemas);
			if (analiseSemanticaSemProblemas){
//				TREE.gerarCodigo();
				TREE.gerarCodigo(nomeDoArquivoDeSaida);
			}
			
			
			
		
		} catch (Exception e) {
			System.out.println("Erro sint�tico!");
			e.printStackTrace();
		}

	}

}
