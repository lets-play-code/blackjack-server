package mob.code.blackjack.controller;

import org.springframework.web.bind.annotation.*;

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
    public String startGame(){
        return "{\n" +
                "            \"host\":[\"B8\"],\n" +
                "            \"player\":[\"A8\",\"C8\"]\n" +
                "           }";
    }

}
