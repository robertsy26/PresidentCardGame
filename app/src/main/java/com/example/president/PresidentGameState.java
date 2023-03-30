package com.example.president;

import static com.example.GameFramework.utilities.Saving.SEPARATOR;

import com.example.GameFramework.gameConfiguration.GamePlayerType;
import com.example.GameFramework.infoMessage.GameState;
import com.example.GameFramework.players.GamePlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PresidentGameState extends GameState {
    private int playerId; // the player
    final int maxCardsHand = 13;
    final int numCardsDeck = 52;
    public int currentHand; //how many players the card has on his turn
    public boolean isCardCorrect; //check if the card is playable
    public boolean isCardVisible;
    public boolean is3Spade; // dictates which player starts first
    public int rankings; //numbers corresponds to a stage
    // public Object card;
    private int player1score;
    private int player2score;
    private int player3score;
    private int player4score;

    int player1Cards[] = new int[13];
    int player2Cards[] = new int[13];
    int player3Cards[] = new int[13];
    int player4Cards[] = new int[13];

    int allPlayers[][] = new int[4][13];







    ArrayList <GamePlayerType> player = new ArrayList<GamePlayerType>();





    public PresidentGameState() { // basic constructor intializing the variables
        player1score = 0;
        player2score = 0;
        player3score = 0;
        player4score = 0;
        player.add(new GamePlayerType("Local Human Player") {
            @Override
            public GamePlayer createPlayer(String name) {
                return new HumanPlayer(name);
            }
        });

        player.add(new GamePlayerType("Local Computer Player") {
            @Override
            public GamePlayer createPlayer(String name) {
                return new PresidentComputerPlayer(name);
            }
        });


    }

    public PresidentGameState(PresidentGameState president){ // copy costructor that makes deep copies
        this.playerId = playerId;
        // cards;
        this.currentHand = president.currentHand;
        this.isCardCorrect = president.isCardCorrect;
        this.isCardVisible = president.isCardVisible;
        this.is3Spade = president.is3Spade;
        this.rankings = president.rankings;
        this.player1score = president.getPlayer1score();
        this.player2score = president.getPlayer2score();
        this.player3score = president.getPlayer3score();
        this.player4score = president.getPlayer4score();



    }

    public void setPlayer1score(int player1score) {
        this.player1score = player1score;
    }
    public void setPlayer2score(int player2score) {
        this.player1score = player2score;
    }
    public void setPlayer3score(int player3score) {
        this.player1score = player3score;
    }
    public void setPlayer4score(int player4score) {
        this.player1score = player4score;
    }
    public void setPlayerId(int id){
        this.playerId = id;
    }
    public void setPlayer1Cards (int[] player){
        player1Cards = player;
    }
    public void setPlayer2Cards (int[] player){
        player2Cards = player;
    }
    public void setPlayer3Cards (int[] player){
        player3Cards = player;
    }
    public void setPlayer4Cards (int[] player){
        player4Cards = player;
    }

    public int getPlayer1score(){
        return player1score;
    }
    public int getPlayer2score(){
        return player2score;
    }
    public int getPlayer3score(){
        return player3score;
    }
    public int getPlayer4score(){
        return player4score;
    }
    public int getPlayerId() {return playerId;}
    public int[] getPlayer1Cards (){
        return player1Cards;
    }
    public int[] getPlayer2Cards (){
        return player2Cards;
    }
    public int[] getPlayer3Cards (){
        return player3Cards;
    }
    public int[] getPlayer4Cards (){
        return player4Cards;
    }






}


