package controller;

import model.Game;
import model.Subscriber;
import view.PlayerChoice;
import view.View;

/**
 * Scenario controller for playing the game.
 */
public class Player implements Subscriber {
  private Game game;
  private View view;

  Player(Game game, View view) {
    this.game = game;
    this.view = view;

    this.game.addSubcriberToDealer(this);
    this.game.addSubcriberToPlayer(this);
  }

  /**
   * Runs the play use case.

   * @return True as long as the game should continue.
   */
  public boolean play() {
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
 

  public void updateHand() {
    pause();
    view.displayDealerHand(game.getDealerHand(), game.getDealerScore());
    view.displayPlayerHand(game.getPlayerHand(), game.getPlayerScore());
  }

  private void pause() {
    try {
      System.out.println("Cards are drawn");
      Thread.sleep(2 * 1000); 
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}






