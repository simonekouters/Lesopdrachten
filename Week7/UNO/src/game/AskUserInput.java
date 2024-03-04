package game;

import java.util.Scanner;

public class AskUserInput {
    private final Scanner scanner = new Scanner(System.in);

    public int askChoice(String text, int max) {
        do {
            System.out.println(text);
            if (scanner.hasNextInt()) {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= max) {
                    return choice;
                } else {
                    System.out.println("Please choose one of the options.");
                }
            } else {
                System.out.println("Please enter the number before the option.");
                scanner.nextLine();
            }
        } while (true);
    }

    public int askChoice(String text) {
        return askChoice(text, 2);
    }

    public void askPlayerToEnter3(String text) {
        do {
            System.out.print(text);
            String input = scanner.nextLine();
            if (input.toLowerCase().trim().equals("3")) {
                break;
            }
        } while (true);
    }
}
