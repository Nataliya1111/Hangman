
import java.util.Arrays;
import java.util.List;

public class WordGuessingProcess { 
	private String word;
	private int wordLength;
	private static final char MASKED_LETTER = '_';
	private static final int MAX_MISTAKES = 6;
	
	public WordGuessingProcess(String word) {
		this.word = word;
		this.wordLength = word.length();
	}
	
	public char[] makeEmptyLetters() {
		
		char[] guessedLetters = new char[wordLength];		
	
		for (int i = 0; i < wordLength; i++) {
			guessedLetters[i] = MASKED_LETTER;			
		}		
		return guessedLetters;
	}	
	
	public boolean isInputValid(String letter, char[] guessedLetters, List<String> wrongLetters) {
		if(letter.length()!=1) {
			System.out.println("Необходимо ввести одну букву");
			return false;			
		}
		if((letter.charAt(0)<'А')||(letter.charAt(0)>'Я')) {
			System.out.println("Необходимо ввести букву руссого алфавита");
			return false;
		}
		if(Arrays.toString(guessedLetters).contains(String.valueOf(letter)) || wrongLetters.contains(letter)) {
			System.out.println("Такая буква уже была. Введите другую букву");
			return false;
		}
		return true;
	}
	
	public char[] makeGuessedLetters(char checkingLetter, char[] guessedLetters) {
		
		char[] wordLetters = word.toCharArray();
		
		for (int i = 0; i < wordLength; i++) {
			if (wordLetters[i] == checkingLetter) {
				guessedLetters[i] = wordLetters[i];					
			}					
		}		
		return guessedLetters;
	}

	public GameStatus makeGameStatus(int currentMistakes, char[] guessedLetters) {
		if(currentMistakes == MAX_MISTAKES) {			
			return GameStatus.PLAYER_LOST;
		}
		else if(!String.valueOf(guessedLetters).contains(String.valueOf(MASKED_LETTER))){			
			return GameStatus.PLAYER_WON;
		}
		else {
			return GameStatus.GAME_IS_CONTINUING;
		}
	}

}

