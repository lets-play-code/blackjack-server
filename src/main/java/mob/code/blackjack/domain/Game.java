package mob.code.blackjack.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Game {

    public static final int HOST_DEAL_THRESHOLD = 17;
    @Autowired
    private Deck deck;
    @Autowired
    private GameRule gameRule;

    private Player host;
    private Player player;

    public Game() {
    }

    public Game(GameRule gameRule) {
        this.gameRule = gameRule;
    }

    public GameResult startGame() {

        deck.shuffle();

        player = new Player();
        host = new Player();
        player.add(deck.deal());
        host.add(deck.deal());
        player.add(deck.deal());
        return new GameResult() {{
            setHost(new PlayerDto() {{
                setCards(host.getCards());
            }});
            setPlayer(new PlayerDto() {{
                setCards(player.getCards());
            }});
        }};
    }

    public GameResult closeDeal() {
        while (gameRule.sum(host.getCards()) < HOST_DEAL_THRESHOLD) {
            host.add(deck.deal());
        }
        boolean isHostWin = gameRule.isHostWin(host.getCards(), player.getCards());

        return new GameResult() {{
            setHost(new PlayerDto() {{
                setWinner(isHostWin);
                setCards(host.getCards());
            }});
            setPlayer(new PlayerDto() {{
                setWinner(!isHostWin);
                setCards(player.getCards());
            }});
        }};
    }

    public GameResult deal() {
        player.add(deck.deal());
        boolean playerLose = gameRule.isBust(player.getCards());

        return new GameResult() {{
            setHost(new PlayerDto() {{
                setWinner(playerLose);
                setCards(host.getCards());
            }});
            setPlayer(new PlayerDto() {{
                setCards(player.getCards());
            }});
        }};
    }

}
