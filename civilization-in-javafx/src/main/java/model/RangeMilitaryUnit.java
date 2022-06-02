package model;

public class RangeMilitaryUnit extends MilitaryUnit{
    private int attackRange;
    public RangeMilitaryUnit(String name, Tile tile, int HP, int goldPrice, int productionPrice, int level, int MP, int combatStrength, int rangeCombatStrength, User user, int attackPoint, int maintainGold) {
        super(name, tile, HP, goldPrice, productionPrice, level, MP, combatStrength, rangeCombatStrength, user, attackPoint, maintainGold);
    }

}
