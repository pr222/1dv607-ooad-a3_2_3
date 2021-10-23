package controller;

import model.Game;
import view.PlayerChoice;
import view.View;


/**
 * Scenario controller for playing the game.
 */
public class Player {

  /**
   * Runs the play use case.

   * @param game The game state.
   * @param view The view to use.
   * @return True as long as the game should continue.
   */
  public boolean play(Game game, View view) {
    view.displayWelcomeMessage();

    view.displayDealerHand(game.getDealerHand(), game.getDealerScore());
    view.displayPlayerHand(game.getPlayerHand(), game.getPlayerScore());

    if (game.isGameOver()) {
      view.displayGameOver(game.isDealerWinner());
    }

    PlayerChoice choice = view.displayGameMenu();
    if (choice.equals(PlayerChoice.PLAY)) {
      game.newGame();
    } else if (choice.equals(PlayerChoice.HIT)) {
      game.hit();
    } else if (choice.equals(PlayerChoice.STAND)) {
      game.stand();
    }
    
    return !choice.equals(PlayerChoice.QUIT);
  }
}