package cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.util.RestfulHelper;
import mob.code.blackjack.BlackjackServerApplication;
import mob.code.blackjack.domain.CardsShuffler;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = BlackjackServerApplication.class, loader = SpringBootContextLoader.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BlackjackStep {
    @Autowired
    private CardsShuffler shuffler;

    @LocalServerPort
    private int port;

    private ResponseEntity<String> response;

    @When("^I ping the server$")
    public void i_ping_the_server() throws Throwable {
        response = RestfulHelper.connect(port).get("/ping");
    }

    @Then("^the server will response$")
    public void the_server_will_response() throws Throwable {
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("pong", response.getBody());
    }

    @Then("the server will return")
    public void the_server_will_return(String docString) throws JSONException {
        assertEquals(HttpStatus.OK, response.getStatusCode());
        //assertEquals(docString,response.getBody());
        JSONAssert.assertEquals(docString,response.getBody(),true);
    }


    @Given("a paiku {string} {string} {string}")
    public void a_paiku(String string, String string2, String string3) {
        when(shuffler.getCards()).thenReturn(asList(string, string2, string3));
    }

    @Given("a paiku {string} {string} {string} {string}")
    public void a_paiku(String string, String string2, String string3, String string4) {
        when(shuffler.getCards()).thenReturn(asList(string, string2, string3, string4));
    }

    @When("I start game")
    public void i_start_game() {
      response = RestfulHelper.connect(port).post("/startgame");
    }

    @When("^I close deal$")
    public void iCloseDeal() {
        response = RestfulHelper.connect(port).post("/closedeal");
    }

    @When("I deal")
    public void i_deal() {
        response = RestfulHelper.connect(port).post("/deal");
    }
}
