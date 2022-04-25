package controller;

import model.*;

import java.util.ArrayList;

public class GameController {
    private ArrayList<User> players;
    private Maps map;
    private int turnForEachPlayer;
    private int height;
    private int width;
    public GameController(ArrayList<User> players, int turnForEachPlayer, Maps map, int height, int width) {
        this.players = players;
        this.map = map;
        for (User player : players) {
            player.setTurns(turnForEachPlayer);
            player.setGold(0);
        }
        this.turnForEachPlayer = turnForEachPlayer;
        this.height = height;
        this.width = width;
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
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map.getTileBoard()[i][j].getX() == x && map.getTileBoard()[i][j].getY() == y)
                    return map.getTileBoard()[i][j];
            }
        }
        return null;
    }
    public void moveUnit(Tile origin, Tile destination, Unit unit) {
        // TODO move the unit to the destination
    }

    public int getTurnForEachPlayer() {
        return turnForEachPlayer;
    }

    public void setTurnForEachPlayer(int turnForEachPlayer) {
        this.turnForEachPlayer = turnForEachPlayer;
    }
}
