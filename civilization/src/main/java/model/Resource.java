package model;

import java.util.ArrayList;

public class Resource {

    private final String name;
    private final String resourceType;
    private final ArrayList<String> requiredLands;
    private int food;
    private int production;
    private int gold;
    private int science;


    public Resource(String name, String resourceType, ArrayList<String> requiredLands, int food, int production, int gold, int science) {
        this.name = name;
        this.resourceType = resourceType;
        this.requiredLands = requiredLands;
        this.food = food;
        this.production = production;
        this.gold = gold;
        this.science = science;
    }

    public String getName() {
        return name;
    }

    public String getResourceType() {
        return resourceType;
    }

    public ArrayList<String> getRequiredLands() {
        return requiredLands;
    }


    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    public int getFood() {
        return food;
    }

    public int getProduction() {
        return production;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getScience() {
        return science;
    }

    public void setProduction(int production) {
        this.production = production;
    }

    public void setScience(int science) {
        this.science = science;
    }
}