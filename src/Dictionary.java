import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dictionary {
	
	private final String filename;
	private List<String> listOfWords = new ArrayList<>();
	
	public Dictionary(String filename){
		this.filename = filename;
	}		
	
	public void makeListOfWordsFromFile(String filename){
		
		try {
			InputStream resource = this.getClass().getClassLoader().getResourceAsStream(this.filename);
			if (resource == null) {
				throw new RuntimeException(String.format("File %s is not found", filename));
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(resource));
			for (;;) {
				String line = reader.readLine();
				if (line == null) {
					break;
				}
				if (line.length() > 0) {
					listOfWords.add(line);
				}
			} 
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public String getRandomWord(int minWordLength, int maxWordLength){
		Random random = new Random();
		String word;
		while (true) {
			word = this.listOfWords.get(random.nextInt(this.listOfWords.size()));
			if (word.length() >= minWordLength & word.length() <= maxWordLength)
				break;
		}
		return word;		
	}
}
