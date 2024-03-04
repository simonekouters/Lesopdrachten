package game;

import cards.*;
import player.Player;
import player.Scoring;

import java.util.List;
import java.util.Scanner;

public class Game {
    private static final int MAX_SCREEN_HEIGHT = 50;
    private static final int STARTING_CARD_AMOUNT = 7;
    private final List<Player> players;
    private final Deck deck = new Deck();
    private final AskUserInput askUserInput = new AskUserInput();
    private final Scanner scanner;
    private int currentPlayerIndex;
    private boolean reverseTurn = false;
    private boolean firstCard = false;
    
    public Game(List<Player> players, Scanner scanner, int startingPlayerIndex) {
        this.players = players;
        this.scanner = scanner;
        this.currentPlayerIndex = startingPlayerIndex;
    }


    public void start() {
        dealCards();
        turnOverFirstCardOfDrawPile(players.get(currentPlayerIndex));
 
        while (true) {
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println(currentPlayer.getName() + ", it's your turn.");
            System.out.println("\nTop of the pile: " + deck.getTopOfPlayPile());

            if (deck.getTopOfPlayPile().isWildCard()) {
                Color newColor = deck.getColorToPlay();
                System.out.println("The color is: " + ConsoleColor.getColor(newColor.name) + newColor.name + ConsoleColor.getColor("reset"));
            }

            askUserInput.askPlayerToEnter3("Enter '3' to see your cards. ");
            System.out.println("\nYour cards:\n" + currentPlayer.getHandAsString());
            askDrawOrPlay(currentPlayer);
            if (currentPlayer.hasWon()) {
                System.out.println(("\n" + currentPlayer.getName() + " has won!").toUpperCase());
                Scoring scoring = new Scoring(players, currentPlayer);
                break;
            }
            nextPlayer();
            clearScreen();
            checkForUNO();
        }   
    }


    private void dealCards() {
        for (Player player : players) {
            for (int i = 0; i < STARTING_CARD_AMOUNT; i++) {
                player.addCard(deck.getCardFromDrawPile());
            }
        }
    }


    private void turnOverFirstCardOfDrawPile(Player playerToStart) {
        do {
            deck.addCardToPlayPile(deck.getCardFromDrawPile());
            if (deck.getTopOfPlayPile().getAction() == Action.WILD_DRAW_FOUR) {
                deck.returnCardToDrawPile(deck.getTopOfPlayPile());
                continue;
            }
            break;
        } while (true);

        deck.setColorToPlay(deck.getTopOfPlayPile().getColor());

        if (deck.getTopOfPlayPile().isActionCard()) {
            // if first card is a symbol card, first player gets the consequences of this card
            firstCard = true;
            System.out.println("\nTop of the pile: " + deck.getTopOfPlayPile() + "\n");
            if (deck.getTopOfPlayPile().isWildCard()) {
                askUserInput.askPlayerToEnter3("Enter '3' to show your cards, so you can choose a color. ");
                System.out.println(playerToStart.getHandAsString());
            }
            playActionCard(deck.getTopOfPlayPile(), playerToStart);
            firstCard = false;
        }
    }


    private void nextPlayer() {
        currentPlayerIndex = getNextPlayerIndex();
    }


    private int getNextPlayerIndex() {
        int nextPlayerIndex;
        if (reverseTurn) {
            if (currentPlayerIndex == 0) {
                nextPlayerIndex = players.size() - 1;
            } else {
                nextPlayerIndex = currentPlayerIndex - 1;
            }
        } else {
            if (currentPlayerIndex == players.size() - 1) {
                nextPlayerIndex = 0;
            } else {
                nextPlayerIndex = currentPlayerIndex + 1;
            }
        }
        return nextPlayerIndex;
    }


    private void askDrawOrPlay(Player player) {
        int choice = askUserInput.askChoice(player.getName() + ", what do you want to do?" + "\n" + "1. Play a card" + "\n" + "2. Draw a card", 2);
        if (choice == 1) {
            askWhichCardToPlay(player);
        } else {
            Card drawnCard = drawCard();
            askToPlayDrawnCard(player, drawnCard);
        }
    }


    private Card drawCard() {
        Card drawnCard = deck.getCardFromDrawPile();
        System.out.println("You got: " + drawnCard); 
        return drawnCard;
    }


    private void askToPlayDrawnCard(Player player, Card drawnCard) {
        int choice = askUserInput.askChoice("""
                Do you want to play this card?
                1. Yes
                2. No""", 2);
        if (choice == 2) {
            player.addCard(drawnCard);
        } else {
            playCard(drawnCard, player, true);
        }
    }


    private void askWhichCardToPlay(Player player) {
        int cardChoice = askUserInput.askChoice("Which card do you want to play?", player.getHand().size());
        Card cardToPlay = player.getCard(cardChoice - 1);
        playCard(cardToPlay, player, false);
    }


    private void playCard(Card cardToPlay, Player player, boolean playingCardAfterDraw) {
        if (deck.cardCanBePlayed(cardToPlay)) {
            deck.addCardToPlayPile(cardToPlay);
            deck.setColorToPlay(cardToPlay.getColor());
            player.removeCard(cardToPlay);
        } else {
            System.out.println("That card can't be played");
            if (!playingCardAfterDraw) {
                askDrawOrPlay(player);
            } else {
                System.out.println("Your turn is over. ");
                askUserInput.askPlayerToEnter3("Enter '3' to go to the next player. ");
            }
        }
        if (cardToPlay.isActionCard()) {
            playActionCard(cardToPlay, player);
        }
    }


    private void playActionCard(Card cardToPlay, Player player) {
        Player nextPlayer = (firstCard) ? player : players.get(getNextPlayerIndex());

        switch (cardToPlay.getAction()) {
          case Action.WILD -> playWildCard();
          case Action.WILD_DRAW_FOUR -> {
              playWildCard();
              makeNextPlayerDrawCard(nextPlayer, 4);
              nextPlayer();
          }
          case Action.DRAW_TWO -> {
              makeNextPlayerDrawCard(nextPlayer, 2);
              nextPlayer();
          }
          case Action.SKIP -> nextPlayer();
          case Action.REVERSE -> reverseTurn = reverseTurn ? false : true;
        }
    }


    private void playWildCard() {
        int color = askUserInput.askChoice("""
                    Which color do you choose?
                    1.Red
                    2.Green
                    3.Blue
                    4.Yellow""", 4);
        Color newColor = Color.values()[color - 1];
        deck.setColorToPlay(newColor);
    }


    private void makeNextPlayerDrawCard(Player nextPlayer, int amountOfCards) {
        if (!firstCard) {
            clearScreen();
        }
        System.out.println(nextPlayer.getName() + ", you have to draw " + amountOfCards + " cards." );
        askUserInput.askPlayerToEnter3("Enter '3' to see your cards. ");

        for (int i = 0; i < amountOfCards; i++) {
            Card drawnCard = drawCard();
            nextPlayer.addCard(drawnCard);
        }

        System.out.println("\nYou have to skip a turn.");
        askUserInput.askPlayerToEnter3("Enter '3' to hide your cards. ");
        for (int i = 0; i < MAX_SCREEN_HEIGHT; i++) {
            System.out.println();
        }
    }


    private void checkForUNO() {
        for (Player player : players) {
            if (player.getHand().size() == 1) {
                System.out.println(player.getName() + ": UNO!");
            }
        }
    }


    private void clearScreen() {
        for (int i = 0; i < MAX_SCREEN_HEIGHT; i++) {
            System.out.println();
        }
    }
}
