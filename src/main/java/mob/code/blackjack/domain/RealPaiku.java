package mob.code.blackjack.domain;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.asList;

@Component
@RequestScope
public class RealPaiku implements Paiku {
    private static String[] ALL_CARDS = {"A1","B1","C1","D1","A2","B2","C2","D2","A3","B3","C3","D3","A4","B4","C4","D4","A5","B5","C5","D5","A6","B6","C6","D6","A7","B7","C7","D7","A8","B8","C8","D8","A9","B9","C9","D9","AA","BA","CA","DA","AB","BB","CB","DB","AD","BD","CD","DD","AE","BE","CE","DE"};
    private static List<String> shuffledCards() {
       List<String> cards = new ArrayList<>(asList(ALL_CARDS));
       Collections.shuffle(cards);
       return cards;
    }

    private Iterator<String> paiku = shuffledCards().iterator();

    @Override
    public String deal() {
        return paiku.next();
    }
}
