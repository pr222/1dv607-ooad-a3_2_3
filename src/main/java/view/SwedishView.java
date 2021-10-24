package view;

/**
 * Implements a Swedish console view.
 */
public class SwedishView implements View, Subscriber {

  /**
   * Shows a welcome message.
   */
  public void displayWelcomeMessage() {
    for (int i = 0; i < 50; i++) {
      System.out.print("\n");
    }

    System.out.println("Hej Black Jack Världen");
    System.out.println("----------------------");
  }

  /**
   * Shows menu for player action.
   */
  public PlayerChoice displayGameMenu() {
    System.out.println("Skriv 's' för att spela, 'k' för nytt kort, 'p' för att passa 'a' för att avsluta\n");
    int input = getInput();
    PlayerChoice choice;

    if (input == 's') {
      choice = PlayerChoice.PLAY;
    } else if (input == 'k') {
      choice = PlayerChoice.HIT;
    } else if (input == 'p') {
      choice = PlayerChoice.STAND;
    } else if (input == 'a') {
      choice = PlayerChoice.QUIT;
    } else {
      choice = PlayerChoice.NONE;
    }
    return choice;
  }

  /**
   * Returns pressed characters from the keyboard.

   * @return the pressed character.
   */
  public int getInput() {
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }
      return c;
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return 0;
    }
  }

  /**
   * Displays a card.

   * @param card The card to display.
   */
  public void displayCard(model.Card card) {
    if (card.getColor() == model.Card.Color.Hidden) {
      System.out.println("Dolt Kort");
    } else {
      String[] colors = { "Hjärter", "Spader", "Ruter", "Klöver" };
      String[] values = { "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio",
                          "knekt", "dam", "kung", "ess" };
      System.out.println("" + colors[card.getColor().ordinal()] + " " + values[card.getValue().ordinal()]);
    }
  }

  public void displayPlayerHand(Iterable<model.Card> hand, int score) {
    displayHand("Spelare", hand, score);
  }

  public void displayDealerHand(Iterable<model.Card> hand, int score) {
    displayHand("Croupier", hand, score);
  }

  /**
   * Displays the winner of the game.

   * @param dealerIsWinner True if the dealer is the winner.
   */
  public void displayGameOver(boolean dealerIsWinner) {
    System.out.println("Slut: ");
    if (dealerIsWinner) {
      System.out.println("Croupiern Vann!");
    } else {
      System.out.println("Du vann!");
    }
  }

  private void displayHand(String name, Iterable<model.Card> hand, int score) {
    System.out.println(name + " Har: " + score);
    for (model.Card c : hand) {
      displayCard(c);
    }
    System.out.println("Poäng: " + score);
    System.out.println("");
  }

  public void updateHand(Iterable<model.Card> hand) { // handen eller playern
    pause();

    for (model.Card card : hand) {
      displayCard(card);
    }
    // loopa hand och visa korten
  }

  private void pause() {
    try {
      Thread.sleep(5 * 1000); 
    } catch (InterruptedException e) {
      e.printStackTrace();
    }    
  }
}
