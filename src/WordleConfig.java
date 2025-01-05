import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.Predicate;

import java.util.*;

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
    private Character[][] grid;
    private final int secretWordLength;
    private int attempts;

    private String currentGuess;
    private String[] correctGuesses;
    private HashMap<Character,Guess> guessedLetters;
    private Character[] possibleLetters =
            {'a','b','c','d', 'e','f','g','h','i', 'j','k','l','m','n', 'o','p','q','r','s','t', 'u','v','w','x','y','z'};
    private ArrayList<Character> correctLetters;
    private ArrayList<Character> wrongLetters;

    /*Constructor*/
    public WordleConfig(String secretWord,String[] words){
        this.secretWord = secretWord;
        this.words = words;
        this.grid = new Character[MAX_MOVES][secretWord.length()];
        this.secretWordLength = secretWord.length();
        this.guessedLetters = new HashMap<Character,Guess>();
        this.correctGuesses = new String[secretWordLength];
        this.correctLetters = new ArrayList<Character>();
        this.wrongLetters = new ArrayList<Character>();

        this.attempts = 0;
    }

    /* Player Function */
    private Character tryLetter(char l, int index){
        if(secretWord.charAt(index) == l){
            guessedLetters.put(secretWord.charAt(index),Guess.GREEN);
            correctLetters.add(l);
        }
        else if(secretWord.contains(String.valueOf(l))){
            guessedLetters.put(secretWord.charAt(index),Guess.YELLOW);
            correctLetters.add(l);
        }
        else{
            guessedLetters.put(secretWord.charAt(index),Guess.RED);
            wrongLetters.add(l);
        }
        return l;
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
            for(char letter: str.toCharArray()){
                if(Chars){
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
