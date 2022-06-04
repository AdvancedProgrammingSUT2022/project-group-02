package controller;

import model.*;
import view.enums.Colors;

import java.util.ArrayList;

public class MapController {
    private final Maps map;

    public MapController(Maps map) {
        this.map = map;
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
            if (y >= 1) {
                if (x % 2 == 0)
                    neighbors.add(map.getTileBoard()[x - 1][y - 1]);
                else
                    neighbors.add(map.getTileBoard()[x - 1][y]);
            }
            //up right
            if (y <= map.getWidth() - 2) {
                if (x % 2 == 0)
                    neighbors.add(map.getTileBoard()[x - 1][y]);
                else
                    neighbors.add(map.getTileBoard()[x - 1][y + 1]);
            }
        }
        //down
        if (x <= map.getHeight() - 3)
            neighbors.add(map.getTileBoard()[x + 2][y]);

        if (x <= map.getHeight() - 2) {
            //down left
            if (y >= 1) {
                if (x % 2 == 0)
                    neighbors.add(map.getTileBoard()[x + 1][y - 1]);
                else
                    neighbors.add(map.getTileBoard()[x + 1][y]);
            }
            //down right
            if (y <= map.getWidth() - 2) {
                if (x % 2 == 0)
                    neighbors.add(map.getTileBoard()[x + 1][y]);
                else
                    neighbors.add(map.getTileBoard()[x + 1][y + 1]);
            }
        }
        tile.setNeighbors(neighbors);
    }

    // find the distance between two hexagons
    public int findDistance(Tile origin, Tile destination) {
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

    public Tile bestChoiceAmongNeighbors(Tile tile, Tile destination, boolean isMilitary) {
        if (tile.getNeighbors().contains(destination))
            return destination;
        Tile bestChoice = tile.getNeighbors().get(0);
        //distance to destination
        int distance = findDistance(bestChoice, destination);
        //cost of movement in the land of the tile
        int cost = bestChoice.getTerrain().getMovementPrice();
        int fullCost = distance + cost;
        for (int i = 1; i < tile.getNeighbors().size(); i++) {
            // if the tile is mountain or ocean or there is same unit in this tile do not add it
            if (!tile.getNeighbors().get(i).getTerrain().isPassable())
                continue;
            //swap
            if (tile.getNeighbors().get(i).getTerrain().getMovementPrice() + findDistance(tile.getNeighbors().get(i), destination) < fullCost) {
                fullCost = tile.getNeighbors().get(i).getTerrain().getMovementPrice() + findDistance(tile.getNeighbors().get(i), destination);
                bestChoice = tile.getNeighbors().get(i);
            }
        }
        if (tile.getNeighbors().get(0).equals(bestChoice) && !bestChoice.getTerrain().isPassable())
            return null;
        return bestChoice;
    }

    private boolean checkConditionOfAddingTheTile(Tile tile, boolean isMilitary) {
        boolean militaryConflict = isMilitary && tile.isMilitaryUnitExists();
        boolean civilianConflict = !isMilitary && tile.isCivilianUnitExists();
        return militaryConflict || civilianConflict || !tile.getTerrain().isPassable();
    }

    public void addAllVisibleAndVisitedTiles(User user) {
        user.setVisible(new ArrayList<>());
        // add tiles that are completely visible
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                //add to visible
                if ((map.getTileBoard()[i][j].isMilitaryUnitExists() && map.getTileBoard()[i][j].getMilitaryUnit().getOwner().equals(user)) ||
                        (map.getTileBoard()[i][j].isCivilianUnitExists() && map.getTileBoard()[i][j].getCivilianUnit().getOwner().equals(user))) {
                    if (!user.getVisible().contains(map.getTileBoard()[i][j]))
                        user.addVisible(map.getTileBoard()[i][j]);
                    //add to the visited tiles if not exists
                    if (!user.getVisited().contains(map.getTileBoard()[i][j]))
                        //map.addVisited(map.getTileBoard()[i][j]);

                        for (int k = 0; k < map.getTileBoard()[i][j].getNeighbors().size(); k++) {
                            //add to visible
                            if (!user.getVisible().contains(map.getTileBoard()[i][j].getNeighbors().get(k)))
                                user.addVisible(map.getTileBoard()[i][j].getNeighbors().get(k));
                            //add to the visited tile if not exists
                            if (!user.getVisited().contains(map.getTileBoard()[i][j].getNeighbors().get(k)))
                                user.addVisited(map.getTileBoard()[i][j].getNeighbors().get(k));
                        }
                }
            }
        }
    }


    public String tileImprovement(Tile tile) {
        if (tile.getOwner() == null) return "   ";
        else if (tile.getImprovement() == null && tile.getCity() == null) return "NIY";
        else if (tile.getCity() != null) return tile.getCity().getName().substring(0, 3);
        else return tile.getImprovement().getName().substring(0, 3);
    }

    public String tileOwner(Tile tile) {
        if (tile.getOwner() == null) return "   ";
        else return tile.getOwner().getNickname().substring(0, 3);
    }

    public String civilianUnit(Tile tile) {
        if (tile.getCivilianUnit() == null) return "  ";
        else return tile.getCivilianUnit().getName().substring(0, 2);
    }

    public String militaryUnit(Tile tile) {
        if (tile.getMilitaryUnit() == null) return "  ";
        else return tile.getMilitaryUnit().getName().substring(0, 2);
    }

    public String tileResource(Tile tile, boolean isFirstRightRow) {
        if (isFirstRightRow || tile.getResource() == null) return "   ";
        else return tile.getResource().getName().substring(0, 3);
    }

    public String tileFeature(Tile tile, boolean isFirstRightRow) {
        if (isFirstRightRow || tile.getFeature() == null) return "  ";
        else return tile.getFeature().getName().substring(0, 2);
    }

    public String getColorOfTileOwner(Tile tile) {
        ColorsController colorsController = new ColorsController();
        return colorsController.getColorOfUser(tile.getOwner());
    }

    public String riverFinder(Tile tile, int x) {
        //print the river or normal border
        if (tile.getRiverBorder() != null && tile.getRiverBorder(x) && (x == 0 || x == 3))
            return Colors.BLUE_BACKGROUND + "___________" + Colors.RESET;
        if (tile.getRiverBorder() != null && tile.getRiverBorder(x) && (x == 2 || x == 5))
            return Colors.BLUE_BACKGROUND + "/" + Colors.RESET;
        else if (tile.getRiverBorder() != null && tile.getRiverBorder(x) && (x == 1 || x == 4))
            return Colors.BLUE_BACKGROUND + "\\" + Colors.RESET;
        else if ((x == 0 && tile.getX() >= 2) || x == 3) return getColorOfTile(tile) + "___________" + Colors.RESET;
        else if (x == 0) return "___________";
        else if (x == 2 || x == 5) return "/";
        else return "\\";
    }

    public String getColorOfTile(Tile tile) {
        ColorsController colorsController = new ColorsController();
        return colorsController.getColorOfTile(tile);
    }

    public void deleteCivilian(Tile tile) {
        tile.setCivilianUnit(null);
        tile.setCivilianUnitExists(false);
    }

    public void deleteMilitary(Tile tile) {
        tile.setMilitaryUnit(null);
        tile.setMilitaryUnitExists(false);
    }

    // storing tiles which can be bought
    public ArrayList<Tile> neighborOfCity(City city) {
        ArrayList<Tile> neighborOfCity = new ArrayList<>();
        for (Tile ownerShipTile : city.getOwnerShipTiles()) {
            for (Tile neighbor : ownerShipTile.getNeighbors()) {
                if (!city.getOwnerShipTiles().contains(neighbor) && neighbor.getOwner() == null)
                    neighborOfCity.add(neighbor);
            }
        }
        return neighborOfCity;
    }


    public ArrayList<Tile> firstSetOfSettlers(ArrayList<User> users) {
        ArrayList<Tile> tiles = new ArrayList<>();
        //user0
        Settler settler = new Settler("settler", map.getSpecificTile(8, 15), 100, 1, 1, 1, 2, 0, 0, null, users.get(0), 0, 0);
        users.get(0).addUnit(settler);
        map.getSpecificTile(8, 15).setCivilianUnit(settler);
        map.getSpecificTile(8, 15).setCivilianUnitExists(true);
        tiles.add(map.getSpecificTile(8, 15));
        //user1
        settler = new Settler("settler", map.getSpecificTile(17, 13), 100, 1, 1, 1, 2, 0, 0, null, users.get(1), 0, 0);
        users.get(1).addUnit(settler);
        map.getSpecificTile(17, 13).setCivilianUnit(settler);
        map.getSpecificTile(17, 13).setCivilianUnitExists(true);
        tiles.add(map.getSpecificTile(17, 13));
        if (users.size() <= 2) return tiles;
        //user2
        settler = new Settler("settler", map.getSpecificTile(4, 46), 100, 1, 1, 1, 2, 0, 0, null, users.get(2), 0, 0);
        users.get(2).addUnit(settler);
        map.getSpecificTile(4, 46).setCivilianUnit(settler);
        map.getSpecificTile(4, 46).setCivilianUnitExists(true);
        tiles.add(map.getSpecificTile(4, 46));
        if (users.size() <= 3) return tiles;
        //user3
        settler = new Settler("settler", map.getSpecificTile(5, 33), 100, 1, 1, 1, 2, 0, 0, null, users.get(3), 0, 0);
        users.get(3).addUnit(settler);
        map.getSpecificTile(5, 33).setCivilianUnit(settler);
        map.getSpecificTile(5, 33).setCivilianUnitExists(true);
        tiles.add(map.getSpecificTile(5, 33));
        if (users.size() <= 4) return tiles;
        //user4
        settler = new Settler("settler", map.getSpecificTile(5, 61), 100, 1, 1, 1, 2, 0, 0, null, users.get(4), 0, 0);
        users.get(4).addUnit(settler);
        map.getSpecificTile(5, 61).setCivilianUnit(settler);
        map.getSpecificTile(5, 61).setCivilianUnitExists(true);
        tiles.add(map.getSpecificTile(5, 61));
        if (users.size() <= 5) return tiles;
        //user5
        settler = new Settler("settler", map.getSpecificTile(7, 4), 100, 1, 1, 1, 2, 0, 0, null, users.get(5), 0, 0);
        users.get(5).addUnit(settler);
        map.getSpecificTile(7, 4).setCivilianUnit(settler);
        map.getSpecificTile(7, 4).setCivilianUnitExists(true);
        tiles.add(map.getSpecificTile(7, 4));
        if (users.size() <= 6) return tiles;
        //user6
        settler = new Settler("settler", map.getSpecificTile(7, 57), 100, 1, 1, 1, 2, 0, 0, null, users.get(6), 0, 0);
        users.get(6).addUnit(settler);
        map.getSpecificTile(7, 57).setCivilianUnit(settler);
        map.getSpecificTile(7, 57).setCivilianUnitExists(true);
        tiles.add(map.getSpecificTile(7, 57));
        if (users.size() <= 7) return tiles;
        //user7
        settler = new Settler("settler", map.getSpecificTile(8, 33), 100, 1, 1, 1, 2, 0, 0, null, users.get(7), 0, 0);
        users.get(7).addUnit(settler);
        map.getSpecificTile(8, 33).setCivilianUnit(settler);
        map.getSpecificTile(8, 33).setCivilianUnitExists(true);
        tiles.add(map.getSpecificTile(8, 33));
        if (users.size() <= 8) return tiles;
        //user8
        settler = new Settler("settler", map.getSpecificTile(11, 22), 100, 1, 1, 1, 2, 0, 0, null, users.get(8), 0, 0);
        users.get(8).addUnit(settler);
        map.getSpecificTile(11, 22).setCivilianUnit(settler);
        map.getSpecificTile(11, 22).setCivilianUnitExists(true);
        tiles.add(map.getSpecificTile(11, 22));
        if (users.size() <= 9) return tiles;
        //user9
        settler = new Settler("settler", map.getSpecificTile(15, 8), 100, 1, 1, 1, 2, 0, 0, null, users.get(9), 0, 0);
        users.get(9).addUnit(settler);
        map.getSpecificTile(15, 8).setCivilianUnit(settler);
        map.getSpecificTile(15, 8).setCivilianUnitExists(true);
        tiles.add(map.getSpecificTile(15, 8));
        if (users.size() <= 10) return tiles;
        //user10
        settler = new Settler("settler", map.getSpecificTile(16, 13), 100, 1, 1, 1, 2, 0, 0, null, users.get(10), 0, 0);
        users.get(10).addUnit(settler);
        map.getSpecificTile(16, 13).setCivilianUnit(settler);
        map.getSpecificTile(16, 13).setCivilianUnitExists(true);
        tiles.add(map.getSpecificTile(16, 13));
        if (users.size() <= 11) return tiles;
        //user11
        settler = new Settler("settler", map.getSpecificTile(18, 32), 100, 1, 1, 1, 2, 0, 0, null, users.get(11), 0, 0);
        users.get(11).addUnit(settler);
        map.getSpecificTile(18, 32).setCivilianUnit(settler);
        map.getSpecificTile(18, 32).setCivilianUnitExists(true);
        tiles.add(map.getSpecificTile(18, 32));
        return tiles;
    }
}
