package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    List<Card> cards = new ArrayList<>();

    public Deck() {
        createDeck();
    }

    private void createDeck() {
        for(Suit suit: Suit.values()){
            for(Values face : Values.values()){
                cards.add(new Card(suit, face));
            }
        }
    }

    private void createDeck(List deck) {
        cards.clear();
        cards.addAll(deck);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }

    public void removeCard(Card card){
        cards.remove(card);
    }
}