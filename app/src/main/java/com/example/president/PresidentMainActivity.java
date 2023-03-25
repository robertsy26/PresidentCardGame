package com.example.president;

import static com.example.GameFramework.utilities.Saving.SEPARATOR;

import com.example.GameFramework.infoMessage.GameState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PresidentMainActivity extends GameState {
    private int playerId; // the player
    public List<Card> cards; //cards array
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



    public PresidentMainActivity (int playerId, List<Card> cards, boolean is3Spade) { // basic constructor intializing the variables
        this.playerId = playerId;
        this.cards = cards;
        this.is3Spade = is3Spade;
        player1score = 0;
        player2score = 0;
        player3score = 0;
        player4score = 0;
    }

    public PresidentMainActivity(PresidentMainActivity president){ // copy costructor that makes deep copies
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

        // Object card;



        //going through each indvisual index to make sure all the values are copied
        this.cards = new ArrayList<>();
        for (Card card : president.cards){
            if(card.isVisibleToPlayer(playerId)){
                cards.add(card.copy());
            }
        }



    }



    public class Player {
        private int id; // players unique id
        private String name; // name of player

        public Player(int id, String name) { //intializing the variables
            this.id = id;
            this.name = name;
        }

        public Player(Player player) { //copy constructor making a deep copy
            this.id = player.id;
            this.name = player.name;
        }

        public Player copyForPlayer(int playerID) { // creates a copy of the current player
            if (id == playerID) {
                return new Player(this); //if the id doesn't match the given playerID,
                // the method creates a new Player object with the same attributes as the current object
            } else {
                return new Player(id, "BRO"); // if id doesn't match the give playerID create new player object with deafult name
            }
        }

        public int getId() { //retrieves ID
            return id;
        }

        public String getName() { // retrieves name
            return name;
        }
    }

    public class Card{
        private int number;
        private String name;
        private boolean visible;

        public Card(int number, String name, boolean visible){ //basic constructor
            this.number = number;
            this.name = name;
            this.visible = visible;
        }
        public Card(Card card){ // copy constructor creating deep copy
            this.number = card.number;
            this.name = card.name;
            this.visible = card.visible;
        }

        public Card copy(){ //copy method
            return new Card(this);
        }

        public boolean isVisibleToPlayer (int playerId){ //checks if cards should be shown
            return true;
        }
    }

    @Override
    public String toString() {
        return this.playerId + SEPARATOR + this.currentHand + SEPARATOR + this.rankings + SEPARATOR +
                this.maxCardsHand + SEPARATOR + this.numCardsDeck + SEPARATOR + this.cards + SEPARATOR +
                this.is3Spade + SEPARATOR + this.isCardCorrect + SEPARATOR + this.isCardVisible;
    }


    //checks to see if card is legal to play
    public boolean isLegal(int playersCardNum, int cardOnDeck, int numOfCardsSelected){
        //2 has no rank and will clear the deck, so will always be legal and can't have more than 4 cards selected
        if (playersCardNum == 2 || playersCardNum > cardOnDeck && numOfCardsSelected >= 4){
            isCardCorrect = true;
            updateHand(numOfCardsSelected);
            return true; }
        else{
            isCardCorrect = false;
            updateHand(numOfCardsSelected);
            return false; }
    }
    //updates players hand when plays a card
    public boolean updateHand(int numOfCardsSelected) {
        if(numOfCardsSelected >= 1 ){ currentHand = currentHand - numOfCardsSelected;}
        else{ currentHand = currentHand; }
        return true;
    }

    //initializes list of players in Array
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;

    public List<Player> players = Arrays.asList(player1, player2, player3, player4);
    Player currentPlayer = players.get(0);
    //methods switches players
    public void switchPlayer(Player currentPlayer)
    {   //selects the next player from list that is after current and then restart with the first after the last
        players.get((players.indexOf(currentPlayer) + 1) % players.size());
    }
    //checks if card is legal to play, then modifies game state to reflect player played a card
    //updated users num of cards and switches players
    public boolean playCard(int playerId, int cardOnDeck, int playersCardNum, int numOfCardsSelected, Player currentPlayer){
        if(isLegal(playersCardNum, cardOnDeck, numOfCardsSelected)){
            switchPlayer(currentPlayer);
            return true; }
        else{
            switchPlayer(currentPlayer);
            return false; }
    }
    //this case pass will always be legal so don't need to check, then reflects player passed by
    // updated users num of cards and switches players
    public boolean pass(int playerId, int numOfCardsSelected){
        updateHand(numOfCardsSelected);
        switchPlayer(currentPlayer);
        return true;
    }
    //pause is always legal so don't need to check or do anything to game state
    public boolean pause(int playerId){
        return true;
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


}


