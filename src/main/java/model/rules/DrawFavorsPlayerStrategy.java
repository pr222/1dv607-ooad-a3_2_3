package model.rules;

import model.Player;

/**
 * Winning Strategy that favours the player in case of a draw.
 */
public class DrawFavorsPlayerStrategy implements WinningStrategy {
  /**
   * Check score and decides winner, if draw Player wins.
   */
  public boolean dealerWon(Player player, Player dealer, int maxScore) {
    if (player.calcScore() > maxScore) {
      return true;
    } else if (dealer.calcScore() > maxScore) {
      return false;
    }
    return player.calcScore() >= dealer.calcScore();
  }
}
