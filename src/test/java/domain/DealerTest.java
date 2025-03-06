package domain;

import domain.card.Card;
import domain.card.CardGroup;
import domain.card.CardType;
import domain.card.RandomCardGenerator;
import domain.gamer.Dealer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class DealerTest {
    @Test
    void 딜러는_점수가_16점_이하인_경우_True를_반환한다(){
        List<Card> cards = List.of(new Card(CardType.DIAMOND_J), new Card(CardType.DIAMOND_2));
        CardGroup cardGroup = new CardGroup(cards);
        RandomCardGenerator randomCardGenerator = new RandomCardGenerator();
        Dealer dealer = new Dealer(cardGroup,randomCardGenerator);

        boolean status = dealer.isLessThen(16);

        assertThat(status).isTrue();
    }
}
