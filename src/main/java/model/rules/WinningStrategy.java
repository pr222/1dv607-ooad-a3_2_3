package model.rules;

import model.Player;

/**
 * Rule interface for deciding wether the dealer has won against the player.
 */
public interface WinningStrategy {
    boolean dealerWon(Player player, Player dealer, int maxScore);
}
    

