
package model.rules;

import model.Dealer;
import model.Deck;
import model.Player;

class AmericanNewGameStrategy implements NewGameStrategy {

  public boolean newGame(Deck deck, Dealer dealer, Player player) {
    deck.dealCard(player, true);
    deck.dealCard(dealer, true);
    deck.dealCard(player, true);
    deck.dealCard(dealer, false);

    return true;
  }
}