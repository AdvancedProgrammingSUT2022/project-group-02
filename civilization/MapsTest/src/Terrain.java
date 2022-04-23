public class Terrain {

    private String name;
    private int movementPrice;
    private int foodRate;
    private int fightRate;
    private int goldRate;
    private int productionRate;

    public Terrain(String name, int movementPrice, int foodRate, int fightRate, int goldRate, int productionRate) {
        this.name = name;
        this.movementPrice = movementPrice;
        this.foodRate = foodRate;
        this.fightRate = fightRate;
        this.goldRate = goldRate;
        this.productionRate = productionRate;
    }

    public String getName() {
        return name;
    }

    public int getMovementPrice() {
        return movementPrice;
    }

    public int getFoodRate() {
        return foodRate;
    }

    public int getFightRate() {
        return fightRate;
    }

    public int getGoldRate() {
        return goldRate;
    }

    public int getProductionRate() {
        return productionRate;
    }
}
