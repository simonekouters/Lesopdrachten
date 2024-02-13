import java.util.Scanner;
import java.util.Arrays;

public class PrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfItems = askNumber("Voer het aantal items in", scanner);
        int[] array = new int[numberOfItems];
        
        for (int i = 0; i < array.length; i++) {
            array[i] = askNumber("Voer een geheel positief getal in", scanner);
        }
        printArray(array);
    }
    
    private static int askNumber(String text, Scanner scanner) {
        do {
            System.out.print(text + ": ");
            if (scanner.hasNextInt()) {
                int number = Integer.parseInt(scanner.nextLine());
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Dat is geen positief getal.");
                }
            } else {
                System.out.println("Dat is geen getal.");
                scanner.nextLine();
            }
        } while (true);
    }
    
    private static void printArray(int[] array) {
        System.out.println("De waarden zijn: " + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}