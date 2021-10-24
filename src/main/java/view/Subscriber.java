package view;

/**
 * Subscriber for when a hand is updated with a new card.
 */
public interface Subscriber {
  void updateHand(Iterable<model.Card> hand);
}
