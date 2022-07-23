package model;

import java.util.ArrayList;

public class Building{
    private final String name;
    private int maintainCost;
    private final int cost;
    private int foodRate;
    private int defence;
    private int XP;
    private int scienceRate;
    private int happiness;
    private final ArrayList<String> requirement;
    private boolean requirementsExists;
    public Building(String name, int maintainCost, int cost, int foodRate, int defence, int XP, int scienceRate, int happiness, ArrayList<String> requirement) {
        this.name = name;
        this.maintainCost = maintainCost;
        this.cost = cost;
        this.foodRate = foodRate;
        this.defence = defence;
        this.XP = XP;
        this.scienceRate = scienceRate;
        this.happiness = happiness;
        this.requirement = requirement;
        this.requirementsExists = false;
    }

    public String getName() {
        return name;
    }

    public int getMaintainCost() {
        return maintainCost;
    }

    public void setMaintainCost(int maintainCost) {
        this.maintainCost = maintainCost;
    }

    public int getCost() {
        return cost;
    }

    public void setFoodRate(int foodRate) {
        this.foodRate = foodRate;
    }

    public int getFoodRate() {
        return foodRate;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    public int getXP() {
        return XP;
    }

    public int getDefence() {
        return defence;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getScienceRate() {
        return scienceRate;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public void setScienceRate(int scienceRate) {
        this.scienceRate = scienceRate;
    }

    public boolean isRequirementsExists() {
        return requirementsExists;
    }

    public void setRequirementsExists(boolean requirementsExists) {
        this.requirementsExists = requirementsExists;
    }

    public ArrayList<String> getRequirement() {
        return requirement;
    }
}
