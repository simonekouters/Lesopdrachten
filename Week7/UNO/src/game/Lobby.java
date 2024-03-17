package game;

import cards.Card;
import cards.Deck;
import player.Player;

import java.util.*;

public class Lobby {
    private final Deck deck = new Deck();
    private final AskUserInput askUserInput = new AskUserInput();
    private final Scanner scanner = new Scanner(System.in);
    private int round = 1;

    public void start() {
        List<Player> players = createPlayersList();
        while (true) {
            System.out.println("\nRound: " + round);
            playGame(players);
            printScores(players);

            if (getWinner(players).isPresent()) {
                System.out.println((getWinner(players).get().getName() + " has won!").toUpperCase());
                break;
            }

            if (askUserInput.askChoice("""
                Do you want to play another round?
                1. Yes
                2. No""") == 2) {
                System.out.println(("The winner is: " + getWinnerOfAllRounds(players).getName() + "!").toUpperCase());
                break;
            }
            do {
                if (askUserInput.askChoice("""
                Is everyone participating in the next round?
                1. Yes
                2. No""") == 1) {
                    break;
                }
                removePlayers(players);
            } while (true);
            round++;
        }
    }


    private List<Player> createPlayersList() {
        System.out.println("Enter the names of the players (max 10). Enter '-' instead of a name to start the game");
        List<Player> players = new ArrayList<>();

        do {
            System.out.print("Enter a name: ");
            String input = scanner.nextLine();
            if (input.equals("-")) {
                if (players.size() < 2) {
                    System.out.println("You have to add at least two players.");
                } else {
                    break;
                }
            }
            if (players.size() > 9) {
                System.out.println("You can't add more than 10 players");
                break;
            }
            if (!input.isEmpty()) {
                players.add(new Player(input.trim()));
            }
        } while (true);
        return players;
    }


    private void playGame(List<Player> players) {
        Player startingPlayer = decideWhoStarts(players);
        int startingPlayerIndex = players.indexOf(startingPlayer);
        Game game = new Game(players, startingPlayerIndex);
        game.start();
    }


    private Player decideWhoStarts(List<Player> players) {
        System.out.println("\nYou're going to draw a card to see who starts.");
        HashMap<Player, Integer> drawnValues = drawCardsToSeeWhoStarts(players);

        int highestDraw = Collections.max(drawnValues.values());
        Player playerWithHighestDraw = null;

        for (Player player : drawnValues.keySet()) {
            if (drawnValues.get(player) == highestDraw) {
                playerWithHighestDraw = player;
            }
        }
        System.out.println(playerWithHighestDraw.getName() + " will start.");
        return playerWithHighestDraw;
    }


    private HashMap<Player, Integer> drawCardsToSeeWhoStarts(List<Player> players) {
        HashMap<Player, Integer> drawnValues = new HashMap<>();

        for (Player player : players) {
            askUserInput.askPlayerToEnter3(player.getName() + ", enter '3' to draw a card. ");
            do {
                Card drawnCard = deck.getCardFromDrawPile();
                int valueOfCard = drawnCard.isActionCard() ? 0 : drawnCard.getNumber().ordinal();
                if (drawnCard.isActionCard() || !drawnValues.containsValue(valueOfCard)) {
                    drawnValues.put(player, valueOfCard);
                    System.out.println(drawnCard + "\n");
                    break;
                }
            } while (true);
        }
        return drawnValues;
    }


    private void removePlayers(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i + 1) + " - " + players.get(i).getName());
        }
        do {
            System.out.println("Enter the number of the player who wants to leave.");
            if (scanner.hasNextInt()) {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= players.size()) {
                    System.out.println(players.get(choice - 1).getName() + " has left the game.");
                    players.remove(choice - 1);
                    break;
                } else {
                    System.out.println("Please choose one of the players.");
                }
            } else {
                System.out.println("Please enter the number before the player.");
                scanner.nextLine();
            }
        } while (true);
    }


    private void printScores(List<Player> players) {
        System.out.println("\nSCORES");
        for (Player player : players) {
            System.out.println(player.getName() + " - " + player.getScore());
        }
        System.out.println();
    }

    private Optional<Player> getWinner(List<Player> players) {
        return players.stream().filter(player -> player.getScore() >= 500).findFirst();
    }

    private Player getWinnerOfAllRounds(List<Player> players) {
        int highest = 0;
        Player winner = players.getFirst();
        for (Player player : players) {
            if (player.getScore() > highest) {
                highest = player.getScore();
                winner = player;
            }
        }
        return winner;
    }
}
