package model;

public class Citizen {
    private Tile tile;

    public Citizen(Tile tile){
        this.tile = tile;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }
}
