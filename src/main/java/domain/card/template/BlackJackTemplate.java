package domain.card.template;

import domain.card.Card;
import domain.card.Signature;

import java.util.List;

public class BlackJackTemplate extends CardScoreTemplate{

    @Override
    protected int getScore(Signature signature) {
        return switch (signature){
            case ACE -> 1;
            case TWO -> 2;
            case THREE -> 3;
            case FOUR -> 4;
            case FIVE -> 5;
            case SIX -> 6;
            case SEVEN -> 7;
            case EIGHT -> 8;
            case NINE -> 9;
            case TEN, JACK, QUEEN, KING -> 10;
        };
    }

    @Override
    protected int adjust(List<Card> cards, int scoreSum){
        int aceCount = (int) cards.stream()
                .filter(card -> card.signature() == Signature.ACE)
                .count();

        while (scoreSum > 21 && aceCount-- > 0) {
            scoreSum -= 10;
        }

        return scoreSum;
    }
}
