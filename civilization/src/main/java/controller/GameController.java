package controller;

import model.*;

import java.util.ArrayList;

public class GameController {
    private ArrayList<User> players;
    private Maps map;
    private int turnForEachPlayer;
    private int height;
    private int width;
    public GameController(ArrayList<User> players, int turnForEachPlayer, Maps map, int height, int width) {
        this.players = players;
        this.map = map;
        for (User player : players) {
            player.setTurns(turnForEachPlayer);
            player.setGold(0);
        }
        this.turnForEachPlayer = turnForEachPlayer;
        this.height = height;
        this.width = width;
    }
    // cheat code for increasing the turn of user
    public void increaseTurn(int extraTurn, User specificPlayer) {
        specificPlayer.setTurns(specificPlayer.getTurns() + extraTurn);
    }
    // cheat code for increasing the gold of user
    public void increaseGold(int extraGold, User specificPlayer) {
        specificPlayer.setGold(specificPlayer.getGold() + extraGold);
    }
    // find the tile by given x and y coordinates
    public Tile findTile(int x, int y) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map.getTileBoard()[i][j].getX() == x && map.getTileBoard()[i][j].getY() == y)
                    return map.getTileBoard()[i][j];
            }
        }
        return null;
    }
    public void moveUnit(Tile origin, Tile destination, Unit unit, boolean isMilitary) {
        if (isMilitary)
            moveMilitary(origin, destination, (MilitaryUnit) unit);
        else
            moveCivilian(origin, destination, (Civilian) unit);
    }

    private void moveMilitary(Tile origin, Tile destination, MilitaryUnit militaryUnit) {
        militaryUnit.setTile(destination);
        origin.setMilitaryUnit(null);
        origin.setMilitaryUnitExists(false);
        destination.setMilitaryUnit(militaryUnit);
        destination.setMilitaryUnitExists(true);
    }
    private void moveCivilian(Tile origin, Tile destination, Civilian civilian) {
        civilian.setTile(destination);
        origin.setCivilianUnit(null);
        origin.setCivilianUnitExists(false);
        destination.setCivilianUnit(civilian);
        destination.setCivilianUnitExists(true);
    }

    public int getTurnForEachPlayer() {
        return turnForEachPlayer;
    }

    public void setTurnForEachPlayer(int turnForEachPlayer) {
        this.turnForEachPlayer = turnForEachPlayer;
    }

    public void cityTurnProducts(User user) {
        // for each on user's cities
        for (City city : user.getCities()) {
            // if producing production
            if (city.isProductStatus()) {
                // if product is done
                if (city.getProductTurnLeft() <= 1) {
                    city.setProductTurnLeft(0);
                    findProduction(city, city.getCurrentProduction());
                    city.setCurrentProduction(null);
                    city.setProductStatus(false);
                }
                else
                    city.setProductTurnLeft(city.getProductTurnLeft() - 1);
            }
        }
    }
    public void userTurnResearch(User user) {
        if (user.isResearching()) {
            // if research is done
            if (user.getResearchTurnLeft() <= 1) {
                user.setResearching(false);
                user.setResearchTurnLeft(0);
                user.addTechnology(user.getCurrentTechnology());
                // add given improvements to user's arraylist of improvements
                if (user.getCurrentTechnology().getGivenImprovement() != null) {
                    for (Improvement improvement : user.getCurrentTechnology().getGivenImprovement()) {
                        user.addImprovement(improvement);
                    }
                }
                // add given units to all the cities products
                if (user.getCurrentTechnology().getGivenUnits() != null) {
                    for (Unit givenUnit : user.getCurrentTechnology().getGivenUnits()) {
                        for (City city : user.getCities()) {
                            city.addProduct(new Product(givenUnit.getName(), givenUnit.getPrice()));
                            // TODO add unit to possible units in city page
                            city.addPossibleUnit(new Unit(givenUnit.getName(), city.getTile(), givenUnit.getHP(), givenUnit.getPrice(), givenUnit.getLevel(), givenUnit.getMP(), givenUnit.getCombatStrength(), givenUnit.getRangeCombatStrength(), city.getOwner(), givenUnit.getAttackPoint()));
                        }
                    }
                }
                user.setCurrentTechnology(null);
            }
            else
                user.setResearchTurnLeft(user.getResearchTurnLeft() - 1);
        }
    }
    // check all workers
    public void userTurnWorker(User player) {

        for (Unit unit : player.getUnits()) {
            // find worker
            if (unit.getName().equals("worker") && ((Worker)unit).getWorkingStatus()) {
                Worker worker = (Worker)unit;
                // if it is done
                if (worker.getRemainingTurnsToComplete() <= 1) {
                    worker.setWorkingStatus(false);
                    worker.setRemainingTurnsToComplete(0);
                    worker.getTile().setInProgress(false);
                    worker.getTile().setImprovement(worker.getImprovement());
                    worker.setImprovement(null);
                }
                else {
                    worker.setRemainingTurnsToComplete(worker.getRemainingTurnsToComplete() - 1);
                }
            }
        }
    }
    // find the unit based on production name
    private void findProduction(City city, Product product) {
        for (int i = 0; i < city.getPossibleUnits().size(); i++) {
            if (city.getPossibleUnits().get(i).getName().equals(product.getName())) {
                city.getOwner().addUnit(city.getPossibleUnits().get(i));
                //  TODO add the city to unit information
                i = city.getPossibleUnits().size();
            }
        }
    }
}
