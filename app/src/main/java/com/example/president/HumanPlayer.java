package com.example.president;

import android.os.Bundle;
import android.view.View;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import com.example.GameFramework.GameMainActivity;
import com.example.GameFramework.infoMessage.GameInfo;
import com.example.GameFramework.infoMessage.GameState;
import com.example.GameFramework.players.GameHumanPlayer;

// random comment, to delete later

import java.util.Collections;

public class HumanPlayer extends GameHumanPlayer {
    private ImageView iv_deck = null;
    private ImageView iv_card1 = null;
    private ImageView iv_card2 = null;
    private ImageView iv_card3 = null;
    private ImageView iv_card4 = null;
    private ImageView iv_card5 = null;
    private ImageView iv_card6 = null;
    private ImageView iv_card7 = null;
    private ImageView iv_card8 = null;
    private ImageView iv_card9 = null;
    private ImageView iv_card10 = null;
    private ImageView iv_card11 = null;
    private ImageView iv_card12 = null;
    private ImageView iv_card13 = null;

    private GameMainActivity presidentActivity;
    Cards cardClass = new Cards();


    private static final String TAG = "HumanPlayer";

    // Not sure if I need this
    private Handler myHandler;
    /**
     * constructor
     *
     * @param name the name of the player
     */

    int[] cards;

    public HumanPlayer(String name) {
        super(name);
        cards = new int[13];
    }

    @Override
    public View getTopView() {
        return presidentActivity.findViewById(R.id.top_gui_layout);
    }

    @Override
    public void receiveInfo(GameInfo info) {
      /*  // wait until handler is there
        if (myHandler == null) Thread.yield();

        // post message to the handler
        Log.d(TAG, "receiveInfo - about to post");
        myHandler.post(new MyRunnable(info, false));
        Log.d(TAG, "receiveInfo - done with post");*/

        if(!(info instanceof GameState)){
            this.flash(1,2000);
            return;
        }

        PresidentGameState pga = (PresidentGameState) info;

    }



    public void onClick(View button){

    }

    protected void onCreate(Bundle savedInstanceState) {
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

                iv_deck.setVisibility((View.INVISIBLE));
                iv_deck.setClickable(true);




            }
        });



    }

    @Override
    public void setAsGui(GameMainActivity activity) {

    }
}
