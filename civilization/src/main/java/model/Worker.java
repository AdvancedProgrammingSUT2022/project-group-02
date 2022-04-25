package model;

public class Worker extends Civilian{
    private boolean working;
    public Worker(String name, Tile tile, int HP, int price, int level, int MP, int combatStrength, int rangeCombatStrength, boolean working, User user) {
        super(name, tile, HP, price, level, MP, combatStrength, rangeCombatStrength, user);
        working = false;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }
}
