public class Fibonacci {
    private static long[] numbers = new long[50];

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        
        for (int n = 0; n < 50; n++) {
            builder.append(fibonacci(n)).append(" ");
        }
        System.out.println(builder);
    }

    private static long fibonacci(int n) {
        numbers [(int) n] = (n == 0) ? 0 : (n <= 2) ? 1 : (numbers[(int) n] != 0) ? numbers[(int) n] : (fibonacci(n - 1) + fibonacci(n - 2));
        return numbers [(int) n];
    }
}



