
import java.util.List;
import java.util.ArrayList;

public class Game {
	
	String word;
	
	Game(String word){
		this.word = word.toUpperCase();
	}
	
	
	void gameloop() {
		
		WordGuessingProcess guessing = new WordGuessingProcess(this.word);	
		int currentMistakes = 0;		
		char[] guessedLetters = guessing.makeEmptyLetters();
		List<String> wrongLetters = new ArrayList<>();
		GameStatus gameStatus;

		Printing.printHangman(currentMistakes); 
		System.out.printf("Необходимо отгадать слово из %d букв\n", word.length());
		Printing.printGuessingWord(guessedLetters);
		
		do {
			System.out.println("\nВведите букву");
			String inputLetter;
			
			do {				
				inputLetter = Main.sc.nextLine().toUpperCase();						
			} while (!guessing.inputIsValid(inputLetter, guessedLetters, wrongLetters));
			
			char checkingLetter = inputLetter.charAt(0);
			
			if (this.word.contains(String.valueOf(checkingLetter))) {
				guessedLetters = guessing.makeGuessedLetters(checkingLetter, guessedLetters);
				System.out.println("Есть такая буква!");

			} else {
				currentMistakes++;
				wrongLetters.add(String.valueOf(checkingLetter));
				System.out.println("Такой буквы нет!");
			}
			
			gameStatus = guessing.makeGameStatus(currentMistakes, guessedLetters);
			
			Printing.printHangman(currentMistakes);
			Printing.printGuessingWord(guessedLetters);
			Printing.printWrongLetters(wrongLetters, currentMistakes, gameStatus);
			
		} while(gameStatus.equals(GameStatus.GAME_IS_CONTINUING));	
		
		Printing.printGameStatus(gameStatus, this.word);
		
	}	

}
