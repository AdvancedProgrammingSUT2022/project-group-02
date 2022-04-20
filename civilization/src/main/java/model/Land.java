package model;
import java.util.*;
public class Land {
    private String name;
    private int movementPrice;
    private int foodRate;
    private int fightRate;
    private int goldRate;
    private int productionRate;
    private ArrayList<Terrain> terrains;
    private ArrayList<Resource> resources;
    private boolean transitAble;
    private boolean nearRiver;
    public Land(String name, int foodRate, int fightRate, int goldRate, int productionRate, boolean transitAble, boolean nearRiver, int movementPrice) {
        this.name = name;
        this.foodRate = foodRate;
        this.fightRate = fightRate;
        this.goldRate = goldRate;
        this.productionRate = productionRate;
        this.transitAble = transitAble;
        this.nearRiver = nearRiver;
        this.movementPrice = movementPrice;
        terrains = new ArrayList<>();
        resources = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFoodRate() {
        return foodRate;
    }

    public void setFoodRate(int foodRate) {
        this.foodRate = foodRate;
    }

    public int getFightRate() {
        return fightRate;
    }

    public void setFightRate(int fightRate) {
        this.fightRate = fightRate;
    }

    public int getGoldRate() {
        return goldRate;
    }

    public void setGoldRate(int goldRate) {
        this.goldRate = goldRate;
    }

    public int getProductionRate() {
        return productionRate;
    }

    public void setProductionRate(int productionRate) {
        this.productionRate = productionRate;
    }

    public boolean isTransitAble() {
        return transitAble;
    }

    public boolean isNearRiver() {
        return nearRiver;
    }

    public void setTransitAble(boolean transitAble) {
        this.transitAble = transitAble;
    }

    public void setNearRiver(boolean nearRiver) {
        this.nearRiver = nearRiver;
    }

    public ArrayList<Resource> getResources() {
        return resources;
    }

    public void setResources(ArrayList<Resource> resources) {
        this.resources = resources;
    }

    public ArrayList<Terrain> getTerrains() {
        return terrains;
    }

    public void setTerrains(ArrayList<Terrain> terrains) {
        this.terrains = terrains;
    }

    public int getMovementPrice() {
        return movementPrice;
    }

    public void setMovementPrice(int movementPrice) {
        this.movementPrice = movementPrice;
    }
}
