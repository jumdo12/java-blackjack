package domain;

public class Player extends Gamer{
    private final String name;

    public Player(String name, CardGroup cardGroup) {
        super(cardGroup);
        this.name = name;
    }
}
