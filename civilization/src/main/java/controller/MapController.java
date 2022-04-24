package controller;

import model.Maps;
import model.Tile;

import java.util.ArrayList;

public class MapController {
    private final int height;
    private final int width;
    private Maps map;
    public MapController(Maps map, int height, int width) {
        this.map = map;
        this.height = height;
        this.width = width;
    }

    public void setNeighbor(Tile tile) {
        ArrayList<Tile> neighbors = new ArrayList<>();
        int x = tile.getX();
        int y = tile.getY();
        // up
        if (x >= 2)
            neighbors.add(map.getTileBoard()[x - 2][y]);

        if (x >= 1) {
            //up left
            if (y >= 1)
                neighbors.add(map.getTileBoard()[x - 1][y - 1]);
            //up right
            if (y <= map.getWidth() - 2)
                neighbors.add(map.getTileBoard()[x - 1][y + 1]);
        }
        //down
        if (x <= map.getHeight() - 3)
            neighbors.add(map.getTileBoard()[x + 2][y]);

        if (x <= map.getHeight() - 2) {
            //down left
            if (y >= 1)
                neighbors.add(map.getTileBoard()[x + 1][y - 1]);
            //down right
            if (y <= map.getWidth() - 2)
                neighbors.add(map.getTileBoard()[x + 1][y + 1]);
        }
        tile.setNeighbors(neighbors);
    }

    // find the distance between two hexagons
    private int findDistance(Tile origin, Tile destination) {
        int xOrigin = origin.getX();
        int yOrigin = origin.getY();
        int xDestination = destination.getX();
        int yDestination = destination.getY();
        int deltaX;
        int deltaY;

        if (xDestination >= xOrigin)
            deltaX = xDestination - xOrigin;
        else
            deltaX = xOrigin - xDestination;
        if (yDestination >= yOrigin)
            deltaY = yDestination - yOrigin;
        else
            deltaY = yOrigin - yDestination;

        return (deltaX + deltaY) / 2;
    }

    public Tile bestChoiceAmongNeighbors(Tile tile, Tile destination) {
        if (tile.getNeighbors().contains(destination))
            return destination;
        Tile bestChoice = tile.getNeighbors().get(0);
        //distance to destination
        int distance = findDistance(bestChoice, destination);
        //cost of movement in the land of the tile
        int cost = bestChoice.getLand().getMovementPrice();
        int fullCost = distance + cost;
        for (int i = 1; i < tile.getNeighbors().size(); i++) {
            if (tile.getNeighbors().get(i).getLand().getName().equals("mountain") ||tile.getNeighbors().get(i).getLand().getName().equals("ocean"))
                continue;
            //swap
            if (tile.getNeighbors().get(i).getLand().getMovementPrice() + findDistance(tile.getNeighbors().get(i), destination) < fullCost) {
                fullCost = tile.getNeighbors().get(i).getLand().getMovementPrice() + findDistance(tile.getNeighbors().get(i), destination);
                bestChoice = tile.getNeighbors().get(i);
            }
        }
        return bestChoice;
    }
}
