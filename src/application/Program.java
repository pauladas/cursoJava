package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Pega o caminho do csv desejado
		System.out.println("CSV path: ");
		String strPath = sc.nextLine();
		File path = new File(strPath);
		
		// Lista de produtos
		List<Product> products = new ArrayList<>();
		
		// Tenta criar uma pasta chamada out
		boolean success = new File(path.getParent() + "\\out").mkdir();
		
		// Se conseguir criar a pasta
		if (success) {
			
			// Pega o caminho da pasta criada (para escrever mais tarde)
			File outputPath = new File(path.getParent() + "\\out");
			
			// Tenta abrir leitura
			try (BufferedReader br = new BufferedReader(new FileReader(path))) {

				String line = br.readLine();
				String[] csvInfo;
				
				// Enquanto tiver arquivo, percorre
				while (line != null) {
					
					//Separa por virgulas (é um csv, afinal de contas)
					csvInfo = line.split(",");
					
					// Adicionando novos produtos na lista
					products.add(new Product(csvInfo[0], Integer.parseInt(csvInfo[2]), Double.parseDouble(csvInfo[1])));
					line = br.readLine();
				}
				
				// Acabou o arquivo, vai escrever nem um novo na pasta criada
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath + "\\summary.csv"))) {
					
					// Escrevendo no novo arquivo
					for (Product p : products) {
						bw.write(p.toString());
						bw.newLine();
					}
					
					// Tratamento de erro
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				// Tratamento de erro
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		//Caso não consiga criar a pasta
		} else {
			System.out.println("Cannot create output dir.");
		}

		sc.close();
	}
}
