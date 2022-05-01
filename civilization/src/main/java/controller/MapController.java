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
        if (isFirstRightRow || tile.getTerrain() == null) return "  ";
        else return tile.getTerrain().getName().substring(0, 2);
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
        if (tile.getRiverBorder(x) && (x == 0 || x == 3)) return Colors.BLUE_BACKGROUND + "___________" + Colors.RESET;
        if (tile.getRiverBorder(x) && (x == 2 || x == 5)) return Colors.BLUE_BACKGROUND + "/" + Colors.RESET;
        else if (tile.getRiverBorder(x) && (x == 1 || x == 4))
            return Colors.BLUE_BACKGROUND + "\\" + Colors.RESET;
        else if ((x == 0 && tile.getX() >= 2) || x == 3) return getColorOfTile(tile) + "___________" + Colors.RESET;
        else if (x == 0) return "___________";
        else if (x == 2 || x == 5) return "/";
        else return "\\";
    }

    public String getColorOfTile(Tile tile) {
        String BACKGROUND_COLOR = switch (tile.getLand().getColor()) {
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

    public String showImprovments(User user, Tile tile) {
        String output = null;
        for (int i = 0; i < user.getTechnologies().size(); i++) {
            if (user.getTechnologies().get(i).equals("Pottery")) {
                if (tile.getImprovement().equals("Granary")) output += "Granary\n";
                else if (tile.getImprovement().equals("Mekewap")) output += "Mekewap\n";
                else if (tile.getImprovement().equals("Great Bath")) output += "Great Bath\n";
            }
            if (user.getTechnologies().get(i).equals("Animal Husbandry")) {
                if (tile.getImprovement().equals("Camp")) output += "Camp\n";
                else if (tile.getImprovement().equals("Pasture")) output += "Pasture\n";
                else if (tile.getImprovement().equals("Kurgan")) output += "Kurgan\n";
            }
            if (user.getTechnologies().get(i).equals("Mining")) {
                if (tile.getImprovement().equals("Mine")) output += "Mine\n";
                else if (tile.getImprovement().equals("Quarry")) output += "Quarry\n";
            }
            if (user.getTechnologies().get(i).equals("Sailing")) {
                if (tile.getImprovement().equals("Fishing Boats")) output += "Fishing Boats\n";
                else if (tile.getImprovement().equals("Galley")) output += "Galley\n";
                else if (tile.getImprovement().equals("Viking Longship")) output += "Viking Longship\n";
                else if (tile.getImprovement().equals("Bireme")) output += "Bireme\n";
            }
            if (user.getTechnologies().get(i).equals("Astrology")) {
                if (tile.getImprovement().equals("Stonehenge")) output += "Stonehenge\n";
                else if (tile.getImprovement().equals("Holy Site")) output += "Holy Site\n";
                else if (tile.getImprovement().equals("Lavra")) output += "Lavra\n";
                else if (tile.getImprovement().equals("Shrine")) output += "Shrine\n";
            }
            if (user.getTechnologies().get(i).equals("Irrigation") && user.getTechnologies().contains("Pottery")) {
                if (tile.getImprovement().equals("Hanging Gardens")) output += "Hanging Gardens\n";
                else if (tile.getImprovement().equals("Plantation")) output += "Plantation\n";
                else if (tile.getImprovement().equals("Stepwell")) output += "Stepwell\n";
                else if (tile.getImprovement().equals("Palgum")) output += "Palgum\n";
            }
            if (user.getTechnologies().get(i).equals("Writing") && user.getTechnologies().contains("Pottery")) {
                if (tile.getImprovement().equals("Etemenanki")) output += "Etemenanki\n";
                else if (tile.getImprovement().equals("Campus")) output += "Campus\n";
                else if (tile.getImprovement().equals("Seowon")) output += "Seowon\n";
                else if (tile.getImprovement().equals("Observatory")) output += "Observatory\n";
                else if (tile.getImprovement().equals("Library")) output += "Library\n";
            }
            if (user.getTechnologies().get(i).equals("Archery") && user.getTechnologies().contains("Animal Husbandry")) {
                if (tile.getImprovement().equals("Archer")) output += "Archer\n";
                else if (tile.getImprovement().equals("Pítati Archer")) output += "Pítati Archer\n";
                else if (tile.getImprovement().equals("Hul'che")) output += "Hul'che\n";
                else if (tile.getImprovement().equals("Temple of Artemis")) output += "Temple of Artemis\n";
            }
            if (user.getTechnologies().get(i).equals("Masonry") && user.getTechnologies().contains("Mining")) {
                if (tile.getImprovement().equals("Battering Ram")) output += "Battering Ram\n";
                else if (tile.getImprovement().equals("Ancient Walls")) output += "Ancient Walls\n";
                else if (tile.getImprovement().equals("Pyramids")) output += "Pyramids\n";
                else if (tile.getImprovement().equals("Great Wall")) output += "Great Wall\n";
                else if (tile.getImprovement().equals("Nubian Pyramid")) output += "Nubian Pyramid\n";
            }
            if (user.getTechnologies().get(i).equals("Bronze Working") && user.getTechnologies().contains("Mining")) {
                if (tile.getImprovement().equals("Spearman")) output += "Spearman\n";
                else if (tile.getImprovement().equals("Hoplite")) output += "Hoplite\n";
                else if (tile.getImprovement().equals("Encampment")) output += "Encampment\n";
                else if (tile.getImprovement().equals("Ikanda")) output += "Ikanda\n";
                else if (tile.getImprovement().equals("Barracks")) output += "Barracks\n";
                else if (tile.getImprovement().equals("Basilikoi Paides")) output += "Basilikoi Paides\n";
            }
            if (user.getTechnologies().get(i).equals("Wheel") && user.getTechnologies().contains("Mining")) {
                if (tile.getImprovement().equals("Heavy Chariot")) output += "Heavy Chariot\n";
                else if (tile.getImprovement().equals("Maryannu Chariot Archer")) output += "Maryannu Chariot Archer\n";
                else if (tile.getImprovement().equals("Water Mill")) output += "Water Mill\n";
            }
        }
        return output;
    }

    public String selectImprovment(User user,String improvment,String availableImprovments){
        if(availableImprovments.contains(improvment)){
            Improvement improvment2 = new Improvement(improvment, 0, 0, 0);
            user.setImprovements(improvment2);
            return "improvment added successfully to your civilization";
        }
        return "unavailable improvment";
    }
}
