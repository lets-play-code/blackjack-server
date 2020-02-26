package pact;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;
import au.com.dius.pact.provider.spring.target.SpringBootHttpTarget;
import mob.code.blackjack.BlackjackServerApplication;
import mob.code.blackjack.domain.CardsShuffler;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;

@RunWith(SpringRestPactRunner.class)
@Provider("backend")
@PactFolder("../page/pacts")
@ContextConfiguration(classes = BlackjackServerApplication.class, loader = SpringBootContextLoader.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContractTest {
    @TestTarget
    public Target target = new SpringBootHttpTarget();

    @Autowired
    private CardsShuffler shuffler;

    @Before
    public void setUp() throws Exception {
    }

    @State("cards are A2, A1, B2, A3")
    public void cardState1() {
        when(shuffler.getCards()).thenReturn(asList("A2", "A1", "B2", "A3"));
    }

    @State("cards are C1, C2, C3, C4")
    public void cardState2() {
        when(shuffler.getCards()).thenReturn(asList("C1", "C2", "C3", "C4"));
    }

    @State("cards are A2, AA, B2, A9")
    public void cardState3() {
        when(shuffler.getCards()).thenReturn(asList("A2", "AA", "B2", "A9", "AA", "AB", "AC"));
    }


}

