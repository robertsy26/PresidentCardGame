package com.example.president;


import com.example.GameFramework.actionMessage.GameAction;
import com.example.GameFramework.players.GamePlayer;
/**
 * @author Yutaka Roberts
 * @author Anish Karumuri
 * @author Zella Run
 * @author Calvin Phuong
 * @version April 2023
 */
public class PresidentPassAction extends GameAction {
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public PresidentPassAction(GamePlayer player) {
        super(player);
    }
}
