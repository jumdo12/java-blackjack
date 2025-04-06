package domain.card.template;

import domain.card.Card;
import domain.card.Signature;

import java.util.List;

public abstract class CardScoreTemplate {

    public int calculate(List<Card> cards){
        int scoreSum = sum(cards);
        int adjustScore = adjust(cards, scoreSum);
        return adjustScore;
    }

    protected int sum(List<Card> cards){
        return cards.stream()
                .mapToInt(card -> getScore(card.signature()))
                .sum();
    }

    abstract int getScore(Signature signature);

    protected int adjust(List<Card> cards, int scoreSum){
        return scoreSum;
    }
}
