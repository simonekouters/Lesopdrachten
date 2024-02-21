import java.util.Arrays;

public class WhileEnDoWhile {
    public static void main(String[] args) {
        int[] list = new int[5];
        whileLoop(list);
        doWhileLoop(list);
    }
    
    private static void whileLoop(int[] list) {
        int i = 0;
        while (i < 5) {
            list[i] = i + 2;
            i++;
        }
        
        System.out.println(Arrays.toString(list));
    }
    
    
    private static void doWhileLoop(int[] list) {
        int i = 0;
        do {
            list[i] = i + 2;
            i++;
        } while (i < 5);
        
        System.out.println(Arrays.toString(list));
    }    
}