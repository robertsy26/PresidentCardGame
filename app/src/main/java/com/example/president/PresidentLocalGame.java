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
        ArrayList<Integer> checkPlayer1 = president.getPlayer1Cards();
        ArrayList<Integer> checkPlayer2 = president.getPlayer2Cards();
        ArrayList<Integer> checkPlayer3 = president.getPlayer3Cards();
        ArrayList<Integer> checkPlayer4 = president.getPlayer4Cards();

        if(checkPlayer1.isEmpty()){
            return "Player 1 winss";
        }
        if(checkPlayer2.isEmpty()){
            return "Player 2 winss";
        }
        if(checkPlayer3.isEmpty()){
            return "Player 3 winss";
        }
        if(checkPlayer4.isEmpty()){
            return "Player 4 winss";
        }
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
