package domain.card.decorator;

import domain.card.Strategy.ScoringStrategy;

public abstract class ScoringStrategyDecorator implements ScoringStrategy {
    protected final ScoringStrategy delegate;

    public ScoringStrategyDecorator(ScoringStrategy delegate) {
        this.delegate = delegate;
    }
}
