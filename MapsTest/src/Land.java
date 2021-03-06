import java.security.PrivateKey;
import java.util.ArrayList;

public class Land {

    private String name;
    private String color;
    private int movementPrice;
    private int foodRate;
    private double fightRate;
    private int goldRate;
    private int productionRate;
    private boolean[] borderRiver = new boolean[6];
    private Terrain terrain;
    private boolean passable;
    private Resource resource;


    public Land(String name, String color, int movementPrice, int foodRate, double fightRate, int goldRate, int productionRate,
                boolean passable, Resource resource, Terrain terrain) {
        this.name = name;
        this.color = color;
        this.movementPrice = movementPrice;
        this.foodRate = foodRate;
        this.fightRate = fightRate;
        this.goldRate = goldRate;
        this.productionRate = productionRate;
        this.passable = passable;
        this.resource = resource;
        this.terrain = terrain;

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

    public double getFightRate() {
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

    public Resource getResource() {
        return resource;
    }

    public boolean getBorderRiver(int X) {
        return borderRiver[X];
    }
}