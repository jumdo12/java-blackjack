package domain;

import domain.gamer.Player;

public enum GameResult {

    WIN,
    LOSE,
    DRAW;

    GameResult() {
    }

    public static GameResult findByScores(int score, int compareScore) {
        if (score > compareScore) {
            return WIN;
        }

        if (score < compareScore || score > Player.LIMIT) {
            return LOSE;
        }

        return DRAW;
    }

}
