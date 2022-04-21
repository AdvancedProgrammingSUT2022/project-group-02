package model;

public class MeleeMilitaryUnit extends MilitaryUnit{
    private boolean attackOnUnit;
    public MeleeMilitaryUnit(String name, Tile tile, int HP, int price, int level, int MP, int combatStrength, int rangeCombatStrength) {
        super(name, tile, HP, price, level, MP, combatStrength, rangeCombatStrength);
    }

    public boolean isAttackOnUnit() {
        return attackOnUnit;
    }

    public void setAttackOnUnit(boolean attackOnUnit) {
        this.attackOnUnit = attackOnUnit;
    }
}
