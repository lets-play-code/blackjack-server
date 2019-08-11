package mob.code.blackjack.domain;

import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class Deck {

    private CardsShuffler shuffler;

    public Deck(CardsShuffler shuffler) {

        this.shuffler = shuffler;
    }

    private Iterator<String> paiku;

    public String deal() {
        return paiku.next();
    }

    public void shuffle() {
        paiku = shuffler.getCards().iterator();

    }
}
