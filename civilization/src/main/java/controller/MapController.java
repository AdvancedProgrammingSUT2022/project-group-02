package controller;

import model.*;
import enums.Colors;

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
            if (checkConditionOfAddingTheTile(tile, isMilitary))
                continue;
            //swap
            if (tile.getNeighbors().get(i).getTerrain().getMovementPrice() + findDistance(tile.getNeighbors().get(i), destination) < fullCost) {
                fullCost = tile.getNeighbors().get(i).getTerrain().getMovementPrice() + findDistance(tile.getNeighbors().get(i), destination);
                bestChoice = tile.getNeighbors().get(i);
            }
        }
        if (tile.getNeighbors().get(0).equals(bestChoice) && checkConditionOfAddingTheTile(bestChoice, isMilitary))
            return null;
        return bestChoice;
    }

    private boolean checkConditionOfAddingTheTile(Tile tile, boolean isMilitary) {
        boolean militaryConflict = isMilitary && tile.isMilitaryUnitExists();
        boolean civilianConflict = !isMilitary && tile.isCivilianUnitExists();
        boolean isMountainOrOcean = tile.getTerrain().getName().equals("mountain") || tile.getTerrain().getName().equals("ocean");
        return militaryConflict || civilianConflict || isMountainOrOcean;
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
        else if (tile.getImprovement() == null) return "NIY";
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
        if (isFirstRightRow || tile.getResource() == null) return "  ";
        else return tile.getResource().getName().substring(0, 2);
    }

    public String tileTerrain(Tile tile, boolean isFirstRightRow) {
        if (isFirstRightRow || tile.getFeature() == null) return "  ";
        else return tile.getFeature().getName().substring(0, 2);
    }

    public String getColorOfTileOwner(Tile tile) {
        String ANSI_COLOR = Colors.BLUE;
        if (tile.getOwner() == null) return ANSI_COLOR;
        else if (tile.getOwner().getColor().equals("black")) ANSI_COLOR = Colors.BLACK;
        else if (tile.getOwner().getColor().equals("green")) ANSI_COLOR = Colors.GREEN;
        else if (tile.getOwner().getColor().equals("red")) ANSI_COLOR = Colors.RED;
        else if (tile.getOwner().getColor().equals("yellow")) ANSI_COLOR = Colors.YELLOW;
        else if (tile.getOwner().getColor().equals("purple")) ANSI_COLOR = Colors.PURPLE;
        else if (tile.getOwner().getColor().equals("cyan")) ANSI_COLOR = Colors.CYAN;
        else if (tile.getOwner().getColor().equals("blue")) ANSI_COLOR = Colors.BLUE;
        return ANSI_COLOR;
    }

    public String riverFinder(Tile tile, int x) {
        //print the river or normal border
        if (tile.getRiverBorder() != null && tile.getRiverBorder(x) && (x == 0 || x == 3)) return Colors.BLUE_BACKGROUND + "___________" + Colors.RESET;
        if (tile.getRiverBorder() != null && tile.getRiverBorder(x) && (x == 2 || x == 5)) return Colors.BLUE_BACKGROUND + "/" + Colors.RESET;
        else if (tile.getRiverBorder() != null && tile.getRiverBorder(x) && (x == 1 || x == 4))
            return Colors.BLUE_BACKGROUND + "\\" + Colors.RESET;
        else if ((x == 0 && tile.getX() >= 2) || x == 3) return getColorOfTile(tile) + "___________" + Colors.RESET;
        else if (x == 0) return "___________";
        else if (x == 2 || x == 5) return "/";
        else return "\\";
    }

    public String getColorOfTile(Tile tile) {
        String BACKGROUND_COLOR = switch (tile.getTerrain().getColor()) {
            case "red" -> Colors.RED_BACKGROUND;
            case "yellow" -> Colors.YELLOW_BACKGROUND;
            case "purple" -> Colors.PURPLE_BACKGROUND;
            case "green" -> Colors.GREEN_BACKGROUND;
            case "cyan" -> Colors.CYAN_BACKGROUND_BRIGHT;
            case "brightBlue" -> Colors.BLUE_BACKGROUND_BRIGHT;
            case "brightGreen" -> Colors.GREEN_BACKGROUND_BRIGHT;
            case "brightBlack" -> Colors.BLACK_BACKGROUND_BRIGHT;
            case "white" -> Colors.WHITE_BACKGROUND_BRIGHT;
            default -> Colors.GREEN_BACKGROUND_BRIGHT;
        };
        return BACKGROUND_COLOR;
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

    public ArrayList<Tile> firstSetOfSettlers(ArrayList<User> users){
        ArrayList<Tile> tiles = new ArrayList<>();
        ArrayList<Tile> newTiles = new ArrayList<>();
        if(users.size()<=0)return tiles;
        newTiles = users.get(0).getTerritory();
        newTiles.add(map.getSpecificTile(12,15));
        users.get(0).setTerritory(newTiles);
        map.getSpecificTile(12,15).setCivilianUnit(new Unit(users.get(0).getUsername(),map.getSpecificTile(12,15),0,0,0,0,0,0,users.get(0),0));
        tiles.add(map.getSpecificTile(12,15));
        if(users.size()<=1)return tiles;
        newTiles = users.get(1).getTerritory();
        newTiles.add(map.getSpecificTile(25,19));
        users.get(1).setTerritory(newTiles);
        map.getSpecificTile(25,19).setCivilianUnit(new Unit(users.get(1).getUsername(),map.getSpecificTile(25,19),0,0,0,0,0,0,users.get(1),0));
        tiles.add(map.getSpecificTile(25,19));
        if(users.size()<=2)return tiles;
        newTiles = users.get(2).getTerritory();
        newTiles.add(map.getSpecificTile(40,11));
        users.get(2).setTerritory(newTiles);
        map.getSpecificTile(40,11).setCivilianUnit(new Unit(users.get(2).getUsername(),map.getSpecificTile(40,11),0,0,0,0,0,0,users.get(2),0));
        tiles.add(map.getSpecificTile(40,11));
        if(users.size()<=3)return tiles;
        newTiles = users.get(3).getTerritory();
        newTiles.add(map.getSpecificTile(45,8));
        users.get(3).setTerritory(newTiles);
        map.getSpecificTile(45,8).setCivilianUnit(new Unit(users.get(3).getUsername(),map.getSpecificTile(45,8),0,0,0,0,0,0,users.get(3),0));
        tiles.add(map.getSpecificTile(45,8));
        if(users.size()<=4)return tiles;
        newTiles = users.get(4).getTerritory();
        newTiles.add(map.getSpecificTile(20,6));
        users.get(4).setTerritory(newTiles);
        map.getSpecificTile(20,6).setCivilianUnit(new Unit(users.get(4).getUsername(),map.getSpecificTile(20,6),0,0,0,0,0,0,users.get(4),0));
        tiles.add(map.getSpecificTile(20,6));
        if(users.size()<=5)return tiles;
        newTiles = users.get(5).getTerritory();
        newTiles.add(map.getSpecificTile(28,2));
        users.get(5).setTerritory(newTiles);
        map.getSpecificTile(28,2).setCivilianUnit(new Unit(users.get(4).getUsername(),map.getSpecificTile(28,2),0,0,0,0,0,0,users.get(5),0));
        tiles.add(map.getSpecificTile(28,2));
        if(users.size()<=6)return tiles;
        newTiles = users.get(6).getTerritory();
        newTiles.add(map.getSpecificTile(54,20));
        users.get(6).setTerritory(newTiles);
        map.getSpecificTile(54,20).setCivilianUnit(new Unit(users.get(4).getUsername(),map.getSpecificTile(54,20),0,0,0,0,0,0,users.get(6),0));
        tiles.add(map.getSpecificTile(54,20));
        if(users.size()<=7)return tiles;
        newTiles = users.get(7).getTerritory();
        newTiles.add(map.getSpecificTile(60,23));
        users.get(7).setTerritory(newTiles);
        map.getSpecificTile(60,23).setCivilianUnit(new Unit(users.get(4).getUsername(),map.getSpecificTile(60,23),0,0,0,0,0,0,users.get(7),0));
        tiles.add(map.getSpecificTile(60,23));
        if(users.size()<=8)return tiles;
        newTiles = users.get(8).getTerritory();
        newTiles.add(map.getSpecificTile(65,16));
        users.get(8).setTerritory(newTiles);
        map.getSpecificTile(65,16).setCivilianUnit(new Unit(users.get(4).getUsername(),map.getSpecificTile(65,16),0,0,0,0,0,0,users.get(8),0));
        tiles.add(map.getSpecificTile(65,16));
        if(users.size()<=9)return tiles;
        newTiles = users.get(9).getTerritory();
        newTiles.add(map.getSpecificTile(75,17));
        users.get(9).setTerritory(newTiles);
        map.getSpecificTile(75,17).setCivilianUnit(new Unit(users.get(4).getUsername(),map.getSpecificTile(75,17),0,0,0,0,0,0,users.get(9),0));
        tiles.add(map.getSpecificTile(75,17));
        if(users.size()<=10)return tiles;
        newTiles = users.get(10).getTerritory();
        newTiles.add(map.getSpecificTile(78,21));
        users.get(10).setTerritory(newTiles);
        map.getSpecificTile(78,21).setCivilianUnit(new Unit(users.get(4).getUsername(),map.getSpecificTile(78,21),0,0,0,0,0,0,users.get(10),0));
        tiles.add(map.getSpecificTile(78,21));
        if(users.size()<=11)return tiles;
        newTiles = users.get(11).getTerritory();
        newTiles.add(map.getSpecificTile(19,4));
        users.get(11).setTerritory(newTiles);
        map.getSpecificTile(19,4).setCivilianUnit(new Unit(users.get(11).getUsername(),map.getSpecificTile(19,4),0,0,0,0,0,0,users.get(11),0));
        tiles.add(map.getSpecificTile(19,4));
        return tiles;
    }
}
