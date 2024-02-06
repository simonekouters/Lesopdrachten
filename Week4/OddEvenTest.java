import java.util.Scanner;

public class OddEvenTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number to check if it's odd: ");
        int number = Integer.parseInt(scanner.nextLine());
        
        System.out.println(isOdd(number));   
    }
    
    private static boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
