package model;

public class Improvement {

    private String name;
    private int requiredTurns;

    public Improvement(String name, int requiredTurns) {
        this.name = name;
        this.requiredTurns = requiredTurns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRequiredTurns() {
        return requiredTurns;
    }
}
