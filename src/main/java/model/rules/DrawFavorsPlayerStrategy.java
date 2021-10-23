package model.rules;

import model.Player;

public class DrawFavorsPlayerStrategy implements WinningStrategy {
    public boolean dealerWon(Player player, Player dealer, int maxScore) {
    
        if (player.calcScore() > maxScore) {
          return true;
        } else if (dealer.calcScore() > maxScore) {
          return false;
        }
        return player.calcScore() >= dealer.calcScore();
      }
    }
    

