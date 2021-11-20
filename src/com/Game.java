package com;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private String gameId;
    List<Player> listOfPlayers = new ArrayList<>();
    List<Card> cards = new ArrayList<>();
    public int total[] = new int[3];
    private int counter;

    public Game(String gameId, List<Player> listOfPlayers) {
        this.gameId = gameId;
        this.listOfPlayers = listOfPlayers;
    }


    public void shuffleDeck(Deck currentDeck) {
        currentDeck.shuffle();
    }

    public void dealCard(Deck currentDeck) {

        shuffleDeck(currentDeck);
        for (Player player : listOfPlayers) {
            player.addCard(currentDeck.cards.get(0));
            currentDeck.removeCard(currentDeck.cards.get(0));
            player.addCard(currentDeck.cards.get(0));
            currentDeck.removeCard(currentDeck.cards.get(0));
        }
//        counter += 6;

    }


    public void play(Deck currentDeck) {
        for (int i = 0; i < total.length; i++) {
            total[i] = listOfPlayers.get(i).getCardTotal();
        }

        for (int i = 0; i < total.length; i++) {
            if (total[i] > 21) {
                listOfPlayers.get(i).setLastActivity(lastActivity.GO_BURST);
                System.out.println(lastActivity.GO_BURST);
                total[i] = 0;
            } else if (total[i] >= 17) {
                listOfPlayers.get(i).setLastActivity(lastActivity.STICK);
                System.out.println(lastActivity.STICK);
            } else if (total[i] < 17) {
                listOfPlayers.get(i).setLastActivity(lastActivity.HIT);
                System.out.println(lastActivity.HIT);
                listOfPlayers.get(i).addCard(currentDeck.cards.get(0));
                currentDeck.removeCard(currentDeck.cards.get(0));
            }
        }
    }

    //public int


    public int maxIndex() {
        int index = 0;
        for (int i = 0; i < total.length; i++) {
            int max = total[i];

            if (total[i] > max) {
                max = total[i];
                index = i;
            }
        }
        return index;
    }

    public Boolean isCompleted() {
        int index = maxIndex();
        int max = total[index];
        Boolean returnee = false;

        int losers = 0;
        for (int j = 0; j < total.length; j++) {
            if (total[j] == 0) {
                losers += 1;
            }
        }

        if (max == 21) {
            System.out.println("The game has ended, " + listOfPlayers.get(index) + "Is the WINNER!!!");
            returnee = true;
        } else if (listOfPlayers.get(0).getLastActivity() == lastActivity.STICK &&
                listOfPlayers.get(1).getLastActivity() == lastActivity.STICK &&
                listOfPlayers.get(2).getLastActivity() == lastActivity.STICK) {
            System.out.println("The game has ended, no one won");

            returnee = true;
        } else if (losers == 2) {
            System.out.println("The game has ended! Player -  " + listOfPlayers.get(index).getId() + "is the WINNER!!!");
            returnee = true;
        }
//        }else
//            {
//                returnee = false;
//            }

        return returnee;
    }
}