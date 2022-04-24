package controller;

import model.*;

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
    // cheat code for increasing the turn of user
    public void increaseTurn(int extraTurn, User specificPlayer) {
        specificPlayer.setTurns(specificPlayer.getTurns() + extraTurn);
    }
    // cheat code for increasing the gold of user
    public void increaseGold(int extraGold, User specificPlayer) {
        specificPlayer.setGold(specificPlayer.getGold() + extraGold);
    }
    // find the tile by given x and y coordinates
    public Tile findTile(int x, int y) {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (map.getTileBoard()[i][j].getX() == x && map.getTileBoard()[i][j].getY() == y)
                    return map.getTileBoard()[i][j];
            }
        }
        return null;
    }
    public void moveUnit(Tile origin, Tile destination, Unit unit) {

    }
}
