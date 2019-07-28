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


public class GameCenterTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @InjectMocks
    GameCenter gameCenter = new GameCenter();

    @Mock
    Paiku paiku;

    @Test
    public void start_game_should_fapai() {
        when (paiku.deal()).thenReturn("A7","B7","C7");

        Game game = gameCenter.startGame();

        assertEquals(asList("B7"), game.getHost());
        assertEquals(asList("A7","C7"), game.getPlayer());

    }

    @Test
    public void close_deal_should_return_game_result() {
        when (paiku.deal()).thenReturn("A7","B7","C7");

        Game game = gameCenter.startGame();

        GameResult result = gameCenter.closeDeal();

        assertEquals(false, result.getHost().isWinner());
        assertEquals(true, result.getPlayer().isWinner());
    }
}