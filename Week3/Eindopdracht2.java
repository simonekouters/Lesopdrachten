import java.util.Scanner;

public class Eindopdracht2 {
    public static void main(String[] args) {
        int number = askNumber();
        
        int unevenSum = calculateSumOfUnevenNumbers(number);
        System.out.println("\nSom van oneven getallen tot en met " + number + " is " + unevenSum);
        
        int evenSum = calculateSumOfEvenNumbers(number);
        System.out.println("Som van even getallen tot en met " + number + " is " + evenSum);
        
        int difference = unevenSum - evenSum;
        System.out.println("Verschil tussen twee sommen is: " + difference);    
    }
    
    private static int askNumber() {
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.print("Geef een geheel positief getal: ");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                scanner.nextLine();
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Error: dat is geen positief getal.");
                }
            } else {
                scanner.nextLine();
                System.out.println("Error: dat is geen geheel getal.");
            }
        } while (true);
    }
    
    
    private static int calculateSumOfEvenNumbers (int number) {
        int sum = 0;
        
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0)
            sum += i;
        }
        return sum;
    }
    
    
    private static int calculateSumOfUnevenNumbers (int number) {
        int sum = 0;
        
        for (int i = 1; i <= number; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        return sum;
    }
}