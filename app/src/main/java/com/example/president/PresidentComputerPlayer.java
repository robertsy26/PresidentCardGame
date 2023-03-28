package com.example.president;

import com.example.GameFramework.infoMessage.GameInfo;
import com.example.GameFramework.players.GameComputerPlayer;

import java.util.Random;

public class PresidentComputerPlayer extends GameComputerPlayer {
    /**
     * constructor
     *
     * @param name the player's name (e.g., "John")
     */

    int[] cards;

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
