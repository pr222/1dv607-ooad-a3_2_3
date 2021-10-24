package model.rules;

import model.Player;

/**
 * Rule interface for deciding wether the dealer has won against the player.
 * 
 */
public interface WinningStrategy {
  /**
   * Encapsulating check for if dealer won.

   * @param dealer The dealer.
   * @param player The player.
   * @param maxScore The maximum score to compare points to.
   * @return boolean - true if dealer won.
   */
  boolean dealerWon(Player player, Player dealer, int maxScore);
}
    
 
