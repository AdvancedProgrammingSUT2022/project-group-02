package controller;

import model.Maps;
import model.User;

import java.util.ArrayList;

public class GameController {
    private ArrayList<User> players;
    private Maps map;
    private int mapSize;
    public GameController(ArrayList<User> players, int turnForEachPlayer, Maps map, int mapSize) {
        this.players = players;
        this.map = map;
        this.mapSize = mapSize;
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

    public int findTile(int x, int y) {
        for (int i = 0; i < mapSize; i++) {
            if (map.getTileBoard()[i].getX() == x && map.getTileBoard()[i].getY() == y)
                return i;
        }
        return -1;
    }
}
