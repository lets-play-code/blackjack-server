package mob.code.blackjack.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class GameCenter {

    @Autowired
    private Paiku paiku;
    private Game game;

    public Game startGame() {
        game = new Game();
        game.getPlayer().add(paiku.deal());
        game.getHost().add(paiku.deal());
        game.getPlayer().add(paiku.deal());
        return game;
    }

    public GameResult closeDeal() {

        List<String> host = game.getHost();
        List<String> player = game.getPlayer();

        int hostSum = host.stream().mapToInt(card -> Integer.parseInt(card.substring(1))).sum();
        int playerSum = player.stream().mapToInt(card -> Integer.parseInt(card.substring(1))).sum();

        return new GameResult(){{
            setHost(new Player(){{
                setWinner(hostSum > playerSum);
            }});
            setPlayer(new Player(){{
                setWinner(hostSum <= playerSum);
            }});
        }};
    }
}
