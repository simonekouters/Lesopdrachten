import java.util.Scanner;

public class Eindopdracht5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Voer een zin in: ");
        String text = sc.nextLine().toLowerCase().trim();
        
        System.out.println("Aantal karakters: " + countCharacters(text));
        System.out.println("Aantal woorden: " + countWords(text));
        System.out.println("Aantal klinkers: " + countVowels(text));
        System.out.println("Palindroom? " + isPalindrome(text));
        System.out.println();
        printDiagram(text);
        
    }
    
    private static int countCharacters(String text) {
        return text.length();
    }
    
    private static int countWords(String text) {
        String[] words = text.split(" ");
        return words.length;
    }
    
    private static int countVowels(String text) {
        int count = 0;
        
        for (char ch : text.toCharArray()) {
            if (ch == 'a'|| ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y') {
                count++;
            }
        }
        return count;
    }
    
    
    private static boolean isPalindrome(String text) { 
        String textWithoutSpaces = text.replaceAll(" ", "");
        StringBuilder bldr = new StringBuilder(textWithoutSpaces);
        String reversed = bldr.reverse().toString();
        return reversed.equals(textWithoutSpaces);    
    }
    
    private static void printDiagram(String text) {
        char[] characters = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r',
        's','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9', ' '};
        
        for (char c : characters) {
            System.out.print(c + " ");
            for (char ch : text.toCharArray()) {
                if (ch == c) {
                    System.out.print("*");
                }
            }
            System.out.println();
        } 
    }
}

