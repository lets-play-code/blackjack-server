package mob.code.blackjack.domain;

import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class RealDeck implements Deck {

    private CardsShuffler shuffler;

    public RealDeck(CardsShuffler shuffler) {

        this.shuffler = shuffler;
    }

    private Iterator<String> paiku;

    @Override
    public String deal() {
        return paiku.next();
    }

    @Override
    public void shuffle() {
        paiku = shuffler.getCards().iterator();

    }
}
