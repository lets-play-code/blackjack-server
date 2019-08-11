package mob.code.blackjack.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameRule {
    boolean isHostWin(List<String> hostCards, List<String> playerCards) {
        int hostSum = hostCards.stream()
                .mapToInt(card -> getCardNum(card))
                .sum();
        int playerSum = playerCards.stream()
                .mapToInt(card -> getCardNum(card))
                .sum();

        return hostSum > playerSum;
    }

    private int getCardNum(String card) {
        String cardCode = getCardCode(card);
        if (cardCode.matches("[ABDE]")) {
            return 10;
        } else {
            return Integer.parseInt(cardCode);
        }
    }

    private String getCardCode(String card) {
        return card.substring(1);
    }
}
