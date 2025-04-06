package domain.card.Strategy;

import domain.card.Signature;

import java.util.Map;

public class BlackJackScoreTable implements ScoreTable{

    private final static Map<Signature, Integer> BLACK_JACK_SCORING = Map.ofEntries(
            Map.entry(Signature.ACE,11),
            Map.entry(Signature.TWO,2),
            Map.entry(Signature.THREE,3),
            Map.entry(Signature.FOUR,4),
            Map.entry(Signature.FIVE,5),
            Map.entry(Signature.SIX,6),
            Map.entry(Signature.SEVEN,7),
            Map.entry(Signature.EIGHT,8),
            Map.entry(Signature.NINE,9),
            Map.entry(Signature.TEN,10),
            Map.entry(Signature.JACK,10),
            Map.entry(Signature.QUEEN,10),
            Map.entry(Signature.KING,10)
    );

    @Override
    public int getScore(Signature signature) {
        return BLACK_JACK_SCORING.get(signature);
    }
}
