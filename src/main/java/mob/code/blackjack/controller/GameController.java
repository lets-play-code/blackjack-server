package mob.code.blackjack.controller;

import mob.code.blackjack.domain.GameDto;
import mob.code.blackjack.domain.Game;
import mob.code.blackjack.domain.GameResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:8090")
public class GameController {

    @Autowired
    Game game;

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
    public GameDto startGame(){
        return game.startGame();
    }

    @PostMapping("closedeal")
    public GameResult closeDeal() {
        return game.closeDeal();
    }

    @PostMapping("deal")
    public GameDto deal() {
        return game.deal();
    }
}
