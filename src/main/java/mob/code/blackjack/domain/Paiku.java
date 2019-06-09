package mob.code.blackjack.domain;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Iterator;

import static java.util.Arrays.asList;

@Component
@RequestScope
public class Paiku {

    private Iterator<String> paiku = asList("A8", "B8", "C8").iterator();
    public String deal() {
        return paiku.next();
    }
}
