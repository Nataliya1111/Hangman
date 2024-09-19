
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Game {
	
	private final String word;
	private Scanner sc;
	private final WordGuessingProcess guessing;
	private int currentMistakes;
	private char[] guessedLetters;
	private List<String> wrongLetters = new ArrayList<>();
	private GameStatus gameStatus;
	
	public Game(String word, Scanner sc){
		this.word = word.toUpperCase();
		this.sc = sc;
		this.guessing = new WordGuessingProcess(this.word);
		this.guessedLetters = guessing.makeEmptyLetters();
	}	
	
	public void loop() {

		Printing.printHangman(currentMistakes); 
		System.out.printf("Необходимо отгадать слово из %d букв\n", word.length());
		Printing.printGuessingWord(guessedLetters);
		
		do {
			System.out.println("\nВведите букву");
			String inputLetter;
			
			do {				
				inputLetter = sc.nextLine().toUpperCase();						
			} while (isInputNotValid(inputLetter));
			
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
	
	private boolean isInputNotValid(String inputLetter) {
		return !guessing.isInputValid(inputLetter, guessedLetters, wrongLetters);
	}

}
