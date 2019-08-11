package mob.code.blackjack.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardsShufflerTest {

    @Test
    public void should_return_52_cards() {
        CardsShuffler shuffler = new CardsShuffler();
        assertEquals(52, shuffler.getCards().size());
    }

    @Test
    public void should_be_random() {
        CardsShuffler shuffler = new CardsShuffler();
        assertNotEquals(shuffler.getCards(), shuffler.getCards());
    }
}