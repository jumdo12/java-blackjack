package domain.card;

import domain.card.Strategy.*;
import domain.card.decorator.BonusScoringStrategy;
import domain.card.decorator.LoggingScoringStrategy;
import domain.card.decorator.ScoringStrategyDecorator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class StrategyHandTest {

    @Nested
    class CardAddTest{

        @DisplayName("원하는 카드를 받는다")
        @Test
        void cardReceiveTest(){
            StrategyHand hand = new StrategyHand();

            Assertions.assertDoesNotThrow(() -> hand.receive(new Card(Shape.CLOVER, Signature.SIX)));
        }
    }

    @Nested
    class BlackJackCalculateCardScore{

        @DisplayName("Ace 카드의 갯수를 계산한다.")
        @Test
        void getAceCount(){
            StrategyHand hand = new StrategyHand();
            ScoreTable scoreTable = new BlackJackScoreTable();
            ScoringStrategy scoringStrategy = new BlackJackScore(scoreTable);

            hand.receive(new Card(Shape.CLOVER, Signature.SIX));
            hand.receive(new Card(Shape.CLOVER, Signature.ACE));

            int score = hand.calcScore(scoringStrategy);

            assertThat(score).isEqualTo(17);
        }
    }

    @Nested
    class PokerCalculateCardScore{

        @Test
        void pokerTest(){
            StrategyHand hand = new StrategyHand();
            ScoreTable scoreTable = new PokerScoreTable();
            ScoringStrategy scoringStrategy = new PokerScore(scoreTable);

            hand.receive(new Card(Shape.CLOVER, Signature.SIX));
            hand.receive(new Card(Shape.CLOVER, Signature.ACE));

            int score = hand.calcScore(scoringStrategy);

            assertThat(score).isEqualTo(7);
        }
    }

    @Nested
    class DecoratorHandCardScore{

        @Test
        void decoratorTest(){
            StrategyHand hand = new StrategyHand();
            ScoreTable blackJackTable = new BlackJackScoreTable();
            ScoringStrategy blackJackStrategy = new BlackJackScore(blackJackTable);

            hand.receive(new Card(Shape.CLOVER, Signature.TEN));

            ScoringStrategyDecorator scoringStrategyDecorator =
                    new BonusScoringStrategy(
                        new LoggingScoringStrategy(blackJackStrategy));

            Assertions.assertDoesNotThrow(() -> hand.calcScore(scoringStrategyDecorator));
        }

        @Test
        void decoratorTest2(){
            StrategyHand hand = new StrategyHand();
            ScoreTable blackJackTable = new BlackJackScoreTable();
            ScoringStrategy blackJackStrategy = new BlackJackScore(blackJackTable);

            hand.receive(new Card(Shape.CLOVER, Signature.TEN));

            ScoringStrategyDecorator scoringStrategyDecorator =
                    new LoggingScoringStrategy(
                            new BonusScoringStrategy(
                                    blackJackStrategy
                            )
                    );

            Assertions.assertDoesNotThrow(() -> hand.calcScore(scoringStrategyDecorator));
        }
    }
}