import java.util.Scanner;

public class Methodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Geef de basis: ");
        int base = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Geef de exponent: ");
        int exponent = Integer.parseInt(scanner.nextLine());
        
        System.out.println(base + " tot de macht " + exponent + " is: " + exponent(base, exponent));   
    }
    
    private static int exponent(int base, int exponent) {
        return (int) Math.pow(base, exponent);
    }
}
