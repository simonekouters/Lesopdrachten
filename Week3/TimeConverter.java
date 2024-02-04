import java.util.Scanner;

public class TimeConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Jaren: ");
        int jaren = Integer.parseInt(scanner.nextLine();
        
        System.out.print("Maanden: ");
        int maanden = Integer.parseInt(scanner.nextLine();
        
        System.out.print("Weken: ");
        int weken = Integer.parseInt(scanner.nextLine();
        
        System.out.print("Dagen: ");
        int dagen = Integer.parseInt(scanner.nextLine();
        
        System.out.print("Uren: ");
        int uren = Integer.parseInt(scanner.nextLine();
        
        long minuten = + jaren * 365 * 24 * 60 + maanden * 30 * 24 * 60 
        + weken * 7 * 24 * 60 + dagen * 24 * 60 + uren * 60;
        
        System.out.println("Het totaal aantal minuten is: " + minuten;
           
    }
}