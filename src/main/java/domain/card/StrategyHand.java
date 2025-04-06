package domain.card;

import domain.card.Strategy.ScoringStrategy;

import java.util.ArrayList;
import java.util.List;

public class StrategyHand {

    private final List<Card> hand;

    public StrategyHand() {
        this(new ArrayList<>());
    }

    public StrategyHand(List<Card> hand) {
        this.hand = hand;
    }

    public void receive(Card card){
        hand.add(card);
    }

    public int calcScore(ScoringStrategy scoringStrategy){
        return scoringStrategy.calculate(new ArrayList<>(hand));
    }
}
