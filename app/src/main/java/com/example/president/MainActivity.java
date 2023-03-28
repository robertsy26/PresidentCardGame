package com.example.president;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    Cards cardClass = new Cards();
    ImageView iv_deck, iv_card1, iv_card2, iv_card3, iv_card4, iv_card5, iv_card6, iv_card7, iv_card8, iv_card9, iv_card10, iv_card11, iv_card12, iv_card13;

    PresidentGameState presidentGameState = new PresidentGameState();

    @SuppressLint("MissingInflatedId")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
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


        iv_deck.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                cardClass.setCards();
                Collections.shuffle(cardClass.cards);
                cardClass.assignImages(cardClass.cards.get(0), iv_card1);
                cardClass.assignImages(cardClass.cards.get(1), iv_card2);
                cardClass.assignImages(cardClass.cards.get(2), iv_card3);
                cardClass.assignImages(cardClass.cards.get(3), iv_card4);
                cardClass.assignImages(cardClass.cards.get(4), iv_card5);
                cardClass.assignImages(cardClass.cards.get(5), iv_card6);
                cardClass.assignImages(cardClass.cards.get(6), iv_card7);
                cardClass.assignImages(cardClass.cards.get(7), iv_card8);
                cardClass.assignImages(cardClass.cards.get(8), iv_card9);
                cardClass.assignImages(cardClass.cards.get(9), iv_card10);
                cardClass.assignImages(cardClass.cards.get(10), iv_card11);
                cardClass.assignImages(cardClass.cards.get(11), iv_card12);
                cardClass.assignImages(cardClass.cards.get(12), iv_card13);


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

                iv_deck.setVisibility((View.VISIBLE));

                

            }
        });



    }
}