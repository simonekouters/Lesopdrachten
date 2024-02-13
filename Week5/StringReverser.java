import java.util.Scanner;

public class StringReverser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        StringBuilder builder = new StringBuilder(text);
        
        String reversed = builder.reverse().toString();
        System.out.println(reversed);
        
        if (reversed.equals(text)) {
            System.out.println("Palindroom!");
        }
    }
}