package model;

import java.util.ArrayList;

public class Maps {
    private final int mapSize;
    private Tile[][] tileBoard;
    private int height;
    private int width;

    private ArrayList<Tile> visited;
    private ArrayList<Tile> visible;

    public Maps(int mapSize) {
        this.mapSize = mapSize;
        tileBoard = new Tile[mapSize][mapSize];
        visited = new ArrayList<>();
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

    public ArrayList<Tile> getVisited() {
        return visited;
    }

    public void setVisited(ArrayList<Tile> visited) {
        this.visited = visited;
    }

    public ArrayList<Tile> getVisible() {
        return visible;
    }

    public void setVisible(ArrayList<Tile> visible) {
        this.visible = visible;
    }
    public void addVisited(Tile visit) {
        visited.add(visit);
    }
    public void addVisible(Tile visible) {
        this.visible.add(visible);
    }
}
