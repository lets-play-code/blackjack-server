package mob.code.blackjack.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameRule {
    boolean isHostWin(List<String> hostCards, List<String> playerCards) {
        int hostSum = sum(hostCards);
        int playerSum = sum(playerCards);

        return hostSum > playerSum;
    }

    public int sum(List<String> cards){
        return cards.stream()
                .mapToInt(card -> getCardNum(card))
                .sum();
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
