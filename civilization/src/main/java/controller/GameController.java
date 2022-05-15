package controller;

import model.*;
import view.UserPanel;

import java.util.ArrayList;
import java.util.Set;

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

    public String moveUnit(Tile origin, Tile destination, Unit unit, boolean isMilitary) {
        if (isMilitary) {
            if(destination.isMilitaryUnitExists())
                return "there is already exists another military unit";
            return moveMilitary(origin, destination, (MilitaryUnit) unit);
        }
        else {
            if(destination.isCivilianUnitExists())
                return "there is already exists another civilian unit";
            return moveCivilian(origin, destination, (Civilian) unit);
        }
    }

    private String moveMilitary(Tile origin, Tile destination, MilitaryUnit militaryUnit) {
        militaryUnit.setTile(destination);
        origin.setMilitaryUnit(null);
        origin.setMilitaryUnitExists(false);
        destination.setMilitaryUnit(militaryUnit);
        destination.setMilitaryUnitExists(true);
        return "military unit moved successfully";
    }

    private String moveCivilian(Tile origin, Tile destination, Civilian civilian) {
        civilian.setTile(destination);
        origin.setCivilianUnit(null);
        origin.setCivilianUnitExists(false);
        destination.setCivilianUnit(civilian);
        destination.setCivilianUnitExists(true);
        return "civilian unit moved successfully";
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
                    MeleeMilitaryUnit meleeMilitaryUnit;
                    RangeMilitaryUnit rangeMilitaryUnit;
                    for (Unit givenUnit : user.getCurrentTechnology().getGivenUnits()) {
                        for (City city : user.getCities()) {
                            // range military unit
                            if (givenUnit.getRangeCombatStrength() > 0) {
                                rangeMilitaryUnit = new RangeMilitaryUnit(givenUnit.getName(), null, givenUnit.getHP(), givenUnit.getGoldPrice(), givenUnit.getProductionPrice(), givenUnit.getLevel(), givenUnit.getMP(), givenUnit.getCombatStrength(), givenUnit.getRangeCombatStrength(), city.getOwner(), givenUnit.getAttackPoint(), givenUnit.getMaintainGold());
                                city.addPossibleUnit(rangeMilitaryUnit);
                                city.addProduct(new Product(rangeMilitaryUnit.getName(), rangeMilitaryUnit.getProductionPrice()));
                            }
                            // melee military unit
                            else {
                                meleeMilitaryUnit = new MeleeMilitaryUnit(givenUnit.getName(), null, givenUnit.getHP(), givenUnit.getGoldPrice(), givenUnit.getProductionPrice(), givenUnit.getLevel(), givenUnit.getMP(), givenUnit.getCombatStrength(), givenUnit.getRangeCombatStrength(), city.getOwner(), givenUnit.getAttackPoint(), givenUnit.getMaintainGold());
                                city.addPossibleUnit(meleeMilitaryUnit);
                                city.addProduct(new Product(meleeMilitaryUnit.getName(), meleeMilitaryUnit.getProductionPrice()));
                            }
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
                        for (Resource resource : worker.getImprovement().getGivenResources()) {
                            if (resource.getName().equals(worker.getTile().getResource().getName()))
                                 player.setAvailableResources(worker.getTile().getResource());
                        }
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
        Worker worker;
        Settler settler;
        Civilian scout;
        MeleeMilitaryUnit meleeMilitaryUnit;
        RangeMilitaryUnit rangeMilitaryUnit;
        for (int i = 0; i < city.getPossibleUnits().size(); i++) {
            if (city.getPossibleUnits().get(i).getName().equals(product.getName())) {
                Unit unit = city.getPossibleUnits().get(i);
                // worker
                if (unit.getName().equals("worker")) {
                    Tile tile = findTileForCivilian(city.getTile());
                    worker = new Worker(unit.getName(), tile, unit.getHP(), unit.getGoldPrice(), unit.getProductionPrice(), unit.getLevel(), unit.getMP(), unit.getCombatStrength(), unit.getRangeCombatStrength(), false, city.getOwner(), unit.getAttackPoint(), unit.getMaintainGold());
                    tile.setCivilianUnit(worker);
                    tile.setCivilianUnitExists(true);
                    worker.setTile(tile);
                    city.getOwner().addUnit(worker);
                    UserPanel.productDoneNotification(city.getOwner(), city, worker, this);
                }
                // settler
                else if (unit.getName().equals("settler")) {
                    Tile tile = findTileForCivilian(city.getTile());
                    settler = new Settler("settler", tile, unit.getHP(), unit.getGoldPrice(), unit.getProductionPrice(), unit.getLevel(), unit.getMP(), unit.getCombatStrength(), unit.getRangeCombatStrength(), null, city.getOwner(), unit.getAttackPoint(), unit.getMaintainGold());
                    tile.setCivilianUnit(settler);
                    tile.setCivilianUnitExists(true);
                    settler.setTile(tile);
                    city.getOwner().addUnit(settler);
                    UserPanel.productDoneNotification(city.getOwner(), city, settler, this);
                }
                else if (unit.getName().equals("scout")) {
                    Tile tile = findTileForCivilian(city.getTile());
                    scout = new Civilian("scout", tile, unit.getHP(), unit.getGoldPrice(), unit.getProductionPrice(), unit.getLevel(), unit.getMP(), unit.getCombatStrength(), unit.getRangeCombatStrength(), city.getOwner(), unit.getAttackPoint(), unit.getMaintainGold());
                    tile.setCivilianUnit(scout);
                    tile.setCivilianUnitExists(true);
                    scout.setTile(tile);
                    city.getOwner().addUnit(scout);
                    UserPanel.productDoneNotification(city.getOwner(), city, scout, this);
                }
                // ranged
                else if (unit.getRangeCombatStrength() > 0) {
                    Tile tile = findTileForMilitary(city.getTile());
                    rangeMilitaryUnit = new RangeMilitaryUnit(unit.getName(), tile, unit.getHP(), unit.getGoldPrice(), unit.getProductionPrice(), unit.getLevel(), unit.getMP(), unit.getCombatStrength(), unit.getRangeCombatStrength(), city.getOwner(), unit.getAttackPoint(), unit.getMaintainGold());
                    tile.setMilitaryUnit(rangeMilitaryUnit);
                    tile.setMilitaryUnitExists(true);
                    rangeMilitaryUnit.setTile(tile);
                    city.getOwner().addUnit(rangeMilitaryUnit);
                    UserPanel.productDoneNotification(city.getOwner(), city, rangeMilitaryUnit, this);
                }
                // melee
                else {
                    Tile tile = findTileForMilitary(city.getTile());
                    System.out.println("i am here");
                    meleeMilitaryUnit = new MeleeMilitaryUnit(unit.getName(), tile, unit.getHP(), unit.getGoldPrice(), unit.getProductionPrice(), unit.getLevel(), unit.getMP(), unit.getCombatStrength(), unit.getRangeCombatStrength(), city.getOwner(), unit.getAttackPoint(), unit.getMaintainGold());
                    tile.setMilitaryUnit(meleeMilitaryUnit);
                    tile.setMilitaryUnitExists(true);
                    meleeMilitaryUnit.setTile(tile);
                    city.getOwner().addUnit(meleeMilitaryUnit);
                    UserPanel.productDoneNotification(city.getOwner(), city, meleeMilitaryUnit, this);
                }
                i = city.getPossibleUnits().size();
            }
        }
    }

    public void usersGoldHandling(User user, Maps map) {
        user.setGoldPerTurn(0);
        user.setFoodPerTurn(0);
        user.setProductPerTurn(0);
        new ResourceController().userResource(user, map);
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

    private Tile findTileForMilitary(Tile origin) {
        if (origin.isMilitaryUnitExists()) {
            for (Tile neighbor : origin.getNeighbors()) {
                if (!neighbor.isMilitaryUnitExists() && neighbor.getTerrain().isPassable())
                    return neighbor;
            }
            for (Tile neighbor : origin.getNeighbors()) {
                for (Tile neighborNeighbor : neighbor.getNeighbors()) {
                    if (!neighborNeighbor.isMilitaryUnitExists() && neighbor.getTerrain().isPassable())
                        return neighborNeighbor;
                }
            }
        }
        return origin;
    }
    private Tile findTileForCivilian(Tile origin) {
        if (origin.isCivilianUnitExists()) {
            for (Tile neighbor : origin.getNeighbors()) {
                if (!neighbor.isCivilianUnitExists() && neighbor.getTerrain().isPassable())
                    return neighbor;
            }
            for (Tile neighbor : origin.getNeighbors()) {
                for (Tile neighborNeighbor : neighbor.getNeighbors()) {
                    if (!neighborNeighbor.isCivilianUnitExists() && neighbor.getTerrain().isPassable())
                        return neighborNeighbor;
                }
            }
        }
        return origin;
    }
}
