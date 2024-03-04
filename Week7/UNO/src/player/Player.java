package player;

import cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final List<Card> hand = new ArrayList<>();
    private int score;
    
    public Player(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public Card getCard(int cardIndex) {
        return hand.get(cardIndex);
    }

    public List<Card> getHand() {
        return hand;
    }
    
    public void addCard(Card card) {
        hand.add(card);
    }

    public void removeCard(Card card) {
        hand.remove(card);
    }

    public boolean hasWon() {
        return hand.isEmpty();
    }
    
    public String getHandAsString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < hand.size(); i++) {
            builder.append((i + 1) + " - " + hand.get(i));
            builder.append("\n");
        }
        return builder.toString();
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int points) {
        score += points;
    }
}