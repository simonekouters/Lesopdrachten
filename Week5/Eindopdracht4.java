import java.util.Scanner;
import java.util.ArrayList;

public class Eindopdracht4 {
    private static Scanner scanner;
    private static ArrayList<Character> guessedLetters;
    private static String word;
    private static boolean isGuessed;
    private static int wrongCount;
    private static int numberOfGuesses;
    
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.print("Player1, enter a word: ");
        word = scanner.nextLine().trim();
        
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
        
        guessedLetters = new ArrayList<>();
        isGuessed = true;
        
        while (true) {
            printWord();
            guessLetter();
            printHangman(wrongCount);
            
            if (isGuessed) {
                System.out.println("\nYou guessed the word! You win!");
                break;
            }
            
            if (wrongCount == 8) {
                System.out.println("\n You're dead!");
                break;
            }
           
            if (numberOfGuesses == 10) {
                System.out.print("\nYou are out of guesses. Can you guess the word? ");
                String guess = scanner.nextLine();
        
                if (guess.equals(word)) {
                    System.out.println("You guessed the word. You win!");
                } else {
                    System.out.println("That's not correct. You lose.");
                }
                break;
            }
        }
    }
    
    private static void guessLetter() {
        System.out.print("\n\nPlayer2, guess a letter: ");
        char letter = scanner.nextLine().charAt(0);
            
        if (!guessedLetters.contains(letter)) {
            guessedLetters.add(letter);
            if (!wordContainsLetter(letter)) {
                wrongCount++;
            }
        }
        numberOfGuesses++;
    }
    
    private static boolean wordContainsLetter(char letter) {
        for (char c : word.toCharArray()) {
            if (c == letter) {
                return true;
            }                
        }
        return false;
    }
    
    private static void printWord() {
        for (int i = 0; i < word.length(); i++) {
            if (guessedLetters.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
            } else {
                System.out.print("_");
                isGuessed = false;
            }
        }
    }
    
    private static void printHangman(int wrongCount) {
        if (wrongCount >= 1) {
            System.out.println(" -------");
        }     
        if (wrongCount >= 2) {
            System.out.println(" |     |");
        }
          
        if (wrongCount >= 3) {
            System.out.println(" O");
        }
    
        if (wrongCount >= 4) {
            System.out.print("\\ ");
            if (wrongCount >= 5) {
                System.out.println("/");
            } else {
                System.out.println("");
            }   
        }
    
        if (wrongCount >= 6) {
            System.out.println(" |");
        }
    
        if (wrongCount >= 7) {
            System.out.print("/ ");
            if (wrongCount >= 8) {
                System.out.println("\\");
            } else {
                System.out.println("");
            }
        }
        System.out.println();
    }
}