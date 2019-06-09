package mob.code.blackjack.domain;

import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.asList;

@Component
public class Paiku {

    private Iterator<String> paiku = asList("A8", "B8", "C8").iterator();
    public String deal() {
        return paiku.next();
    }
}
