package model;

import java.util.ArrayList;

public class Resource {

    private String name;
    private String resourceType;
    private int goldRate;
    private int foodRate;
    private int productRate;
    private int happiness;

    public Resource(String name, String resourceType,
                    int goldRate, int foodRate, int productRate, int happiness) {
        this.name = name;
        this.resourceType = resourceType;
        this.goldRate = goldRate;
        this.foodRate = foodRate;
        this.productRate = productRate;
        this.happiness = happiness;
    }

    public String getName() {
        return name;
    }

    public String getResourceType() {
        return resourceType;
    }


    public int getGold() {
        return goldRate;
    }

    public int getFood() {
        return foodRate;
    }

    public int getProduction() {
        return productRate;
    }

    public void setFood(int food) {
        this.foodRate = food;
    }

    public void setProduction(int production) {
        this.productRate = production;
    }

}