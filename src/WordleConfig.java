public class WordleConfig {
    public enum Guess {
        GREEN,
        YELLOW,
        RED
    }

    static int MAX_MOVES = 6;
    private Guess[][] grid;
    private String secretWord;
    private int wordLength;
    private int attempts;

    public WordleConfig(String secretWord){
        this.secretWord = secretWord;
        this.grid = new Guess[MAX_MOVES][secretWord.length()];
        this.wordLength = secretWord.length();
        this.attempts = 0;
    }

    private Guess tryLettter(char l, int index){
        if(secretWord.charAt(index) == l){
            return Guess.GREEN;
        }
        else if(secretWord.contains(String.valueOf(l))){
            return  Guess.YELLOW;
        }
        else{
            return Guess.RED;
        }
    }

    public Boolean guessWord(String word){
        if(word.length() != wordLength){
            return false;
        }else {
            String[] guess = word.split("");
            for (int i = 0; i < wordLength; i++) {
               grid[attempts][i] = tryLettter(guess[i].charAt(0),i);

            }
            return true;
        }
    }


}
