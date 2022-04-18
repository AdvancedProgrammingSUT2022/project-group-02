package controller;

import model.User;

import java.util.ArrayList;

public class GameController {
    private ArrayList<User> players;
    public GameController(ArrayList<User> players, int turnForEachPlayer) {
        this.players = players;
        for (User player : players) {
            player.setTurns(turnForEachPlayer);
            player.setGold(0);
        }
    }
    public void increaseTurn(int extraTurn, User specificPlayer) {
        specificPlayer.setTurns(specificPlayer.getTurns() + extraTurn);
    }
    public void increaseGold(int extraGold, User specificPlayer) {
        specificPlayer.setGold(specificPlayer.getGold() + extraGold);
    }

}
