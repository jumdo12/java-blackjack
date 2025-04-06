package domain.card.decorator;

import domain.card.Card;
import domain.card.Strategy.ScoringStrategy;

import java.util.List;

public class BonusScoringStrategy extends ScoringStrategyDecorator{

    public BonusScoringStrategy(ScoringStrategy delegate) {
        super(delegate);
    }

    @Override
    public int calculate(List<Card> cards) {
        return delegate.calculate(cards) + 5;
    }

    @Override
    public int countAce(List<Card> cards) {
        return super.countAce(cards);
    }
}
