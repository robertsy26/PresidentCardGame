package com.example.president;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.GameFramework.GameMainActivity;
import com.example.GameFramework.LocalGame;
import com.example.GameFramework.gameConfiguration.GameConfig;
import com.example.GameFramework.infoMessage.GameState;

import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ImageView iv_deck, iv_card1,iv_card2,iv_card3,iv_card4,iv_card5,iv_card6,iv_card7,iv_card8,iv_card9,iv_card10,iv_card11,iv_card12,iv_card13, imageView2;
    Cards card = new Cards();


    @Override
    protected void onCreate (Bundle savedInstanceSate) {
        super.onCreate(savedInstanceSate);
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
                Collections.shuffle(card.cards);

                card.assignImages(card.cards.get(0), iv_card1);
                card.assignImages(card.cards.get(1), iv_card2);
                card.assignImages(card.cards.get(2), iv_card3);
                card.assignImages(card.cards.get(3), iv_card4);
                card.assignImages(card.cards.get(4), iv_card5);
                card.assignImages(card.cards.get(5), iv_card6);
                card.assignImages(card.cards.get(6), iv_card7);
                card.assignImages(card.cards.get(7), iv_card8);
                card.assignImages(card.cards.get(8), iv_card9);
                card.assignImages(card.cards.get(9), iv_card10);
                card.assignImages(card.cards.get(10), iv_card11);
                card.assignImages(card.cards.get(11), iv_card12);
                card.assignImages(card.cards.get(12), iv_card13);

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





            }
        });

        iv_card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_deck.setVisibility((View.VISIBLE));
                card.assignImages(card.cards.get(0), imageView2);
                iv_deck.setClickable(false);
                iv_card1.setVisibility((View.INVISIBLE));
            }
        });
        iv_card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_deck.setVisibility((View.VISIBLE));
                card.assignImages(card.cards.get(1), imageView2);
                iv_deck.setClickable(false);
                iv_card2.setVisibility((View.INVISIBLE));

            }
        });
        iv_card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_deck.setVisibility((View.VISIBLE));
                card.assignImages(card.cards.get(2), imageView2);
                iv_deck.setClickable(false);
                iv_card3.setVisibility((View.INVISIBLE));

            }
        });
        iv_card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_deck.setVisibility((View.VISIBLE));
                card.assignImages(card.cards.get(3), imageView2);
                iv_deck.setClickable(false);
                iv_card4.setVisibility((View.INVISIBLE));

            }
        });
        iv_card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_deck.setVisibility((View.VISIBLE));
                card.assignImages(card.cards.get(4), imageView2);
                iv_deck.setClickable(false);
                iv_card5.setVisibility((View.INVISIBLE));

            }
        });
        iv_card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_deck.setVisibility((View.VISIBLE));
                card.assignImages(card.cards.get(5), imageView2);
                iv_deck.setClickable(false);
                iv_card6.setVisibility((View.INVISIBLE));

            }
        });
        iv_card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_deck.setVisibility((View.VISIBLE));
                card.assignImages(card.cards.get(6), imageView2);
                iv_deck.setClickable(false);
                iv_card7.setVisibility((View.INVISIBLE));

            }
        });
        iv_card8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_deck.setVisibility((View.VISIBLE));
                card.assignImages(card.cards.get(7), imageView2);
                iv_deck.setClickable(false);
                iv_card8.setVisibility((View.INVISIBLE));

            }
        });

        iv_card9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_deck.setVisibility((View.VISIBLE));
                card.assignImages(card.cards.get(8), imageView2);
                iv_deck.setClickable(false);
                iv_card9.setVisibility((View.INVISIBLE));

            }
        });

        iv_card10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_deck.setVisibility((View.VISIBLE));
                card.assignImages(card.cards.get(9), imageView2);
                iv_deck.setClickable(false);
                iv_card10.setVisibility((View.INVISIBLE));

            }
        });

        iv_card11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_deck.setVisibility((View.VISIBLE));
                card.assignImages(card.cards.get(10), imageView2);
                iv_deck.setClickable(false);
                iv_card11.setVisibility((View.INVISIBLE));

            }
        });

        iv_card12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_deck.setVisibility((View.VISIBLE));
                card.assignImages(card.cards.get(11), imageView2);
                iv_deck.setClickable(false);
                iv_card12.setVisibility((View.INVISIBLE));

            }
        });

        iv_card13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_deck.setVisibility((View.VISIBLE));
                card.assignImages(card.cards.get(12), imageView2);
                iv_deck.setClickable(false);
                iv_card13.setVisibility((View.INVISIBLE));

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