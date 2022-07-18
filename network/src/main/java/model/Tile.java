package model;

import java.util.ArrayList;

public class Tile {
    private Unit militaryUnit;
    private Unit civilianUnit;
    private final int x;
    private final int y;
    private final int indexY;
    private ArrayList<PhysicalObject> physicalObjects;
    private User owner;
    private Terrain terrain;
    private int fogOfWarLevel;
    private boolean militaryUnitExists;
    private boolean civilianUnitExists;
    private boolean selectedOne;
    private boolean selectedTwo;
    private boolean inProgress;
    private boolean road;
    private ArrayList<Tile> neighbors;
    private boolean isNearRiver;
    private boolean[] riverBorder;
    private Improvement improvement;
    private Feature feature;
    private Resource resource;
    private City city;
    private int price;
    private boolean looted;
    private boolean citizenExist;
    private Ruin ruin;
    private Building building;

    public Tile (int x, int y, User owner, Terrain terrain, int fogOfWarLevel, boolean isNearRiver,
                 boolean[] riverBorder, Resource resource, Feature feature) {
        this.indexY = y;
        this.x = x;
        //this.y = y + (int)(Math.ceil((double)x / 2)) - 1;
        if (x % 2 == 0)
            this.y = x * 2;

        else
            this.y = x * 2 + 1;
        this.owner = owner;
        this.terrain = terrain;
        this.fogOfWarLevel = fogOfWarLevel;
        this.militaryUnitExists = false;
        this.civilianUnitExists = false;
        this.inProgress = false;
        selectedOne = false;
        selectedTwo = false;
        this.isNearRiver = isNearRiver;
        this.riverBorder = riverBorder;
        this.feature = feature;
        this.resource = resource;
        inProgress = false;
        price = 100;
        citizenExist = false;
        this.road = false;
    }

    public boolean isNearRiver() {
        return isNearRiver;
    }

    public Feature getFeature() {
        return feature;
    }

    public Resource getResource() {
        return resource;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public boolean isSelectedOne() {
        return selectedOne;
    }

    public boolean isSelectedTwo() {
        return selectedTwo;
    }

    public void setSelectedOne(boolean selectedOne) {
        this.selectedOne = selectedOne;
    }

    public void setSelectedTwo(boolean selectedTwo) {
        this.selectedTwo = selectedTwo;
    }

    public ArrayList<PhysicalObject> getPhysicalObjects() {
        return physicalObjects;
    }

    public boolean isCivilianUnitExists() {
        return civilianUnitExists;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public boolean isMilitaryUnitExists() {
        return militaryUnitExists;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getFogOfWarLevel() {
        return fogOfWarLevel;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public User getOwner() {
        return owner;
    }

    public void setCivilianUnitExists(boolean civilianUnitExists) {
        this.civilianUnitExists = civilianUnitExists;
    }

    public void setFogOfWarLevel(int fogOfWarLevel) {
        this.fogOfWarLevel = fogOfWarLevel;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }

    public void setLand(Terrain terrain) {
        this.terrain = terrain;
    }

    public void setMilitaryUnitExists(boolean militaryUnitExists) {
        this.militaryUnitExists = militaryUnitExists;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setPhysicalObjects(ArrayList<PhysicalObject> physicalObjects) {
        this.physicalObjects = physicalObjects;
    }

    public Unit getCivilianUnit() {
        return civilianUnit;
    }

    public Unit getMilitaryUnit() {
        return militaryUnit;
    }

    public void setCivilianUnit(Unit civilianUnit) {
        this.civilianUnit = civilianUnit;
    }

    public void setMilitaryUnit(Unit militaryUnit) {
        this.militaryUnit = militaryUnit;
    }

    public ArrayList<Tile> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(ArrayList<Tile> neighbors) {
        this.neighbors = neighbors;
    }

    public Improvement getImprovement() {
        return improvement;
    }

    public void setImprovement(Improvement improvement) {
        this.improvement = improvement;
    }

    public boolean getRiverBorder(int x){
        return riverBorder[x];
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setPrice() {
        price = 0;
        price += this.getTerrain().getFoodRate() * 5;
        if (this.getFeature() != null)
            price += this.getFeature().getFoodRate() * 5;
        price += this.getTerrain().getGoldRate() * 5;
        if (this.getFeature() != null)
            price += this.getFeature().getGoldRate() * 5;
        price += this.getTerrain().getProductionRate() * 5;
        if (this.getFeature() != null)
            price += this.getFeature().getProductionRate() * 5;
        if (this.isNearRiver())
            price += 20;
    }

    public int getPrice() {
        return price;
    }
    public boolean isRoad() {
        return road;
    }

    public void setRoad(boolean road) {
        this.road = road;
    }

    public boolean[] getRiverBorder() {
        return riverBorder;
    }

    public void setLooted(boolean looted) {
        this.looted = looted;
    }

    public void setRiverBorder(boolean[] riverBorder) {
        this.riverBorder = riverBorder;
    }

    public void setNearRiver(boolean nearRiver) {
        isNearRiver = nearRiver;
    }

    public boolean isCitizenExist() {
        return citizenExist;
    }

    public void setCitizenExist(boolean citizenExist) {
        this.citizenExist = citizenExist;
    }

    public boolean isLooted() {
        return looted;
    }

    public Ruin getRuin() {
        return ruin;
    }

    public void setRuin(Ruin ruin) {
        this.ruin = ruin;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public int getIndexY() {
        return indexY;
    }
}
