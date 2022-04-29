package model;
import java.util.*;
public class Product {
    private int turnCost;
    private int processing;
    private final String name;
    private final ArrayList<Technology> requirements;
    public Product(String name, int turnCost, ArrayList<Technology> requirements) {
        this.name = name;
        this.turnCost = turnCost;
        processing = 0;
        this.requirements = requirements;
    }

    public String getName() {
        return name;
    }

    public int getProcessing() {
        return processing;
    }

    public int getTurnCost() {
        return turnCost;
    }

    public void setProcessing(int processing) {
        this.processing = processing;
    }

    public void setTurnCost(int turnCost) {
        this.turnCost = turnCost;
    }

    public ArrayList<Technology> getRequirements() {
        return requirements;
    }
}
