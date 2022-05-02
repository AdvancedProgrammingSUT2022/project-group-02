package model;

public class Improvement {

    private final String name;
    private int productionRate;
    private int foodRate;
    private int goldRate;
    private int price;

    public Improvement(String name, int productionRate, int foodRate, int goldRate, int price) {
        this.name = name;
        this.productionRate = productionRate;
        this.foodRate = foodRate;
        this.goldRate = goldRate;
        this.price = price;
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

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
