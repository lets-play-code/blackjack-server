package mob.code.blackjack.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameRule {

    public static final int BUST_THRESHOLD = 21;

    boolean isHostWin(List<String> hostCards, List<String> playerCards) {
        int hostSum = sum(hostCards);
        int playerSum = sum(playerCards);
        if (isBust(hostSum)) return false;
        return hostSum > playerSum;
    }

    public boolean isBust(int sum) {
        return sum > BUST_THRESHOLD;
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

    boolean isBust(List<String> cards) {
        return isBust(sum(cards));
    }
}
