package com.example.president;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.GameFramework.Game;
import com.example.GameFramework.infoMessage.GameInfo;
import com.example.GameFramework.infoMessage.GameState;
import com.example.GameFramework.players.GameComputerPlayer;

import java.util.ArrayList;
import java.util.Random;
/**
 * @author Yutaka Roberts
 * @author Anish Karumuri
 * @author Zella Run
 * @author Calvin Phuong
 * @version April 2023
 *
 * Our dumb AI randomly passes or places down a legal card
 * There is a small chance that the dumb AI can win the game
 * The dumb AI will check how many cards have been placed and place the same down if it can
 * it will only place the smallest numbers, making it easier for the human player to place down cards as well
 */
public class PresidentComputerPlayer extends GameComputerPlayer {
    /**
     * constructor
     *
     * @param name the player's name (e.g., "John")
     * This class contains our dumb AI
     *
     */

    int[] cards;
    int smallest;
    PresidentGameState PGS = new PresidentGameState();



    public ArrayList<Integer> pickCards (PresidentGameState gameState){
        int[] hand = gameState.allPlayers[gameState.currentPlayer];
        smallest = 14;
        //Finds the smallest card that is not below the current card value
        for(int i = 0; i < 13; i++) {
            if (smallest > hand[i] % 100 && hand[i] % 100 > gameState.currentCardNum) {
                smallest = hand[i] % 100;
            }
        }

        ArrayList<Integer> chosen = new ArrayList<>();
        for(int i = 0; i < 13; i++) {
            //Finds every card that has the value of 'smallest'
            //and puts them into an array
            if (hand[i] % 100 == smallest) {
                chosen.add(hand[i]);
            }

            //Break the loop if the round is new and one card has been chosen, or if only one card is necessary
            if (chosen.size() == 1 && gameState.cardsAtPlay == 0){
                break;
            }
            else if (chosen.size() == 1 && gameState.cardsAtPlay == 1) {
                break;
            }
        }
        //Sends chosen cards back to the MainActivity to be evaluated
        return chosen;
    }








    public PresidentComputerPlayer(String name) {
        super(name);
        cards = new int[13];
    }

    @Override
    protected void receiveInfo(GameInfo info) {
        PresidentGameState pga = (PresidentGameState) info;

        sleep(1000);
        PresidentPlaceAction app = new PresidentPlaceAction(this);
        this.game.sendAction(app);

    }
}
