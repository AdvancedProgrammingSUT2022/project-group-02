import java.security.PrivateKey;
import java.util.ArrayList;

public class Land {

    private String name;
    private String color;
    private int movementPrice;
    private int foodRate;
    private int fightRate;
    private int goldRate;
    private int productionRate;
    private Terrain terrain;
    private boolean passable;
    private boolean nearRiver;
    private Resource resource;

    public Land(String name, String color, int movementPrice, int foodRate, int fightRate, int goldRate, int productionRate,
                boolean passable, boolean nearRiver, Resource resource) {
        this.name = name;
        this.color = color;
        this.movementPrice = movementPrice;
        this.foodRate = foodRate;
        this.fightRate = fightRate;
        this.goldRate = goldRate;
        this.productionRate = productionRate;
        this.passable = passable;
        this.nearRiver = nearRiver;
        this.resource = resource;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
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

    public Terrain getTerrain() {return terrain;}

    public void setTerrains(Terrain terrain) {this.terrain = terrain;}

    public boolean isPassable() {
        return passable;
    }

    public boolean isNearRiver() {
        return nearRiver;
    }

    public Resource getResource() {
        return resource;
    }
}
