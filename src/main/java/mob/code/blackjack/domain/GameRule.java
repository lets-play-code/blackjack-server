package mob.code.blackjack.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameRule {
    boolean isHostWin(List<String> hostCards, List<String> playerCards) {
        int hostSum = hostCards.stream().mapToInt(card -> Integer.parseInt(card.substring(1))).sum();
        int playerSum = playerCards.stream().mapToInt(card -> Integer.parseInt(card.substring(1))).sum();

        return hostSum > playerSum;
    }
}
