package model;

import java.util.ArrayList;

public class Tile {
    private ArrayList<Unit> unitsOnTheTile = new ArrayList<>();
    private final int x;
    private final int y;
    private ArrayList<PhysicalObject> physicalObjects;
    private User owner;
    private Land land;
    private int fogOfWarLevel;
    private boolean militaryUnitExists;
    private boolean civilianUnitExists;
    private String color;
    private boolean inProgress;
    public Tile (int x, int y, User owner, Land land, int fogOfWarLevel, String color) {
        this.x = x;
        this.y = y;
        this.owner = owner;
        this.land = land;
        this.fogOfWarLevel = fogOfWarLevel;
        this.color = color;
        this.militaryUnitExists = false;
        this.civilianUnitExists = false;
        this.inProgress = false;
        physicalObjects = new ArrayList<>();
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

    public String getColor() {
        return color;
    }

    public User getOwner() {
        return owner;
    }

    public void setCivilianUnitExists(boolean civilianUnitExists) {
        this.civilianUnitExists = civilianUnitExists;
    }

    public void setColor(String color) {
        this.color = color;
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

    public ArrayList<Unit> getUnitsOnTheTile() {
        return unitsOnTheTile;
    }

    public void setUnitsOnTheTile(ArrayList<Unit> unitsOnTheTile) {
        this.unitsOnTheTile = unitsOnTheTile;
    }
}
