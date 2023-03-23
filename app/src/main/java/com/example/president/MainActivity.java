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
    ImageView iv_deck, iv_card1, iv_card2, iv_card3, iv_card4, iv_card5, iv_card6;

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

        iv_card1.setVisibility(View.INVISIBLE);
        iv_card2.setVisibility(View.INVISIBLE);
        iv_card3.setVisibility(View.INVISIBLE);
        iv_card4.setVisibility(View.INVISIBLE);
        iv_card5.setVisibility(View.INVISIBLE);
        iv_card6.setVisibility(View.INVISIBLE);

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

                iv_card1.setVisibility(View.VISIBLE);
                iv_card2.setVisibility(View.VISIBLE);
                iv_card3.setVisibility(View.VISIBLE);
                iv_card4.setVisibility(View.VISIBLE);
                iv_card5.setVisibility(View.VISIBLE);
                iv_card6.setVisibility(View.VISIBLE);



                

            }
        });



    }
}