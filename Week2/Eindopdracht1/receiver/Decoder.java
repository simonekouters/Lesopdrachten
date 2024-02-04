package receiver;
import java.util.List;

public class Decoder {
    public void receiveMessage(String messageFromSender) {
        String receivedMessage = decryptMessage(messageFromSender);
        System.out.println("\nWas your message: " + receivedMessage + "?");
    }
    
    private String decryptMessage(String message) { 
        final List<String> morseCode = List.of(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", 
        "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..");
    
        StringBuilder builder = new StringBuilder();
        String[] parts = message.split(" ");
    
        for (String part : parts) {
            for (int i = 0; i < morseCode.size(); i++) {
                if (morseCode.get(i).equals(part)) {
                    // Add 97 because that's the ASCII decimal for the letter 'a'
                    char letter = (char) (i + 97); 
                    builder.append(letter);
                }
            }  
            // If there's a space between the words, add a space
            if (part.isEmpty()) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}