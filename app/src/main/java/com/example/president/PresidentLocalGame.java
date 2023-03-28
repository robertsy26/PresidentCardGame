package com.example.president;

import com.example.GameFramework.LocalGame;
import com.example.GameFramework.actionMessage.GameAction;
import com.example.GameFramework.players.GamePlayer;

import java.util.ArrayList;

public class PresidentLocalGame extends LocalGame {
    PresidentGameState president;
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        p.sendInfo(new PresidentGameState(this.president));
    }

    @Override
    protected boolean canMove(int playerIdx) {
        if(president.getPlayerId() == playerIdx){
            return true;
        }
        return false;
    }

    @Override
    protected String checkIfGameOver() {

        return null;
    }

    @Override
    protected boolean makeMove(GameAction action) {
        return false;
    }

    public void alternatePlayers() {
        if(players.length == 1){
            return;

        } else {
            if(president.getPlayerId() == 1){
                president.setPlayerId(2);

            } else if (president.getPlayerId() == 2) {
                president.setPlayerId(3);

            } else if (president.getPlayerId() == 3) {
                president.setPlayerId(4);
            } else {
                president.setPlayerId(1);
            }
        }
    }

}
