package cards;

public class ConsoleColor {
	private static final String RESET = "\u001B[0m";
	private static final String RED = "\u001B[31m";
	private static final String GREEN = "\u001B[32m";
	private static final String BLUE = "\u001B[34m";
	private static final String YELLOW = "\u001B[33m";
	private static final String PURPLE = "\u001B[35m";

	public static String getColor(Color color, String description) {
		String colorCode = switch (color) {
			case RED -> RED;
			case GREEN -> GREEN;
			case BLUE -> BLUE;
            case YELLOW -> YELLOW;
			case null -> PURPLE;
        };
		return colorCode + description + RESET;
	}
}







