package mob.code.blackjack.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.asList;

@Component
public class RealPaiku implements Paiku {

    private CardsShuffler shuffler;

    public RealPaiku(CardsShuffler shuffler) {

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
