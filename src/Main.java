import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            File File = new File("data/5LetterWords");
            System.out.println("File Found");

            BufferedReader reader = new BufferedReader(new FileReader(File));
            String[] words = (String[]) reader.lines().toArray();
            String secretWord = words[(int)(Math.random()+words.length)];
            WordleConfig game = new WordleConfig(secretWord,words);
        }catch (IOException e){
            throw e;
        }
    }
}