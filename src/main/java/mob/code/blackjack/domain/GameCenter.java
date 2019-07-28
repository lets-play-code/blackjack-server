package mob.code.blackjack.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class GameCenter {

    @Autowired
    private Paiku paiku;

    public Game startGame() {
        Game game = new Game();
        game.getPlayer().add(paiku.deal());
        game.getHost().add(paiku.deal());
        game.getPlayer().add(paiku.deal());
        return game;
    }

    public GameResult closeDeal() {

        return new GameResult(){{
            setHost(new Player());
            setPlayer(new Player(){{
                setWinner(true);
            }});
        }};
    }
}
