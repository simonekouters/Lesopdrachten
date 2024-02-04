import java.util.Scanner;

public class CaesarsCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Voer een leestekenreeks in (bestaande uit hoofdletters): ");
        String leestekenreeks = scanner.nextLine().toUpperCase();
        
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < leestekenreeks.length(); i++) {
            if (leestekenreeks.charAt(i) == 'X') {
                builder.append("A"); 
            } else if (leestekenreeks.charAt(i) == 'Y') {
                builder.append("B");
            } else if (leestekenreeks.charAt(i) == 'Z') {
                builder.append("C");
            } else {
                char letter = leestekenreeks.charAt(i);
                for (int j = 0; j < alphabet.length; j++) {
                    if (letter == alphabet[j]) {
                        builder.append(alphabet[j + 3]);
                    }
                }
            }      
        } 
        System.out.println("De cijfertekstreeks is: " + builder);                 
    }
}
