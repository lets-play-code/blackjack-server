package mob.code.blackjack.domain;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class GameRuleTest {

    @Test
    public void testPlayerWin() {
        GameRule gameRule = new GameRule();
        assertEquals(false, gameRule.isHostWin(asList("B7"), asList("A7", "C7")));
    }

    @Test
    public void testHostWin() {
        GameRule gameRule = new GameRule();
        assertEquals(true, gameRule.isHostWin(asList("B7"), asList("A1", "C2")));
    }

    @Test
    public void testCard10JQK() {
        GameRule gameRule = new GameRule();
        assertEquals(false, gameRule.isHostWin(asList("BA"), asList("AB", "CD")));
    }

}