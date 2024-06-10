package ui;

import java.util.Scanner;
import com.opencsv.exceptions.CsvException;
import dijkstra.*;
import netdatatypes.*;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;

public class Menu{
	private File file = new File("src/output.txt");
	private FileWriter writer;
	private BufferedWriter wbuffer;
	
	public Menu() {}
	
	public void screen() throws IOException, CsvException {
		Menu control = new Menu();
		Dijkstra algorithm = new Dijkstra();
		int destination = 0;
		Scanner read = new Scanner(System.in);
		List<String> cities = Arrays.asList("Fortaleza", "Recife", "Joao Pessoa", "Aracaju", "Maceio", "Salvador", "Teresina", "Sao Luis", "Belem", "Macapa", "Manaus", "Porto Velho", "Boa Vista", "Rio Branco", "Palmas", "Cuiaba", "Campo Grande", "Goiania", "Brasilia", "Belo Horizonte", "Vitoria", "Sao Paulo", "Rio de Janeiro", "Curitiba", "Florianopolis", "Porto Alegre");
		
		destination = read.nextInt();
	
		if(destination <= 0 || destination >= 27) {
			while(destination <= 0 || destination >= 27) {
				System.out.println("\nValor inválido. Por favor, digite um número de 1 a 26 correspondente à cidade que você quer viajar: ");
				destination = read.nextInt();
			}
		}
		else {
			control.answer(algorithm.algorithm(cities.get(destination-1)), cities.get(destination-1));
		}
	}
	
	public void answer(ArrayList<City> smallest_path, String destination) throws IOException {
		String result = smallest_path.get(0).getName();
		
		for(int i = 1; i < smallest_path.size(); i++){
			result += " - " + smallest_path.get(i).getName();
		}
		System.out.println("-----------------------------------------------------------------------------\n"
				+ "O melhor caminho que nós encontramos para " + destination + " foi: " + result + ".\n");
				
		writer = new FileWriter(file, true);
		wbuffer = new BufferedWriter(writer);
		
		wbuffer.write("O melhor caminho que nós encontramos para " + destination + " foi: " + result + ".\n");
		wbuffer.newLine();
		
		wbuffer.close();
		writer.close();
	}
	
	public static void main(String[] args) throws IOException, CsvException, InterruptedException {
		Menu control = new Menu();
		Scanner read = new Scanner(System.in);
		
		System.out.println("----------------------------------------------------------------------------BEM-VINDO----------------------------------------------------------------------------\n");
		System.out.println("    NORDESTE: | 1. Fortaleza       | 2. Recife         | 3. João Pessoa   | 4. Aracaju          | 5. Maceió     | 6. Salvador    | 7. Teresina | 8. São Luís |\n"
				+ "       NORTE: | 9. Belém           | 10. Macapá        | 11. Manaus       | 12. Porto Velho     | 13. Boa Vista | 14. Rio Branco | 15. Palmas  | ----------- |\n"
				+ "CENTRO-OESTE: | 16. Cuiabá         | 17. Campo Grande  | 18. Goiânia      | 19. Brasília        | ------------- | -------------- | ----------- | ----------- |\n"
				+ "     SUDESTE: | 20. Belo Horizonte | 21. Vitória       | 22. São Paulo    | 23. Rio de Janeiro  | ------------- | -------------- | ----------- | ----------- |\n"
				+ "         SUL: | 24. Curitiba       | 25. Florianópolis | 26. Porto Alegre | ------------------- | ------------- | -------------- | ----------- | ----------- |\n\n"
				+ "Partindo de Natal, para que cidade você quer ir? Digite o número correspondente a ela: ");
		control.screen();
	}
}