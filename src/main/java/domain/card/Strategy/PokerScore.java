package domain.card.Strategy;

import domain.card.Card;

import java.util.List;

public class PokerScore implements ScoringStrategy {

    private final ScoreTable scores;

    public PokerScore(ScoreTable table) {
        this.scores = table;
    }

    @Override
    public int calculate(List<Card> cards) {
        return cards.stream()
                .mapToInt(card -> scores.getScore(card.signature()))
                .sum();
    }
}
