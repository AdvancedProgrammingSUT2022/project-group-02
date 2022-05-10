package model;

public class Resource {

    private final String name;
    private final String resourceType;
    private Tile tile;
    private final int goldRate;
    private final int foodRate;
    private final int productionRate;
    private final int happiness;
    private final String requiredImprovement;

    public Resource(String name, String resourceType, String requiredImprovement,
                    int goldRate, int foodRate, int productionRate, int happiness) {
        this.name = name;
        this.resourceType = resourceType;
        this.goldRate = goldRate;
        this.requiredImprovement = requiredImprovement;
        this.foodRate = foodRate;
        this.productionRate = productionRate;
        this.happiness = happiness;
    }

    public String getName() {
        return name;
    }

    public String getResourceType() {
        return resourceType;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public int getGoldRate() {
        return goldRate;
    }

    public int getFoodRate() {
        return foodRate;
    }

    public int getProductionRate() {
        return productionRate;
    }

    public int getHappiness() {
        return happiness;
    }
    public String getRequiredImprovement(){
        return requiredImprovement;
    }
}