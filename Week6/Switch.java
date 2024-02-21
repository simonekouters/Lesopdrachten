public class Switch {
    public static void main(String[] args) {
        switchStatement("chrome");
        switchExpression("IE");
    }
    
    private static void switchStatement(String browser) {
        switch(browser) {
            case "Edge":
                System.out.println("Je gebruikt Edge");
                break;
            case "chrome":
            case "firefox":
            case "opera":
                System.out.println("Je gebruikt een moderne browser");
                break;
            case "IE":
                System.out.println("Waarom gebruik je Internet Explorer?");
                break;
            default: 
                System.out.println("Je gebruikt een niet-ondersteunde browser");  
        } 
    }
    
    private static void switchExpression(String browser) {
        switch(browser) {
            case "Edge" -> System.out.println("Je gebruikt Edge");
            case "chrome", "firefox", "opera" -> System.out.println("Je gebruikt een moderne browser");
            case "IE" -> System.out.println("Waarom gebruik je Internet Explorer?");
            default -> System.out.println("Je gebruikt een niet-ondersteunde browser"); 
        };
    }
}