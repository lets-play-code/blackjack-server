package mob.code.blackjack.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;



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
}
