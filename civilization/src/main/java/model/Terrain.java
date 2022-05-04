package model;

public class Terrain {
    private String name;
    private int movementPrice;
    private int foodRate;
    private double fightRate;
    private int goldRate;
    private int productionRate;
    private String color;
    private boolean nearRiver;
    private boolean passable;

    public Terrain(String name, String color, int movementPrice, int foodRate, double fightRate, int goldRate, int productionRate,
                   boolean passable) {
        this.name = name;
        this.color = color;
        this.movementPrice = movementPrice;
        this.foodRate = foodRate;
        this.fightRate = fightRate;
        this.goldRate = goldRate;
        this.productionRate = productionRate;
        this.passable = passable;
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

    public double getFightRate() {
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

    public boolean isNearRiver() {
        return nearRiver;
    }

    public void setNearRiver(boolean nearRiver) {
        this.nearRiver = nearRiver;
    }

    public boolean isPassable(){return passable;}

    public int getMovementPrice() {
        return movementPrice;
    }

    public void setMovementPrice(int movementPrice) {
        this.movementPrice = movementPrice;
    }

    public String getColor() {
        return color;
    }
}
