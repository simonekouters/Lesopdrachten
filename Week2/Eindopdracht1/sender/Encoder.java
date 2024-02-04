package sender;
import receiver.Decoder;
import java.util.Scanner;
import java.util.List;

public class Encoder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        
        System.out.print("Enter your message to encode morse (use only letters): ");
        String message = scanner.nextLine().toLowerCase();
        
        String encodedMessage = encodeMessage(message);
        sendMessage (encodedMessage);
    }
    
    private static String encodeMessage(String message) {
        final List<String> morseCode = List.of(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", 
        "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..");
        
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (Character.isLetter(message.charAt(i))) {
                char letter = message.charAt(i);
                // Subtract 97 because that's the ASCII decimal for the letter 'a'
                int ascii = letter - 97;
                String letterInMorse = morseCode.get(ascii);
                builder.append(letterInMorse);
                builder.append(" ");
            } else { 
            // If the character is a space, add a space between the words
                builder.append(" ");
            }
        }
        return builder.toString();
    }
    
    private static void sendMessage(String message) {
        // Print the encode message in morse code, then send it to the decoder
        System.out.println(message);
        Decoder decoder = new Decoder();
        decoder.receiveMessage(message);
    }
}