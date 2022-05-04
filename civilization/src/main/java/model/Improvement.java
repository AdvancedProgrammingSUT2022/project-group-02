package model;

public record Improvement(String name, int productionRate, int foodRate, int goldRate, int price) {

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
