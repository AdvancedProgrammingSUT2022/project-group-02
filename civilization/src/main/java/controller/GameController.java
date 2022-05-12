package controller;

import model.*;
import view.UserPanel;

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

    // cheat codes
    public void increaseTurn(int extraTurn, User specificPlayer) {
        specificPlayer.setTurns(specificPlayer.getTurns() + extraTurn);
    }

    public void increaseGold(int extraGold, User specificPlayer) {
        specificPlayer.setGold(specificPlayer.getGold() + extraGold);
    }

    public void increaseHappiness(int extraHappiness, User specificPlayer) {
        specificPlayer.setHappiness(specificPlayer.getHappiness() + extraHappiness);
    }

    public void increaseFood(int extraFood, User specificPlayer) {
        specificPlayer.setFood(specificPlayer.getFood() + extraFood);
    }

    public void increaseFaith(int extraFaith, User specificPlayer) {
        specificPlayer.setFaith(specificPlayer.getFaith() + extraFaith);
    }

    public void increaseScience(int extraScience, User specificPlayer) {
        specificPlayer.setScience(specificPlayer.getScience() + extraScience);
    }

    public void increaseCapitalCitizens(int extraCitizens, User specificPlayer) {
        specificPlayer.getCapital().setCitizens(specificPlayer.getCapital().getCitizens() + extraCitizens);
    }

    public void increaseCapitalDefence(int extraDefence, User specificPlayer) {
        specificPlayer.getCapital().setDefence(specificPlayer.getCapital().getDefence() + extraDefence);
    }

    public void increaseCulture(int extraCulture, User specificPlayer) {
        specificPlayer.setCulture(specificPlayer.getCulture() + extraCulture);
    }

    public void decreaseResearchTurnLeft(int extraResearch, User specificPlayer) {
        specificPlayer.setResearchTurnLeft(specificPlayer.getResearchTurnLeft()- extraResearch);
    }

    // find the tile by given x and y coordinates
    public Tile findTile(int x, int y) {
        if (x < height && y < width)
            return map.getTileBoard()[x][y];
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
        if (user.getCities() != null) {
            for (City city : user.getCities()) {
                // if producing production
                if (city.isProductStatus()) {
                    // if product is done
                    if (city.getProductTurnLeft() <= 1) {
                        //notification for production
                        UserPanel.productDoneNotification(user, city, city.getCurrentProduction(), this);
                        city.setProductTurnLeft(0);
                        findProduction(city, city.getCurrentProduction());
                        city.setCurrentProduction(null);
                        city.setProductStatus(false);
                    } else
                        city.setProductTurnLeft(city.getProductTurnLeft() - 1);
                }
            }
        }
    }

    public void userTurnResearch(User user) {
        if (user.isResearching()) {
            // if research is done
            if (user.getResearchTurnLeft() <= 1) {
                //notification for research
                UserPanel.researchDoneNotification(user, user.getCurrentTechnology());
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
                            city.addProduct(new Product(givenUnit.getName(), givenUnit.getGoldPrice()));
                            givenUnit.setTile(city.getTile());
                            givenUnit.setOwner(city.getOwner());
                            city.addPossibleUnit(givenUnit);
                        }
                    }
                }
                user.setCurrentTechnology(null);
            } else
                user.setResearchTurnLeft(user.getResearchTurnLeft() - 1);
        }
    }

    // check all workers
    public void userTurnWorker(User player) {
        if (player.getUnits() != null) {

            for (Unit unit : player.getUnits()) {
                // find worker
                if (unit.getName().equals("worker") && ((Worker) unit).getWorkingStatus()) {
                    Worker worker = (Worker) unit;
                    // if it is done
                    if (worker.getRemainingTurnsToComplete() <= 1) {
                        // notification for improvement
                        UserPanel.improvementDoneNotification(player, worker.getImprovement());
                        worker.setWorkingStatus(false);
                        worker.setRemainingTurnsToComplete(0);
                        worker.getTile().setInProgress(false);
                        worker.getTile().setImprovement(worker.getImprovement());
                        worker.setImprovement(null);
                    } else {
                        worker.setRemainingTurnsToComplete(worker.getRemainingTurnsToComplete() - 1);
                    }
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

    public Unit findProductionUnit(City city, Product product) {
        for (int i = 0; i < city.getPossibleUnits().size(); i++)
            if (city.getPossibleUnits().get(i).getName().equals(product.getName()))
                return city.getPossibleUnits().get(i);
        return null;
    }

    public void usersGoldHandling(User user) {
        user.setGoldPerTurn(0);
        user.setFoodPerTurn(0);
        user.setProductPerTurn(0);
        new ResourceController().userResource(user);
        if (user.getImprovements() != null) {
            for (Improvement improvement : user.getImprovements()) {
                if (!improvement.getTile().LootedStatus()) {
                    user.setGoldPerTurn(user.getGoldPerTurn() + improvement.getGoldRate());
                    user.setFoodPerTurn(user.getFoodPerTurn() + improvement.getFoodRate());
                    user.setProductPerTurn(user.getProductPerTurn() + improvement.getProductionRate());
                }
            }
        }
        if (user.getTerritory() != null) {
            for (Tile tile : user.getTerritory()) {
                if (tile.getFeature() != null) {
                    user.setGoldPerTurn(user.getGoldPerTurn() + tile.getFeature().getGoldRate());
                    user.setFoodPerTurn(user.getFoodPerTurn() + tile.getFeature().getFoodRate());
                    user.setProductPerTurn(user.getProductPerTurn() + tile.getFeature().getProductionRate());
                }
                user.setGoldPerTurn(user.getGoldPerTurn() + tile.getTerrain().getGoldRate());
                user.setGoldPerTurn(user.getFoodPerTurn() + tile.getTerrain().getFoodRate());
                user.setProductPerTurn(user.getProductPerTurn() + tile.getTerrain().getProductionRate());
            }
        }
        user.setGold(user.getGold() + user.getGoldPerTurn());
        user.setFood(user.getFood() + user.getFoodPerTurn());
        user.setProduct(user.getProduct() + user.getProductPerTurn());
    }
}
