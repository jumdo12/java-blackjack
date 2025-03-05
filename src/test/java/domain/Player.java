package domain;

public class Player {
    private final String name;
    private final CardGroup cardGroup;

    public Player(final String name, final CardGroup cardGroup) {
        this.name = name;
        this.cardGroup = cardGroup;
    }
}
