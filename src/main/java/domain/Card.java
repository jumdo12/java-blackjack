package domain;

public class Card {
    CardScore score;
    CardType type;

    Card(CardScore number, domain. CardType type) {
        this.score = number;
        this.type = type;
    }

    public CardScore getScore() {
        return score;
    }

    public CardType getType() {
        return type;
    }

    public int calculateAceScore(final int score, final int limit) {
        final int result = limit - score;
        int aceScore = 1;
        if (result >=  11) {
            aceScore = 11;
        }
        return aceScore;
    }
}
