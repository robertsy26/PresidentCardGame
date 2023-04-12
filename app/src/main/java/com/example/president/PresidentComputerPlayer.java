package com.example.president;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;

import com.example.GameFramework.Game;
import com.example.GameFramework.infoMessage.GameInfo;
import com.example.GameFramework.infoMessage.GameState;
import com.example.GameFramework.players.GameComputerPlayer;

import java.util.Random;

public class PresidentComputerPlayer extends GameComputerPlayer {
    /**
     * constructor
     *
     * @param name the player's name (e.g., "John")
     */

    int[] cards;
    int smallest;
    int counter = 0;
    PresidentGameState PGS = new PresidentGameState();


    Random rand = new Random();

    int randomizer = rand.nextInt(10);

    public void PresidentDumbAI (PresidentGameState gameState){
        if(randomizer % 2 == 0){
            //Turn goes to next player
            gameState.currentPlayer++;
            //A check to ensure the currentPlayer stays with 0-3 range
            if (gameState.currentPlayer > 3) {
                gameState.currentPlayer = 0;
            }
            //Prepares displayed hand for next player
            ImageView[] views = new ImageView[]{iv_card1,iv_card2,iv_card3,iv_card4,iv_card5,iv_card6,iv_card7,iv_card8,iv_card9,iv_card10,iv_card11,iv_card12,iv_card13, imageView2};
            presidentUI.updateCards(views, gameState.allPlayers[gameState.currentPlayer]);

            //Increments number of passes
            gameState.passCount++;
            //After a pass, if number of passes is 3, then the round resets
            if (gameState.passCount == 3){
                //Resets certain UI elements to prepare for new round
                gameState.cardsAtPlay = 0;
                card.assignImages(500, imageView2);
                presidentUI.updateChosenCardsTotal(chosenCardsTotal, gameState.cardsAtPlay);
            }
            //Resets certain UI elements to prepare for the next player
            views = presidentUI.resetCards(views);
            chosenCards.clear();
            presidentUI.updateButtonColor(placeCards, Color.RED);
            playerNumberText = presidentUI.updatePlayerNumberText(playerNumberText, gameState.currentPlayer, false);



        } else {
            int curPlayer = PGS.getCurrentPlayer();

            for(int i = 0; i < 13; i++){
                if(smallest%100 == i % 100 ){
                    counter++;
                }
            }

            for(int i=0; i<13; i++) {
               smallest = PGS.allPlayers[curPlayer][i];
                if(smallest > PGS.allPlayers[curPlayer][i]) {
                    smallest = PGS.allPlayers[curPlayer][i];
                }


                if (card.legal(chosenCards, gameState.cardsAtPlay, gameState.currentCardNum)){
                    //Since the cards are the same number, the displayed image is the first chosen card
                    card.assignImages(chosenCards.get(0), imageView2);
                    iv_deck.setVisibility(View.VISIBLE);
                    gameState.cardsAtPlay = chosenCards.size();
                    //Updates current card value to chosen card value
                    gameState.currentCardNum = chosenCards.get(0) % 100;
                    presidentUI.updateChosenCardsTotal(chosenCardsTotal, gameState.cardsAtPlay);
                    presidentUI.updateButtonColor(placeCards, Color.RED);
                    gameState.passCount = 0;

                    //Finds chosen cards in current player's hand and turns those values into 0
                    while (chosenCards.size() != 0){
                        for (int i = 0; i < 13; i++){
                            if (chosenCards.get(0) == gameState.allPlayers[gameState.currentPlayer][i]){
                                gameState.allPlayers[gameState.currentPlayer][i] = 0;
                                break;
                            }
                        }
                        chosenCards.remove(Integer.valueOf(chosenCards.get(0)));
                    }

                    ImageView[] views = new ImageView[]{iv_card1,iv_card2,iv_card3,iv_card4,iv_card5,iv_card6,iv_card7,iv_card8,iv_card9,iv_card10,iv_card11,iv_card12,iv_card13, imageView2};
                    views = presidentUI.updateCards(views, gameState.allPlayers[gameState.currentPlayer]);
                    playerNumberText = presidentUI.updatePlayerNumberText(playerNumberText, gameState.currentPlayer, false);

                    //Counts all of the 0 values in current player's hand
                    int count = 0;
                    for (int i = 0; i < 13; i++){
                        if (gameState.allPlayers[gameState.currentPlayer][i] == 0)
                            count++;
                    }
                    //If 13 zeroes are counted, then the current player has won
                    //and all of the buttons become unclickable
                    if (count == 13){
                        for (int i = 0; i < 13; i++){
                            views[i].setClickable(false);
                        }
                        passButton.setClickable(false);
                        playerNumberText = presidentUI.updatePlayerNumberText(playerNumberText, gameState.currentPlayer, true);
                    }
                    //Otherwise, turn goes to next player
                    else {
                        gameState.currentPlayer++;
                        //A check to ensure the currentPlayer stays with 0-3 range
                        if (gameState.currentPlayer > 3) {
                            gameState.currentPlayer = 0;
                        }
                        //Resets certain UI elements to prepare for the next player
                        presidentUI.updateCards(views, gameState.allPlayers[gameState.currentPlayer]);
                        views = presidentUI.resetCards(views);
                        chosenCards.clear();
                        presidentUI.updateButtonColor(placeCards, Color.RED);
                        playerNumberText = presidentUI.updatePlayerNumberText(playerNumberText, gameState.currentPlayer, false);
                    }
                }

            }


        }
    }






    public PresidentComputerPlayer(String name) {
        super(name);
        cards = new int[13];
    }

    @Override
    protected void receiveInfo(GameInfo info) {
        PresidentGameState pga = (PresidentGameState) info;
        if(pga.getPlayerId() != playerNum){
            return;
        }
        Random r = new Random();
        if (r.nextBoolean()) {
            sleep(1000);
            PresidentPassAction ppa = new PresidentPassAction(this);
            this.game.sendAction(ppa);
        } else {
            sleep(1000);
            PresidentPlaceAction app = new PresidentPlaceAction(this);
            this.game.sendAction(app);

        }

    }
}
