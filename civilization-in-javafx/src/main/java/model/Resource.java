package model;

public class Resource {

    private final String name;
    private final String resourceType;
    private boolean happinessEffect;
    private int tileX;
    private int tileY;
    private final int goldRate;
    private final int foodRate;
    private final int productionRate;
    private final int happiness;
    private final String requiredImprovement;
    private boolean announce;

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

    public int getTileX() {
        return tileX;
    }

    public void setTileX(int tileX) {
        this.tileX = tileX;
    }

    public int getTileY() {
        return tileY;
    }

    public void setTileY(int tileY) {
        this.tileY = tileY;
    }

    public boolean isAnnounce() {
        return announce;
    }

    public void setAnnounce(boolean announce) {
        this.announce = announce;
    }

    public boolean isHappinessEffect() {
        return happinessEffect;
    }

    public void setHappinessEffect(boolean happinessEffect) {
        this.happinessEffect = happinessEffect;
    }
}