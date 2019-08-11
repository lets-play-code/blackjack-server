package mob.code.blackjack.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class GameCenter {

    @Autowired
    private Paiku paiku;
    private Game game;
    @Autowired
    private GameRule gameRule;

    public Game startGame() {
        game = new Game();
        paiku.shuffle();
        game.getPlayer().add(paiku.deal());
        game.getHost().add(paiku.deal());
        game.getPlayer().add(paiku.deal());
        return game;
    }

    public GameResult closeDeal() {

        boolean isHostWin = gameRule.isHostWin(game.getHost(), game.getPlayer());

        return new GameResult(){{
            setHost(new Player(){{
                setWinner(isHostWin);
            }});
            setPlayer(new Player(){{
                setWinner(!isHostWin);
            }});
        }};
    }

    public Game deal() {
        game.getPlayer().add(paiku.deal());
        return game;
    }
}
