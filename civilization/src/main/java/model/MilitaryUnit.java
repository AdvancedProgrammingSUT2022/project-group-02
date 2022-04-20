package model;

public class MilitaryUnit extends Unit{
    private String status;
    private Unit attackedUnit;


    public MilitaryUnit(String name, Tile tile, int HP, int price, int level, int MP, int combatStrength, int rangeCombatStrength) {
        super(name, tile, HP, price, level, MP, combatStrength, rangeCombatStrength);

    }
}
