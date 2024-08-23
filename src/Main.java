
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("ВИСЕЛИЦА\n");
		
		Path dictionaryPath = Path.of("src\\resources\\Dictionary.txt");
		List<String> allDictionaryWords = new ArrayList<>();
		
		try {
			allDictionaryWords = Files.readAllLines(dictionaryPath);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		List<String> words = new ArrayList<>();
		
		for(String word : allDictionaryWords) {
			if (word.length() >= 6) {
				words.add(word);
			};
		}
	
		String wantToPlay;
		
		do {
			System.out.println("Хотите начать новую игру? (введите да/нет)");
			wantToPlay = sc.nextLine().toUpperCase();
		
			while (wantToPlay.equals("ДА")) {
				Random random = new Random();
				String word = words.get(random.nextInt(words.size()));
				Game game = new Game(word);
				game.gameloop();
				wantToPlay = "";
			}	
			
		}while(!(wantToPlay.equals("ДА")||wantToPlay.equals("НЕТ")));

		
		System.out.println("До свидания!");
		
		sc.close();

	}

}
