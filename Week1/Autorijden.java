import java.util.Scanner;

public class Autorijden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        boolean heeftRijbewijs;
        int leeftijd;
        
        System.out.print("Leeftijd: ");
        leeftijd = Integer.valueOf(scanner.nextLine()); 
        System.out.print("Rijbewijs (ja/nee): ");
        String rijbewijs = scanner.nextLine();
        if (rijbewijs.equals("ja")) {
            heeftRijbewijs = true;
        } else {
            heeftRijbewijs = false;
        }
    
        if (leeftijd > 18 && heeftRijbewijs) {
            System.out.println("Je mag rijden.");
        } else if (leeftijd < 18 && heeftRijbewijs) {
            System.out.println("Je mag rijden onder begeleiding.");
        } else {
            System.out.println("Je mag niet rijden.");
        }
    
    }
}