package com;

public enum Values {

    //enum contents contain fields with different values
    ACE(11), DEUCE(2), THREE(3),
    FOUR(4), FIVE(5), SIX(6),
    SEVEN(7), EIGHT(8), NINE(9),
    TEN(10), JACK(10), QUEEN(10),
    KING(10);

    private final int cardValue;

    //Constructor for enum of cardFace which takes in an int and when they defined this constructor is called and the int value in enum field is passed
    private Values(int cardValue) {
        this.cardValue = cardValue;
    }

    //Access the enum
    public int getCardValue() {
        return this.cardValue;
    }

}
