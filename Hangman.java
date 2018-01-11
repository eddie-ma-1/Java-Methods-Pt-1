import java.util.Scanner;

public class Hangman
{

    // Prints 50 blank lines to the screen essentially "clearing" the console window
    public static void clearScreen()
    {
      for (int i =0; i<50; i++){
        System.out.println("");
      }
    
    }

    // asks the user for a starting word
    public static String getWord()
    {
      Scanner sc = new Scanner(System.in);
      String word = sc.nextLine();
      return word;
    }

    // asks the user for a guess letter using a Scanner
    public static String getLetter()
    {
      Scanner sc = new Scanner(System.in);
      String letter = sc.nextLine();
      return letter;
    }

    // replaces the dashes in guessedWord with any occurences of the guessedLetter in the answerWord
    // and returns a new version of the guessedWord
    //
    //  As an example, suppose the answer word is "mississippi" and the guessed word thus far is "--ss-ss----"
    //  If the guessed letter was "i" the String "-ississi--i" would be returned
    public static String revealLetters( String answerWord, StringBuffer guessedWord, String guessedLetter )
    {
      int wordLength = answerWord.length();
      for (int i = 0; i< wordLength; i++){
        if (answerWord.charAt(i) == guessedLetter.charAt(0)){
          guessedWord.setCharAt(i,guessedLetter.charAt(0));
        }
        
    }
      return guessedWord.toString();
      
    }

    // returns true none of the characters in the String word are dashes (-), otherwise returns false
    public static boolean wordGuessed( String word )
    {
      if(word.contains("-")){
        return false;
      }
      else{
        return true;
      }
    }
    
    public static void main(String[] args){
      String ans = getWord();
      String guess = "";
      for (int i = 0; i< ans.length(); i++){
        guess += "-";
      }
      
      int badGuesses = 0;
      while (wordGuessed(guess) == false ){
        String guessLet = getLetter();
        StringBuffer newGuess = new StringBuffer(guess);
        String correctGuess = guess;
        if (ans.contains(guessLet) && guess.contains(guessLet) == false){
          correctGuess = revealLetters(ans, newGuess, guessLet);
          System.out.println(correctGuess);
        }
        else{
          badGuesses += 1;
          System.out.println("Sorry the answer does not contain " + guessLet + ", please try again");
        }
        guess = correctGuess;
        
        if (badGuesses >5){
          break;
        }
      }
      if (badGuesses <6){
        System.out.println("You win");
      }
      else{
        System.out.println("You lose");
      }
        

    
}
}















