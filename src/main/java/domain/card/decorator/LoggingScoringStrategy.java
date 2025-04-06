package domain.card.decorator;

import domain.card.Card;
import domain.card.Strategy.ScoringStrategy;

import java.util.List;

public class LoggingScoringStrategy extends ScoringStrategyDecorator{

    public LoggingScoringStrategy(ScoringStrategy delegate) {
        super(delegate);
    }

    @Override
    public int calculate(List<Card> cards) {
        System.out.println("계산 전");
        int score = delegate.calculate(cards);
        System.out.println("게산 후" + score);
        return score;
    }

    @Override
    public int countAce(List<Card> cards) {
        return super.countAce(cards);
    }
}
