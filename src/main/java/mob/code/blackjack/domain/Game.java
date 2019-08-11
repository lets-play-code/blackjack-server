package mob.code.blackjack.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Game {

    @Autowired
    private Deck deck;
    private GameDto gameDto;
    @Autowired
    private GameRule gameRule;

    public GameDto startGame() {
        gameDto = new GameDto();
        deck.shuffle();
        gameDto.getPlayer().add(deck.deal());
        gameDto.getHost().add(deck.deal());
        gameDto.getPlayer().add(deck.deal());
        return gameDto;
    }

    public GameResult closeDeal() {

        boolean isHostWin = gameRule.isHostWin(gameDto.getHost(), gameDto.getPlayer());

        return new GameResult(){{
            setHost(new Player(){{
                setWinner(isHostWin);
            }});
            setPlayer(new Player(){{
                setWinner(!isHostWin);
            }});
        }};
    }

    public GameDto deal() {
        gameDto.getPlayer().add(deck.deal());
        return gameDto;
    }
}
