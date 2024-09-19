import java.util.List;

public class Printing {
	
	public static void printGuessingWord(char[] guessedLetters) {
		
		System.out.print("Слово: ");
		for (char letter : guessedLetters) {
			System.out.printf(" " + letter);
		}
		System.out.println("");	
	}
	
	public static void printWrongLetters(List<String> wrongLetters, int currentMistakes, GameStatus gameStatus) {		
		
		if (!gameStatus.equals(GameStatus.PLAYER_WON)) {
			System.out.printf("Ошибки (%d): %s\n", currentMistakes, String.join(", ", wrongLetters));
		}
	}
	
	public static void printGameStatus(GameStatus gameStatus, String word) {
		if(gameStatus.equals(GameStatus.PLAYER_LOST)) {
			System.out.printf("\nВы проиграли!\nЗагаданое слово - %s\n\n", word);
		}
		if(gameStatus.equals(GameStatus.PLAYER_WON)) {
			System.out.println("Слово отгадано!\n");
		}
	}
	
	public static void printHangman(int currentMistakes) {
		
		final String[] pictureOfHangman = {
						                "    +---+\n" +
						                "    |   |\n" +
						                "    |\n" +
						                "    |\n" +
						                "    |\n" +
						                "    |\n" +
						                "    --------",
						
						                "    +---+\n" +
						                "    |   |\n" +
						                "    |   O\n" +
						                "    |\n" +
						                "    |\n" +
						                "    |\n" +
						                "    --------",
						
						                "    +---+\n" +
						                "    |   |\n" +
						                "    |   O\n" +
						                "    |   |\n" +
						                "    |\n" +
						                "    |\n" +
						                "    --------",
						
						                "    +---+\n" +
						                "    |   |\n" +
						                "    |   O\n" +
						                "    |  /|\n" +
						                "    |\n" +
						                "    |\n" +
						                "    --------",
						
						                "    +---+\n" +
						                "    |   |\n" +
						                "    |   O\n" +
						                "    |  /|\\\n" +
						                "    |\n" +
						                "    |\n" +
						                "    --------",
						
						                "    +---+\n" +
						                "    |   |\n" +
						                "    |   O\n" +
						                "    |  /|\\\n" +
						                "    |  /\n" +
						                "    |\n" +
						                "    --------",
						
						                "    +---+\n" +
						                "    |   |\n" +
						                "    |   O\n" +
						                "    |  /|\\\n" +
						                "    |  / \\\n" +
						                "    |\n" +
						                "    --------" };
		
		System.out.println(pictureOfHangman[currentMistakes]);

	}

}
