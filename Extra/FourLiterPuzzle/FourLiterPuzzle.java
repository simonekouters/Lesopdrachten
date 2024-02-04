public class FourLiterPuzzle {
        private static Container threeLiterContainer = new Container(3, 0);
        private static Container fiveLiterContainer = new Container(5, 0);
        private static int goal = 4;
        
    public static void main(String[] args) {
        printContainers();
        
        fiveLiterContainer.fillCompletely();
        printContainers(); 
        
        Container.transferLiquid(fiveLiterContainer, threeLiterContainer);
        printContainers(); 
        
        threeLiterContainer.emptyContainer();
        printContainers(); 
        
        Container.transferLiquid(fiveLiterContainer, threeLiterContainer);
        printContainers(); 
        
        fiveLiterContainer.fillCompletely();
        printContainers(); 
        
        Container.transferLiquid(fiveLiterContainer, threeLiterContainer);
        printContainers();   
    }
    
    
    private static void printContainers() {
        System.out.println("First container: " + threeLiterContainer.toString());
        System.out.println("Second container: " + fiveLiterContainer.toString());
        System.out.println();
    }
}

