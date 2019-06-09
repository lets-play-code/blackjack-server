package mob.code.blackjack.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import static org.mockito.Mockito.mock;

@Configuration
public class StubPaikuFactory {
    @Bean
    @Primary
    public Paiku create() {
        return mock(Paiku.class);
    }

}
