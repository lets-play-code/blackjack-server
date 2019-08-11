package mob.code.blackjack.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import static org.mockito.Mockito.mock;

@Configuration
public class StubShufflerFactory {
    @Bean
    @Primary
    public CardsShuffler create() {
        return mock(CardsShuffler.class);
    }

}
