package model;

public class Citizen extends Civilian {
    public Citizen(String name, Tile tile, int HP, int price, int level, int MP, int combatStrength, int rangeCombatStrength, User user) {
        super(name, tile, HP, price, level, MP, combatStrength, rangeCombatStrength, user);
    }
}
