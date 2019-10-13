package mob.code.blackjack.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


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
        while(sum(gameDto.getHost())<17){
            gameDto.getHost().add(deck.deal());
        }

        boolean isHostWin = gameRule.isHostWin(gameDto.getHost(), gameDto.getPlayer());

        return new GameResult(){{
            setHost(new Player(){{
                setWinner(isHostWin);
                setCards(gameDto.getHost());
            }});
            setPlayer(new Player(){{
                setWinner(!isHostWin);
                setCards(gameDto.getPlayer());
            }});
        }};
    }

    public GameDto deal() {
        gameDto.getPlayer().add(deck.deal());
        return gameDto;
    }

    private int sum(List<String> cards){
        return cards.stream()
                .mapToInt(card -> getCardNum(card))
                .sum();

    }

    private int getCardNum(String card) {
        String cardCode = getCardCode(card);
        if (cardCode.matches("[ABDE]")) {
            return 10;
        } else {
            return Integer.parseInt(cardCode);
        }
    }

    private String getCardCode(String card) {
        return card.substring(1);
    }
}
