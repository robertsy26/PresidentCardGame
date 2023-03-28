package com.example.president;

import com.example.GameFramework.LocalGame;
import com.example.GameFramework.actionMessage.GameAction;
import com.example.GameFramework.players.GamePlayer;

public class PresidentLocalGame extends LocalGame {
    PresidentGameState president;
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        p.sendInfo(new PresidentGameState(this.president));
    }

    @Override
    protected boolean canMove(int playerIdx) {
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

        }
    }

}
