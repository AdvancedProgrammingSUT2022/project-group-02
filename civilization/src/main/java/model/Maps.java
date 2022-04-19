package model;

public class Maps {
    private final int mapSize;
    private Tile[] tileBoard;
    public Maps(int mapSize) {
        this.mapSize = mapSize;
        tileBoard = new Tile[mapSize];
    }
    public Tile[] getTileBoard() {
        return tileBoard;
    }
    public Tile getSpecificTile(int index) {
        return tileBoard[index];
    }

    public void setTileBoard(Tile[] tileBoard) {
        this.tileBoard = tileBoard;
    }
}
