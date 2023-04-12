package com.example.president;

import static com.example.GameFramework.utilities.Saving.SEPARATOR;

import com.example.GameFramework.gameConfiguration.GamePlayerType;
import com.example.GameFramework.infoMessage.GameState;
import com.example.GameFramework.players.GamePlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yutaka Roberts
 * @author Anish Karumuri
 * @author Zella Run
 * @author Calvin Phuong
 * @version April 2023
 */
public class PresidentGameState extends GameState {
    private int playerId; // the player
    final int maxCardsHand = 13;
    final int numCardsDeck = 52;
    public boolean isCardCorrect; //check if the card is playable
    public boolean isCardVisible;
    public boolean is3Spade; // dictates which player starts first
    public int rankings; //numbers corresponds to a stage
    // public Object card;
    private int player1score;
    private int player2score;
    private int player3score;
    private int player4score;

    //2D array of all four players and each of their hands
    int allPlayers[][];

    //Index of current player playing
    int currentPlayer;

    //Number of required cards to play
    public int cardsAtPlay = 0;

    //Number of passes that have occurred
    public int passCount = 0;

    //Value of card in play
    public int currentCardNum = 0;



    ArrayList <GamePlayerType> player = new ArrayList<GamePlayerType>();

    boolean emptyStack = true;





    public PresidentGameState() { // basic constructor intializing the variables
        player1score = 0;
        player2score = 0;
        player3score = 0;
        player4score = 0;

        allPlayers = new int[4][13];
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

        currentPlayer = 0;

    }

    public PresidentGameState(PresidentGameState president){ // copy costructor that makes deep copies
        this.playerId = playerId;
        // cards;
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

    public int getCurrentPlayer(){
        return currentPlayer;
    }






}


