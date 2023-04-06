package com.example.president;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.GameFramework.GameMainActivity;
import com.example.GameFramework.LocalGame;
import com.example.GameFramework.gameConfiguration.GameConfig;
import com.example.GameFramework.infoMessage.GameState;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ImageView iv_deck, iv_card1,iv_card2,iv_card3,iv_card4,iv_card5,iv_card6,iv_card7,iv_card8,iv_card9,iv_card10,iv_card11,iv_card12,iv_card13, imageView2;
    Cards card = new Cards();

    ArrayList<Integer> chosenCards = new ArrayList<>();
    Button placeCards;
    
    Button passButton;

    TextView chosenCardsTotal;

    TextView playerNumberText;

    PresidentUI presidentUI = new PresidentUI();
    PresidentGameState gameState = new PresidentGameState();

    //TextView playCardsCount = findViewById(R.id.cardPlay);


    @Override
    protected void onCreate (Bundle savedInstanceSate) {
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.activity_main);

        passButton = (Button) findViewById((R.id.passButton));
        placeCards = (Button) findViewById(R.id.placeCards);
        placeCards = presidentUI.updateButtonColor(placeCards, Color.RED);
        chosenCardsTotal = (TextView) findViewById(R.id.cardPlay);
        playerNumberText = (TextView) findViewById((R.id.playerNumber));

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
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        iv_card1.setVisibility(View.INVISIBLE);
        iv_card2.setVisibility(View.INVISIBLE);
        iv_card3.setVisibility(View.INVISIBLE);
        iv_card4.setVisibility(View.INVISIBLE);
        iv_card5.setVisibility(View.INVISIBLE);
        iv_card6.setVisibility(View.INVISIBLE);
        iv_card7.setVisibility(View.INVISIBLE);
        iv_card8.setVisibility(View.INVISIBLE);
        iv_card9.setVisibility(View.INVISIBLE);
        iv_card10.setVisibility(View.INVISIBLE);
        iv_card11.setVisibility(View.INVISIBLE);
        iv_card12.setVisibility(View.INVISIBLE);
        iv_card13.setVisibility(View.INVISIBLE);

        iv_deck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                card.setCards();

                for (int i = 0; i < 4; i++){
                    Collections.shuffle(card.cards);
                    for (int j  = 0; j < 13; j++){
                        gameState.allPlayers[i][j] = card.cards.get(j);
                    }
                }

                //Resets game variable back to default
                gameState.currentPlayer = 0;

                card.assignImages(gameState.allPlayers[0][0], iv_card1);
                card.assignImages(gameState.allPlayers[0][1], iv_card2);
                card.assignImages(gameState.allPlayers[0][2], iv_card3);
                card.assignImages(gameState.allPlayers[0][3], iv_card4);
                card.assignImages(gameState.allPlayers[0][4], iv_card5);
                card.assignImages(gameState.allPlayers[0][5], iv_card6);
                card.assignImages(gameState.allPlayers[0][6], iv_card7);
                card.assignImages(gameState.allPlayers[0][7], iv_card8);
                card.assignImages(gameState.allPlayers[0][8], iv_card9);
                card.assignImages(gameState.allPlayers[0][9], iv_card10);
                card.assignImages(gameState.allPlayers[0][10], iv_card11);
                card.assignImages(gameState.allPlayers[0][11], iv_card12);
                card.assignImages(gameState.allPlayers[0][12], iv_card13);

                iv_card1.setVisibility(View.VISIBLE);
                iv_card2.setVisibility(View.VISIBLE);
                iv_card3.setVisibility(View.VISIBLE);
                iv_card4.setVisibility(View.VISIBLE);
                iv_card5.setVisibility(View.VISIBLE);
                iv_card6.setVisibility(View.VISIBLE);
                iv_card7.setVisibility(View.VISIBLE);
                iv_card8.setVisibility(View.VISIBLE);
                iv_card9.setVisibility(View.VISIBLE);
                iv_card10.setVisibility(View.VISIBLE);
                iv_card11.setVisibility(View.VISIBLE);
                iv_card12.setVisibility(View.VISIBLE);
                iv_card13.setVisibility(View.VISIBLE);
                card.assignImages(500,imageView2);

                //Resets game variables back to default
                presidentUI.updateChosenCardsTotal(chosenCardsTotal, 0);
                ImageView[] views = new ImageView[]{iv_card1,iv_card2,iv_card3,iv_card4,iv_card5,iv_card6,iv_card7,iv_card8,iv_card9,iv_card10,iv_card11,iv_card12,iv_card13, imageView2};
                views = presidentUI.resetCards(views);
                chosenCards.clear();
                presidentUI.updateButtonColor(placeCards, Color.RED);
                gameState.cardsAtPlay = 0;
                playerNumberText = presidentUI.updatePlayerNumberText(playerNumberText, gameState.currentPlayer, false);
            }
        });

        placeCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (card.legal(chosenCards, gameState.cardsAtPlay, gameState.currentCardNum)){
                    card.assignImages(chosenCards.get(0), imageView2);
                    iv_deck.setVisibility(View.VISIBLE);
                    gameState.cardsAtPlay = chosenCards.size();
                    gameState.currentCardNum = chosenCards.get(0) % 100;
                    presidentUI.updateChosenCardsTotal(chosenCardsTotal, gameState.cardsAtPlay);
                    presidentUI.updateButtonColor(placeCards, Color.RED);
                    gameState.passCount = 0;

                    //Picked cards turn into 0
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

                    int count = 0;
                    for (int i = 0; i < 13; i++){
                        if (gameState.allPlayers[gameState.currentPlayer][i] == 0)
                            count++;
                    }
                    if (count == 13){
                        for (int i = 0; i < 13; i++){
                            views[i].setClickable(false);
                        }
                        passButton.setClickable(false);
                        playerNumberText = presidentUI.updatePlayerNumberText(playerNumberText, gameState.currentPlayer, true);
                    }
                    else {
                        gameState.currentPlayer++;
                        if (gameState.currentPlayer > 3) {
                            gameState.currentPlayer = 0;
                        }
                        presidentUI.updateCards(views, gameState.allPlayers[gameState.currentPlayer]);
                        views = presidentUI.resetCards(views);
                        chosenCards.clear();
                        presidentUI.updateButtonColor(placeCards, Color.RED);
                        playerNumberText = presidentUI.updatePlayerNumberText(playerNumberText, gameState.currentPlayer, false);
                    }
                }
            }
        });

        passButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameState.currentPlayer++;
                if (gameState.currentPlayer > 3) {
                    gameState.currentPlayer = 0;
                }
                ImageView[] views = new ImageView[]{iv_card1,iv_card2,iv_card3,iv_card4,iv_card5,iv_card6,iv_card7,iv_card8,iv_card9,iv_card10,iv_card11,iv_card12,iv_card13, imageView2};
                presidentUI.updateCards(views, gameState.allPlayers[gameState.currentPlayer]);

                gameState.passCount++;
                if (gameState.passCount == 3){
                    gameState.cardsAtPlay = 0;
                    card.assignImages(500, imageView2);
                    presidentUI.updateChosenCardsTotal(chosenCardsTotal, gameState.cardsAtPlay);
                }
                views = presidentUI.resetCards(views);
                chosenCards.clear();
                presidentUI.updateButtonColor(placeCards, Color.RED);
                playerNumberText = presidentUI.updatePlayerNumberText(playerNumberText, gameState.currentPlayer, false);
            }
        });

        /*
        iv_card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_deck.setVisibility((View.VISIBLE));
                card.assignImages(card.cards.get(0), imageView2);
                iv_card1.setVisibility((View.INVISIBLE));
            }
        });
         */
        iv_card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iv_card1.getPaddingBottom() == 0) {
                    iv_card1.setPadding(0, 0, 0, 50);
                    chosenCards.add(gameState.allPlayers[gameState.currentPlayer][0]);
                }
                else {
                    iv_card1.setPadding(0, 0, 0, 0);
                    chosenCards.remove(Integer.valueOf(gameState.allPlayers[gameState.currentPlayer][0]));
                }

                if (card.legal(chosenCards, gameState.cardsAtPlay, gameState.currentCardNum)){
                    presidentUI.updateButtonColor(placeCards, Color.GREEN);
                }
                else{
                    presidentUI.updateButtonColor(placeCards, Color.RED);
                }
            }
        });
        iv_card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iv_card2.getPaddingBottom() == 0) {
                    iv_card2.setPadding(0, 0, 0, 50);
                    chosenCards.add(gameState.allPlayers[gameState.currentPlayer][1]);
                }
                else {
                    iv_card2.setPadding(0, 0, 0, 0);
                    chosenCards.remove(Integer.valueOf(gameState.allPlayers[gameState.currentPlayer][1]));
                }

                if (card.legal(chosenCards, gameState.cardsAtPlay, gameState.currentCardNum)){
                    presidentUI.updateButtonColor(placeCards, Color.GREEN);
                }
                else{
                    presidentUI.updateButtonColor(placeCards, Color.RED);
                }
            }
        });
        iv_card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iv_card3.getPaddingBottom() == 0) {
                    iv_card3.setPadding(0, 0, 0, 50);
                    chosenCards.add(gameState.allPlayers[gameState.currentPlayer][2]);
                }
                else {
                    iv_card3.setPadding(0, 0, 0, 0);
                    chosenCards.remove(Integer.valueOf(gameState.allPlayers[gameState.currentPlayer][2]));
                }

                if (card.legal(chosenCards, gameState.cardsAtPlay, gameState.currentCardNum)){
                    presidentUI.updateButtonColor(placeCards, Color.GREEN);
                }
                else{
                    presidentUI.updateButtonColor(placeCards, Color.RED);
                }
            }
        });
        iv_card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iv_card4.getPaddingBottom() == 0) {
                    iv_card4.setPadding(0, 0, 0, 50);
                    chosenCards.add(gameState.allPlayers[gameState.currentPlayer][3]);
                }
                else {
                    iv_card4.setPadding(0, 0, 0, 0);
                    chosenCards.remove(Integer.valueOf(gameState.allPlayers[gameState.currentPlayer][3]));
                }

                if (card.legal(chosenCards, gameState.cardsAtPlay, gameState.currentCardNum)){
                    presidentUI.updateButtonColor(placeCards, Color.GREEN);
                }
                else{
                    presidentUI.updateButtonColor(placeCards, Color.RED);
                }
            }
        });
        iv_card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iv_card5.getPaddingBottom() == 0) {
                    iv_card5.setPadding(0, 0, 0, 50);
                    chosenCards.add(gameState.allPlayers[gameState.currentPlayer][4]);
                }
                else {
                    iv_card5.setPadding(0, 0, 0, 0);
                    chosenCards.remove(Integer.valueOf(gameState.allPlayers[gameState.currentPlayer][4]));
                }

                if (card.legal(chosenCards, gameState.cardsAtPlay, gameState.currentCardNum)){
                    presidentUI.updateButtonColor(placeCards, Color.GREEN);
                }
                else{
                    presidentUI.updateButtonColor(placeCards, Color.RED);
                }
            }
        });
        iv_card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iv_card6.getPaddingBottom() == 0) {
                    iv_card6.setPadding(0, 0, 0, 50);
                    chosenCards.add(gameState.allPlayers[gameState.currentPlayer][5]);
                }
                else {
                    iv_card6.setPadding(0, 0, 0, 0);
                    chosenCards.remove(Integer.valueOf(gameState.allPlayers[gameState.currentPlayer][5]));
                }

                if (card.legal(chosenCards, gameState.cardsAtPlay, gameState.currentCardNum)){
                    presidentUI.updateButtonColor(placeCards, Color.GREEN);
                }
                else{
                    presidentUI.updateButtonColor(placeCards, Color.RED);
                }
            }
        });
        iv_card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iv_card7.getPaddingBottom() == 0) {
                    iv_card7.setPadding(0, 0, 0, 50);
                    chosenCards.add(gameState.allPlayers[gameState.currentPlayer][6]);
                }
                else {
                    iv_card7.setPadding(0, 0, 0, 0);
                    chosenCards.remove(Integer.valueOf(gameState.allPlayers[gameState.currentPlayer][6]));
                }

                if (card.legal(chosenCards, gameState.cardsAtPlay, gameState.currentCardNum)){
                    presidentUI.updateButtonColor(placeCards, Color.GREEN);
                }
                else{
                    presidentUI.updateButtonColor(placeCards, Color.RED);
                }
            }
        });
        iv_card8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iv_card8.getPaddingBottom() == 0) {
                    iv_card8.setPadding(0, 0, 0, 50);
                    chosenCards.add(gameState.allPlayers[gameState.currentPlayer][7]);
                }
                else {
                    iv_card8.setPadding(0, 0, 0, 0);
                    chosenCards.remove(Integer.valueOf(gameState.allPlayers[gameState.currentPlayer][7]));
                }

                if (card.legal(chosenCards, gameState.cardsAtPlay, gameState.currentCardNum)){
                    presidentUI.updateButtonColor(placeCards, Color.GREEN);
                }
                else{
                    presidentUI.updateButtonColor(placeCards, Color.RED);
                }
            }
        });

        iv_card9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iv_card9.getPaddingBottom() == 0) {
                    iv_card9.setPadding(0, 0, 0, 50);
                    chosenCards.add(gameState.allPlayers[gameState.currentPlayer][8]);
                }
                else {
                    iv_card9.setPadding(0, 0, 0, 0);
                    chosenCards.remove(Integer.valueOf(gameState.allPlayers[gameState.currentPlayer][8]));
                }

                if (card.legal(chosenCards, gameState.cardsAtPlay, gameState.currentCardNum)){
                    presidentUI.updateButtonColor(placeCards, Color.GREEN);
                }
                else{
                    presidentUI.updateButtonColor(placeCards, Color.RED);
                }
            }
        });

        iv_card10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iv_card10.getPaddingBottom() == 0) {
                    iv_card10.setPadding(0, 0, 0, 50);
                    chosenCards.add(gameState.allPlayers[gameState.currentPlayer][9]);
                }
                else {
                    iv_card10.setPadding(0, 0, 0, 0);
                    chosenCards.remove(Integer.valueOf(gameState.allPlayers[gameState.currentPlayer][9]));
                }

                if (card.legal(chosenCards, gameState.cardsAtPlay, gameState.currentCardNum)){
                    presidentUI.updateButtonColor(placeCards, Color.GREEN);
                }
                else{
                    presidentUI.updateButtonColor(placeCards, Color.RED);
                }
            }
        });

        iv_card11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iv_card11.getPaddingBottom() == 0) {
                    iv_card11.setPadding(0, 0, 0, 50);
                    chosenCards.add(gameState.allPlayers[gameState.currentPlayer][10]);
                }
                else {
                    iv_card11.setPadding(0, 0, 0, 0);
                    chosenCards.remove(Integer.valueOf(gameState.allPlayers[gameState.currentPlayer][10]));
                }

                if (card.legal(chosenCards, gameState.cardsAtPlay, gameState.currentCardNum)){
                    presidentUI.updateButtonColor(placeCards, Color.GREEN);
                }
                else{
                    presidentUI.updateButtonColor(placeCards, Color.RED);
                }
            }
        });

        iv_card12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iv_card12.getPaddingBottom() == 0) {
                    iv_card12.setPadding(0, 0, 0, 50);
                    chosenCards.add(gameState.allPlayers[gameState.currentPlayer][11]);
                }
                else {
                    iv_card12.setPadding(0, 0, 0, 0);
                    chosenCards.remove(Integer.valueOf(gameState.allPlayers[gameState.currentPlayer][11]));
                }

                if (card.legal(chosenCards, gameState.cardsAtPlay, gameState.currentCardNum)){
                    presidentUI.updateButtonColor(placeCards, Color.GREEN);
                }
                else{
                    presidentUI.updateButtonColor(placeCards, Color.RED);
                }
            }
        });

        iv_card13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iv_card13.getPaddingBottom() == 0) {
                    iv_card13.setPadding(0, 0, 0, 50);
                    chosenCards.add(gameState.allPlayers[gameState.currentPlayer][12]);
                }
                else {
                    iv_card13.setPadding(0, 0, 0, 0);
                    chosenCards.remove(Integer.valueOf(gameState.allPlayers[gameState.currentPlayer][12]));
                }

                if (card.legal(chosenCards, gameState.cardsAtPlay, gameState.currentCardNum)){
                    presidentUI.updateButtonColor(placeCards, Color.GREEN);
                }
                else{
                    presidentUI.updateButtonColor(placeCards, Color.RED);
                }
            }
        });




    }









}




//private static final int PORT_NUMBER = 3384;




   /* @Override
    public GameConfig createDefaultConfig() {

        ArrayList<GamePlayerType> playerType = new ArrayList<>();
        playerType.add(new GamePlayerType("Human Player") {
            @Override
            public GamePlayer createPlayer(String name) {
                return new HumanPlayer(name);
            }
        });

        playerType.add(new GamePlayerType("Computer Player") {
            @Override
            public GamePlayer createPlayer(String name) {
                return new PresidentComputerPlayer(name);
            }
        });

        GameConfig defaultConfig = new GameConfig(playerType, 4, 4, "Pig", PORT_NUMBER);
        defaultConfig.addPlayer("Human", 0); // player 1: a human player
        defaultConfig.addPlayer("Computer", 1); // player 2: a computer player
        defaultConfig.addPlayer("Computer", 2);
        defaultConfig.addPlayer("Computer",4);

        defaultConfig.setRemoteData("Remote Human Player", "", 0);

        return defaultConfig;


    }


    public LocalGame createLocalGame(GameState gameState) {
        return null;
    }





}

    */