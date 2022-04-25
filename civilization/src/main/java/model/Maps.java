package model;

import java.util.ArrayList;

public class Maps {
    private Tile[][] tileBoard;
    private int height;
    private int width;

    public Maps(int height, int width) {
        this.height = height;
        this.width = width;
        tileBoard = new Tile[height][width];
    }

    public Tile[][] getTileBoard() {
        return tileBoard;
    }

    public Tile getSpecificTile(int index1, int index2) {
        return tileBoard[index1][index2];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setTileBoard(Tile[][] tileBoard) {
        this.tileBoard = tileBoard;
    }
}
