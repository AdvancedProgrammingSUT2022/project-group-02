package model;

public class Improvement {

    private final String name;
    private int productionRate;
    private int foodRate;
    private int goldRate;

    public Improvement(String name, int productionRate, int foodRate, int goldRate) {
        this.name = name;
        this.productionRate = productionRate;
        this.foodRate = foodRate;
        this.goldRate = goldRate;
    }

    public String getName() {
        return name;
    }

    public void setProductionRate(int productionRate) {
        this.productionRate = productionRate;
    }

    public int getProductionRate() {
        return productionRate;
    }

    public void setGoldRate(int goldRate) {
        this.goldRate = goldRate;
    }

    public int getGoldRate() {
        return goldRate;
    }

    public void setFoodRate(int foodRate) {
        this.foodRate = foodRate;
    }

    public int getFoodRate() {
        return foodRate;
    }
}
