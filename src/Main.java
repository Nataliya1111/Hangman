
import java.util.Scanner;

public class Main {
	
	private static final String COMMAND_PLAY = "ДА";
	private static final String COMMAND_EXIT = "НЕТ";
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("ВИСЕЛИЦА\n");
		
		String filename = "Dictionary.txt";		
		Dictionary listOfWords = new Dictionary(filename);	
		
		listOfWords.makeListOfWordsFromFile(filename);
	
		String wantToPlay;		
		
		do {
			System.out.printf("Хотите начать новую игру? (введите %s/%s)\n", COMMAND_PLAY,COMMAND_EXIT);
			wantToPlay = sc.nextLine().toUpperCase();
		
			while (wantToPlay.equals(COMMAND_PLAY)) {				
				String word = listOfWords.getRandomWord(6, 12);
				Game game = new Game(word, sc);
				game.loop();
				wantToPlay = "";
			}	
			
		}while(!(wantToPlay.equals(COMMAND_PLAY)||wantToPlay.equals(COMMAND_EXIT)));
		
		System.out.println("До свидания!");
		
		sc.close();

	}
}
