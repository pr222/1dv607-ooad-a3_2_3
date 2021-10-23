package model.rules;

import model.Player;

public class DrawFavorsDealerStrategy implements WinningStrategy {

  public boolean dealerWon(Player player, Player dealer, int maxScore) {
    
    if (player.calcScore() > maxScore) {
      return true;
    } else if (player.calcScore() > maxScore) {
      return false;
    }
    return dealer.calcScore() >= player.calcScore();
  }
}

