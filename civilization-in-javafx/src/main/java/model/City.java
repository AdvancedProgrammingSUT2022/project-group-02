package model;

import java.util.ArrayList;
import java.util.HashMap;

public class City extends PhysicalObject {
    //TODO : SET CITY PRODUCT TURN LEFT WITH PRODUCT TURN LEFT
    private final String name;
    private Tile cityLocation;
    private boolean unhappinessEffect;
    private ArrayList<Tile> ownerShipTiles;
    private int defence;
    private Unit garrison;
    private ArrayList<Product> products;
    private int productTurnLeft;
    private int citizensNumber;
    private int food;
    private int production;
    private int gold;
    private int science;
    private int faith;
    private int tourism;
    private int culture;
    private int turnNumber;
    private ArrayList<Building> buildings;
    private boolean warStatus;
    private ArrayList<Citizen> Citizens;
    private boolean productStatus;
    private Product currentProduction;
    private ArrayList<Unit> possibleUnits;
    private ArrayList<Building> possibleBuildings;

    private int productionPerTurn;
    private int goldPerTurn;
    private int foodPerTurn;

    public City(String name, Tile cityLocation, User ownerShip, ArrayList<Tile> ownerShipTiles, int HP, int defence,
                Unit garrison, ArrayList<Product> products, int productTurnLeft, int citizensNumber, int food, int production,
                int gold, int science, int faith, int tourism, int culture, ArrayList<Building> buildings,
                ArrayList<Unit> units, boolean warStatus, ArrayList<Citizen> Citizens,
                int attackPoint) {
        super(true, attackPoint, HP, ownerShip, cityLocation);
        this.name = name;
        this.ownerShipTiles = ownerShipTiles;
        this.defence = defence;
        this.garrison = garrison;
        this.products = products;
        this.productTurnLeft = productTurnLeft;
        this.citizensNumber = citizensNumber;
        this.food = food;
        this.production = production;
        this.gold = gold;
        this.science = science;
        this.faith = faith;
        this.tourism = tourism;
        this.culture = culture;
        this.turnNumber = 0;
        this.buildings = buildings;
        this.warStatus = warStatus;
        this.Citizens = Citizens;
        this.currentProduction = null;
        this.cityLocation = cityLocation;
        this.possibleBuildings = new ArrayList<>();
        this.possibleUnits = new ArrayList<>();
        productionPerTurn = 1;
        goldPerTurn = 0;
        foodPerTurn = 0;
    }

    public void setDefence(int amount) {
        this.defence += amount;
    }

    public int getDefence() {
        return this.defence;
    }

    public void setGarrison(Unit garrison) {
        this.garrison = garrison;
    }

    public Unit getGarrison() {
        return this.garrison;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProductTurnLeft(int turn) {
        this.productTurnLeft = turn;
    }

    public int getProductTurnLeft() {
        return productTurnLeft;
    }

    public void setCitizensNumber(int amount) {
        this.citizensNumber = amount;
    }

    public int getCitizensNumber() {
        return citizensNumber;
    }

    public void setFood(int amount) {
        this.food = amount;
    }

    public int getFood() {
        return food;
    }

    public void setProduction(int amount) {
        this.production = amount;
    }

    public int getProduction() {
        return production;
    }

    public void setGold(int amount) {
        this.gold = amount;
    }

    public int getGold() {
        return gold;
    }

    public void setScience(int amount) {
        this.science = amount;
    }

    public int getScience() {
        return science;
    }

    public void setFaith(int amount) {
        this.faith = amount;
    }

    public int getFaith() {
        return faith;
    }

    public void setTourism(int amount) {
        this.tourism = amount;
    }

    public int getTourism() {
        return tourism;
    }

    public void setCulture(int amount) {
        this.culture = amount;
    }

    public int getCulture() {
        return culture;
    }

    public void addBuildings(Building building) {
        this.buildings.add(building);
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public void setWarStatus(boolean status) {
        this.warStatus = status;
    }

    public boolean getWarStatus() {
        return warStatus;
    }

    public void addCitizen(Citizen citizen) {
        this.Citizens.add(citizen);
    }

    public ArrayList<Citizen> getCitizens() {
        return Citizens;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Tile> getOwnerShipTiles() {
        return ownerShipTiles;
    }

    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }

    public boolean isWarStatus() {
        return warStatus;
    }

    public void addOwnerShipTiles(Tile tile) {
        this.ownerShipTiles.add(tile);
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void setCitizens(ArrayList<Citizen> citizens) {
        this.Citizens = citizens;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public Product getCurrentProduction() {
        return currentProduction;
    }

    public void setCurrentProduction(Product currentProduction) {
        this.currentProduction = currentProduction;
    }

    public Tile getCityLocation() {
        return cityLocation;
    }

    public void setCityLocation(Tile cityLocation) {
        this.cityLocation = cityLocation;
    }

    public ArrayList<Unit> getPossibleUnits() {
        return possibleUnits;
    }

    public void setPossibleUnits(ArrayList<Unit> possibleUnits) {
        this.possibleUnits = possibleUnits;
    }

    public void addPossibleUnit(Unit unit) {
        this.possibleUnits.add(unit);
    }

    public ArrayList<Building> getPossibleBuildings() {
        return possibleBuildings;
    }

    public void setPossibleBuildings(ArrayList<Building> possibleBuildings) {
        this.possibleBuildings = possibleBuildings;
    }

    public void addPossibleBuildings(Building building) {
        possibleBuildings.add(building);
    }

    public boolean isUnhappinessEffect() {
        return unhappinessEffect;
    }

    public void setUnhappinessEffect(boolean unhappinessEffect) {
        this.unhappinessEffect = unhappinessEffect;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public void setOwnerShipTiles(ArrayList<Tile> ownerShipTiles) {
        this.ownerShipTiles = ownerShipTiles;
    }

    public int getProductionPerTurn() {
        return productionPerTurn;
    }

    public void setProductionPerTurn(int productionPerTurn) {
        this.productionPerTurn = productionPerTurn;
    }

    public int getGoldPerTurn() {
        return goldPerTurn;
    }

    public void setGoldPerTurn(int goldPerTurn) {
        this.goldPerTurn = goldPerTurn;
    }

    public int getFoodPerTurn() {
        return foodPerTurn;
    }

    public void setFoodPerTurn(int foodPerTurn) {
        this.foodPerTurn = foodPerTurn;
    }
}
