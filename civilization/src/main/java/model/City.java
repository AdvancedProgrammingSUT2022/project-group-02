package model;

import java.util.ArrayList;
import java.util.HashMap;

public class City extends PhysicalObject {
    private final String name;
    private Tile cityLocation;
    private ArrayList<Tile> ownerShipTiles;
    private int defence;
    private Unit garrison;
    private ArrayList<Product> products;
    private int productTurnLeft;
    private int citizens;
    private int food;
    private int production;
    private int gold;
    private int science;
    private int faith;
    private int tourism;
    private int culture;
    private HashMap<Citizen, Tile> citizensLocation;
    private ArrayList<Building> buildings;
    private boolean warStatus;
    private ArrayList<Citizen> expertCitizens;
    private boolean productStatus;
    private Product currentProduction;
    private ArrayList<Unit> possibleUnits;

    public City(String name, Tile cityLocation, User ownerShip, ArrayList<Tile> ownerShipTiles, int HP, int defence,
                Unit garrison, ArrayList<Product> products, int productTurnLeft, int citizens, int food, int production,
                int gold, int science, int faith, int tourism, int culture, HashMap<Citizen, Tile> citizensLocation,
                ArrayList<Building> buildings, ArrayList<Unit> units, boolean warStatus, ArrayList<Citizen> expertCitizens,
                int attackPoint) {
        super(true, attackPoint, HP, ownerShip, cityLocation);
        this.name = name;
        this.ownerShipTiles = ownerShipTiles;
        this.defence = defence;
        this.garrison = garrison;
        this.products = products;
        this.productTurnLeft = productTurnLeft;
        this.citizens = citizens;
        this.food = food;
        this.production = production;
        this.gold = gold;
        this.science = science;
        this.faith = faith;
        this.tourism = tourism;
        this.culture = culture;
        this.citizensLocation = citizensLocation;
        this.buildings = buildings;
        this.warStatus = warStatus;
        this.expertCitizens = expertCitizens;
        this.currentProduction = null;
        this.cityLocation = cityLocation;
    }

    public void addOwnerShipLand(Tile tile) {
        this.ownerShipTiles.add(tile);
    }

    public ArrayList<Tile> getOwnerShipLands() {
        return this.ownerShipTiles;
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

    public void setCitizens(int amount) {
        this.citizens = amount;
    }

    public int getCitizens() {
        return citizens;
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

    public void addCitizensLocation(Citizen citizen, Tile tile) {
        this.citizensLocation.put(citizen, tile);
    }

    public HashMap<Citizen, Tile> getCitizensLocation() {
        return citizensLocation;
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

    public void addExpertCitizen(Citizen citizen) {
        this.expertCitizens.add(citizen);
    }

    public ArrayList<Citizen> getExpertCitizens() {
        return expertCitizens;
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

    public void setCitizensLocation(HashMap<Citizen, Tile> citizensLocation) {
        this.citizensLocation = citizensLocation;
    }

    public void setOwnerShipTiles(ArrayList<Tile> ownerShipTiles) {
        this.ownerShipTiles = ownerShipTiles;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void setExpertCitizens(ArrayList<Citizen> expertCitizens) {
        this.expertCitizens = expertCitizens;
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
}
