package player;

import cards.Card;

import java.util.List;

public class Scoring {
    private final List<Player> players;
    private final Player winner;

    public Scoring(List<Player> players, Player winner) {
        this.players = players;
        this.winner = winner;

        int score = calculateWinnerScore();
        winner.updateScore(score);
    }

    public int calculateWinnerScore() {
        int sum = 0;
        for (Player player : players) {
            if (player == winner) {
                continue;
            }
            for (Card card : player.getHand()) {
                if (card.isWildCard()) {
                    sum += 50;
                } else if (card.isActionCard()) {
                    sum += 20;
                } else {
                    sum += card.getNumber().ordinal();
                }
            }
        }
        return sum;
    }
}
