import java.util.Scanner;

public class Eindopdracht3 {
    public static void main(String[] args) {
        int number = askNumber();
        System.out.println(getLucasNumbers(number)); 
    }
    
    
    private static int askNumber() {
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.print("Geef een natuurlijk getal: ");
            if (scanner.hasNextInt()) {
                int number = Integer.parseInt(scanner.nextLine());
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Getal negatief, fout.");
                }
            } else {
                System.out.println("Geen getal, fout.");
                scanner.nextLine();
            }
        } while (true);
    }
    
    
    private static String getLucasNumbers(int number) {
        StringBuilder builder = new StringBuilder();
        builder.append("De eerste " + number + " Lucas-getallen: \n");
        
        int firstNumber = 2, secondNumber = 1, nextNumber;
        
        for (int i = 2; i <= number; i++) {
            builder.append(firstNumber + " ");
            
            try {
                nextNumber = Math.addExact(firstNumber, secondNumber); 
            } catch (Exception e) {
                return "Getal te groot, past niet."; 
            }
            
            firstNumber = secondNumber;
            secondNumber = nextNumber; 
        }
        /* I start i at 2 in the loop, because there should only be an exception when the number
        is bigger than 44. Therefore I have to append firstNumber one more time at the end. */
        builder.append(firstNumber); 
        return builder.toString();
    }
}
