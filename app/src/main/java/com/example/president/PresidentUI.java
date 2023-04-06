package com.example.president;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PresidentUI extends AppCompatActivity{

    ImageView iv_deck, iv_card1,iv_card2,iv_card3,iv_card4,iv_card5,iv_card6,iv_card7,iv_card8,iv_card9,iv_card10,iv_card11,iv_card12,iv_card13;

    ImageView[] displayCards = new ImageView[]{iv_card1, iv_card2, iv_card3, iv_card4, iv_card5, iv_card6, iv_card7, iv_card8, iv_card9, iv_card10, iv_card11, iv_card12, iv_card13};
    Cards card = new Cards();


    public PresidentUI(){
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    //temporary name
    public ImageView[] updateCards(ImageView[] views, int[] stack){
        for (int i = 0; i < 13; i++){
            if (stack[i] == 0) {
                views[i].setVisibility(View.INVISIBLE);
                views[i].setClickable(false);
            }
            else{
                card.assignImages(stack[i], views[i]);
                views[i].setVisibility(View.VISIBLE);
                views[i].setClickable(true);
            }
        }
        return views;
    }

    public Button updateButtonColor(Button button, int color){
        button.setBackgroundColor(color);
        return button;
    }

    public TextView updateChosenCardsTotal(TextView number, int num){
        number.setText("x" + num);
        return number;
    }

    public TextView updatePlayerNumberText(TextView player, int num, boolean won){
        if (won)
            player.setText("Player " + (num + 1) + " won");
        else
            player.setText("Player " + (num + 1));
        return player;
    }

    public ImageView[] resetCards(ImageView[] views){
        for (int i = 0; i < 13; i++){
            views[i].setPadding(0, 0, 0, 0);
            views[i].setClickable(true);
        }
        return views;
    }
}
