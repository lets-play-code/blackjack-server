package mob.code.blackjack.domain;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


public class GameTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    GameRule gameRule = new GameRule();

    @InjectMocks
    Game game = new Game(gameRule);

    @Mock
    Deck deck;

    @Test
    public void start_game_should_fapai() {
        givenCards("A7", "B7", "C7");

        GameResult gameDto = game.startGame();

        assertEquals(asList("B7"), gameDto.getHost().getCards());
        assertEquals(asList("A7","C7"), gameDto.getPlayer().getCards());

    }

    @Test
    public void close_deal_should_return_game_result() {
        givenCards("A7", "B7", "C7", "BA");

        game.startGame();

        GameResult result = game.closeDeal();

        assertEquals(true, result.getHost().isWinner());
        assertEquals(false, result.getPlayer().isWinner());
        assertEquals(asList("B7","BA"), result.getHost().getCards());
        assertEquals(asList("A7","C7"), result.getPlayer().getCards());
    }

    @Test
    public void host_should_deal_until_17() {
        givenCards("A7", "B7", "C7", "B2","B3","B4","B5","B6");

        game.startGame();
        GameResult result = game.closeDeal();

        assertEquals(asList("B7","B2","B3","B4","B5"), result.getHost().getCards());
        assertEquals(asList("A7","C7"), result.getPlayer().getCards());
    }

    @Test
    public void host_should_lose_with_bust() {
        givenCards("AA", "B7", "CA", "B9","BA","B4","B5","B6");

        game.startGame();
        GameResult result = game.closeDeal();

        assertEquals(asList("B7","B9","BA"), result.getHost().getCards());
        assertTrue(result.getPlayer().isWinner());
    }

    @Test
    public void player_should_lose_with_bust() {
        givenCards("AA", "B7", "CA", "B2","B3","B4","B5","B6");

        game.startGame();
        GameResult result = game.deal();

        assertEquals(asList("AA","CA", "B2"), result.getPlayer().getCards());
        assertTrue(result.getHost().isWinner());

    }

    private void givenCards(String first, String... others) {
        when(deck.deal()).thenReturn(first, others);
    }
}