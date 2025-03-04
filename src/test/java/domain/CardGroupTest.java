package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CardGroupTest {

    @Nested
    class CardGroupConstructor{
        @Test
        void 카드_그룹을_생성한다() {
            //given
            final List<Card> cards = List.of(new Card(CardScore.ACE, CardType.DIAMOND), new Card(CardScore.EIGHT, CardType.HEART));

            //when
            final CardGroup cardGroup = new CardGroup(cards);

            //then
            assertThat(cardGroup).isInstanceOf(CardGroup.class);
        }

        @Test
        void 카드_점수를_계산한다1() {
            //given
            final List<Card> cards = List.of(new Card(CardScore.TWO, CardType.DIAMOND), new Card(CardScore.THREE, CardType.HEART));

            //when
            final CardGroup cardGroup = new CardGroup(cards);
            final int score = cardGroup.calculateScore();

            //then
            assertThat(score).isEqualTo(5);
        }

        @Test
        void 카드_점수를_계산한다2() {
            //given
            final List<Card> cards = List.of(new Card(CardScore.THREE, CardType.DIAMOND), new Card(CardScore.FOUR, CardType.HEART));

            //when
            final CardGroup cardGroup = new CardGroup(cards);
            final int score = cardGroup.calculateScore();

            //then
            assertThat(score).isEqualTo(7);
        }
    }
}
