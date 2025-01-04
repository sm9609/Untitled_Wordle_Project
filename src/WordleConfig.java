import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.Predicate;

public class WordleConfig {
    public enum Guess {
        GREEN,
        YELLOW,
        RED
    }
    /*fields*/

    private final String secretWord;
    private final String[] words;

    static int MAX_MOVES = 6;
    private String[][] grid;
    private final int secretWordLength;
    private int attempts;

    private String currentGuess;
    private String[] correctGuesses;
    private HashMap<Character,Guess> guessedLetters;
    private ArrayList<String> correctLetters;
    private ArrayList<String> wrongLetters;

    /*Constructor*/
    public WordleConfig(String secretWord,String[] words){
        this.secretWord = secretWord;
        this.words = words;
        this.grid = new String[MAX_MOVES][secretWord.length()];
        this.secretWordLength = secretWord.length();
        this.guessedLetters = new HashMap<Character,Guess>();
        this.correctGuesses = new String[secretWordLength];
        this.correctLetters = new ArrayList<String>();
        this.wrongLetters = new ArrayList<String>();

        this.attempts = 0;
    }

    /* Player Function */
    private String tryLetter(char l, int index){
        if(secretWord.charAt(index) == l){
            guessedLetters.put(secretWord.charAt(index),Guess.GREEN);
            correctLetters.add(String.valueOf(l));
        }
        else if(secretWord.contains(String.valueOf(l))){
            guessedLetters.put(secretWord.charAt(index),Guess.YELLOW);
            correctLetters.add(String.valueOf(l));
        }
        else{
            guessedLetters.put(secretWord.charAt(index),Guess.RED);
            wrongLetters.add(String.valueOf(l));
        }
        return String.valueOf(l);
    }

    public Boolean guessWord(String word){
        if(word.length() != secretWordLength){
            return false;
        }else {
            String[] guess = word.split("");
            for (int i = 0; i < secretWordLength; i++) {
               grid[attempts][i] = tryLetter(guess[i].charAt(0),i);
            }
            attempts++;
            return true;
        }
    }

    /*Solver Functions*/
    public boolean isSolution(){
        return (Objects.equals(currentGuess, secretWord));
    }

    public void getPossibleWords(){

        Predicate<String> hasPossibleLetters = str -> {
            if(str.length() != secretWordLength){
                return false;
            }
            for(int i = 0; i < str.length(); i++){
                if(){
                    return false;
                }
            }
            return true;
        };

        if(!Arrays.stream(correctGuesses).allMatch(null)){
            Arrays.stream(words)
                    .filter(hasPossibleLetters);
        }
    }


}
