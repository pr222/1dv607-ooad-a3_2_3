package model.rules;

import model.Dealer;
import model.Deck;
import model.Player;


class InternationalNewGameStrategy implements NewGameStrategy {

  public boolean newGame(Deck deck, Dealer dealer, Player player) {

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

    return true;
  }
}