package mob.code.blackjack.domain;

public class GameResult {
    private PlayerDto host;

    public void setPlayer(PlayerDto player) {
        this.player = player;
    }

    private PlayerDto player;

    public PlayerDto getHost() {
        return host;
    }

    public void setHost(PlayerDto host) {
        this.host = host;
    }

    public PlayerDto getPlayer() {
        return player;
    }
}
