
import java.util.Arrays;
import java.util.List;

public class WordGuessingProcess { 
	String word;
	int wordLength;
	static final int maxMistakes = 6;
	
	public WordGuessingProcess(String word) {
		this.word = word;
		this.wordLength = word.length();
	}
	
	char[] makeEmptyLetters() {
		
		char[] guessedLetters = new char[wordLength];		
	
		for (int i = 0; i < wordLength; i++) {
			guessedLetters[i] = '_';			
		}		
		return guessedLetters;
	}	
	
	boolean inputIsValid(String letter, char[] guessedLetters, List<String> wrongLetters) {
		if(letter.length()!=1) {
			System.out.println("Необходимо ввести одну букву");
			return false;			
		}
		else if((letter.charAt(0)<(int)'А')||(letter.charAt(0)>(int)'Я')) {
			System.out.println("Необходимо ввести букву руссого алфавита");
			return false;
		}
		else if(Arrays.toString(guessedLetters).contains(String.valueOf(letter)) || wrongLetters.contains(letter)) {
			System.out.println("Такая буква уже была. Введите другую букву");
			return false;
		}
		else {
			return true;
		}
	}
	
	char[] makeGuessedLetters(char checkingLetter, char[] guessedLetters) {
		
		char[] wordLetters = word.toCharArray();
		
		for (int i = 0; i < wordLength; i++) {
			if (wordLetters[i] == checkingLetter) {
				guessedLetters[i] = wordLetters[i];					
			}					
		}		
		return guessedLetters;
	}

	GameStatus makeGameStatus(int currentMistakes, char[] guessedLetters) {
		if(currentMistakes == 6) {			
			return GameStatus.PLAYER_LOST;
		}
		else if(!String.valueOf(guessedLetters).contains("_")){			
			return GameStatus.PLAYER_WON;
		}
		else {
			return GameStatus.GAME_IS_CONTINUING;
		}
	}

}

