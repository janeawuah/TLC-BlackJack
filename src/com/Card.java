package com;

public class Card {
    private Suit suit;
    private Values Values;

    public Card(Suit suit, Values Values) {
        this.suit = suit;
        this.Values = Values;
    }

    public Suit getSuit() {
        return suit;
    }

    public Values getCardFace() {
        return Values;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", cardValue=" + Values.getCardValue() +
                '}';
    }
}

