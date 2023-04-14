package com.example.president;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.GameFramework.infoMessage.GameState;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void CheckPlayer1Card() {
        PresidentGameState pGameState = new PresidentGameState();

    }

    @Test
    public void checkPassCount() {
        PresidentGameState pGameState = new PresidentGameState();
        assertEquals(0, pGameState.passCount);
    }

    @Test
    public void checkMaxCardsHand() {
        PresidentGameState pGameState = new PresidentGameState();
        assertEquals(13, pGameState.maxCardsHand);
    }

    @Test
    public void currentPlayer() {
        PresidentGameState pGameState = new PresidentGameState();
        assertEquals(0, pGameState.currentPlayer);
    }

    @Test
    public void nextCurrentPlayer() {
        PresidentGameState pGameState = new PresidentGameState();
        pGameState.currentPlayer++;
        assertEquals(1, pGameState.currentPlayer);
    }

    @Test
    public void cardsAtPlay() {
        PresidentGameState pGameState = new PresidentGameState();
        assertEquals(0, pGameState.cardsAtPlay);
    }

    @Test
    public void testPlayer() {
        PresidentGameState pGameState = new PresidentGameState();

    }


}