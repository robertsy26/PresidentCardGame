package com.example.president;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PresidentUI extends AppCompatActivity {

    PresidentGameState gameState;
    Button placeCards;

    ImageView iv_deck, iv_card1,iv_card2,iv_card3,iv_card4,iv_card5,iv_card6,iv_card7,iv_card8,iv_card9,iv_card10,iv_card11,iv_card12,iv_card13;

    public PresidentUI(PresidentGameState gameState){
        this.gameState = gameState;
        placeCards.findViewById(R.id.placeCards);
    }

    //temporary name
    public void updateCards(){
        //number of cards
        gameState.getPlayer1Cards();
        //array of player 1's cards
        gameState.getPlayer1Cards();

        /*
        If displayed cards are in an array, I could set every card
        in display to the player's cards in array
         */

        int player = gameState.currentPlayer - 1;

        for (int i = 0; i < gameState.allPlayers[player].length; i++){
                //displayCards[i] = gameState.allPlayers[player][i];
        }

        //Current player and individual player cards are different
        //Putting the players into an array would turn change easier
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_deck = (ImageView) findViewById(R.id.iv_deck);
        iv_card1 = (ImageView) findViewById(R.id.iv_card1);
        iv_card2 = (ImageView) findViewById(R.id.iv_card2);
        iv_card3 = (ImageView) findViewById(R.id.iv_card3);
        iv_card4 = (ImageView) findViewById(R.id.iv_card4);
        iv_card5 = (ImageView) findViewById(R.id.iv_card5);
        iv_card6 = (ImageView) findViewById(R.id.iv_card6);
        iv_card7 = (ImageView) findViewById(R.id.iv_card7);
        iv_card8 = (ImageView) findViewById(R.id.iv_card8);
        iv_card9 = (ImageView) findViewById(R.id.iv_card9);
        iv_card10 = (ImageView) findViewById(R.id.iv_card10);
        iv_card11 = (ImageView) findViewById(R.id.iv_card11);
        iv_card12 = (ImageView) findViewById(R.id.iv_card12);
        iv_card13 = (ImageView) findViewById(R.id.iv_card13);
    }
}
