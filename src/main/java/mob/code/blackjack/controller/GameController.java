package mob.code.blackjack.controller;

import mob.code.blackjack.domain.Game;
import mob.code.blackjack.domain.GameCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:8090")
public class GameController {

    @Autowired
    GameCenter gameCenter;

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
        return gameCenter.startGame();
    }

}
