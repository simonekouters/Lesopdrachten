import java.util.Scanner;
import java.util.LinkedHashMap;

public class Eindopdracht5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Voer een zin in: ");
        String text = sc.nextLine().toLowerCase().trim();
        
        System.out.println("Aantal karakters: " + countCharacters(text));
        System.out.println("Aantal woorden: " + countWords(text));
        System.out.println("Aantal klinkers: " + countVowels(text));
        System.out.println("Palindroom? " + isPalindrome(text));
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
        LinkedHashMap<Character, Integer> charactersToPrint = createCharacterMap(text);
        int maxHeight = maxHeight(charactersToPrint);
        
        StringBuilder builder = new StringBuilder();
        
        for (int i = maxHeight; i > 0; i--) {
            for (Integer charCount : charactersToPrint.values()) {
                if (i <= charCount) {
                    builder.append("* ");
                } else {
                    builder.append("  ");
                }
            }
            builder.append("\n");
        }
        System.out.print("\n" + builder);
        
        for (Character ch : charactersToPrint.keySet()) {
            System.out.print(ch + " ");
        }
    }
    
    private static LinkedHashMap<Character, Integer> createCharacterMap(String text) {
        LinkedHashMap<Character, Integer> charactersToPrint = new LinkedHashMap<>();
        saveCharacterCounts(97, 123, charactersToPrint, text);
        saveCharacterCounts(48, 58, charactersToPrint, text);
        charactersToPrint.put(' ', countSpaces(text));
        return charactersToPrint;
    }
    
    private static void saveCharacterCounts(int from, int to, LinkedHashMap<Character, Integer> charactersToPrint, String text) {
        for (int i = from; i < to; i++) { 
            int count = 0; 
            for (char ch : text.toCharArray()) {
                if (ch == (char)i) {
                    count++;
                }  
                charactersToPrint.put((char) i, count);
            }
        }   
    }
    
    private static int maxHeight(LinkedHashMap<Character, Integer> charactersToPrint) {
       int max = 0;
       for (Integer charCount : charactersToPrint.values()) {
            if (charCount > max) {
                max = charCount;
            }
        }
        return max;
    }
    
    private static int countSpaces(String text) {
        int count = 0;
        for (char ch : text.toCharArray()) {
            if (ch == ' ') {
                count++;
            }
        }
        return count;
    }
}

