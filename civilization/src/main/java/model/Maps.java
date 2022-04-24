package model;

public class Maps {
    private final int mapSize;
    private Tile[][] tileBoard;
    private int height;
    private int width;
    public Maps(int mapSize) {
        this.mapSize = mapSize;
        tileBoard = new Tile[mapSize][mapSize];
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

    public int getMapSize() {
        return mapSize;
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
