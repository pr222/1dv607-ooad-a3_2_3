package model.rules;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.*;

import model.Card;
import model.Player;

public class Soft17StrategyTest {
  @Test void hitsWhenSoft() {
    Player p = new Player();
    HitStrategy strat = new Soft17Strategy();

    Card.Mutable ace = new Card.Mutable(Card.Color.Clubs, Card.Value.Ace);
    Card.Mutable six = new Card.Mutable(Card.Color.Clubs, Card.Value.Six);

    ace.show(true);
    six.show(true);

    p.dealCard(ace);
    p.dealCard(six);
    
    boolean willHit = strat.doHit(p);
    assertTrue(willHit);
  }

  @Test void willNotWantToHit() {
    
    Player p2 = new Player();
    HitStrategy strat2 = new Soft17Strategy();

    Card.Mutable ace2 = new Card.Mutable(Card.Color.Clubs, Card.Value.Ace);
    Card.Mutable seven = new Card.Mutable(Card.Color.Clubs, Card.Value.Ten);

    ace2.show(true);
    seven.show(true);

    p2.dealCard(ace2);
    p2.dealCard(seven);
    
    boolean willHit2 = strat2.doHit(p2);
    assertFalse(willHit2);
  }
}
