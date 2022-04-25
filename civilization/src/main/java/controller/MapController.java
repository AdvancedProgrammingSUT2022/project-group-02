package controller;

import model.Maps;
import model.Tile;
import model.User;
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
        int cost = bestChoice.getLand().getMovementPrice();
        int fullCost = distance + cost;
        for (int i = 1; i < tile.getNeighbors().size(); i++) {
            // if the tile is mountain or ocean or there is same unit in this tile do not add it
            if (checkConditionOfAddingTheTile(tile, isMilitary))
                continue;
            //swap
            if (tile.getNeighbors().get(i).getLand().getMovementPrice() + findDistance(tile.getNeighbors().get(i), destination) < fullCost) {
                fullCost = tile.getNeighbors().get(i).getLand().getMovementPrice() + findDistance(tile.getNeighbors().get(i), destination);
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
        boolean isMountainOrOcean = tile.getLand().getName().equals("mountain") || tile.getLand().getName().equals("ocean");
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

    public void showMap(){
        String ANSI_COLOR;
        //first top sides of left tiles of game board
        for (int j = 0; j < 4; j++)
            System.out.print("   " + riverFinder(map.getTileBoard()[0][j], 0) + "              ");
        System.out.println();

        //print the game board
        for (int i = 0; i < 4; i++) {

            leftCoordinatesPlace(i);

            leftOwnerName(i);

            //units on the left tiles and top sides of right tiles
            for (int j = 0; j < 4; j++) {
                ANSI_COLOR = getColorOfTileOwner(map.getTileBoard()[2 * i][j]);
                System.out.print(riverFinder(map.getTileBoard()[2 * i][j], 5) + "    "
                        + ANSI_COLOR + civilianUnit(map.getTileBoard()[2 * i][j])
                        + "   " + ANSI_COLOR+militaryUnit(map.getTileBoard()[2 * i][j]) + "    "
                        + Colors.RESET+ Colors.RESET + riverFinder(map.getTileBoard()[2 * i][j], 1));
                if (i != 0)System.out.print(riverFinder(map.getTileBoard()[2 * i - 1][j], 3));
                else System.out.print(riverFinder(map.getTileBoard()[1][j], 0));
            }
            if (i != 0) System.out.println(riverFinder(map.getTileBoard()[2 * i][3], 2));
            else System.out.println();

            leftResourceAndTerrain(i);

            rightOwnerName(i);

            leftBottomSides(i);

        }

    }

    private void leftCoordinatesPlace(int i) {

        //Coordinates of left tiles and resource and terrain in right tiles
        for (int j = 0; j < 4; j++) {
            if (i != 0)
                System.out.print("  " + riverFinder(map.getTileBoard()[2 * i][j], 5)
                        + getColorOfTile(map.getTileBoard()[2 * i][j])
                        + "   [" + (2 * i) + "," + j + "]   " + Colors.RESET + riverFinder(map.getTileBoard()[2 * i][j], 1)
                        + "    " + tileResource(map.getTileBoard()[2 * i - 1][j], true)
                        + "   " + tileTerrain(map.getTileBoard()[2 * i - 1][j], true) + "  ");
            else System.out.print("  " + riverFinder(map.getTileBoard()[2 * i][j], 5)
                    + getColorOfTile(map.getTileBoard()[2 * i][j])
                    + "   [" + 0 + "," + j + "]   " + Colors.RESET + riverFinder(map.getTileBoard()[2 * i][j], 1) + "             ");
        }
        if (i != 0) System.out.println("  " + riverFinder(map.getTileBoard()[2 * i - 1][3], 2));
        else System.out.println();

    }

    private void leftOwnerName(int i) {
        String ANSI_COLOR = Colors.WHITE;

        //owner name and color of left tiles
        for (int j = 0; j < 4; j++) {
            ANSI_COLOR = getColorOfTileOwner(map.getTileBoard()[2 * i][j]);
            if (i != 0)
                System.out.print(" " + riverFinder(map.getTileBoard()[2 * i][j], 5)
                        + "     " + ANSI_COLOR + tileOwner(map.getTileBoard()[2 * i][j]) + Colors.RESET + "     "
                        + riverFinder(map.getTileBoard()[2 * i][j], 1)
                        + "     " + tileImprovement(map.getTileBoard()[2 * i - 1][j]) + "    ");
            else System.out.print(" " + riverFinder(map.getTileBoard()[2 * i][j], 5)
                    + "     " + ANSI_COLOR + tileOwner(map.getTileBoard()[2 * i][j]) + Colors.RESET + "     "
                    + riverFinder(map.getTileBoard()[2 * i][j], 1)
                    + "            ");
        }
        if (i != 0) System.out.println(" " + riverFinder(map.getTileBoard()[2 * i][0], 2));
        else System.out.println();

    }

    private void leftResourceAndTerrain(int i) {

        //resource and terrain in left tiles and Coordinates of right tiles
        for (int j = 0; j < 4; j++) {
            if (i != 3)
                System.out.print(riverFinder(map.getTileBoard()[2 * i][j], 4)
                        + "    " + tileResource(map.getTileBoard()[2 * i][j], false)
                        + "   " + tileTerrain(map.getTileBoard()[2 * i][j], false)
                        + "    " + riverFinder(map.getTileBoard()[2 * i][j], 2)
                        + getColorOfTile(map.getTileBoard()[2 * i+1][j]) + "   [" + (2 * i + 1) + "," + j + "]   " + Colors.RESET);
            else System.out.print(riverFinder(map.getTileBoard()[2 * i][j], 4)
                    + "    " + tileResource(map.getTileBoard()[2 * i][j], false)
                    + "   " + tileTerrain(map.getTileBoard()[2 * i][0], false) + "    "
                    + riverFinder(map.getTileBoard()[2 * i][j], 2) + "           ");
        }
        if (i != 3) System.out.println(riverFinder(map.getTileBoard()[2 * i + 1][3], 1));
        else System.out.println();

    }

    private void rightOwnerName(int i) {
        String ANSI_COLOR = Colors.WHITE;

        //owner name and color of right tiles
        for (int j = 0; j < 4; j++) {
            ANSI_COLOR = getColorOfTileOwner(map.getTileBoard()[2 * i][j]);

            if (i != 3)
                System.out.print(" " + riverFinder(map.getTileBoard()[2 * i][j], 4)
                        + "     " + tileImprovement(map.getTileBoard()[2 * i][j])
                        + "     " + riverFinder(map.getTileBoard()[2 * i][j], 2)
                        + "     " + ANSI_COLOR + tileOwner(map.getTileBoard()[2 * i][j]) + Colors.RESET + "    ");
            else System.out.print(" " + riverFinder(map.getTileBoard()[2 * i][j], 4)
                    + "     " + tileImprovement(map.getTileBoard()[2 * i][j])
                    + "     " + riverFinder(map.getTileBoard()[2 * i][j], 2) + "            ");
        }
        if (i != 3) System.out.println(" " + riverFinder(map.getTileBoard()[2 * i + 1][3], 1));
        else System.out.println();

    }

    private void leftBottomSides(int i) {
        String ANSI_COLOR = Colors.WHITE;

        //bottom sides of left tiles and units on the right tiles
        for (int j = 0; j < 4; j++) {
            if (i != 3)ANSI_COLOR = getColorOfTileOwner(map.getTileBoard()[2 * i + 1][j]);

            if (i != 3)
                System.out.print("  " + riverFinder(map.getTileBoard()[2 * i][j], 4)
                        + riverFinder(map.getTileBoard()[2 * i][j], 3) + riverFinder(map.getTileBoard()[2 * i][j], 2)
                        + "    " + ANSI_COLOR + civilianUnit(map.getTileBoard()[2 * i + 1][0])
                        + "   " + ANSI_COLOR+militaryUnit(map.getTileBoard()[2 * i + 1][j]) +Colors.RESET+ Colors.RESET + "  ");
            else System.out.print("  " + riverFinder(map.getTileBoard()[2 * i][j], 4) + riverFinder(map.getTileBoard()[2 * i][j], 3)
                    + riverFinder(map.getTileBoard()[2 * i][j], 2) + "             ");
        }
        if (i != 3) System.out.println("  " + riverFinder(map.getTileBoard()[2 * i + 1][3], 1));
        else System.out.println();

    }

    private String tileImprovement(Tile tile) {
        if (tile.getImprovement() == null) return "NIY";
        else return tile.getImprovement().getName().substring(0, 3);
    }

    private String tileOwner(Tile tile) {
        if (tile.getOwner() == null) return "   ";
        else return tile.getOwner().getNickname().substring(0, 3);
    }

    private String civilianUnit(Tile tile) {
        if (tile.getCivilianUnit() == null) return "  ";
        else return tile.getCivilianUnit().getName().substring(0, 2);
    }

    private String militaryUnit(Tile tile) {
        if (tile.getMilitaryUnit() == null) return "  ";
        else return tile.getMilitaryUnit().getName().substring(0, 2);
    }

    private String tileResource(Tile tile, boolean isFirstRightRow) {
        if (isFirstRightRow || tile.getLand().getResource() == null) return "  ";
        else return tile.getLand().getResource().getName().substring(0, 2);
    }

    private String tileTerrain(Tile tile, boolean isFirstRightRow) {
        if (isFirstRightRow || tile.getLand().getTerrain() == null) return "  ";
        else return tile.getLand().getTerrain().getName().substring(0, 2);
    }

    private String getColorOfTileOwner(Tile tile) {
        String ANSI_COLOR = Colors.BLUE;
        if (tile.getOwner() == null) ANSI_COLOR = Colors.BLACK;
        else if (tile.getOwner().getColor().equals("green")) ANSI_COLOR = Colors.GREEN;
        else if (tile.getOwner().getColor().equals("red")) ANSI_COLOR = Colors.RED;
        else if (tile.getOwner().getColor().equals("yellow")) ANSI_COLOR = Colors.YELLOW;
        else if (tile.getOwner().getColor().equals("purple")) ANSI_COLOR = Colors.PURPLE;
        else if (tile.getOwner().getColor().equals("cyan")) ANSI_COLOR = Colors.CYAN;
        return ANSI_COLOR;
    }

    private String riverFinder(Tile tile, int x) {
        //print the river or normal border
        if (tile.getRiverBorder(x) && (x == 0 || x == 3)) return Colors.BLUE_BACKGROUND + "___________" + Colors.RESET;
        if (tile.getRiverBorder(x) && (x == 2 || x == 5)) return Colors.BLUE_BACKGROUND + "/" + Colors.RESET;
        else if (tile.getRiverBorder(x) && (x == 1 || x == 4))
            return Colors.BLUE_BACKGROUND + "\\" + Colors.RESET;
        else if (x == 0 || x == 3) return "___________";
        else if (x == 2 || x == 5) return "/";
        else return "\\";
    }

    private String getColorOfTile(Tile tile) {
        String BACKGROUND_COLOR = Colors.CYAN_BACKGROUND;
        if (tile.getLand().getColor().equals("red")) {
            BACKGROUND_COLOR = Colors.RED_BACKGROUND;
        } else if (tile.getLand().getColor().equals("yellow")) {
            BACKGROUND_COLOR = Colors.YELLOW_BACKGROUND;
        }else if(tile.getLand().getColor().equals("purple")){
            BACKGROUND_COLOR = Colors.PURPLE_BACKGROUND;
        }else if(tile.getLand().getColor().equals("green")){
            BACKGROUND_COLOR = Colors.GREEN_BACKGROUND;
        }else if(tile.getLand().getColor().equals("cyan")){
            BACKGROUND_COLOR = Colors.CYAN_BACKGROUND;
        }
        return BACKGROUND_COLOR;
    }
}
