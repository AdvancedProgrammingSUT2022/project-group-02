package model;

public class Maps {
    private final int mapSize;
    private Tile[][] tileBoard;
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

    public void setTileBoard(Tile[][] tileBoard) {
        this.tileBoard = tileBoard;
    }
}
