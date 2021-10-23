package model.rules;

import model.Card;
import model.Player;

class Soft17Strategy implements HitStrategy {
  private static final int hitLimit = 17;

  public boolean doHit(Player dealer) {
    int score = dealer.calcScore();
    boolean hit = false;

    if (score < hitLimit) {
        hit = true;
    } else if (score == 17) {
        for (Card c : dealer.getHand()) {
            if (c.getValue() != Card.Value.Ace) {
                hit = true;
            }
        }
    }
      
    return hit;
  }
}


