package model;

import java.util.ArrayList;

public class Tile {
    private Unit militaryUnit;
    private Unit civilianUnit;
    private final int x;
    private final int y;
    private ArrayList<PhysicalObject> physicalObjects;
    private User owner;
    private Land land;
    private int fogOfWarLevel;
    private boolean militaryUnitExists;
    private boolean civilianUnitExists;
    private boolean selectedOne;
    private boolean selectedTwo;
    private boolean inProgress;
    private ArrayList<Tile> neighbors;
    private boolean isNearRiver;
    private boolean[] riverBorder;
    private Improvement improvement;
    private Terrain terrain;
    private Resource resource;
    private City city;

    public Tile (int x, int y, User owner, Land land, int fogOfWarLevel, boolean isNearRiver,
                 boolean[] riverBorder, Resource resource, Terrain terrain) {
        this.x = x;
        this.y = y;
        this.owner = owner;
        this.land = land;
        this.fogOfWarLevel = fogOfWarLevel;
        this.militaryUnitExists = false;
        this.civilianUnitExists = false;
        this.inProgress = false;
        selectedOne = false;
        selectedTwo = false;
        this.isNearRiver = isNearRiver;
        this.riverBorder = riverBorder;
        this.terrain = terrain;
        this.resource = resource;
    }

    public boolean isNearRiver() {
        return isNearRiver;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public Resource getResource() {
        return resource;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
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

    public Land getLand() {
        return land;
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

    public void setLand(Land land) {
        this.land = land;
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
}
