public class TafelMaker {
    public static void main(String[] args) {
        tafelMaker(10);  
    }
    
    private static void tafelMaker(int size) {
        StringBuilder builder = new StringBuilder();
        
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                builder.append(i * j).append(" ");
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }
}