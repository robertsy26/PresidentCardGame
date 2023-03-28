package com.example.president;

import android.view.View;
import android.os.Handler;
import android.util.Log;

import com.example.GameFramework.GameMainActivity;
import com.example.GameFramework.infoMessage.GameInfo;
import com.example.GameFramework.players.GameHumanPlayer;

public class HumanPlayer extends GameHumanPlayer {

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
        View gameView = new View(myActivity);
        return gameView;
    }

    @Override
    public void receiveInfo(GameInfo info) {
        // wait until handler is there
        if (myHandler == null) Thread.yield();

        // post message to the handler
        Log.d(TAG, "receiveInfo - about to post");
        myHandler.post(new MyRunnable(info, false));
        Log.d(TAG, "receiveInfo - done with post");
    }

    public void setAsGui(GameMainActivity activity) {
        // default behavior is do nothing
    }
}
