package mob.code.blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<String> cards = new ArrayList<>();

    public void add(String card) {
        cards.add(card);
    }

    public List<String> getCards() {
        return cards;
    }
}
