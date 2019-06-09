package mob.code.blackjack.controller;

import mob.code.blackjack.domain.Game;
import org.springframework.web.bind.annotation.*;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:8090")
public class GameController {

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("card")
    public String card() {
        //See https://en.wikipedia.org/wiki/Playing_cards_in_Unicode
        return "BB";
    }
    @PostMapping("startgame")
    public Game startGame(){
        Game game = new Game();
        game.setHost(asList("B8"));
        game.setPlayer(asList("A8","C8"));
        return game;
    }

}
