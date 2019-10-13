package mob.code.blackjack.domain;

import java.util.List;

public class PlayerDto {

    private boolean isWinner;
    private List<String> cards;


    public List<String> getCards() {
        return cards;
    }

    public void setCards(List<String> cards) {
        this.cards = cards;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

}
