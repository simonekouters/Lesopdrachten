package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> drawPile = new ArrayList<>();
    private List<Card> playPile = new ArrayList<>();
    private Color colorToPlay;
    
    public Deck() {
        createDeck();
        shuffleDeck();
    }
    
    private void createDeck() {
        for (Color color : Color.values()) {
            for (int i = 0; i < 2; i++) {
                for (Number number : Number.values()) {
                    Card card = new Card(color, number);
                    drawPile.add(card);
                }
                drawPile.add(new Card(color, Action.SKIP));
                drawPile.add(new Card(color, Action.REVERSE));
                drawPile.add(new Card(color, Action.DRAW_TWO));
            }
        }   
        // remove a zero from every color 
        for (int i = 0; i <= 75; i += 25) {
            drawPile.remove(i);
        }
        
        for (int i = 0; i < 4; i++) {
            drawPile.add(new Card(Action.WILD));
            drawPile.add(new Card(Action.WILD_DRAW_FOUR));
        }
    }
    
    private void shuffleDeck() {
        Collections.shuffle(drawPile);
    }
    
    public void returnCardToDrawPile(Card card) {
        drawPile.add(card);
    }
    
    public Card getCardFromDrawPile() {
        if (drawPile.isEmpty()) {
            refillDrawPile();
        }
        Card topCard = drawPile.getFirst();
        drawPile.removeFirst();
        return topCard;
    }

    public void refillDrawPile() {
        drawPile.addAll(playPile);
        shuffleDeck();
    }

    public void addCardToPlayPile(Card card) {
        playPile.add(card);
    }

    public Card getTopOfPlayPile() {
        return playPile.getLast();
    }

    public void setColorToPlay(Color color) {
        colorToPlay = color;
    }

    public Color getColorToPlay() {
        return colorToPlay;
    }

    public boolean cardCanBePlayed(Card cardToPlay) {
        if (cardToPlay.isWildCard()) {
            return true;
        } else if (cardToPlay.isActionCard() && cardToPlay.getAction() == getTopOfPlayPile().getAction()) {
            return true;
        } else if (cardToPlay.getColor() == colorToPlay || cardToPlay.getNumber() == getTopOfPlayPile().getNumber()) {
            return true;
        }
        return false;
    }
}