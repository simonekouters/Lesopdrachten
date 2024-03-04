package cards;

public class ConsoleColor {

	public static String getColor(String color){
		return switch(color.toLowerCase()){
            case "red" -> "\u001B[31m";
			case "green" -> "\u001B[32m";
			case "yellow" -> "\u001B[33m";
			case "blue" -> "\u001B[36m";
			case "purple" -> "\u001B[35m";
			default -> "\u001B[0m";
		};
	}
}







