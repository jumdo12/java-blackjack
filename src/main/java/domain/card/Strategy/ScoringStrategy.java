package domain.card.Strategy;

import domain.card.Card;
import domain.card.Signature;

import java.util.List;

public interface ScoringStrategy {

    int calculate(List<Card> cards);

    default int countAce(List<Card> cards){
        return Math.toIntExact(cards.stream()
                .filter(card -> card.signature() == Signature.ACE)
                .count());
    }
}
