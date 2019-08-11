package mob.code.blackjack.domain;

import java.util.ArrayList;
import java.util.List;


public class GameDto {
    public List<String> getHost() {
        return host;
    }

    public void setHost(List<String> host) {
        this.host = host;
    }

    public List<String> getPlayer() {
        return player;
    }

    public void setPlayer(List<String> player) {
        this.player = player;
    }

    private List<String> host = new ArrayList<>();
    private List<String> player = new ArrayList<>();

}
