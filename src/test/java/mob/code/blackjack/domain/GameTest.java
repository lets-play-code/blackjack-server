package mob.code.blackjack.domain;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class GameTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @InjectMocks
    Game game = new Game();

    @Mock
    Deck deck;

    @Mock
    GameRule gameRule;

    @Test
    public void start_game_should_fapai() {
        givenCards("A7", "B7", "C7");

        GameDto gameDto = game.startGame();

        assertEquals(asList("B7"), gameDto.getHost());
        assertEquals(asList("A7","C7"), gameDto.getPlayer());

    }

    @Test
    public void close_deal_should_return_game_result() {
        when(gameRule.isHostWin(anyList(), anyList())).thenReturn(false);
        givenCards("A7", "B7", "C7", "BA");

        GameDto gameDto = game.startGame();

        GameResult result = game.closeDeal();

        verify(gameRule).isHostWin(asList("B7","BA"), asList("A7", "C7"));
        assertEquals(false, result.getHost().isWinner());
        assertEquals(true, result.getPlayer().isWinner());
        assertEquals(asList("B7","BA"), result.getHost().getCards());
        assertEquals(asList("A7","C7"), result.getPlayer().getCards());
    }

    @Test
    public void host_should_deal_until_17() {
        when(gameRule.isHostWin(anyList(), anyList())).thenReturn(false);
        givenCards("A7", "B7", "C7", "B2","B3","B4","B5","B6");

        GameDto gameDto = game.startGame();

        GameResult result = game.closeDeal();


        assertEquals(asList("B7","B2","B3","B4","B5"), result.getHost().getCards());
        assertEquals(asList("A7","C7"), result.getPlayer().getCards());
    }

    private void givenCards(String first, String... others) {
        when(deck.deal()).thenReturn(first, others);
    }
}