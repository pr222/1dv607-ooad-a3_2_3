package model.rules;

import model.Player;

/**
 * Checks who is wins.
 */
public class DrawFavorsDealerStrategy implements WinningStrategy {

  /**
   * Checks scores for Player and Dealer, Dealer wins if draw.
   */
  public boolean dealerWon(Player player, Player dealer, int maxScore) {
    
    if (player.calcScore() > maxScore) {
      return true;
    } else if (player.calcScore() > maxScore) {
      return false;
    }
    return dealer.calcScore() >= player.calcScore();
  }
}

