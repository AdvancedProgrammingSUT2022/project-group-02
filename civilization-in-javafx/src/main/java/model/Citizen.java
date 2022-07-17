package model;

public class Citizen {
    private Tile tile;
    private boolean working;

    public Citizen(Tile tile){
        this.tile = tile;
        working = false;
    }


    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }
}
