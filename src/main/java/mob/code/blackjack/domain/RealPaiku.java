package mob.code.blackjack.domain;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Iterator;

import static java.util.Arrays.asList;

@Component
@RequestScope
public class RealPaiku implements Paiku {

    private Iterator<String> paiku = asList("A7", "B7", "C7").iterator();
   @Override
    public String deal() {
        return paiku.next();
    }
}
