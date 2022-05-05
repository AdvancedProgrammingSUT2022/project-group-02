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

    public int getProductionRate() {
        return productionRate;
    }

    public int getGoldRate() {
        return goldRate;
    }

    public int getFoodRate() {
        return foodRate;
    }

    public int getPrice() {
        return price;
    }

}
