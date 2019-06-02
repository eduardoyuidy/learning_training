package application;

import java.io.File;
import java.util.Scanner;

public class Program04Folders {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		// Buscando uma listagem das pastas que estão no path informado.
		System.out.println("FOLDERS:");
		File[] folders = path.listFiles(File::isDirectory);
		for (File folder : folders) {
			System.out.println(folder);
		}
		
		// Buscando uma listagem dos arquivos que estão no path informado.
		System.out.println("FILES:");
		File[] files = path.listFiles(File::isFile);
		for (File file : files) {
			System.out.println(file);
		}
		
		// Criar uma nova pasta no diretório informado
		boolean success = new File(strPath + "\\subdirectory").mkdir();
		System.out.println("Directory created successfully: " + success);
		
		sc.close();
	}
}
