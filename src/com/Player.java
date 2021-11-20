package com;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String id;
    private List<Card> cardStore = new ArrayList<>();
    private lastActivity lastActivity;


    public Player(String id, List<Card> cardStore) {
        this.id = id;
        this.cardStore = cardStore;
        //this.lastActivity = lastActivity;
    }

    public void addCard(Card card) {
        this.cardStore.add(card);
    }

    public int getCardTotal() {
        int cardTotal = 0;
        for(Card card: cardStore){
            cardTotal += card.getCardFace().getCardValue();
        }
        return cardTotal;
    }

    public String getId() {
        return id;
    }


    public List<Card> getCardStore() {
        return cardStore;
    }

    public lastActivity getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(lastActivity lastActivity) {
        this.lastActivity = lastActivity;
    }
}