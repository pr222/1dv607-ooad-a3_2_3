
package model.rules;

import model.Dealer;
import model.Deck;
import model.Player;

class AmericanNewGameStrategy implements NewGameStrategy {

  public boolean newGame(Deck deck, Dealer dealer, Player player) {
    // Card.Mutable c;

    deck.dealCard(player, true);
    // c = deck.getCard();
    // c.show(true);
    // player.dealCard(c);

    deck.dealCard(dealer, true);
    // c = deck.getCard();
    // c.show(true);
    // dealer.dealCard(c);

    deck.dealCard(player, true);
    // c = deck.getCard();
    // c.show(true);
    // player.dealCard(c);

    deck.dealCard(dealer, false);
    // c = deck.getCard();
    // c.show(false);
    // dealer.dealCard(c);

    return true;
  }
}