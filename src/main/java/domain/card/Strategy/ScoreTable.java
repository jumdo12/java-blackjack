package domain.card.Strategy;

import domain.card.Signature;

public interface ScoreTable {
    int getScore(Signature signature);
}
