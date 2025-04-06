package domain.card.Strategy;

import domain.card.Card;
import domain.card.Signature;

import java.util.List;

public class BlackJackScore implements ScoringStrategy {

    private final ScoreTable scoreTable;

    public BlackJackScore(ScoreTable scoreTable) {
        this.scoreTable = scoreTable;
    }

    @Override
    public int calculate(List<Card> cards) {
        int score = cards.stream()
                .mapToInt(card -> scoreTable.getScore(card.signature()))
                .sum();
        int aceCount = countAce(cards);

        while(score > 21 && aceCount-- > 0){
            score -= 10;
        }

        return score;
    }
}
