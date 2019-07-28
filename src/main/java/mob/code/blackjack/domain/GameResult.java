package mob.code.blackjack.domain;

public class GameResult {
    private Player host;

    public void setPlayer(Player player) {
        this.player = player;
    }

    private Player player;

    public Player getHost() {
        return host;
    }

    public void setHost(Player host) {
        this.host = host;
    }

    public Player getPlayer() {
        return player;
    }
}
