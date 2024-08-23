import java.util.List;

public class Printing {
	
	static void printGuessingWord(char[] guessedLetters) {
		
		System.out.print("Слово: ");
		for (char letter : guessedLetters) {
			System.out.printf(" " + letter);
		}
		System.out.println("");	
	}
	
	static void printWrongLetters(List<String> wrongLetters, int currentMistakes, GameStatus gameStatus) {		
		
		if (!gameStatus.equals(GameStatus.PLAYER_WON)) {
			System.out.printf("Ошибки (%d): %s\n", currentMistakes, String.join(", ", wrongLetters));
		}
	}
	
	static void printGameStatus(GameStatus gameStatus, String word) {
		if(gameStatus.equals(GameStatus.PLAYER_LOST)) {
			System.out.printf("\nВы проиграли!\nЗагаданое слово - %s\n\n", word);
		}
		if(gameStatus.equals(GameStatus.PLAYER_WON)) {
			System.out.println("Слово отгадано!\n");
		}
	}
	
	static void printHangman(int currentMistakes) {
		switch (currentMistakes) {
		case 0: 
			System.out.println("   ____");
			System.out.println("  |   |");
			System.out.println("  |");
			System.out.println("  |");
			System.out.println("  |");
			System.out.println("__|__\n");
			break;
		case 1: 
			System.out.println("   ____");
			System.out.println("  |   |");
			System.out.println("  |   O");
			System.out.println("  |");
			System.out.println("  |");
			System.out.println("__|__\n");
			break;
		case 2: 
			System.out.println("   ____");
			System.out.println("  |   |");
			System.out.println("  |   O");
			System.out.println("  |   |");
			System.out.println("  |");
			System.out.println("__|__\n");
			break;
		case 3: 
			System.out.println("   ____");
			System.out.println("  |   |");
			System.out.println("  |   O");
			System.out.println("  |  -|");
			System.out.println("  |");
			System.out.println("__|__\n");
			break;
		case 4: 
			System.out.println("   ____");
			System.out.println("  |   |");
			System.out.println("  |   O");
			System.out.println("  |  -|-");
			System.out.println("  |");
			System.out.println("__|__\n");
			break;
		case 5: 
			System.out.println("   ____");
			System.out.println("  |   |");
			System.out.println("  |   O");
			System.out.println("  |  -|-");
			System.out.println("  |  /");
			System.out.println("__|__\n");
			break;
		case 6: 
			System.out.println("   ____");
			System.out.println("  |   |");
			System.out.println("  |   O");
			System.out.println("  |  -|-");
			System.out.println("  |  / \\");
			System.out.println("__|__\n");
			break;
		}
	}

}
